/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.11-MariaDB : Database - jpahowitworks
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jpahowitworks` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `jpahowitworks`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `CODE` bigint(20) NOT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CODE`),
  UNIQUE KEY `indx_name` (`NAME`),
  UNIQUE KEY `uniq_name` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `city` */

insert  into `city`(`CODE`,`NAME`) values 
(11002,'City - 11002'),
(11003,'City - 11003'),
(11006,'City 11006');

/*Table structure for table `contact_person` */

DROP TABLE IF EXISTS `contact_person`;

CREATE TABLE `contact_person` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LASNTNAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MANUFACTURER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CONTACT_PERSON_MANUFACTURER_ID` (`MANUFACTURER_ID`),
  CONSTRAINT `FK_CONTACT_PERSON_MANUFACTURER_ID` FOREIGN KEY (`MANUFACTURER_ID`) REFERENCES `manufacturer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `contact_person` */

/*Table structure for table `gen_id` */

DROP TABLE IF EXISTS `gen_id`;

CREATE TABLE `gen_id` (
  `PK_GEN` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `VALUE_GEN` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`PK_GEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `gen_id` */

insert  into `gen_id`(`PK_GEN`,`VALUE_GEN`) values 
('TBL_MANUFACTURER',3);

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CITY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MANUFACTURER_CITY_ID` (`CITY_ID`),
  CONSTRAINT `FK_MANUFACTURER_CITY_ID` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `manufacturer` */

insert  into `manufacturer`(`ID`,`NAME`,`CITY_ID`) values 
(1,'manufacturer-3',11002),
(2,'manufacturer-5',11006);

/*Table structure for table `product_category` */

DROP TABLE IF EXISTS `product_category`;

CREATE TABLE `product_category` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `product_category` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
