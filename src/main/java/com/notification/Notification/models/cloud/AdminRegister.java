package com.notification.Notification.models.cloud;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "admin_register")
public class AdminRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 4)
    private String uniqueId;

    private String schoolName;
    private String city;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AdminCourse> courses;

    // Constructors
    public AdminRegister() {
        this.uniqueId = generateUniqueId();
    }

    public AdminRegister(String schoolName, String city, String address, String mobileNumber, String email, String password, List<AdminCourse> courses) {
        this.schoolName = schoolName;
        this.city = city;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.courses = courses;
        this.uniqueId = generateUniqueId();
    }

    private String generateUniqueId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder id = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            id.append(chars.charAt(random.nextInt(chars.length())));
        }
        return id.toString();
    }

    // Getters and Setters
    public String getUniqueId() { return uniqueId; }
    public void setUniqueId(String uniqueId) { this.uniqueId = uniqueId; }

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
            course.setAdmin(this);
        }
    }
}