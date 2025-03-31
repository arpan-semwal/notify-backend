package com.notification.Notification.controllers;

import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.services.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/admin")
public class AdminRegisterController {

    @Autowired
    private AdminRegisterService adminRegisterService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerAdmin(@RequestBody AdminRegister adminRegister) {
        AdminRegister savedAdmin = adminRegisterService.registerAdmin(adminRegister);

        // Create response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Admin registered successfully");
        response.put("uniqueId", savedAdmin.getUniqueId());
        response.put("institutionType", savedAdmin.getInstitutionType()); // ✅ Send type back

        return ResponseEntity.ok(response);
    }
}
