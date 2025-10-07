create table if not exists Taco (
 id identity,
 name varchar(50) not null,
 TACO_CLOUD_ORDER_KEY bigint not null,
 created_at timestamp not null
);

create table if not exists Ingredients (
 id varchar(4) not null,
 name varchar(25) not null,
 type varchar(10) not null
);

 alter table Ingredients add primary key (id);


