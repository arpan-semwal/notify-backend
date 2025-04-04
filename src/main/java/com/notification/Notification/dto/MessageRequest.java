package com.notification.Notification.dto;

public class MessageRequest {
    private String schoolName;  // ✅ Add schoolName field
    private String course;
    private String message;

    // ✅ Default Constructor
    public MessageRequest() {
    }

    // ✅ Constructor with all fields
    public MessageRequest(String schoolName, String course, String message) {
        this.schoolName = schoolName;
        this.course = course;
        this.message = message;
    }

    // ✅ Getters
    public String getSchoolName() {
        return schoolName;
    }

    public String getCourse() {
        return course;
    }

    public String getMessage() {
        return message;
    }

    // ✅ Setters
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
