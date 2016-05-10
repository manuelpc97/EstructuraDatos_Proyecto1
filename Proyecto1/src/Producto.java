/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manuel
 */
public class Producto {
    String nombre;
    String descripcion;
    int tiempo;
    Pila materiales;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, int tiempo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Pila getMateriales() {
        return materiales;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + "; Tiempo de ensamblaje: " + tiempo + "s";
    }
    
    
}
