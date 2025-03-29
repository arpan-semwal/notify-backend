package com.notification.Notification.service.cloud;

import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.repository.cloud.AdminRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRegisterService {

    @Autowired
    private AdminRegisterRepository adminRegisterRepository;

    public String registerAdmin(AdminRegister admin) {
        if (adminRegisterRepository.existsByEmail(admin.getEmail())) {
            return "Email already exists!";
        }
        adminRegisterRepository.save(admin);
        return "Admin registered successfully!";
    }
}
