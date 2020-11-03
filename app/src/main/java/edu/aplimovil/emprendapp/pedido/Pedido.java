package edu.aplimovil.emprendapp.pedido;

import java.io.Serializable;

public class Pedido  implements Serializable {
    int id;
    String nombre;
    int precioTotal;
    int cantidad;
    String imagen;

    public Pedido() {
    }

    public Pedido(int id, String nombre, int precioTotal, int cantidad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
