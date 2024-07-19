package com.example.hackathon.repository;

import com.example.hackathon.models.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicinesRepository extends JpaRepository<Medicines, Integer> {
    @Query("SELECT s FROM Medicines s WHERE s.patient.id = :patientId")
    List<Medicines> findByPatientId(@Param("patientId") Long patientId);
}
