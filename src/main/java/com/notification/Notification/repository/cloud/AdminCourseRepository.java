package com.notification.Notification.repository.cloud;

import com.notification.Notification.models.cloud.AdminCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCourseRepository extends JpaRepository<AdminCourse, Long> { }
