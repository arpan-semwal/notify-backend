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

    // Removed @Transactional to allow partial success (Cloud can succeed even if Local fails)
    public void registerStudent(StudentRegisterRequest request) {
        try {
            System.out.println("🔹 Registering student: " + request.getName());

            // ✅ Step 1: Save in Cloud DB
            CloudStudent cloudStudent = new CloudStudent();
            cloudStudent.setName(request.getName());
            cloudStudent.setFatherName(request.getFatherName());
            cloudStudent.setSchoolName(request.getSchoolName());
            cloudStudent.setMobileNumber(request.getMobileNumber());

            cloudStudent = studentRepository.save(cloudStudent);
            System.out.println("✅ Saved in Cloud DB! ID: " + cloudStudent.getId());

            // ✅ Step 2: Check if student already exists in Local DB
            boolean exists = localStudentRepository.existsByNameAndSchoolNameIgnoreCase(
                    request.getName(), request.getSchoolName()
            );

            System.out.println("🔍 Checking existence in Local DB: " + exists);

            // ✅ Step 3: Save in Local DB if not exists
            if (!exists) {
                LocalStudent localStudent = new LocalStudent();
                localStudent.setId(cloudStudent.getId()); // ✅ Ensure same ID as cloud
                localStudent.setName(request.getName());
                localStudent.setFatherName(request.getFatherName());
                localStudent.setSchoolName(request.getSchoolName());
                localStudent.setMobileNumber(request.getMobileNumber());

                localStudent = localStudentRepository.save(localStudent);
                System.out.println("✅ Saved in Local DB! ID: " + localStudent.getId());
            } else {
                System.out.println("⚠️ Student already exists in Local DB: " + request.getName());
            }

        } catch (Exception e) {
            System.err.println("❌ Error in Student Registration: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
