CREATE TABLE `meudb`.`usuarios`
(
    id           bigint       NOT NULL AUTO_INCREMENT,
    nome         varchar(100) NOT NULL,
    email        varchar(100) NOT NULL,
    senha        varchar(100) NOT NULL,
    tipo_usuario char(1)      NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY email (email)
);

CREATE TABLE `meudb`.`anuncios`
(
    id                bigint       NOT NULL AUTO_INCREMENT,
    id_usuario        bigint                DEFAULT NULL,
    area_conhecimento varchar(100)          DEFAULT NULL,
    descricao         varchar(100) NOT NULL,
    telefone          varchar(20)  NOT NULL,
    email             varchar(100) NOT NULL,
    data_inicio       date                  DEFAULT NULL,
    data_fim          date                  DEFAULT NULL,
    exibir            char(1)      NOT NULL,
    localidade        varchar(100) NOT NULL,
    status            char(1)      NOT NULL DEFAULT '1',
    PRIMARY KEY (id),
    KEY               idUsuario (id_usuario),
    CONSTRAINT anuncios_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES usuarios (id)
);