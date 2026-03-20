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
    valor_unitario NUMERIC(10,2),
    valor_por_grama_ml NUMERIC(10,4)
);

CREATE TABLE formula (
    id SERIAL PRIMARY KEY,
    produto_id INTEGER NOT NULL,

    CONSTRAINT fk_formula_produto
        FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE formula_item (
    id SERIAL PRIMARY KEY,
    formula_id INTEGER NOT NULL,
    insumo_id INTEGER NOT NULL,
    quantidade NUMERIC(10,3) NOT NULL,

    CONSTRAINT fk_formula_item_formula
        FOREIGN KEY (formula_id) REFERENCES formula(id),

    CONSTRAINT fk_formula_item_insumo
        FOREIGN KEY (insumo_id) REFERENCES insumo(id)
);

CREATE TABLE estoque_produto (
    id SERIAL PRIMARY KEY,
    produto_id INTEGER NOT NULL,
    quantidade NUMERIC(10,3) NOT NULL DEFAULT 0,
    estoque_minimo NUMERIC(10,3) NOT NULL DEFAULT 0,

    CONSTRAINT fk_estoque_produto
        FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE estoque_insumo (
    id SERIAL PRIMARY KEY,
    insumo_id INTEGER NOT NULL,
    quantidade NUMERIC(10,3) NOT NULL DEFAULT 0,
    estoque_minimo NUMERIC(10,3) NOT NULL DEFAULT 0,

    CONSTRAINT fk_estoque_insumo
        FOREIGN KEY (insumo_id) REFERENCES insumo(id)
);

CREATE TABLE lote_insumo (
    id SERIAL PRIMARY KEY,
    insumo_id INTEGER NOT NULL,
    quantidade NUMERIC(10,3) NOT NULL,
    validade DATE,

    CONSTRAINT fk_lote_insumo
        FOREIGN KEY (insumo_id) REFERENCES insumo(id)
);

CREATE TABLE movimentacao_estoque (
    id SERIAL PRIMARY KEY,

    tipo VARCHAR(20) NOT NULL,
    origem VARCHAR(30) NOT NULL,

    item_id INTEGER NOT NULL,
    item_tipo VARCHAR(20) NOT NULL,
    quantidade NUMERIC(10,3) NOT NULL,
    data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);