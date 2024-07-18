package com.example.hackathon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientInfo {
    private String name;
    private String email;
    private String phone;
    private String address;
    private byte[] image;
    private Integer age;
    private String gender;
}
