/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-02 10:33:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '22');
INSERT INTO `user` VALUES ('2', '关羽', '22');
INSERT INTO `user` VALUES ('3', '张飞', '21');
INSERT INTO `user` VALUES ('4', '刘备', '32');
INSERT INTO `user` VALUES ('5', '赵云', '25');
INSERT INTO `user` VALUES ('6', '马超', '24');
INSERT INTO `user` VALUES ('7', '黄忠', '21');
INSERT INTO `user` VALUES ('8', '张三', '21');
INSERT INTO `user` VALUES ('9', '李四', '22');
INSERT INTO `user` VALUES ('10', '李四1', '21');
INSERT INTO `user` VALUES ('12', '李四3', '98');
INSERT INTO `user` VALUES ('13', '王五', '21');
INSERT INTO `user` VALUES ('14', '哇啊哈哈', '11');
