package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;

public class Prueba {

    public static void main(String[] args) {
        Prueba evaluar = new Prueba();
      //evaluar.listarCategorias();
      // evaluar.editarCategorias();
      // evaluar.guardarCategoria();
      evaluar.listarCategorias();
     // evaluar.eliminar();
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
    public void guardarCategoria(){
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria guardar_cat=new Categoria();
        guardar_cat.setNombre("Bebidas Naturales");
        guardar_cat.setId_categoria(5);
        guardar_cat.setEstado_categoria(1);
        categoria.guardarCat(guardar_cat);
    }
    public void eliminar(){
    CategoriaDAO categoria=new CategoriaDAOImplementar();
    categoria.eliminarCat(2);
    }
}
