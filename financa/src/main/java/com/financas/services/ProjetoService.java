package com.financas.services;

import com.financas.models.Projeto;
import com.financas.repositories.ProjetoRepository;
import com.financas.repositories.RepositoryGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService extends ServiceGenerico<Projeto, Long> {
    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Override
    protected RepositoryGenerico<Projeto, Long> getRepositoryGenerico() {
        return projetoRepository;
    }
}
