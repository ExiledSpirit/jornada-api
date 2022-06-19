package com.financas.controllers;

import com.financas.models.Financa;
import com.financas.services.FinancaService;
import com.financas.services.ServiceGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financa")
public class FinancaController extends ControllerGenerico<Financa, Long> {
    private final FinancaService financaService;

    @Autowired
    public FinancaController(FinancaService financaService) {
        this.financaService = financaService;
    }

    @Override
    protected ServiceGenerico<Financa, Long> getServiceGenerico() {
        return financaService;
    }
}
