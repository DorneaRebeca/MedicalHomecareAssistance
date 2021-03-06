package com.example.springdemo.repositories;

import com.example.springdemo.entities.Pill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PillRepository extends JpaRepository<Pill, Integer> {
}
