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
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySql);
        boolean guardar = false;
        try {
            if (categoria.getId_categoria() == 0) {
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("insert into tb_categoria (nom_categoria,estado_categoria) values ('"
                        + categoria.getNombre() + " ' ,'" + categoria.estado_categoria + " ' );");
                this.conn.ejecutarSQL(miSQL.toString());
            } else if (categoria.getId_categoria() > 0) {
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("UPDATE tb_categoria set id_categoria = ").append(categoria.getId_categoria());
                miSQL.append(", nom_categoria = ' ").append(categoria.getNombre());
                miSQL.append("  ', estado_categoria = ").append(categoria.getEstado_categoria());
                miSQL.append(" WHERE id_categoria = ").append(categoria.getId_categoria()).append(";");
                this.conn.ejecutarSQL(miSQL.toString());
            }
            guardar = true;
        } catch (Exception e) {

        } finally {
            this.conn.cerrarConexion();
        }
        return guardar;
    }

    @Override
    public boolean eliminarCat(int id_cant_borrar) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySql);
        boolean borra = false;
        try {
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("DELETE FROM tb_categoria where id_categoria = ").append(id_cant_borrar);
            this.conn.ejecutarSQL(miSQL.toString());
            borra = true;
        } catch (Exception e) {
        } finally {
            this.conn.cerrarConexion();
        }
        return borra;
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
