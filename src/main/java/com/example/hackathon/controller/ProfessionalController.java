package com.example.hackathon.controller;

import com.example.hackathon.dto.MedicineInfo;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.Professional;
import com.example.hackathon.models.ScheduleMapping;
import com.example.hackathon.service.ProfessionalService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/prof")
public class ProfessionalController {

    private final ProfessionalService professionalService;

    @Autowired
    public ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @GetMapping("/getProf/{profId}")
    public Professional getProfessional(@PathVariable @NotNull Integer profId) {
        return professionalService.getProf(profId);
    }


    @GetMapping("/getProfSchedule/{profId}")
    public List<ScheduleMapping> getScheduleForProf(@PathVariable @NotNull Integer profId) {
        return professionalService.getScheduleforProf(profId);
    }


    @GetMapping("/addMedicine/{patientName}")
    public String AddMedicine(@PathVariable @NotNull String patientName, @RequestBody @NotNull MedicineInfo medicineInfo) {
        return professionalService.addMedicine(patientName,medicineInfo);
    }

}
