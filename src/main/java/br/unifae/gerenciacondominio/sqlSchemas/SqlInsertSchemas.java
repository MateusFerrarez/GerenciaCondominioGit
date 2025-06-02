/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.sqlSchemas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author patri
 */
public class SqlInsertSchemas {

    public static PreparedStatement queryInsertResidencia(Connection connection) throws SQLException {
        final String querySql = "INSERT INTO RESIDENCIA (RUA, CEP, NUMERO)"
                + " VALUES (?, ?, ?)";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryInsertProprietario(Connection connection) throws SQLException {
        final String querySql = "INSERT INTO PROPRIETARIO(NOME, RG, CPF, DT_NASCIMENTO)"
                + " VALUES (?, ?, ?, ?)";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryInsertMorador(Connection connection) throws SQLException {
        final String querySql = "INSERT INTO MORADOR(NOME, RG, CPF, DT_NASCIMENTO)"
                + " VALUES (?, ?, ?, ?)";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryInsertProprietarioResidencia(Connection connection) throws SQLException {
        final String querySql = "INSERT INTO PROPRIETARIO_RESIDENCIA (ID_PROPRIETARIO, ID_RESIDENCIA) VALUES (?,?)";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryInsertMoradorResidencia(Connection connection) throws SQLException {
        final String querySql = "INSERT INTO MORADOR_RESIDENCIA (ID_MORADOR, ID_RESIDENCIA) VALUES ((SELECT MAX(ID_MORADOR) FROM MORADOR),?)";
        var query = connection.prepareCall(querySql);
        return query;
    }
    
    public static PreparedStatement queryInsertParcelaResidencia(Connection connection) throws SQLException {
        final String querySql = "INSERT INTO PARCELA_RESIDENCIA (ID_RESIDENCIA, VL_PARCELA, VL_PAGO, DT_PARCELA)"
                + " VALUES (?, ? ,?, ?)";
        var query = connection.prepareCall(querySql);
        return query;
    }
}
