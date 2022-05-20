CREATE DATABASE  IF NOT EXISTS `planeshop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `planeshop`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: planeshop
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `jaar_rente` double NOT NULL,
  `loop_tijd` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pmt` double NOT NULL,
  `price` double NOT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES (1,'Boeing','De Boeing 747-8 is een versie van de Boeing 747 die werd aangekondigd op 14 november 2005. Boeing vervangt hiermee de Boeing 747-400 en beconcurreert de superjumbo van concurrent Airbus, de A380.',0,0,'747-8',0,350000000,'B-747_Iberia.jpg',NULL),(2,'Airbus','De Airbus A320 is een narrow-bodyvliegtuigtype van de Europese vliegtuigbouwer Airbus. De benaming wordt zowel gebruikt voor de A320 zelf als voor de \"A320-familie\", met daarin de aan elkaar gerelateerde vliegtuigtypen A318, A319, A320 en A321.',0,0,'A320',0,101000000,'Airbus_A320-214,_Brussels_Airlines_AN2114057.jpg',NULL),(3,'Antonov','De Antonov An-225 \"Mriya\" is een voormalig vrachtvliegtuig, ontworpen in de Oekraïense SSR door het ontwerpbureau Antonov. Gemeten naar maximum startgewicht was het het grootste vliegtuig ooit gebouwd.',0,0,'An-225 Mriya',0,300000000,'an225.jpg',NULL),(4,'Cessna','De Citation is een familie van zakenjets van Cessna die in 1972 begon met de ingebruikname van het eerste model. In de vijftig jaar na de eerste vlucht in 1969 werden meer dan 7.500 Citations afgeleverd, waarmee ze de grootste vloot van zakenjets vormden.',0,0,'Citation',0,27000000,'citationx.jpg',NULL),(5,'Eurofighter','De Eurofighter Typhoon is een gevechtsvliegtuig ontworpen en gebouwd door een Europees consortium bestaande uit de industrieën: EUROJET NETMA Alenia Aeronautica BAE Systems Construcciones Aeronáuticas European Aeronautic Defence and Space Company',0,0,'Typhoon',0,124000000,'German_eurofighter.jpg',NULL),(6,'General Dynamics','De F-16 Fighting Falcon is een eenmotorige multifunctionele straaljager die sinds 1979 veel gebruikt wordt. In onder andere Nederland en België was het de opvolger van de F-104 Starfighter. In België kwam de F-16 ook in de plaats van de Mirage 5. In Neder',0,0,'F-16 Fighting Falcon',0,35000000,'Belgian-Air-Force-F-16-Vador-3-1024x682.jpg',NULL);
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Gusco','geheim');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-20 14:08:13
