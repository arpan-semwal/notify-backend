package com.notification.Notification.models.cloud;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin_register")
public class AdminRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolName;
    private String city;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // ✅ Prevents infinite recursion when converting to JSON
    private List<AdminCourse> courses;

    // Constructors
    public AdminRegister() {}

    public AdminRegister(String schoolName, String city, String address, String mobileNumber, String email, String password, List<AdminCourse> courses) {
        this.schoolName = schoolName;
        this.city = city;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.courses = courses;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<AdminCourse> getCourses() { return courses; }

    public void setCourses(List<AdminCourse> courses) {
        this.courses = courses;
        for (AdminCourse course : courses) {
            course.setAdmin(this); // ✅ Ensures each course has an admin reference
        }
    }
}
