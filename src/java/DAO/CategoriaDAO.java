package DAO;

import Model.Categoria;
import java.util.List;

public interface CategoriaDAO {
public List<Categoria> Listar();
public List<Categoria> Listar2();
public Categoria publicCat(int id_cant_edit);
public Categoria editCat(int cant_edit);
public boolean guardarCat(Categoria categoria);
public boolean eliminarCat(int id_cant_borrar);
}
