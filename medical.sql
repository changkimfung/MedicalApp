/*
Navicat MySQL Data Transfer

Source Server         : Medical
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : medical

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-07-24 17:27:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `emp_id` int(11) NOT NULL,
  `emp_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menuid` varchar(20) NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `menuid` (`menuid`),
  KEY `num01` (`emp_id`),
  KEY `num02` (`emp_name`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`menuid`) REFERENCES `sys_menu` (`U_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('5555', 'xxx', '002');

-- ----------------------------
-- Table structure for pre_drug
-- ----------------------------
DROP TABLE IF EXISTS `pre_drug`;
CREATE TABLE `pre_drug` (
  `U_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `CODE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编码',
  `Buy_Time` date DEFAULT NULL COMMENT '购买日期',
  `Total` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购买总量',
  `rest` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '剩余量',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pre_drug
-- ----------------------------
INSERT INTO `pre_drug` VALUES ('0101557895177953', '舒大林', '1112222', '2019-05-08', '898', '123', null);

-- ----------------------------
-- Table structure for pre_injury_handle
-- ----------------------------
DROP TABLE IF EXISTS `pre_injury_handle`;
CREATE TABLE `pre_injury_handle` (
  `U_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `stuName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生姓名',
  `stuId` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学号',
  `classes` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级',
  `medical` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医院',
  `illness` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '病情',
  `docName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医生姓名',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态(0/1/2)',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pre_injury_handle
-- ----------------------------
INSERT INTO `pre_injury_handle` VALUES ('002', '吴敬霆', '15552011454', 'H15W', '花都中西结合医院', '低能侏儒症', '001', '1');
INSERT INTO `pre_injury_handle` VALUES ('0101557895027652', '郑剑锋', '155555555', 'H15B', '花都', '感冒', '陈医生', '1');

-- ----------------------------
-- Table structure for pre_insurance_handle
-- ----------------------------
DROP TABLE IF EXISTS `pre_insurance_handle`;
CREATE TABLE `pre_insurance_handle` (
  `U_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `stuName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生姓名',
  `stuID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学号',
  `insCode` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '保险编码',
  `docName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医生姓名',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pre_insurance_handle
-- ----------------------------
INSERT INTO `pre_insurance_handle` VALUES ('0101557894156569', '郑剑锋', '15551102081', '111111', '陈医生', '1');
INSERT INTO `pre_insurance_handle` VALUES ('0101557895003501', '郑剑锋', '1555110281', '123456', '陈医生2', '1');

-- ----------------------------
-- Table structure for pre_num
-- ----------------------------
DROP TABLE IF EXISTS `pre_num`;
CREATE TABLE `pre_num` (
  `id` varchar(255) NOT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_num
-- ----------------------------
INSERT INTO `pre_num` VALUES ('1', '6');

-- ----------------------------
-- Table structure for pre_problemitem
-- ----------------------------
DROP TABLE IF EXISTS `pre_problemitem`;
CREATE TABLE `pre_problemitem` (
  `U_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '问题详情',
  `code` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编码',
  `answer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回答',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pre_problemitem
-- ----------------------------
INSERT INTO `pre_problemitem` VALUES ('0101557808551805', '最近有点热', '123', '确实有点热啊');
INSERT INTO `pre_problemitem` VALUES ('0101557894226288', '测试提出问题意见', '5555', '收到');
INSERT INTO `pre_problemitem` VALUES ('0101557895074958', '今天答辩', '111', '开心');

-- ----------------------------
-- Table structure for pre_registration
-- ----------------------------
DROP TABLE IF EXISTS `pre_registration`;
CREATE TABLE `pre_registration` (
  `U_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `stuName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生姓名',
  `stuId` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生ID',
  `docName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医生姓名',
  `ResDate` date DEFAULT NULL COMMENT '挂号日期',
  `illness` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '病情',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pre_registration
-- ----------------------------
INSERT INTO `pre_registration` VALUES ('0101557808538559', '郑剑锋', '111', '陈医生', null, '111', '2019-05-14', '1');
INSERT INTO `pre_registration` VALUES ('0101557894208516', '郑剑锋', '1555511102081', '陈医生', null, '喝醉', '2019-04-30', '1');
INSERT INTO `pre_registration` VALUES ('0101557895055071', '哈哈个', '15551102081', '陈医生', null, '喝醉', '2019-05-01', '2');

-- ----------------------------
-- Table structure for pre_secsha
-- ----------------------------
DROP TABLE IF EXISTS `pre_secsha`;
CREATE TABLE `pre_secsha` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_secsha
-- ----------------------------
INSERT INTO `pre_secsha` VALUES ('1', '2323232323232');
INSERT INTO `pre_secsha` VALUES ('2019-7-10 17:58:36', '3');
INSERT INTO `pre_secsha` VALUES ('2019-7-10 17:58:40', '4');
INSERT INTO `pre_secsha` VALUES ('2019-7-10 17:59:22', '5');
INSERT INTO `pre_secsha` VALUES ('22', '2');
INSERT INTO `pre_secsha` VALUES ('888', '1');
INSERT INTO `pre_secsha` VALUES ('test', '8');

-- ----------------------------
-- Table structure for sys_doctor
-- ----------------------------
DROP TABLE IF EXISTS `sys_doctor`;
CREATE TABLE `sys_doctor` (
  `U_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `Code` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工号（与用户名关联）',
  `age` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '年龄',
  `EmploymentYear` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工龄',
  `sex` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `Entry_Date` date DEFAULT NULL COMMENT '入职时间',
  `introduction` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简介',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_doctor
-- ----------------------------
INSERT INTO `sys_doctor` VALUES ('0101557808363125', '陈医生', '1111111', '25', '8', '男', '2019-05-14', '是个男生', '');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `U_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `roleId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色种类',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路径',
  `parId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父菜单id',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('002', '1', '学生信息查询', 'http://localhost:8080/Student/list', 'A100', '1');
INSERT INTO `sys_menu` VALUES ('003', '1', '校医信息查询', 'http://localhost:8080/Doctor/list', 'A100', '1');
INSERT INTO `sys_menu` VALUES ('004', '1', '学生信息录入', 'http://localhost:8080/Student/list', 'A100', '1');
INSERT INTO `sys_menu` VALUES ('005', '1', '校医信息录入', 'http://localhost:8080/Doctor/list', 'A100', '1');
INSERT INTO `sys_menu` VALUES ('007', null, '医保报销申请', 'http://localhost:8080/InsuranceHandle/list', 'A200', '1');
INSERT INTO `sys_menu` VALUES ('008', null, '伤病证明申办', 'http://localhost:8080/InjuryHandle/list', 'A200', '1');
INSERT INTO `sys_menu` VALUES ('009', null, '医保报销申请', 'http://localhost:8080/InsuranceHandle/list', 'A200', '1');
INSERT INTO `sys_menu` VALUES ('010', null, '伤病证明查询', 'http://localhost:8080/InjuryHandle/list', 'A200', '1');
INSERT INTO `sys_menu` VALUES ('012', null, '患病登记', 'http://localhost:8080/Registration/list', 'A300', '1');
INSERT INTO `sys_menu` VALUES ('013', null, '药品库量查询', 'http://localhost:8080/Drug/list', 'A300', '1');
INSERT INTO `sys_menu` VALUES ('014', null, '校园问题反映', 'http://localhost:8080/ProblemItem/list', 'A300', '1');
INSERT INTO `sys_menu` VALUES ('015', null, '学生病史查询', 'http://localhost:8080/Registration/list', 'A300', '1');
INSERT INTO `sys_menu` VALUES ('016', null, '药品登记', 'http://localhost:8080/Drug/list', 'A300', '1');
INSERT INTO `sys_menu` VALUES ('017', null, '校园问题反应查询', 'http://localhost:8080/ProblemItem/list', 'A300', '1');
INSERT INTO `sys_menu` VALUES ('019', null, '学生信息维护', 'http://localhost:8080/Student/list', 'A400', '1');
INSERT INTO `sys_menu` VALUES ('020', null, '校医信息维护', 'http://localhost:8080/Doctor/list', 'A400', '1');

-- ----------------------------
-- Table structure for sys_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role`;
CREATE TABLE `sys_menu_role` (
  `U_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `roleId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色Id',
  `menuId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu_role
-- ----------------------------
INSERT INTO `sys_menu_role` VALUES ('1', '1', '004');
INSERT INTO `sys_menu_role` VALUES ('10', '2', '004');
INSERT INTO `sys_menu_role` VALUES ('11', '2', '003');
INSERT INTO `sys_menu_role` VALUES ('12', '2', '007');
INSERT INTO `sys_menu_role` VALUES ('13', '2', '008');
INSERT INTO `sys_menu_role` VALUES ('14', '2', '012');
INSERT INTO `sys_menu_role` VALUES ('15', '2', '013');
INSERT INTO `sys_menu_role` VALUES ('16', '2', '014');
INSERT INTO `sys_menu_role` VALUES ('17', '3', '002');
INSERT INTO `sys_menu_role` VALUES ('18', '3', '005');
INSERT INTO `sys_menu_role` VALUES ('19', '3', '009');
INSERT INTO `sys_menu_role` VALUES ('2', '1', '005');
INSERT INTO `sys_menu_role` VALUES ('20', '3', '010');
INSERT INTO `sys_menu_role` VALUES ('21', '3', '015');
INSERT INTO `sys_menu_role` VALUES ('22', '3', '016');
INSERT INTO `sys_menu_role` VALUES ('23', '3', '017');
INSERT INTO `sys_menu_role` VALUES ('3', '1', '010');
INSERT INTO `sys_menu_role` VALUES ('4', '1', '009');
INSERT INTO `sys_menu_role` VALUES ('5', '1', '013');
INSERT INTO `sys_menu_role` VALUES ('6', '1', '014');
INSERT INTO `sys_menu_role` VALUES ('7', '1', '015');
INSERT INTO `sys_menu_role` VALUES ('8', '1', '019');
INSERT INTO `sys_menu_role` VALUES ('9', '1', '020');

-- ----------------------------
-- Table structure for sys_parent_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_parent_menu`;
CREATE TABLE `sys_parent_menu` (
  `U_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父菜单名',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编码',
  `path` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路径',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_parent_menu
-- ----------------------------
INSERT INTO `sys_parent_menu` VALUES ('A100', '用户信息查询', 'A1001', '', '1');
INSERT INTO `sys_parent_menu` VALUES ('A200', '医疗证明申请办理', 'A200', null, '1');
INSERT INTO `sys_parent_menu` VALUES ('A300', '校医医疗咨询', 'A300', null, '1');
INSERT INTO `sys_parent_menu` VALUES ('A400', '用户维护', 'A400', null, '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `U_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户类别',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '超级管理员', '1');
INSERT INTO `sys_role` VALUES ('2', '2', '学生', '1');
INSERT INTO `sys_role` VALUES ('3', '3', '校医', '1');

-- ----------------------------
-- Table structure for sys_student
-- ----------------------------
DROP TABLE IF EXISTS `sys_student`;
CREATE TABLE `sys_student` (
  `U_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生姓名',
  `stuId` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学号(与用户名关联）',
  `sex` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `classes` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_student
-- ----------------------------
INSERT INTO `sys_student` VALUES ('0101557808317753', '郑剑锋', '15551102081', '男', '2019-05-09', 'H15B软件工程', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `U_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `USERNAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `USER_TYPE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户类型',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`U_ID`) USING BTREE,
  UNIQUE KEY `IndexName` (`U_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('001', '123456', '1231456', '1', '1');
INSERT INTO `sys_user` VALUES ('0101557808144387', 'admin', 'admin', '1', null);
INSERT INTO `sys_user` VALUES ('0101557808160432', '002', '123456', '3', null);
INSERT INTO `sys_user` VALUES ('0101557894914767', '测试号', '123456', '2', null);
