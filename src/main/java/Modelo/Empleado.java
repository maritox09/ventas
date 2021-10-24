/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase Empleado
 * Contiene la entidad Empleado correspondiente al registro de datos de cada empleado,
 */
public class Empleado {
    int id;
    String nombre;
    String pass;
    String correo;
    int tipo;
    String rango;


    
     public Empleado() {
    }

    /**
     * Constructor de la clase
     */
    public Empleado(int id, String nombre, String pass, String correo, int tipo, String rango) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.correo = correo;
        this.tipo = tipo;
        this.rango = rango;
    }

    /**
     * Metodos getters y setters
     */
    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
     
     
}
