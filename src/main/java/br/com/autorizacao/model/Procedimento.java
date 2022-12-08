package br.com.autorizacao.model;

public class Procedimento {

    private Long id;
    private String codigo;
    private String sexo;
    private int idade;
    private Boolean permissao;

    public Procedimento(Long id, String codigo, String sexo, int idade, Boolean permissao) {
        this.id = id;
        this.codigo = codigo;
        this.sexo = sexo;
        this.idade = idade;
        this.permissao = permissao;
    }

    public Procedimento(String codigo, String sexo, int idade, Boolean permissao) {
        this(null, codigo,sexo,idade,permissao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Boolean getPermissao() {
        return permissao;
    }

    public void setPermissao(Boolean permissao) {
        this.permissao = permissao;
    }
}
