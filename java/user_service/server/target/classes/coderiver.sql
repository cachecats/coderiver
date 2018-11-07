create table `user_info`(
	`id` varchar(32) not null,
	`name` varchar(32) not null default '',
	`password` varchar(32) not null default '',
	`sex` tinyint(1) default '0' comment '性别，0未知 1男 2女',
	`token` varchar(64) default '' comment 'token',
	`tel` varchar(16) default '' comment '电话',
	`email` varchar(32) default '' comment '邮箱',
	`avatar` varchar(512) default '' comment '头像',
	`openid` varchar(64) default '' comment '微信openid',
	`qq_id` varchar(64) default '' comment 'qq的id',
	`role` tinyint(1) default '0' comment '角色 0未知',
	`city` varchar(32) default '' comment '城市',
	`experience` tinyint(2) default '0' comment '工作经验, 0:在校生 1:0年 2:1-2年 3:3-5年 4:5-10年 5:10年+',
	`skill` varchar(256) default '' comment '技能',
	`workday_start_time` TIME comment '工作日空闲开始时间',
	`workday_end_time` TIME comment '工作日空闲结束时间',
	`weekend_start_time` TIME comment '周末空闲结束时间',
	`weekend_end_time` TIME comment '周末空闲结束时间',
	`influence` int default '0' comment '影响力',
	`like` int default '0' comment '赞的数量',
	`introduce` varchar(512) default '' comment '个人简介',
	`status` tinyint(1) default '1' comment '用户状态，0已注销 1正常',
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  primary key(`id`)
) comment '用户表';



create table `education_experience`(
	`id` int not null auto_increment,
	`user_id` varchar(32) not null comment '用户id',
	`school_name` varchar(32) not null comment '学校',
	`major` varchar(32) not null comment '专业',
	`degree` varchar(16) not null comment '学位',
	`comment` varchar(512) comment '备注',
	`start_date` date not null comment '开始日期',
	`end_date` date not null comment '结束日期',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (`id`) 
) comment '教育经历';


create table `work_experience`(
	`id` int not null auto_increment,
	`user_id` varchar(32) not null comment '用户id',
	`company_name` varchar(32) not null comment '公司名字',
	`position` varchar(32) not null comment '职位',
	`comment` varchar(512) comment '备注',
	`start_date` date not null comment '开始日期',
	`end_date` date not null comment '结束日期',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (`id`) 
) comment '教育经历';


create table `project_info`(
	`project_id` varchar(32) not null,
	`project_name` varchar(64) not null default '' comment '项目名字',
	`project_avatar` varchar(512) default null comment '项目封面',
	`project_difficulty` float(1,1) default '0' comment '项目难度',
	`category_type` int(2) not null comment '项目类型类目编号',
	`project_progress` int(2) default '0' comment '项目进度',
	`project_introduce` varchar(512) default null comment '项目简介',
	`project_creator_id` varchar(32) not null comment '项目创建者id',
	`team_id` varchar(32) comment '团队id',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(`project_id`)
) comment '项目表';


create table `project_category`(
	`category_id` int not null auto_increment,
  `category_name` varchar(64) not null comment '类目名字',
  `category_type` int not null comment '类目编号',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`category_id`),
  unique key `uqe_category_type` (`category_type`)
) comment '项目类型';


create table `project_picture`(
	`picture_id` int not null auto_increment,
	`project_id` varchar(32) not null comment '项目id',
	`picture_url` varchar(512) default null comment '图片地址',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key(`picture_id`)
) comment '项目截图';


create table `user_project_relation`(
	`id` int not null auto_increment,
	`user_id` varchar(32) not null comment '用户id',
	`project_id` varchar(32) not null comment '项目id',
	primary key (`id`)
) comment '用户和项目对应关系表';



create table `team_info`(
	`team_id` varchar(32) not null comment '团队id',
	`team_name` varchar(64) not null comment '团队名字',
	`team_avatar` varchar(512) comment '团队头像',
	`team_introduce` varchar(512) comment '团队简介',
	`team_creator_id` varchar(32) comment '团队创建者id',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(`team_id`)
) comment '团队信息表';


create table `user_team_relation`(
	`id` int not null auto_increment,
	`user_id` varchar(32) not null comment '用户id',
	`team_id` varchar(32) not null comment '团队id',
	primary key(`id`)
) comment '用户-团队关系表';


# 项目  多对多  用户
# 项目  一对多  团队
# 团队  多对多  用户


