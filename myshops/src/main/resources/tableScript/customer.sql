/*
MySQL Data Transfer
Source Host: localhost
Source Database: myshop
Target Host: localhost
Target Database: myshop
Date: 2021/7/17 15:55:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for customer
-- ----------------------------
CREATE TABLE `customer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `custNo` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '客户编号',
  `custName` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '客户姓名',
  `address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '联系地址',
  `cellPhone` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '座机号',
  `status` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '1.合作中 0.终止合作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `customer` VALUES ('5', 'C005', '吴奇隆', '台湾', '15373260344', '55555555', '1');
INSERT INTO `customer` VALUES ('7', 'C002', '周星驰', '香港', '15273260355', '88888888', '1');
INSERT INTO `customer` VALUES ('9', 'C003', '赵子龙', '常山', '13142872035', '', '1');
