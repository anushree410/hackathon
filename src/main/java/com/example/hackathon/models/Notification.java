package com.example.hackathon.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Notification")
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String message;
    private String role;
    private java.sql.Timestamp date;
    
    // Getters and Setters
    
    public Integer getId() {
        
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public Timestamp getDate() {
        return date;
    }
    
    public void setDate(Timestamp date) {
        this.date = date;
    }
}
