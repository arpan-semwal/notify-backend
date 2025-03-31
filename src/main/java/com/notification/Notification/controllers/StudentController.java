package com.notification.Notification.controllers;

import com.notification.Notification.dto.StudentRegisterRequest;
import com.notification.Notification.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerStudent(@RequestBody StudentRegisterRequest request) {
        try {
            studentService.registerStudent(request);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Student registered successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Registration failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
