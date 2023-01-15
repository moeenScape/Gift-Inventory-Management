create table log_in_details(
id bigint not null auto_increment,
    log_in_status varchar(255),
    lof_in_time datetime, -- lof ??
    log_out_time datetime,
    user_id bigint,
    user_email varchar(250),
    ip varchar(250),
    primary key(id)
)