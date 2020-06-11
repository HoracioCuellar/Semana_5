package Model;

public class Producto {

    private int id_producto;
    private String nombre_producto;
    private int categoria_id;
    private float stock;
    private float precio;
    private String unidadMedida;
    private int estado;
    private Categoria categoria;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto() {
        this.id_producto=0;
        this.categoria=new Categoria();
    }

    public Producto(int id, String nombre, int categoria, float stock, float precio, String unidad, int estado, Categoria c) {
        this.categoria = c;
        this.categoria_id = categoria;
        this.estado = estado;
        this.id_producto = id;
        this.nombre_producto = nombre;
        this.precio = precio;
        this.stock = stock;
        this.unidadMedida = unidad;
    }
}
