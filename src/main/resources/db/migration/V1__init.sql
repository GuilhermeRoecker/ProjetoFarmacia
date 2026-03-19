CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    preco_venda NUMERIC(10,2) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE insumo (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    tipo VARCHAR(100),
    fabricante VARCHAR(150),
    fornecedor VARCHAR(150),
    validade DATE,
    valor_unitario NUMERIC(10,2),
    valor_por_grama_ml NUMERIC(10,4)
);

CREATE TABLE estoque (
    id SERIAL PRIMARY KEY,
    produto_id INTEGER,
    insumo_id INTEGER,
    quantidade NUMERIC(10,3) NOT NULL DEFAULT 0,
    estoque_minimo NUMERIC(10,3) NOT NULL DEFAULT 0,

    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produto(id),
    CONSTRAINT fk_insumo FOREIGN KEY (insumo_id) REFERENCES insumo(id)
);