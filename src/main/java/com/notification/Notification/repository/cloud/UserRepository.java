package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // ✅ CHANGED Integer to Long
    Optional<User> findBySchoolNameAndRegistrationNumberAndMobileNumber(
            String schoolName, String registrationNumber, String mobileNumber);
}
