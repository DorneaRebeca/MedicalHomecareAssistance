package com.example.springdemo.soapService.services;
import com.example.springdemo.dto.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface DoctorSoapService {

    @WebMethod
    public DoctorDTO getDoctor(int id);

    @WebMethod
    public DoctorDTO login(String email, String password);

    @WebMethod
    ArrayList<PatientDTO> getAllPatients();

    @WebMethod(action = "getDetails")
    PatientDTO getPatientDetails(int id);

    @WebMethod(action = "getActivities")
    ActivitiesListDTO getPatientActivities(int id);

    @WebMethod(action = "getPills")
    MonitoredPillsList getNotTakenPills(int patientID, String date);

    @WebMethod(action = "getActivityStatus")
    ActivitiesListDTO getActivityOnDate(int patientID, String date);

    @WebMethod(action = "newRecommendation")
    String newRecommendation(RecommendationDTO recommendationDTO);

    @WebMethod(action = "getRecommendation")
    RecommendationListDTO getRecommendations(int caregiverID);

}
