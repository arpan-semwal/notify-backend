package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.GlobalMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlobalMessageRepository extends JpaRepository<GlobalMessage, Long> {
    // Ensure this method correctly saves and fetches messages by schoolUniqueId and courseUniqueId
    List<GlobalMessage> findBySchoolUniqueIdAndCourseUniqueId(String schoolUniqueId, String courseUniqueId);
}
