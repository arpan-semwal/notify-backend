package com.notification.Notification.controllers;

import com.notification.Notification.dto.MessageRequest;
import com.notification.Notification.models.local.LocalMessage;
import com.notification.Notification.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // ✅ Endpoint to Save Messages in Global DB
    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody MessageRequest request) {
        boolean success = messageService.saveMessage(request);
        Map<String, String> response = new HashMap<>();
        if (success) {
            response.put("message", "Message sent successfully!");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Failed to send message!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // ✅ Fetch Messages from Local DB
    @GetMapping("/fetch")
    public ResponseEntity<List<LocalMessage>> fetchMessages(
            @RequestParam String schoolName,
            @RequestParam String course
    ) {
        List<LocalMessage> messages = messageService.getMessages(schoolName, course);
        return ResponseEntity.ok(messages);
    }
}
