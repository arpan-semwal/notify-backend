package com.notification.Notification.controllers;

import com.notification.Notification.services.FetchStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") // Allows frontend requests (Adjust as needed)
public class FetchStudentCourseController {

    @Autowired
    private FetchStudentCourseService fetchStudentCourseService;

    @GetMapping("/fetchstudentcourse/{schoolName}")
    public List<String> getCoursesBySchool(@PathVariable String schoolName) {
        return fetchStudentCourseService.getCoursesBySchool(schoolName);
    }
}
