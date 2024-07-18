package com.example.hackathon.service;

import com.example.hackathon.dto.SignupInfo;
import com.example.hackathon.mapper.SignupInfoMapper;
import com.example.hackathon.models.Carer;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.Professional;
import com.example.hackathon.repository.CarerRepository;
import com.example.hackathon.repository.PatientRepository;
import com.example.hackathon.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SignupService {

    @Autowired
    private ProfessionalRepository professionalRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private CarerRepository carerRepository;
    private final SignupInfoMapper signupInfoMapper=SignupInfoMapper.INSTANCE;

    public Integer signupUser(SignupInfo signupInfo) {
        if (Objects.nonNull(signupInfo)) {
            switch (signupInfo.getRole()) {
                case "Patient":
                    Patient patient = signupInfoMapper.fromSignupInfoToPatient(signupInfo);
                    patientRepository.save(patient);
                    return patientRepository.findByEmail(patient.getEmail()).getId();
                case "Carer":
                    Carer carer = signupInfoMapper.fromSignupInfoToCarer(signupInfo);
                    carerRepository.save(carer);
                    return carerRepository.findByEmail(carer.getEmail()).getId();
                case "Professional":
                    Professional professional = signupInfoMapper.fromSignupInfoToProfessional(signupInfo);
                    professionalRepository.save(professional);
                    return professionalRepository.findByEmail(professional.getEmail()).getId();
                default:
                    System.out.println("Provide appropriate role");
                    break;
            }
        }

        return 0;
    }
}
