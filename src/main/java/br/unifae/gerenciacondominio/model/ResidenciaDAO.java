/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.model;

import br.unifae.gerenciacondominio.sqlSchemas.SqlDeleteSchemas;
import br.unifae.gerenciacondominio.sqlSchemas.SqlInsertSchemas;
import br.unifae.gerenciacondominio.sqlSchemas.SqlSelectSchemas;
import br.unifae.gerenciacondominio.sqlSchemas.SqlUpdateSchemas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateu
 */
public class ResidenciaDAO {

    private Connection dbConnection;

    public ResidenciaDAO(Connection connection) {
        this.dbConnection = connection;
    }

    public void insertResidencia(Residencia residencia) throws SQLException {
        var stament = SqlInsertSchemas.queryInsertResidencia(dbConnection);
        stament.setString(1, residencia.getRua());
        stament.setString(2, residencia.getCep());
        stament.setString(3, residencia.getNumero());
        stament.executeUpdate();
    }

    public void insertMoradoResidencia(Long idResidencia) throws SQLException {
        var stament = SqlInsertSchemas.queryInsertMoradorResidencia(dbConnection);
        stament.setLong(1, idResidencia);
        stament.executeUpdate();
    }

    public void atribuirProprietario(Long idProprietario, Long idResidencia) throws SQLException {
        var stamentVerica = SqlSelectSchemas.queryGetVerificaProprietarioResidencia(dbConnection);
        stamentVerica.setLong(1, idResidencia);

        var result = stamentVerica.executeQuery();

        Long existe = 0L;

        while (result.next()) {
            existe = result.getLong(1);
        }

        if (existe == 0) {
            var stament = SqlInsertSchemas.queryInsertProprietarioResidencia(dbConnection);
            stament.setLong(1, idProprietario);
            stament.setLong(2, idResidencia);
            stament.executeUpdate();
            return;
        }

        var stament = SqlUpdateSchemas.queryUpdateProprietarioResidencia(dbConnection);
        stament.setLong(1, idProprietario);
        stament.setLong(2, idResidencia);
        stament.executeUpdate();
    }

    public void updateResidencia(Residencia residencia) throws SQLException {
        var stament = SqlUpdateSchemas.queryUpdateResidencia(dbConnection);
        stament.setString(1, residencia.getRua());
        stament.setString(2, residencia.getCep());
        stament.setString(3, residencia.getNumero());
        stament.setLong(4, residencia.getIdResidencia());
        stament.executeUpdate();
    }

    public void updateMoradoResidencia(Long idMorador, Long idResidencia) throws SQLException {
        var stament = SqlUpdateSchemas.queryUpdateMoradorResidencia(dbConnection);
        stament.setLong(1, idResidencia);
        stament.setLong(2, idMorador);
        stament.executeUpdate();
    }

    public List<Residencia> getResidencias() throws SQLException {
        final List<Residencia> tempResidencias = new ArrayList<>();

        ResultSet result = SqlSelectSchemas.queryGetResidencias(dbConnection);

        while (result.next()) {
            final Long idResidencia = result.getLong(1);
            final String rua = result.getString(2);
            final String cep = result.getString(3);
            final String numero = result.getString(4);

            final Residencia residencia = new Residencia(idResidencia, rua, numero, cep);
            tempResidencias.add(residencia);
        }

        return tempResidencias;
    }

    public Residencia getResidenciaById(Long idResidencia) throws SQLException {
        ResultSet result = SqlSelectSchemas.queryGetResidenciaById(dbConnection, idResidencia);

        Residencia tempResidencia = null;

        while (result.next()) {
            final String rua = result.getString(1);
            final String cep = result.getString(2);
            final String numero = result.getString(3);
            tempResidencia = new Residencia(rua, numero, cep);
        }

        return tempResidencia;
    }
    
    public void deleteResidenciaById(Long idResidencia) throws SQLException {
        var stament = SqlDeleteSchemas.queryDeleteResidencia(dbConnection);
        stament.setLong(1, idResidencia);
        stament.executeUpdate();
    }

}
