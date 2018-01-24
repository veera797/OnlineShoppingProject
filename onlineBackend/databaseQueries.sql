create table category(
id IDENTITY,
name varchar(255),
description varchar(255),
image_url varchar(50),
is_ACTIVE boolean,

constraint pk_category_id primary key (id)
);