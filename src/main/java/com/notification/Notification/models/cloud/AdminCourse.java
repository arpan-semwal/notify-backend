package com.notification.Notification.models.cloud;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "admin_course")
public class AdminCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @Column(name = "course_unique_id", nullable = false, unique = true)
    private String courseUniqueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unique_id", referencedColumnName = "uniqueId")
    @JsonBackReference
    private AdminRegister admin;

    public AdminCourse() {
        this.courseUniqueId = UUID.randomUUID().toString();
    }

    public AdminCourse(String courseName, String courseUniqueId) {
        this.courseName = courseName;
        this.courseUniqueId = courseUniqueId;
    }

    public Long getId() { return id; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseUniqueId() { return courseUniqueId; }
    public void setCourseUniqueId(String courseUniqueId) { this.courseUniqueId = courseUniqueId; }
    public AdminRegister getAdmin() { return admin; }
    public void setAdmin(AdminRegister admin) { this.admin = admin; }
}
