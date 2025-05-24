package com.notification.Notification.services;

import com.notification.Notification.dto.MessageRequest;
import com.notification.Notification.models.cloud.GlobalMessage;
import com.notification.Notification.models.local.LocalMessage;
import com.notification.Notification.repository.cloud.GlobalMessageRepository;
import com.notification.Notification.repository.local.LocalMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private GlobalMessageRepository globalMessageRepository;

    @Autowired
    private LocalMessageRepository localMessageRepository;

    // ✅ Save message to global DB
    public boolean saveMessage(MessageRequest request) {
        try {
            GlobalMessage message = new GlobalMessage(
                    request.getSchoolUniqueId(),
                    request.getCourseUniqueId(),
                    request.getMessage(),
                    new Timestamp(System.currentTimeMillis())
            );
            globalMessageRepository.save(message);
            System.out.println("✅ [SAVE] Message saved to global DB:");
            System.out.println("    • School: " + message.getSchoolUniqueId());
            System.out.println("    • Course: " + message.getCourseUniqueId());
            System.out.println("    • Content: " + message.getContent());
            return true;
        } catch (Exception e) {
            System.err.println("❌ [SAVE ERROR] Failed to save message: " + e.getMessage());
            return false;
        }
    }

    // ✅ Fetch messages from local DB
    public List<LocalMessage> getMessages(String schoolUniqueId, String courseUniqueId) {
        List<LocalMessage> messages = localMessageRepository.findBySchoolUniqueIdAndCourseUniqueId(schoolUniqueId, courseUniqueId);
        System.out.println("📥 [FETCH] Fetching messages for:");
        System.out.println("    • School: " + schoolUniqueId);
        System.out.println("    • Course: " + courseUniqueId);
        System.out.println("    • Total Local Messages: " + messages.size());

        int counter = 1;
        for (LocalMessage message : messages) {
            System.out.println("    #" + counter + " → " + message.getContent());
            counter++;
        }

        return messages;
    }

    // ✅ Sync new messages from global to local
    public void syncMessages(String schoolUniqueId, String courseUniqueId) {
        System.out.println("🔄 [SYNC] Starting sync for:");
        System.out.println("    • School: " + schoolUniqueId);
        System.out.println("    • Course: " + courseUniqueId);

        List<GlobalMessage> globalMessages = globalMessageRepository.findBySchoolUniqueIdAndCourseUniqueId(schoolUniqueId, courseUniqueId);
        List<LocalMessage> localMessages = localMessageRepository.findBySchoolUniqueIdAndCourseUniqueId(schoolUniqueId, courseUniqueId);

        System.out.println("🌐 Global messages found: " + globalMessages.size());
        System.out.println("📦 Local messages before sync: " + localMessages.size());

        int syncedCount = 0;

        for (GlobalMessage global : globalMessages) {
            boolean alreadyExists = localMessages.stream().anyMatch(local ->
                    local.getContent().equals(global.getContent())
            );

            if (!alreadyExists) {
                LocalMessage newLocal = new LocalMessage(
                        global.getSchoolUniqueId(),
                        global.getCourseUniqueId(),
                        global.getContent(),
                        global.getTimestamp()
                );
                localMessageRepository.save(newLocal);
                System.out.println("    ✔️ Synced new message: " + newLocal.getContent());
                syncedCount++;
            }
        }

        List<LocalMessage> updatedLocalMessages = localMessageRepository.findBySchoolUniqueIdAndCourseUniqueId(schoolUniqueId, courseUniqueId);
        System.out.println("✅ [SYNC COMPLETE]");
        System.out.println("    • New messages synced: " + syncedCount);
        System.out.println("    • Total local messages now: " + updatedLocalMessages.size());
    }


    // New method to fetch messages from Global DB for admin
    public List<GlobalMessage> getGlobalMessages(String schoolUniqueId, String courseUniqueId) {
        List<GlobalMessage> messages = globalMessageRepository.findBySchoolUniqueIdAndCourseUniqueId(schoolUniqueId, courseUniqueId);
        System.out.println("📤 [FETCH GLOBAL] Admin fetching messages for:");
        System.out.println("    • School: " + schoolUniqueId);
        System.out.println("    • Course: " + courseUniqueId);
        System.out.println("    • Total messages: " + messages.size());
        return messages;
    }
}
