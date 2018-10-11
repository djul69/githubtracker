-- MySQL dump 10.13  Distrib 5.5.61, for Win64 (AMD64)
--
-- Host: localhost    Database: githubtracker
-- ------------------------------------------------------
-- Server version	5.5.61

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
-- Current Database: `githubtracker`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `githubtracker` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `githubtracker`;

--
-- Table structure for table `githuber`
--

DROP TABLE IF EXISTS `githuber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `githuber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `github_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `avatar_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `githuber_github_id_uindex` (`github_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `githuber`
--

LOCK TABLES `githuber` WRITE;
/*!40000 ALTER TABLE `githuber` DISABLE KEYS */;
INSERT INTO `githuber` VALUES (9,199,'Jeremy Daer','jeremy','https://api.github.com/users/jeremy',NULL,'this is a cool site right','San Diego, CA','https://avatars1.githubusercontent.com/u/199?v=4'),(12,38242,'Sylvain Gautier','Sylvain','https://api.github.com/users/Sylvain',NULL,'CTO at @Vinosoft','Paris, France','https://avatars1.githubusercontent.com/u/38242?v=4'),(17,3465387,NULL,'Sylvie','https://api.github.com/users/Sylvie',NULL,NULL,NULL,'https://avatars2.githubusercontent.com/u/3465387?v=4'),(18,272048,'Tatiana Al-Chueyr','tatiana','https://api.github.com/users/tatiana',NULL,NULL,'London','https://avatars1.githubusercontent.com/u/272048?v=4'),(23,12289141,'Tatiana Perillo','Tatianaprl','https://api.github.com/users/Tatianaprl',NULL,NULL,NULL,'https://avatars2.githubusercontent.com/u/12289141?v=4'),(24,18159,'Lisa Seelye','lisa','https://api.github.com/users/lisa',NULL,'Rubyist. Sysadmin. Magic player. Learner.','Toronto, Canada','https://avatars2.githubusercontent.com/u/18159?v=4'),(25,7266512,'Tatiana','whodef','https://api.github.com/users/whodef',NULL,'Geek. What else? \r\n','Cyprus','https://avatars2.githubusercontent.com/u/7266512?v=4'),(26,60341,'Taku M','t','https://api.github.com/users/t',NULL,'????????',NULL,'https://avatars3.githubusercontent.com/u/60341?v=4'),(35,3892910,'Amanda Pickering','amanda','https://api.github.com/users/amanda',NULL,NULL,'Brooklyn, NY','https://avatars2.githubusercontent.com/u/3892910?v=4'),(38,7470425,'Jane','jane','https://api.github.com/users/jane','dev@jane.com',NULL,NULL,'https://avatars3.githubusercontent.com/u/7470425?v=4');
/*!40000 ALTER TABLE `githuber` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-11 16:26:04
