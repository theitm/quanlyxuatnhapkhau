-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: import_export_db
-- ------------------------------------------------------
-- Server version	8.0.23
DROP database IF EXISTS `import_export_db`;
create database import_export_db;
use import_export_db;

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
-- Table structure for table `tb_commodity`
--

DROP TABLE IF EXISTS `tb_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_commodity` (
  `id` char(36) NOT NULL,
  `id_type_of_commodity` char(36) NOT NULL,
  `commodity_name` varchar(255) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` float NOT NULL,
  `unit` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_type_of_commodity` (`id_type_of_commodity`),
  CONSTRAINT `tb_commodity_ibfk_1` FOREIGN KEY (`id_type_of_commodity`) REFERENCES `tb_type_of_commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_commodity`
--

LOCK TABLES `tb_commodity` WRITE;
/*!40000 ALTER TABLE `tb_commodity` DISABLE KEYS */;
INSERT INTO `tb_commodity` VALUES ('9acf2a52-5eb3-454b-857a-d73f9524d1b6','2a53430c-815b-11eb-8dcd-0242ac130003','Ao Quan','Ao Quan',5000,'Chiec');
/*!40000 ALTER TABLE `tb_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_country`
--

DROP TABLE IF EXISTS `tb_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_country` (
  `id` char(36) NOT NULL,
  `country_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tax` float NOT NULL,
  `transport_fee` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_country`
--

LOCK TABLES `tb_country` WRITE;
/*!40000 ALTER TABLE `tb_country` DISABLE KEYS */;
INSERT INTO `tb_country` VALUES ('98317552-815a-11eb-8dcd-0242ac130003','VN',20,500),('a22dd6fe-815a-11eb-8dcd-0242ac130003','CHINA',10,500),('aa332610-815a-11eb-8dcd-0242ac130003','USA',15.5,500),('b1876a84-815a-11eb-8dcd-0242ac130003','JAPAN',20.1,200),('bcf9e8e2-815a-11eb-8dcd-0242ac130003','ITALIA',15.6,200),('c6cb603a-815a-11eb-8dcd-0242ac130003','LAOS',5,300);
/*!40000 ALTER TABLE `tb_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_details_import_export`
--

DROP TABLE IF EXISTS `tb_details_import_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_details_import_export` (
  `id` char(36) NOT NULL,
  `id_import_export` char(36) NOT NULL,
  `id_commodity` char(36) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantity` double NOT NULL DEFAULT '0',
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_details_import_export_ibfk_2` (`id_commodity`),
  KEY `tb_details_import_export_ibfk_3` (`id_import_export`),
  CONSTRAINT `tb_details_import_export_ibfk_2` FOREIGN KEY (`id_commodity`) REFERENCES `tb_commodity` (`id`),
  CONSTRAINT `tb_details_import_export_ibfk_3` FOREIGN KEY (`id_import_export`) REFERENCES `tb_import_export` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_details_import_export`
--

LOCK TABLES `tb_details_import_export` WRITE;
/*!40000 ALTER TABLE `tb_details_import_export` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_details_import_export` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_document`
--

DROP TABLE IF EXISTS `tb_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_document` (
  `id` char(36) NOT NULL,
  `id_import_export` char(36) NOT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_document_ibfk_1` (`id_import_export`),
  CONSTRAINT `tb_document_ibfk_1` FOREIGN KEY (`id_import_export`) REFERENCES `tb_import_export` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_document`
--

LOCK TABLES `tb_document` WRITE;
/*!40000 ALTER TABLE `tb_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_embargo`
--

DROP TABLE IF EXISTS `tb_embargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_embargo` (
  `id` char(36) NOT NULL,
  `id_type_of_commodity` char(36) NOT NULL,
  `id_country` char(36) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `activate` tinyint(1) NOT NULL,
  `active` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_embargo_ibfk_1` (`id_type_of_commodity`),
  KEY `tb_embargo_ibfk_2` (`id_country`),
  CONSTRAINT `tb_embargo_ibfk_1` FOREIGN KEY (`id_type_of_commodity`) REFERENCES `tb_type_of_commodity` (`id`),
  CONSTRAINT `tb_embargo_ibfk_2` FOREIGN KEY (`id_country`) REFERENCES `tb_country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_embargo`
--

LOCK TABLES `tb_embargo` WRITE;
/*!40000 ALTER TABLE `tb_embargo` DISABLE KEYS */;
INSERT INTO `tb_embargo` VALUES ('1fd0d908-87b9-11eb-8dcd-0242ac130003','163a8330-815b-11eb-8dcd-0242ac130003','a22dd6fe-815a-11eb-8dcd-0242ac130003','AVC',1,NULL);
/*!40000 ALTER TABLE `tb_embargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_import_export`
--

DROP TABLE IF EXISTS `tb_import_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_import_export` (
  `id` char(36) NOT NULL,
  `id_country` char(36) NOT NULL,
  `id_warehouse` char(36) NOT NULL,
  `date` date NOT NULL,
  `type` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_country_import_export` (`id_country`),
  KEY `id_warehouse_import_export` (`id_warehouse`),
  CONSTRAINT `id_country_import_export` FOREIGN KEY (`id_country`) REFERENCES `tb_country` (`id`),
  CONSTRAINT `id_warehouse_import_export` FOREIGN KEY (`id_warehouse`) REFERENCES `tb_warehouse` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_import_export`
--

LOCK TABLES `tb_import_export` WRITE;
/*!40000 ALTER TABLE `tb_import_export` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_import_export` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_type_of_commodity`
--

DROP TABLE IF EXISTS `tb_type_of_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_type_of_commodity` (
  `id` char(36) NOT NULL,
  `id_tax_bracket` char(36) DEFAULT NULL,
  `type_of_commodity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_type_of_commodity_ibfk_1` (`id_tax_bracket`),
  CONSTRAINT `tb_type_of_commodity_ibfk_1` FOREIGN KEY (`id_tax_bracket`) REFERENCES `tb_tax_bracket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_type_of_commodity`
--

LOCK TABLES `tb_type_of_commodity` WRITE;
/*!40000 ALTER TABLE `tb_type_of_commodity` DISABLE KEYS */;
INSERT INTO `tb_type_of_commodity` VALUES ('163a8330-815b-11eb-8dcd-0242ac130003','ee89ae10-815a-11eb-8dcd-0242ac130003','AO QUAN','Loai hang hoa Ao quan'),('2a53430c-815b-11eb-8dcd-0242ac130003','031b705c-815b-11eb-8dcd-0242ac130003','XE OTO','O to nhap khau'),('3d69ba0c-815b-11eb-8dcd-0242ac130003','fd19dec8-815a-11eb-8dcd-0242ac130003','THUC PHAM','Thuc pham'),('4d6f0fec-815b-11eb-8dcd-0242ac130003','ee89ae10-815a-11eb-8dcd-0242ac130003','TRAI CAY','Trai cay');
/*!40000 ALTER TABLE `tb_type_of_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tax_bracket`
--

DROP TABLE IF EXISTS `tb_tax_bracket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tax_bracket` (
  `id` char(36) NOT NULL,
  `tax_bracket_name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `coefficient` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tax_bracket`
--

LOCK TABLES `tb_tax_bracket` WRITE;
/*!40000 ALTER TABLE `tb_tax_bracket` DISABLE KEYS */;
INSERT INTO `tb_tax_bracket` VALUES ('031b705c-815b-11eb-8dcd-0242ac130003','Bac 4','4',4),('ee89ae10-815a-11eb-8dcd-0242ac130003','Bac 1','1',1.2),('f6d3bfe8-815a-11eb-8dcd-0242ac130003','Bac 2','2',2),('fd19dec8-815a-11eb-8dcd-0242ac130003','Bac 3','3',3);
/*!40000 ALTER TABLE `tb_tax_bracket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_warehouse`
--

DROP TABLE IF EXISTS `tb_warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_warehouse` (
  `id` char(36) NOT NULL,
  `warehouse_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `capacity` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_warehouse`
--

LOCK TABLES `tb_warehouse` WRITE;
/*!40000 ALTER TABLE `tb_warehouse` DISABLE KEYS */;
INSERT INTO `tb_warehouse` VALUES ('194167d4-815a-11eb-8dcd-0242ac130003','KHO OTO','Kho chua oto',100),('280d7082-815a-11eb-8dcd-0242ac130003','KHO THUC PHAM','Kho chua thuc pham',100),('373217b6-815a-11eb-8dcd-0242ac130003','KHO TRAI CAY','Kho chua trai cay',10000),('94c10cce-d695-45a3-978d-74ad5c7b885e','KHO A','Kho chua hang hoa',10000);
/*!40000 ALTER TABLE `tb_warehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_warehouse_commodity`
--

DROP TABLE IF EXISTS `tb_warehouse_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_warehouse_commodity` (
  `id` char(36) NOT NULL,
  `id_warehouse` char(36) NOT NULL,
  `id_commodity` char(36) NOT NULL,
  `inventory_number` double DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_warehouse_commodity` (`id_warehouse`),
  KEY `fk_warehouse_commodity_2` (`id_commodity`),
  CONSTRAINT `fk_warehouse_commodity` FOREIGN KEY (`id_warehouse`) REFERENCES `tb_warehouse` (`id`),
  CONSTRAINT `fk_warehouse_commodity_2` FOREIGN KEY (`id_commodity`) REFERENCES `tb_commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_warehouse_commodity`
--

LOCK TABLES `tb_warehouse_commodity` WRITE;
/*!40000 ALTER TABLE `tb_warehouse_commodity` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_warehouse_commodity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-18 14:17:55
