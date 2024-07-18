package com.example.hackathon.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ScheduleInfo {

    private Date date;
    private Integer professionalId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String description;
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Integer getProfessionalId() {
        return professionalId;
    }
    
    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }
    
    public Timestamp getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
    
    public Timestamp getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
