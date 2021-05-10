#整个系统中的sql 基础脚本


 SET NAMES utf8mb4;
 SET FOREIGN_KEY_CHECKS = 0;

 -- ----------------------------
 -- Table structure for user
 -- ----------------------------
 DROP TABLE IF EXISTS `user`;
 CREATE TABLE `user`  (
   `id` int(11) NOT NULL COMMENT '用户id',
   `name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
   `birthday` timestamp(0) NULL DEFAULT NULL COMMENT '用户出生日期',
   `sex` int(8) NULL DEFAULT NULL COMMENT '用户性别  男 0 女 1',
   `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
   `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
   `photoUrl` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址url ',
   `deleted` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '逻辑删除业务',
   `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态位',
   `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
   `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
   PRIMARY KEY (`id`) USING BTREE
 ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

 -- ----------------------------
 -- Records of user
 -- ----------------------------
 INSERT INTO `user` VALUES (1, '111', '2021-05-10 14:30:45', 1, '1', '1', '1', '1', '1', '2021-05-10 14:30:36', '2021-05-10 14:30:34', 12);

 SET FOREIGN_KEY_CHECKS = 1;