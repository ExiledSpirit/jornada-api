package com.financas.services;

import com.financas.models.EntidadeGenerica;
import com.financas.repositories.RepositoryGenerico;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class ServiceGenerico<T extends EntidadeGenerica, ID extends Serializable>{
    /**
     * Método que retorna para o service, durante o runtime,
     * o repository da execução atual.
     *
     * @return {@link RepositoryGenerico<T, ID>}. Repository Genérico.
     */
    @Autowired
    protected abstract RepositoryGenerico<T, ID> getRepositoryGenerico();

    public List<T> findAll() {
        return getRepositoryGenerico().findAll();
    }

    public T findById(ID id) throws Exception {
        Optional<T> possivelObjeto = getRepositoryGenerico().findById(id);
        if (!possivelObjeto.isPresent()) throw new Exception("not found");
        return possivelObjeto.get();
    }

    public T save(T objeto) {
        return getRepositoryGenerico().save(objeto);
    }

    public T update(ID id, T objeto) throws Exception {
        Optional<T> possivelObjeto = getRepositoryGenerico().findById(id);
        if (!possivelObjeto.isPresent()) {
            throw new Exception("ID não existe");
        }
        System.out.println(objeto.getId());
        return getRepositoryGenerico().save(objeto);
    }

    public void delete(ID id) {
        getRepositoryGenerico().deleteById(id);
    }
}
