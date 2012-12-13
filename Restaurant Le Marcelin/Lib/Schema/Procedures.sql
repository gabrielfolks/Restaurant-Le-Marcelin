-- STORED PROCEDURES
-- Caixa
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Caixa //
CREATE PROCEDURE Insere_Caixa (in p_codigo int, in p_dia DATETIME, in p_valor float,
in p_valorInicial float, in p_status BOOLEAN)
BEGIN
    INSERT INTO caixa (`codigo`,`dia`,`valor`,`valorInicial`, `status`)
    VALUES(P_codigo, p_dia, p_valor, p_valorInicial, p_status);
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Caixa //
CREATE PROCEDURE `Altera_Caixa`(in p_codigo int, in p_dia DATETIME, in p_valor float,
in p_valorInicial float, in p_status BOOLEAN)
BEGIN
    UPDATE `restaurantlemarcelin`.`caixa`
    SET dia = p_dia,
    valor = p_valor, valorInicial = p_valorInicial, status = p_status
    WHERE codigo = p_codigo;
END //

-- Cardapio
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Cardapio //
CREATE PROCEDURE Insere_Cardapio (in p_dia char(3))
BEGIN
    INSERT INTO cardapio (dia) 
    VALUES (p_dia);
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Cardapio //
CREATE PROCEDURE Altera_Cardapio (in p_id int, in p_dia char(3))
BEGIN
    UPDATE cardapio SET dia = p_dia 
    WHERE idCardapio = p_id;
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Insere_CardapioProduto //
CREATE PROCEDURE Insere_CardapioProduto (in p_cardapio int, in p_produto int)
BEGIN
    INSERT INTO cardapioProduto (idCardapio, idProduto) 
    VALUES (p_cardapio, p_produto);
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Deleta_CardapioProduto //
CREATE PROCEDURE Deleta_CardapioProduto (in p_cardapio int, in p_produto int)
BEGIN
    delete from cardapioProduto 
where idCardapio = p_cardapio AND idProduto = p_produto;
END //

-- Cliente
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Cliente //
CREATE PROCEDURE Insere_Cliente (in p_nome varchar(50), in p_telefone char(11), in p_endereco varchar(100),
in p_cpf char(11))
BEGIN
    
    INSERT INTO Cliente (nome, telefone, endereço, cpf)
    VALUES (p_nome, p_telefone, p_endereco, p_cpf); 
 
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Cliente //
CREATE PROCEDURE Altera_Cliente (in p_id int, in p_nome varchar(50), in p_telefone char(11), in p_endereco varchar(100),
in p_cpf char(11))
BEGIN
    
    UPDATE Cliente SET nome = p_nome, telefone = p_telefone, endereço = p_endereco, 
    cpf = p_cpf where idCliente = p_id;
 
END //

-- Comanda
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Comanda //
CREATE PROCEDURE Insere_Comanda (in p_codigo int, in p_valor float, in p_data DATETIME)
BEGIN

    INSERT INTO COMANDA (codigo, valor, data) 
    VALUES (p_codigo, p_valor, p_data);    
 
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Comanda //
CREATE PROCEDURE Altera_Comanda (in id_comanda int, in p_codigo int, in p_valor float, in p_data DATETIME)
BEGIN

    UPDATE COMANDA SET valor = p_valor, data = p_data 
    WHERE codigo = p_codigo AND idComanda = id_comanda;    
 
END //

-- Estoque
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Estoque //
CREATE PROCEDURE Insere_Estoque (in p_id int, in p_qmax int, in p_qmin int, in p_qitens int)
BEGIN

    INSERT INTO ESTOQUE (idMercadoria, qtdMax, qtdMin, qtdItens) 
    VALUES (p_id, p_qmax, p_qmin, p_qitens);
 
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Estoque //
CREATE PROCEDURE Altera_Estoque (in p_id int, in p_qmax int, in p_qmin int, in p_qitens int)
BEGIN

    UPDATE ESTOQUE SET 
    qtdMax = p_qmax, 
    qtdMin = p_qmin,
    qtdItens = p_qitens 
    WHERE idMercadoria = p_id;
 
END //

-- Fornecedor

DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Fornecedor //
CREATE PROCEDURE Insere_Fornecedor (in p_nome varchar(50), in p_cnpj char(14), in p_telefone char(11), in p_endereco varchar(100), in p_cep char(8), in p_razaoSocial varchar(50))
BEGIN

   INSERT INTO fornecedor(nome, cnpj, telefone, endereco, cep, razaoSocial)
   VALUES (p_nome, p_cnpj,p_telefone,p_endereco,p_cep, p_razaoSocial);
 
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Fornecedor //
CREATE PROCEDURE Altera_Fornecedor (in p_id int, in p_nome varchar(50), in p_cnpj char(14), in p_telefone char(11), in p_endereco varchar(100), in p_cep char(8), in razaoSocial varchar(50))
BEGIN

   UPDATE fornecedor SET 
   nome = p_nome, cnpj = p_cnpj, telefone = p_telefone, endereco = p_endereco, cep = p_cep,            razaoSocial = p_razaoSocial
   WHERE idFornecedor = p_id;
 
END //

-- Franquia
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Franquia //
CREATE PROCEDURE Insere_Franquia (in p_razao varchar(50), in p_fantasia varchar(50), 
in p_cnpj char(14), in p_endereco varchar(100), in p_cep char(8), in p_cidade varchar(50), in p_estado char(2))
BEGIN

   INSERT INTO fornecedor(nome, cnpj, telefone, endereco, cep, razaoSocial)
   VALUES (p_nome, p_cnpj,p_telefone,p_endereco,p_cep, p_razaoSocial);
 
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Franquia //
CREATE PROCEDURE Altera_Franquia (in p_id int, in p_razao varchar(50), in p_fantasia varchar(50), 
in p_cnpj char(14), in p_endereco varchar(100), in p_cep char(8), in p_cidade varchar(50), in p_estado char(2))
BEGIN

   UPDATE FRANQUIA SET 
   razao = p_razao, fantasia = p_fantasia, cnpj = p_cnpj, endereco = p_endereco, cep = p_cep, 
   cidade = p_cidade, estado = p_estado
   WHERE idFranquia = p_id;
 
END //

-- Funcionario 
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Funcionario //
CREATE PROCEDURE Insere_Funcionario (in p_franquia int, in p_ctps varchar(10), 
in p_nome varchar(50), in p_endereco varchar(100), in p_cpf char(11),
in p_nascimento DATETIME, in p_salario float, in p_comissao float, in p_cargo varchar(10), in p_login int)
BEGIN

    INSERT INTO funcionario(idFranquia, ctps, nome, endereco,
    cpf, nascimento, salario, comissao, cargo, idLogin)
    VALUES(p_franquia,p_ctps,p_nome,p_endereco,p_cpf,
    p_nascimento,p_salario,p_comissao,p_cargo,p_login);
 
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Funcionario //
CREATE PROCEDURE Altera_Funcionario (in p_id int,in p_franquia int, in p_ctps varchar(10), 
in p_nome varchar(50), in p_endereco varchar(100), in p_cpf char(11),
in p_nascimento DATETIME, in p_salario float, in p_comissao float, in p_cargo varchar(10), in p_login int)
BEGIN


   UPDATE Funcionario SET 
   idFranquia = p_franquia, ctps = p_ctps, nome = p_nome, endereco = p_endereco, cpf = p_cpf, 
   nascimento = p_nascimento, salario = p_salario, comissao = p_comissao, cargo = p_cargo,
   idLogin = p_login
   WHERE idFuncionario = p_id;
 
END //
-- Ingrediente
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Ingrediente //
CREATE PROCEDURE Insere_Ingrediente (in p_produto int, p_insumo int, p_quantidade int, p_medida varchar(2))
BEGIN
    INSERT INTO INGREDIENTE (idProduto, idInsumo, quantidade, medida)
    VALUES (p_produto, p_insumo, p_quantidade, p_medida);
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Deleta_Ingrediente //
CREATE PROCEDURE Deleta_Ingrediente (in p_id int)
BEGIN
    DELETE FROM INGREDIENTE WHERE idIngrediente = p_id;
END //

-- Insumo / -- Produto
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Mercadoria //
CREATE PROCEDURE Insere_Mercadoria (in p_codigo int, in p_nome varchar(50), in p_valor float, in p_fornecedor int)
BEGIN
    INSERT INTO MERCADORIA (codigo, nome, valor, idFornecedor) 
    VALUES (p_codigo, p_nome, p_Valor, p_fornecedor);
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Mercadoria //
CREATE PROCEDURE Altera_Mercadoria (in p_id int , in p_codigo int, in p_nome varchar(50), in p_valor float, in p_fornecedor int)
BEGIN
    UPDATE MERCADORIA SET
    codigo = p_codigo,  nome = p_nome, valor = p_Valor, idFornecedor = p_fornecedor 
    WHERE idMercadoria = p_id;
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Produto //
CREATE PROCEDURE Insere_Produto(in p_codigo int, in p_nome varchar(50), in p_valor float, in p_fornecedor int,
in p_tempo DATETIME, in p_quantidadeMedida int, in p_medidaComercial varchar(10), in p_taxa float, in p_fb boolean  )
BEGIN
    DECLARE id int default 0;
    CALL Insere_Mercadoria (p_codigo, p_nome , p_valor , p_fornecedor);
    Select last_insert_id() into id;
    INSERT INTO Produto (idMercadoria, tempoPreparo, quantMedida, medidaComercial, taxaDesconto, fabricacaoPropria)
    values (id, p_tempo, p_quantidadeMedida, p_medidaComercial, p_taxa, p_fb);       
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Produto //
CREATE PROCEDURE Altera_Produto(in p_id int, in p_codigo int, in p_nome varchar(50), in p_valor float, in p_fornecedor int,
in p_tempo DATETIME, in p_medida int, in p_mc varchar(10), in p_taxa float, in p_fb boolean  )
BEGIN
    CALL Altera_Mercadoria(p_id, p_codigo, p_nome, p_valor, p_fornecedor);
    UPDATE produto SET
    tempoPreparo = p_tempo,
    quantMedida = p_medida,
    medidaComercial = p_mc,
    taxaDesconto = p_taxa,
    fabricacaoPropria = p_fb
    WHERE idMercadoria = p_id;
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Insumo //
CREATE PROCEDURE Insere_Insumo(in p_codigo int, in p_nome varchar(50), in p_valor float, in p_fornecedor int,
in p_unidade varchar(2))
BEGIN
    DECLARE id int default 0;
    CALL Insere_Mercadoria (p_codigo, p_nome , p_valor , p_fornecedor);
    Select last_insert_id() into id;
    INSERT INTO Insumo (idMercadoria, unidadeMedida) values (id, p_unidade);       
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Insumo //
CREATE PROCEDURE Altera_Insumo(in p_id int, in p_codigo int, in p_nome varchar(50), in p_valor float, in p_fornecedor int,
in p_unidade varchar(2))
BEGIN
    CALL Altera_Mercadoria(p_id, p_codigo, p_nome, p_valor, p_fornecedor);
    UPDATE Insumo SET
    unidadeMedida = p_unidade
    WHERE idMercadoria = p_id;
END //

-- ItemPedido
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Item //
CREATE PROCEDURE Insere_Item (in p_idPedido int, in p_idProduto int, in p_qtd int)
BEGIN
    INSERT INTO ItemPedido (idPedido, idProduto, quantidade)
    VALUES (p_idPedido, p_idProduto, p_qtd);
END //

-- Login
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Login //
CREATE PROCEDURE Insere_Login(in p_usuario varchar(30), p_senha varchar(20))
BEGIN
    INSERT INTO LOGIN (usuario, senha) VALUES (p_usuario, p_senha);
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Login //
CREATE PROCEDURE Altera_Login(in p_usuario varchar(30), p_senha varchar(20))
BEGIN
    UPDATE LOGIN SET senha = p_senha WHERE usuario = p_usuario;
END //

-- Mesa
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Mesa //
CREATE PROCEDURE Insere_Mesa(in p_numero int, in p_zona int, in p_f BOOLEAN, in p_lug int)
BEGIN
    INSERT INTO MESA (numero, zona, fumante, lugares) VALUES ( p_numero, p_zona, p_f, p_lug);
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Mesa //
CREATE PROCEDURE Altera_Mesa(in p_numero int, in p_zona int, in p_f BOOLEAN, in p_lug int)
BEGIN
    UPDATE MESA SET 
    zona = p_zona, fumante = p_f, lugares = p_lug
    WHERE numero = p_numero;
END //
-- Pagamento

DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Pagamento //
CREATE PROCEDURE Insere_Pagamento (p_forma varchar(8), p_qp int, p_idComanda int, p_caixa int)
BEGIN
    INSERT INTO PAGAMENTO (formaPagamento, quantidadeParcelas, idComanda, idCaixa)
    VALUES ( p_forma, p_qp, p_idComanda, p_caixa );
END //


-- PedidoEntrega 
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_PedidoEntrega //
CREATE PROCEDURE Insere_PedidoEntrega (in p_numero int, in p_previsao DATETIME, in p_idComanda int,
in p_prEntrega DATETIME, in p_taxa float, in p_idCliente int)
BEGIN

    DECLARE id INT DEFAULT 0;    
    
    INSERT INTO Pedido (numero, previsao, idComanda)
    VALUES (p_numero, p_previsao, p_idComanda); 
    
    Select last_insert_id() into id;
    
    INSERT INTO PedidoEntrega (idPedido, previsaoEntrega, taxaEntrega, idCliente) 
    VALUES (id, p_prEntrega, p_taxa, p_idCliente);
 
END //

-- PedidoMesa

DELIMITER //
DROP PROCEDURE IF EXISTS Insere_PedidoMesa //
CREATE PROCEDURE Insere_PedidoMesa (in p_numero int, in p_previsao DATETIME, in p_idComanda int,
in p_mesa int)
BEGIN
    DECLARE id INT DEFAULT 0;    
    
    INSERT INTO Pedido (numero, previsao, idComanda)
    VALUES (p_numero, p_previsao, p_idComanda); 
    
    Select last_insert_id() into id;
    
    INSERT INTO PedidoMesa(idPedido, idMesa) VALUES (id , p_mesa);
END //

-- Reserva
DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Reserva //
CREATE PROCEDURE Insere_Reserva( p_data DATETIME, p_cliente int, p_mesa int)
BEGIN
    INSERT INTO RESERVA (data, idCliente, idMesa) VALUES (p_data, p_cliente, p_mesa);
END //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Reserva //
CREATE PROCEDURE Altera_Reserva (p_id int, p_data DATETIME, p_cliente int, p_mesa int)
BEGIN
	UPDATE Reserva 
	SET data = p_data, idCliente = p_cliente, mesa = p_mesa 
	WHERE idReserva = p_id;
END //

-- Franquia

DELIMITER //
DROP PROCEDURE IF EXISTS Insere_Franquia //
CREATE PROCEDURE Insere_Franquia(p_razao VARCHAR(50), p_fantasia VARCHAR(50), p_cnpj CHAR(14),
p_endereco VARCHAR(100), p_cep CHAR(8), p_cidade VARCHAR(50), p_estado CHAR(2)) 
BEGIN
	INSERT INTO Franquia (razao, fantasia, cnpj, endereco, cep, cidade, estado) 
	VALUES (p_razao, p_fantasia, p_cnpj, p_endereco, p_cep, p_cidade, p_estado);
END  //

DELIMITER //
DROP PROCEDURE IF EXISTS Altera_Franquia //
CREATE PROCEDURE Altera_Franquia (p_id INT, p_razao VARCHAR(50), p_fantasia VARCHAR(50), p_cnpj CHAR(14),
p_endereco VARCHAR(100), p_cep CHAR(8), p_cidade VARCHAR(50), p_estado CHAR(2))
BEGIN
	UPDATE Franquia
	SET razao = p_razao, fantasia = p_fantasia, cnpj = p_cnpj, endereco = p_endereco, 
	cep = p_cep, cidade = p_cidade, estado = p_estado WHERE id = p_id;
END //