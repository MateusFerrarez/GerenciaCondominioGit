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
 * @author user
 */
public class SqlDeleteSchemas {

    public static PreparedStatement queryDeleteMorador(Connection connection) throws SQLException {
        final String querySql = "DELETE FROM MORADOR WHERE ID_MORADOR = ?";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryDeleteParcelaResidencia(Connection connection) throws SQLException {
        final String querySql = "DELETE FROM PARCELA_RESIDENCIA WHERE ID_PARCELA_RESIDENCIA = ?";
        var query = connection.prepareCall(querySql);
        return query;
    }
    
    public static PreparedStatement queryDeleteResidencia(Connection connection) throws SQLException {
        final String querySql = "DELETE FROM RESIDENCIA WHERE ID_RESIDENCIA = ?";
        var query = connection.prepareCall(querySql);
        return query;
    }
    
    public static PreparedStatement queryDeleteProprietario(Connection connection) throws SQLException {
        final String querySql = "DELETE FROM PROPRIETARIO WHERE ID_PROPRIETARIO = ?";
        var query = connection.prepareCall(querySql);
        return query;
    }
}
