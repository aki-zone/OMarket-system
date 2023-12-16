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

 Date: 25/05/2023 19:45:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item_category
-- ----------------------------
DROP TABLE IF EXISTS `item_category`;
CREATE TABLE `item_category`  (
  `itemsId` bigint(20) UNSIGNED ZEROFILL NOT NULL,
  `categoryId` bigint(8) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`itemsId`, `categoryId`) USING BTREE,
  INDEX `item_category_ibfk_2`(`categoryId`) USING BTREE,
  CONSTRAINT `item_category_ibfk_1` FOREIGN KEY (`itemsId`) REFERENCES `item` (`OId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `item_category_ibfk_2` FOREIGN KEY (`categoryId`) REFERENCES `category` (`OId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item_category
-- ----------------------------
INSERT INTO `item_category` VALUES (00000000000000000001, 00000001);
INSERT INTO `item_category` VALUES (00000000000000000002, 00000001);
INSERT INTO `item_category` VALUES (00000000000000000003, 00000001);
INSERT INTO `item_category` VALUES (00000000000000000004, 00000001);
INSERT INTO `item_category` VALUES (00000000000000000001, 00000004);
INSERT INTO `item_category` VALUES (00000000000000000003, 00000004);
INSERT INTO `item_category` VALUES (00000000000000000004, 00000004);

SET FOREIGN_KEY_CHECKS = 1;
