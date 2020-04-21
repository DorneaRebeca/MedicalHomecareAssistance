package com.example.springdemo.services;


import com.example.springdemo.entities.MonitoredData;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.repositories.MonitoredDataRepository;
import com.example.springdemo.repositories.PatientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class MonitoredDataService {

    @Autowired
    private MonitoredDataRepository monitoredDataRepository;

    @Autowired
    private PatientRepository patientRepository;

    private MonitoredData data;


    public JSONObject processActivity(String message) {
        data = toMonitoredData (message);
        String notif =  verifyRules (data);

         monitoredDataRepository.save (data);

        JSONObject json = new JSONObject ();
        json.appendField ("message", notif);
        json.appendField ("caregiverID", data.getPatient ().getCaregiver ().getId ());
        return json;
    }

    private MonitoredData toMonitoredData(String message) {
        StringTokenizer str = new StringTokenizer (message, "{\"\\},");

        MonitoredData md =  new MonitoredData ();
        str.nextToken ();
        str.nextToken ();
        md.setActivity (str.nextToken ());
        str.nextToken ();
        str.nextToken ();
        md.setStart (str.nextToken ());
        str.nextToken ();
        str.nextToken ();
        md.setEnd (str.nextToken ());
        str.nextToken ();
        int id = Integer.parseInt (str.nextToken ().replace (":",""));
        Patient patient = patientRepository.findById (id).get ();
        md.setPatient (patient);
        md.setAnomaly(false);
        return md;
    }

    private String verifyRules(MonitoredData receivedData) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern ("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endTime = LocalDateTime.parse (receivedData.getEnd (), format);
        LocalDateTime startTime = LocalDateTime.parse (receivedData.getStart (), format);

        if (receivedData.getActivity ().equals ("Sleeping")) {
            if (HOURS.between (startTime, endTime) > 1.00) {
                data.setAnomaly(true);
                return "Patient : " + receivedData.getPatient().getName ()  + " has slept too much lately(more than 12 hours)";
            }
        }

        if(receivedData.getActivity ().equals ("Leaving")) {
            if(HOURS.between (startTime, endTime) > 1.00) {
                data.setAnomaly(true);
                return "Patient : " + receivedData.getPatient() .getName ()  + " spends too much time outside(more than 12 hours)";

            }
        }

        if(receivedData.getActivity ().equals ("Toileting")) {
            if(MINUTES.between (startTime, endTime) > 0) {
                data.setAnomaly(true);
                return "Patient : " + receivedData.getPatient ().getName ()  + " spends too much time in bathroom(more than 12 hours)";
            }
        }
        return null;
    }


}
