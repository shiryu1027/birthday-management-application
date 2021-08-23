/* テーブル内容のメモ */

CREATE TABLE IF NOT EXISTS celebrated_persons (
	person_id MEDIUMINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40) NOT NULL,
	birth_date DATE NOT NULL,
	age TINYINT UNSIGNED NOT NULL,
	relationship VARCHAR(20))
	DEFAULT CHARSET=utf8;
	
CREATE TABLE IF NOT EXISTS users (
	id MEDIUMINT PRIMARY KEY AUTO_INCREMENT,
	mailAdress VARCHAR(50) NOT NULL,
	password VARCHAR(20) NOT NULL,
	name VARCHAR(40) NOT NULL,
	birthday DATE NOT NULL,
	age TINYINT UNSIGNED NOT NULL)
	DEFAULT CHARSET=utf8;