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

    @Query("SELECT a.schoolName FROM AdminRegister a")
    List<String> findAllSchoolNames();
}
