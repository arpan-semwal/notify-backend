package com.notification.Notification.controllers;




import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.service.cloud.AdminRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminRegisterController {

    @Autowired
    private AdminRegisterService adminRegisterService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRegister admin) {
        String response = adminRegisterService.registerAdmin(admin);
        return ResponseEntity.ok(response);
    }
}

