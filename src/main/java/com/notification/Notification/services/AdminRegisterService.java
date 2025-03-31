package com.notification.Notification.services;

import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.repository.cloud.AdminRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;  // ✅ Import UUID for unique institutionId
import org.apache.commons.lang3.RandomStringUtils;
import java.security.SecureRandom;
import java.util.Random;
@Service
public class AdminRegisterService {

    @Autowired
    private AdminRegisterRepository adminRegisterRepository;

    @Transactional("cloudTransactionManager")
    public AdminRegister registerAdmin(AdminRegister admin) {
        // Check if email already exists
        if (adminRegisterRepository.existsByEmail(admin.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        // Generate unique 4-character ID
        String uniqueId;
        do {
            uniqueId = RandomStringUtils.randomAlphanumeric(4).toUpperCase(); // Example: "X7Q8"
        } while (adminRegisterRepository.existsByUniqueId(uniqueId));

        admin.setUniqueId(uniqueId);
        return adminRegisterRepository.save(admin);
    }
}