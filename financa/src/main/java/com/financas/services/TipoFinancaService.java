package com.financas.services;

import com.financas.models.TipoFinanca;
import com.financas.repositories.RepositoryGenerico;
import com.financas.repositories.TipoFinancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoFinancaService extends ServiceGenerico<TipoFinanca, Long> {
    private final TipoFinancaRepository tipoFinancaRepository;

    @Autowired
    public TipoFinancaService(TipoFinancaRepository tipoFinancaRepository) {
        this.tipoFinancaRepository = tipoFinancaRepository;
    }

    @Override
    protected RepositoryGenerico<TipoFinanca, Long> getRepositoryGenerico() {
        return tipoFinancaRepository;
    }
}
