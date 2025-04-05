package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.AdminRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRegisterRepository extends JpaRepository<AdminRegister, Long> {

    boolean existsByEmail(String email);

    boolean existsByUniqueId(String uniqueId);  // ✅ Check for unique ID existence

    // ✅ Existing method for just school names (still used elsewhere if needed)
    @Query("SELECT a.schoolName FROM AdminRegister a")
    List<String> findAllSchoolNames();

    // ✅ New method to fetch full list of AdminRegister entities (used in SchoolService)
    @Query("SELECT a FROM AdminRegister a")
    List<AdminRegister> findAllAdmins();
}
