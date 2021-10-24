
package Modelo;

/**
 * Clase Producto
 * Contiene la entidad Producto correspondiente al registro de datos de cada terminal para vender
 */
public class Producto {
    int id;
    String Nombre;
    int precioL;
    int memoria;
    int almacenamiento;
    String procesador;
    int cores;
    String descripcion;
    String color;
    Double precioV;
    String imagen1;
    String imagen2;
    String imagen3;
    int Cantidad;
    int idMarca;
    String marca;
    int idFabrica;
    String nombreFabrica;
    
        public Producto() {
    }

    /**
     * Constructor de la clase
     */
    public Producto(int id, String nombre, int precioL, int memoria, int almacenamiento, String procesador, int cores, String descripcion, String color, Double precioV, String imagen1, String imagen2, String imagen3, int cantidad, int idMarca, String marca, int idFabrica, String nombreFabrica) {
        this.id = id;
        Nombre = nombre;
        this.precioL = precioL;
        this.memoria = memoria;
        this.almacenamiento = almacenamiento;
        this.procesador = procesador;
        this.cores = cores;
        this.descripcion = descripcion;
        this.color = color;
        this.precioV = precioV;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        Cantidad = cantidad;
        this.idMarca = idMarca;
        this.marca = marca;
        this.idFabrica = idFabrica;
        this.nombreFabrica = nombreFabrica;
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
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPrecioL() {
        return precioL;
    }

    public void setPrecioL(int precioL) {
        this.precioL = precioL;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(Double precioV) {
        this.precioV = precioV;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public String getNombreFabrica() {
        return nombreFabrica;
    }

    public void setNombreFabrica(String nombreFabrica) {
        this.nombreFabrica = nombreFabrica;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", precioL=" + precioL +
                ", memoria=" + memoria +
                ", almacenamiento=" + almacenamiento +
                ", procesador='" + procesador + '\'' +
                ", cores=" + cores +
                ", descripcion='" + descripcion + '\'' +
                ", color='" + color + '\'' +
                ", precioV=" + precioV +
                ", imagen1='" + imagen1 + '\'' +
                ", imagen2='" + imagen2 + '\'' +
                ", imagen3='" + imagen3 + '\'' +
                ", Cantidad=" + Cantidad +
                ", idMarca=" + idMarca +
                ", marca='" + marca + '\'' +
                ", idFabrica=" + idFabrica +
                ", nombreFabrica='" + nombreFabrica + '\'' +
                '}';
    }
}
