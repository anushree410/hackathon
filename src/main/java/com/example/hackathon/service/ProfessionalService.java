package com.example.hackathon.service;

import com.example.hackathon.dto.MedicineInfo;
import com.example.hackathon.models.Medicines;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.Professional;
import com.example.hackathon.models.ScheduleMapping;
import com.example.hackathon.repository.MedicinesRepository;
import com.example.hackathon.repository.PatientRepository;
import com.example.hackathon.repository.ProfessionalRepository;
import com.example.hackathon.repository.ScheduleMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalService {

    private ProfessionalRepository professionalRepository;
     private ScheduleMappingRepository scheduleMappingRepository;

     private MedicinesRepository medicinesRepository;

     private PatientRepository patientRepository;

    @Autowired
    public ProfessionalService(ProfessionalRepository professionalRepository, ScheduleMappingRepository scheduleMappingRepository,MedicinesRepository medicinesRepository,PatientRepository patientRepository) {
        this.professionalRepository = professionalRepository;
        this.scheduleMappingRepository = scheduleMappingRepository;
        this.medicinesRepository = medicinesRepository;
        this.patientRepository = patientRepository;

    }


    public Professional getProf(Integer profId){
        Professional professional = professionalRepository.findById(profId).get();
        return professional;
    }

    public List<ScheduleMapping> getScheduleforProf(Integer profId) {
        List<ScheduleMapping> scheduleMapping1 = scheduleMappingRepository.findByProfId(profId);
        return scheduleMapping1;

    }

    public String addMedicine(String patientName, MedicineInfo medicineInfo){
        Medicines medicine =  new Medicines();
        medicine.setEndDate(medicineInfo.getEndDate());
        medicine.setMedName(medicineInfo.getMedName());
        medicine.setStartDate(medicineInfo.getStartDate());
        medicine.setFrequency(medicineInfo.getFrequency());
        Patient patient = patientRepository.findByName(patientName);
        medicine.setPatient(patient);
        medicinesRepository.save(medicine);

        return "Medicines added successfully!";
    }

    public Professional getProfessionalByEmail(String email) {
        Professional professional = professionalRepository.findByEmail(email);
        // Returns the Patient object if present
        //            throw new NoSuchElementException("No Patient found with email: " + email);
        return professional;
    }
}
