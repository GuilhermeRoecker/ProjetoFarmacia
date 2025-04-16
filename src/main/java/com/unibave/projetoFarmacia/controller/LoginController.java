package com.unibave.projetoFarmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.unibave.projetoFarmacia.model.Usuario;
import com.unibave.projetoFarmacia.services.UsuarioService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Permite CORS para essa rota específica
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String login(@RequestBody Usuario loginData) {
        Usuario usuario = usuarioService.findByUsername(loginData.getUsername());

        if (usuario != null && usuario.getSenha().equals(loginData.getSenha())) {
            return "Login bem-sucedido! Bem-vindo, " + usuario.getNome();
        }

        return "Usuário ou senha inválidos.";
    }
}
