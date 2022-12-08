package br.com.autorizacao.model;

import java.time.LocalDate;

public class Solicitacao {

    private Long id;
    private String paciente;
    private LocalDate nascimento;
    private String sexo;

    private Procedimento procedimento;

    public Solicitacao(Long id, String paciente, LocalDate nascimento, String sexo, Procedimento procedimento) {
        this.id = id;
        this.paciente = paciente;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.procedimento = procedimento;
    }

    public Solicitacao(String paciente, LocalDate nascimento, String sexo, Procedimento procedimento) {
        this(null,paciente,nascimento,sexo, procedimento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
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
