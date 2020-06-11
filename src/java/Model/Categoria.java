package Model;

public class Categoria {

    public int id_categoria;
    public String nombre;
    public int estado_categoria;

    public Categoria() {
        this.estado_categoria=1;
        this.id_categoria=0;
        this.nombre="";
    }

    public Categoria(int id, String nombre, int estado) {
        this.estado_categoria = estado;
        this.id_categoria = id;
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado_categoria() {
        return estado_categoria;
    }

    public void setEstado_categoria(int estado_categoria) {
        this.estado_categoria = estado_categoria;
    }
    

}
