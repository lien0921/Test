CREATE TABLE `departement` (
  `d_id` varchar(5) NOT NULL COMMENT '部門ID',
  `d_name` varchar(100) NOT NULL COMMENT '部門名稱',
  KEY `departemet_d_id_IDX` (`d_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8