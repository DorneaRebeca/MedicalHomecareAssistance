package com.example.springdemo.services;

import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PillDTO;
import com.example.springdemo.dto.builders.PillBuilder;
import com.example.springdemo.entities.Patient;
import com.yrrhelp.gdpr.MedicationPlan;
import com.yrrhelp.gdpr.medicationPlanGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicationDispenserService extends medicationPlanGrpc.medicationPlanImplBase {

    @Autowired
    private PatientService patientService;


    @Override
    public void getPlan(MedicationPlan.PlanRequest request, StreamObserver<MedicationPlan.PlanResponse> responseObserver) {

        int id = Integer.parseInt(request.getId());

        List<MedicationPlanDTO> medPlans = patientService.getMedicationPlans(id);
        MedicationPlan.PlanResponse.Builder planResponse = MedicationPlan.PlanResponse.newBuilder();
        MedicationPlanDTO currentPlan = null;
        if(medPlans.size() > 0) {
            for (MedicationPlanDTO m : medPlans
                 ) {
                if(LocalDate.parse(m.getStartDate()).isBefore(LocalDate.now()) && LocalDate.parse(m.getEndDate()).isAfter(LocalDate.now())) {
                    currentPlan = m;
                    break;
                }
            }
        }
        if(currentPlan != null) {
            planResponse.setStartDate(currentPlan.getStartDate().toString())
                    .setEndDate(currentPlan.getStartDate().toString());
            MedicationPlan.Pill.Builder pillBuilder = MedicationPlan.Pill.newBuilder();
            for (PillDTO pill: currentPlan.getPills()
            ) {
                pillBuilder.setIntakeInterval(pill.getIntakeInterval());
                pillBuilder.setDosage(String.valueOf(pill.getMedication().getDosage()));
                pillBuilder.setName(pill.getMedication().getName());
                pillBuilder.setSideEffects(pill.getMedication().getSideEffects());
                planResponse.addPills(pillBuilder.build());
            }
        }
        responseObserver.onNext(planResponse.build());
        responseObserver.onCompleted();
    }

    @Override
    public void pillTaken(MedicationPlan.MessageRequest request, StreamObserver<MedicationPlan.MessageResponse> responseObserver) {
        System.out.println(request.getMessage());
        MedicationPlan.MessageResponse.Builder response = MedicationPlan.MessageResponse.newBuilder()
                .setMessage("You took the medicine in time. Good job!");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void pillNotTaken(MedicationPlan.MessageRequest request, StreamObserver<MedicationPlan.MessageResponse> responseObserver) {
        MedicationPlan.Pill pill = request.getPill();
        System.out.println(request.getMessage());
        MedicationPlan.MessageResponse.Builder response = MedicationPlan.MessageResponse.newBuilder()
                .setMessage("WARNING : The intake interval for "+pill.getName()
                        +" medication has passed. Please take it quickly");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }
}
