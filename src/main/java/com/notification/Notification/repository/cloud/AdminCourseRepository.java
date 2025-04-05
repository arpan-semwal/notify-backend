package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.AdminCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminCourseRepository extends JpaRepository<AdminCourse, Long> {
    List<AdminCourse> findByAdmin_SchoolName(String schoolName);
}

