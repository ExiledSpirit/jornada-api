package com.financas.controllers;

import com.financas.models.EntidadeGenerica;
import com.financas.services.ServiceGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class ControllerGenerico<T extends EntidadeGenerica, ID extends Serializable> {
    /**
     * Método que retorna para o Controller, durante o runtime,
     * o Service da execução atual.
     *
     * @return {@link ServiceGenerico<T, ID>}. Service Genérico.
     */
    @Autowired
    protected abstract ServiceGenerico<T, ID> getServiceGenerico();

    @GetMapping("")
    ResponseEntity<List<T>> findAll() {
        return new ResponseEntity<>(getServiceGenerico().findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<T> findById(@PathVariable ID id) throws Exception {
        return new ResponseEntity<>(getServiceGenerico().findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    ResponseEntity<T> save(@RequestBody T objeto) {
        return new ResponseEntity<>(getServiceGenerico().save(objeto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<T> update(@PathVariable ID id, @RequestBody T objeto) throws Exception {
        return new ResponseEntity<>(getServiceGenerico().update(id, objeto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable ID id) {
        getServiceGenerico().delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
