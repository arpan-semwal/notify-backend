package com.notification.Notification.models.local;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class LocalStudent {

    @Id
    private Long id;

    private String name;
    private String fatherName;
    private String schoolUniqueId; // ✅ Changed
    private String course;
    private String mobileNumber;

    public LocalStudent() {}

    public LocalStudent(Long id, String name, String fatherName, String schoolUniqueId, String course, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.schoolUniqueId = schoolUniqueId;
        this.course = course;
        this.mobileNumber = mobileNumber;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getSchoolUniqueId() { return schoolUniqueId; } // ✅
    public void setSchoolUniqueId(String schoolUniqueId) { this.schoolUniqueId = schoolUniqueId; } // ✅

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
}
