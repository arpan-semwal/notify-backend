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
    private String course;
    private String content;
    private Timestamp timestamp;

    // Constructors
    public GlobalMessage() {}

    public GlobalMessage(String schoolUniqueId, String course, String content, Timestamp timestamp) {
        this.schoolUniqueId = schoolUniqueId;
        this.course = course;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSchoolUniqueId() { return schoolUniqueId; }
    public void setSchoolUniqueId(String schoolUniqueId) { this.schoolUniqueId = schoolUniqueId; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
}
