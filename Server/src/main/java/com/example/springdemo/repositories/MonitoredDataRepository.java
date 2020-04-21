package com.example.springdemo.repositories;

import com.example.springdemo.entities.MonitoredData;
import com.example.springdemo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface MonitoredDataRepository extends JpaRepository<MonitoredData, Integer> {

    List<MonitoredData> findByPatient(Patient patient);

    @Query("select a from MonitoredData a where a.patient = ?1  and a.start like ?2")
    List<MonitoredData> findByPatientAndStart(Patient patient, String start);


}
