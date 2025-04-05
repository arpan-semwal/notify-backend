package com.notification.Notification.services;

import com.notification.Notification.dto.SchoolResponse;
import com.notification.Notification.models.cloud.AdminRegister;
import com.notification.Notification.repository.cloud.AdminRegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final AdminRegisterRepository adminRegisterRepository;

    public SchoolService(AdminRegisterRepository adminRegisterRepository){
        this.adminRegisterRepository = adminRegisterRepository;
    }

    public List<SchoolResponse> getAllSchools() {
        List<AdminRegister> admins = adminRegisterRepository.findAllAdmins();
        return admins.stream()
                .map(admin -> new SchoolResponse(admin.getSchoolName(), admin.getUniqueId()))
                .collect(Collectors.toList());
    }
}
