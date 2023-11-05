-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: tao-mysql3.mysql.database.azure.com    Database: university_campus_equipment_rental
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'new york6','usa6','100016','NY6','555555 st'),(2,'fairfield','usa','52557','IA','24 st');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment` (
  `equipmentid` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `equipment_type_typeid` bigint DEFAULT NULL,
  `manufacturer_manufacturerid` bigint DEFAULT NULL,
  PRIMARY KEY (`equipmentid`),
  KEY `FK20po5s63yf9e7lgtxwylruhpt` (`equipment_type_typeid`),
  KEY `FKiicje6ergkxr7mj7wik5expt1` (`manufacturer_manufacturerid`),
  CONSTRAINT `FK20po5s63yf9e7lgtxwylruhpt` FOREIGN KEY (`equipment_type_typeid`) REFERENCES `equipment_type` (`typeid`),
  CONSTRAINT `FKiicje6ergkxr7mj7wik5expt1` FOREIGN KEY (`manufacturer_manufacturerid`) REFERENCES `manufacturer` (`manufacturerid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,'for studing','labtop',1,1);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_type`
--

DROP TABLE IF EXISTS `equipment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment_type` (
  `typeid` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_type`
--

LOCK TABLES `equipment_type` WRITE;
/*!40000 ALTER TABLE `equipment_type` DISABLE KEYS */;
INSERT INTO `equipment_type` VALUES (1,'computer');
/*!40000 ALTER TABLE `equipment_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erdstaff`
--

DROP TABLE IF EXISTS `erdstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `erdstaff` (
  `erd_staffid` varchar(255) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `late_fee_per_day` float NOT NULL,
  `max_rental_days` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`erd_staffid`),
  UNIQUE KEY `UK_l1vfo52k3685jhol1nhiretxf` (`address_id`),
  UNIQUE KEY `UK_cqylcahy2f873rlcshjlsue09` (`user_id`),
  CONSTRAINT `FK5t0ldqgywxesednp3rpxb20t0` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FKsduxf90e8c6j7vj5xgt7ijlox` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erdstaff`
--

LOCK TABLES `erdstaff` WRITE;
/*!40000 ALTER TABLE `erdstaff` DISABLE KEYS */;
INSERT INTO `erdstaff` VALUES ('1','3',10,14,'li',2,NULL);
/*!40000 ALTER TABLE `erdstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `facultyid` varchar(255) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `late_fee_per_day` float NOT NULL,
  `max_rental_days` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`facultyid`),
  UNIQUE KEY `UK_be4642bkimc54gmq9uk72s6cw` (`address_id`),
  UNIQUE KEY `UK_3eea1r6n844u6vn4qae7dix4` (`user_id`),
  CONSTRAINT `FK2uvt2fv0einmbtk9ixy0hxm15` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FKfakwwhqpm5bahy2do8t30j58r` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES ('1','4',10,14,'zhao',2,NULL);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graduate_student`
--

DROP TABLE IF EXISTS `graduate_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `graduate_student` (
  `graduate_studentid` varchar(255) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `late_fee_per_day` float NOT NULL,
  `max_rental_days` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`graduate_studentid`),
  UNIQUE KEY `UK_2ssva4soiugbjn5sfoaqcd9fj` (`address_id`),
  UNIQUE KEY `UK_ahdomo2fo7nhsmco1ocqmxn4f` (`user_id`),
  CONSTRAINT `FKdn2qa78qnybuppwndeqvecde0` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FKqkoissxv20sbcraflatebkhbb` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graduate_student`
--

LOCK TABLES `graduate_student` WRITE;
/*!40000 ALTER TABLE `graduate_student` DISABLE KEYS */;
INSERT INTO `graduate_student` VALUES ('1','2',20,10,'zhang',2,NULL);
/*!40000 ALTER TABLE `graduate_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturer` (
  `manufacturerid` bigint NOT NULL AUTO_INCREMENT,
  `contact_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `head_office_address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`manufacturerid`),
  UNIQUE KEY `UK_e3x88fvd7vct4w7ia1u9fsucu` (`head_office_address_id`),
  CONSTRAINT `FK3oqonn56bvf5d7a5g37n33bew` FOREIGN KEY (`head_office_address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'1','IBM',1);
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental_transaction`
--

DROP TABLE IF EXISTS `rental_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental_transaction` (
  `transactionid` bigint NOT NULL AUTO_INCREMENT,
  `due_date` datetime(6) DEFAULT NULL,
  `late_fee` float DEFAULT NULL,
  `rental_date` datetime(6) DEFAULT NULL,
  `return_date` datetime(6) DEFAULT NULL,
  `equipment_equipmentid` bigint DEFAULT NULL,
  `erd_staff_erd_staffid` varchar(255) DEFAULT NULL,
  `faculty_facultyid` varchar(255) DEFAULT NULL,
  `graduate_student_graduate_studentid` varchar(255) DEFAULT NULL,
  `student_studentid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `FKh9mbemtlqth27fksmaqtsd12x` (`equipment_equipmentid`),
  KEY `FK8h719e1tnkqr6k86vccjbpqdl` (`erd_staff_erd_staffid`),
  KEY `FK6v2dor2bmnrwjssko85lq8v8o` (`faculty_facultyid`),
  KEY `FKl4lhkwcosakdqe05bqfms7tvk` (`graduate_student_graduate_studentid`),
  KEY `FKqqnvltkwekjxg6islyrrrd9rv` (`student_studentid`),
  CONSTRAINT `FK6v2dor2bmnrwjssko85lq8v8o` FOREIGN KEY (`faculty_facultyid`) REFERENCES `faculty` (`facultyid`),
  CONSTRAINT `FK8h719e1tnkqr6k86vccjbpqdl` FOREIGN KEY (`erd_staff_erd_staffid`) REFERENCES `erdstaff` (`erd_staffid`),
  CONSTRAINT `FKh9mbemtlqth27fksmaqtsd12x` FOREIGN KEY (`equipment_equipmentid`) REFERENCES `equipment` (`equipmentid`),
  CONSTRAINT `FKl4lhkwcosakdqe05bqfms7tvk` FOREIGN KEY (`graduate_student_graduate_studentid`) REFERENCES `graduate_student` (`graduate_studentid`),
  CONSTRAINT `FKqqnvltkwekjxg6islyrrrd9rv` FOREIGN KEY (`student_studentid`) REFERENCES `student` (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental_transaction`
--

LOCK TABLES `rental_transaction` WRITE;
/*!40000 ALTER TABLE `rental_transaction` DISABLE KEYS */;
INSERT INTO `rental_transaction` VALUES (1,'2023-11-12 06:00:00.000000',77777,'2023-08-01 05:00:00.000000','2023-11-12 06:00:00.000000',1,NULL,NULL,NULL,'1'),(2,'2023-11-12 00:00:00.000000',10,'2023-01-12 00:00:00.000000','2023-11-12 00:00:00.000000',1,'1',NULL,NULL,NULL),(3,'2023-11-12 00:00:00.000000',10,'2023-02-12 00:00:00.000000','2023-11-12 00:00:00.000000',1,'1','1',NULL,NULL),(4,'2023-11-12 00:00:00.000000',10,'2023-03-12 00:00:00.000000','2023-11-12 00:00:00.000000',1,NULL,'1','1',NULL);
/*!40000 ALTER TABLE `rental_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'student');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `studentid` varchar(255) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `late_fee_per_day` float NOT NULL,
  `max_rental_days` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`studentid`),
  UNIQUE KEY `UK_e3500f0n5n132n60x2ay1woj9` (`address_id`),
  UNIQUE KEY `UK_bkix9btnoi1n917ll7bplkvg5` (`user_id`),
  CONSTRAINT `FKcaf6ht0hfw93lwc13ny0sdmvo` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FKk0thg920a3xk3v59yjbsatw1l` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('1','1',10,7,'wang',2,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'123','tao'),(2,'222','wang');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-04 19:52:56
