package edu.aplimovil.emprendapp.categorias;

public class Categoria {
    
    String nombre;
    int id;
    String imgCategoria;

    public Categoria() {
    }

    public Categoria(String nombre, int id, String imgCategoria) {
        this.nombre = nombre;
        this.id = id;
        this.imgCategoria = imgCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getImgCategoria() {
        return imgCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImgCategoria(String imgCategoria) {
        this.imgCategoria = imgCategoria;
    }
}

