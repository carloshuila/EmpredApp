package edu.aplimovil.emprendapp.usuario;

import java.io.Serializable;

public class Usuario  implements Serializable {

    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String email;
    private String pass;

    public Usuario() {
    }

    public Usuario(int id, String nombre,String apellido, String direccion,String ciudad, String email,String pass) {
        this.id = id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.ciudad=ciudad;
        this.email=email;
        this.pass=pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
