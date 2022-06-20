package com.financas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "financa")
public class Financa extends EntidadeGenerica {
    @ManyToOne()
    @JoinColumn(name = "fk_projeto_id")
    @JsonIgnore
    private Projeto projeto;

    @ManyToOne()
    @JoinColumn(name = "fk_usuario_id")
    private Usuario usuario;

    @Column(name = "valor")
    private float valor;

    @ManyToOne()
    @JoinColumn(name = "fk_tipo_financa_id")
    private TipoFinanca tipoFinanca;

    public Financa() { }

    public Financa(Projeto projeto, Usuario usuario, float valor, TipoFinanca tipoFinanca) {
        this.projeto = projeto;
        this.usuario = usuario;
        this.valor = valor;
        this.tipoFinanca = tipoFinanca;
    }

    public Financa(Long id, Date createdAt, Boolean deletado, Projeto projeto, Usuario usuario, float valor, TipoFinanca tipoFinanca) {
        super(id, createdAt, deletado);
        this.projeto = projeto;
        this.usuario = usuario;
        this.valor = valor;
        this.tipoFinanca = tipoFinanca;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public TipoFinanca getTipoFinanca() {
        return tipoFinanca;
    }

    public void setTipoFinanca(TipoFinanca tipoFinanca) {
        this.tipoFinanca = tipoFinanca;
    }

    @Override
    public String toString() {
        return "Financa{" +
                "projeto=" + projeto +
                ", usuario=" + usuario +
                ", valor=" + valor +
                ", tipoFinanca=" + tipoFinanca +
                '}';
    }
}
