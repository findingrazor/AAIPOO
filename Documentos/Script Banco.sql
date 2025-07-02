use loja;

CREATE TABLE cliente(
	codCliente int identity not null,
    nome varchar (40) not null,
    cpf char (11) not null,
    endereço varchar(40) null,
    telefone char(12) not null,
    email varchar (40) null
);

CREATE TABLE pedido(
	codPedido int identity not null,
    codCliente int not null,
    codPag int not null
);

CREATE TABLE pagamento(
	codPag int identity not null,
    formaPag varchar (11) not null
);

CREATE TABLE detalhes(
	codPedido int not null,
    codProduto int not null,
    qntdProd int not null,
	valorUni float not null,
    desconto float null,
    valorTotal float not null
);

CREATE TABLE produto(
	codProduto int identity not null,
	nome varchar(40) not null,
    codMidia int not null,
    codGenero int not null,
    qntdEstoque int not null,
    preco float not null
);

CREATE TABLE midia(
	codMidia int identity not null,
    tipo varchar(5) not null
);

CREATE TABLE genero(
	codGenero int identity not null,
    genero varchar(7)
);

ALTER TABLE cliente ADD CONSTRAINT pk_cliente_codCliente PRIMARY KEY (codCliente);
ALTER TABLE pedido ADD CONSTRAINT pk_pedido_codPedido PRIMARY KEY (codPedido);
ALTER TABLE pagamento ADD CONSTRAINT pk_pagamento_codPag PRIMARY KEY (codPag);
ALTER TABLE detalhes ADD CONSTRAINT pk_detalhes_codPedCodProd PRIMARY KEY (codPedido, codProduto);
ALTER TABLE produto ADD CONSTRAINT pk_produto_codProduto PRIMARY KEY (codProduto);
ALTER TABLE midia ADD CONSTRAINT pk_midia_codMidia PRIMARY KEY (codMidia);
ALTER TABLE genero ADD CONSTRAINT pk_genero_codGenero PRIMARY KEY (codGenero);

ALTER TABLE pedido ADD CONSTRAINT fk_pedido_codCliente FOREIGN KEY (codCliente) REFERENCES cliente (codCliente);
ALTER TABLE pedido ADD CONSTRAINT fk_pedido_codPag FOREIGN KEY (codPag) REFERENCES pagamento (codPag);
ALTER TABLE detalhes ADD CONSTRAINT fk_detalhes_codPedido FOREIGN KEY (codPedido) REFERENCES pedido (codPedido);
ALTER TABLE detalhes ADD CONSTRAINT fk_detalhes_codProduto FOREIGN KEY (codProduto) REFERENCES produto (codProduto);
ALTER TABLE produto ADD CONSTRAINT fk_produto_codMidia FOREIGN KEY (codMidia) REFERENCES midia (codMidia);
ALTER TABLE produto ADD CONSTRAINT fk_produto_codGenero FOREIGN KEY (codGenero) REFERENCES genero (codGenero);

ALTER TABLE cliente ADD CONSTRAINT uq_cliente_cpf UNIQUE (cpf);
ALTER TABLE pagamento ADD CONSTRAINT uq_pagamento_formaPag UNIQUE (formaPag);
ALTER TABLE midia ADD CONSTRAINT uq_midia_tipo UNIQUE (tipo);
ALTER TABLE genero ADD CONSTRAINT uq_genero_genero UNIQUE (genero);

ALTER TABLE cliente ADD CONSTRAINT df_cliente_email DEFAULT 'sememail@nada.com' FOR email;

ALTER TABLE detalhes ADD CONSTRAINT vlrTotal_ck CHECK (valorTotal > 0);

INSERT INTO pagamento (formaPag) VALUES
('Débito'),
('Crédito'),
('Dinheiro'),
('Pix');

INSERT INTO midia (tipo) VALUES
('CD'),
('LP'),
('DVD');

INSERT INTO genero (genero) VALUES
('Rock'),
('Pop'),
('Alterna'),
('Indie'),
('MPB');

INSERT INTO cliente (nome, cpf, endereço, telefone, email) VALUES
('Ana Souza', '11111111111', 'Rua das Flores, 100', '11999990001', 'ana@email.com'),
('Bruno Lima', '22222222222', 'Av. Brasil, 200', '11999990002', 'bruno@email.com'),
('Carla Mendes', '33333333333', 'Rua Verde, 300', '11999990003', 'carla@email.com'),
('Diego Tavares', '44444444444', 'Travessa Azul, 400', '11999990004', 'diego@email.com'),
('Elaine Rocha', '55555555555', 'Rua do Sol, 500', '11999990005', 'elaine@email.com'),
('Felipe Ramos', '66666666666', 'Rua Central, 600', '11999990006', 'felipe@email.com'),
('Gabriela Luz', '77777777777', 'Rua Nova, 700', '11999990007', 'gabi@email.com'),
('Henrique Dias', '88888888888', 'Rua das Árvores, 800', '11999990008', 'henrique@email.com'),
('Isabela Martins', '99999999999', 'Rua das Palmeiras, 900', '11999990009', 'isabela@email.com'),
('João Pedro', '00000000000', 'Rua Estrela, 1000', '11999990010', 'joao@email.com');

INSERT INTO produto (nome, codMidia, codGenero, qntdEstoque, preco) VALUES
('Álbum Rock 1', 1, 1, 50, 49.90),
('Pop Collection', 2, 2, 60, 39.90),
('Alterna Vibes', 3, 3, 40, 59.90),
('Indie Dreams', 1, 4, 70, 44.90),
('MPB Essencial', 2, 5, 80, 34.90),
('Clássicos do Rock', 3, 1, 30, 42.50),
('Pop Atual', 1, 2, 20, 38.00),
('Alternativo Vol.2', 2, 3, 25, 47.90),
('Indie Night', 3, 4, 10, 36.70),
('MPB Hits', 1, 5, 15, 41.10);

INSERT INTO pedido (codCliente, codPag) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 1),
(6, 2),
(7, 3),
(8, 4),
(9, 1),
(10, 2);

INSERT INTO detalhes (codPedido, codProduto, qntdProd, valorUni, desconto, valorTotal) VALUES
(1, 1, 2, 49.90, 5.00, 94.80),
(2, 2, 1, 39.90, 0.00, 39.90),
(3, 3, 3, 59.90, 10.00, 169.70),
(4, 4, 1, 44.90, 0.00, 44.90),
(5, 5, 2, 34.90, 5.00, 64.80),
(6, 6, 1, 42.50, 2.50, 40.00),
(7, 7, 1, 38.00, 0.00, 38.00),
(8, 8, 2, 47.90, 5.00, 90.80),
(9, 9, 1, 36.70, 1.70, 35.00),
(10, 10, 1, 41.10, 0.00, 41.10);

/*
DROP TABLE cliente;
DROP TABLE pedido;
DROP TABLE detalhes;
DROP TABLE pagamento;
DROP TABLE genero;
DROP TABLE midia;
DROP TABLE produto;
*/




