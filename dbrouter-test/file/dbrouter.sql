create schema if not exists simple_user;
create schema if not exists simple_user_001;
create schema if not exists simple_user_002;

use simple_user;

create table if not exists simple_user_table_001
(
    id bigint(11) auto_increment comment '主键',
    name varchar(64) null comment '用户名称',
    age int null comment '年龄',
    sex varchar(20) null comment '性别',
    create_time timestamp default current_timestamp null comment '创建时间',
    update_time timestamp default current_timestamp null comment '更新时间',
    constraint simple_user_table_pk
        primary key (id)
)
    comment '简单的用户表';

create table if not exists simple_user_table_002
(
    id bigint(11) auto_increment comment '主键',
    name varchar(64) null comment '用户名称',
    age int null comment '年龄',
    sex varchar(20) null comment '性别',
    create_time timestamp default current_timestamp null comment '创建时间',
    update_time timestamp default current_timestamp null comment '更新时间',
    constraint simple_user_table_pk
        primary key (id)
)
    comment '简单的用户表';

use simple_user_001;

create table if not exists simple_user_table_001
(
    id bigint(11) auto_increment comment '主键',
    name varchar(64) null comment '用户名称',
    age int null comment '年龄',
    sex varchar(20) null comment '性别',
    create_time timestamp default current_timestamp null comment '创建时间',
    update_time timestamp default current_timestamp null comment '更新时间',
    constraint simple_user_table_pk
    primary key (id)
    )
    comment '简单的用户表';

create table if not exists simple_user_table_002
(
    id bigint(11) auto_increment comment '主键',
    name varchar(64) null comment '用户名称',
    age int null comment '年龄',
    sex varchar(20) null comment '性别',
    create_time timestamp default current_timestamp null comment '创建时间',
    update_time timestamp default current_timestamp null comment '更新时间',
    constraint simple_user_table_pk
    primary key (id)
    )
    comment '简单的用户表';


use simple_user_002;

create table if not exists simple_user_table_001
(
    id bigint(11) auto_increment comment '主键',
    name varchar(64) null comment '用户名称',
    age int null comment '年龄',
    sex varchar(20) null comment '性别',
    create_time timestamp default current_timestamp null comment '创建时间',
    update_time timestamp default current_timestamp null comment '更新时间',
    constraint simple_user_table_pk
    primary key (id)
    )
    comment '简单的用户表';

create table if not exists simple_user_table_002
(
    id bigint(11) auto_increment comment '主键',
    name varchar(64) null comment '用户名称',
    age int null comment '年龄',
    sex varchar(20) null comment '性别',
    create_time timestamp default current_timestamp null comment '创建时间',
    update_time timestamp default current_timestamp null comment '更新时间',
    constraint simple_user_table_pk
    primary key (id)
    )
    comment '简单的用户表';