create table editoras (
    id bigint not null auto_increment,
    ativo tinyint not null,
    nome varchar(100) not null,

    primary key(id)
);