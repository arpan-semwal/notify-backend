package com.notification.Notification.services;

import com.notification.Notification.models.cloud.GlobalMessage;
import com.notification.Notification.models.local.LocalMessage;
import com.notification.Notification.repository.cloud.GlobalMessageRepository;
import com.notification.Notification.repository.local.LocalMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MessageSyncService {

    @Autowired
    private GlobalMessageRepository globalMessageRepository;

    @Autowired
    private LocalMessageRepository localMessageRepository;

    @Transactional("localTransactionManager")
    @Scheduled(fixedRate = 60000) // Runs every 60 seconds
    public void syncMessages() {
        System.out.println("🔄 Syncing messages..."); // Debug log

        List<GlobalMessage> newMessages = globalMessageRepository.findAll();
        System.out.println("🌍 Fetched " + newMessages.size() + " messages from global DB"); // Debug log

        for (GlobalMessage msg : newMessages) {
            // ✅ Use correct method
            if (!localMessageRepository.existsByContentAndSchoolName(msg.getContent(), msg.getSchoolName())) {
                LocalMessage localMessage = new LocalMessage();
                localMessage.setId(msg.getId()); // Keep ID same as cloud
                localMessage.setContent(msg.getContent());
                localMessage.setSchoolName(msg.getSchoolName());
                localMessage.setTimestamp(msg.getTimestamp());

                System.out.println("✅ Saving message: " + msg.getContent()); // Debug log
                localMessageRepository.save(localMessage);
            } else {
                System.out.println("⚠️ Message already exists: " + msg.getContent());
            }
        }
    }
}
