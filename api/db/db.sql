create table ojbase_Judgedata
(
    id     int auto_increment
        primary key,
    sid    int  null,
    input  text null,
    answer text null
);

create table ojbase_User
(
    id       int auto_increment
        primary key,
    UserName varchar(128) charset utf8mb3 null,
    Password varchar(64)                  null,
    Email    varchar(64)                  null,
    Phone    varchar(128)                 null,
    Name     varchar(64)                  null
);

create table ojbase_problem
(
    id          int auto_increment
        primary key,
    subName     varchar(128) null,
    subDetailed text         null,
    subLevel    int          null,
    userid      int          null,
    subMemroy   int          null,
    subRuntime  int          null,
    create_time time         null,
    tag         varchar(128) null
);

create table ojbase_recode
(
    rid         int auto_increment
        primary key,
    userid      int         null,
    create_time time        null,
    status      varchar(64) null,
    Memroy      int         null,
    runtime     int         null,
    Code        text        null
);

