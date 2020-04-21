package com.utcn.soapApi.services;

import com.utcn.soapApi.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Service
public class DoctorService {

    private DoctorSoapService doctorSoapService;

    @Autowired
    public DoctorService() throws MalformedURLException {
        URL wsdlURL = new URL("http://app-server:8888/ws/doctor?wsdl");

        //creating QName using targetNamespace and name
        QName qname = new QName("http://services.soapService.springdemo.example.com/", "DoctorServiceImplService");

        Service service = Service.create(wsdlURL, qname);

        //We need to pass interface and model beans to client
       QName port_name = new QName("http://services.soapService.springdemo.example.com/","DoctorSoapServicePort");
        doctorSoapService = service.getPort(port_name, DoctorSoapService.class);
    }

    public PatientDTO findPatientDetails(int id) {
        return doctorSoapService.getPatientDetails(id);
    }

    public List<MonitoredDataDTO> getActivities(int id)
    {
        ActivitiesListDTO activ =  doctorSoapService.getPatientActivities(id);
        System.out.println("************** Activities : " + activ.getActivities().size());
        activ.getActivities().forEach(System.out::println);
        return activ.getActivities();
    }

    public List<MonitoredPillDTO> getMonitoredPills(int id, String date)
    {
        MonitoredPillsList activ =  doctorSoapService.getNotTakenPills(id, date);
        return activ.getMonitoredPillDTOList();
    }

    public List<ActivityStatus> getActivityOnDate(int id, String date) {
        ActivitiesListDTO act =  doctorSoapService.getActivityOnDate(id, date);
        List<ActivityStatus> status = new LinkedList<>();
        act.getActivities().forEach(
                a ->
                {
                    long time = Long.parseLong(a.getEnd()) - Long.parseLong(a.getStart()) / 864000;

                    status.add(new ActivityStatus(a.getActivity(), time));
                }
        );
        return  status;

    }

    public String newRecomd(RecommendationDTO recommendationDTO) {
        return doctorSoapService.newRecommendation(recommendationDTO);
    }

    public List<RecommendationDTO> getRecommendations(int caregiverID) {
        return doctorSoapService.getRecommendations(caregiverID).getRecommendationDTOList();
    }


}
