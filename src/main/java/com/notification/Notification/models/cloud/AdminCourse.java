package com.notification.Notification.models.cloud;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
@Table(name = "admin_course")
public class AdminCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unique_id", referencedColumnName = "uniqueId") // 👈 use uniqueId instead of ID
    @JsonBackReference
    private AdminRegister admin;

    // Constructors
    public AdminCourse() {}

    public AdminCourse(String courseName) {
        this.courseName = courseName;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName) { this.courseName = courseName; }

    public AdminRegister getAdmin() { return admin; }

    public void setAdmin(AdminRegister admin) { this.admin = admin; }
}
