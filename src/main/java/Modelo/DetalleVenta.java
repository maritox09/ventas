package Modelo;

/**
 * Clase DetalleVenta
 * Contiene la entidad DetalleVenta correspondiente al cada registro de una venta realizadad
 */
public class DetalleVenta {

    int id;
    int idventa;
    int idproducto;
    int cantidad;
    double monto;
    int estado;
    String estadoNombre;
    int encargo;

    public DetalleVenta() {
    }

    /**
     * Constructor de la clase
     */
    public DetalleVenta(int id, int idventa, int idproducto, int cantidad, double monto, int estado, String estadoNombre, int encargo) {
        this.id = id;
        this.idventa = idventa;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.monto = monto;
        this.estado = estado;
        this.estadoNombre = estadoNombre;
        this.encargo = encargo;
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

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public int getEncargo() {
        return encargo;
    }

    public void setEncargo(int encargo) {
        this.encargo = encargo;
    }
}
