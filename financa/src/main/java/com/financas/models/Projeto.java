package com.financas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Projeto extends EntidadeGenerica {
    @ManyToMany
    @JoinTable(
            name = "projeto_tem_usuario",
            joinColumns = @JoinColumn(name = "fk_projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_usuario_id")
    )
    private Set<Usuario> membros;

    @OneToMany(
            mappedBy = "projeto",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private Set<Financa> financas;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "saldo")
    private Float saldo;

    public Projeto() { }

    public Projeto(Set<Usuario> membros, Set<Financa> financas, String titulo, Float saldo) {
        this.membros = membros;
        this.financas = financas;
        this.titulo = titulo;
        this.saldo = saldo;
    }

    public Projeto(Long id, Date createdAt, Boolean deletado, Set<Usuario> membros, Set<Financa> financas, String titulo, Float saldo) {
        super(id, createdAt, deletado);
        this.membros = membros;
        this.financas = financas;
        this.titulo = titulo;
        this.saldo = saldo;
    }

    public Set<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(Set<Usuario> membros) {
        this.membros = membros;
    }

    public Set<Financa> getFinancas() {
        return financas;
    }

    public void setFinancas(Set<Financa> financas) {
        this.financas = financas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "membros=" + membros +
                ", financas=" + financas +
                ", titulo='" + titulo + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
