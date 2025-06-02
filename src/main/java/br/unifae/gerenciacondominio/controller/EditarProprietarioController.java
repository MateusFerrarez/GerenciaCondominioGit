/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.controller;

import br.unifae.gerenciacondominio.model.factory.FactoryProprietario;
import br.unifae.gerenciacondominio.model.Pessoa;
import br.unifae.gerenciacondominio.model.Residencia;
import br.unifae.gerenciacondominio.model.ResidenciaDAO;
import br.unifae.gerenciacondominio.model.factory.Factory;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author mateu
 */
public class EditarProprietarioController {

    private Connection connection;

    public EditarProprietarioController(Connection connection) {
        this.connection = connection;
    }

    public void fillInfo(JTextField txtNome, JFormattedTextField txtCpf, JFormattedTextField txtRg, JFormattedTextField txtDt, Long idPessoa, Factory factory) throws SQLException {
        final Pessoa tempPessoa = factory.getPessoaById(idPessoa);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataFormatada = tempPessoa.getDtNascimento().format(formatter).replace("/", "");

        txtNome.setText(tempPessoa.getNome().toUpperCase());
        txtCpf.setText(tempPessoa.getCpf());
        txtRg.setText(tempPessoa.getRg());
        txtDt.setText(dataFormatada);
    }

    public void fillInfoMorador(JTextField txtNome, JFormattedTextField txtCpf, JFormattedTextField txtRg, JFormattedTextField txtDt, JTextField txtResidencia, Long idPessoa, Long idResidencia, Factory factory) throws SQLException {
        final Pessoa tempPessoa = factory.getPessoaById(idPessoa);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataFormatada = tempPessoa.getDtNascimento().format(formatter).replace("/", "");

        if (tempPessoa.getResidencia() == null) {
            idResidencia = 0L;
        } else {
            idResidencia = tempPessoa.getResidencia().getIdResidencia();
            txtResidencia.setText(tempPessoa.getResidencia().getCep() + " - " + tempPessoa.getResidencia().getRua() + ", " + tempPessoa.getResidencia().getNumero());
        }

        txtNome.setText(tempPessoa.getNome().toUpperCase());
        txtCpf.setText(tempPessoa.getCpf());
        txtRg.setText(tempPessoa.getRg());
        txtDt.setText(dataFormatada);
    }

    public Long getIdResidenciaByIdPessoa(Long idPessoa, Factory factory) throws SQLException {
        final Pessoa tempPessoa = factory.getPessoaById(idPessoa);

        return tempPessoa.getResidencia().getIdResidencia();
    }

    public void searchResidenciaById(JTextField txtResidencia, Long idResidencia) throws SQLException, RuntimeException {
        ResidenciaDAO residenciaDAO = new ResidenciaDAO(connection);
        final Residencia tempResidencia = residenciaDAO.getResidenciaById(idResidencia);

        if (tempResidencia == null) {
            throw new RuntimeException("Residencia não encontrada!");
        }

        final String formataResidencia = tempResidencia.getCep() + " - " + tempResidencia.getRua() + ", " + tempResidencia.getNumero();
        txtResidencia.setText(formataResidencia);
    }

    public void insertMoradorResidencia(Long idResidencia) throws SQLException {
        ResidenciaDAO residenciaDAO = new ResidenciaDAO(connection);
        residenciaDAO.insertMoradoResidencia(idResidencia);
    }

    public void updateMoradorResidencia(Long idMorador, Long idResidencia) throws SQLException {
        ResidenciaDAO residenciaDAO = new ResidenciaDAO(connection);
        residenciaDAO.updateMoradoResidencia(idMorador, idResidencia);
    }
}
