-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 16-Ago-2022 às 16:53
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
-- Estrutura da tabela `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('adm', 'ROLE_ADM');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(60) NOT NULL,
  `valor` decimal(10,0) DEFAULT NULL,
  `data_entrega` date DEFAULT NULL,
  `url_produto` text NOT NULL,
  `url_imagem` text NOT NULL,
  `descricao` text NOT NULL,
  `status` varchar(60) DEFAULT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `nome_produto`, `valor`, `data_entrega`, `url_produto`, `url_imagem`, `descricao`, `status`, `user_username`) VALUES
(1, 'ACER Notebook Nitro 5 AN515-44-R4KA', '20', '2022-08-17', 'https://www.amazon.com.br/ACER-Notebook-Nitro-AN515-44-R4KA-Windows11/dp/B09ZQ943YL/?_encoding=UTF8&pd_rd_w=orbp5&content-id=amzn1.sym.457c181d-08f4-4901-b7a5-e5a789ccf30b&pf_rd_p=457c181d-08f4-4901-b7a5-e5a789ccf30b&pf_rd_r=WBJ9K70XM314Z4X7RQHV&pd_rd_wg=AZs8Q&pd_rd_r=ec1ae3e6-0034-4e29-9a78-678983bcd9f3&ref_=pd_gw_ci_mcx_mr_hp_d', 'https://m.media-amazon.com/images/I/51CITkXajBL._AC_SL1000_.jpg', 'ACER Notebook Nitro 5 AN515-44-R4KA', 'AGUARDANDO', 'adm'),
(2, 'Hd Ssd Kingston 240gb Sata 3 A400 2,5 Notebook', '0', '2022-08-27', 'https://www.amazon.com.br/Kingston-240gb-Sata-A400-Notebook/dp/B07P97M7HP/?_encoding=UTF8&pd_rd_w=BQ6Pw&content-id=amzn1.sym.cf842a5d-b143-431c-876c-f6263fda7ed7&pf_rd_p=cf842a5d-b143-431c-876c-f6263fda7ed7&pf_rd_r=2VHZQ9DG4WMAH1R6BCMX&pd_rd_wg=8GU70&pd_rd_r=e736845f-c584-418b-b5e0-23f9257bc05b&ref_=pd_gw_unk', 'https://m.media-amazon.com/images/I/714mOgOXzgL._AC_SL1500_.jpg', 'Armazene fotos, videos, musicas e documentos, com muito mais seguranca e sem comprometer a memoria do seu computador com o SSSD Kingston A400 240GB. Principais Caracteristicas: - Rapida inicializacao, carregamento e transferencia de arquivos; ', 'APROVADO', NULL),
(3, 'Echo Dot (4ª geração): Smart Speaker com Relógio e Alexa', NULL, NULL, 'https://www.amazon.com.br/Novo-Echo-Dot-com-rel%C3%B3gio/dp/B084J4WP6J/?_encoding=UTF8&pd_rd_w=paE27&content-id=amzn1.sym.669252bb-68fb-4fa5-ba40-1448d10324f1&pf_rd_p=669252bb-68fb-4fa5-ba40-1448d10324f1&pf_rd_r=THTCGCYH9ABDG09E5JKW&pd_rd_wg=ryWtS&pd_rd_r=e726c52b-bbda-47ed-8a9b-c7319702d36a&ref_=pd_gw_unk', 'https://m.media-amazon.com/images/I/61bEzxKzZIL._AC_SL1000_.jpg', 'Use sua voz para tocar música, artista ou gênero com o Amazon Music, Apple Music, Spotify, Deezer e outros. Você pode tocar música em toda a sua casa com dispositivos Echo compatíveis em diferentes cômodos com a ajuda da música multi-ambiente. *Alguns serviços podem exigir assinaturas ou taxas separadas.', 'ENTREGUE', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('adm', '$2a$10$XWbjjPXlHDzXUdKEqlSHJ.MwKbA5cilhHQN6DXizrx20pAhWqrb4a', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
