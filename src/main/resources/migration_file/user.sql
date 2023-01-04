--create Table for User
create table user (
    id bigint auto_increment,
    first_name varchar(250),
    last_name varchar(250),
    email varchar(250),
    contact_number varchar(11),
    password varchar(10),
    role varchar(10),
    status varchar(10),

    CONSTRAINT user_pk PRIMARY KEY (id)
);

--insert
insert into user(id,first_name,last_name,email,contract_number,password,role,status)
value(?,?,?,?,?,?,?,?);