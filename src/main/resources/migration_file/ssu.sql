--create Sample section Unit table
create table sample_section_unit(
ssuid int Not NULL,
ssu_name varchar(250),
location varchar(250),
number_of_employee int,
foreign key (user_id) references user(id),
CONSTRAINT sample_section_unit_pk PRIMARY KEY (ssuID)
);
insert into sample_section_unit(ssuID,ssuName,location,numberOfEmployee) value(101,"DPG","Pabna",20);
insert into sample_section_unit(ssuID,ssuName,location,numberOfEmployee) value(102,"DSO","Dhaka",25);
insert into sample_section_unit(ssuID,ssuName,location,numberOfEmployee) value(103,"DU","Gazipur",20);