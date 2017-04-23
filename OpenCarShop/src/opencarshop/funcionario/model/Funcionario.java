package opencarshop.funcionario.model;

import java.time.LocalDate;

public class Funcionario {

    private String cpf;
    private String nome;
    private String senha;
    private LocalDate dataNascimento;
    private String email;
    private String telefone1;
    private String telefone2;
    private Boolean ativo;
    
    
    public Funcionario(){}
    
    public Funcionario(String cpf,
                       String nome,
                       String senha,
                       LocalDate dataNascimento,
                       String email,
                       String telefone1,
                       String telefone2,
                       boolean ativo){
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.ativo = ativo;
    }
    
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
}
