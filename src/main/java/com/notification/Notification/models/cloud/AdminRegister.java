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

    @Column(unique = true, length = 4)
    private String uniqueId;

    private String schoolName;
    private String city;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;
    private String institutionType;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // ✅ Prevents infinite recursion in JSON serialization
    private List<AdminCourse> courses;

    // Default constructor
    public AdminRegister() {}

    // Parameterized constructor
    public AdminRegister(String schoolName, String city, String address,
                         String mobileNumber, String email, String password,
                         String institutionType) {
        this.schoolName = schoolName;
        this.city = city;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.institutionType = institutionType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUniqueId() { return uniqueId; }
    public void setUniqueId(String uniqueId) { this.uniqueId = uniqueId; }

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

    public String getInstitutionType() { return institutionType; }
    public void setInstitutionType(String institutionType) { this.institutionType = institutionType; }

    public List<AdminCourse> getCourses() { return courses; }
    public void setCourses(List<AdminCourse> courses) { this.courses = courses; }
}
