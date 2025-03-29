package com.notification.Notification.controllers;

import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.services.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminRegisterController {

    @Autowired
    private AdminRegisterService adminRegisterService;

    @PostMapping("/register")
    public String registerAdmin(@RequestBody AdminRegister adminRegister) {
        return adminRegisterService.registerAdmin(adminRegister);  // ✅ Uses service layer
    }
}
