/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mateu
 */
public class DbDAO {

    private Connection dbConnection;

    public DbDAO(Connection connection) {
        this.dbConnection = connection;
    }

    public void initDefaultTables() throws SQLException {
        final String queryProprietario = "CREATE TABLE IF NOT EXISTS PROPRIETARIO ("
                + " ID_PROPRIETARIO BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + " NOME TEXT NOT NULL,"
                + " DT_NASCIMENTO DATE,"
                + " CPF VARCHAR(11) NOT NULL,"
                + " RG VARCHAR(9) NOT NULL"
                + " );";

        final String queryResidencia = "CREATE TABLE IF NOT EXISTS RESIDENCIA ("
                + " ID_RESIDENCIA BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + " RUA VARCHAR(60) NOT NULL,"
                + " NUMERO VARCHAR(6) NOT NULL,"
                + " CEP VARCHAR(8) NOT NULL"
                + " );";

        final String queryMorador = "CREATE TABLE IF NOT EXISTS MORADOR ("
                + " ID_MORADOR BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + " NOME TEXT NOT NULL,"
                + " DT_NASCIMENTO DATE,"
                + " CPF VARCHAR(11) NOT NULL,"
                + " RG VARCHAR(9) NOT NULL"
                + " );";

        final String queryProprietarioResidencia = "CREATE TABLE IF NOT EXISTS PROPRIETARIO_RESIDENCIA ("
                + " ID_PROPRIETARIO_RESIDENCIA BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + " ID_PROPRIETARIO BIGINT NOT NULL,"
                + " ID_RESIDENCIA BIGINT NOT NULL,"
                + " FOREIGN KEY (ID_PROPRIETARIO) REFERENCES PROPRIETARIO (ID_PROPRIETARIO) ON DELETE CASCADE,"
                + " FOREIGN KEY (ID_RESIDENCIA) REFERENCES RESIDENCIA (ID_RESIDENCIA) ON DELETE CASCADE"
                + ");";

        final String queryMoradorResidencia = "CREATE TABLE IF NOT EXISTS MORADOR_RESIDENCIA ("
                + " ID_MORADOR_RESIDENCIA BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + " ID_MORADOR BIGINT NOT NULL,"
                + " ID_RESIDENCIA BIGINT NOT NULL,"
                + " FOREIGN KEY (ID_MORADOR) REFERENCES MORADOR (ID_MORADOR) ON DELETE CASCADE,"
                + " FOREIGN KEY (ID_RESIDENCIA) REFERENCES RESIDENCIA (ID_RESIDENCIA) ON DELETE CASCADE"
                + " );";

        final String queryParcelaResidencia = "CREATE TABLE IF NOT EXISTS PARCELA_RESIDENCIA ("
                + " ID_PARCELA_RESIDENCIA BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + " ID_RESIDENCIA BIGINT NOT NULL,"
                + " VL_PARCELA DOUBLE NOT NULL,"
                + " VL_PAGO DOUBLE DEFAULT 0,"
                + " DT_PARCELA DATE NOT NULL,"
                + " FOREIGN KEY (ID_RESIDENCIA) REFERENCES RESIDENCIA (ID_RESIDENCIA) ON DELETE CASCADE"
                + " );";

        dbConnection.prepareStatement(queryMorador).execute();
        dbConnection.prepareStatement(queryProprietario).execute();
        dbConnection.prepareStatement(queryResidencia).execute();
        dbConnection.prepareStatement(queryMoradorResidencia).execute();
        dbConnection.prepareStatement(queryProprietarioResidencia).execute();
        dbConnection.prepareStatement(queryParcelaResidencia).execute();
    }

}
