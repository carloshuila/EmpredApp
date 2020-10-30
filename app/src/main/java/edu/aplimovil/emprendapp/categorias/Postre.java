package edu.aplimovil.emprendapp.categorias;

public class Postre {
    private String id;
    private String nombre;
    private String categoria;
    private String sabor;
    private String descripcion;
    private String precio;
    private int imagen;

    public Postre() {
    }

    public Postre(String id, String nombre, String categoria, String sabor, String descripcion, String precio, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.sabor = sabor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSabor() {
        return sabor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}
