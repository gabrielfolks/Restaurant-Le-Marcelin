-- Produtos 

CREATE VIEW V_PRODUTO AS 
SELECT
    A.idMercadoria, A.codigo, A.nome, A.valor,
    A.IdFornecedor, B.tempoPreparo, B.quantMedida,
    B.medidaComercial, B.taxaDesconto, B.fabricacaoPropria
From Mercadoria A INNER JOIN Produto B
ON A.idMercadoria = B.idMercadoria;

-- Insumos

CREATE VIEW V_INSUMO AS 
SELECT
    A.idMercadoria, A.codigo, A.nome, A.valor,
    A.IdFornecedor, B.unidadeMedida 
From Mercadoria A 
INNER JOIN Insumo B ON A.idMercadoria = B.idMercadoria;

-- Pedido Entrega

CREATE VIEW V_PEDIDOENTREGA AS
SELECT
     A.idPedido , A.numero , A.previsao ,
     A.idComanda , B.previsaoEntrega, B.taxaEntrega,
     B.idCliente
FROM pedido A 
INNER JOIN PedidoEntrega B
ON A.idPedido = B.idPedido;

-- Pedido Mesa
CREATE VIEW V_PEDIDOMESA AS
SELECT
     A.idPedido , A.numero , A.previsao ,
     A.idComanda , B.idMesa
FROM pedido A 
INNER JOIN PedidoMesa B
ON A.idPedido = B.idPedido;




