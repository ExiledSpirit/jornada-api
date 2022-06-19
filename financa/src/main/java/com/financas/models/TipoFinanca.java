package com.financas.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "tipo_financa")
public class TipoFinanca extends EntidadeGenerica{
    private String nome;

    public TipoFinanca() { }

    public TipoFinanca(String nome) {
        this.nome = nome;
    }

    public TipoFinanca(Long id, Date createdAt, Boolean deletado, String nome) {
        super(id, createdAt, deletado);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
