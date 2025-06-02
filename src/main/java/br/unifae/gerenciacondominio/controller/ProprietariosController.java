/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.controller;

import br.unifae.gerenciacondominio.model.factory.Factory;
import br.unifae.gerenciacondominio.model.Pessoa;
import br.unifae.gerenciacondominio.model.factory.FactoryMorador;
import br.unifae.gerenciacondominio.model.factory.FactoryProprietario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateu
 */
public class ProprietariosController {

    private Connection dbConnection;

    public ProprietariosController(Connection DbConnection) {
        this.dbConnection = DbConnection;
    }

    public void fillTable(JTable jTable) throws SQLException {
        final Factory factory = new FactoryProprietario(dbConnection);

        final List<Pessoa> tempProprietarios = factory.getPessoas();

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.getDataVector().removeAllElements();

        if (tempProprietarios.size() > 0) {
            for (Pessoa tempPessoa : tempProprietarios) {
                model.addRow(new Object[]{tempPessoa.getIdPessoa(), tempPessoa.getNome(), tempPessoa.getCpf(), tempPessoa.getRg(), tempPessoa.getIdade()});
            }
            
            return;
        }

        model.addRow(new Object[]{});
        model.removeRow(0);
    }

    public void deletarProprietario(Long idPessoa) throws SQLException {
        final Factory factory = new FactoryProprietario(dbConnection);

        factory.deletePessoaById(idPessoa);
    }
}
