
create schema banking;

use banking;

CREATE TABLE tbl_user_profile(profile_id INT  PRIMARY KEY AUTO_INCREMENT,first_name VARCHAR(30) NOT NULL,last_name VARCHAR(30) NOT NULL,username VARCHAR(30) NOT NULL UNIQUE,password VARCHAR(70) NOT NULL,phone VARCHAR(10) NOT NULL,email VARCHAR(30) NOT NULL UNIQUE,address VARCHAR(30) NOT NULL,city  VARCHAR(30) NOT NULL,state  VARCHAR(30) NOT NULL,country  VARCHAR(30) NOT NULL,zip INT NOT NULL,id_name VARCHAR(30) NOT NULL,id_number VARCHAR(30) NOT NULL,created_time TIMESTAMP NOT NULL DEFAULT '00-00-0000 00:00:00',updated_time TIMESTAMP NOT NULL DEFAULT CURRENT TIMESTAMP);


 

CREATE TABLE tbl_user_account(acc_id INT PRIMARY KEY,acc_type VARCHAR(20) NOT NULL,profile_id INT NOT NULL,acc_balance INT NOT NULL,debit_card INT(16),card_status VARCHAR(20) NOT NULL DEFAULT 'NOT_ISSUED',acc_created_time TIMESTAMP NOT NULL DEFAULT  '00-00-0000 00:00:00',acc_updated_time TIMESTAMP NOT NULL DEFAULT CURRENT TIMESTAMP,FOREIGN KEY (profile_id) REFERENCES tbl_user_profile(profile_id));





CREATE TABLE tbl_card_details(card_id INT PRIMARY KEY,acc_id INT NOT NULL,card_type VARCHAR(50) NOT NULL,cvv INT NOT NULL,validity TIMESTAMP NOT NULL DEFAULT '00-00-0000 00:00:00',card_status VARCHAR(10) NOT NULL,created_time TIMESTAMP NOT NULL DEFAULT '00-00-0000 00:00:00',updated_time TIMESTAMP NOT NULL DEFAULT CURRENT TIMESTAMP,FOREIGN KEY(acc_id) REFERENCES tbl_user_account(acc_id));
