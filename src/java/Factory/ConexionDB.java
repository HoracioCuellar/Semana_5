package Factory;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ConexionDB {

    protected String[] parametros;
    protected Connection conexion;

    abstract Connection open();

    public ResultSet consultaSQL(String consulta) {
        Statement stm;
        ResultSet rs = null;
        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(consulta);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public boolean ejecutarSQL(String consulta) {
        boolean guardar = true;
        Statement stm;
        try {
            stm = conexion.createStatement();
            stm.executeUpdate(consulta);
        } catch (SQLException ex) {
            guardar = false;
            ex.printStackTrace();
        }
        return guardar;
    }

    public boolean cerrarConexion() {
        boolean cerrar = true;
        try {
            conexion.close();
        } catch (Exception ex) {
            cerrar = false;
            ex.printStackTrace();

        }
        return cerrar;
    }

}
