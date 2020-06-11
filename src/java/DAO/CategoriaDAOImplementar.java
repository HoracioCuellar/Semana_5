package DAO;

import Model.Categoria;
import java.util.List;
import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import java.util.ArrayList;
import java.sql.*;

public class CategoriaDAOImplementar implements CategoriaDAO {

    ConexionDB conn;

    public CategoriaDAOImplementar() {

    }

    @Override
    public List<Categoria> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySql);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("select * from tb_categoria");
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while (resultadoSQL.next()) {
                Categoria categoria = new Categoria(); //este tiene que estar dentro del try
                categoria.setId_categoria(Integer.parseInt(resultadoSQL.getString("id_categoria")));
                categoria.setNombre(resultadoSQL.getString("nom_categoria"));
                categoria.setEstado_categoria(Integer.parseInt(resultadoSQL.getString("estado_categoria")));
                //Guardando objetos de la Clase Categoria
                lista.add(categoria);
            }

        } catch (Exception ex) {

        } finally {
            this.conn.cerrarConexion();
        }
        return lista;

    }

    @Override
    public List<Categoria> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria publicCat(int id_cant_edit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarCat(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarCat(int id_cant_borrar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria editCat(int id_cant) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySql);
        Categoria categoria = new Categoria();
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("select * from tb_categoria where id_categoria = ").append(id_cant);
        try {
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while (resultadoSQL.next()) {
                categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
                categoria.setNombre(resultadoSQL.getString("nom_categoria"));
                categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
            }
        } catch (Exception ex) {

        } finally {
            this.conn.cerrarConexion();
        }
        return categoria;
    }
}
