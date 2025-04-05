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
    private StudentRepository studentRepository;

    @Autowired
    private LocalStudentRepository localStudentRepository;

    public void registerStudent(StudentRegisterRequest request) {
        try {
            System.out.println("🔹 Registering student: " + request.getName());

            // Cloud
            CloudStudent cloudStudent = new CloudStudent();
            cloudStudent.setName(request.getName());
            cloudStudent.setFatherName(request.getFatherName());
            cloudStudent.setSchoolUniqueId(request.getSchoolUniqueId()); // ✅
            cloudStudent.setCourse(request.getCourse());
            cloudStudent.setMobileNumber(request.getMobileNumber());

            cloudStudent = studentRepository.save(cloudStudent);
            System.out.println("✅ Saved in Cloud DB! ID: " + cloudStudent.getId());

            // Local
            LocalStudent localStudent = new LocalStudent();
            localStudent.setId(cloudStudent.getId());
            localStudent.setName(request.getName());
            localStudent.setFatherName(request.getFatherName());
            localStudent.setSchoolUniqueId(request.getSchoolUniqueId()); // ✅
            localStudent.setCourse(request.getCourse());
            localStudent.setMobileNumber(request.getMobileNumber());

            localStudentRepository.save(localStudent);
            System.out.println("✅ Saved in Local DB! ID: " + localStudent.getId());

        } catch (Exception e) {
            System.err.println("❌ Error in Student Registration: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
