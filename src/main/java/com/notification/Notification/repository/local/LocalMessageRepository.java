package com.notification.Notification.repository.local;

import com.notification.Notification.models.local.LocalMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalMessageRepository extends JpaRepository<LocalMessage, Long> {
    List<LocalMessage> findBySchoolUniqueIdAndCourse(String schoolUniqueId, String course);
}
