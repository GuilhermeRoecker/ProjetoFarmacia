package com.unibave.projetoFarmacia.model;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;
    
    @Column
    private LocalDate dtNascimento;

    @CPF
    private String cpf;

    




}
