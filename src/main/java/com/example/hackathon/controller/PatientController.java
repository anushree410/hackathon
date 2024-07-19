package com.example.hackathon.controller;

import com.example.hackathon.dto.CarerInfo;
import com.example.hackathon.dto.PatientInfo;
import com.example.hackathon.dto.ScheduleInfo;
import com.example.hackathon.models.Carer;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.ScheduleMapping;
import com.example.hackathon.service.PatientService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/patient")
public class PatientController {
    
    private final PatientService patientService;
    
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    
    @GetMapping("/getUser/{patientId}")
    public Patient getPatient(@PathVariable @NotNull Integer patientId) {
        return patientService.getPatient(patientId);
    }
    
    @GetMapping("/getSchedule/{patientId}")
    public List<ScheduleMapping> getSchedule(@PathVariable @NotNull Integer patientId) {
        return patientService.getSchedule(patientId);
    }

    @PostMapping("/addCarer/{patientId}")
    public String addCarer(@PathVariable @NotNull Integer patientId, @RequestBody CarerInfo carer){
        return patientService.addCarer(patientId,carer);
    }
    
    @PostMapping("/addSchedule/{patientId}")
    public String addSchedule(@PathVariable @NotNull Integer patientId, @RequestBody ScheduleInfo schedule){
        return patientService.addSchedule(patientId,schedule);
    }
    
    @GetMapping("/getCareTakers/{patientId}")
    public List<Carer> getCarers(@PathVariable @NotNull Integer patientId)
    {
        return patientService.getCarers(patientId);
    }

    @PostMapping("/create")
    public ResponseEntity<Patient> createPatient(@RequestBody PatientInfo PatientDto) {
        Patient newPatient = patientService.createPatient(PatientDto);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PostMapping("/getPatientIdByEmail")
    public ResponseEntity<Integer> getPatientIdByEmail(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        Patient patient = patientService.getPatientByEmail(email);
        if (patient == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // or HttpStatus.BAD_REQUEST if email does not exist
        }
        return new ResponseEntity<>(patient.getId(), HttpStatus.OK);
    }
    @GetMapping("/{id}/getDetails")
    public String getUserDetails(@PathVariable("id") Integer id) {
        Patient patient = patientService.getPatient(id);
        if (patient == null) {
            return "Patient not found";
        }

        StringBuilder message = new StringBuilder("I am ");
        message.append(patient.getName()).append(" and my caretakers are:\n");

        List<Carer> caretakers = patientService.getCarers(id);
        for (int i = 0; i < caretakers.size(); i++) {
            Carer caretaker = caretakers.get(i);
            message.append(i + 1).append(") ").append(caretaker.getName()).append(": ").append(caretaker.getPhone());
            if (i < caretakers.size() - 1) {
                message.append("\n");
            }
        }

        return message.toString();
    }

}
