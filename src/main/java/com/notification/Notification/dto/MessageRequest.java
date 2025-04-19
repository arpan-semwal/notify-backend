package com.notification.Notification.dto;

public class MessageRequest {
    private String schoolUniqueId;      // Unique ID of the school
    private String courseUniqueId;      // Unique ID of the course
    private String message;             // Message content

    // ✅ Default Constructor
    public MessageRequest() {
    }

    // ✅ Constructor with all fields
    public MessageRequest(String schoolUniqueId, String courseUniqueId, String message) {
        this.schoolUniqueId = schoolUniqueId;
        this.courseUniqueId = courseUniqueId;
        this.message = message;
    }

    // ✅ Getters
    public String getSchoolUniqueId() {
        return schoolUniqueId;
    }

    public String getCourseUniqueId() {
        return courseUniqueId;
    }

    public String getMessage() {
        return message;
    }

    // ✅ Setters
    public void setSchoolUniqueId(String schoolUniqueId) {
        this.schoolUniqueId = schoolUniqueId;
    }

    public void setCourseUniqueId(String courseUniqueId) {
        this.courseUniqueId = courseUniqueId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
