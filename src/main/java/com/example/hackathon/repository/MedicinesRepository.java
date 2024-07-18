package com.example.hackathon.repository;

import com.example.hackathon.models.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicinesRepository extends JpaRepository<Medicines, Integer> {
}
