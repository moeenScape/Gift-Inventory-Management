create table depot (
    id bigint not null auto_increment,
    depot_name varchar(255),
    location varchar(255),
    userid int,
    primary key (id),
    foreign key (userid) references user(userid)
);