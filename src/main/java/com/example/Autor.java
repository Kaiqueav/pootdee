package com.example;

public class Autor {

    
        private String cpf;
        private String nome;
        private String email;
        private String curso;
    
        public Autor(String cpf, String nome, String email, String curso) {
            this.cpf = cpf;
            this.nome = nome;
            this.email = email;
            this.curso = curso;
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
    
        public String getCurso() {
            return curso;
        }
    
        public void setCurso(String curso) {
            this.curso = curso;
        }
    
}
