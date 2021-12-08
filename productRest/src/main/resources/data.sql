
create table PRODUTO (
		id int AUTO_INCREMENT PRIMARY KEY,
        descricao varchar(255),
        nome varchar(255),
        preco double not null,
        primary key (id)
    );

INSERT INTO PRODUTO(nome, descricao, preco) VALUES('Copo', 'Copo da vovó', 55);
INSERT INTO PRODUTO(nome, descricao, preco) VALUES('Copo', 'Copo da tio', 77);
INSERT INTO PRODUTO(nome, descricao, preco) VALUES('Copo', 'Copo da mae', 120);
INSERT INTO PRODUTO( nome, descricao, preco) VALUES('Camiseta', 'Camiseta do flamengo', 199.99);
INSERT INTO PRODUTO(nome, descricao, preco) VALUES('Ventilador', 'Ventilador Mondial', 79.00);
INSERT INTO PRODUTO(nome, descricao, preco) VALUES('Copo', 'Copo do filho', 120);
INSERT INTO PRODUTO(nome, descricao, preco) VALUES('Copo', 'Copo da pai', 99);

