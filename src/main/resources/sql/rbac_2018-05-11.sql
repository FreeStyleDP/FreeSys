# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.19)
# Database: rbac
# Generation Time: 2018-05-11 00:23:05 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `name` varchar(50) DEFAULT NULL COMMENT '菜单显示名字',
  `parentName` varchar(50) DEFAULT NULL COMMENT '父菜单',
  `order` int(11) DEFAULT NULL COMMENT '排列序号',
  `id` varchar(50) NOT NULL,
  `icon` varchar(100) DEFAULT NULL COMMENT '图标地址',
  `parentOrder` int(11) DEFAULT NULL COMMENT '父菜单排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '权限id',
  `desc` varchar(50) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;

INSERT INTO `permission` (`id`, `desc`)
VALUES
	('/role',NULL),
	('/role/add',NULL),
	('/role/select',NULL),
	('/user',NULL),
	('/user/add',NULL),
	('/user/delete',NULL),
	('/user/select',NULL),
	('/user/update',NULL);

/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '角色id',
  `desc` varchar(50) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`id`, `desc`)
VALUES
	('manager','管理员'),
	('superManager','超级管理员'),
	('user1','一级用户'),
	('user2','二级用户');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `role_id` varchar(50) NOT NULL DEFAULT '' COMMENT '角色id',
  `permission_id` varchar(50) NOT NULL DEFAULT '' COMMENT '权限id',
  UNIQUE KEY `role_id` (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;

INSERT INTO `role_permission` (`role_id`, `permission_id`)
VALUES
	('manager','/user'),
	('superManager','/role'),
	('superManager','/user'),
	('user1','/user/select'),
	('user2','/user/update');

/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名字',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '0:男 1:女 2:不详',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `name`, `password`, `sex`)
VALUES
	('a','a','123',0),
	('b','b','123',0),
	('c','c','123',0),
	('dp','dp','123',0);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户id',
  `role_id` varchar(50) NOT NULL DEFAULT '' COMMENT '角色id',
  KEY `user_id` (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;

INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES
	('a','manager'),
	('b','user1'),
	('c','user2'),
	('dp','superManager');

/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
