package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.GlobalMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GlobalMessageRepository extends JpaRepository<GlobalMessage, Long> {
    List<GlobalMessage> findBySchoolName(String schoolName);
}


