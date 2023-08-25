CREATE SCHEMA SA;
USE SA;

CREATE TABLE IF NOT EXISTS contato (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO contato(nome, email) VALUES('Ana Clara','ana.clara@gmail.com');
INSERT INTO contato(nome, email) VALUES('Joao Pedro','joao.pedro@gmail.com');
