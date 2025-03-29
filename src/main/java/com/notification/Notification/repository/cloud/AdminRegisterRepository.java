package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.AdminRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRegisterRepository extends JpaRepository<AdminRegister, Long> {
    boolean existsByEmail(String email);  // ✅ Added method to check if email exists
}
