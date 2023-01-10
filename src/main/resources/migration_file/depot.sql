create table depot (
    id bigint not null auto_increment,
    depot_name varchar(255),
    location varchar(255),
    user_id bigint,
    primary key (id),
    foreign key (user_id) references user(id)
);
--insert
insert into depot (depot_name,location,user_id) values ('dpo_bar1','Barishal',1008);
insert into depot (depot_name,location,user_id) values ('dpo_kis2','Kishoreganj',1009);
insert into depot (depot_name,location,user_id) values ('dpo_bog3','Bogura',1010);
insert into depot (depot_name,location,user_id) values ('dpo_mai4','Maizdee',1011);
insert into depot (depot_name,location,user_id) values ('dpo_b.b5','B.Baria',1012);
insert into depot (depot_name,location,user_id) values ('dpo_mou6','Moulavibazar',1013);
insert into depot (depot_name,location,user_id) values ('dpo_cho7','Chottogram',1014);
insert into depot (depot_name,location,user_id) values ('dpo_may8','Maymansing',1015);
insert into depot (depot_name,location,user_id) values ('dpo_cox9','CoxsBazar',1016);
insert into depot (depot_name,location,user_id) values ('dpo_nao10','Naoga',1017);
insert into depot (depot_name,location,user_id) values ('dpo_cum11','Cumilla',1018);
insert into depot (depot_name,location,user_id) values ('dpo_nar12','Narayangonj',1019);
insert into depot (depot_name,location,user_id) values ('dpo_cha13','Chadpur',1020);
insert into depot (depot_name,location,user_id) values ('dpo_pab14','Pabna',1021);
insert into depot (depot_name,location,user_id) values ('dpo_dha15','Dhaka',1022);
insert into depot (depot_name,location,user_id) values ('dpo_raj16','Rajshai',1023);
insert into depot (depot_name,location,user_id) values ('dpo_din17','Dinajpur',1024);
insert into depot (depot_name,location,user_id) values ('dpo_ran18','Rangpur',1025);
insert into depot (depot_name,location,user_id) values ('dpo_far19','Faridpur',1026);
insert into depot (depot_name,location,user_id) values ('dpo_syl20','Sylhet',1027);
insert into depot (depot_name,location,user_id) values ('dpo_fen21','Feni',1028);
insert into depot (depot_name,location,user_id) values ('dpo_tan22','Tangail',1029);
insert into depot (depot_name,location,user_id) values ('dpo_gop23','Gopalganj',1030);
insert into depot (depot_name,location,user_id) values ('dpo_ton24','Tongi',1031);
insert into depot (depot_name,location,user_id) values ('dpo_khu25','Khulna',1032);
insert into depot (depot_name,location,user_id) values ('dpo_jas26','Jashore',1033);