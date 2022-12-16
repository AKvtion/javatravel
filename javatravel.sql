-- ************************************************************
--
-- close fk
--
-- skip


-- MySQL dump 10.13  Distrib 5.7.35, for Linux (x86_64)
--
-- Host: 9.235.44.39    Database: javatravel
-- ------------------------------------------------------
-- Server version	5.7.18-cynos-log

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
-- Table structure for table `t_article`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_article` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文章题目',
  `author` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '作者',
  `content` varchar(250) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文章内容',
  `time` datetime DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_article`
--

/*!40000 ALTER TABLE `t_article` DISABLE KEYS */;
INSERT INTO `t_article` VALUES (1,'秘境阿里，你是我的诗和远方123123','管理员','这里是一处让我向往已久的远方，它叫 阿里 ，地处在 西藏 西部，号称天上 阿里 ，这里是世界屋脊的屋脊，是高原之上的高原，它是万山之祖，也是百川之源，有遥远的地球第三极之称，平均海拔在4500米以上，那些在其他地方难得一见的五六千米以上的高山，在这里你可以随处可见，就像我们平常所见的一个个小山峰，如果这个季节你不知道去哪里旅行好，那就去圣洁纯美的 阿里 吧','2022-12-09 16:18:10'),(2,'火遍全网！深圳仙湖植物园随手就能拍出ins风大片','管理员','没错，它就是超火的拍照圣地仙湖植物园，之前有妹子问怎样拍照才显得好看，今天，二毛和大丸子冒着炎炎热日，扛着相机，为各位亲自体验了一把，拍照攻略来咯，小主们准备好笔记了吗？森女系大片，所以衣服尽量选择田园风，可以穿鲜艳或者清新一点的衣服去。比如大丸子就挑了黄色和白色，衬托绿色背影就很容易拍出大片的感觉。','2022-12-09 16:21:40'),(5,'文旅部：娱乐场所和旅游景区均不再要求查验核酸和健康码','管理员','12月9日下午，文化和旅游部对相关疫情防控工作指南再次进行了调整更新，发布了新版旅游景区、旅行社、互联网上网服务营业场所、娱乐场所、剧院等演出场所、剧本娱乐经营场所新冠肺炎疫情防控工作指南，按照国务院联防联控机制综合组优化落实疫情防控新十条，除对导游上团前核验健康码外，相关指南均不再要求提供核酸检测阴性证明、查验健康码、开展落地检。','2022-12-10 06:21:40'),(6,'防疫“新十条”发布  旅游市场或迎重要转折点','管理员','“从整体来看，此次政策的发布增强了大家出行出游的信心，但不可忽视的是，目前疫情防控形势依然严峻复杂，国内出行、文旅行业仍面临一些挑战。”去哪儿大数据研究员对中国商报记者表示。  “‘新十条’对旅游、服务、零售行业是一个很强的利好信号，行业的转向迹象已经非常明显。不过，疫情的影响可能会再持续一段时间，等到明年春季时，旅游等行业的常态化发展就可以见端倪了。”北京联合大学在线旅游研究中心主任杨彦锋告诉记者。','2022-12-11 10:21:40'),(7,'世界旅游组织：把旅游打造成更包容可持续行业','管理员','11月30日电 日前，联合国世界旅游组织第117次执行委员会会议在摩洛哥马拉喀什召开。会议聚焦如何通过创新、投资、教育促进旅游业转型发展，同时强调了旅游业在应对气候变化以及在促进农村地区发展中的重要作用。  联合国世界旅游组织秘书长祖拉布·波洛利卡什维利表示，当前，旅游业正面临着转型升级的重要机遇，要不失时机地把旅游业打造成更加包容、可持续和有韧性的行业。他同时指出，现在已经不是用数量衡量旅游业发展是否成功的时候了，而是要更多关注旅游业在增进民生福祉和生态环境保护等方面的重要性。','2022-12-11 10:21:40');
/*!40000 ALTER TABLE `t_article` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-16 11:10:15
-- ************************************************************
--
-- close fk
--
-- skip


-- MySQL dump 10.13  Distrib 5.7.35, for Linux (x86_64)
--
-- Host: 9.235.44.39    Database: javatravel
-- ------------------------------------------------------
-- Server version	5.7.18-cynos-log

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
-- Table structure for table `t_user`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `name` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真实名字',
  `password` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  `state` int(1) DEFAULT NULL COMMENT '状态',
  `province` int(30) DEFAULT NULL COMMENT '省份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'小明','黎明','123456','18818985683',1,1),(4,'小兵','刘兵','vLB2etCEahatZy8','18818985684',1,10),(5,'小东','刘强东','123456','18818985683',1,3),(6,'小马','马云','123456','18818985683',1,13),(7,'小龙','剑池龙','123456789','18818985683',1,23),(10,'小群','刘群','123456','18818985683',1,26),(11,'小德','李德','123456','18818985683',1,3),(12,'小泽','张泽','123456','18818985683',1,4),(13,'小萧','萧敬腾','123456','18818985683',1,5),(14,'小木','榆木','123456','18818985683',1,8);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-16 11:10:15
-- ************************************************************
--
-- close fk
--
-- skip


-- MySQL dump 10.13  Distrib 5.7.35, for Linux (x86_64)
--
-- Host: 9.235.44.39    Database: javatravel
-- ------------------------------------------------------
-- Server version	5.7.18-cynos-log

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
-- Table structure for table `t_admin`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真实名字',
  `password` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `state` int(20) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` VALUES (1,'root','超级管理员','123456','18818985683',1),(2,'admin1','上官婉儿','123456','18818985683',1),(7,'admin2','荆轲','123456','18818985683',1),(8,'admin3','黄忠','123456','18818985683',0),(9,'admin4','管理员','123456','18818985683',1);
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-16 11:10:15
