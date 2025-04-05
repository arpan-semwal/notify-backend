package com.notification.Notification.dto;

public class MessageRequest {
    private String schoolUniqueId;  // 🔄 Changed from schoolName
    private String course;
    private String message;

    // ✅ Default Constructor
    public MessageRequest() {
    }

    // ✅ Constructor with all fields
    public MessageRequest(String schoolUniqueId, String course, String message) {
        this.schoolUniqueId = schoolUniqueId;
        this.course = course;
        this.message = message;
    }

    // ✅ Getters
    public String getSchoolUniqueId() {
        return schoolUniqueId;
    }

    public String getCourse() {
        return course;
    }

    public String getMessage() {
        return message;
    }

    // ✅ Setters
    public void setSchoolUniqueId(String schoolUniqueId) {
        this.schoolUniqueId = schoolUniqueId;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
