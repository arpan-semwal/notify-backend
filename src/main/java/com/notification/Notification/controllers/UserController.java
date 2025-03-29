package com.notification.Notification.controllers;

import com.notification.Notification.models.cloud.User;
import com.notification.Notification.repository.cloud.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Allow frontend (Android) to access the backend
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
        Optional<User> foundUser = userRepository.findBySchoolNameAndRegistrationNumberAndMobileNumber(
                user.getSchoolName(), user.getRegistrationNumber(), user.getMobileNumber());

        Map<String, String> response = new HashMap<>();
        if (foundUser.isPresent()) {
            response.put("message", "Login Successful");
            response.put("schoolName", foundUser.get().getSchoolName()); // ✅ Make sure it's sent
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid Credentials");
            return ResponseEntity.status(401).body(response);
        }
    }

}


