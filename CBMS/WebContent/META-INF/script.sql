CREATE DATABASE "CBMS_V1.0"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;
       
   
CREATE TABLE product_catalog
(
  prd_catlog_id integer NOT NULL,
  prd_name character varying(60) NOT NULL,
  prd_code character varying(30) NOT NULL,
  usr_def_code character varying(10),
  description character varying(150),
  purchase_price double precision,
  sale_price double precision,
  qty_in_hand integer,
  shelf_life smallint,
  rack_code character varying(10),
  warranty smallint,
  added_date date,
  added_by character varying(20),
  stat_code smallint,
  CONSTRAINT catlog_pkey PRIMARY KEY (prd_catlog_id),
  CONSTRAINT product_catalog_prd_name_key UNIQUE (prd_name)
);

CREATE TABLE customer
(
  cust_id integer NOT NULL,
  name character varying(50) NOT NULL,
  address character varying(200),
  phone_office character varying(15),
  phone_mobile character varying(15) NOT NULL,
  skype character varying(20),
  viber character varying(20),
  email character varying(30),
  nic character varying(15),
  country character varying(25),
  city character varying(25),
  added_date date,
  added_by character varying(20),
  stat_code smallint,
  CONSTRAINT cust_pkey PRIMARY KEY (cust_id)
);

CREATE TABLE sale_inv_header
(
  sale_inv_id integer NOT NULL,
  hdr_remark character varying(150),
  inv_date date NOT NULL,
  grand_total double precision,
  so_id integer,
  cust_id integer,
  max_cr_period smallint,
  added_date date,
  added_by character varying(20),
  stat_code smallint,
  sub_total double precision,
  CONSTRAINT sale_inv_hdr_pkey PRIMARY KEY (sale_inv_id),
  CONSTRAINT sale_inv_hdr_cust_id_fkey FOREIGN KEY (cust_id)
      REFERENCES customer (cust_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE RESTRICT
);

CREATE TABLE sale_inv_detail
(
  sale_inv_det_id bigint NOT NULL,
  unit_price double precision,
  quantity smallint,
  total double precision,
  discount double precision,
  net_total double precision,
  det_remark character varying(150),
  sale_inv_id integer,
  prd_catlog_id integer,
  added_date date,
  added_by character varying(20),
  stat_code smallint,
  CONSTRAINT sale_inv_det_pkey PRIMARY KEY (sale_inv_det_id),
  CONSTRAINT sale_inv_det_prd_catlog_id_fkey FOREIGN KEY (prd_catlog_id)
      REFERENCES product_catalog (prd_catlog_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE RESTRICT,
  CONSTRAINT sale_inv_det_sup_inv_id_fkey FOREIGN KEY (sale_inv_id)
      REFERENCES sale_inv_header (sale_inv_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE RESTRICT
);


CREATE TABLE user_type
(	
  id smallint NOT NULL,
  user_type character varying(20) NOT NULL,
  stat_code smallint,
  CONSTRAINT user_type_id_pkey PRIMARY KEY (id)
);

CREATE TABLE sys_user
(	
  id smallint NOT NULL,
  user_name character varying(20) NOT NULL,
  password character varying(300) NOT NULL, 
  lock_state character varying(1),
  login_fail_count smallint,
  user_type character varying(15),
  access_type character varying(10),
  added_date date,
  added_by character varying(20),
  stat_code smallint,
  CONSTRAINT sys_user_id_pkey PRIMARY KEY (id)
);

CREATE TABLE login_user
(	
  id smallint NOT NULL,
  user_name character varying(20),
  user_type_id smallint NOT NULL, 
  sys_user_id smallint NOT NULL,  
  stat_code smallint,
  CONSTRAINT log_usr_id_pkey PRIMARY KEY (id)
  
);

 
CREATE TABLE user_role
(  
  id smallint NOT NULL,
  user_id smallint NOT NULL,
  module_id smallint NOT NULL,
  sub_module_id smallint,
  func_id smallint NOT NULL,
  added_date date,
  added_by character varying(20),
  stat_code smallint,
  CONSTRAINT user_role_pkey PRIMARY KEY (id),
  CONSTRAINT user_role_usr_id_fkey FOREIGN KEY (user_id)
      REFERENCES sys_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE RESTRICT
  
);
 

CREATE SEQUENCE "customer_seq" INCREMENT BY 1 NO MINVALUE MAXVALUE 9999999 START WITH 1 CYCLE;
CREATE SEQUENCE "login_user_seq" INCREMENT BY 1 NO MINVALUE MAXVALUE 99999999 START WITH 1 CYCLE;
CREATE SEQUENCE "product_catalog_seq" INCREMENT BY 1 NO MINVALUE MAXVALUE 99999 START WITH 1 CYCLE;
CREATE SEQUENCE "sale_inv_detail_seq" INCREMENT BY 1 NO MINVALUE MAXVALUE 99999999 START WITH 1 CYCLE;
CREATE SEQUENCE "sale_inv_header_seq" INCREMENT BY 1 NO MINVALUE MAXVALUE 9999999 START WITH 1 CYCLE;
CREATE SEQUENCE "sys_user_seq" INCREMENT BY 1 NO MINVALUE MAXVALUE 9999 START WITH 5 CYCLE;
CREATE SEQUENCE "user_type_seq" INCREMENT BY 1 NO MINVALUE MAXVALUE 9999 START WITH 1 CYCLE;
 
