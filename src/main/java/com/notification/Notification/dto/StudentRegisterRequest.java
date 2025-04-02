package com.notification.Notification.dto;

public class StudentRegisterRequest {
    private String name;
    private String fatherName;
    private String schoolName;
    private String mobileNumber;
    private String course; // New field added

    // Default constructor
    public StudentRegisterRequest() {
    }

    // Parameterized constructor
    public StudentRegisterRequest(String name, String fatherName, String schoolName, String mobileNumber, String course) {
        this.name = name;
        this.fatherName = fatherName;
        this.schoolName = schoolName;
        this.mobileNumber = mobileNumber;
        this.course = course;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getCourse() {
        return course;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
