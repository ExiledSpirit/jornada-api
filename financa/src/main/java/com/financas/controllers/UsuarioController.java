package com.financas.controllers;

import com.financas.models.Usuario;
import com.financas.services.ServiceGenerico;
import com.financas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController extends ControllerGenerico<Usuario, Long>{
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    protected UsuarioService getServiceGenerico() {
        return usuarioService;
    }

    @PostMapping("/autenticar")
    ResponseEntity<Usuario> autenticar(@RequestBody Map<String, String> credenciais) throws Exception {
        return new ResponseEntity<>(getServiceGenerico().autenticar(credenciais), HttpStatus.OK);
    }
}
