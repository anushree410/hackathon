package com.example.hackathon.mapper;

import com.example.hackathon.dto.SignupInfo;
import com.example.hackathon.models.Carer;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.Professional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SignupInfoMapper {
    SignupInfoMapper INSTANCE = Mappers.getMapper(SignupInfoMapper.class);


    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "gender", source = "gender")

    })
    Patient fromSignupInfoToPatient(SignupInfo signupInfo);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "gender", source = "gender")

    })
    Carer fromSignupInfoToCarer(SignupInfo signupInfo);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "speciality", source = "speciality"),
            @Mapping(target = "workingDays", source = "workingDays"),
            @Mapping(target = "workingSlots", source = "workingSlots")
    })
    Professional fromSignupInfoToProfessional(SignupInfo signupInfo);
}
