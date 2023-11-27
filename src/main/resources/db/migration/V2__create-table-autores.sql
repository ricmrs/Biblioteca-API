create table autores (
    id bigint not null auto_increment,
    ativo tinyint not null,
    nome varchar(100) not null,
    sobre varchar(255),

    primary key(id)
);