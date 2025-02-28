CREATE DATABASE IF NOT EXISTS db_dao;
USE db_dao;

CREATE TABLE users (
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(45) not null
);

select * from users;