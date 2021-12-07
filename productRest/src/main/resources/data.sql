create table USUARIO (
		id int AUTO_INCREMENT PRIMARY KEY,
        email varchar(255),
        nome varchar(255),
        senha varchar(255),
        primary key (id)
    );
create table PRODUTO (
		id int AUTO_INCREMENT PRIMARY KEY,
        descricao varchar(255),
        nome varchar(255),
        preco double not null,
        primary key (id)
    );
INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '123456');

INSERT INTO PRODUTO(nome, descricao, preco) VALUES('Copo', 'Copo da vovó', 55);
INSERT INTO PRODUTO( nome, descricao, preco) VALUES('Camiseta', 'Camiseta do flamengo', 199.99);
INSERT INTO PRODUTO(nome, descricao, preco) VALUES('Ventilador', 'Ventilador Mondial', 79.00);

