package com.notification.Notification.controllers;

import com.notification.Notification.dto.SchoolResponse;
import com.notification.Notification.services.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }



    @GetMapping("/all")
    public List<SchoolResponse> getAllSchools() {
        return schoolService.getAllSchools();
    }


    @GetMapping("/search")
    public List<SchoolResponse> searchSchools(@RequestParam String query) {
        return schoolService.searchSchools(query);
    }
}
