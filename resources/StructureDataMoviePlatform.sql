CREATE DATABASE  IF NOT EXISTS `movie_platform` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `movie_platform`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: clon_netflix
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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_category` varchar(100) DEFAULT NULL,
  `classification` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Drama',NULL),(2,'Action',NULL),(3,'Comedy',NULL),(4,'Science Fiction',NULL),(5,'Animation',NULL),(6,'Romance',NULL),(7,'Fantasy',NULL),(8,'Thriller',NULL),(9,'Mystery',NULL),(10,'Adventure',NULL),(11,'Horror',NULL),(12,'Musical',NULL),(13,'Western',NULL),(14,'Crime',NULL),(15,'Biography',NULL),(16,'Dramedy',NULL),(17,'War',NULL);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directors`
--

DROP TABLE IF EXISTS `directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `oscar` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directors`
--

LOCK TABLES `directors` WRITE;
/*!40000 ALTER TABLE `directors` DISABLE KEYS */;
INSERT INTO `directors` VALUES (1,'Frank Darabont','USA',0),(2,'Christopher Nolan','United Kingdom',1),(3,'Todd Phillips','USA',0),(4,'Denis Villeneuve','Canada',1),(5,'Josh Cooley','USA',1),(6,'Nick Cassavetes','USA',0),(7,'Peter Jackson','New Zealand',1),(8,'David Fincher','USA',0),(9,'Bryan Singer','USA',1),(10,'Steven Spielberg','USA',1),(11,'William Friedkin','USA',1),(12,'Damien Chazelle','USA',1),(13,'Quentin Tarantino','USA',1),(14,'Alejandro G. Iñárritu','Mexico',1),(15,'George Miller','Australia',1),(16,'Wes Anderson','USA',1),(17,'Tom McCarthy','USA',1),(18,'Jordan Peele','USA',1),(19,'Guillermo del Toro','Mexico',1),(20,'Bong Joon-ho','South Korea',1),(21,'Martin Scorsese','USA',0),(22,'Sam Mendes','United Kingdom',1);
/*!40000 ALTER TABLE `directors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite_movies`
--

DROP TABLE IF EXISTS `favorite_movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite_movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `movie_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `movie_id_UNIQUE` (`movie_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `movie_id_idx` (`movie_id`),
  CONSTRAINT `movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite_movies`
--

LOCK TABLES `favorite_movies` WRITE;
/*!40000 ALTER TABLE `favorite_movies` DISABLE KEYS */;
INSERT INTO `favorite_movies` VALUES (1,1,4),(2,1,3),(3,2,6),(4,2,1),(5,3,19),(6,3,20),(7,3,10),(8,3,25);
/*!40000 ALTER TABLE `favorite_movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `stars` int DEFAULT NULL,
  `category_id` int NOT NULL,
  `director_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categories_idx` (`category_id`),
  KEY `directors_idx` (`director_id`),
  CONSTRAINT `categories` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `directors` FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'The Shawshank Redemption',1994,5,1,1),(2,'The Dark Knight',2008,5,2,2),(3,'The Hangover',2009,4,3,3),(4,'Blade Runner 2049',2017,5,4,4),(5,'Toy Story 4',2019,4,5,5),(6,'The Notebook',2004,4,6,6),(7,'The Lord of the Rings: The Fellowship of the Ring',2001,5,7,7),(8,'Se7en',1995,5,8,8),(9,'The Usual Suspects',1995,4,9,9),(10,'Indiana Jones and the Last Crusade',1989,4,10,10),(11,'The Exorcist',1973,4,11,11),(12,'La La Land',2016,5,12,12),(13,'Django Unchained',2012,5,13,13),(14,'Pulp Fiction',1994,5,14,13),(15,'The Social Network',2010,4,15,8),(16,'Inception',2010,5,4,2),(17,'The Revenant',2015,5,10,14),(18,'Birdman',2014,4,16,14),(19,'Mad Max: Fury Road',2015,5,2,15),(20,'The Grand Budapest Hotel',2014,4,3,16),(21,'Whiplash',2014,5,1,12),(22,'Interstellar',2014,5,4,2),(24,'Spotlight',2015,4,1,17),(25,'Get Out',2017,4,11,18),(26,'The Shape of Water',2017,5,7,19),(27,'Parasite',2019,5,8,20),(28,'The Irishman',2019,4,14,21),(30,'1917',2019,5,17,22);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Alice Johnson','ali_j','alice.johnson@email.com','Pass123!'),(2,'Bob Smith','bobby89','bob.smith@email.com','SecurePwd987'),(3,'Emily Davis','Emily','emily_davise@mail.com','P@ss123456'),(4,'Alex Turner','a_turner','alex.turner@email.com','Password1234');
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

-- Dump completed on 2024-02-14 10:48:09
