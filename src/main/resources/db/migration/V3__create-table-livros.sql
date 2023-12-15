create table livros (
    id bigint not null auto_increment,
    ativo tinyint not null,
    titulo varchar(100) not null,
    descricao varchar(255) not null,
    numero_paginas smallint not null,
    idioma varchar(100) not null,
    autor_id bigint not null,
    editora_id bigint not null,
    data_publicacao date not null,
    preco decimal(6,2) not null,

    primary key(id),
    constraint fk_livros_autor_id foreign key(autor_id) references autores(id),
    constraint fk_livros_editora_id foreign key(editora_id) references editoras(id)
);
