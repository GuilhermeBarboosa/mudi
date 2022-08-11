-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 11-Ago-2022 às 16:51
-- Versão do servidor: 8.0.29
-- versão do PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `loja`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(60) NOT NULL,
  `valor` decimal(10,0) NOT NULL,
  `data_entrega` date NOT NULL,
  `url_produto` text NOT NULL,
  `url_imagem` text NOT NULL,
  `descricao` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `nome_produto`, `valor`, `data_entrega`, `url_produto`, `url_imagem`, `descricao`) VALUES
(1, 'ACER Notebook Nitro 5 AN515-44-R4KA', '20', '2022-08-17', 'https://www.amazon.com.br/ACER-Notebook-Nitro-AN515-44-R4KA-Windows11/dp/B09ZQ943YL/?_encoding=UTF8&pd_rd_w=orbp5&content-id=amzn1.sym.457c181d-08f4-4901-b7a5-e5a789ccf30b&pf_rd_p=457c181d-08f4-4901-b7a5-e5a789ccf30b&pf_rd_r=WBJ9K70XM314Z4X7RQHV&pd_rd_wg=AZs8Q&pd_rd_r=ec1ae3e6-0034-4e29-9a78-678983bcd9f3&ref_=pd_gw_ci_mcx_mr_hp_d', 'https://m.media-amazon.com/images/I/51CITkXajBL._AC_SL1000_.jpg', 'teste');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
