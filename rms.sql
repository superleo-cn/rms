-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: play
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `feedbackId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK752F2BDE1E045315` (`userId`),
  KEY `FK752F2BDEB6DA1A09` (`feedbackId`),
  CONSTRAINT `FK752F2BDE1E045315` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK752F2BDEB6DA1A09` FOREIGN KEY (`feedbackId`) REFERENCES `feedback` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (3,NULL,'1323131','3213123',1,7),(4,NULL,'321312312','3213123',1,7),(5,NULL,'321321312','43243242',1,7),(6,NULL,'432424','432',1,8),(7,NULL,'31313','3123',1,8);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `circular`
--

DROP TABLE IF EXISTS `circular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circular` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` varchar(255) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `endDate` varchar(255) DEFAULT NULL,
  `startDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAA8F6ABF1E045315` (`userId`),
  CONSTRAINT `FKAA8F6ABF1E045315` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circular`
--

LOCK TABLES `circular` WRITE;
/*!40000 ALTER TABLE `circular` DISABLE KEYS */;
INSERT INTO `circular` VALUES (1,'2011-08-25 11:27:01','<span class=\"Apple-style-span\" style=\"color:#333333;font-family:tahoma, sans-serif;font-size:11px;line-height:13px;\"><div id=\"ahead\" class=\"articlehead galleryhead\"><p class=\"articleabstract\" style=\"clear:both;color:#666666;font-family:Tahoma;font-size:1.25em;font-weight:bold;line-height:1.2em;margin-top:0px;margin-bottom:0px;\">Steve Jobs has resigned in a long-expected move and named Chief Operating Officer Tim Cook as his replacement. In tribute to the \'iCon\' here\'s a look at Jobs through the years.</p>\r\n<br />\r\n</div>\r\n<div id=\"abody\" class=\"articlebody\" style=\"clear:right;overflow-x:hidden;overflow-y:hidden;min-width:100%;width:602px;\"><div class=\"parent insert chrome6 single1 float8 cf\" style=\"margin-top:0.37em;margin-right:auto;margin-bottom:9px;margin-left:auto;float:none;clear:both;width:422px;\"><div class=\"child c1 first\" style=\"margin-top:0px;margin-right:0px;margin-bottom:6px;margin-left:0px;\"><div class=\"img\" style=\"font-size:11px;\"><p style=\"font-size:11px;margin-top:0px;margin-bottom:0.714em;padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;line-height:1.286em;\"><img src=\"http://sgstb.msn.com/i/E0/6801FF1CACF4DC5EDCBF354C7531.jpg\" width=\"418\" height=\"325\" alt=\"Steve Jobs(AP Photo)\" class=\"img1\" title=\"Steve Jobs(AP Photo)\" style=\"font-size:11px;border-top-style:solid;border-right-style:solid;border-bottom-style:solid;border-left-style:solid;border-top-width:1px;border-right-width:1px;border-bottom-width:1px;border-left-width:1px;border-top-color:#999999;border-right-color:#999999;border-bottom-color:#999999;border-left-color:#999999;padding-top:1px;padding-right:1px;padding-bottom:1px;padding-left:1px;\" /></p>\r\n<p class=\"copyright\" style=\"float:right;font-size:11px;margin-top:0px;margin-bottom:0.714em;padding-top:0px;padding-right:0.5em;padding-bottom:0px;padding-left:0px;color:#999999;text-align:right;font-family:Tahoma;line-height:1.286em;\">AP Photo</p>\r\n</div>\r\n</div>\r\n</div>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\"><a href=\"http://technology.xin.msn.com/mobile-and-gadgets/photos.aspx?cp-documentid=4589798&amp;page=1\" style=\"text-decoration:none;background-color:transparent;color:#07519a;\"><strong>In Pictures: Steve Jobs through the years</strong></a></p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">Apple\'s legendary co-founder and top ideas man Steve Jobs resigned as chief executive Wednesday, the company said, in a long expected move after he began a dramatic fight with cancer.</p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">In a written statement, Apple, the world\'s second biggest company by market capitalization, announced that chief operating officer Tim Cook would take over as CEO but that Jobs would stay on as chairman of the board.</p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">\"Steve\'s extraordinary vision and leadership saved Apple and guided it to its position as the world\'s most innovative and valuable technology company,\" board member Art Levinson said in a statement.</p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\"><strong><a href=\"http://technology.xin.msn.com/technology-news/article.aspx?cp-documentid=5196871\" style=\"text-decoration:none;background-color:transparent;color:#07519a;\">READ: Jobs\' resignation sends Apple share tumbling</a></strong></p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">No reason was given for Job\'s resignation, but his health problems, including a lengthy medical leave for a liver transplant in 2009 and his increasingly gaunt appearances at public events, fueled speculation he would have to give up the everyday running of the&nbsp;<a href=\"http://technology.xin.msn.com/technology-news/article.aspx?cp-documentid=5196876\" style=\"text-decoration:none;background-color:transparent;color:#07519a;\">company he co-founded in 1976.</a></p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">Cook ran Apple when Jobs went on medical leave and has essentially been running day-to-day operations since early this year with the company racking up record revenue and profit.</p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">Jobs is seen as the heart and soul of Apple, with analysts and investors repeatedly expressing concern over how the Cupertino, California-based company would handle his departure.</p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">\"The board has complete confidence that Tim is the right person to be our next CEO,\" Levinson said.</p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">\"Tim\'s 13 years of service to Apple have been marked by outstanding performance, and he has demonstrated remarkable talent and sound judgment in everything he does,\" Levinson continued.</p>\r\n<p style=\"font-family:Tahoma;font-size:1.25em;line-height:1.286em;margin-top:0px;margin-bottom:0.714em;\">Jobs submitted his resignation on Wednesday and urged the board to implement its succession plan and name Cook as his replacement, according to Apple.&nbsp;<a href=\"http://news.xin.msn.com/en/sci-tech/article.aspx?cp-documentid=5196749\" style=\"text-decoration:none;background-color:transparent;color:#07519a;\"><strong>FULL STORY</strong></a></p>\r\n</div>\r\n</span>','Steve Jobs - The iCon says iQuit',1,'2011-08-25 12:35','2011-08-25 11:26');
/*!40000 ALTER TABLE `circular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `endDate` varchar(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `startDate` varchar(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `facilityId` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK403827A1E045315` (`userId`),
  KEY `FK403827AD956D0C5` (`facilityId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'test1','2011-08-10 22:00:00','test1','2011-08-10 20:00:00',3,2,'green'),(2,'test2','2011-08-10 01:00:00','test2','2011-08-10 02:00:00',3,2,'blue'),(3,'test3','2011-08-15 03:00:00','test3','2011-08-10 05:00:00',3,2,'blue'),(4,'test4','2011-08-11 03:00:00','test4','2011-08-11 05:00:00',3,2,'blue'),(5,'test5','2011-08-12 03:00:00','test5','2011-08-12 05:00:00',3,2,'green'),(6,'test5','2011-08-13 03:00:00','test6','2011-08-13 05:00:00',3,2,'green'),(7,'hubo','2011-08-01 10:00:00','hubo','2011-08-01 00:00:00',3,2,'green'),(8,'BBQ1','2011-08-02 13:00:00','BBQ1','2011-08-02 12:00:00',3,2,'blue'),(9,'BBQ1','2011-08-02 13:00:00','BBQ1','2011-08-02 12:00:00',3,2,'blue'),(10,'BBQ1','2011-08-02 13:00:00','BBQ1','2011-08-02 12:00:00',3,2,'blue'),(11,'BBQ1','2011-08-02 13:00:00','BBQ1','2011-08-02 12:00:00',3,2,'green'),(12,'BBQ1','2011-08-02 13:00:00','BBQ1','2011-08-02 12:00:00',3,2,'red'),(13,'BBQ1','2011-08-02 13:00:00','BBQ1','2011-08-02 12:00:00',3,2,'green'),(14,'BBQ1','2011-08-02 13:00:00','BBQ1','2011-08-02 12:00:00',3,2,'red'),(15,'BBQ1','2011-08-02 13:00:00','BBQ1','2011-08-02 12:00:00',3,11,'red'),(16,'BBQ3','2011-08-04 00:00:00','BBQ3','2011-08-04 00:00:00',3,11,'red'),(17,'Tennis1','2011-08-24 01:00:00','Tennis1','2011-08-24 00:00:00',3,2,'red'),(18,'green','2011-08-26 02:00:00','green','2011-08-26 00:00:00',3,2,'green');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES (2,'BBQ','BBQ'),(4,'','Info-lab'),(6,'','Tennis'),(7,'','Function Room'),(11,'222','222');
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF8704FA51E045315` (`userId`),
  CONSTRAINT `FKF8704FA51E045315` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'2011-08-21','1','1',3),(2,'2011-08-21','2','2',2),(3,'2011-08-21','3','3',2),(4,'2011-08-22','4','4',1),(5,'2011-08-23','5','5',2),(6,'2011-08-23','6','6',1),(7,'2011-08-23','7','7',3),(8,'2011-08-21','8','8',3);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `residentType` varchar(255) DEFAULT NULL,
  `unitNo` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'123','hubo',NULL,'#04-1','leo','MGR'),(2,'123','hubo',NULL,'#04-2','leo2','RDT'),(3,'111','leo',NULL,'#0434','leo3','RDT');
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

-- Dump completed on 2013-09-02 13:42:24
