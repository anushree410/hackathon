package com.example.hackathon.service;

import com.example.hackathon.dto.CarerInfo;
import com.example.hackathon.dto.PatientInfo;
import com.example.hackathon.dto.ScheduleInfo;
import com.example.hackathon.models.Carer;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.Professional;
import com.example.hackathon.models.ScheduleMapping;
import com.example.hackathon.repository.CarerRepository;
import com.example.hackathon.repository.PatientRepository;
import com.example.hackathon.repository.ProfessionalRepository;
import com.example.hackathon.repository.ScheduleMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PatientService {
    
    private final PatientRepository patientRepository;
    
    private final ScheduleMappingRepository scheduleMappingRepository;
    
    private final CarerRepository carerRepository;
    
    private final ProfessionalRepository professionalRepository;
    
    @Autowired
    public PatientService(PatientRepository patientRepository, ScheduleMappingRepository scheduleMappingRepository, CarerRepository carerRepository, ProfessionalRepository professionalRepository) {
        this.patientRepository = patientRepository;
        this.scheduleMappingRepository = scheduleMappingRepository;
        this.carerRepository = carerRepository;
        this.professionalRepository = professionalRepository;
    }
    
    public Patient getPatient(Integer patientId) {
        return patientRepository.findById(patientId).get();
    }
    
    public List<ScheduleMapping> getSchedule(Integer patientId) {
        List<ScheduleMapping> scheduleMapping1 = scheduleMappingRepository.findByPatientId(patientId);
        return scheduleMapping1;
        
    }
    
    public String addCarer(Integer patientId, CarerInfo carer) {
        Carer carer1 = new Carer();
        String carerName = carer.getName();
        Optional<Carer> carerOptional = carerRepository.findByName(carerName);
        if (!carerOptional.isEmpty()) {
            return "ERROR! Caretaker is already associated with another patient!";
        } else {
            Patient patient = patientRepository.findById(patientId).get();
            carer1.setPatient(patient);
            carer1.setName(carerName);
            carer1.setAddress(carer.getAddress());
            carer1.setAge(carer.getAge());
            carer1.setEmail(carer.getEmail());
            carer1.setImage(carer.getImage());
            carer1.setPhone(carer.getPhone());
            carer1.setGender(carer.getGender());
            carerRepository.save(carer1);
            return "Carer assigned successfully!";
        }
    }
    
    public String addSchedule(Integer patientId, ScheduleInfo schedule) {
        Patient patient = patientRepository.findById(patientId).get();
        ScheduleMapping scheduleMapping = new ScheduleMapping();
        Integer professionalId = schedule.getProfessionalId();
        Professional professional = professionalRepository.findById(professionalId).get();
        scheduleMapping.setPatient(patient);
        scheduleMapping.setProfessional(professional);
        scheduleMapping.setScheduleDate(schedule.getDate());
        scheduleMapping.setStartTime(schedule.getStartTime());
        scheduleMapping.setEndTime(schedule.getEndTime());
        scheduleMapping.setDescription(schedule.getDescription());
        scheduleMappingRepository.save(scheduleMapping);
        return "Schedule Added successfully!";
    }
    
    public List<Carer> getCarers(Integer patientId) {
        return carerRepository.findByPatientId(patientId).get();
    }

    @Transactional
    public Patient createPatient(PatientInfo PatientDto) {
        Patient newPatient = new Patient();
        newPatient.setName(PatientDto.getName());
        newPatient.setEmail(PatientDto.getEmail());
        newPatient.setPhone(PatientDto.getPhone());
        newPatient.setAddress(PatientDto.getAddress());
        newPatient.setImage(PatientDto.getImage());
        newPatient.setAge(PatientDto.getAge());
        newPatient.setGender(PatientDto.getGender());
        return patientRepository.save(newPatient);
    }

    public Patient getPatientByEmail(String email) {
        Optional<Patient> optionalPatient = patientRepository.findByEmail(email);
        // Returns the Patient object if present
        //            throw new NoSuchElementException("No Patient found with email: " + email);
        return optionalPatient.orElse(null);
    }


}
