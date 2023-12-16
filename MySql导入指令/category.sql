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

 Date: 25/05/2023 19:45:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `OId` bigint(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`OId`) USING BTREE,
  UNIQUE INDEX `n`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (00000050, '机械工具');
INSERT INTO `category` VALUES (00000001, '水果');
INSERT INTO `category` VALUES (00000060, '玩具');
INSERT INTO `category` VALUES (00000004, '神器');
INSERT INTO `category` VALUES (00000003, '衣物');
INSERT INTO `category` VALUES (00000002, '运动');

SET FOREIGN_KEY_CHECKS = 1;
