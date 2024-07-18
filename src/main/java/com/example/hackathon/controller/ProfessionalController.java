package com.example.hackathon.controller;

import com.example.hackathon.dto.MedicineInfo;
import com.example.hackathon.models.Patient;
import com.example.hackathon.models.Professional;
import com.example.hackathon.models.ScheduleMapping;
import com.example.hackathon.service.ProfessionalService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/getProfessionalIdByEmail")
    public ResponseEntity<Integer> getProfessionalIdByEmail(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        Professional professional = professionalService.getProfessionalByEmail(email);
        if (professional == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // or HttpStatus.BAD_REQUEST if email does not exist
        }
        return new ResponseEntity<>(professional.getId(), HttpStatus.OK);
    }
}
