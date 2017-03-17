DROP DATABASE IF EXISTS `sampledb`;
CREATE DATABASE `sampledb` DEFAULT CHARACTER SET utf8;
USE `sampledb`;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
`user_name` VARCHAR (30) NOT NULL PRIMARY KEY COMMENT '用户名',
`password` VARCHAR (30) NOT NULL COMMENT '密码',
`score` INT (11) COMMENT '得分',
`last_logon_time` INT (20) COMMENT '最近登录时间'
)ENGINE=INNODB COMMENT '用户基本信息表';

INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES ('tom','123456',10,123213213);
COMMIT;