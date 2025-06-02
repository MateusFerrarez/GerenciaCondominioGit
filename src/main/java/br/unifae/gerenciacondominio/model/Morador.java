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
public class Morador extends Pessoa{
    
    public Morador(Long idPessoa, String nome, String rg, String cpf, LocalDate dtNascimento) {
        super(idPessoa, nome, rg, cpf, dtNascimento);
    }

    public Morador(Long idPessoa, String nome, String rg, String cpf, LocalDate dtNascimento, Residencia residencia) {
        super(idPessoa, nome, rg, cpf, dtNascimento, residencia);
    }
   
    
}
