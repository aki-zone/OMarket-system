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

 Date: 25/05/2023 19:45:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `OId` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `price` decimal(10, 2) NOT NULL,
  `num` int(0) UNSIGNED NULL DEFAULT 1,
  PRIMARY KEY (`OId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (00000000000000000001, '冬天番茄', '非常美味！降价促销五亿元一个！', 5.22, 100);
INSERT INTO `item` VALUES (00000000000000000002, '夏天番茄', '非常美味！降价促销五亿元一个！', 5.44, 5);
INSERT INTO `item` VALUES (00000000000000000003, '充能柚子', '哈哈！太厉害啦！！', 3.60, 10);
INSERT INTO `item` VALUES (00000000000000000004, '抖音豌豆', '发射抖音豌豆嘟嘟嘟嘟嘟嘟', 9999.66, 1);
INSERT INTO `item` VALUES (00000000000000000006, '近战之王', '舒、速速、苏苏苏噗！！', 9999.00, 0);
INSERT INTO `item` VALUES (00000000000000000008, 'King of 405', '', 999999.00, 0);

SET FOREIGN_KEY_CHECKS = 1;
