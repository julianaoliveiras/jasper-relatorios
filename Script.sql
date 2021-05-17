CREATE DATABASE lojaCabaitePOO;
USE lojaCabaitePOO;

CREATE TABLE pessoa
	(id_pessoa integer(6) PRIMARY KEY AUTO_INCREMENT,
     		nome varchar(100) NOT null,
	 		endereco varchar(300) NOT null,
	 			cpf varchar(20) NOT null UNIQUE,
     					telefone varchar(20) NOT null,
    						sexo varchar(2) NOT null);
					
CREATE	TABLE produto
	(id_produto integer(6) PRIMARY KEY AUTO_INCREMENT, 
     		descricao varchar(300) NOT null, 
	 		marca varchar(200) NOT null, 
     				preco_unitario decimal(6,2) NOT null);			
		
CREATE TABLE pedido
     (numero_pedido integer(6) PRIMARY KEY,
      	NF integer(6) AUTO_INCREMENT UNIQUE,
      		data_pedido varchar(11) NOT null,
      			id_pessoa integer(6),
      				CONSTRAINT FK_id_pessoa FOREIGN KEY (id_pessoa) 								
					REFERENCES pessoa (id_pessoa));
					
CREATE TABLE itens_pedido (
	numero_pedido integer(6), 
	preco_unitario decimal(6,2), 
	descricao varchar(300), 
	quantidade integer(6) unsigned NOT null, 
	CONSTRAINT FK_numero_pedido FOREIGN KEY (numero_pedido) REFERENCES pedido (numero_pedido));

	 
# DADOS
	 
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `endereco`, `cpf`, `telefone`, `sexo`) VALUES ('1', 'Julio', 'rua de barro', '123', '3223', 'M');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `endereco`, `cpf`, `telefone`, `sexo`) VALUES ('2', 'Patrick', 'rua de barro', '321', '3223', 'M');
INSERT INTO `pessoa` (`id_pessoa`, `nome`, `endereco`, `cpf`, `telefone`, `sexo`) VALUES ('3', 'Agatha', 'rua de barro', '323', '3223', 'F');

INSERT INTO `produto` (`id_produto`, `descricao`, `preco_unitario`) VALUES ('1', 'HD', 300);
INSERT INTO `produto` (`id_produto`, `descricao`, `preco_unitario`) VALUES ('2', 'SSD', 500);
INSERT INTO `produto` (`id_produto`, `descricao`, `preco_unitario`) VALUES ('3', 'GPU', 1000);
