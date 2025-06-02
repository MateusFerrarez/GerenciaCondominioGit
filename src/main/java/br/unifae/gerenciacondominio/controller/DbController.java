/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.controller;

import br.unifae.gerenciacondominio.model.DbDAO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mateu
 */
public class DbController {
    private Connection dbConnection;

    public DbController(Connection DbConnection) {
        this.dbConnection = DbConnection;
    }
    
    public void initTables() throws SQLException {
        final DbDAO dbDAO = new DbDAO(dbConnection);
        dbDAO.initDefaultTables();
    }
}
