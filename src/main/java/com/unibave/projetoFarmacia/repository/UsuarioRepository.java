package com.unibave.projetoFarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibave.projetoFarmacia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByUsername(String username);
    public Usuario findByEmail(String email);
    public Usuario findByDocumento(String documento);
    public Usuario findByTelefone(String telefone);
    Usuario findByCrm(String crm);
    public Usuario findByEspecialidade(String especialidade);
    public Usuario findByNome(String nome);
    public Usuario findByRole(String role);

}
