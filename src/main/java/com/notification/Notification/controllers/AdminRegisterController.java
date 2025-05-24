package com.notification.Notification.controllers;

import com.notification.Notification.dto.AdminLoginRequest;
import com.notification.Notification.dto.AdminLoginResponse;
import com.notification.Notification.models.cloud.AdminCourse;
import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.services.AdminRegisterService;
import com.notification.Notification.services.AdminCourseService;  // Inject AdminCourseService
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
public class AdminRegisterController {

    @Autowired
    private AdminRegisterService adminRegisterService;

    @Autowired
    private AdminCourseService adminCourseService;  // Inject AdminCourseService

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerAdmin(@RequestBody AdminRegister adminRegister) {
        // Save Admin Register
        AdminRegister savedAdmin = adminRegisterService.registerAdmin(adminRegister);

        // Assign unique 4-character course IDs for each course
        for (AdminCourse course : adminRegister.getCourses()) {
            // Generate unique 4-character course ID for each course
            String courseUniqueId = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
            course.setCourseUniqueId(courseUniqueId);
            course.setAdmin(savedAdmin);  // Associate course with the admin
            adminCourseService.saveCourse(course);  // Save course entity in database
        }

        // Create response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Admin registered successfully");
        response.put("uniqueId", savedAdmin.getUniqueId());


        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponse> loginAdmin(@RequestBody AdminLoginRequest request) {
        AdminRegister admin = adminRegisterService.findBySchoolName(request.getSchoolName());

        if (admin == null || !admin.getPassword().equals(request.getPassword())) {
            return ResponseEntity
                    .status(401)
                    .body(new AdminLoginResponse(false, "Invalid credentials", null, null, null));
        }

        AdminLoginResponse response = new AdminLoginResponse(
                true,
                "Login successful",
                admin.getSchoolName(),
                admin.getUniqueId(),
                admin.getEmail()
        );

        return ResponseEntity.ok(response);
    }





}
