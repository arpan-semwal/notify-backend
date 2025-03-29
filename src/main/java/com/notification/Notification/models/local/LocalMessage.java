package com.notification.Notification.models.local;

import jakarta.persistence.*;

@Entity
@Table(name = "local_messages")
public class LocalMessage {

    @Id
    private Long id;  // Keep same ID as cloud

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    // ✅ Explicit Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
