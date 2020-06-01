CREATE TABLE `employee` (
  `e_id` varchar(6) NOT NULL COMMENT '員工編號',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `d_id` varchar(5) NOT NULL COMMENT '部門ID',
  `gender` char(1) NOT NULL COMMENT '性別',
  `phone` varchar(10) NOT NULL COMMENT '電話',
  `address` varchar(1000) NOT NULL COMMENT '地址',
  `age` int NOT NULL COMMENT '年齡',
  `create_time` date NOT NULL COMMENT '建立時間',
  `modify_time` date DEFAULT NULL COMMENT '最後一次修改時間',
  KEY `employee_e_id_IDX` (`e_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8