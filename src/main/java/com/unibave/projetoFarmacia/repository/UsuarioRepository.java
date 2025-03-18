package com.unibave.projetoFarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibave.projetoFarmacia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
