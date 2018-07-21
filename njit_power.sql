drop table if exists t_auth;

drop table if exists t_basic_user;

drop table if exists t_message;

drop table if exists t_role;

drop table if exists t_role_auth;

drop table if exists t_user;

drop table if exists t_user_role;

/*==============================================================*/
/* Table: t_auth                                                */
/*==============================================================*/
create table t_auth
(
   id                   int not null comment '主键',
   auth                 varchar(128) comment '权限',
   col1                 varchar(128) comment '预留1',
   col2                 varchar(128) comment '预留2',
   col3                 varchar(128) comment '预留3',
   primary key (id)
);

/*==============================================================*/
/* Table: t_basic_user                                          */
/*==============================================================*/
create table t_basic_user
(
   id                   int not null comment '主键',
   account              varchar(128) not null comment '账号',
   password             varchar(128) not null comment '密码',
   user_id              int comment '用户明细主键',
   flag                 varchar(1) comment '是否是普通用户',
   create_time          datetime comment '用户创建时间',
   col1                 varchar(128) comment '备用字段',
   col2                 text comment '备用字段',
   col3                 varchar(12) comment '备用字段',
   primary key (id)
);

alter table t_basic_user comment '基本用户表';

/*==============================================================*/
/* Table: t_message                                             */
/*==============================================================*/
create table t_message
(
   id                   int not null comment '主键',
   user_id              int not null comment '用户主键',
   "from"               int not null comment '用户主键',
   title                varchar(128) comment '标题',
   content              text comment '内容',
   create_time          datetime comment '创建消息的时间',
   flag                 varchar(128) comment '已读',
   col1                 varchar(128) comment '预留1',
   col2                 varchar(128) comment '预留2',
   col3                 text comment '预留3',
   primary key (id)
);

alter table t_message comment '用户消息表';

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   int not null comment '主键',
   role                 varchar(128) comment '角色',
   col1                 varchar(128) comment '预留1',
   col2                 varchar(128) comment '预留2',
   col3                 varchar(128) comment '预留3',
   primary key (id)
);

/*==============================================================*/
/* Table: t_role_auth                                           */
/*==============================================================*/
create table t_role_auth
(
   role_id              int not null comment '角色主键',
   auth_id              int not null comment '权限主键',
   primary key (role_id, auth_id)
);

alter table t_role_auth comment '角色权限中间表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null comment '主键',
   real_name            varchar(128) not null comment '真实姓名',
   id_number            varchar(128) not null comment '身份证号',
   account              varchar(128) not null comment '账号',
   password             varchar(128) not null comment '密码',
   stu_class            varchar(128) not null comment '学生班级',
   dormitory            varchar(128) comment '宿舍号+床号',
   grade                varchar(128) not null comment '大几',
   phone                varchar(128) comment '手机号码',
   email                varchar(128) comment '邮箱地址',
   addr                 varchar(128) comment '家庭住址',
   politics             varchar(128) comment '政治面貌',
   birth                date comment '不带时分秒',
   nation               varchar(128) comment '民族',
   sex                  varchar(128) comment '性别',
   middle_school        varchar(128) comment '高中',
   native_place         varchar(128) comment '籍贯',
   tel                  varchar(128) comment '家庭电话',
   col1                 varchar(128) comment '预留1',
   col2                 text comment '预留2',
   col3                 varchar(128) comment '预留3',
   primary key (id)
);

alter table t_user comment '管理员、教师、学生都是属于用户';

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   user_id              int not null comment '用户主键',
   role_id              int not null comment '角色主键',
   primary key (user_id, role_id)
);

alter table t_user_role comment '用户角色中间表';

alter table t_basic_user add constraint FK_Reference_1 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_message add constraint FK_Reference_7 foreign key (user_id)
      references t_basic_user (id) on delete restrict on update restrict;

alter table t_role_auth add constraint FK_Reference_3 foreign key (auth_id)
      references t_auth (id) on delete restrict on update restrict;

alter table t_role_auth add constraint FK_Reference_4 foreign key (role_id)
      references t_role (id) on delete restrict on update restrict;

alter table t_user_role add constraint FK_Reference_5 foreign key (role_id)
      references t_role (id) on delete restrict on update restrict;

alter table t_user_role add constraint FK_Reference_6 foreign key (user_id)
      references t_basic_user (id) on delete restrict on update restrict;
