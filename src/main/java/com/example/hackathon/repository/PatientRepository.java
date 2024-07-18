package com.example.hackathon.repository;

import com.example.hackathon.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository  extends JpaRepository<Patient, Integer> {


    Patient findByName(String patientName);

    Patient findByEmail(String email);
}
