drop table if exists user;
drop table if exists loginLog;

create table user (
  userId integer identity primary key,
  userName varchar(30) not null,
  password varchar(32) not null,
  lastVisit datetime,
  lastIp varchar(23)
);


create table loginLog (
  loginLogId integer identity primary key,
  userId integer not null,
  ip varchar(23),
  loginDate datetime
);

insert into user (userName , password) values ('admin','123456');