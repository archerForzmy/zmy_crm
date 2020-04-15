/*
Navicat MySQL Data Transfer

Source Server         : yuan
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : crm_zzy

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-03-27 23:06:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '总经办', '2020-03-24 09:34:13', '2020-03-24 09:34:16', '0');

-- ----------------------------
-- Table structure for dept_role
-- ----------------------------
DROP TABLE IF EXISTS `dept_role`;
CREATE TABLE `dept_role` (
  `dept_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`dept_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept_role
-- ----------------------------
INSERT INTO `dept_role` VALUES ('1', '1', '2020-03-24 09:33:54', '2020-03-24 09:33:56', '0');
INSERT INTO `dept_role` VALUES ('1', '12', '2020-03-27 21:33:18', '2020-03-27 21:33:18', '0');
INSERT INTO `dept_role` VALUES ('1', '13', '2020-03-27 22:57:36', '2020-03-27 22:57:36', '0');
INSERT INTO `dept_role` VALUES ('1', '14', '2020-03-27 23:01:41', '2020-03-27 23:01:41', '0');
INSERT INTO `dept_role` VALUES ('1', '15', '2020-03-27 23:02:24', '2020-03-27 23:02:24', '0');
INSERT INTO `dept_role` VALUES ('1', '16', '2020-03-27 23:03:11', '2020-03-27 23:03:11', '0');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(3) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'admin', 'ab395f9bcce071deeb8d6a42ccb31082', 'b88ad99e38ec', '18', '男', '13513513511', '广州天河', '2020-03-23 15:34:10', '2020-03-23 15:34:13', '0');
INSERT INTO `employee` VALUES ('2', '张三', '123', '123', '18', '男', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '1');
INSERT INTO `employee` VALUES ('3', '李四', '1f48e0e2ea050a2ae14d2ff627c6aa76', '4f843b197b0e', '18', '女', '13355', '北京', '2020-03-24 09:29:16', '2020-03-26 10:56:37', '0');
INSERT INTO `employee` VALUES ('4', 'tom', '123456', '123', '18', '男', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '0');
INSERT INTO `employee` VALUES ('5', 'jerry', '123456', '123', '18', '女', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '0');
INSERT INTO `employee` VALUES ('6', 'ben', '123456', '123', '18', '男', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '0');
INSERT INTO `employee` VALUES ('7', 'luffy', '123456', '123', '18', '男', '1511155', '上海', '2020-03-24 09:29:16', '2020-03-26 10:54:17', '0');
INSERT INTO `employee` VALUES ('8', 'nami', '123456', '123', '18', '女', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '0');
INSERT INTO `employee` VALUES ('9', 'soro', '123456', '123', '18', '男', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '0');
INSERT INTO `employee` VALUES ('10', 'san', '123456', '123', '18', '男', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '0');
INSERT INTO `employee` VALUES ('11', 'honto', '123456', '123', '18', '男', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '0');
INSERT INTO `employee` VALUES ('12', 'mali', '123456', '123', '18', '女', '13355', '广州', '2020-03-24 09:29:16', '2020-03-24 09:29:19', '1');
INSERT INTO `employee` VALUES ('13', 'test', '123', '123', '18', '男', '13533', '天河', '2020-03-25 00:00:00', '2020-03-25 00:00:00', '1');
INSERT INTO `employee` VALUES ('14', 'test', '5eea41cb71c152f41548489ac186b12c', 'c0f135ff74bb', '18', '男', '13533', '天河', '2020-03-25 14:53:46', '2020-03-25 14:53:46', '1');
INSERT INTO `employee` VALUES ('16', '帅哥', '228e0cb83072fc4bdf626561d2c42536', 'f2a59fd5bcb7', '18', '男', '13533', '天河', '2020-03-25 15:05:36', '2020-03-25 15:05:36', '1');
INSERT INTO `employee` VALUES ('20', 'coolssss', 'a630bfb93508cf28f745c9e112a4322b', '2fc529651cd1', '30', '男', '13535556788', '天河', '2020-03-25 15:11:15', '2020-03-26 14:33:38', '0');
INSERT INTO `employee` VALUES ('21', '小小', 'a59b046ff0b81a93c51aba485123d1a2', '0d5d3d632cfa', '18', '女', '5555', '广州', '2020-03-25 15:18:22', '2020-03-26 20:03:25', '0');
INSERT INTO `employee` VALUES ('27', 'testtt', '123456', '123456', '22', '男', '13533876788', 'happy', '2020-03-26 09:46:11', '2020-03-26 10:08:56', '0');
INSERT INTO `employee` VALUES ('28', '邹志远', 'a2ebc8dcbec49d61af4d772fd7da05b7', 'a5bda4be4fdd', '12', '男', '15114878777', '广州', '2020-03-26 10:28:43', '2020-03-26 10:29:18', '0');
INSERT INTO `employee` VALUES ('29', '李洋', 'b8fabc8fef4166a3d57cf1bd85620897', '7833889691a9', '28', '女', '15112494544', '美国', '2020-03-26 10:55:24', '2020-03-26 14:33:51', '1');
INSERT INTO `employee` VALUES ('30', '邹志远', '7d9ba6d686b15283d54559e4f8a13b3c', '917f4ffd7b93', '21', '男', '15154878994', '广东', '2020-03-26 11:29:56', '2020-03-26 11:29:56', '1');
INSERT INTO `employee` VALUES ('31', '猪猪', '93253c04bcde7c39f44d9bea66e84ab2', 'f79edc695c98', '21', '女', '15114788788', '广州', '2020-03-26 20:04:04', '2020-03-26 20:04:04', '0');
INSERT INTO `employee` VALUES ('32', '作者', '1fe213d878b65d7017afe4434ac40ed6', '3103530d2c33', '12', '女', '12548798755', '工作', '2020-03-27 09:31:38', '2020-03-27 09:31:48', '1');
INSERT INTO `employee` VALUES ('33', 'zzy', 'fa961da5c7e21d7e8a9b977d015def66', '29c2833f3087', '12', '男', '15114878777', 'dd', '2020-03-27 12:42:57', '2020-03-27 12:42:57', '0');
INSERT INTO `employee` VALUES ('34', '小花花', '286076619c4e29b31f8c5a16f41ab55d', 'd37d639bae28', '15', '女', '14147877881', '河源', '2020-03-27 22:59:29', '2020-03-27 23:00:24', '1');

-- ----------------------------
-- Table structure for emp_role
-- ----------------------------
DROP TABLE IF EXISTS `emp_role`;
CREATE TABLE `emp_role` (
  `emp_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_role
-- ----------------------------
INSERT INTO `emp_role` VALUES ('1', '1', '2020-03-24 09:29:38', '2020-03-24 09:29:40', '0');
INSERT INTO `emp_role` VALUES ('2', '2', '2020-03-24 09:30:05', '2020-03-24 09:30:08', '0');
INSERT INTO `emp_role` VALUES ('16', '1', '2020-03-25 15:05:36', '2020-03-25 15:05:36', '0');
INSERT INTO `emp_role` VALUES ('17', '2', '2020-03-25 15:10:50', '2020-03-26 10:27:57', '0');
INSERT INTO `emp_role` VALUES ('18', '2', '2020-03-25 15:10:55', '2020-03-25 15:10:55', '0');
INSERT INTO `emp_role` VALUES ('19', '2', '2020-03-25 15:11:04', '2020-03-25 15:11:04', '0');
INSERT INTO `emp_role` VALUES ('20', '1', '2020-03-25 15:11:15', '2020-03-26 14:33:38', '0');
INSERT INTO `emp_role` VALUES ('21', '3', '2020-03-25 15:18:23', '2020-03-26 20:03:25', '0');
INSERT INTO `emp_role` VALUES ('22', '2', '2020-03-25 15:22:56', '2020-03-25 15:22:56', '0');
INSERT INTO `emp_role` VALUES ('23', '1', '2020-03-26 08:52:03', '2020-03-26 08:52:03', '0');
INSERT INTO `emp_role` VALUES ('27', '1', '2020-03-26 09:46:11', '2020-03-26 10:08:56', '0');
INSERT INTO `emp_role` VALUES ('28', '1', '2020-03-26 10:28:43', '2020-03-26 10:29:18', '0');
INSERT INTO `emp_role` VALUES ('29', '2', '2020-03-26 10:55:24', '2020-03-26 14:33:51', '0');
INSERT INTO `emp_role` VALUES ('30', '1', '2020-03-26 11:29:56', '2020-03-26 11:29:56', '0');
INSERT INTO `emp_role` VALUES ('31', '1', '2020-03-26 20:04:04', '2020-03-26 20:04:04', '0');
INSERT INTO `emp_role` VALUES ('32', '3', '2020-03-27 09:31:38', '2020-03-27 09:31:48', '0');
INSERT INTO `emp_role` VALUES ('33', '5', '2020-03-27 12:42:57', '2020-03-27 12:42:57', '0');
INSERT INTO `emp_role` VALUES ('34', '1', '2020-03-27 22:59:29', '2020-03-27 23:00:24', '0');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `perm_id` int(11) NOT NULL AUTO_INCREMENT,
  `perm_name` varchar(50) NOT NULL,
  `url` varchar(255) NOT NULL,
  `permission` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`perm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '员工查询', '/emp', 'emp:list', '2020-03-24 09:33:28', '2020-03-24 09:33:30', '0');
INSERT INTO `permission` VALUES ('2', '员工查询', '/emp/del', 'emp:del', '2020-03-27 11:48:36', '2020-03-27 11:48:38', '0');
INSERT INTO `permission` VALUES ('3', '查询员工', 'zz', 'emp', '2020-03-27 20:51:00', '2020-03-27 20:51:00', '0');
INSERT INTO `permission` VALUES ('4', 'asdfa', 'fsadf', 'fasdf', '2020-03-27 20:30:41', '2020-03-27 20:30:41', '1');
INSERT INTO `permission` VALUES ('5', '打算', '打算', '大萨达', '2020-03-27 20:51:25', '2020-03-27 20:51:25', '1');
INSERT INTO `permission` VALUES ('6', '新增', '/user', 'epm/sdfsd', '2020-03-27 23:04:38', '2020-03-27 23:04:38', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '总经理', '2020-03-24 09:27:40', '2020-03-24 09:27:42', '0');
INSERT INTO `role` VALUES ('2', '销售员', '2020-03-24 09:28:09', '2020-03-24 09:28:13', '0');
INSERT INTO `role` VALUES ('3', '经理', '2020-03-26 16:57:52', '2020-03-26 16:57:52', '0');
INSERT INTO `role` VALUES ('4', '懂事长', '2020-03-26 17:32:13', '2020-03-27 19:39:54', '0');
INSERT INTO `role` VALUES ('5', '技术员', '2020-03-26 17:35:18', '2020-03-26 17:35:18', '0');
INSERT INTO `role` VALUES ('6', '技术员01', '2020-03-26 17:36:05', '2020-03-26 17:36:05', '1');
INSERT INTO `role` VALUES ('7', '技术员02', '2020-03-26 18:10:39', '2020-03-26 18:10:39', '1');
INSERT INTO `role` VALUES ('8', '技术员03', '2020-03-26 18:29:54', '2020-03-26 18:29:54', '1');
INSERT INTO `role` VALUES ('9', '销售经理', '2020-03-26 20:04:18', '2020-03-26 20:04:18', '0');
INSERT INTO `role` VALUES ('10', '秘书', '2020-03-27 20:28:42', '2020-03-27 20:28:42', '0');
INSERT INTO `role` VALUES ('11', '鱿鱼', '2020-03-27 21:24:31', '2020-03-27 21:24:31', '1');
INSERT INTO `role` VALUES ('12', '作者', '2020-03-27 21:33:18', '2020-03-27 21:33:18', '0');
INSERT INTO `role` VALUES ('13', '邹经理', '2020-03-27 22:57:36', '2020-03-27 22:57:36', '0');
INSERT INTO `role` VALUES ('14', '技术员', '2020-03-27 23:01:41', '2020-03-27 23:01:41', '0');
INSERT INTO `role` VALUES ('15', '秘书长', '2020-03-27 23:02:24', '2020-03-27 23:02:24', '0');
INSERT INTO `role` VALUES ('16', 'zzy', '2020-03-27 23:03:11', '2020-03-27 23:03:11', '0');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`perm_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '2020-03-24 09:34:39', '2020-03-24 09:34:41', '0');
INSERT INTO `role_permission` VALUES ('13', '1', '2020-03-27 22:57:36', '2020-03-27 22:57:36', '0');
INSERT INTO `role_permission` VALUES ('14', '1', '2020-03-27 23:01:41', '2020-03-27 23:01:41', '0');
INSERT INTO `role_permission` VALUES ('15', '1', '2020-03-27 23:02:24', '2020-03-27 23:02:24', '0');
INSERT INTO `role_permission` VALUES ('16', '1', '2020-03-27 23:03:11', '2020-03-27 23:03:11', '0');
INSERT INTO `role_permission` VALUES ('1', '2', '2020-03-27 11:48:53', '2020-03-27 11:48:55', '0');
INSERT INTO `role_permission` VALUES ('12', '3', '2020-03-27 21:33:18', '2020-03-27 21:33:18', '0');
