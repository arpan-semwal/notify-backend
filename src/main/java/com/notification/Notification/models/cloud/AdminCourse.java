package com.notification.Notification.models.cloud;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "admin_courses")
public class AdminCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    @JsonBackReference  // ✅ Prevents infinite recursion when converting to JSON
    private AdminRegister admin;

    public AdminCourse() {}

    public AdminCourse(String courseName, AdminRegister admin) {
        this.courseName = courseName;
        this.admin = admin;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public AdminRegister getAdmin() { return admin; }
    public void setAdmin(AdminRegister admin) { this.admin = admin; }
}
