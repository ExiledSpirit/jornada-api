package com.financas.services;

import com.financas.models.Financa;
import com.financas.repositories.FinancaRepository;
import com.financas.repositories.RepositoryGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancaService extends ServiceGenerico<Financa, Long> {
    private final FinancaRepository financaRepository;

    @Autowired
    public FinancaService(FinancaRepository financaRepository) {
        this.financaRepository = financaRepository;
    }

    @Override
    protected FinancaRepository getRepositoryGenerico() {
        return financaRepository;
    }
}
