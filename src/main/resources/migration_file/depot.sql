create table depot (
    depot_id bigint not null auto_increment,
    depotName varchar(255),
    location varchar(255),
    user_id bigint,
    primary key (depot_id)
    );