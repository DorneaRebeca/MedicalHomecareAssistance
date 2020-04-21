package sample;

import com.yrrhelp.gdpr.MedicationPlan;
import com.yrrhelp.gdpr.medicationPlanGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Popup;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Controller {
    @FXML
    public Text clock;

    @FXML
    public TableView pillTable;
    public TableColumn namePillColumn = new TableColumn("Name");
    public TableColumn sideEffectsColumn = new TableColumn("Side Effects");
    public TableColumn intakeIntervalColumn = new TableColumn("Intake interval");
    public TableColumn dosageColumn = new TableColumn("Dosage");

    @FXML
    public Button taken;

    @FXML
    public Text errorText;
    @FXML
    public Text successMessage;

    @FXML
    public Text notifText;

    private MedicationPlan.Pill pillClicked;
    private ManagedChannel channel;
    private Alert alert;
    private String alertMessage = null;
    private MedicationPlan.PlanResponse plan;


    public void initialize() {
        channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setContentText("The intake interval for this medication has passed. Please take it quickly");

        namePillColumn.setCellValueFactory(new PropertyValueFactory<MedicationPlan.Pill, String>("name"));
        sideEffectsColumn.setCellValueFactory(new PropertyValueFactory<MedicationPlan.Pill, Integer>("sideEffects"));
        intakeIntervalColumn.setCellValueFactory(new PropertyValueFactory<MedicationPlan.Pill, String>("intakeInterval"));
        dosageColumn.setCellValueFactory(new PropertyValueFactory<MedicationPlan.Pill, Integer>("dosage"));

        pillTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        pillTable.getColumns().addAll(namePillColumn, intakeIntervalColumn, sideEffectsColumn, dosageColumn);

         plan = downloadMedicationPlan();
        setPillPlan(plan);
        verifyPills();
        clockTicking();
    }


    @FXML
    public void getPill(Event event) {
        pillClicked = (MedicationPlan.Pill) pillTable.getSelectionModel().getSelectedItem();
        //System.out.println(pillClicked);
    }

    @FXML
    public boolean takePill(Event event) {
        ObservableList<MedicationPlan.Pill> pills = pillTable.getItems();
        if (pills.size() == 0) {
            errorText.setText("No more pills for you :)");
            return false;

        }
        if(!verifyTakenPill()) {
            return false;
        }

        pills.remove(pillClicked);
        pillTaken();
        pillClicked = null;
        pillTable.setItems(pills);

        return true;
    }

    private void clockTicking() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        clock.setText(LocalDateTime.now().toLocalTime().toString());
                        sleep(1000);
                        if ( LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(1, 30,0))
                        && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(1, 30,1))) {
                            MedicationPlan.PlanResponse plan = downloadMedicationPlan();
                            setPillPlan(plan);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }


    public void verifyPills() {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                List<MedicationPlan.Pill> pills = pillTable.getItems();
                pills.forEach(p ->
                {
                    StringTokenizer str = new StringTokenizer(p.getIntakeInterval(), "-");
                    int endH = Integer.parseInt(str.nextToken());
                    if (LocalDateTime.now().getHour() > endH) {
                        System.out.println("found a wrong one : " + p.getName());
                        pillNotTaken(p);
                    }
                });
                setPillPlan(plan);
            }
        }, 0, 1, TimeUnit.MINUTES);
    }


    private MedicationPlan.PlanResponse downloadMedicationPlan() {

        medicationPlanGrpc.medicationPlanBlockingStub planStub = medicationPlanGrpc.newBlockingStub(channel);

        MedicationPlan.PlanRequest planRequest = MedicationPlan.PlanRequest.newBuilder()
                .setId("5").build();
        MedicationPlan.PlanResponse plan = planStub.getPlan(planRequest);
        plan.getPillsList().forEach(System.out::println);
        return plan;
    }

    private void pillTaken() {
        if (pillClicked != null) {
            medicationPlanGrpc.medicationPlanBlockingStub planStub = medicationPlanGrpc.newBlockingStub(channel);
            MedicationPlan.MessageRequest messageRequest = MedicationPlan.MessageRequest.newBuilder()
                    .setMessage("Pill taken")
                    .setPill(pillClicked).build();
            MedicationPlan.MessageResponse response = planStub.pillTaken(messageRequest);
            successMessage.setText(response.getMessage());
            notifText.setText("");
        }
    }

    private void pillNotTaken(MedicationPlan.Pill pill) {
        medicationPlanGrpc.medicationPlanBlockingStub planStub = medicationPlanGrpc.newBlockingStub(channel);
        MedicationPlan.MessageRequest messageRequest = MedicationPlan.MessageRequest.newBuilder()
                .setMessage("Patient no 5 didn't take the pill on time")
                .setPill(pill).build();
        MedicationPlan.MessageResponse response = planStub.pillNotTaken(messageRequest);
        notifText.setText(response.getMessage());
        alertMessage = response.getMessage();
    }

    private void setPillPlan(MedicationPlan.PlanResponse plan) {

        ObservableList<MedicationPlan.Pill> dockObservableList = FXCollections.observableArrayList();
        dockObservableList.addAll(
                //getCurrentPills(plan.getPillsList())
                plan.getPillsList()
        );
        pillTable.setItems(dockObservableList);
    }

    private boolean verifyTakenPill() {
        if (pillClicked == null) {
            errorText.setText("You must choose a pill in order to be checked as taken :)");
            return false;
        }

        StringTokenizer str = new StringTokenizer(pillClicked.getIntakeInterval(), "-");
        int startH = Integer.parseInt(str.nextToken());
        if(LocalDateTime.now().getHour() < startH) {
            errorText.setText("The pill cannot be taken until established intake interval!");
            return false;
        }
        return true;
    }

    private List<MedicationPlan.Pill> getCurrentPills(List<MedicationPlan.Pill> pills) {
        List<MedicationPlan.Pill> rez = new LinkedList<>();
        for(MedicationPlan.Pill p : pills) {
            StringTokenizer str = new StringTokenizer(p.getIntakeInterval(), "-");
            int startH = Integer.parseInt(str.nextToken());
            int endH = Integer.parseInt(str.nextToken());

            if(LocalDateTime.now().getHour() > startH && LocalDateTime.now().getHour() < endH) {
                rez.add(p);
            }
        }
        return rez;

    }

}
