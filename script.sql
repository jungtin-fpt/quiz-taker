drop database LAB321_0014;

CREATE DATABASE	LAB321_0014

go
use LAB321_0014;


go
create table account(
	email varchar(255) not null primary key,
	name nvarchar(255) not null,
	password varchar(255) not null,
	role varchar(50) not null,
	status varchar(50) not null,
	create_date datetime default CURRENT_TIMESTAMP
)

go
create table subject(
	id int identity(1, 1) not null primary key,
	name nvarchar(255) unique not null,
	create_date datetime default CURRENT_TIMESTAMP
)

go
create table quiz(
	id int identity(1, 1) not null primary key,
	name nvarchar(255) not null,
	timeout int not null,
	subject_id int not null FOREIGN KEY REFERENCES subject(id),
	create_date datetime default CURRENT_TIMESTAMP
)

go
create table question(
	id int identity(1, 1) not null primary key,
	title ntext not null,
	answer_1 ntext not null,
	answer_2 ntext not null,
	answer_3 ntext not null,
	answer_4 ntext not null,
	correct_answer int not null,
	status bit not null,
	quiz_id int not null FOREIGN KEY REFERENCES quiz(id),
	create_date datetime default CURRENT_TIMESTAMP
)


go
insert into subject(name) values(N'Toán');
insert into subject(name) values(N'Văn');
insert into subject(name) values(N'Anh');

insert into quiz(name, timeout, subject_id) values(N'Quiz 1', 60, 1);

insert into question(
	title, 
	answer_1, 
	answer_2, 
	answer_3, 
	answer_4, 
	correct_answer,
	status,
	quiz_id
) values(
	N'Số cần điền vào: ….. – 2 = 3 là:', 
	N'1',
	N'5',
	N'9',
	N'11',
	2,
	1,
	1
);