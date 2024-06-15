package com.example.model;

public class Orientador {
    private String cpf;
    private String nome;
    private String email;
    private String titulacao;

    public Orientador(String cpf, String nome, String email, String titulacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.titulacao = titulacao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}
