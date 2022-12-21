/*
SQLyog Enterprise v13.1.1 (64 bit)
MySQL - 5.7.38-log : Database - javatravel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javatravel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `javatravel`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT '普通管理员' COMMENT '真实名字',
  `password` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `state` int(20) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`username`,`name`,`password`,`phone`,`state`) values 
(1,'root','超级管理员','123456','18818985683',1),
(2,'admin','管理员','123456','18818985683',1),
(7,'admin2','管理员二号','123456','18818985683',1),
(8,'admin3','管理员三号','123456','18818985683',0),
(12,'admin12','普通管理员','123',NULL,1),
(13,'admin13','普通管理员','123',NULL,1);

/*Table structure for table `t_article` */

DROP TABLE IF EXISTS `t_article`;

CREATE TABLE `t_article` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文章题目',
  `author` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '作者',
  `content` varchar(250) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文章内容',
  `time` datetime DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `t_article` */

insert  into `t_article`(`id`,`title`,`author`,`content`,`time`) values 
(1,'秘境阿里 你是我的诗和远方','管理员','这里是一处让我向往已久的远方，它叫 阿里 ，地处在 西藏 西部，号称天上 阿里 ，这里是世界屋脊的屋脊，是高原之上的高原，它是万山之祖，也是百川之源，有遥远的地球第三极之称，平均海拔在4500米以上，那些在其他地方难得一见的五六千米以上的高山，在这里你可以随处可见，就像我们平常所见的一个个小山峰，如果这个季节你不知道去哪里旅行好，那就去圣洁纯美的 阿里 吧','2022-12-08 12:18:10'),
(2,'火遍全网！深圳仙湖植物园随手就能拍出ins风大片','管理员','没错，它就是超火的拍照圣地仙湖植物园，之前有妹子问怎样拍照才显得好看，今天，二毛和大丸子冒着炎炎热日，扛着相机，为各位亲自体验了一把，拍照攻略来咯，小主们准备好笔记了吗？森女系大片，所以衣服尽量选择田园风，可以穿鲜艳或者清新一点的衣服去。比如大丸子就挑了黄色和白色，衬托绿色背影就很容易拍出大片的感觉。','2022-12-09 16:21:40');

/*Table structure for table `t_hotel` */



/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `name` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真实名字',
  `password` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  `state` int(1) DEFAULT NULL COMMENT '状态',
  `province` int(30) DEFAULT NULL COMMENT '省份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`name`,`password`,`phone`,`state`,`province`) values 
(1,'小明','黎明','123456','18818985683',1,1),
(4,'小兵','刘兵','vLB2etCEahatZy8','18818985684',1,10),
(5,'小东','刘强东','123456','18818985683',1,3),
(6,'小马','马云','123456','18818985683',1,13);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `MobName` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系人显示的名字',
  `UserName` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系人的名字',
  `nickname` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系人的昵称',
  `phone` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系人的电话',
  `register` tinyint(4) NOT NULL COMMENT '是1否0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`id`,`MobName`,`UserName`,`nickname`,`phone`,`register`) values 
(1,'小三','张三','三哥','13123232323',1),
(2,'四弟','李四','阿肆','15356739929',1),
(3,'五天','王五','小五','15555555555',1),
(4,'玉圆环','杨玉洁','小玉','13145357896',1),
(5,'余力','于大力','大力','15467889192',0),
(6,'和虎','陈虎','阿虎','15545656655',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
