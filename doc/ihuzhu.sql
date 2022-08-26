SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) UNSIGNED NOT NULL COMMENT '管理员主键',
  `name` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bonus_integral
-- ----------------------------
DROP TABLE IF EXISTS `bonus_integral`;
CREATE TABLE `bonus_integral`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '发放积分主键',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `integral` decimal(10, 2) UNSIGNED NOT NULL COMMENT '积分',
  `description` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '备注',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_user_id`(`user_id`) USING BTREE COMMENT '用户id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '发放积分' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for certification_record
-- ----------------------------
DROP TABLE IF EXISTS `certification_record`;
CREATE TABLE `certification_record`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '实名认证记录主键',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '人脸',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态',
  `name` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '真实姓名',
  `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号',
  `font` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证正面',
  `back` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证反面',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_user_id`(`user_id`) USING BTREE COMMENT '用户id索引',
  INDEX `normal_status`(`status`) USING BTREE COMMENT '状态索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实名认证记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `service_id` bigint(20) UNSIGNED NOT NULL COMMENT '服务订单号',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `role` tinyint(4) UNSIGNED NOT NULL COMMENT '角色',
  `comment_level` tinyint(4) UNSIGNED NOT NULL COMMENT '评价等级',
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`service_id`, `user_id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_role`(`role`) USING BTREE COMMENT '角色索引',
  INDEX `normal_comment_level`(`comment_level`) USING BTREE COMMENT '评价等级索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务评价' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint`  (
  `service_id` bigint(20) UNSIGNED NOT NULL COMMENT '服务订单号',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `description` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `is_processed` tinyint(1) UNSIGNED NOT NULL COMMENT '是否已处理',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`service_id`, `user_id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_is_processed`(`is_processed`) USING BTREE COMMENT '是否已处理索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '举报' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for credit_level
-- ----------------------------
DROP TABLE IF EXISTS `credit_level`;
CREATE TABLE `credit_level`  (
  `id` tinyint(4) UNSIGNED NOT NULL COMMENT '信用等级主键',
  `name` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `score` int(10) UNSIGNED NOT NULL COMMENT '信用分',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '信用等级' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `is_actived` tinyint(1) UNSIGNED NOT NULL,
  `status` tinyint(4) UNSIGNED NOT NULL,
  `integral` decimal(10, 2) NOT NULL,
  `union_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `is_deleted` tinyint(1) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_name`(`name`) USING BTREE COMMENT '名字唯一索引',
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_is_actived`(`is_actived`) USING BTREE COMMENT '激活标记索引',
  INDEX `normal_is_deleted`(`is_deleted`) USING BTREE COMMENT '删除标记索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '演示' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for face_recognition_record
-- ----------------------------
DROP TABLE IF EXISTS `face_recognition_record`;
CREATE TABLE `face_recognition_record`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '人脸识别记录主键',
  `service_id` bigint(20) UNSIGNED NOT NULL COMMENT '服务订单号',
  `status` tinyint(1) UNSIGNED NOT NULL COMMENT '识别状态',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '人脸',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_service_id`(`service_id`) USING BTREE COMMENT '服务订单号索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '人脸识别记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '反馈主键',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `content` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `is_processed` tinyint(1) UNSIGNED NOT NULL COMMENT '是否已处理',
  `category` tinyint(4) UNSIGNED NOT NULL COMMENT '反馈类型',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_is_processed`(`is_processed`) USING BTREE COMMENT '是否已处理索引',
  INDEX `normal_user_id`(`user_id`) USING BTREE COMMENT '用户id索引',
  INDEX `normal_category`(`category`) USING BTREE COMMENT '反馈类型索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '反馈' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '文件主键',
  `object_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件key',
  `suffix` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '后缀',
  `size` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '文件大小',
  `is_used` tinyint(1) UNSIGNED NOT NULL COMMENT '是否被使用',
  `use` tinyint(3) UNSIGNED NOT NULL COMMENT '用途',
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '用户id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_suffix`(`suffix`) USING BTREE COMMENT '后缀索引',
  INDEX `normal_use`(`use`) USING BTREE COMMENT '用途索引',
  INDEX `normal_user_id`(`user_id`) USING BTREE COMMENT '用户id索引',
  INDEX `normal_is_used`(`is_used`) USING BTREE COMMENT '是否被使用索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for income_order
-- ----------------------------
DROP TABLE IF EXISTS `income_order`;
CREATE TABLE `income_order`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '收益订单主键',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `balance` decimal(10, 2) NOT NULL COMMENT '余额',
  `income` decimal(10, 2) UNSIGNED NOT NULL COMMENT '收益',
  `interest` decimal(7, 6) UNSIGNED NOT NULL COMMENT '利率',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_user_id`(`user_id`) USING BTREE COMMENT '用户id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收益订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for interest_rate
-- ----------------------------
DROP TABLE IF EXISTS `interest_rate`;
CREATE TABLE `interest_rate`  (
  `id` tinyint(4) UNSIGNED NOT NULL COMMENT '利率主键',
  `interest` decimal(7, 6) UNSIGNED NOT NULL COMMENT '利率',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '利率' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '订单流水主键',
  `order_id` bigint(20) UNSIGNED NOT NULL COMMENT '订单号',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `type` tinyint(4) UNSIGNED NOT NULL COMMENT '类型',
  `amount` decimal(10, 2) NOT NULL COMMENT '金额',
  `balance` decimal(10, 2) NOT NULL COMMENT '余额',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_order_id`(`order_id`) USING BTREE COMMENT '订单号索引',
  INDEX `normal_user_id`(`user_id`) USING BTREE COMMENT '用户id索引',
  INDEX `normal_type`(`type`) USING BTREE COMMENT '类型索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单流水' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '问题主键',
  `category_id` int(11) UNSIGNED NOT NULL COMMENT '问题分类',
  `question` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '问题',
  `answer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '回答',
  `helpful` int(11) UNSIGNED NOT NULL COMMENT '有用数',
  `unhelpful` int(11) UNSIGNED NOT NULL COMMENT '无用数',
  `is_hot` tinyint(1) UNSIGNED NOT NULL COMMENT '热门标记',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_category_id`(`category_id`) USING BTREE COMMENT '分类索引',
  INDEX `normal_helpful`(`helpful`) USING BTREE COMMENT '有用数索引',
  INDEX `normal_unhelpful`(`unhelpful`) USING BTREE COMMENT '无用数索引',
  INDEX `normal_is_hot`(`is_hot`) USING BTREE COMMENT '热门标记索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for question_category
-- ----------------------------
DROP TABLE IF EXISTS `question_category`;
CREATE TABLE `question_category`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '问题分类主键',
  `name` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '问题分类名称',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题分类' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for recharge_denomination
-- ----------------------------
DROP TABLE IF EXISTS `recharge_denomination`;
CREATE TABLE `recharge_denomination`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '充值面额主键',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `amount` decimal(10, 2) UNSIGNED NOT NULL COMMENT '金额',
  `integral` decimal(10, 2) UNSIGNED NOT NULL COMMENT '积分',
  `is_used` tinyint(1) UNSIGNED NOT NULL COMMENT '是否启用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_user_id`(`user_id`) USING BTREE COMMENT '用户id索引',
  INDEX `normal_amount`(`amount`) USING BTREE COMMENT '金额索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '充值面额' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for recharge_order
-- ----------------------------
DROP TABLE IF EXISTS `recharge_order`;
CREATE TABLE `recharge_order`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '充值订单主键',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `amount` decimal(10, 2) NOT NULL COMMENT '金额',
  `integral` decimal(10, 2) UNSIGNED NOT NULL COMMENT '积分',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_user_id`(`user_id`) USING BTREE COMMENT '用户id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '充值订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for service_application
-- ----------------------------
DROP TABLE IF EXISTS `service_application`;
CREATE TABLE `service_application`  (
  `service_order_id` bigint(20) UNSIGNED NOT NULL COMMENT '服务订单id',
  `servant_id` bigint(20) UNSIGNED NOT NULL COMMENT '服务者id',
  `service_status` tinyint(4) UNSIGNED NOT NULL COMMENT '服务申请状态',
  `cancel_reason` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '服务取消原因',
  `remark` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `region` int(6) UNSIGNED NOT NULL COMMENT '行政区号',
  `province` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `county` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区',
  `detailed_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `lng` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '经度',
  `lat` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '纬度',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL COMMENT '删除标记',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`service_order_id`, `servant_id`) USING BTREE,
  INDEX `normal_is_deleted`(`is_deleted`) USING BTREE COMMENT '删除标记索引',
  INDEX `normal_service_status`(`service_status`) USING BTREE COMMENT '服务申请状态索引',
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_region`(`region`) USING BTREE COMMENT '行政区号索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务申请' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for service_cancel_application
-- ----------------------------
DROP TABLE IF EXISTS `service_cancel_application`;
CREATE TABLE `service_cancel_application`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '服务取消申请主键',
  `service_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '服务id',
  `service_application_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '服务申请id',
  `service_cancel_reason_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '服务取消原因id',
  `description` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务取消申请' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for service_cancel_reason
-- ----------------------------
DROP TABLE IF EXISTS `service_cancel_reason`;
CREATE TABLE `service_cancel_reason`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '服务取消原因主键',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务取消原因名称',
  `is_used` tinyint(1) UNSIGNED NOT NULL COMMENT '是否启用',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL COMMENT '删除标记',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_is_deleted`(`is_deleted`) USING BTREE COMMENT '删除标记索引',
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务取消原因' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for service_order
-- ----------------------------
DROP TABLE IF EXISTS `service_order`;
CREATE TABLE `service_order`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '服务主键',
  `cancel_reason` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '服务取消原因',
  `service_status` tinyint(4) UNSIGNED NOT NULL COMMENT '服务状态',
  `client_id` bigint(20) UNSIGNED NOT NULL COMMENT '老人id',
  `servant_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '服务者id',
  `content` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务内容',
  `service_time` datetime(0) NOT NULL COMMENT '服务时间',
  `service_duration` tinyint(4) UNSIGNED NOT NULL COMMENT '服务时长',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `region` int(6) UNSIGNED ZEROFILL NOT NULL COMMENT '行政区号',
  `province` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `county` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区',
  `detailed_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `lng` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '经度',
  `lat` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '纬度',
  `integral` decimal(10, 2) UNSIGNED NOT NULL COMMENT '积分',
  `tip` decimal(10, 2) UNSIGNED NOT NULL COMMENT '小费',
  `pass_time` datetime(0) NULL DEFAULT NULL COMMENT '通过申请时间',
  `finished_time` datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
  `reading_count` int(10) UNSIGNED NOT NULL COMMENT '阅读量',
  `commit_count` int(10) UNSIGNED NOT NULL COMMENT '申请量',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL COMMENT '删除标记',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_is_deleted`(`is_deleted`) USING BTREE COMMENT '删除标记索引',
  INDEX `normal_service_status`(`service_status`) USING BTREE COMMENT '服务状态索引',
  INDEX `normal_client_id`(`client_id`) USING BTREE COMMENT '老人id索引',
  INDEX `normal_service_time`(`service_time`) USING BTREE COMMENT '服务时间索引',
  INDEX `normal_service_duration`(`service_duration`) USING BTREE COMMENT '服务时长索引',
  INDEX `normal_integral`(`integral`) USING BTREE COMMENT '积分索引',
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_commit_count`(`commit_count`) USING BTREE COMMENT '申请量索引',
  INDEX `normal_servant_id`(`servant_id`) USING BTREE COMMENT '服务者id',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_postcode`(`region`) USING BTREE COMMENT '行政区号索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for service_order_collect
-- ----------------------------
DROP TABLE IF EXISTS `service_order_collect`;
CREATE TABLE `service_order_collect`  (
  `service_order_id` bigint(20) UNSIGNED NOT NULL COMMENT '服务id',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`service_order_id`, `user_id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务收藏' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for service_order_service_tag
-- ----------------------------
DROP TABLE IF EXISTS `service_order_service_tag`;
CREATE TABLE `service_order_service_tag`  (
  `service_order_id` bigint(20) UNSIGNED NOT NULL COMMENT '服务订单主键',
  `service_tag_id` int(10) UNSIGNED NOT NULL COMMENT '服务标签主键',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`service_order_id`, `service_tag_id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务订单服务标签关联' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for service_tag
-- ----------------------------
DROP TABLE IF EXISTS `service_tag`;
CREATE TABLE `service_tag`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '服务标签主键',
  `name` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务标签名称',
  `is_used` tinyint(1) UNSIGNED NOT NULL COMMENT '是否启用',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL COMMENT '删除标记',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_is_deleted`(`is_deleted`) USING BTREE COMMENT '删除标记索引',
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引'
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务标签' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for transfer_order
-- ----------------------------
DROP TABLE IF EXISTS `transfer_order`;
CREATE TABLE `transfer_order`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '转账订单主键',
  `from_id` bigint(20) UNSIGNED NOT NULL COMMENT '转账人id',
  `to_id` bigint(20) UNSIGNED NOT NULL COMMENT '收款人id',
  `integral` decimal(10, 2) UNSIGNED NOT NULL COMMENT '积分',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_from_id`(`from_id`) USING BTREE COMMENT '转账人id索引',
  INDEX `normal_to_id`(`to_id`) USING BTREE COMMENT '收款人id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '转账订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '用户主键',
  `openid` char(28) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'openid',
  `status` tinyint(4) UNSIGNED NOT NULL COMMENT '状态',
  `role` tinyint(4) UNSIGNED NOT NULL COMMENT '角色',
  `name` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `gender` tinyint(4) NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `expiration` date NULL DEFAULT NULL COMMENT '到期时间',
  `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `nickname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `signature` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '人像',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '头像',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `integral` decimal(10, 2) NOT NULL COMMENT '积分',
  `credit_score` int(11) UNSIGNED NOT NULL COMMENT '信用分',
  `service_times` int(10) UNSIGNED NOT NULL COMMENT '服务次数',
  `enjoy_times` int(10) UNSIGNED NOT NULL COMMENT '被服务次数',
  `commit_count` int(10) UNSIGNED NOT NULL COMMENT '申请服务次数',
  `create_count` int(10) UNSIGNED NOT NULL COMMENT '发布服务次数',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_openid`(`openid`) USING BTREE COMMENT 'openid唯一索引',
  INDEX `normal_create_time`(`create_time`) USING BTREE COMMENT '创建时间索引',
  INDEX `normal_update_time`(`update_time`) USING BTREE COMMENT '更新时间索引',
  INDEX `normal_status`(`status`) USING BTREE COMMENT '状态索引',
  INDEX `normal_role`(`role`) USING BTREE COMMENT '角色索引',
  INDEX `normal_credit_score`(`credit_score`) USING BTREE COMMENT '信用分索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
