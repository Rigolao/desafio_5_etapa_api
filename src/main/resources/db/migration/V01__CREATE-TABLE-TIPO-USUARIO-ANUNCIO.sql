CREATE TABLE `meudb`.`TIPOUSUARIOS`(
    id BIGINT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE `meudb`.`usuarios` (
    id bigint NOT NULL AUTO_INCREMENT,
    idTipoUsuario bigint not null,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(100) not null,

    PRIMARY KEY (id),
    FOREIGN KEY (idTipoUsuario) REFERENCES TIPOUSUARIOS(id)
);

CREATE TABLE `meudb`.`anuncios` (
    id bigint NOT NULL AUTO_INCREMENT,
    idUsuario bigint NOT NULL,
    areaConhecimento varchar(100) NOT NULL,
    descricao varchar(100) NOT NULL,
    telefone varchar(20) NOT NULL,
    email varchar(100) NOT NULL,
    dataInicio date NOT NULL,
    dataFim date NOT NULL,
    exibir char(1) NOT NULL,
    localidade varchar(100) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (idUsuario) REFERENCES usuarios(id)
);