
package Modelo;

/**
 * Clase Cliente
 * Contiene la entidad cliente con todos sus métodos
 * @author josue
 */
public class Cliente {
    int id;
    String nombre;
    int nit;
    String correo;
    int celular;
    String patente;
    int suscripcion;
    String rango;
    float descuento;
    String fechaC;

    public Cliente() {
    }



    /**
     * Constructor de la clase Cliente
     */
    public Cliente(int id, String nombre, int nit, String correo, int celular, String patente, int suscripcion, String rango, float descuento, String fechaC) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.celular = celular;
        this.patente = patente;
        this.suscripcion = suscripcion;
        this.rango = rango;
        this.descuento=descuento;
    }

    /**
     * Metodos getters y setters
     */
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

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(int suscripcion) {
        this.suscripcion = suscripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    /**
     * Método toString.()
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", correo='" + correo + '\'' +
                ", celular=" + celular +
                ", patente='" + patente + '\'' +
                ", suscripcion=" + suscripcion +
                ", rango='" + rango + '\'' +
                ", descuento=" + descuento +
                ", fechaC='" + fechaC + '\'' +
                '}';
    }
}
