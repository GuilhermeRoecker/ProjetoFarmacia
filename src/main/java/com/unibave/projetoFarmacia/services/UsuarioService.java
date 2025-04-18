package com.unibave.projetoFarmacia.services;

import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unibave.projetoFarmacia.model.Usuario;
import com.unibave.projetoFarmacia.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    // Construtor
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();  // Usando BCrypt para hash da senha
    }

    // Cadastrar usuário (com hash de senha)
    public Usuario cadastrarUsuario(Usuario usuario) {
        String hashedPassword = passwordEncoder.encode(usuario.getSenha());  // Criptografando a senha
        usuario.setSenha(hashedPassword);  // Atualizando a senha com o hash
        return repository.save(usuario);
    }

    // Modificar usuário (com hash de senha)
    public Usuario modificarUsuario(Usuario usuario) {
        if (usuario.getSenha() != null) {
            String hashedPassword = passwordEncoder.encode(usuario.getSenha());  // Criptografando a senha
            usuario.setSenha(hashedPassword);  // Atualizando a senha com o hash
        }
        return repository.save(usuario);
    }

    // Encontrar usuário por ID
    public Usuario findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Excluir cadastro de usuário
    public void excluirCadastroUsuario(Usuario usuario) {
        repository.delete(usuario);
    }

    // Encontrar usuário por nome de usuário (username)
    public Usuario findByUsername(String username) {
        return repository.findByUsername(username);
    }

    // Encontrar usuário por e-mail
    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }

    // Encontrar usuário por documento
    public Usuario findByDocumento(String documento) {
        return repository.findByDocumento(documento);
    }

    // Encontrar usuário por telefone
    public Usuario findByTelefone(String telefone) {
        return repository.findByTelefone(telefone);
    }

    // Encontrar usuário por CRM
    public Usuario findByCRM(String crm) {
        return repository.findByCrm(crm);
    }

    // Encontrar usuário por especialidade
    public Usuario findByEspecialidade(String especialidade) {
        return repository.findByEspecialidade(especialidade);
    }

    // Encontrar usuário por nome
    public Usuario findByNome(String nome) {
        return repository.findByNome(nome);
    }

    // Encontrar usuário por papel (role)
    public Usuario findByRole(String role) {
        return repository.findByRole(role);
    }

    // Modificar parcialmente um usuário
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

    // Listar todos os usuários
    public List<Usuario> listAll() {
        return repository.findAll();
    }

    // Autenticar usuário (verificar senha)
    public boolean autenticar(String username, String senha) {
        Usuario usuario = repository.findByUsername(username);
        return usuario != null && passwordEncoder.matches(senha, usuario.getSenha());  // Comparando a senha fornecida com o hash armazenado
    }
}
