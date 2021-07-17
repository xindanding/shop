/*
MySQL Data Transfer
Source Host: localhost
Source Database: myshop
Target Host: localhost
Target Database: myshop
Date: 2021/7/17 15:56:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for purchase
-- ----------------------------
CREATE TABLE `purchase` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '订单编号',
  `orderName` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '订单名称',
  `providerNo` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商编号',
  `providerName` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商名称',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `amount` int(10) DEFAULT NULL COMMENT '数量',
  `totalPrice` decimal(10,0) DEFAULT NULL COMMENT '总价',
  `payStatus` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '支付状态 1.已支付 0.未支付',
  `orderDate` date DEFAULT NULL COMMENT '订单日期',
  `comments` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `status` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '1 删除  0 使用中',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `purchase` VALUES ('1', 'P0011', '11', '1', '1', '2', '2', '4', '1', '2021-07-15', '111', '0');
INSERT INTO `purchase` VALUES ('2', '11111', '11111', '1', '1', '0', '0', '0', '0', '2021-07-25', '11', '1');
