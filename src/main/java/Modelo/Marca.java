
package Modelo;

/**
 * Clase Marca
 * Contiene la entidad Marca correspondiente al registro de datos de cada marca registrada
 */
public class Marca {
    
    int id;
    String nombrem;
    String logo;
    String descripcion;

    public Marca() {
    }

    /**
     * Constructor de la clase
     */
    public Marca(int id, String nombrem, String logo, String descripcion) {
        this.id = id;
        this.nombrem = nombrem;
        this.logo = logo;
        this.descripcion = descripcion;
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

    public String getNombrem() {
        return nombrem;
    }

    public void setNombrem(String nombrem) {
        this.nombrem = nombrem;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
