package com.notification.Notification.services;

import com.notification.Notification.dto.StudentRegisterRequest;
import com.notification.Notification.models.cloud.CloudStudent;
import com.notification.Notification.models.local.LocalStudent;
import com.notification.Notification.repository.cloud.StudentRepository;
import com.notification.Notification.repository.local.LocalStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository; // Cloud DB

    @Autowired
    private LocalStudentRepository localStudentRepository; // Local DB

    public void registerStudent(StudentRegisterRequest request) {
        try {
            System.out.println("🔹 Registering student: " + request.getName());

            // ✅ Save in Cloud DB
            CloudStudent cloudStudent = new CloudStudent();
            cloudStudent.setName(request.getName());
            cloudStudent.setFatherName(request.getFatherName());
            cloudStudent.setSchoolName(request.getSchoolName());
            cloudStudent.setCourse(request.getCourse()); // Fixed: Saving course field
            cloudStudent.setMobileNumber(request.getMobileNumber());

            cloudStudent = studentRepository.save(cloudStudent);
            System.out.println("✅ Saved in Cloud DB! ID: " + cloudStudent.getId());

            // ✅ Save in Local DB
            LocalStudent localStudent = new LocalStudent();
            localStudent.setId(cloudStudent.getId());
            localStudent.setName(request.getName());
            localStudent.setFatherName(request.getFatherName());
            localStudent.setSchoolName(request.getSchoolName());
            localStudent.setCourse(request.getCourse()); // Fixed: Saving course field
            localStudent.setMobileNumber(request.getMobileNumber());

            localStudentRepository.save(localStudent);
            System.out.println("✅ Saved in Local DB! ID: " + localStudent.getId());

        } catch (Exception e) {
            System.err.println("❌ Error in Student Registration: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

