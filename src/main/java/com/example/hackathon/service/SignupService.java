package com.example.hackathon.service;

import com.example.hackathon.dto.LoginInfo;
import com.example.hackathon.dto.SignupInfo;
import com.example.hackathon.dto.SignupResponse;
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

    public SignupResponse signupUser(SignupInfo signupInfo) {
        SignupResponse signupResponse = new SignupResponse();
        if (Objects.nonNull(signupInfo)) {
            switch (signupInfo.getRole()) {
                case "Patient":
                    Patient patient = signupInfoMapper.fromSignupInfoToPatient(signupInfo);
                    patientRepository.save(patient);
                    Patient patient1 = patientRepository.findByEmail(patient.getEmail());
                    signupResponse.setId(patient1.getId());
                    return signupResponse;
                case "Carer":
                    Carer carer = signupInfoMapper.fromSignupInfoToCarer(signupInfo);
                    carerRepository.save(carer);
                    signupResponse.setId(carerRepository.findByEmail(carer.getEmail()).getId());
                    return signupResponse;
                case "Professional":
                    Professional professional = signupInfoMapper.fromSignupInfoToProfessional(signupInfo);
                    professionalRepository.save(professional);
                    signupResponse.setId(professionalRepository.findByEmail(professional.getEmail()).getId());
                    return signupResponse;
                default:
                    System.out.println("Provide appropriate role");
                    break;
            }
        }

        return signupResponse;
    }
    public SignupResponse loginUser(LoginInfo loginInfo) {
        SignupResponse signupResponse = new SignupResponse();
        if (Objects.nonNull(loginInfo)) {
            switch (loginInfo.getRole()) {
                case "Patient":
                    Patient patient = patientRepository.findByEmail(loginInfo.getEmail());
                    signupResponse.setId(patient.getId());
                    return signupResponse;
                case "Carer":
                    Carer carer = carerRepository.findByEmail(loginInfo.getEmail());
                    signupResponse.setId(carer.getId());
                    return signupResponse;
                case "Professional":
                    Professional professional = professionalRepository.findByEmail(loginInfo.getEmail());
                    signupResponse.setId(professional.getId());
                    return signupResponse;
                default:
                    System.out.println("Provide appropriate role");
                    break;
            }
        }
        return signupResponse;
    }
}
