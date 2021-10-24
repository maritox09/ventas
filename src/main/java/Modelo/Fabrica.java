package Modelo;

/**
 * Clase Fabrica
 * Contiene la entidad Fabrica correspondiente al registro de datos de las fabricas a las cuales se le piden los terminales
 */
public class Fabrica {

    int idf;
    String nombref;
    String dominio;
    String usuario;
    String pass;

    public Fabrica() {
    }

    /**
     * Constructor de la clase
     */
    public Fabrica(int idf, String nombref, String dominio, String usuario, String pass) {
        this.idf = idf;
        this.nombref = nombref;
        this.dominio = dominio;
        this.usuario = usuario;
        this.pass = pass;
    }

    /**
     * Metodos getters y setters
     */
    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getNombref() {
        return nombref;
    }

    public void setNombref(String nombref) {
        this.nombref = nombref;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
