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
public class Proprietario extends Pessoa {

    public Proprietario(Long idPessoa, String nome, String rg, String cpf, LocalDate dtNascimento) {
        super(idPessoa, nome, rg, cpf, dtNascimento);
    }

    public Proprietario(Long idPessoa, String nome, String rg, String cpf, int idade) {
        super(idPessoa, nome, rg, cpf, idade);
    }

    public Proprietario(String nome, String rg, String cpf, LocalDate dtNascimento) {
        super(nome, rg, cpf, dtNascimento);
    }

}
