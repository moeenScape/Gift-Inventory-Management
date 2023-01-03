create table depot (
    id bigint not null auto_increment,
    depotName varchar(255),
    location varchar(255),
    userId int,
    primary key (id),
    foreign key (userId) references user(userId)
);