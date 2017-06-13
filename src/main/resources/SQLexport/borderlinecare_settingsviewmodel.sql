-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: borderlinecare
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `settingsviewmodel`
--

DROP TABLE IF EXISTS `settingsviewmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settingsviewmodel` (
  `ID` int(11) NOT NULL,
  `LOGINACCOUNT_EMAIL` varchar(255) DEFAULT NULL,
  `CONTACT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SETTINGSVIEWMODEL_LOGINACCOUNT_EMAIL` (`LOGINACCOUNT_EMAIL`),
  KEY `FK_SETTINGSVIEWMODEL_CONTACT_ID` (`CONTACT_ID`),
  CONSTRAINT `FK_SETTINGSVIEWMODEL_CONTACT_ID` FOREIGN KEY (`CONTACT_ID`) REFERENCES `contact` (`ID`),
  CONSTRAINT `FK_SETTINGSVIEWMODEL_LOGINACCOUNT_EMAIL` FOREIGN KEY (`LOGINACCOUNT_EMAIL`) REFERENCES `loginaccount` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settingsviewmodel`
--

LOCK TABLES `settingsviewmodel` WRITE;
/*!40000 ALTER TABLE `settingsviewmodel` DISABLE KEYS */;
/*!40000 ALTER TABLE `settingsviewmodel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-13 21:24:07