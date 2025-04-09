package com.unibave.projetoFarmacia.enums;

public enum Sexo {
    HOMEM("Homem"),
    MULHER("Mulher"),
    NAO_INFORMADO("Prefere não se identificar");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
