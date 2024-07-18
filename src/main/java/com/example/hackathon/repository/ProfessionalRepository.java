package com.example.hackathon.repository;

import com.example.hackathon.models.Patient;
import com.example.hackathon.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

    Professional findByEmail(String email);
}
