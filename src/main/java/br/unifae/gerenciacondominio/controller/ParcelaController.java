/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.controller;

import br.unifae.gerenciacondominio.model.ParcelaDAO;
import br.unifae.gerenciacondominio.model.ParcelaResidencia;
import br.unifae.gerenciacondominio.model.Pessoa;
import br.unifae.gerenciacondominio.model.factory.Factory;
import br.unifae.gerenciacondominio.model.factory.FactoryProprietario;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ParcelaController {

    private Connection dbConnection;

    public ParcelaController(Connection DbConnection) {
        this.dbConnection = DbConnection;
    }

    public void fillTable(JTable jTable, Long idResidencia) throws SQLException {
        final ParcelaDAO parcelaDAO = new ParcelaDAO(dbConnection);

        final List<ParcelaResidencia> tempParcelaResidencias = parcelaDAO.getParcelasByIdResidencia(idResidencia);

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.getDataVector().removeAllElements();

        if (tempParcelaResidencias.size() > 0) {
            for (ParcelaResidencia tempParcelaResidencia : tempParcelaResidencias) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                String dataFormatada = tempParcelaResidencia.getDtVencimento().format(formatter);

                model.addRow(new Object[]{tempParcelaResidencia.getIdParcela(), dataFormatada, tempParcelaResidencia.getVlReceber(), tempParcelaResidencia.getVlRecebido(), tempParcelaResidencia.isEmDia()});
            }
            return;
        }

        model.addRow(new Object[]{});
        model.removeRow(0);
    }

    public void insertParcelaResidencia(Long idResidencia, double vlReceber, double vlRecebido, LocalDate dtVencimento) throws SQLException {
        final ParcelaDAO parcelaDAO = new ParcelaDAO(dbConnection);
        final ParcelaResidencia tempParcel = new ParcelaResidencia(vlReceber, vlRecebido, dtVencimento, idResidencia);
        parcelaDAO.insertParcelaResidencia(tempParcel);
    }

    public void updateParcelaResidencia(Long idParcela, double vlReceber, double vlRecebido, LocalDate dtVencimento) throws SQLException {
        final ParcelaDAO parcelaDao = new ParcelaDAO(dbConnection);
        final ParcelaResidencia tempParcel = new ParcelaResidencia(vlReceber, vlRecebido, dtVencimento, idParcela, false);
        parcelaDao.updateParcelaResidencia(tempParcel);
    }

    public void getParcelaResidencia(Long idParcela, JTextField txtParcel, JTextField txtPago, JFormattedTextField dtParcela) throws SQLException {
        final ParcelaDAO parcelaDao = new ParcelaDAO(dbConnection);
        final ParcelaResidencia tempParcel = parcelaDao.getParcelaByIdParcela(idParcela);
        txtParcel.setText(String.valueOf(tempParcel.getVlReceber()));
        txtPago.setText(String.valueOf(tempParcel.getVlRecebido()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataFormatada = tempParcel.getDtVencimento().format(formatter).replace("/", "");

        dtParcela.setText(dataFormatada);
    }

    public void deleteParcelaByIdParcela(Long idParcela) throws SQLException {
        final ParcelaDAO parcelaDao = new ParcelaDAO(dbConnection);
        parcelaDao.deleteParcelaByIdParecla(idParcela);
    }
}
