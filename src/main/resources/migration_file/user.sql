--create Table for User
create table user (
    id bigint auto_increment,
    first_name varchar(250),
    last_name varchar(250),
    email varchar(250),
    contact_number varchar(11), -- can we write phone number
    password varchar(250),
    role varchar(10),
    status varchar(10),
    otp varchar(64),
    otp_generation_time datetime,
    CONSTRAINT user_pk PRIMARY KEY (id) -- discuss with me
);

--insert
--password 123456
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Krishan','Rocha','depotadmin1@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Chantelle','David','depotadmin2@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Brogan','Macdonald','depotadmin3@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Adam','Moon','depotadmin4@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Youssef','Guerrero','depotadmin5@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Ammar','Klein','depotadmin6@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Jacques','Schaefer','depotadmin7@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Marina','Wilso','depotadmin8@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Alannah','Shah','depotadmin9@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Heath','Green','depotadmin10@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Anish','Douglas','depotadmin11@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Laurie','Blaese','depotadmin12@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Cade','Leblanc','depotadmin13@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Erika','Combs','depotadmin14@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Amber','Wall','depotadmin15@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Nikodem','Doherty','depotadmin16@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Vanessa','Patel','depotadmin17@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Izabella','Gardner','depotadmin18@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Ehsan','Pena','depotadmin19@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Marie','Le','depotadmin20@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Sara','Pace','depotadmin21@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Nabil','Sanchez','depotadmin22@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Mia','Holman','depotadmin23@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Floyd','Gonzalez','depotadmin24@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Hazel','Bridges','depotadmin25@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');
insert into user (first_name, last_name, email, contact_number, password, role, status) values ('Alastair','Glass','depotadmin26@gmail.com','01712345678', '$2a$10$GwbVJnEZrvfJf0znBtU2.eyVvUDEn.wnTEViwTA2j0MptgO2fjgNe', 'depot', 'true');