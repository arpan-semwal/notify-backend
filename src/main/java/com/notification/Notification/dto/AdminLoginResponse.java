package com.notification.Notification.dto;

public class AdminLoginResponse {
    private boolean success;
    private String message;
    private String schoolName;
    private String schoolUniqueId;
    private String email;

    public AdminLoginResponse(boolean success, String message, String schoolName, String schoolUniqueId, String email) {
        this.success = success;
        this.message = message;
        this.schoolName = schoolName;
        this.schoolUniqueId = schoolUniqueId;
        this.email = email;
    }

    // Getters and setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolUniqueId() {
        return schoolUniqueId;
    }

    public void setSchoolUniqueId(String schoolUniqueId) {
        this.schoolUniqueId = schoolUniqueId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
