package com.notification.Notification.repository.local;

import com.notification.Notification.models.local.LocalMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LocalMessageRepository extends JpaRepository<LocalMessage, Long> {

    // ✅ Check if a message with the same content and schoolName exists
    boolean existsByContentAndSchoolName(String content, String schoolName);

    // ✅ Fetch messages by schoolName
    List<LocalMessage> findBySchoolName(String schoolName);
}
