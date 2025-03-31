package com.notification.Notification.models.cloud;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class CloudStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String fatherName;
    private String schoolName;
    private String mobileNumber;

    // Default Constructor
    public CloudStudent() {}

    // Parameterized Constructor
    public CloudStudent(Long id, String name, String fatherName, String schoolName, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.schoolName = schoolName;
        this.mobileNumber = mobileNumber;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
