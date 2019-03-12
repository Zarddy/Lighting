DROP TABLE IF EXISTS `spring`.`t_product`;
CREATE TABLE `spring`.`t_product` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `t_name` varchar(30) DEFAULT '' COMMENT '名称',
  `t_thumb` varchar(150) DEFAULT '' COMMENT '缩略图',
  `t_image` varchar(150) DEFAULT '' COMMENT '产品图',
  `t_price` float DEFAULT 0.00 COMMENT '价格',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;