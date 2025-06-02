/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.sqlSchemas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author patri
 */
public class SqlSelectSchemas {

    public static ResultSet queryGetProprietarios(Connection connection) throws SQLException {
        final String querySql = "SELECT P.ID_PROPRIETARIO, P.NOME, P.RG, P.CPF,"
                + " (SELECT TIMESTAMPDIFF(YEAR, DT_NASCIMENTO, CURDATE()) FROM PROPRIETARIO WHERE ID_PROPRIETARIO = P.ID_PROPRIETARIO) AS IDADE"
                + " FROM PROPRIETARIO P";

        var result = connection.prepareCall(querySql).executeQuery();

        return result;
    }

    public static ResultSet queryGetParcelaByIdParcela(Connection connection, Long idParcel) throws SQLException {
        final String querySql = "SELECT P.VL_PARCELA, P.VL_PAGO, P.DT_PARCELA FROM PARCELA_RESIDENCIA P WHERE P.ID_PARCELA_RESIDENCIA = ?";

        var statment = connection.prepareCall(querySql);
        statment.setLong(1, idParcel);
        var result = statment.executeQuery();

        return result;
    }

    public static ResultSet queryGetMoradores(Connection connection) throws SQLException {
        final String querySql = "SELECT P.ID_MORADOR, P.NOME, P.RG, P.CPF,"
                + " (SELECT TIMESTAMPDIFF(YEAR, DT_NASCIMENTO, CURDATE()) FROM MORADOR WHERE ID_MORADOR = P.ID_MORADOR) AS IDADE"
                + " FROM MORADOR P";

        var result = connection.prepareCall(querySql).executeQuery();

        return result;
    }

    public static ResultSet queryGetParcelas(Connection connection) throws SQLException {
        final String querySql = "SELECT P.ID_PARCELA_RESIDENCIA, P.VL_PARCELA, P.VL_PAGO, P.DT_PARCELA"
                + " FROM PARCELA_RESIDENCIA P";

        var result = connection.prepareCall(querySql).executeQuery();

        return result;
    }

    public static ResultSet queryGetResidencias(Connection connection) throws SQLException {
        final String querySql = "SELECT ID_RESIDENCIA, RUA, CEP, NUMERO"
                + " FROM RESIDENCIA";

        var result = connection.prepareCall(querySql).executeQuery();

        return result;
    }

    public static PreparedStatement queryGetVerificaProprietarioResidencia(Connection connection) throws SQLException {
        final String querySql = "SELECT COUNT(ID_RESIDENCIA)"
                + " FROM PROPRIETARIO_RESIDENCIA WHERE ID_RESIDENCIA = ?";

        var result = connection.prepareCall(querySql);

        return result;
    }

    public static ResultSet queryGetResidenciaById(Connection connection, Long idResidencia) throws SQLException {
        final String querySql = "SELECT P.RUA, P.CEP, P.NUMERO"
                + " FROM RESIDENCIA P"
                + " WHERE P.ID_RESIDENCIA = ?";

        var statment = connection.prepareCall(querySql);
        statment.setLong(1, idResidencia);
        var result = statment.executeQuery();

        return result;
    }

    public static ResultSet queryGetProprietarioById(Connection connection, Long idPessoa) throws SQLException {
        final String querySql = "SELECT P.NOME, P.RG, P.CPF,"
                + " P.DT_NASCIMENTO"
                + " FROM PROPRIETARIO P"
                + " WHERE ID_PROPRIETARIO = ?";

        var statment = connection.prepareCall(querySql);
        statment.setLong(1, idPessoa);
        var result = statment.executeQuery();

        return result;
    }

    public static ResultSet queryGetMoradorById(Connection connection, Long idPessoa) throws SQLException {
        final String querySql = "SELECT P.NOME, P.RG, P.CPF, P.DT_NASCIMENTO, R.RUA, R.CEP, R.NUMERO, R.ID_RESIDENCIA"
                + " FROM MORADOR P "
                + " LEFT JOIN MORADOR_RESIDENCIA MR ON MR.ID_MORADOR = P.ID_MORADOR"
                + " LEFT JOIN RESIDENCIA R ON R.ID_RESIDENCIA = MR.ID_RESIDENCIA"
                + " WHERE P.ID_MORADOR = ?";

        var statment = connection.prepareCall(querySql);
        statment.setLong(1, idPessoa);
        var result = statment.executeQuery();

        return result;
    }
}
