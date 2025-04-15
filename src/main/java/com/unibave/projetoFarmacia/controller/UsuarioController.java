package com.unibave.projetoFarmacia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unibave.projetoFarmacia.model.Usuario;
import com.unibave.projetoFarmacia.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listAll() {
        List<Usuario> usuarios = usuarioService.listAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("buscar/documento")
    public ResponseEntity<Usuario> findByDocumento(@RequestParam String documento) {
        Usuario usuario = usuarioService.findByDocumento(documento);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("buscar/telefone")
    public ResponseEntity<Usuario> findByTelefone(@RequestParam String telefone) {
        Usuario usuario = usuarioService.findByTelefone(telefone);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("buscar/email")
    public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.findByEmail(email);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("buscar/crm")
    public ResponseEntity<Usuario> findByCRM(@RequestParam String crm) {
        Usuario usuario = usuarioService.findByCRM(crm);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("buscar/especialidade")
    public ResponseEntity<Usuario> findByEspecialidade(@RequestParam String especialidade) {
        Usuario usuario = usuarioService.findByEspecialidade(especialidade);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("buscar/role")
    public ResponseEntity<Usuario> findByRole(@RequestParam String role) {
        Usuario usuario = usuarioService.findByRole(role);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("buscar/username")
    public ResponseEntity<Usuario> findByUsername(@RequestParam String username) {
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(usuarioCadastrado);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable Integer id,@RequestBody Usuario usuario) {
        Usuario usuarioModificado = usuarioService.modificarParcial(id, usuario);
        if (usuarioModificado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioModificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.excluirCadastroUsuario(usuario);
        return ResponseEntity.noContent().build();
    }
}
