package com.notification.Notification.services;

import com.notification.Notification.repository.cloud.AdminRegisterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchoolService {
    private final AdminRegisterRepository adminRegisterRepository;

    public SchoolService(AdminRegisterRepository adminRegisterRepository){
        this.adminRegisterRepository = adminRegisterRepository;
    }

    // Fetch all school names
    public List<String> getAllSchoolNames() {
        return adminRegisterRepository.findAllSchoolNames();
    }
}
