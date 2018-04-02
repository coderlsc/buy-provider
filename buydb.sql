/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : buydb

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-04-02 18:37:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `purchaser`
-- ----------------------------
DROP TABLE IF EXISTS `purchaser`;
CREATE TABLE `purchaser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(32) NOT NULL,
  `short_name` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `password` varchar(32) NOT NULL,
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `status` char(1) NOT NULL COMMENT '用户状态 1-正常2-冻结 3-注销',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaser
-- ----------------------------
INSERT INTO `purchaser` VALUES ('1', '1212', '12', '1061365819@qq.com', '13865278507', '111111', 'admin', '2018-03-30 18:19:26', 'admin', '2018-03-30 18:19:26', '0');
INSERT INTO `purchaser` VALUES ('2', '121212', '12122112', '1212@163.com', '13865278506', '111111', 'admin', '2018-03-30 18:22:52', 'admin', '2018-03-30 18:22:52', '0');
INSERT INTO `purchaser` VALUES ('3', 'ssds', 'sdsd', '1061365819@qq.com', '13865278508', '222222', 'admin', '2018-03-30 18:23:15', 'admin', '2018-03-30 18:23:15', '0');
INSERT INTO `purchaser` VALUES ('4', '2123', '123', '1061365819@qq.com', '13865278509', '111111', 'admin', '2018-03-31 17:18:14', 'admin', '2018-03-31 17:18:14', '0');
INSERT INTO `purchaser` VALUES ('5', 'sadad', 'asdsad', '1061365819@qq.com', '13865278500', '111111', 'admin', '2018-04-01 22:07:54', 'admin', '2018-04-01 22:07:54', '0');
INSERT INTO `purchaser` VALUES ('6', 'weewe', 'we', '1061365819@qq.com', '13865278508', '111111', 'admin', '2018-04-01 22:11:20', 'admin', '2018-04-01 22:11:20', '0');
INSERT INTO `purchaser` VALUES ('7', 'weewe', 'we', '1061365819@qq.com', '13865278508', '111111', 'admin', '2018-04-01 22:28:17', 'admin', '2018-04-01 22:28:17', '0');
INSERT INTO `purchaser` VALUES ('8', '1212', '12122112', '1061365819@qq.com', '13544444444', '111111', 'admin', '2018-04-01 22:29:10', 'admin', '2018-04-01 22:29:10', '0');
INSERT INTO `purchaser` VALUES ('9', '测试信息认证', '测试信息认证', '1061365819@qq.com', '13865278523', '111111', 'admin', '2018-04-01 22:37:54', 'admin', '2018-04-01 22:37:54', '0');
INSERT INTO `purchaser` VALUES ('10', '测试信息认证2', '测试信息认证2', '1061365819@qq.com', '13544444456', '111111', 'admin', '2018-04-01 22:41:47', 'admin', '2018-04-01 22:41:47', '0');
INSERT INTO `purchaser` VALUES ('11', '测试信息认证', '测试信息认证', '1061365819@qq.com', '13522222222', '111111', 'admin', '2018-04-01 22:47:09', 'admin', '2018-04-01 22:47:09', '0');
INSERT INTO `purchaser` VALUES ('12', '测试信息认证', '测试信息认证', '1061365819@qq.com', '13533333333', '111111', 'admin', '2018-04-01 22:49:30', 'admin', '2018-04-01 22:49:30', '0');
INSERT INTO `purchaser` VALUES ('13', '测试信息认证3', '测试信息认证3', '1061365819@qq.com', '13555555555', '111111', 'admin', '2018-04-02 16:10:21', 'admin', '2018-04-02 16:10:21', '0');
INSERT INTO `purchaser` VALUES ('14', '注册测试', '注册测试', '1061365819@qq.com', '13865278506', '111111', 'admin', '2018-04-02 16:18:44', 'admin', '2018-04-02 16:18:44', '0');
INSERT INTO `purchaser` VALUES ('15', '111', '11123111', '1061365819@qq.com', '13544477777', '222222', 'admin', '2018-04-02 16:20:14', 'admin', '2018-04-02 16:20:14', '0');
INSERT INTO `purchaser` VALUES ('16', '13', '131', '1061365819@qq.com', '13865278512', '111111', 'admin', '2018-04-02 16:33:16', 'admin', '2018-04-02 16:33:16', '0');
INSERT INTO `purchaser` VALUES ('17', '请二位', 'QEQW', '1212@163.com', '13865278544', '111111', 'admin', '2018-04-02 16:35:13', 'admin', '2018-04-02 16:35:13', '0');
INSERT INTO `purchaser` VALUES ('18', 'qweq', 'qweq', '1061365819@qq.com', '13865222222', '222222', 'admin', '2018-04-02 16:38:00', 'admin', '2018-04-02 16:38:00', '0');
INSERT INTO `purchaser` VALUES ('19', 'qwe', 'qweq', '1061365819@qq.com', '13865273333', '111111', 'admin', '2018-04-02 16:42:24', 'admin', '2018-04-02 16:42:24', '0');
INSERT INTO `purchaser` VALUES ('20', 'ssdsasd', 'asda', '1212@163.com', '13865278566', '111111', 'admin', '2018-04-02 16:50:10', 'admin', '2018-04-02 16:50:10', '0');
INSERT INTO `purchaser` VALUES ('21', '去问我去', 'wqe', '1061365819@qq.com', '13865278123', '111111', 'admin', '2018-04-02 17:06:58', 'admin', '2018-04-02 17:06:58', '0');
INSERT INTO `purchaser` VALUES ('22', 'qwe', 'qweq', '1061365819@qq.com', '13865278588', '111111', 'admin', '2018-04-02 17:19:16', 'admin', '2018-04-02 17:19:16', '0');
INSERT INTO `purchaser` VALUES ('23', 'qwe', 'qweq', '1061365819@qq.com', '13865278506', '111111', 'admin', '2018-04-02 17:25:43', 'admin', '2018-04-02 17:25:43', '0');
INSERT INTO `purchaser` VALUES ('24', 'qwe', 'qqq', '1061365819@qq.com', '13433333333', '111111', 'admin', '2018-04-02 17:27:23', 'admin', '2018-04-02 17:27:23', '0');
INSERT INTO `purchaser` VALUES ('25', '往前嗯', '券额', '1061365819@qq.com', '13865278500', '111111', 'admin', '2018-04-02 17:30:05', 'admin', '2018-04-02 17:30:05', '0');
INSERT INTO `purchaser` VALUES ('26', 'qwe', 'qweq', '1061365819@qq.com', '13865278144', '111111', 'admin', '2018-04-02 17:58:51', 'admin', '2018-04-02 17:58:51', '0');
INSERT INTO `purchaser` VALUES ('27', '111', '12122112', '1061365819@qq.com', '13865278007', '111111', 'admin', '2018-04-02 18:13:45', 'admin', '2018-04-02 18:13:45', '0');
INSERT INTO `purchaser` VALUES ('28', '13', '12122112', '1061365819@qq.com', '13865278666', '111111', 'admin', '2018-04-02 18:15:52', 'admin', '2018-04-02 18:15:52', '0');
INSERT INTO `purchaser` VALUES ('29', 'qweqe', 'qweqwe', '1061365819@qq.com', '13865278555', '111111', 'admin', '2018-04-02 18:23:14', 'admin', '2018-04-02 18:23:14', '0');
INSERT INTO `purchaser` VALUES ('30', 'qweqe', 'qweqwe', '1061365819@qq.com', '13865278555', '111111', 'admin', '2018-04-02 18:24:25', 'admin', '2018-04-02 18:24:25', '0');
INSERT INTO `purchaser` VALUES ('31', 'qweqe', 'qweqwe', '1061365819@qq.com', '13865278555', '111111', 'admin', '2018-04-02 18:24:30', 'admin', '2018-04-02 18:24:30', '0');

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `company_name` varchar(32) NOT NULL,
  `short_name` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `password` varchar(32) NOT NULL,
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `status` char(1) NOT NULL COMMENT '用户状态 1-正常2-冻结 3-注销',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', 'c1', 'c1', '1061365819@qq.com', '15688878453', '123456', 'admin', '2018-03-26 11:46:07', 'admin', '2018-03-26 11:46:10', '0');
