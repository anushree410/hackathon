package com.example.hackathon.controller;

import com.example.hackathon.dto.LoginInfo;
import com.example.hackathon.dto.SignupInfo;
import com.example.hackathon.dto.SignupResponse;
import com.example.hackathon.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("")
public class SignUpController {

    private SignupService signupService;

    @Autowired
    public SignUpController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupInfo signupInfo) {
        return signupService.signupUser(signupInfo);
    }

    @PostMapping("/login")
    public SignupResponse login(@RequestBody LoginInfo loginInfo) {
        return signupService.loginUser(loginInfo);
    }

}
