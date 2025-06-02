/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.controller;

import br.unifae.gerenciacondominio.model.Pessoa;
import br.unifae.gerenciacondominio.model.Residencia;
import br.unifae.gerenciacondominio.model.ResidenciaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateu
 */
public class ResidenciaController {

    private List<Residencia> listaOriginal;
    private Connection connection;
    private ResidenciaDAO residenciaDao;

    public ResidenciaController(Connection connection) {
        this.connection = connection;
    }

    public void fillTable(JTable jTable) throws SQLException {
        residenciaDao = new ResidenciaDAO(connection);
        listaOriginal = residenciaDao.getResidencias();

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.getDataVector().removeAllElements();

        if (listaOriginal.size() > 0) {
            for (Residencia tempResidencia : listaOriginal) {
                model.addRow(new Object[]{tempResidencia.getIdResidencia(), tempResidencia.getRua(), tempResidencia.getCep(), tempResidencia.getNumero()});
            }
            return;
        }

        model.addRow(new Object[]{});
        model.removeRow(0);
    }

    public void searchResidenciaByRua(String rua, JTable jTable) {
        List<Residencia> tempResidencias = listaOriginal
                .stream()
                .filter(res -> res.getRua().contains(rua)).toList();

        if (rua.isEmpty()) {
            tempResidencias = listaOriginal;
        }

        if (tempResidencias.isEmpty()) {
            tempResidencias = listaOriginal;
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a residencia!", "Aviso!", JOptionPane.WARNING_MESSAGE);

        }

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.getDataVector().removeAllElements();

        for (Residencia tempResidencia : tempResidencias) {
            model.addRow(new Object[]{tempResidencia.getIdResidencia(), tempResidencia.getRua(), tempResidencia.getCep(), tempResidencia.getNumero()});
        }
    }

    public void atribuirProprietario(String idProprietario, String idResidencia) throws SQLException {
        Long tempIdResidencia = Long.parseLong(idResidencia);
        Long tempIdProprietario = Long.parseLong(idProprietario);
        residenciaDao = new ResidenciaDAO(connection);
        residenciaDao.atribuirProprietario(tempIdProprietario, tempIdResidencia);
    }

    public void fillInfo(JTextField txtRua, JFormattedTextField txtCep, JTextField txtNumero, Long idResidencia) throws SQLException {
        residenciaDao = new ResidenciaDAO(connection);
        final Residencia tempResidencia = residenciaDao.getResidenciaById(idResidencia);

        txtRua.setText(tempResidencia.getRua());
        txtCep.setText(tempResidencia.getCep());
        txtNumero.setText(tempResidencia.getNumero());
    }

    public void insertResidencia(String rua, String numero, String cep) throws SQLException {
        final Residencia residencia = new Residencia(rua, numero, cep);
        residenciaDao = new ResidenciaDAO(connection);
        residenciaDao.insertResidencia(residencia);
    }

    public void updateResidencia(Long idResidencia, String rua, String numero, String cep) throws SQLException {
        final Residencia residencia = new Residencia(idResidencia, rua, numero, cep);
        residenciaDao = new ResidenciaDAO(connection);
        residenciaDao.updateResidencia(residencia);
    }

    public void deleteResidenciaById(Long idResidencia) throws SQLException {
        residenciaDao = new ResidenciaDAO(connection);
        residenciaDao.deleteResidenciaById(idResidencia);
    }
}
