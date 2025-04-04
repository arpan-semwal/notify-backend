package com.notification.Notification.services;

import com.notification.Notification.dto.MessageRequest;
import com.notification.Notification.models.cloud.GlobalMessage;
import com.notification.Notification.models.local.LocalMessage;
import com.notification.Notification.repository.cloud.GlobalMessageRepository;
import com.notification.Notification.repository.local.LocalMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service
public class MessageService {

    @Autowired
    private GlobalMessageRepository globalMessageRepository;

    @Autowired
    private LocalMessageRepository localMessageRepository;

    public boolean saveMessage(MessageRequest request) {
        try {
            GlobalMessage globalMessage = new GlobalMessage();
            globalMessage.setSchoolName(request.getSchoolName());
            globalMessage.setCourse(request.getCourse());
            globalMessage.setContent(request.getMessage());
            globalMessage.setTimestamp(new Timestamp(System.currentTimeMillis()));

            // ✅ Save to global database
            globalMessageRepository.save(globalMessage);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<LocalMessage> getMessages(String schoolName, String course) {
        // ✅ Fetch messages from the local database
        List<LocalMessage> localMessages = localMessageRepository.findBySchoolNameAndCourse(schoolName, course);
        if (!localMessages.isEmpty()) {
            return localMessages;
        }

        // ✅ Fetch messages from the global database if not found locally
        List<GlobalMessage> globalMessages = globalMessageRepository.findBySchoolNameAndCourse(schoolName, course);

        if (!globalMessages.isEmpty()) {
            // ✅ Convert GlobalMessage to LocalMessage and ensure correct type
            List<LocalMessage> newLocalMessages = new ArrayList<>();

            for (GlobalMessage message : globalMessages) {
                LocalMessage localMessage = new LocalMessage(
                        message.getSchoolName(),
                        message.getCourse(),
                        message.getContent(),
                        new Timestamp(System.currentTimeMillis())
                );
                newLocalMessages.add(localMessage);
            }

            // ✅ Save all converted messages into the local database
            localMessageRepository.saveAll(newLocalMessages);

            // ✅ Return explicitly converted List<LocalMessage>
            return new ArrayList<>(newLocalMessages);
        }

        return new ArrayList<>(); // Return an empty list instead of null
    }
}
