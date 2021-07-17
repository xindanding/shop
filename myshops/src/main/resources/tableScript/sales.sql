/*
MySQL Data Transfer
Source Host: localhost
Source Database: myshop
Target Host: localhost
Target Database: myshop
Date: 2021/7/17 15:57:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sales
-- ----------------------------
CREATE TABLE `sales` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `saleNo` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '订单编号',
  `custNo` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '客户编号',
  `custName` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '客户名称',
  `saleName` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '订单名称',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `totalprice` decimal(10,0) DEFAULT NULL COMMENT '总价',
  `paystatus` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '支付状态 1.已支付 2.待支付',
  `comments` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `status` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '状态 1.删除 0.使用',
  `saleDate` date DEFAULT NULL COMMENT '交易日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sales` VALUES ('1', 'S001', 'C002', '周星驰', '证件打印', '1', '100', '100', '1', '客户决定年底一起结账', '1', '2021-05-31');
INSERT INTO `sales` VALUES ('2', 'S005', 'C002', '周星驰', 's', '0', '0', '0', '0', 'fds', '0', '2021-07-03');
INSERT INTO `sales` VALUES ('3', '321', 'C002', '周星驰', '321', '0', '0', '0', '0', '321', '0', '2021-07-03');
