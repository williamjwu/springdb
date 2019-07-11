DROP TABLE IF EXISTS student;
CREATE TABLE student (
	id INT NOT NULL AUTO_INCREMENT,
	create_time DATETIME,
	modify_time DATETIME,
	student_name VARCHAR(255),
	student_age VARCHAR(255),
	student_gender VARCHAR(255),
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher (
	id INT NOT NULL AUTO_INCREMENT,
	create_time DATETIME,
	modify_time DATETIME,
	teacher_name VARCHAR(255),
	teacher_age VARCHAR(255),
	teacher_gender VARCHAR(255),
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS subject;
CREATE TABLE subject (
	id INT NOT NULL AUTO_INCREMENT,
	create_time DATETIME,
	modify_time DATETIME,
	subject_name VARCHAR(255),
	subject_day VARCHAR(255),
	subject_period VARCHAR(255),
	teacher_id INT,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS schedule;
CREATE TABLE schedule (
	id INT NOT NULL AUTO_INCREMENT,
	create_time DATETIME,
	modify_time DATETIME,
	student_id INT,
	subject_id INT,
	teacher_id INT,
	PRIMARY KEY (id)
);
