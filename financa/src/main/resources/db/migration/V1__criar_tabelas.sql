CREATE SEQUENCE IF NOT EXISTS usuario_id_seq;
CREATE SEQUENCE IF NOT EXISTS tipo_financa_id_seq;
CREATE SEQUENCE IF NOT EXISTS projeto_id_seq;
CREATE SEQUENCE IF NOT EXISTS financa_id_seq;

CREATE TABLE IF NOT EXISTS public.usuario(
    id integer NOT NULL DEFAULT nextval('usuario_id_seq'),
    created_at timestamp without time zone NOT NULL default current_timestamp,
    deletado boolean NOT NULL  default false,
    login varchar(30) NOT NULL,
    senha varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    cpf varchar(15) NOT NULL,
    nome varchar(255) NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.tipo_financa(
    id integer NOT NULL DEFAULT nextval('tipo_financa_id_seq'),
    created_at timestamp without time zone NOT NULL default current_timestamp,
    deletado boolean NOT NULL default false,
    nome varchar(255) not null,
    CONSTRAINT pk_tipo_financa PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.projeto(
    id integer NOT NULL DEFAULT nextval('projeto_id_seq'),
    created_at timestamp without time zone NOT NULL default current_timestamp,
    deletado boolean NOT NULL default false,
    titulo varchar(255) not null,
    saldo float NOT NULL default 0,
    CONSTRAINT pk_projeto PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.projeto_tem_usuario(
    fk_projeto_id int NOT NULL,
    fk_usuario_id int NOT NULL,
    CONSTRAINT fk_projeto
        FOREIGN KEY(fk_projeto_id)
        REFERENCES projeto(id),
    CONSTRAINT fk_usuario
        FOREIGN KEY(fk_usuario_id)
        REFERENCES usuario(id),
    CONSTRAINT pk_projeto_tem_usuario PRIMARY KEY (fk_projeto_id, fk_usuario_id)
);

CREATE TABLE IF NOT EXISTS public.financa(
    id integer NOT NULL DEFAULT nextval('financa_id_seq'),
    created_at timestamp without time zone NOT NULL default current_timestamp,
    deletado boolean NOT NULL default false,
    fk_projeto_id int NOT NULL,
    fk_usuario_id int NOT NULL,
    fk_tipo_financa_id int NOT NULL,
    valor float NOT NULL,
    CONSTRAINT fk_projeto_financa
        FOREIGN KEY(fk_projeto_id)
        REFERENCES projeto(id),
    CONSTRAINT fk_usuario_financa
        FOREIGN KEY(fk_usuario_id)
        REFERENCES usuario(id),
    CONSTRAINT fk_tipo_financa_financa
        FOREIGN KEY(fk_tipo_financa_id)
        REFERENCES tipo_financa(id),
    CONSTRAINT pk_financa PRIMARY KEY (id)
);

