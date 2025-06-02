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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ParcelaDAO {

    private Connection dbConnection;

    public ParcelaDAO(Connection connection) {
        this.dbConnection = connection;
    }

    public void insertParcelaResidencia(ParcelaResidencia parcelaResidencia) throws SQLException {
        var stament = SqlInsertSchemas.queryInsertParcelaResidencia(dbConnection);
        stament.setLong(1, parcelaResidencia.getIdResidencia());
        stament.setDouble(2, parcelaResidencia.getVlReceber());
        stament.setDouble(3, parcelaResidencia.getVlRecebido());
        stament.setString(4, parcelaResidencia.getDtVencimento().toString());
        stament.executeUpdate();
    }

    public void updateParcelaResidencia(ParcelaResidencia parcelaResidencia) throws SQLException {
        var stament = SqlUpdateSchemas.queryUpdateParcelaResidencia(dbConnection);
        stament.setDouble(1, parcelaResidencia.getVlReceber());
        stament.setDouble(2, parcelaResidencia.getVlRecebido());
        stament.setString(3, parcelaResidencia.getDtVencimento().toString());
        stament.setLong(4, parcelaResidencia.getIdParcela());
        stament.executeUpdate();
    }

    public ParcelaResidencia getParcelaByIdParcela(Long idParcela) throws SQLException {
        var stament = SqlSelectSchemas.queryGetParcelaByIdParcela(dbConnection, idParcela);
        
        ParcelaResidencia parcelaResidencia = null;
        
        while (stament.next()){
            final double vlParcela = stament.getDouble(1);
            final double vlPago = stament.getDouble(2);
            final String dtParcela = stament.getString(3);
            
            parcelaResidencia = new ParcelaResidencia(vlParcela, vlPago, LocalDate.parse(dtParcela));
        }
        
        return parcelaResidencia;
    }

    public List<ParcelaResidencia> getParcelasByIdResidencia(Long idResidencia) throws SQLException {
        final List<ParcelaResidencia> tempResidenciaList = new ArrayList();

        var result = SqlSelectSchemas.queryGetParcelas(dbConnection);

        while (result.next()) {
            final Long idParcela = result.getLong(1);
            final double vlParcela = result.getDouble(2);
            final double vlPago = result.getDouble(3);
            final String dtVencimento = result.getString(4);
            final ParcelaResidencia tempParcelaResidencia = new ParcelaResidencia(vlParcela, vlPago, LocalDate.parse(dtVencimento), idParcela, vlParcela == vlPago);

            tempResidenciaList.add(tempParcelaResidencia);
        }

        return tempResidenciaList;
    }
    
    public void deleteParcelaByIdParecla(Long idParcela) throws SQLException {
        var stament = SqlDeleteSchemas.queryDeleteParcelaResidencia(dbConnection);
        stament.setLong(1, idParcela);
        stament.executeUpdate();
    }
}
