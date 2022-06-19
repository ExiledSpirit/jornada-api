package com.financas.services;

import com.financas.models.Usuario;
import com.financas.repositories.RepositoryGenerico;
import com.financas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioService extends ServiceGenerico<Usuario, Long>{
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected UsuarioRepository getRepositoryGenerico() {
        return usuarioRepository;
    }

    public boolean autenticar(Map<String, String> credenciais) {
        Optional<Usuario> possivelUsuario = getRepositoryGenerico().autenticar(credenciais.get("login"), credenciais.get("senha"));
        if (possivelUsuario.isPresent()) return true;
        return false;
    }
}
