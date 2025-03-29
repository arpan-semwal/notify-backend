package com.notification.Notification.controllers;

import com.notification.Notification.models.cloud.GlobalMessage;
import com.notification.Notification.models.local.LocalMessage;
import com.notification.Notification.repository.cloud.GlobalMessageRepository;
import com.notification.Notification.repository.local.LocalMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/messages") // ✅ This is correct
public class MessageController {

    @Autowired
    private LocalMessageRepository localMessageRepository;

    @GetMapping  // ✅ Removed "/messages"
    public ResponseEntity<List<LocalMessage>> getMessages(@RequestParam String schoolName) {
        List<LocalMessage> messages = localMessageRepository.findBySchoolName(schoolName);
        if (messages.isEmpty()) {
            System.out.println("No messages found for school: " + schoolName);
        }
        return ResponseEntity.ok(messages);
    }
}