package edu.aplimovil.emprendapp.productos;

import java.io.Serializable;
import java.security.SecureRandom;

public class Productos implements Serializable {
    int id;
    String nombre;

    public Productos() {
    }

    public Productos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
