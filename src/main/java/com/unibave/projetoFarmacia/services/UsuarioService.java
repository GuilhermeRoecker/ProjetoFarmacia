package com.unibave.projetoFarmacia.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.unibave.projetoFarmacia.model.Usuario;
import com.unibave.projetoFarmacia.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario modificarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void excluirCadastroUsuario(Usuario usuario) {
        repository.delete(usuario);
    }

    public Usuario findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Usuario findByDocumento(String documento) {
        return repository.findByDocumento(documento);
    }

    public Usuario findByTelefone(String telefone) {
        return repository.findByTelefone(telefone);
    }

    public Usuario findByCRM(String crm) {
        return repository.findByCrm(crm);
    }

    public Usuario findByEspecialidade(String especialidade) {
        return repository.findByEspecialidade(especialidade);
    }

    public Usuario findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public Usuario findByRole(String role) {
        return repository.findByRole(role);
    }

    public Usuario modificarParcial(Integer id, Usuario usuario) {
        Objects.requireNonNull(id, "O parâmetro 'id' não pode ser nulo");
        Objects.requireNonNull(usuario, "O parâmetro 'usuario' não pode ser nulo");

        Usuario u = repository.findById(id).orElse(null);
        if (u != null) {
            if (usuario.getNome() != null) {
                u.setNome(usuario.getNome());
            }
            if (usuario.getEmail() != null) {
                u.setEmail(usuario.getEmail());
            }
            if (usuario.getTelefone() != null) {
                u.setTelefone(usuario.getTelefone());
            }
            if (usuario.getDocumento() != null) {
                u.setDocumento(usuario.getDocumento());
            }
            if (usuario.getCRM() != null) {
                u.setCRM(usuario.getCRM());
            }
            if (usuario.getEspecialidade() != null) {
                u.setEspecialidade(usuario.getEspecialidade());
            }
            if (usuario.getRole() != null) {
                u.setRole(usuario.getRole());
            }
            return repository.save(u);
        }
        return null;
    }

    public List<Usuario> listAll() {
        return repository.findAll();
    }

    

}
