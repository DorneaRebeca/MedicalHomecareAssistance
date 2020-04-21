package com.example.springdemo.repositories;

import com.example.springdemo.entities.MonitoredPill;
import com.example.springdemo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface MonitoredPillRepository extends JpaRepository<MonitoredPill, Integer> {

    List<MonitoredPill> findByPatient(Patient patient);


    List<MonitoredPill> findByPatientAndTakenDate(Patient patient, Date date);
}
