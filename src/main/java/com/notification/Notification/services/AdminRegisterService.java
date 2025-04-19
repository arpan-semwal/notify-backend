package com.notification.Notification.services;

import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.models.cloud.AdminCourse;
import com.notification.Notification.repository.cloud.AdminRegisterRepository;
import com.notification.Notification.repository.cloud.AdminCourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.RandomStringUtils;

@Service
public class AdminRegisterService {

    @Autowired
    private AdminRegisterRepository adminRegisterRepository;

    @Autowired
    private AdminCourseRepository adminCourseRepository;

    @Transactional("cloudTransactionManager")
    public AdminRegister registerAdmin(AdminRegister admin) {
        // ✅ Check if email already exists
        if (adminRegisterRepository.existsByEmail(admin.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        // ✅ Generate a unique 4-character ID for the admin
        String uniqueId;
        do {
            uniqueId = RandomStringUtils.randomAlphanumeric(4).toUpperCase(); // Example: "X7Q8"
        } while (adminRegisterRepository.existsByUniqueId(uniqueId));

        admin.setUniqueId(uniqueId);

        // ✅ Generate and assign unique course IDs
        if (admin.getCourses() != null) {
            for (AdminCourse course : admin.getCourses()) {
                String courseUniqueId;
                do {
                    courseUniqueId = RandomStringUtils.randomAlphanumeric(6).toUpperCase(); // Example: "AB12CD"
                } while (courseAlreadyExists(courseUniqueId)); // Ensure uniqueness

                course.setCourseUniqueId(courseUniqueId);
                course.setAdmin(admin); // Link the course to the admin
            }
        }

        return adminRegisterRepository.save(admin); // Save admin and associated courses
    }

    // ✅ Helper method to check if courseUniqueId exists
    private boolean courseAlreadyExists(String courseUniqueId) {
        return adminCourseRepository.existsByCourseUniqueId(courseUniqueId);
    }
}
