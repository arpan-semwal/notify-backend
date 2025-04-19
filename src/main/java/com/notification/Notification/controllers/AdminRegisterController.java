package com.notification.Notification.controllers;

import com.notification.Notification.models.cloud.AdminCourse;
import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.services.AdminRegisterService;
import com.notification.Notification.services.AdminCourseService;  // Inject AdminCourseService
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        response.put("institutionType", savedAdmin.getInstitutionType()); // Send institution type back

        return ResponseEntity.ok(response);
    }


}
