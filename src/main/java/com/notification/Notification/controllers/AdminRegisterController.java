package com.notification.Notification.controllers;

import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.services.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;

@RestController
@RequestMapping("/api/admin")
public class AdminRegisterController {

    @Autowired
    private AdminRegisterService adminRegisterService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerAdmin(@RequestBody AdminRegister adminRegister) {
        String message = adminRegisterService.registerAdmin(adminRegister);

        // Return a JSON response instead of a plain string
        Map<String, String> response = new HashMap<>();
        response.put("message", message);

        return ResponseEntity.ok(response);
    }
}
