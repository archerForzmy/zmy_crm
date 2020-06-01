/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : crm_zzy

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 01/06/2020 16:02:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `busubess_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`business_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES (1, '特快专递EMS', '张宇', '18978675467', '今日投递，次日送达', '2020-05-28 09:54:35', '2020-05-28 09:54:35', 0);
INSERT INTO `business` VALUES (2, '国际小包', '万华', '13456543456', '三到五日到达', '2020-05-29 13:20:50', '2020-05-29 13:20:50', 0);
INSERT INTO `business` VALUES (3, '普通包裹', '李梅', '18767554389', '三到七日内到达', '2020-05-29 13:21:47', '2020-05-29 13:21:47', 0);

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emp_id` int(11) NULL DEFAULT NULL,
  `is_del` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`contact_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (1, '电话', '推销农产品', 3, '中国邮政', 36, 0, '2020-05-27 13:22:21', '2020-06-01 13:22:26');
INSERT INTO `contact` VALUES (2, '走访', '推销', 3, '中国邮政', 36, 0, '2020-05-27 13:23:20', '2020-06-01 13:23:29');
INSERT INTO `contact` VALUES (3, '电访', '推销', 4, '中国邮政', 36, 0, '2020-05-27 13:24:16', '2020-06-01 13:24:22');
INSERT INTO `contact` VALUES (4, '电访', '推销农产品', 5, '中国邮政', 37, 0, '2020-05-27 13:24:58', '2020-06-01 13:25:03');
INSERT INTO `contact` VALUES (5, '电话', '推销农产品', 1, '中国邮政', 1, 0, '2020-05-27 09:29:14', '2020-05-29 13:17:57');
INSERT INTO `contact` VALUES (6, 'QQ', '商谈合同事项', 1, '中国邮政', 1, 0, '2020-05-27 09:41:27', '2020-05-29 13:18:08');
INSERT INTO `contact` VALUES (7, '微信', '签订合同', 2, '中国邮政', 1, 0, '2020-05-27 15:14:44', '2020-05-27 15:14:48');
INSERT INTO `contact` VALUES (8, '电访', '推销农产品', 3, '中国邮政', 36, 0, '2020-05-28 13:25:44', '2020-06-01 13:25:50');
INSERT INTO `contact` VALUES (9, '电访', '推销农产品', 4, '中国邮政', 36, 0, '2020-05-28 13:26:26', '2020-06-01 13:26:35');
INSERT INTO `contact` VALUES (10, '电访', '推销农产品', 5, '中国邮政', 37, 0, '2020-05-28 13:27:07', '2020-06-01 13:27:13');
INSERT INTO `contact` VALUES (11, '微信', '推销农产品', 3, '中国邮政', 36, 0, '2020-05-28 13:32:05', '2020-06-01 13:32:15');
INSERT INTO `contact` VALUES (12, '电访', '推销农产品', 5, '中国邮政', 37, 0, '2020-05-28 13:33:01', '2020-06-01 13:33:10');
INSERT INTO `contact` VALUES (13, 'QQ', '咨询', 4, '中国邮政', 36, 0, '2020-05-28 13:34:08', '2020-06-01 13:34:31');
INSERT INTO `contact` VALUES (14, '电访', '揽收包裹', 1, '中国邮政', 1, 0, '2020-05-28 13:16:37', '2020-05-29 13:18:22');
INSERT INTO `contact` VALUES (15, '走访', '投递包裹', 2, '中国邮政', 1, 0, '2020-05-28 13:19:00', '2020-05-29 13:19:00');
INSERT INTO `contact` VALUES (16, '电访', '投递包裹', 2, '中国邮政', 1, 0, '2020-05-29 13:52:40', '2020-05-29 13:52:43');
INSERT INTO `contact` VALUES (17, '电访', '揽收包裹', 2, '中国邮政', 1, 0, '2020-05-29 15:13:00', '2020-05-29 15:13:05');
INSERT INTO `contact` VALUES (18, '电访', '来电咨询', 1, '中国邮政', 1, 0, '2020-05-29 15:13:33', '2020-05-29 15:13:36');
INSERT INTO `contact` VALUES (19, '电访', '推销农产品', 3, '中国邮政', 36, 0, '2020-05-29 13:35:05', '2020-06-01 13:35:10');
INSERT INTO `contact` VALUES (20, 'QQ', '推销农产品', 4, '中国邮政', 36, 0, '2020-05-29 13:35:46', '2020-06-01 13:35:51');
INSERT INTO `contact` VALUES (21, '微信', '推销农产品', 3, '中国邮政', 36, 0, '2020-05-29 13:36:21', '2020-06-01 13:36:27');
INSERT INTO `contact` VALUES (22, '走访', '推销农产品', 5, '中国邮政', 37, 0, '2020-05-29 13:36:55', '2020-06-01 13:37:05');
INSERT INTO `contact` VALUES (23, '问卷', '推销农产品', 5, '中国邮政', 37, 0, '2020-05-29 13:37:33', '2020-06-01 13:37:39');
INSERT INTO `contact` VALUES (24, '问卷', '推销农产品', 1, '中国邮政', 1, 0, '2020-05-30 13:38:22', '2020-06-01 13:38:27');
INSERT INTO `contact` VALUES (25, 'QQ', '推销农产品', 2, '中国邮政', 1, 0, '2020-05-30 13:38:59', '2020-06-01 13:39:04');
INSERT INTO `contact` VALUES (26, '微信', '推销农产品', 3, '中国邮政', 36, 0, '2020-05-30 13:39:28', '2020-06-01 13:39:46');
INSERT INTO `contact` VALUES (27, '微信', '推销农产品', 5, '中国邮政', 37, 0, '2020-05-30 13:40:10', '2020-06-01 13:40:14');
INSERT INTO `contact` VALUES (28, '电访', '推销农产品', 1, '中国邮政', 1, 0, '2020-05-31 13:43:58', '2020-06-01 13:44:04');
INSERT INTO `contact` VALUES (29, '电访', '推销农产品', 2, '中国邮政', 1, 0, '2020-05-31 13:44:30', '2020-06-01 13:44:35');
INSERT INTO `contact` VALUES (30, '微信', '推销农产品', 3, '中国邮政', 36, 0, '2020-05-31 13:45:03', '2020-06-01 13:45:12');
INSERT INTO `contact` VALUES (31, '微信', '推销农产品', 4, '中国邮政', 36, 0, '2020-05-31 13:45:33', '2020-06-01 13:45:38');
INSERT INTO `contact` VALUES (32, '电话', '推销保险', 3, '中国邮政', 36, 0, '2020-05-31 13:46:17', '2020-06-01 13:46:22');
INSERT INTO `contact` VALUES (33, '电话', '推销农产品', 4, '中国邮政', 36, 0, '2020-05-31 13:46:52', '2020-06-01 13:46:56');
INSERT INTO `contact` VALUES (34, '电话', '推销农产品', 5, '中国邮政', 37, 0, '2020-05-31 13:47:21', '2020-06-01 13:47:25');
INSERT INTO `contact` VALUES (35, '微信', '推销农产品', 5, '中国邮政', 37, 0, '2020-05-31 13:47:47', '2020-06-01 13:47:51');
INSERT INTO `contact` VALUES (36, 'QQ', '推销农产品', 1, '中国邮政', 1, 0, '2020-06-01 13:48:23', '2020-06-01 13:48:25');
INSERT INTO `contact` VALUES (37, 'QQ', '推销农产品', 2, '中国邮政', 1, 0, '2020-06-01 13:48:51', '2020-06-01 13:48:54');
INSERT INTO `contact` VALUES (38, 'QQ', '推销农产品', 2, '中国邮政', 1, 0, '2020-06-01 13:49:17', '2020-06-01 13:49:19');
INSERT INTO `contact` VALUES (39, '微信', '推销农产品', 3, '中国邮政', 36, 0, '2020-06-01 13:49:44', '2020-06-01 13:49:46');
INSERT INTO `contact` VALUES (40, '微信', '推销农产品', 3, '中国邮政', 36, 0, '2020-06-01 13:50:06', '2020-06-01 13:50:08');
INSERT INTO `contact` VALUES (41, 'QQ', '推销农产品', 4, '中国邮政', 36, 0, '2020-06-01 13:50:45', '2020-06-01 13:50:47');
INSERT INTO `contact` VALUES (42, 'QQ', '推销农产品', 4, '中国邮政', 36, 0, '2020-06-01 13:51:28', '2020-06-01 13:51:30');
INSERT INTO `contact` VALUES (43, '微信', '推销农产品', 5, '中国邮政', 37, 0, '2020-06-01 13:51:58', '2020-06-01 13:52:01');
INSERT INTO `contact` VALUES (44, '电访', '推销农产品', 5, '中国邮政', 37, 0, '2020-06-01 13:52:25', '2020-06-01 13:52:28');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emp_id` int(11) NULL DEFAULT NULL,
  `is_orders` int(11) NULL DEFAULT NULL,
  `is_del` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '张三', '男', '18977666868', '中国邮政', '宜春市宜阳大道50号', 1, 1, 0, '2020-05-26 22:07:58', '2020-05-27 15:35:25');
INSERT INTO `customer` VALUES (2, '王二牛', '男', '18767542389', '中国铁塔', '北京市海淀区学院路134号', 1, 1, 0, '2020-05-29 13:17:22', '2020-05-29 13:17:22');
INSERT INTO `customer` VALUES (3, '李铁蛋', '男', '18720520869', '中国邮政', '北京市海淀区', 36, 1, 0, '2020-06-01 12:18:02', '2020-06-01 12:18:08');
INSERT INTO `customer` VALUES (4, '狗剩', '男', '18220520869', '中国邮政', '北京市海淀区', 36, 1, 0, '2020-06-01 12:22:36', '2020-06-01 12:22:43');
INSERT INTO `customer` VALUES (5, '李狗蛋', '男', '18720520869', '中国邮政', '广州白云区', 37, 1, 0, '2020-06-01 12:25:22', '2020-06-01 12:25:25');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '寄递事业部', '2020-03-24 09:34:13', '2020-03-24 09:34:16', 0);

-- ----------------------------
-- Table structure for dept_role
-- ----------------------------
DROP TABLE IF EXISTS `dept_role`;
CREATE TABLE `dept_role`  (
  `dept_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`dept_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept_role
-- ----------------------------
INSERT INTO `dept_role` VALUES (1, 1, '2020-03-24 09:33:54', '2020-03-24 09:33:56', 0);
INSERT INTO `dept_role` VALUES (1, 22, '2020-05-28 17:09:09', '2020-05-28 17:09:09', 0);
INSERT INTO `dept_role` VALUES (1, 23, '2020-05-28 17:14:48', '2020-05-28 17:14:48', 0);

-- ----------------------------
-- Table structure for emp_role
-- ----------------------------
DROP TABLE IF EXISTS `emp_role`;
CREATE TABLE `emp_role`  (
  `emp_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp_role
-- ----------------------------
INSERT INTO `emp_role` VALUES (1, 1, '2020-03-24 09:29:38', '2020-03-24 09:29:40', 0);
INSERT INTO `emp_role` VALUES (36, 22, '2020-05-28 17:07:45', '2020-05-28 17:09:58', 0);
INSERT INTO `emp_role` VALUES (37, 23, '2020-05-28 17:20:50', '2020-05-29 13:23:34', 0);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'admin', 'ab395f9bcce071deeb8d6a42ccb31082', 'b88ad99e38ec', 18, '男', '13513513511', '北京海淀', '2020-03-23 15:34:10', '2020-03-23 15:34:13', 0);
INSERT INTO `employee` VALUES (36, '张三', 'd951f09f76cff2a901a2a4852e1109eb', 'b0dd8ef64c69', 34, '男', '18720520869', '广州天河', '2020-05-28 17:07:45', '2020-05-28 17:09:58', 0);
INSERT INTO `employee` VALUES (37, '李四', '0e627bfaf82712310518293bf8b545c8', 'e94871e08d68', 19, '男', '18976677621', '湖南长沙', '2020-05-28 17:20:50', '2020-05-29 13:23:34', 0);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_id` int(11) NULL DEFAULT NULL,
  `total_price` decimal(20, 0) NULL DEFAULT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`orders_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (5, 3, 66, 5, '2020-05-27 14:14:38', '2020-05-27 14:14:42', 0);
INSERT INTO `orders` VALUES (6, 2, 26, 3, '2020-05-27 14:12:27', '2020-06-01 14:12:32', 0);
INSERT INTO `orders` VALUES (7, 3, 12, 2, '2020-05-27 14:11:49', '2020-05-27 14:11:53', 0);
INSERT INTO `orders` VALUES (8, 1, 56, 1, '2020-05-27 13:59:40', '2020-05-27 13:59:45', 0);
INSERT INTO `orders` VALUES (9, 2, 32, 1, '2020-05-27 15:30:20', '2020-05-27 15:30:26', 0);
INSERT INTO `orders` VALUES (10, 2, 14, 1, '2020-05-28 15:34:59', '2020-05-28 15:35:03', 0);
INSERT INTO `orders` VALUES (11, 1, 44, 1, '2020-05-28 09:55:57', '2020-05-28 09:55:57', 0);
INSERT INTO `orders` VALUES (12, 3, 22, 4, '2020-05-28 14:13:28', '2020-05-28 14:13:32', 0);
INSERT INTO `orders` VALUES (13, 2, 65, 5, '2020-05-28 14:13:54', '2020-05-28 14:13:59', 0);
INSERT INTO `orders` VALUES (14, 1, 44, 2, '2020-05-28 14:15:19', '2020-05-28 14:15:24', 0);
INSERT INTO `orders` VALUES (15, 2, 26, 3, '2020-05-29 14:15:51', '2020-05-29 14:15:55', 0);
INSERT INTO `orders` VALUES (16, 3, 78, 1, '2020-05-29 15:36:36', '2020-05-29 15:36:39', 0);
INSERT INTO `orders` VALUES (17, 2, 14, 1, '2020-05-29 15:35:58', '2020-05-29 15:36:01', 0);
INSERT INTO `orders` VALUES (18, 1, 23, 1, '2020-05-29 13:57:53', '2020-05-29 13:57:56', 0);
INSERT INTO `orders` VALUES (19, 3, 11, 4, '2020-05-29 14:16:32', '2020-06-01 14:16:38', 0);
INSERT INTO `orders` VALUES (20, 2, 45, 5, '2020-05-29 14:17:03', '2020-06-01 14:17:14', 0);
INSERT INTO `orders` VALUES (21, 1, 22, 1, '2020-05-30 14:17:31', '2020-05-30 14:17:34', 0);
INSERT INTO `orders` VALUES (22, 2, 56, 2, '2020-05-30 14:18:04', '2020-06-01 14:18:07', 0);
INSERT INTO `orders` VALUES (23, 3, 55, 4, '2020-05-30 14:18:28', '2020-05-30 14:18:31', 0);
INSERT INTO `orders` VALUES (24, 1, 14, 5, '2020-05-30 14:18:50', '2020-05-30 14:18:54', 0);
INSERT INTO `orders` VALUES (25, 2, 99, 1, '2020-05-31 14:19:32', '2020-05-31 14:19:35', 0);
INSERT INTO `orders` VALUES (26, 3, 45, 3, '2020-05-31 14:19:51', '2020-05-31 14:19:56', 0);
INSERT INTO `orders` VALUES (27, 3, 23, 4, '2020-05-31 14:20:14', '2020-05-31 14:20:18', 0);
INSERT INTO `orders` VALUES (28, 1, 18, 5, '2020-05-31 14:20:37', '2020-05-31 14:20:41', 0);
INSERT INTO `orders` VALUES (29, 1, 35, 3, '2020-06-01 14:21:05', '2020-06-01 14:21:37', 0);
INSERT INTO `orders` VALUES (30, 2, 22, 2, '2020-06-01 14:21:51', '2020-06-01 14:21:54', 0);
INSERT INTO `orders` VALUES (31, 3, 77, 5, '2020-06-01 14:22:21', '2020-06-01 14:22:25', 0);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `perm_id` int(11) NOT NULL AUTO_INCREMENT,
  `perm_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '总权限', '/', 'emp', '2020-05-28 15:27:24', '2020-05-28 15:27:24', 0);
INSERT INTO `permission` VALUES (15, '客户列表', '/customer/list', 'emp:customer', '2020-05-28 17:28:11', '2020-05-28 17:28:11', 0);
INSERT INTO `permission` VALUES (16, '员工列表', '/emp/list', 'emp:list', '2020-05-28 17:28:02', '2020-05-28 17:28:02', 0);
INSERT INTO `permission` VALUES (17, '角色列表', '/emp/role', 'emp:role', '2020-05-28 17:31:15', '2020-05-28 17:31:15', 0);
INSERT INTO `permission` VALUES (18, '部门列表', '/emp/dept', 'emp:dept', '2020-05-28 17:31:39', '2020-05-28 17:31:39', 0);
INSERT INTO `permission` VALUES (19, '权限列表', '/emp/permission', 'emp:permission', '2020-05-28 17:32:12', '2020-05-28 17:32:12', 0);
INSERT INTO `permission` VALUES (20, '客户跟踪', '/customer/contact', 'emp:contact', '2020-05-28 17:33:17', '2020-05-28 17:33:17', 0);
INSERT INTO `permission` VALUES (21, '业务管理', '/orders/business', 'emp:business', '2020-05-28 17:35:32', '2020-05-28 17:35:32', 0);
INSERT INTO `permission` VALUES (22, '订单管理', '/orders/orders', 'emp:orders', '2020-05-28 17:36:00', '2020-05-28 17:36:00', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '2020-03-24 09:27:40', '2020-03-24 09:27:42', 0);
INSERT INTO `role` VALUES (22, '总干事', '2020-05-28 17:09:09', '2020-05-28 17:09:09', 0);
INSERT INTO `role` VALUES (23, '营销员', '2020-05-28 17:14:48', '2020-05-28 17:14:48', 0);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NOT NULL,
  PRIMARY KEY (`perm_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, '2020-03-24 09:34:39', '2020-03-24 09:34:41', 0);
INSERT INTO `role_permission` VALUES (22, 15, '2020-05-27 17:32:22', '2020-05-29 17:32:26', 0);
INSERT INTO `role_permission` VALUES (23, 15, '2020-05-28 17:39:33', '2020-05-28 17:39:40', 0);
INSERT INTO `role_permission` VALUES (22, 16, '2020-05-27 17:29:12', '2020-05-28 17:29:18', 0);
INSERT INTO `role_permission` VALUES (22, 20, '2020-05-27 17:33:57', '2020-05-28 17:34:00', 0);
INSERT INTO `role_permission` VALUES (23, 20, '2020-05-28 17:40:31', '2020-05-28 17:40:34', 0);
INSERT INTO `role_permission` VALUES (22, 21, '2020-05-28 17:37:03', '2020-05-28 17:37:06', 0);
INSERT INTO `role_permission` VALUES (22, 22, '2020-05-27 17:37:35', '2020-05-28 17:37:37', 0);
INSERT INTO `role_permission` VALUES (23, 22, '2020-05-28 17:40:44', '2020-05-28 17:40:48', 0);
INSERT INTO `role_permission` VALUES (22, 23, '2020-05-27 17:37:48', '2020-05-28 17:37:53', 0);
INSERT INTO `role_permission` VALUES (23, 23, '2020-05-28 17:41:18', '2020-05-28 17:41:20', 0);

SET FOREIGN_KEY_CHECKS = 1;
