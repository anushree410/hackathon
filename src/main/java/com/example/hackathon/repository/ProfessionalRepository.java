package com.example.hackathon.repository;

import com.example.hackathon.models.Patient;
import com.example.hackathon.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

    default Optional<Professional> findByEmail(String email) {
        return findAll().stream()
                .filter(professional -> professional.getEmail().equals(email))
                .findFirst();
    }
}
