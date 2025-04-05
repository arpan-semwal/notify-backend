package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.GlobalMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlobalMessageRepository extends JpaRepository<GlobalMessage, Long> {
    List<GlobalMessage> findBySchoolUniqueIdAndCourse(String schoolUniqueId, String course);
}
