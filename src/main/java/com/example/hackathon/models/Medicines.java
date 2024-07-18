package com.example.hackathon.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Medicines")
public class Medicines {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medId;
    
    private String medName;
    private String frequency;
    private Date startDate;
    private Date endDate;


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @JoinColumn(name = "patientId")
    @ManyToOne
    private Patient patient;
    
    public Integer getMedId() {
        return medId;
    }
    
    public void setMedId(Integer medId) {
        this.medId = medId;
    }
    
    public String getMedName() {
        return medName;
    }
    
    public void setMedName(String medName) {
        this.medName = medName;
    }
    
    public String getFrequency() {
        return frequency;
    }
    
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}