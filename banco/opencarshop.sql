-- MySQL dump 10.16  Distrib 10.1.20-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version	10.1.20-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `cpf` varchar(15) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone1` varchar(45) DEFAULT NULL,
  `telefone2` varchar(45) DEFAULT NULL,
  `endereco` int(11) NOT NULL,
  `ativo` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  KEY `fk_Cliente_Endereco1_idx` (`endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES ('028','Rogerio','2012-01-01','rogerio@email.com','43563464','23423423423',1,0),('12345678','Bolsonaro','2016-02-09','bolsomito@gmail.com','3221-2121','123',34,1),('2332','Tharlles','2016-10-12','fds','sdf','sdf',10,1),('51123254','Malakoi do Ebraico','2016-10-10','malacoi@devaso.com.br','123','1212',21,1),('8484948','lol','2016-10-03','455456','4546456','456456',29,0);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contrato`
--

DROP TABLE IF EXISTS `Contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contrato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` char(1) DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  `dataInicio` date DEFAULT NULL,
  `dataTermino` date DEFAULT NULL,
  `funcionario` varchar(15) NOT NULL,
  PRIMARY KEY (`id`,`funcionario`),
  KEY `fk_Contrato_Funcionario1_idx` (`funcionario`),
  CONSTRAINT `fk_Contrato_Funcionario1` FOREIGN KEY (`funcionario`) REFERENCES `Funcionario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contrato`
--

LOCK TABLES `Contrato` WRITE;
/*!40000 ALTER TABLE `Contrato` DISABLE KEYS */;
INSERT INTO `Contrato` VALUES (1,'G',2.00,'2000-01-01','2000-02-02','123'),(3,'F',23.00,'2016-10-15','2016-10-15','00000000000'),(4,'F',32.00,'2016-10-06','2016-10-06','1'),(5,'M',1000.00,'2016-10-02','2016-10-02','12465'),(6,'G',32.00,'2016-10-07','2016-10-07','3232'),(7,'G',22.00,'2016-10-07','2016-10-07','we23');
/*!40000 ALTER TABLE `Contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Endereco`
--

DROP TABLE IF EXISTS `Endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cep` varchar(9) DEFAULT '_____-___',
  `estado` char(2) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `tipo` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Endereco`
--

LOCK TABLES `Endereco` WRITE;
/*!40000 ALTER TABLE `Endereco` DISABLE KEYS */;
INSERT INTO `Endereco` VALUES (1,'49010020','a','a','a','a',1,'aa','r'),(2,'49010020','a','a','a','a',1,'aa','r'),(4,'49010020','ds','sdsd','sdds','sdds',2,'sdds','R'),(5,'2323','ee','w','ewe','w',2,'we','C'),(6,'1212','SE','Aracaju','Atalaia','Rua',10,'','R'),(7,'sds','sd','23','32','23',3,'23','C'),(8,'2131','sd','asd','asdad','asda',2,'asd','R'),(10,'2','sd','asd','asda','3sdas',32,'asd','C'),(18,'123456442','SE','A','A','A',22,'A','C'),(19,'1237261','Se','Aracaju','São José','Rua B',66,'Ao lado','C'),(20,'234123','SE','Nao sei','Vila da folha','Logo ali',13,'numero zero','C'),(21,'123412','SE','Rio','Ok','Ebraico',69,'garoto ixpertinho','R'),(22,'12345','Se','Outra','São João','Rua X',22,'Ao lado','C'),(29,'456456','SE','456','456456','456',456,'456','R'),(34,'231223','SE','Aracaju','qrrr','Brasil',12,'qqr coisa','R'),(35,'1233','Se','Aracaju','xd','rua boa',12,'conjunto','C');
/*!40000 ALTER TABLE `Endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fornecedor`
--

DROP TABLE IF EXISTS `Fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Fornecedor` (
  `cnpj` varchar(15) NOT NULL,
  `razaoSocial` varchar(50) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone1` varchar(45) DEFAULT NULL,
  `telefone2` varchar(45) DEFAULT NULL,
  `endereco` int(11) NOT NULL,
  `ativo` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`cnpj`),
  KEY `fk_Fornecedor_Endereco_idx` (`endereco`),
  CONSTRAINT `fk_Fornecedor_Endereco` FOREIGN KEY (`endereco`) REFERENCES `Endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fornecedor`
--

LOCK TABLES `Fornecedor` WRITE;
/*!40000 ALTER TABLE `Fornecedor` DISABLE KEYS */;
INSERT INTO `Fornecedor` VALUES ('123','UFS','Universidade','ufs.br','123','12345',35,1),('12312','xD','Alguma descrição','ola@hotmail.com','1','2',22,NULL),('12344321','Xablau Carai','Aqui nois controi fibra','xablau@carai.com','12313213','123123123',20,NULL),('A','A','A','dshau@hotmail.com','123','321',18,NULL),('CNpJ','Teste','BLABLABLAoioi','test@test.com','123','1243511',19,0);
/*!40000 ALTER TABLE `Fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Funcionario`
--

DROP TABLE IF EXISTS `Funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Funcionario` (
  `cpf` varchar(15) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone1` varchar(45) DEFAULT NULL,
  `telefone2` varchar(45) DEFAULT NULL,
  `endereco` int(11) NOT NULL,
  `ativo` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  KEY `fk_Funcionario_Endereco1_idx` (`endereco`),
  CONSTRAINT `fk_Funcionario_Endereco1` FOREIGN KEY (`endereco`) REFERENCES `Endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Funcionario`
--

LOCK TABLES `Funcionario` WRITE;
/*!40000 ALTER TABLE `Funcionario` DISABLE KEYS */;
INSERT INTO `Funcionario` VALUES ('00000000000','Teste','123','2016-10-11','teste@gmail.com','4584','515',4,0),('1','helma','123','2016-10-13','sd','we','ew',5,1),('123','Teste2','123','2000-01-01','teste@gmail.com','123','321',2,1),('12465','PEDRO HENRIQUE 2','456','2016-10-11','pedro_henrique@hotmail.com','1321654','213216',6,1),('3232','testeeee','323','2016-09-29','3','3','3',7,1),('we23','teteasdsadas','asda','2016-10-07','asdada','asd','asd',8,1);
/*!40000 ALTER TABLE `Funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ItemPeca`
--

DROP TABLE IF EXISTS `ItemPeca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ItemPeca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `quantidadeVendida` int(11) NOT NULL,
  `idPeca` int(11) NOT NULL,
  `idVenda` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idPeca_idx` (`idPeca`),
  KEY `idVenda_idx` (`idVenda`),
  CONSTRAINT `idPeca` FOREIGN KEY (`idPeca`) REFERENCES `Peca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ItemPeca`
--

LOCK TABLES `ItemPeca` WRITE;
/*!40000 ALTER TABLE `ItemPeca` DISABLE KEYS */;
INSERT INTO `ItemPeca` VALUES (1,180,1,6,1),(2,268.99,1,3,7),(3,268.99,1,3,8),(4,4800,1,4,8),(5,320.99,1,5,8),(6,268.99,1,3,9),(7,180,1,6,9),(8,3000,1,9,9),(9,1344.95,5,3,10),(10,200,1,11,11),(11,4800,1,4,12),(12,320.99,1,5,12),(13,268.99,1,3,13),(14,4800,1,4,14),(15,268.99,1,3,15),(16,537.98,2,3,16);
/*!40000 ALTER TABLE `ItemPeca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ItemPecaServico`
--

DROP TABLE IF EXISTS `ItemPecaServico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ItemPecaServico` (
  `peca` int(11) NOT NULL,
  `ordemServico` int(11) NOT NULL,
  `orcamento` int(11) NOT NULL,
  `cliente` varchar(15) NOT NULL,
  `funcionario` varchar(15) NOT NULL,
  `tipoPagamento` char(1) DEFAULT NULL,
  `codigoPagamento` varchar(45) DEFAULT NULL,
  `valorFinal` decimal(10,2) DEFAULT NULL,
  `desconto` decimal(6,2) DEFAULT NULL,
  `ItemPecacol` varchar(45) DEFAULT NULL,
  `Funcionario_cpf` varchar(15) NOT NULL,
  `Cliente_cpf` varchar(15) NOT NULL,
  PRIMARY KEY (`peca`,`ordemServico`,`orcamento`,`cliente`,`funcionario`,`Funcionario_cpf`,`Cliente_cpf`),
  KEY `fk_Peca_has_OrdemServico_OrdemServico1_idx` (`ordemServico`,`orcamento`,`cliente`,`funcionario`),
  KEY `fk_Peca_has_OrdemServico_Peca1_idx` (`peca`),
  KEY `fk_ItemPecaServico_Funcionario1_idx` (`Funcionario_cpf`),
  KEY `fk_ItemPecaServico_Cliente1_idx` (`Cliente_cpf`),
  CONSTRAINT `fk_ItemPecaServico_Cliente1` FOREIGN KEY (`Cliente_cpf`) REFERENCES `Cliente` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemPecaServico_Funcionario1` FOREIGN KEY (`Funcionario_cpf`) REFERENCES `Funcionario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peca_has_OrdemServico_OrdemServico1` FOREIGN KEY (`ordemServico`, `orcamento`, `cliente`, `funcionario`) REFERENCES `OrdemServico` (`id`, `orcamento`, `cliente`, `funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peca_has_OrdemServico_Peca1` FOREIGN KEY (`peca`) REFERENCES `Peca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ItemPecaServico`
--

LOCK TABLES `ItemPecaServico` WRITE;
/*!40000 ALTER TABLE `ItemPecaServico` DISABLE KEYS */;
/*!40000 ALTER TABLE `ItemPecaServico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ItemVeiculo`
--

DROP TABLE IF EXISTS `ItemVeiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ItemVeiculo` (
  `veiculo` int(11) NOT NULL,
  `funcionario` varchar(15) NOT NULL,
  `cliente` varchar(15) NOT NULL,
  `tipoPagamento` varchar(45) DEFAULT NULL,
  `codigoPagemento` varchar(45) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `codigoPagamento` varchar(45) DEFAULT NULL,
  `chasi` varchar(45) DEFAULT NULL,
  `desconto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`veiculo`,`funcionario`,`cliente`),
  KEY `fk_Veiculo_has_Funcionario_Funcionario1_idx` (`funcionario`),
  KEY `fk_Veiculo_has_Funcionario_Veiculo1_idx` (`veiculo`),
  KEY `fk_ItemVeiculo_Cliente1_idx` (`cliente`),
  CONSTRAINT `fk_ItemVeiculo_Cliente1` FOREIGN KEY (`cliente`) REFERENCES `Cliente` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Veiculo_has_Funcionario_Funcionario1` FOREIGN KEY (`funcionario`) REFERENCES `Funcionario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Veiculo_has_Funcionario_Veiculo1` FOREIGN KEY (`veiculo`) REFERENCES `Veiculo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ItemVeiculo`
--

LOCK TABLES `ItemVeiculo` WRITE;
/*!40000 ALTER TABLE `ItemVeiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ItemVeiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrcamentoServico`
--

DROP TABLE IF EXISTS `OrcamentoServico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OrcamentoServico` (
  `id` int(11) NOT NULL,
  `placa` varchar(45) NOT NULL,
  `data` date DEFAULT NULL,
  `Funcionario_cpf` varchar(15) NOT NULL,
  PRIMARY KEY (`id`,`Funcionario_cpf`),
  KEY `fk_OrcamentoServico_Funcionario1_idx` (`Funcionario_cpf`),
  CONSTRAINT `fk_OrcamentoServico_Funcionario1` FOREIGN KEY (`Funcionario_cpf`) REFERENCES `Funcionario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrcamentoServico`
--

LOCK TABLES `OrcamentoServico` WRITE;
/*!40000 ALTER TABLE `OrcamentoServico` DISABLE KEYS */;
/*!40000 ALTER TABLE `OrcamentoServico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrdemServico`
--

DROP TABLE IF EXISTS `OrdemServico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OrdemServico` (
  `id` int(11) NOT NULL,
  `tipoPagamento` char(1) DEFAULT NULL,
  `codigoPagemento` varchar(45) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `valorFinal` decimal(10,2) DEFAULT NULL,
  `desconto` decimal(6,2) DEFAULT NULL,
  `orcamento` int(11) NOT NULL,
  `cliente` varchar(15) NOT NULL,
  `funcionario` varchar(15) NOT NULL,
  PRIMARY KEY (`id`,`orcamento`,`cliente`,`funcionario`),
  KEY `fk_OrdemServico_OrcamentoServico1_idx` (`orcamento`),
  KEY `fk_OrdemServico_Cliente1_idx` (`cliente`),
  KEY `fk_OrdemServico_Funcionario1_idx` (`funcionario`),
  CONSTRAINT `fk_OrdemServico_Cliente1` FOREIGN KEY (`cliente`) REFERENCES `Cliente` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdemServico_Funcionario1` FOREIGN KEY (`funcionario`) REFERENCES `Funcionario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdemServico_OrcamentoServico1` FOREIGN KEY (`orcamento`) REFERENCES `OrcamentoServico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrdemServico`
--

LOCK TABLES `OrdemServico` WRITE;
/*!40000 ALTER TABLE `OrdemServico` DISABLE KEYS */;
/*!40000 ALTER TABLE `OrdemServico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Peca`
--

DROP TABLE IF EXISTS `Peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Peca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `nome` varchar(45) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `ativa` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Peca`
--

LOCK TABLES `Peca` WRITE;
/*!40000 ALTER TABLE `Peca` DISABLE KEYS */;
INSERT INTO `Peca` VALUES (2,189.99,'Pneu GoodYear',16,0),(3,268.99,'Bateria moura',30,1),(4,4800,'Motor 1.6',3,1),(5,320.99,'Som USB',20,1),(6,180,'Pneu',11,1),(7,850,'Vidro Frontal',10,0),(8,1300,'Farol Neblina',5,1),(9,3000,'Painel',12,1),(10,5000,'Painel Gol',15,0),(11,200,'Som',4,1),(12,800,'Parachoque',80,0);
/*!40000 ALTER TABLE `Peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PecaForncida`
--

DROP TABLE IF EXISTS `PecaForncida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PecaForncida` (
  `fornecedor` varchar(15) NOT NULL,
  `peca` int(11) NOT NULL,
  PRIMARY KEY (`fornecedor`,`peca`),
  KEY `fk_Fornecedor_has_Peca_Peca1_idx` (`peca`),
  KEY `fk_Fornecedor_has_Peca_Fornecedor1_idx` (`fornecedor`),
  CONSTRAINT `fk_Fornecedor_has_Peca_Fornecedor1` FOREIGN KEY (`fornecedor`) REFERENCES `Fornecedor` (`cnpj`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fornecedor_has_Peca_Peca1` FOREIGN KEY (`peca`) REFERENCES `Peca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PecaForncida`
--

LOCK TABLES `PecaForncida` WRITE;
/*!40000 ALTER TABLE `PecaForncida` DISABLE KEYS */;
/*!40000 ALTER TABLE `PecaForncida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PecaNecessarias`
--

DROP TABLE IF EXISTS `PecaNecessarias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PecaNecessarias` (
  `peca` int(11) NOT NULL,
  `orcamentoServico` int(11) NOT NULL,
  PRIMARY KEY (`peca`,`orcamentoServico`),
  KEY `fk_Peca_has_OrcamentoServico_OrcamentoServico1_idx` (`orcamentoServico`),
  KEY `fk_Peca_has_OrcamentoServico_Peca1_idx` (`peca`),
  CONSTRAINT `fk_Peca_has_OrcamentoServico_OrcamentoServico1` FOREIGN KEY (`orcamentoServico`) REFERENCES `OrcamentoServico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peca_has_OrcamentoServico_Peca1` FOREIGN KEY (`peca`) REFERENCES `Peca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PecaNecessarias`
--

LOCK TABLES `PecaNecessarias` WRITE;
/*!40000 ALTER TABLE `PecaNecessarias` DISABLE KEYS */;
/*!40000 ALTER TABLE `PecaNecessarias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Servico`
--

DROP TABLE IF EXISTS `Servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Servico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descrição` varchar(45) NOT NULL,
  `valorPadrão` decimal(10,2) NOT NULL,
  `valorFixo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Servico`
--

LOCK TABLES `Servico` WRITE;
/*!40000 ALTER TABLE `Servico` DISABLE KEYS */;
INSERT INTO `Servico` VALUES (1,'teste',30.00,1),(2,'trocar catalisador',120.00,0),(3,'serviço teste',5.00,1),(4,'serviço teste',99.00,0),(5,'serviço ',1.00,1),(6,'SERVICINHO',1.00,0),(7,'Trocar Oleo',40.00,1),(8,'Destruir Carro',50.00,1),(9,'TESTE2',50.00,1),(10,'TESTE',50.00,1),(11,'TESTE',50.00,1),(12,'TESTE',50.00,0),(13,'TESTE',50.00,1),(14,'TES',50.00,0),(15,'Trocar Freio',15.00,1);
/*!40000 ALTER TABLE `Servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ServicoSelecionado`
--

DROP TABLE IF EXISTS `ServicoSelecionado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ServicoSelecionado` (
  `orcamento` int(11) NOT NULL,
  `servico` int(11) NOT NULL,
  PRIMARY KEY (`orcamento`,`servico`),
  KEY `fk_OrcamentoServico_has_Servico_Servico1_idx` (`servico`),
  KEY `fk_OrcamentoServico_has_Servico_OrcamentoServico1_idx` (`orcamento`),
  CONSTRAINT `fk_OrcamentoServico_has_Servico_OrcamentoServico1` FOREIGN KEY (`orcamento`) REFERENCES `OrcamentoServico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrcamentoServico_has_Servico_Servico1` FOREIGN KEY (`servico`) REFERENCES `Servico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ServicoSelecionado`
--

LOCK TABLES `ServicoSelecionado` WRITE;
/*!40000 ALTER TABLE `ServicoSelecionado` DISABLE KEYS */;
/*!40000 ALTER TABLE `ServicoSelecionado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Veiculo`
--

DROP TABLE IF EXISTS `Veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Veiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(45) NOT NULL,
  `ano` year(4) NOT NULL,
  `versao` varchar(45) NOT NULL,
  `opcionalVidrosEletricos` tinyint(1) DEFAULT '0',
  `opcionalTravasEletricas` tinyint(1) DEFAULT '0',
  `opcionalAr` tinyint(1) DEFAULT '0',
  `opcionalFarolNeblina` tinyint(1) DEFAULT '0',
  `opcionalAltoFalantes` tinyint(1) DEFAULT '0',
  `quantidade` int(11) DEFAULT NULL,
  `valor` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Veiculo`
--

LOCK TABLES `Veiculo` WRITE;
/*!40000 ALTER TABLE `Veiculo` DISABLE KEYS */;
INSERT INTO `Veiculo` VALUES (1,'ModeloTeste',2016,'v1',1,1,0,0,0,1,1),(2,'Modelito',2016,'v1',0,0,0,0,0,1,1),(3,'Honda',2000,'v2',0,0,0,0,0,1,56000),(4,'Toyota',2008,'v4',0,0,0,0,0,1,65440),(5,'Toyota',2008,'v4',0,0,0,0,0,1,65440),(6,'GOL',2016,'v3',0,0,0,0,0,45,36000),(7,'GOL',2012,'g7',0,0,0,0,0,2,40),(8,'Gol',2012,'lt',0,0,0,0,0,2,20),(9,'Gol',2012,'lt',0,0,0,0,0,2,23);
/*!40000 ALTER TABLE `Veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VeiculoFornecido`
--

DROP TABLE IF EXISTS `VeiculoFornecido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VeiculoFornecido` (
  `Fornecedor_cnpj` varchar(15) NOT NULL,
  `Veiculo_id` int(11) NOT NULL,
  PRIMARY KEY (`Fornecedor_cnpj`,`Veiculo_id`),
  KEY `fk_Fornecedor_has_Veiculo_Veiculo1_idx` (`Veiculo_id`),
  KEY `fk_Fornecedor_has_Veiculo_Fornecedor1_idx` (`Fornecedor_cnpj`),
  CONSTRAINT `fk_Fornecedor_has_Veiculo_Fornecedor1` FOREIGN KEY (`Fornecedor_cnpj`) REFERENCES `Fornecedor` (`cnpj`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fornecedor_has_Veiculo_Veiculo1` FOREIGN KEY (`Veiculo_id`) REFERENCES `Veiculo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VeiculoFornecido`
--

LOCK TABLES `VeiculoFornecido` WRITE;
/*!40000 ALTER TABLE `VeiculoFornecido` DISABLE KEYS */;
/*!40000 ALTER TABLE `VeiculoFornecido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VendaPeca`
--

DROP TABLE IF EXISTS `VendaPeca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VendaPeca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataVenda` date NOT NULL,
  `valor` double NOT NULL,
  `pago` tinyint(4) NOT NULL,
  `cpfCliente` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cpfCliente_idx` (`cpfCliente`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VendaPeca`
--

LOCK TABLES `VendaPeca` WRITE;
/*!40000 ALTER TABLE `VendaPeca` DISABLE KEYS */;
INSERT INTO `VendaPeca` VALUES (1,'2016-10-12',180,0,'028'),(2,'2016-10-01',589.98,1,'2332'),(3,'2016-06-23',1344.95,0,'028'),(4,'2016-09-28',3641.98,0,'2332'),(5,'2016-12-23',268.99,1,'2332'),(6,'2016-10-01',268.99,0,'028'),(7,'2016-10-12',268.99,0,'2332'),(8,'2016-07-20',5389.98,1,'2332'),(9,'2016-10-19',3448.99,0,'51123254'),(10,'2016-06-15',1344.95,1,'8484948'),(11,'2016-10-31',200,0,'028'),(12,'2016-10-06',5120.99,1,'028'),(13,'2017-03-09',268.99,0,'028'),(14,'2017-03-16',4800,0,'028'),(15,'2017-03-12',268.99,0,'028'),(16,'2017-03-12',537.98,0,'12345678');
/*!40000 ALTER TABLE `VendaPeca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teste`
--

DROP TABLE IF EXISTS `teste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teste` (
  `id` int(11) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teste`
--

LOCK TABLES `teste` WRITE;
/*!40000 ALTER TABLE `teste` DISABLE KEYS */;
INSERT INTO `teste` VALUES (NULL,'ModeloTeste');
/*!40000 ALTER TABLE `teste` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-17  0:19:26
