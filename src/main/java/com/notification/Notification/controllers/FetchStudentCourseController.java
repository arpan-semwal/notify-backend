package com.notification.Notification.controllers;

import com.notification.Notification.models.cloud.AdminCourse;
import com.notification.Notification.services.FetchStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FetchStudentCourseController {

    @Autowired
    private FetchStudentCourseService fetchStudentCourseService;

    @GetMapping("/fetchstudentcourse/{schoolUniqueId}")
    public List<AdminCourse> getCoursesBySchool(@PathVariable String schoolUniqueId) {
        return fetchStudentCourseService.getCoursesBySchool(schoolUniqueId);
    }

}
