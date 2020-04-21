package com.utcn.monitoringSys.service;

import com.utcn.monitoringSys.model.MonitoredData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DataGetter {

    public List<MonitoredData> getData() throws IOException {
        List<MonitoredData> foundData = new LinkedList<> ();
        Stream<String> dataF = Files.lines (Paths.get ("activities.txt"));
        Random ranomizer = new Random ();
        dataF.forEach (p -> {
            StringTokenizer str = new StringTokenizer (p, "\t");

            DateTimeFormatter format = DateTimeFormatter.ofPattern ("yyyy-MM-dd HH:mm:ss");
            String startTime = str.nextToken ();

            String endTime = str.nextToken ();
            int id = 0;
            do {
                id = ranomizer.nextInt (20);
            }while (id == 0);

            foundData.add (new MonitoredData (str.nextToken (), startTime, endTime, id));
        });

        return foundData;
    }
}
