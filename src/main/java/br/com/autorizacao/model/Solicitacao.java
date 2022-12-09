package br.com.autorizacao.model;

import java.time.LocalDate;

public class Solicitacao {

    private Long id;
    private String paciente;


    private int idade;
    private String sexo;

    private Procedimento procedimento;

    public Solicitacao(Long id, String paciente, int idade, String sexo, Procedimento procedimento) {
        this.id = id;
        this.paciente = paciente;
        this.idade = idade;
        this.sexo = sexo;
        this.procedimento = procedimento;
    }

    public Solicitacao(String paciente,int idade, String sexo, Procedimento procedimento) {
        this(null,paciente,idade,sexo, procedimento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

}
