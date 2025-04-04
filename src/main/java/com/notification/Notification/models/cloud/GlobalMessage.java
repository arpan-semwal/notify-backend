
package com.notification.Notification.models.cloud;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "global_message")
public class GlobalMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolName;
    private String course;
    private String content;
    private Timestamp timestamp;

    // ✅ Default Constructor
    public GlobalMessage() {}

    public GlobalMessage(String schoolName, String course, String content, Timestamp timestamp) {
        this.schoolName = schoolName;
        this.course = course;
        this.content = content;
        this.timestamp = timestamp;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
}
