package com.notification.Notification.services;

import com.notification.Notification.models.cloud.AdminCourse;
import com.notification.Notification.repository.cloud.AdminCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FetchStudentCourseService {

    @Autowired
    private AdminCourseRepository adminCourseRepository;

    public List<String> getCoursesBySchool(String schoolName) {
        List<AdminCourse> courses = adminCourseRepository.findByAdmin_SchoolName(schoolName);
        return courses.stream().map(AdminCourse::getCourseName).collect(Collectors.toList());
    }
}
