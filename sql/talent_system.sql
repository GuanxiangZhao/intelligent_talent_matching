SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `file`;
DROP TABLE IF EXISTS `job_skill`;
DROP TABLE IF EXISTS `job_application`;
DROP TABLE IF EXISTS `job`;
DROP TABLE IF EXISTS `employer_profile`;
DROP TABLE IF EXISTS `candidate_skill`;
DROP TABLE IF EXISTS `skill`;
DROP TABLE IF EXISTS `candidate_experience`;
DROP TABLE IF EXISTS `candidate_education`;
DROP TABLE IF EXISTS `candidate_profile`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_account` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_status` int NOT NULL,
  `create_time` datetime NULL,
  `update_time` datetime NULL,
  `last_login_time` datetime NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `candidate_profile` (
  `profile_id` int NOT NULL AUTO_INCREMENT,
  `profile_name` varchar(50) NOT NULL,
  `profile_age` int NOT NULL,
  `profile_year` int NOT NULL,
  `profile_tel` varchar(11) NOT NULL,
  `profile_email` varchar(50) NULL,
  `profile_localtion` varchar(200) NULL,
  `profile_major` varchar(50) NULL,
  `profile_introduction` text NULL,
  `profile_create_time` datetime NOT NULL,
  `profile_update_time` datetime NOT NULL,
  `profile_user_id` int NOT NULL,
  PRIMARY KEY (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `candidate_education` (
  `education_id` int NOT NULL AUTO_INCREMENT,
  `education_school` varchar(100) NOT NULL,
  `education_start_date` date NOT NULL,
  `education_end_date` date NOT NULL,
  `education_major` varchar(50) NOT NULL,
  `education_create_time` datetime NULL,
  `education_update_time` datetime NULL,
  `education_profile_id` int NOT NULL,
  PRIMARY KEY (`education_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `candidate_experience` (
  `experience_id` int NOT NULL AUTO_INCREMENT,
  `experience_company` varchar(100) NOT NULL,
  `experience_job` varchar(50) NOT NULL,
  `experience_start_date` date NOT NULL,
  `experience_end_date` date NOT NULL,
  `experience_create_time` datetime NULL,
  `experience_update_time` datetime NULL,
  `experience_profile_id` int NOT NULL,
  PRIMARY KEY (`experience_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `skill` (
  `skill_id` int NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(50) NOT NULL,
  `skill_create_time` datetime NULL,
  `skill_update_time` datetime NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `candidate_skill` (
  `candidate_skill_id` int NOT NULL AUTO_INCREMENT,
  `candidate_skill_profile_id` int NOT NULL,
  `candidate_skill_skill_id` int NOT NULL,
  PRIMARY KEY (`candidate_skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employer_profile` (
  `candidate_skill_id` int NOT NULL AUTO_INCREMENT,
  `candidate_skill_profile_id` int NOT NULL,
  `candidate_skill_skill_id` int NOT NULL,
  PRIMARY KEY (`candidate_skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job` (
  `job_id` int NOT NULL AUTO_INCREMENT,
  `job_employer_id` int NOT NULL,
  `job_name` varchar(50) NOT NULL,
  `job_description` varchar(200) NULL,
  `job_requirements` varchar(200) NULL,
  `job_min_salary` double(6,1) NOT NULL,
  `job_max_salary` double(6,1) NOT NULL,
  `job_count` int NOT NULL,
  `job_create_time` datetime NULL,
  `job_update_time` datetime NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job_application` (
  `application_id` int NOT NULL AUTO_INCREMENT,
  `application_candidate_id` int NOT NULL,
  `application_employer_id` int NOT NULL,
  `application_job_id` int NOT NULL,
  `application_create_time` datetime NULL,
  `application_update_time` datetime NULL,
  PRIMARY KEY (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job_skill` (
  `job_skill_id` int NOT NULL AUTO_INCREMENT,
  `job_skill_job_id` int NOT NULL,
  `job_skill_skill_id` int NOT NULL,
  PRIMARY KEY (`job_skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `file` (
  `file_id` int NOT NULL AUTO_INCREMENT,
  `file_user_id` int NOT NULL,
  `file_name` varchar(50) NOT NULL,
  `file_url` varchar(250) NOT NULL,
  `file_type` varchar(20) NOT NULL,
  `file_create_time` datetime NULL,
  `file_update_time` datetime NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
