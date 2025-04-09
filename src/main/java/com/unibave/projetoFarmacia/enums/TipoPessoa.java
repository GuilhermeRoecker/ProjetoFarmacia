package com.unibave.projetoFarmacia.enums;

public enum TipoPessoa {
    FISICA(1),
    JURIDICA(2);

    private final int codigo;

    TipoPessoa(int codigo) { this.codigo = codigo; }

    public int getCodigo() { return codigo; }

    public static TipoPessoa fromCodigo(int codigo) {
        for (TipoPessoa tipo : values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo inválido");
    }
}

