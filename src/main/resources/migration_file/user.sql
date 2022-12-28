--create Table for User
create table user(
userId int Not NULL,
firstName varchar(250),
lastName varchar(250),
email varchar(250),
contractNumber varchar(11),
password varchar(10),
role varchar(10),
status varchar(10),
userDescription varchar(250),
workPlace varchar(10),
CONSTRAINT user_pk PRIMARY KEY (userId)
);

--insert
insert into user(userId,firstName,lastName,email,contractNumber,password,role,status,userDescription,workPlace)
value(?,?,?,?,?,?,?,?,?,?);