package edu.aplimovil.emprendapp.quesos;

import java.io.Serializable;

import edu.aplimovil.emprendapp.productos.Productos;

public class Queso  extends Productos implements Serializable {
    String imagen;
    String descripcion;

    public Queso() {
    }

    public Queso(int id, String nombre, String imagen, String descripcion) {
        super(id, nombre);
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
