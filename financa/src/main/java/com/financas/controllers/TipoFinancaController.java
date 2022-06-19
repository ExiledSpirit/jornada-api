package com.financas.controllers;

import com.financas.models.TipoFinanca;
import com.financas.services.ServiceGenerico;
import com.financas.services.TipoFinancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tipo-financa")
public class TipoFinancaController extends ControllerGenerico<TipoFinanca, Long> {
    private final TipoFinancaService tipoFinancaService;

    @Autowired
    public TipoFinancaController(TipoFinancaService tipoFinancaService) {
        this.tipoFinancaService = tipoFinancaService;
    }

    @Override
    protected ServiceGenerico<TipoFinanca, Long> getServiceGenerico() {
        return tipoFinancaService;
    }
}
