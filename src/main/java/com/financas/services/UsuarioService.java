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

    public Usuario autenticar(Map<String, String> credenciais) throws Exception {
        Optional<Usuario> possivelUsuario = getRepositoryGenerico().autenticar(credenciais.get("login"), credenciais.get("senha"));
        if (possivelUsuario.isPresent()) return possivelUsuario.get();
        throw new Exception("Não autenticado");
    }
}
