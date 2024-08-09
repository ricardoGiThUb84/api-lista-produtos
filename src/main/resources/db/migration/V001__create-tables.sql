create table item_lista (
id bigint not null auto_increment,
preco decimal(19,2) not null,
quantidade integer not null,
id_lista bigint not null,
id_produto bigint not null,
primary key (id)
) engine=InnoDB DEFAULT CHARACTER SET = utf8;

create table lista (
id bigint not null auto_increment,
descricao varchar(255) not null,
preco decimal(19,2) not null,
usuario_id bigint not null,
primary key (id)
) engine=InnoDB DEFAULT CHARACTER SET = utf8;

create table produto (
id bigint not null auto_increment,
condicao varchar(100) not null,
descricao text not null,
porcentagem decimal(19,2) not null,
preco decimal(19,2) not null,
preco_desconto decimal(19,2) not null,
primary key (id)
) engine=InnoDB DEFAULT CHARACTER SET = utf8;

create table roles (
id bigint not null auto_increment,
role varchar(80),
primary key (id)
) engine=InnoDB DEFAULT CHARACTER SET = utf8;

create table usuario (
id bigint not null auto_increment,
cpf varchar(11),
nome varchar(150),
senha varchar(255),
username varchar(80),
primary key (id)
) engine=InnoDB DEFAULT CHARACTER SET = utf8;

create table usuario_roles (
usuario_id bigint not null,
roles_id bigint not null
) engine=InnoDB DEFAULT CHARACTER SET = utf8;

alter table item_lista add constraint item_lista_lista foreign key (id_lista) references lista (id);
alter table item_lista add constraint item_lista_produto foreign key (id_produto) references produto (id);
alter table lista add constraint lista_usuario foreign key (usuario_id) references usuario (id);
alter table usuario_roles add constraint usuario_roles_roles foreign key (roles_id) references roles (id);
alter table usuario_roles add constraint usuario_roles_usuario foreign key (usuario_id) references usuario (id);



