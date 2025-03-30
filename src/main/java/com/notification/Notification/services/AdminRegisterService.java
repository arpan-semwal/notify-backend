package com.notification.Notification.services;

import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.repository.cloud.AdminRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminRegisterService {

    @Autowired
    private AdminRegisterRepository adminRegisterRepository;

    @Transactional("cloudTransactionManager")
    public String registerAdmin(AdminRegister admin) {
        // Check if email already exists
        if (adminRegisterRepository.existsByEmail(admin.getEmail())) {
            return "Email already exists!";
        }

        // Ensure correct relationship between Admin and Courses
        admin.setCourses(admin.getCourses());

        // Save admin details including courses
        adminRegisterRepository.save(admin);
        return "Admin registered successfully!";
    }
}
