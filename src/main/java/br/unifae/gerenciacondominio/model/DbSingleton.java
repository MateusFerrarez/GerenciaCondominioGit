/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mateu
 */
public class DbSingleton {

    private static DbSingleton dbSingleton;
    private Connection connection;
    
    private DbSingleton() throws SQLException {
        final String user = "root";
        final String password = "1234";
        final String dbName = "banco";
        final String mysqlUrl = "jdbc:mysql://localhost:3306/" + dbName;
        connection = DriverManager.getConnection(mysqlUrl, user, password);
    }

    public static DbSingleton getInstancia() throws SQLException{
        if (dbSingleton == null) {
            dbSingleton = new DbSingleton();
        }
        
        return dbSingleton;
    }

    public Connection getConnection() {
        return connection;
    }

}
