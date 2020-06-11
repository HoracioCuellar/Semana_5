/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MysqlConexionFactory extends ConexionDB {

    public MysqlConexionFactory(String[] criterios) {
        this.parametros = criterios;
        this.open();
    }

    @Override
    public Connection open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + this.parametros[0], this.parametros[1], this.parametros[2]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.conexion;
    }

}
