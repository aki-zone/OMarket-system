/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : wtumarket

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 25/05/2023 19:46:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `OId` bigint(15) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `status` int(0) NOT NULL DEFAULT 0,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phoneNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `balances` decimal(10, 2) NOT NULL,
  `regsTime` datetime(0) NOT NULL,
  PRIMARY KEY (`OId`) USING BTREE,
  UNIQUE INDEX `o`(`OId`) USING BTREE,
  UNIQUE INDEX `p`(`phoneNum`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (000000000000001, 10, 'admin', '111111', '0', '0@0.com', '妙木山武纺', 99999894.60, '2977-01-01 00:00:00');
INSERT INTO `user` VALUES (000000000000002, 0, '王锋', '555555', '1771234567', 'b@qq.com', '北京地道', 9999999.00, '2014-03-22 00:00:01');
INSERT INTO `user` VALUES (000000000000003, 0, '张华', '123456', '1775555555', 'a@qq.com', '中国武汉', 5104.40, '2022-06-22 00:00:00');
INSERT INTO `user` VALUES (000000000000004, -10, 'it', '111111', '', '', '', 0.00, '2022-03-22 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
