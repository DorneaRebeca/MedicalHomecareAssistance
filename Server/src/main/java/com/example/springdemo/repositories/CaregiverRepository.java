package com.example.springdemo.repositories;

import com.example.springdemo.entities.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {
    Caregiver findByEmail(String email);
    Optional<Caregiver> findById(Integer id);
}
