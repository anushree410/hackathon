package com.example.hackathon.service;

import com.example.hackathon.models.Carer;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.ScheduleMapping;
import com.example.hackathon.repository.CarerRepository;
import com.example.hackathon.repository.ScheduleMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.constant.ConstantDescs.NULL;

@Service
public class CaretakerService {
    
    
    private final CarerRepository carerRepository;
    
    private final ScheduleMappingRepository scheduleMappingRepository;
    
    @Autowired
    public CaretakerService(CarerRepository carerRepository, ScheduleMappingRepository scheduleMappingRepository) {
        this.carerRepository = carerRepository;
        this.scheduleMappingRepository = scheduleMappingRepository;
    }
    
    public Carer getInformation(Integer id){
        return carerRepository.findById(id).get();
    }
    
    
    public List<ScheduleMapping> getSchedule(Integer carerId){
        Integer patientId = carerRepository.findPatientIdByCarerId(carerId);
        List<ScheduleMapping> scheduleMapping1 = scheduleMappingRepository.findByPatientId(patientId);
        return scheduleMapping1;
        
    }
    
    public String addPatient(Integer carerId, Integer patientId){
        Carer carer = carerRepository.findById(carerId).get();
        Patient patient = carer.getPatient();
        if(patient != NULL){
            return "Error ! Patient already exists";
        }
        else{
            carerRepository.updatePatientId(patientId,carerId);
        }
        return "Patient added successfully!";
    }

    public Carer getCaretakerByEmail(String email) {
        Optional<Carer> optionalCarer = carerRepository.findByEmail(email);
        // Returns the Patient object if present
        //            throw new NoSuchElementException("No Patient found with email: " + email);
        return optionalCarer.orElse(null);
    }
    
}