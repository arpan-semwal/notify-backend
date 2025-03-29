--Database Name:

CREATE Database notify_cloud;

use notify_cloud;

--USER TABLE STRUCTURE:



CREATE TABLE users(
    user_id INT NOT NULL AUTO_INCREMENT,
    school_name VARCHAR(20) NOT NULL,
    registration_number VARCHAR(20) NOT NULL,
    mobile_number VARCHAR(10) NOT NULL,
    PRIMARY KEY(user_id)
)