package com.example.springdemo.repositories;

import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository  extends JpaRepository<Recommendation, Integer> {
    List<Recommendation> findByCaregiver(Caregiver caregiver);


}
