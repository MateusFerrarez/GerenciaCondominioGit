/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.model.factory;

import br.unifae.gerenciacondominio.model.Pessoa;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author patri
 */
public interface Factory {

    public void insertPessoa(String nome, String cpf, String rg, LocalDate dtNascimento) throws SQLException;

    public List<Pessoa> getPessoas() throws SQLException;

    public Pessoa getPessoaById(Long idPessoa) throws SQLException;

    public void updatePessoa(Long idPessoa, String nome, String cpf, String rg, LocalDate dtNascimento) throws SQLException;

    public void deletePessoaById(Long idPessoa) throws SQLException;
}
