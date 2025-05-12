package com.notification.Notification.services;

import com.notification.Notification.models.cloud.AdminCourse;
import com.notification.Notification.repository.cloud.AdminCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminCourseService {

    @Autowired
    private AdminCourseRepository adminCourseRepository;

    // Method to save a new course
    public AdminCourse saveCourse(AdminCourse adminCourse) {
        return adminCourseRepository.save(adminCourse);  // Correct method for saving courses
    }

    // Other methods (if any)z
}
