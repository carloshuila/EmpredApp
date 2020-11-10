package edu.aplimovil.emprendapp.usuario;

import java.io.Serializable;

public class Usuario  implements Serializable {

    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String email;
    private String pass;
    private  String  foto;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String direccion, String ciudad, String email, String pass, String foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.email = email;
        this.pass = pass;
        this.foto = foto;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getFoto() {
        return foto;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
