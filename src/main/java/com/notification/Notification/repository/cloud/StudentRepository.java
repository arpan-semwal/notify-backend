package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.CloudStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<CloudStudent, Long> {
}
