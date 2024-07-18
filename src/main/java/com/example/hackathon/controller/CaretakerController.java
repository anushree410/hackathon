package com.example.hackathon.controller;

import com.example.hackathon.models.Carer;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.ScheduleMapping;
import com.example.hackathon.service.CaretakerService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/caretaker")
public class CaretakerController {
    
    private final CaretakerService careTakerService;
    
    @Autowired
    public CaretakerController(CaretakerService careTakerService) {
        this.careTakerService = careTakerService;
    }
    
    @GetMapping("/getCareTaker/{careTakerId}")
    public Carer getCarerInformation(@PathVariable @NotNull Integer careTakerId) {
        return careTakerService.getInformation(careTakerId);
    }
    
    @PostMapping("/addPatient/{careTakerId}/{patientId}")
    public String addPatient(@PathVariable @NotNull Integer careTakerId, @PathVariable @NotNull Integer patientId) {
        return careTakerService.addPatient(careTakerId, patientId);
    }
    
    @GetMapping("/getScheduler/{carerId}")
    public List<ScheduleMapping> getPatientSchedule(@PathVariable @NotNull Integer carerId) {
        return careTakerService.getSchedule(carerId);
    }
//    @GetMapping("/getNotifications/{careTakerId}")
//    public Notification getNotifications(@PathVariable @NotNull Integer carerId) {
//        return careTakerService.getNotifications(carerId);
//    }
    @PostMapping("/getCarerIdByEmail")
    public ResponseEntity<Integer> getPatientIdByEmail(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        Carer carer = careTakerService.getCaretakerByEmail(email);
        if (carer == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // or HttpStatus.BAD_REQUEST if email does not exist
        }
        return new ResponseEntity<>(carer.getId(), HttpStatus.OK);
    }
    
}
