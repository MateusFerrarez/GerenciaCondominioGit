/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.model.factory;

import br.unifae.gerenciacondominio.model.Pessoa;
import br.unifae.gerenciacondominio.model.Proprietario;
import br.unifae.gerenciacondominio.sqlSchemas.SqlDeleteSchemas;
import br.unifae.gerenciacondominio.sqlSchemas.SqlInsertSchemas;
import br.unifae.gerenciacondominio.sqlSchemas.SqlSelectSchemas;
import br.unifae.gerenciacondominio.sqlSchemas.SqlUpdateSchemas;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author patri
 */
public class FactoryProprietario implements Factory {

    private Connection dbConnection;

    public FactoryProprietario(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void insertPessoa(String nome, String cpf, String rg, LocalDate dtNascimento) throws SQLException {
        final Proprietario proprietario = new Proprietario(0L, nome, rg, cpf, dtNascimento);

        var stament = SqlInsertSchemas.queryInsertProprietario(dbConnection);
        stament.setString(1, proprietario.getNome());
        stament.setString(2, proprietario.getRg());
        stament.setString(3, proprietario.getCpf());
        stament.setString(4, proprietario.getDtNascimento().toString());
        stament.executeUpdate();
    }

    @Override
    public List<Pessoa> getPessoas() throws SQLException {
        final List<Pessoa> tempPessoas = new ArrayList<>();
        var result = SqlSelectSchemas.queryGetProprietarios(dbConnection);

        while (result.next()) {
            final Long idProprietario = result.getLong(1);
            final String nome = result.getString(2).toUpperCase();
            final String rg = result.getString(3).toUpperCase();
            final String cpf = result.getString(4).toUpperCase();
            final int idade = result.getInt(5);

            final Proprietario proprietario = new Proprietario(idProprietario, nome, rg, cpf, idade);
            tempPessoas.add(proprietario);
        }

        return tempPessoas;
    }

    @Override
    public void updatePessoa(Long idPessoa, String nome, String cpf, String rg, LocalDate dtNascimento) throws SQLException {
        final Proprietario proprietario = new Proprietario(0L, nome, rg, cpf, dtNascimento);

        var stament = SqlUpdateSchemas.queryUpdateProprietario(dbConnection);
        stament.setString(1, proprietario.getNome());
        stament.setString(2, proprietario.getRg());
        stament.setString(3, proprietario.getCpf());
        stament.setString(4, proprietario.getDtNascimento().toString());
        stament.setLong(5, idPessoa);
        stament.executeUpdate();
    }

    @Override
    public Pessoa getPessoaById(Long idPessoa) throws SQLException {
        var result = SqlSelectSchemas.queryGetProprietarioById(dbConnection, idPessoa);
        Pessoa proprietario = null;

        while (result.next()) {
            final String nome = result.getString(1);
            final String rg = result.getString(2);
            final String cpf = result.getString(3);
            final String dtNascimentoString = result.getString(4);
            LocalDate data = LocalDate.parse(dtNascimentoString);

            proprietario = new Proprietario(idPessoa, nome, rg, cpf, data);
        }

        return proprietario;
    }

    @Override
    public void deletePessoaById(Long idPessoa) throws SQLException {
        var result = SqlDeleteSchemas.queryDeleteProprietario(dbConnection);
        result.setLong(1, idPessoa);
        result.executeUpdate();
    }

}
