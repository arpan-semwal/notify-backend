package com.notification.Notification.controllers;

import com.notification.Notification.dto.MessageRequest;
import com.notification.Notification.models.cloud.GlobalMessage;
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

    // Save Message to Global DB using schoolUniqueId
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

    // Fetch Messages from Local DB using schoolUniqueId
    @GetMapping("/fetch")
    public ResponseEntity<List<LocalMessage>> fetchMessages(
            @RequestParam String schoolUniqueId,
            @RequestParam String courseUniqueId
    ) {
        return ResponseEntity.ok(messageService.getMessages(schoolUniqueId, courseUniqueId));
    }

    // Sync messages from global to local DB
    @GetMapping("/sync")
    public ResponseEntity<Map<String, Object>> syncMessages(@RequestParam String schoolUniqueId,
                                                            @RequestParam String courseUniqueId) {
        messageService.syncMessages(schoolUniqueId, courseUniqueId);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Sync completed successfully");

        return ResponseEntity.ok(response);
    }



    @GetMapping("/fetch-global")
    public ResponseEntity<List<GlobalMessage>> fetchGlobalMessages(
            @RequestParam String schoolUniqueId,
            @RequestParam String courseUniqueId) {
        List<GlobalMessage> messages = messageService.getGlobalMessages(schoolUniqueId, courseUniqueId);
        return ResponseEntity.ok(messages);
    }
}
