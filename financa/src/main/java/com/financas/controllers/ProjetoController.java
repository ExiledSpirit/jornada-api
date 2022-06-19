package com.financas.controllers;

import com.financas.models.Projeto;
import com.financas.services.ProjetoService;
import com.financas.services.ServiceGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projeto")
public class ProjetoController extends ControllerGenerico<Projeto, Long> {
    private final ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @Override
    protected ServiceGenerico<Projeto, Long> getServiceGenerico() {
        return projetoService;
    }
}
