package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;

public class Prueba {

    public static void main(String[] args) {
        Prueba evaluar = new Prueba();
//        evaluar.listarCategorias();
        evaluar.editarCategorias();
    }

    public void listarCategorias() {
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        List<Categoria> lista = categoria.Listar();
        System.out.println("Lista de categorias");
        for (Categoria categoriaListar : lista) {
            System.out.println("ID: " + categoriaListar.getId_categoria()
                    + " NOMBRE " + categoriaListar.getNombre()
                    + " ESTADO: " + categoriaListar.getEstado_categoria());
        }
    }

    public void editarCategorias() {
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria cat = categoria.editCat(1);
        System.out.println("CATEGORIA A MODIFICAR");
        System.out.println("ID: " + cat.getId_categoria()
                + " NOMBRE " + cat.getNombre()
                + " ESTADO: " + cat.getEstado_categoria());
    }
}
