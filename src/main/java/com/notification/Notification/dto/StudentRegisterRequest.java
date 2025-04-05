package com.notification.Notification.dto;

public class StudentRegisterRequest {
    private String name;
    private String fatherName;
    private String schoolUniqueId; // ✅ Changed from schoolName
    private String mobileNumber;
    private String course;

    // Default constructor
    public StudentRegisterRequest() {}

    // Parameterized constructor
    public StudentRegisterRequest(String name, String fatherName, String schoolUniqueId, String mobileNumber, String course) {
        this.name = name;
        this.fatherName = fatherName;
        this.schoolUniqueId = schoolUniqueId;
        this.mobileNumber = mobileNumber;
        this.course = course;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getSchoolUniqueId() { return schoolUniqueId; } // ✅
    public void setSchoolUniqueId(String schoolUniqueId) { this.schoolUniqueId = schoolUniqueId; } // ✅

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}
