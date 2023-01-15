--create Sample section Unit table
create table sample_section_unit(
ssuID int Not NULL, -- use proper convention
ssuName varchar(250), -- use proper convention
location varchar(250),
numberOfEmployee int, -- use proper convention
-- remove this space
CONSTRAINT sample_section_unit_pk PRIMARY KEY (ssuID)
);

insert into sample_section_unit(ssuID,ssuName,location,numberOfEmployee) value(101,"DPG","Pabna",20);
insert into sample_section_unit(ssuID,ssuName,location,numberOfEmployee) value(102,"DSO","Dhaka",25);
insert into sample_section_unit(ssuID,ssuName,location,numberOfEmployee) value(103,"DU","Gazipur",20);