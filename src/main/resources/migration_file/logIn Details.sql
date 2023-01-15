create table log_in_details(
id bigint not null auto_increment,
    log_in_status varchar(255),
    lod_in_at datetime,
    log_out_at datetime,
    user_id bigint,
    user_email varchar(250),
    device_ip varchar(250),
    primary key(id)
)