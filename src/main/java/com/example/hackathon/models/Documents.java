package com.example.hackathon.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Documents")
public class Documents {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docId;
    
    @Lob
    private byte[] document;
    
    // Getters and Setters
    
    public Integer getDocId() {
        return docId;
    }
    
    public void setDocId(Integer docId) {
        this.docId = docId;
    }
    
    public byte[] getDocument() {
        return document;
    }
    
    public void setDocument(byte[] document) {
        this.document = document;
    }
}