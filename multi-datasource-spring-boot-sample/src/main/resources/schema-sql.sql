use test_commodity;
drop table if exists `commodity`;
create table if not exists `commodity` (
    `id` int not null auto_increment,
    `commodity_name` varchar(10) not null,
    `commodity_price` decimal not null,
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`id`)
) default charset=utf8;

use test_user;
drop table if exists `user`;
create table if not exists `user` (
    `id` int not null auto_increment,
    `user_name` varchar(10) not null,
    `create_time` timestamp not null default current_timestamp,
    `update_time` timestamp not null default current_timestamp on update current_timestamp,
    primary key (`id`)
) default charset =utf8;
