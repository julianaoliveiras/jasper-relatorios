-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Maio-2021 às 21:12
-- Versão do servidor: 10.4.19-MariaDB
-- versão do PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `programacaodesktop`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_pedido`
--

CREATE TABLE `itens_pedido` (
  `numero_pedido` int(6) DEFAULT NULL,
  `preco_unitario` decimal(6,2) DEFAULT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  `quantidade` int(6) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `itens_pedido`
--

INSERT INTO `itens_pedido` (`numero_pedido`, `preco_unitario`, `descricao`, `quantidade`) VALUES
(1, '10.00', 'Uva', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `numero_pedido` int(6) NOT NULL,
  `NF` int(6) NOT NULL,
  `data_pedido` varchar(11) NOT NULL,
  `id_pessoa` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`numero_pedido`, `NF`, `data_pedido`, `id_pessoa`) VALUES
(1, 1, '17/05/2021', 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id_pessoa` int(6) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(300) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `sexo` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id_pessoa`, `nome`, `endereco`, `cpf`, `telefone`, `sexo`) VALUES
(4, 'Maria', 'Rua Ruby', '000.000.000-00', '(00)00000-0000', 'F'),
(5, 'Carla', 'Rua Diamante', '000.000.000-01', '(00)00000-0001', 'F'),
(6, 'Ana', 'Rua Esmeralda', '000.000.000-03', '(00)00000-0003', 'F'),
(8, 'Miguel', 'Rua Prata', '000.000.000-05', '(00)00000-0005', 'M');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(6) NOT NULL,
  `descricao` varchar(300) NOT NULL,
  `marca` varchar(200) NOT NULL,
  `preco_unitario` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `descricao`, `marca`, `preco_unitario`) VALUES
(4, 'Morango', 'Nacional', '10.00'),
(5, 'Uva', 'Niagra', '10.00'),
(6, 'Pera', 'Importada', '10.00'),
(7, 'Arroz', 'Tio João', '30.00'),
(8, 'Macarrão', 'Galo', '5.00'),
(9, 'Azeite', 'Andorinha', '25.00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `itens_pedido`
--
ALTER TABLE `itens_pedido`
  ADD KEY `FK_numero_pedido` (`numero_pedido`);

--
-- Índices para tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`numero_pedido`),
  ADD UNIQUE KEY `NF` (`NF`),
  ADD KEY `FK_id_pessoa` (`id_pessoa`);

--
-- Índices para tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id_pessoa`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `NF` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id_pessoa` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `itens_pedido`
--
ALTER TABLE `itens_pedido`
  ADD CONSTRAINT `FK_numero_pedido` FOREIGN KEY (`numero_pedido`) REFERENCES `pedido` (`numero_pedido`);

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_id_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
