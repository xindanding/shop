/*
MySQL Data Transfer
Source Host: localhost
Source Database: myshop
Target Host: localhost
Target Database: myshop
Date: 2021/7/17 15:56:26
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for provider
-- ----------------------------
CREATE TABLE `provider` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `providerNo` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商编号',
  `providerName` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商名称',
  `address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '联系地址',
  `cellPhone` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '座机号',
  `status` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '状态 1.删除 0.使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `provider` VALUES ('2', '1', '1', '1', '13047224083', '1', null);
