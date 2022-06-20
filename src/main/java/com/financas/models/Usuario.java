package com.financas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Usuario extends EntidadeGenerica{
    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    public Usuario() { }

    public Usuario(String login, String senha, String email, String cpf, String nome) {
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Usuario(Long id, Date createdAt, Boolean deletado, String login, String senha, String email, String cpf, String nome) {
        super(id, createdAt, deletado);
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
