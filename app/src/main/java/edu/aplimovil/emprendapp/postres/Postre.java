package edu.aplimovil.emprendapp.postres;

import java.io.Serializable;

public class Postre implements Serializable {
    private int id;
    private String nombre;
    private String categoria;
    private String sabor;
    private String descripcion;
    private int precio;
    private String imagen;

    public Postre() {
    }

    public Postre(int id, String nombre, String categoria, String sabor, String descripcion, int precio, String imagen ) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.sabor = sabor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public void setId(int id) {
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

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setImagen(String  imagen) {
        this.imagen = imagen;
    }

    public int getId() {
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

    public int getPrecio() {
        return precio;
    }

    public String  getImagen() {
        return imagen;
    }
}
