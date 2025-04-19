package com.notification.Notification.models.local;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "local_message")
public class LocalMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolUniqueId;
    private String courseUniqueId; // Only store courseUniqueId now
    private String content;
    private Timestamp timestamp;

    // Constructors
    public LocalMessage() {}

    public LocalMessage(String schoolUniqueId, String courseUniqueId, String content, Timestamp timestamp) {
        this.schoolUniqueId = schoolUniqueId;
        this.courseUniqueId = courseUniqueId;  // Store courseUniqueId
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSchoolUniqueId() { return schoolUniqueId; }
    public void setSchoolUniqueId(String schoolUniqueId) { this.schoolUniqueId = schoolUniqueId; }

    public String getCourseUniqueId() { return courseUniqueId; }
    public void setCourseUniqueId(String courseUniqueId) { this.courseUniqueId = courseUniqueId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
}
