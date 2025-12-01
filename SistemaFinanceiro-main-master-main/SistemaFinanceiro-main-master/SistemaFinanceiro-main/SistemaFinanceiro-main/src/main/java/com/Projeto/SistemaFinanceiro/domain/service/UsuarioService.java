package com.Projeto.SistemaFinanceiro.domain.service;

import com.Projeto.SistemaFinanceiro.domain.usuario.UsuarioRepository;
import com.Projeto.SistemaFinanceiro.domain.usuario.DadosCadastroUsuario;
import com.Projeto.SistemaFinanceiro.domain.usuario.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario cadastrarUsuario(DadosCadastroUsuario dados){
        var senhaCriptogafada = passwordEncoder.encode(dados.senha());
        var usuario = new Usuario(dados.login(),senhaCriptogafada);
        usuarioRepository.save(usuario);
        return usuario;
    }
}