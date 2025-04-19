package com.notification.Notification.models.cloud;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "global_message")
public class GlobalMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolUniqueId;
    private String courseUniqueId; // Changed from 'course'
    private String content;
    private Timestamp timestamp;

    // Constructors
    public GlobalMessage() {}

    public GlobalMessage(String schoolUniqueId, String courseUniqueId, String content, Timestamp timestamp) {
        this.schoolUniqueId = schoolUniqueId;
        this.courseUniqueId = courseUniqueId;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getSchoolUniqueId() { return schoolUniqueId; }
    public void setSchoolUniqueId(String schoolUniqueId) { this.schoolUniqueId = schoolUniqueId; }

    public String getCourseUniqueId() { return courseUniqueId; }
    public void setCourseUniqueId(String courseUniqueId) { this.courseUniqueId = courseUniqueId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
}
