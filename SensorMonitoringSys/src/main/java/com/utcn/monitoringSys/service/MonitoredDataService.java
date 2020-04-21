package com.utcn.monitoringSys.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utcn.monitoringSys.model.MonitoredData;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class MonitoredDataService  {

    @Autowired
    private DataGetter dataGetter;

    public List<String> getAllActivities() throws IOException {
        List<MonitoredData> receivedData = dataGetter.getData ();
        return toJsonFormat (receivedData);
    }

    private List<String> toJsonFormat(List<MonitoredData> data) {
        List<String> jsonFormat = new LinkedList<> ();
        ObjectMapper jsonMapper = new ObjectMapper ();
        data.forEach (
                d -> {
                    try {
                        jsonFormat.add (jsonMapper.writeValueAsString (d));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace ();
                    }
                }
        );
        return jsonFormat;
    }
}
