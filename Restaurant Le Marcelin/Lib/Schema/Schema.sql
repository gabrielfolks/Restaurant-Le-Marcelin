DROP DATABASE IF EXISTS RestaurantLeMarcelin;
CREATE DATABASE RestaurantLeMarcelin;
USE RestaurantLeMarcelin; 

-- Fornecedor(idFornecedor , nome, cnpj, telefone, endereço, razaoSocial, cep)
CREATE TABLE Fornecedor(
    idFornecedor smallint NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    cnpj char(14) NOT NULL UNIQUE,
    telefone char(11) NOT NULL,
    endereco VARCHAR(100),
    cep CHAR(8),
    razaoSocial VARCHAR(50),
    Primary Key  (idFornecedor)
);

CREATE TABLE Mercadoria(
    idMercadoria INT NOT NULL AUTO_INCREMENT,
    codigo int NOT NULL UNIQUE,
    nome varchar(50) NOT NULL,
    valor decimal(8, 2) NOT NULL,
    idFornecedor smallint,
    Primary Key (idMercadoria),
    Foreign Key (idFornecedor) References Fornecedor(idFornecedor) ON DELETE SET NULL ON UPDATE CASCADE
);

-- Insumo(idMercadoria, unidadeMedia)
CREATE TABLE Insumo(
    idMercadoria INT NOT NULL UNIQUE,
    unidadeMedida VARCHAR(2) NOT NULL,
    Foreign Key(idMercadoria) References Mercadoria(idMercadoria)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- Produto(idMercadoria, tempoPreparo, quantMedida, medidaComercial, taxaDesconto, fabricacaoPropria)
CREATE TABLE Produto(
    idMercadoria INT NOT NULL UNIQUE,
    tempoPreparo DATETIME,
    quantMedida FLOAT,
    medidaComercial VARCHAR(10),
    taxaDesconto FLOAT,
    fabricacaoPropria boolean,
    Foreign Key(idMercadoria) References Mercadoria(idMercadoria)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- Ingrediente(idIngrediente, idProduto, idInsumo, quantidade, medida)
CREATE TABLE Ingrediente(
    idIngrediente INT NOT NULL AUTO_INCREMENT,
    idProduto INT NOT NULL,
    idInsumo INT NOT NULL,
    quantidade INT NOT NULL,
    medida VARCHAR(2),
    Primary Key (idIngrediente),
    Foreign Key(idProduto) References Produto(idMercadoria)
    ON DELETE CASCADE ON UPDATE CASCADE,
    Foreign Key(idInsumo) References Insumo(idMercadoria)
    ON DELETE CASCADE ON UPDATE CASCADE
); 

-- Estoque( idMercadoria, qtdMax, qtdMin, qtdItens)
CREATE TABLE Estoque(
    idMercadoria INT NOT NULL UNIQUE,
    qtdMax INT NOT NULL,
    qtdMin INT NOT NULL,
    qtdItens INT NOT NULL,
    Foreign Key(idMercadoria) References Mercadoria(idMercadoria)
    ON DELETE CASCADE ON UPDATE CASCADE
); 

-- Cardapio (idCardapio, dia)
CREATE TABLE Cardapio(
    idCardapio INT NOT NULL AUTO_INCREMENT,
    dia CHAR(3) NOT NULL UNIQUE,
    Primary Key (idCardapio)
); 

-- CardapioProduto(idCardapio, idProduto) //Melhorar o nome desse mapeamento
CREATE TABLE CardapioProduto(
    idCardapio INT NOT NULL,
    idProduto INT NOT NULL,
    Foreign Key(idCardapio) References Cardapio(idCardapio)
    ON DELETE CASCADE ON UPDATE CASCADE,
    Foreign Key(idProduto) References Produto(idMercadoria)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- Comanda ( idComanda, código, valor, data) 
CREATE TABLE Comanda(
    idComanda INT NOT NULL AUTO_INCREMENT,
    codigo INT NOT NULL,
    valor DECIMAL(10, 2) ,
    data DATETIME,
    Primary Key (idComanda)
);

-- Pedido (idPedido, numero, valor, previsão, idComanda)
CREATE TABLE Pedido(
    idPedido INT NOT NULL AUTO_INCREMENT,
    numero INT NOT NULL,
    previsao DATETIME,
    idComanda INT NOT NULL,
    Primary Key  (idPedido),
    Foreign Key(idComanda) References Comanda(idcomanda)
    ON UPDATE CASCADE
);

-- Mesa( idMesa, numero, zona, fumante, lugares)
CREATE TABLE Mesa(
    idMesa INT NOT NULL AUTO_INCREMENT,
    numero INT NOT NULL UNIQUE,
    zona VARCHAR(10) NOT NULL,
    fumante BOOLEAN NOT NULL,
    lugares INT NOT NULL,
    Primary Key (idMesa)
);

-- PedidoMesa(idPedido, idMesa)
CREATE TABLE PedidoMesa(
    idPedido INT NOT NULL UNIQUE,
    idMesa INT NOT NULL,
    Foreign Key(idPedido) References Pedido(idPedido)
    ON UPDATE CASCADE ON DELETE CASCADE,
    Foreign Key(idMesa) References Mesa(idMesa)
    ON UPDATE CASCADE
);

-- ItemPedido( idPedido, idProduto, quantidade)
CREATE TABLE ItemPedido(
    idPedido INT NOT NULL,
    idProduto INT NOT NULL,   
    quantidade INT NOT NULL,
    Foreign Key(idPedido) References Pedido(idPedido)
    ON UPDATE CASCADE ON DELETE CASCADE,
    Foreign Key(idProduto) References Produto(idMercadoria)
    ON UPDATE CASCADE
);

-- Cliente ( idCliente, nome, telefone, endereço, cpf) 
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `telefone` char(11) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `cpf` (`cpf`)
); 

-- PedidoEntrega (idPedido, previsaoEntrega, taxaEntrega, idCliente)
CREATE TABLE PedidoEntrega(
    idPedido INT NOT NULL UNIQUE,
    previsaoEntrega DATETIME ,   
    taxaEntrega float NOT NULL,
    idCliente INT NOT NULL,
    Foreign Key(idPedido) references Pedido(idPedido)
    ON DELETE CASCADE ON UPDATE CASCADE,
    Foreign Key(idCliente) references Cliente(idCliente)
    ON UPDATE CASCADE
);

-- Reserva( idReserva, data, idCliente, idMesa)
CREATE TABLE Reserva(
    idReserva INT NOT NULL AUTO_INCREMENT,
    data DATETIME ,      
    idCliente INT NOT NULL,
    idMesa INT NOT NULL,
    Primary Key  (idReserva),
    Foreign Key(idCliente) references Cliente(idCliente)
    ON DELETE CASCADE ON UPDATE CASCADE,
    Foreign Key(idMesa) references Mesa(idMesa)
    ON UPDATE CASCADE
);

-- Caixa( idCaixa, código, dia, valor, valorInicial, status)
CREATE TABLE Caixa(
    idCaixa INT NOT NULL AUTO_INCREMENT,
    codigo INT NOT NULL UNIQUE,
    dia DATETIME ,      
    valor FLOAT,
    valorInicial FLOAT,
    status BOOLEAN,
    CONSTRAINT PKCaixa Primary Key (idCaixa) 
);

-- Pagamento ( idPagamento, formaPagamento, quantidadeParcelas, idComanda, idCaixa)
CREATE TABLE Pagamento(
    idPagamento INT NOT NULL AUTO_INCREMENT,
    formaPagamento VARCHAR(8) NOT NULL,
    quantidadeParcelas INT NOT NULL ,      
    idComanda INT NOT NULL ,      
    idCaixa INT NOT NULL,
    Primary Key (idPagamento),
    Foreign Key(idComanda) references Comanda(idComanda)
    ON UPDATE CASCADE,
    Foreign Key(idCaixa) references Caixa(idCaixa)
    ON UPDATE CASCADE
);

-- Franquia ( idFranquia, razão, fantasia, cnpj, endereco, cep, cidade, estado)
CREATE TABLE Franquia(
    idFranquia INT NOT NULL AUTO_INCREMENT,
    razao VARCHAR(50) NOT NULL,
    fantasia VARCHAR(50) NOT NULL,
    cnpj char(14) NOT NULL UNIQUE,      
    endereco VARCHAR(100) NOT NULL,
    cep CHAR(8) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL,
    Primary Key (idFranquia)
);

-- Login (idLogin, usuário, senha) 
CREATE TABLE Login(
    idLogin INT NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(30) NOT NULL UNIQUE,
    senha VARCHAR(20) NOT NULL,
    Primary Key (idLogin)
);

INSERT INTO LOGIN (usuario, senha) VALUES ('MASTER', '123456'); 

-- Funcionario ( idFuncionario, idFranquia, ctps, nome, endereco, cpf, nascimento, salario, comissão, cargo, idLogin)
CREATE TABLE Funcionario(
    idFuncionario INT NOT NULL AUTO_INCREMENT,
    idFranquia INT NOT NULL,
    ctps CHAR(10) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,      
    nascimento DATETIME,
    salario FLOAT NOT NULL,
    comissao FLOAT,
    cargo VARCHAR(10),
    idLogin INT,
    Primary Key (idFuncionario),
    Foreign Key(idLogin) References Login(idLogin)
    ON UPDATE SET NULL
);


