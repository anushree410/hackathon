package com.example.hackathon.repository;

import com.example.hackathon.models.ScheduleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleMappingRepository  extends JpaRepository<ScheduleMapping, Integer> {
    
    
    @Query("SELECT s FROM ScheduleMapping s WHERE s.patient.id = :patientId")
    List<ScheduleMapping> findByPatientId(@Param("patientId") Integer patientId);

    @Query("SELECT s FROM ScheduleMapping s WHERE s.professional.id = :profId")
    List<ScheduleMapping> findByProfId(@Param("profId") Integer profId);
}
