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

 Date: 25/05/2023 19:46:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_item
-- ----------------------------
DROP TABLE IF EXISTS `user_item`;
CREATE TABLE `user_item`  (
  `userId` bigint(15) UNSIGNED ZEROFILL NOT NULL,
  `itemsId` bigint(20) UNSIGNED ZEROFILL NOT NULL,
  `num` int(0) UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`itemsId`, `userId`) USING BTREE,
  INDEX `UO`(`userId`) USING BTREE,
  CONSTRAINT `IO` FOREIGN KEY (`itemsId`) REFERENCES `item` (`OId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `UO` FOREIGN KEY (`userId`) REFERENCES `user` (`OId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_item
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
