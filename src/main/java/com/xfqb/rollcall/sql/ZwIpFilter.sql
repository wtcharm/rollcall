/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : filter

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-04-29 11:05:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ip_filter
-- ----------------------------
DROP TABLE IF EXISTS `ip_filter`;
CREATE TABLE `ip_filter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` varchar(255) NOT NULL DEFAULT '' COMMENT '当前的ip地址',
  `module` varchar(255) DEFAULT '' COMMENT '模块名称或者访问路径名称',
  `mark` int(10) DEFAULT '0' COMMENT '标记名单 0-白名单 1-黑名单',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `update_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `dr` int(11) NOT NULL DEFAULT '0' COMMENT '删除标识 0 -未删除 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
