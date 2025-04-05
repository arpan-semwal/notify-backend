package com.notification.Notification.repository.local;

import com.notification.Notification.models.local.LocalStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalStudentRepository extends JpaRepository<LocalStudent, Long> {

    // ✅ Ensure case-insensitive check for student existence
    boolean existsByNameAndSchoolUniqueIdIgnoreCase(String name, String schoolUniqueId);

}
