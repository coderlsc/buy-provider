/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : buydb

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-05-02 21:08:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `image_resource`
-- ----------------------------
DROP TABLE IF EXISTS `image_resource`;
CREATE TABLE `image_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `resource_type` char(1) NOT NULL COMMENT '资源类别 1:图片 2：视频 ',
  `resource_width` int(11) DEFAULT NULL COMMENT '图片宽度',
  `resource_height` int(11) DEFAULT NULL COMMENT '图片高度',
  `resource_name` varchar(100) NOT NULL COMMENT '资源名称',
  `resource_new_name` varchar(100) NOT NULL COMMENT '资源上传后名称',
  `resource_upload_patch` varchar(200) NOT NULL COMMENT '资源上传路径',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image_resource
-- ----------------------------
INSERT INTO `image_resource` VALUES ('1', '1', '100', '100', '测试资源1', '测试新资源名称', '/D:/test1/testFile', 'admin', '2018-01-01 15:27:22', 'admin', '2018-01-23 15:27:25');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` bigint(20) NOT NULL COMMENT '商品id，同时也是商品编号',
  `title` varchar(100) NOT NULL COMMENT '商品标题',
  `sell_point` varchar(500) DEFAULT NULL COMMENT '商品卖点',
  `price` bigint(20) NOT NULL COMMENT '商品价格，单位为：分',
  `num` int(10) NOT NULL COMMENT '库存数量',
  `barcode` varchar(30) DEFAULT NULL COMMENT '商品条形码',
  `image` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `cid` bigint(10) NOT NULL COMMENT '所属类目，叶子类目',
  `status` varchar(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', 'new2 - 阿尔卡特 (OT-927) 炭黑 联通3G手机 双卡双待', '清仓！仅北京，武汉仓有货！', '29900000', '99999', '', 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '2', '1', '2015-03-08 21:33:18', '2015-04-11 20:38:38', 'admin', 'admin');
INSERT INTO `item` VALUES ('2', 'new8- 三星 W999 黑色 电信3G手机 双卡双待双通', '下单送12000毫安移动电源！双3.5英寸魔焕炫屏，以非凡视野纵观天下时局，尊崇翻盖设计，张弛中，尽显从容气度！', '1100', '99999', '', 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '2', '1', '2015-03-08 21:27:54', '2015-04-12 17:10:43', 'admin', 'admin');
INSERT INTO `item` VALUES ('3', '阿尔卡特 (OT-927) 单电版 炭黑 联通3G手机 双卡双待', '清仓！仅北京，武汉仓有货！', '24900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:33:18', '2015-03-08 21:33:18', 'admin', 'admin');
INSERT INTO `item` VALUES ('4', '阿尔卡特 (OT-986+) 玫红 AK47 加强版 联通3G手机', '仅上海，广州，沈阳仓有货！预购从速！', '49900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:32:31', '2015-03-08 21:32:31', 'admin', 'admin');
INSERT INTO `item` VALUES ('5', '阿尔卡特 (OT-986+) 曜石黑 AK47 加强版 联通3G手机', '少量库存，抢完即止！<a  target=\"blank\"  href=\"http://sale.jd.com/act/bxYeI1346g.html?erpad_source=erpad\">“领券更优惠！”</a>', '49900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:31:36', '2015-03-08 21:31:36', 'admin', 'admin');
INSERT INTO `item` VALUES ('6', '三星 B9120 钛灰色 联通3G手机 双卡双待双通', '下单即送10400毫安移动电源！再赠手机魔法盒！', '439900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:29:27', '2015-03-08 21:29:27', 'admin', 'admin');
INSERT INTO `item` VALUES ('7', '三星 Note II (N7100) 云石白 联通3G手机', '经典回顾！超值价格值得拥有。', '169900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:16', '2015-03-08 21:28:16', 'admin', 'admin');
INSERT INTO `item` VALUES ('8', '三星 Note II (N7100) 钛金灰 联通3G手机', '下单赠12000毫安移动电源', '169900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:30', '2015-03-08 21:28:30', 'admin', 'admin');
INSERT INTO `item` VALUES ('9', '三星 Note II (N7100) 钻石粉 联通3G手机', '经典回顾！超值特惠！', '169900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:44', '2015-03-08 21:28:44', 'admin', 'admin');
INSERT INTO `item` VALUES ('10', '夏普（SHARP）LCD-46DS40A 46英寸 日本原装液晶面板 智能全高清液晶电视', '要好屏，选夏普！日本原装面板，智能电视，高画质高音质！<a  target=\"blank\"  href=\"http://item.jd.com/1278686.html\">还有升级版安卓智能新机46DS52供您选择！</a>', '379900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '76', '1', '2015-03-08 21:27:39', '2015-03-08 21:27:39', 'admin', 'admin');
INSERT INTO `item` VALUES ('11', '飞利浦 老人手机 (X2560) 深情蓝 移动联通2G手机 双卡双待', '赠：九安血压计+8G内存！超长待机，关爱无限，更好用！飞利浦简单健康老人手机！外观圆滑，手感极佳！', '48900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:30', '2015-03-08 21:28:30', 'admin', 'admin');
INSERT INTO `item` VALUES ('12', '中兴 U288 珠光白 移动3G手机', '好评过万！超大彩屏，超大字体，超大按键，超大音量，一键SOS紧急呼叫 ！', '19900', '99999', '', 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:44', '2015-03-08 21:28:44', 'admin', 'admin');
INSERT INTO `item` VALUES ('13', '三星 SCH-W899 亮金色 电信3G手机 双卡双待双通', '双3.3英寸魔焕炫屏，CG双网双待，臻尊体验，心系天下！', '299900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:01', '2015-03-08 21:28:01', 'admin', 'admin');
INSERT INTO `item` VALUES ('14', '飞利浦 老人手机 (X2560) 喜庆红 移动联通2G手机 双卡双待', '超长待机，关爱无限，更好用！飞利浦简单健康老人手机！外观圆滑，手感极佳！', '48900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:30', '2015-03-08 21:28:30', 'admin', 'admin');
INSERT INTO `item` VALUES ('15', '飞利浦 老人手机 (X2560) 硬朗黑 移动联通2G手机 双卡双待', '超长待机，关爱无限，更好用！飞利浦简单健康老人手机！外观圆滑，手感极佳！', '46900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:09', '2015-03-08 21:28:09', 'admin', 'admin');
INSERT INTO `item` VALUES ('16', '三星 Galaxy S4 (I9500)16G版 皓月白 联通3G手机', '三星经典旗舰机！5英寸1080P高清屏+1300万像素主摄像头！', '188800', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:42', '2015-03-08 21:27:42', 'admin', 'admin');
INSERT INTO `item` VALUES ('17', '三星 Galaxy S4 (I9500) 16G版 星空黑 联通3G手机', '年货特价来袭！三星经典旗舰机！', '188800', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:54', '2015-03-08 21:27:54', 'admin', 'admin');
INSERT INTO `item` VALUES ('18', '三星 I8552 白色 联通3G手机 双卡双待', '经济实惠机器~~开春入手好时机~', '79900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:49', '2015-03-08 21:27:49', 'admin', 'admin');
INSERT INTO `item` VALUES ('19', '长虹（CHANGHONG） 3D51C1080i 51英寸 快门式3D智能Android 电视（黑色）', '智能安卓系统 可自由安装应用程序 <a  target=\"blank\"  href=\"http://sale.jd.com/act/Kt0aHzbU7uR1M.html\">“点击进入长虹新年专场”</a>', '269900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '76', '1', '2015-03-08 21:27:35', '2015-03-08 21:27:35', 'admin', 'admin');
INSERT INTO `item` VALUES ('20', 'LG 47LA6800-CA 47英寸 全高清智能3D液晶电视 （红色）', '【疯狂清仓】无边框硬屏，不闪式3D技术，动感应遥控器，“船”型底座设计！仅北京、沈阳、深圳有货！', '999900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '76', '1', '2015-03-08 21:29:12', '2015-03-08 21:29:12', 'admin', 'admin');
INSERT INTO `item` VALUES ('21', '诺基亚(NOKIA) 1050 (RM-908) 黑色 移动联通2G手机', '经典神器，简单实用,超长待机，更多色彩！', '14900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:49', '2015-03-08 21:27:49', 'admin', 'admin');
INSERT INTO `item` VALUES ('22', '诺基亚(NOKIA) 1050 (RM-908) 蓝色 移动联通2G手机', '经典神器，简单实用,超长待机，更多色彩！', '14900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:54', '2015-03-08 21:27:54', 'admin', 'admin');
INSERT INTO `item` VALUES ('23', '联想 MA388 老人手机 星夜黑 移动联通2G手机 双卡双待', '孝敬爸妈首选，好评超22000条，大按键 大喇叭 大翻盖，配置1900mAh大容量电池，带来超长续航体验！', '28700', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:49', '2015-03-08 21:27:49', 'admin', 'admin');
INSERT INTO `item` VALUES ('24', '海信（Hisense）LED42EC260JD 42英寸 窄边网络 LED电视（黑色）', '<a  target=\"blank\"  href=\"http://sale.jd.com/act/YykdEtrMRaSsT.html\">“春宵一刻值千金”</a>', '229900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '76', '1', '2015-03-08 21:27:35', '2015-03-08 21:27:35', 'admin', 'admin');
INSERT INTO `item` VALUES ('25', '酷派 8076D 咖啡棕 移动3G手机 双卡双待', '4.0英寸屏幕，双核处理器！移动用户无需换号，直接尊享3G网络！', '19900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:29:19', '2015-03-08 21:29:19', 'admin', 'admin');
INSERT INTO `item` VALUES ('26', '创维(Skyworth)LED 42E5DHR 42英寸 海量影视资源智能网络平板液晶电视二代升级版(黑色)', '二代新品！！智能双系统，正版影视随心看，丰富安卓应用，多屏互动！<a  target=\"blank\"  href=\"http://jmall.jd.com/p117514.html\">“猛戳这里，更多惊喜”</a>', '249900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '76', '1', '2015-03-08 21:27:39', '2015-03-08 21:27:39', 'admin', 'admin');
INSERT INTO `item` VALUES ('27', '联想 P780 极速版 深邃黑 联通3G手机 双卡双待', '待机王，5吋HD高清炫屏，9.9mm锐薄机身，背壳全金属材质，独创智恒省电技术！', '69900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:09', '2015-03-08 21:28:09', 'admin', 'admin');
INSERT INTO `item` VALUES ('28', '华为 P6 (P6-C00) 黑 电信3G手机 双卡双待双通', '经典旗舰！雅然天成纤薄之美，强悍四核，前置500万美颜自拍,，2GB RAM+16GB ROM大内存！<a  target=\"blank\"  href=\"http://sale.jd.com/act/0akd8u5vomz.html\">【买卡上京东，省钱又轻松】点击有惊喜！</a>', '128800', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:42', '2015-03-08 21:27:42', 'admin', 'admin');
INSERT INTO `item` VALUES ('29', '华为 P6 (P6-C00) 白 电信3G手机 双卡双待双通', '经典旗舰，万人好评！强悍四核，前置500万美颜自拍,，2GB RAM+16GB ROM大内存！', '129900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:37', '2015-03-08 21:27:37', 'admin', 'admin');
INSERT INTO `item` VALUES ('30', '华为 P6-C00 电信3G手机（粉色） CDMA2000/GSM 双模双待双通', '情人节神器！粉色机身，女神必备！数量有限前置500万美颜自拍，后置800万，非常适合喜欢拍照的你！', '134900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:54', '2015-03-08 21:27:54', 'admin', 'admin');
INSERT INTO `item` VALUES ('31', '华为 Ascend P6 (P6-T00) 黑色 移动3G手机', '限时特价！好评过万条优秀产品！浑然天成纤薄机身，前置500w摄像头，2GB RAM,1.5GHz四核cpu！ <a  target=\"blank\"  href=\"http://sale.jd.com/act/ZovfiDKYagBQJ.html\">更多推荐请点击！</a>', '128900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:27:37', '2015-03-08 21:27:37', 'admin', 'admin');
INSERT INTO `item` VALUES ('32', '三星 Galaxy S4 (I9502) 16G版 蓝色 联通3G手机 双卡双待双通', '三星经典旗舰机！5英寸1080P高清屏+双四核分时CUP+2GB RAM+1300万像素主摄像头', '189900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:01', '2015-03-08 21:28:01', 'admin', 'admin');
INSERT INTO `item` VALUES ('33', '海尔统帅（Leader）LE39MUF5 39英寸 MHL传屏 LED平板电视（黑色）', '好评率96%！MHL传屏，内附价值99元的MHL传屏线哦~独家免费带货安装调试一步到位！', '199900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '76', '1', '2015-03-08 21:29:12', '2015-03-08 21:29:12', 'admin', 'admin');
INSERT INTO `item` VALUES ('34', '三星 I8558 白色 移动3G手机 双卡双待', '4.7英寸屏，四核，500万像素！移动用户无需换号，直接享3G网络！', '75900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:16', '2015-03-08 21:28:16', 'admin', 'admin');
INSERT INTO `item` VALUES ('35', '飞利浦 (X1560) 黑色+香槟色 移动联通2G手机 双卡双待', '畅销！智能机的好伴侣，可以充电的手机！最长可达100天！键盘金属工艺，移动电源功能！', '36900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:16', '2015-03-08 21:28:16', 'admin', 'admin');
INSERT INTO `item` VALUES ('36', '夏普（SHARP）LCD-52DS70A 52英寸 日本原装液晶面板 3D Android操作系统智能液晶电视', '安卓体感3D超强机！日本原装液晶屏 安卓智能 体感遥控器 智能语音 无线上网！<a  target=\"blank\"  href=\"http://item.jd.com/1134535.html\">还有外观炫酷的50英寸50DS60供您选择！</a>', '699900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '76', '1', '2015-03-08 21:28:00', '2015-03-08 21:28:00', 'admin', 'admin');
INSERT INTO `item` VALUES ('37', 'TCL L32F3301B 32英寸 窄边蓝光USB播放LED电视(黑色）', '【0元献礼】好评过万，销量传奇！经典蓝光电视，独有自然光技术专利，过大年带最好的回家！<a  target=\"blank\"  href=\"http://sale.jd.com/act/6MqRytIYKfn.html\">【0元白条试用，1001个拜年计划】</a>', '139800', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '76', '1', '2015-03-08 21:27:35', '2015-03-08 21:27:35', 'admin', 'admin');
INSERT INTO `item` VALUES ('38', '三星 Galaxy S4 (I9502) 16G版 粉色 联通3G手机 双卡双待双通', '三星经典旗舰机！5英寸1080P高清屏+双四核分时CUP+2GB RAM+1300万像素主摄像头', '179900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:01', '2015-03-08 21:28:01', 'admin', 'admin');
INSERT INTO `item` VALUES ('39', '三星 I8558 灰色 移动3G手机 双卡双待', '4.7英寸屏，四核，500万像素！移动用户无需换号，直接享3G网络!', '75900', '99999', null, 'http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg,http://p5odlc0yx.bkt.clouddn.com/53a7a9d9-e0d6-4a74-84d0-3b3be214.jpg', '560', '1', '2015-03-08 21:28:55', '2015-03-08 21:28:55', 'admin', 'admin');

-- ----------------------------
-- Table structure for `item_cat`
-- ----------------------------
DROP TABLE IF EXISTS `item_cat`;
CREATE TABLE `item_cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) DEFAULT NULL COMMENT '类目名称',
  `status` int(1) DEFAULT '1' COMMENT '状态。可选值:1(正常),2(删除)',
  `sort_order` int(4) DEFAULT NULL COMMENT '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `is_parent` tinyint(1) DEFAULT '1' COMMENT '该类目是否为父类目，1为true，0为false',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`,`status`) USING BTREE,
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品类目';

-- ----------------------------
-- Records of item_cat
-- ----------------------------
INSERT INTO `item_cat` VALUES ('1', '1', '测试父级类目1', '1', '1', '1', '2018-05-01 11:16:14', '2018-05-01 11:16:18');
INSERT INTO `item_cat` VALUES ('2', '1', '测试子类目1', '1', '1', '1', '2018-05-01 11:16:14', '2018-05-01 11:16:18');
INSERT INTO `item_cat` VALUES ('3', '1', '测试子类目2', '1', '1', '1', '2018-05-01 11:16:14', '2018-05-01 11:16:14');

-- ----------------------------
-- Table structure for `item_desc`
-- ----------------------------
DROP TABLE IF EXISTS `item_desc`;
CREATE TABLE `item_desc` (
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `item_desc` text COMMENT '商品描述',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品描述表';

-- ----------------------------
-- Records of item_desc
-- ----------------------------
INSERT INTO `item_desc` VALUES ('1', '可以的 很好啊', '2018-05-01 12:37:12', '2018-05-01 12:37:16');
INSERT INTO `item_desc` VALUES ('2', 'nice', '2018-05-01 12:37:12', '2018-05-01 12:37:12');

-- ----------------------------
-- Table structure for `license_resource`
-- ----------------------------
DROP TABLE IF EXISTS `license_resource`;
CREATE TABLE `license_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `resource_type` char(1) NOT NULL COMMENT '资源类别 1:图片 2：视频 ',
  `resource_name` varchar(100) NOT NULL COMMENT '资源名称',
  `resource_new_name` varchar(100) NOT NULL COMMENT '资源上传后名称',
  `resource_upload_patch` varchar(200) NOT NULL COMMENT '资源上传路径',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of license_resource
-- ----------------------------
INSERT INTO `license_resource` VALUES ('1', '1', '测试资源1', '测试新资源名称', '/D:/test1/testFile', 'admin', '2018-01-01 15:27:22', 'admin', '2018-01-23 15:27:25');
INSERT INTO `license_resource` VALUES ('5', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '73e24399-8f4a-44df-92e0-08b42e8f.docx', 'D:/license/73e24399-8f4a-44df-92e0-08b42e8f.docx', 'admin', '2018-04-30 15:15:00', 'admin', '2018-04-30 15:15:00');
INSERT INTO `license_resource` VALUES ('6', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '284b17d1-d905-4b16-b94f-6bb4efc3.docx', 'D:/license/284b17d1-d905-4b16-b94f-6bb4efc3.docx', 'admin', '2018-04-30 15:17:04', 'admin', '2018-04-30 15:17:04');
INSERT INTO `license_resource` VALUES ('7', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '765834d7-98bf-4e3e-a20c-a9b02b73.docx', 'D:/license/765834d7-98bf-4e3e-a20c-a9b02b73.docx', 'admin', '2018-04-30 15:20:58', 'admin', '2018-04-30 15:20:58');
INSERT INTO `license_resource` VALUES ('8', '2', 'SSH(Secure-Shell-Client)常用命令.docx', 'fabdc658-0ab7-435f-824e-9710414e.docx', 'D:/license/fabdc658-0ab7-435f-824e-9710414e.docx', 'admin', '2018-04-30 15:24:37', 'admin', '2018-04-30 15:24:37');
INSERT INTO `license_resource` VALUES ('9', '2', 'SSH(Secure-Shell-Client)常用命令.docx', 'fe2e08e8-22d9-4635-b837-c2684827.docx', 'D:/license/fe2e08e8-22d9-4635-b837-c2684827.docx', 'admin', '2018-04-30 15:27:16', 'admin', '2018-04-30 15:27:16');
INSERT INTO `license_resource` VALUES ('10', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '41bd76f5-906a-4751-a6de-826875f5.docx', 'D:/license/41bd76f5-906a-4751-a6de-826875f5.docx', 'admin', '2018-04-30 15:27:23', 'admin', '2018-04-30 15:27:23');
INSERT INTO `license_resource` VALUES ('11', '2', 'SSH(Secure-Shell-Client)常用命令.docx', 'c0773a98-e2d9-4961-85b8-6b5d20ef.docx', 'D:/license/c0773a98-e2d9-4961-85b8-6b5d20ef.docx', 'admin', '2018-04-30 15:29:18', 'admin', '2018-04-30 15:29:18');
INSERT INTO `license_resource` VALUES ('12', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '4280457a-6814-417c-881f-7a448db5.docx', 'D:/license/4280457a-6814-417c-881f-7a448db5.docx', 'admin', '2018-04-30 15:30:05', 'admin', '2018-04-30 15:30:05');
INSERT INTO `license_resource` VALUES ('13', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '7dc4e88c-70a3-4ace-bebe-f7b2a394.docx', 'D:/license/7dc4e88c-70a3-4ace-bebe-f7b2a394.docx', 'admin', '2018-04-30 15:32:32', 'admin', '2018-04-30 15:32:32');
INSERT INTO `license_resource` VALUES ('14', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '98e0ad2b-cedb-4945-97e1-b0a9b224.docx', 'D:/license/98e0ad2b-cedb-4945-97e1-b0a9b224.docx', 'admin', '2018-04-30 15:32:32', 'admin', '2018-04-30 15:32:32');
INSERT INTO `license_resource` VALUES ('15', '2', 'SSH(Secure-Shell-Client)常用命令.docx', 'a5faa568-3f84-4f2f-83f7-eb1cb3b1.docx', 'D:/license/a5faa568-3f84-4f2f-83f7-eb1cb3b1.docx', 'admin', '2018-04-30 15:34:05', 'admin', '2018-04-30 15:34:05');
INSERT INTO `license_resource` VALUES ('16', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '7a41de37-b081-44d5-836f-cc3b91a4.docx', 'D:/license/7a41de37-b081-44d5-836f-cc3b91a4.docx', 'admin', '2018-04-30 15:34:06', 'admin', '2018-04-30 15:34:06');
INSERT INTO `license_resource` VALUES ('17', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '194ca877-9634-41bd-9fe9-0af53d9e.docx', 'D:/license/194ca877-9634-41bd-9fe9-0af53d9e.docx', 'admin', '2018-04-30 15:37:53', 'admin', '2018-04-30 15:37:53');
INSERT INTO `license_resource` VALUES ('18', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '77bfbda9-4ec8-48db-a1c3-d3079f95.docx', 'D:/license/77bfbda9-4ec8-48db-a1c3-d3079f95.docx', 'admin', '2018-04-30 15:37:53', 'admin', '2018-04-30 15:37:53');
INSERT INTO `license_resource` VALUES ('19', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '60038d17-093f-44e1-8b4b-b16caf50.docx', 'D:/license/60038d17-093f-44e1-8b4b-b16caf50.docx', 'admin', '2018-04-30 15:37:53', 'admin', '2018-04-30 15:37:53');
INSERT INTO `license_resource` VALUES ('20', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '3c7634f9-05de-4a31-92cc-c01333ee.docx', 'D:/license/3c7634f9-05de-4a31-92cc-c01333ee.docx', 'admin', '2018-04-30 22:18:44', 'admin', '2018-04-30 22:18:44');
INSERT INTO `license_resource` VALUES ('21', '2', 'SSH(Secure-Shell-Client)常用命令.docx', 'c240ee7d-745c-49ab-858f-e6c904ff.docx', 'D:/license/c240ee7d-745c-49ab-858f-e6c904ff.docx', 'admin', '2018-04-30 22:18:44', 'admin', '2018-04-30 22:18:44');
INSERT INTO `license_resource` VALUES ('22', '2', 'SSH(Secure-Shell-Client)常用命令.docx', 'e4d44546-ea63-453f-aa18-13111cc5.docx', 'D:/license/e4d44546-ea63-453f-aa18-13111cc5.docx', 'admin', '2018-04-30 22:18:44', 'admin', '2018-04-30 22:18:44');
INSERT INTO `license_resource` VALUES ('23', '2', 'SSH(Secure-Shell-Client)常用命令.docx', 'b478df67-ecf9-4ca1-a249-22e7f5bb.docx', 'D:/license/b478df67-ecf9-4ca1-a249-22e7f5bb.docx', 'admin', '2018-04-30 22:19:47', 'admin', '2018-04-30 22:19:47');
INSERT INTO `license_resource` VALUES ('24', '2', '', '663f6a01-b052-46a6-bcf9-f77cb98a.', 'D:/license/663f6a01-b052-46a6-bcf9-f77cb98a.', 'admin', '2018-04-30 22:19:47', 'admin', '2018-04-30 22:19:47');
INSERT INTO `license_resource` VALUES ('25', '2', '', '27a90e35-15d6-43cd-b982-c39ab33b.', 'D:/license/27a90e35-15d6-43cd-b982-c39ab33b.', 'admin', '2018-04-30 22:19:47', 'admin', '2018-04-30 22:19:47');
INSERT INTO `license_resource` VALUES ('26', '2', '', 'f8bdc7f4-0044-4ee0-b682-fdb67ec8.', 'D:/license/f8bdc7f4-0044-4ee0-b682-fdb67ec8.', 'admin', '2018-04-30 22:22:43', 'admin', '2018-04-30 22:22:43');
INSERT INTO `license_resource` VALUES ('27', '2', '', '8b61ebd3-47bb-4990-9ce8-f9c8576d.', 'D:/license/8b61ebd3-47bb-4990-9ce8-f9c8576d.', 'admin', '2018-04-30 22:22:43', 'admin', '2018-04-30 22:22:43');
INSERT INTO `license_resource` VALUES ('28', '2', '', '02cb1020-2299-4098-859c-b4b464a9.', 'D:/license/02cb1020-2299-4098-859c-b4b464a9.', 'admin', '2018-04-30 22:22:43', 'admin', '2018-04-30 22:22:43');
INSERT INTO `license_resource` VALUES ('29', '2', 'SSH(Secure-Shell-Client)常用命令.docx', 'd5547426-ecab-4f07-a02a-a8c3cb02.docx', 'D:/license/d5547426-ecab-4f07-a02a-a8c3cb02.docx', 'admin', '2018-04-30 22:25:04', 'admin', '2018-04-30 22:25:04');
INSERT INTO `license_resource` VALUES ('30', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '2adb1379-a15d-43ac-8984-26002cec.docx', 'D:/license/2adb1379-a15d-43ac-8984-26002cec.docx', 'admin', '2018-04-30 22:25:05', 'admin', '2018-04-30 22:25:05');
INSERT INTO `license_resource` VALUES ('31', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '3f565691-94a1-4e5c-906c-2949b135.docx', 'D:/license/3f565691-94a1-4e5c-906c-2949b135.docx', 'admin', '2018-04-30 22:25:05', 'admin', '2018-04-30 22:25:05');
INSERT INTO `license_resource` VALUES ('32', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '3518445b-2df5-4e3c-b602-f2d9ac69.docx', 'D:/license/3518445b-2df5-4e3c-b602-f2d9ac69.docx', 'admin', '2018-04-30 22:36:48', 'admin', '2018-04-30 22:36:48');
INSERT INTO `license_resource` VALUES ('33', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '8fbea0ed-e4b7-4ab2-9a90-a118f3a2.docx', 'D:/license/8fbea0ed-e4b7-4ab2-9a90-a118f3a2.docx', 'admin', '2018-04-30 22:36:49', 'admin', '2018-04-30 22:36:49');
INSERT INTO `license_resource` VALUES ('34', '2', 'SSH(Secure-Shell-Client)常用命令.docx', '24dd00c3-bd69-4523-a4a8-3965ffd3.docx', 'D:/license/24dd00c3-bd69-4523-a4a8-3965ffd3.docx', 'admin', '2018-04-30 22:36:49', 'admin', '2018-04-30 22:36:49');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaser
-- ----------------------------
INSERT INTO `purchaser` VALUES ('1', '测试采购商1', '测试采购商1', '1@qq.com', '13111111111', '111111', 'admin', '2018-04-30 22:36:37', 'admin', '2018-04-30 22:36:37', '0');

-- ----------------------------
-- Table structure for `purchaser_license`
-- ----------------------------
DROP TABLE IF EXISTS `purchaser_license`;
CREATE TABLE `purchaser_license` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `license_resource_id` bigint(32) NOT NULL,
  `company_id` bigint(32) NOT NULL,
  `create_user` varchar(64) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(64) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `resource_type` char(1) NOT NULL COMMENT '资源类型(1:授权委托书, 2:营业执照, 3:税务登记书',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaser_license
-- ----------------------------
INSERT INTO `purchaser_license` VALUES ('1', '17', '103', 'admin', '2018-04-30 15:37:53', 'admin', '2018-04-30 15:37:53', '1');
INSERT INTO `purchaser_license` VALUES ('2', '18', '103', 'admin', '2018-04-30 15:37:53', 'admin', '2018-04-30 15:37:53', '2');
INSERT INTO `purchaser_license` VALUES ('3', '19', '103', 'admin', '2018-04-30 15:37:53', 'admin', '2018-04-30 15:37:53', '3');
INSERT INTO `purchaser_license` VALUES ('4', '20', '105', 'admin', '2018-04-30 22:18:44', 'admin', '2018-04-30 22:18:44', '1');
INSERT INTO `purchaser_license` VALUES ('5', '21', '105', 'admin', '2018-04-30 22:18:44', 'admin', '2018-04-30 22:18:44', '2');
INSERT INTO `purchaser_license` VALUES ('6', '22', '105', 'admin', '2018-04-30 22:18:44', 'admin', '2018-04-30 22:18:44', '3');
INSERT INTO `purchaser_license` VALUES ('7', '23', '106', 'admin', '2018-04-30 22:19:47', 'admin', '2018-04-30 22:19:47', '1');
INSERT INTO `purchaser_license` VALUES ('8', '24', '106', 'admin', '2018-04-30 22:19:47', 'admin', '2018-04-30 22:19:47', '2');
INSERT INTO `purchaser_license` VALUES ('9', '25', '106', 'admin', '2018-04-30 22:19:47', 'admin', '2018-04-30 22:19:47', '3');
INSERT INTO `purchaser_license` VALUES ('10', '26', '108', 'admin', '2018-04-30 22:22:43', 'admin', '2018-04-30 22:22:43', '1');
INSERT INTO `purchaser_license` VALUES ('11', '27', '108', 'admin', '2018-04-30 22:22:43', 'admin', '2018-04-30 22:22:43', '2');
INSERT INTO `purchaser_license` VALUES ('12', '28', '108', 'admin', '2018-04-30 22:22:43', 'admin', '2018-04-30 22:22:43', '3');
INSERT INTO `purchaser_license` VALUES ('13', '29', '109', 'admin', '2018-04-30 22:25:05', 'admin', '2018-04-30 22:25:05', '1');
INSERT INTO `purchaser_license` VALUES ('14', '30', '109', 'admin', '2018-04-30 22:25:05', 'admin', '2018-04-30 22:25:05', '2');
INSERT INTO `purchaser_license` VALUES ('15', '31', '109', 'admin', '2018-04-30 22:25:05', 'admin', '2018-04-30 22:25:05', '3');
INSERT INTO `purchaser_license` VALUES ('16', '32', '1', 'admin', '2018-04-30 22:36:49', 'admin', '2018-04-30 22:36:49', '1');
INSERT INTO `purchaser_license` VALUES ('17', '33', '1', 'admin', '2018-04-30 22:36:49', 'admin', '2018-04-30 22:36:49', '2');
INSERT INTO `purchaser_license` VALUES ('18', '34', '1', 'admin', '2018-04-30 22:36:49', 'admin', '2018-04-30 22:36:49', '3');

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
