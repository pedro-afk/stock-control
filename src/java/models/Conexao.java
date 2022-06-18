/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Pedro
 */
public class Conexao {
    private final String database = "sotck";
    private final String host = "jdbc:mysql://localhost/";
    private final String pass = "";
    private final String user = "root";
    
    public Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(this.host+this.database, this.user, this.pass);
        } catch (Exception e) {
            System.out.println("Não foi possível conectar no banco de dados!" + e);
        }
        return conexao;
    }
}
