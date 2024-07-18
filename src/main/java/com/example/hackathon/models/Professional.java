package com.example.hackathon.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Professional")
public class Professional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private String speciality;
    private String workingDays;
    private String workingSlots;
    private String email;

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSpeciality() {
        return speciality;
    }
    
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
    public String getWorkingDays() {
        return workingDays;
    }
    
    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }
    
    public String getWorkingSlots() {
        return workingSlots;
    }
    
    public void setWorkingSlots(String workingSlots) {
        this.workingSlots = workingSlots;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email;}
    // Getters and Setters
}