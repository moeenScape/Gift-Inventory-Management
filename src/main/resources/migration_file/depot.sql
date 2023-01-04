create table depot (
    id bigint not null auto_increment,
    depot_name varchar(255),
    location varchar(255),
    user_id bigint,
    primary key (id),
    foreign key (user_id) references user(id)
);