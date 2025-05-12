package com.notification.Notification.dto;

public class SchoolResponse {
    private String schoolName;
    private String uniqueId;

    public SchoolResponse() {}

    public SchoolResponse(String schoolName, String uniqueId) {
        this.schoolName = schoolName;
        this.uniqueId = uniqueId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
