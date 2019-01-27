drop table user if exists;
CREATE TABLE `user` (
  `id` bigint generated by default as identity,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) default NULL,
  `age` int(11) default NULL,
  `balance` decimal(10,0) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8;

