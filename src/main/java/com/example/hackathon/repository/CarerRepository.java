package com.example.hackathon.repository;

import com.example.hackathon.models.Carer;
import com.example.hackathon.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarerRepository extends JpaRepository<Carer, Integer> {
    
    //    @Query()
//    void addPatient(Integer carerId, Patient patient);
    @Query("SELECT c.patient.id FROM Carer c WHERE c.id = :carerId")
    Integer findPatientIdByCarerId(@Param("carerId") Integer carerId);
    
    @Query("UPDATE Carer SET patient.id = :patientId where id = :carerId ")
    Integer updatePatientId(@Param("patientId") Integer patientId, @Param("carerId") Integer carerId);
    
    Optional<Carer> findByName(String name);

    Carer findByEmail(String email);
    
    Optional<List<Carer>> findByPatientId(Integer patientId);
}
