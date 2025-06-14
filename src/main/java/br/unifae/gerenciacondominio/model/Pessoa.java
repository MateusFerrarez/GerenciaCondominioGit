/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.model;

import java.time.LocalDate;

/**
 *
 * @author android
 */
public abstract class Pessoa {

    private Long idPessoa;
    private String nome;
    private String rg;
    private String cpf;
    private int idade;
    private LocalDate dtNascimento;
    private Residencia residencia;

    public Pessoa(Long idPessoa, String nome, String rg, String cpf, LocalDate dtNascimento) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public Pessoa(Long idPessoa, String nome, String rg, String cpf, int idade) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Pessoa(String nome, String rg, String cpf, LocalDate dtNascimento) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public Pessoa(Long idPessoa, String nome, String rg, String cpf, LocalDate dtNascimento, Residencia residencia) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.residencia = residencia;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Residencia getResidencia() {
        return residencia;
    }
    
    

}
