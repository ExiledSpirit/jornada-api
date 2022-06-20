package com.financas.controllers;

import com.financas.models.Projeto;
import com.financas.services.ProjetoService;
import com.financas.services.ServiceGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projeto")
public class ProjetoController extends ControllerGenerico<Projeto, Long> {
    private final ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @Override
    protected ProjetoService getServiceGenerico() {
        return projetoService;
    }

    @GetMapping("/por-usuario/{id}")
    public ResponseEntity<List<Projeto>> buscarProjetosPorUsuarioId(@PathVariable Long id) {
        return new ResponseEntity<>(getServiceGenerico().buscarProjetosPorUsuarioId(id), HttpStatus.OK);
    }
}
