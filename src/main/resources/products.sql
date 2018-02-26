DROP TABLE IF EXISTS t_product;
CREATE TABLE t_product(
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  product_no VARCHAR(32) DEFAULT NULL COMMENT '产品编号',
  product_name VARCHAR(32) DEFAULT NULL COMMENT '产品名称',
  remark VARCHAR(200) DEFAULT NULL COMMENT '备注',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (id)
);

INSERT INTO t_product (id,product_no,product_name,create_time) VALUES (1,'p00001', 'product 1',NOW());
INSERT INTO t_product (id,product_no,product_name,create_time) VALUES (2,'p00002', 'product 2',NOW());
INSERT INTO t_product (id,product_no,product_name,create_time) VALUES (3,'p00003', 'product 3',NOW());
INSERT INTO t_product (id,product_no,product_name,create_time) VALUES (4,'p00004', 'product 4',NOW());