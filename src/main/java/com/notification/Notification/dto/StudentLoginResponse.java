package com.notification.Notification.dto;

public class StudentLoginResponse {
    private String schoolName;

    public StudentLoginResponse(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}

