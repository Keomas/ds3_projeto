package opencarshop.fornecedor.model;

public class Fornecedor {

    private String cnpj;
    private String razaoSocial;
    private String email;
    private String telefone1;
    private String telefone2;
    private String descricao;
    private Boolean ativo;
    
    public Fornecedor(){}
    
    public Fornecedor(     
            String cnpj,
            String razaoSocial,
            String email,
            String telefone1,
            String telefone2,
            String descricao,
            Boolean ativo)
    {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
