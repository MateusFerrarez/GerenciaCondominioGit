/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.sqlSchemas;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mateu
 */
public class SqlUpdateSchemas {

    public static PreparedStatement queryUpdateProprietario(Connection connection) throws SQLException {
        final String querySql = "UPDATE PROPRIETARIO SET NOME = ?, RG = ?, CPF = ?, DT_NASCIMENTO = ? WHERE ID_PROPRIETARIO = ?";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryUpdateMorador(Connection connection) throws SQLException {
        final String querySql = "UPDATE MORADOR SET NOME = ?, RG = ?, CPF = ?, DT_NASCIMENTO = ? WHERE ID_MORADOR = ?";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryUpdateResidencia(Connection connection) throws SQLException {
        final String querySql = "UPDATE RESIDENCIA SET RUA = ?, CEP = ?, NUMERO = ? WHERE ID_RESIDENCIA = ?";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryUpdateProprietarioResidencia(Connection connection) throws SQLException {
        final String querySql = "UPDATE PROPRIETARIO_RESIDENCIA SET ID_PROPRIETARIO = ? WHERE ID_RESIDENCIA = ?";
        var query = connection.prepareStatement(querySql);
        return query;
    }

    public static PreparedStatement queryUpdateMoradorResidencia(Connection connection) throws SQLException {
        final String querySql = "UPDATE MORADOR_RESIDENCIA SET ID_RESIDENCIA = ? WHERE ID_MORADOR = ?";
        var query = connection.prepareCall(querySql);
        return query;
    }

    public static PreparedStatement queryUpdateParcelaResidencia(Connection connection) throws SQLException {
        final String querySql = "UPDATE PARCELA_RESIDENCIA SET VL_PARCELA = ?, VL_PAGO = ?, DT_PARCELA = ? WHERE ID_PARCELA_RESIDENCIA = ?";
        var query = connection.prepareStatement(querySql);
        return query;
    }
}
