package Modelo;

/**
 * Clase Pedido
 * Contiene la entidad Pedido correspondiente al registro de datos de cada pedido a realizar a fabrica
 */
public class Pedido {
    int idpedido;
    int idproducto;
    String fechapedido;
    String fechaentrega;
    int cantidad;
    String estado;
    String numeroOrden;
    int estadoId;
    int idfabrica;
    String nombreFabrica;

    public Pedido() {
    }

    /**
     * Constructor de la clase
     */
    public Pedido(int idpedido, int idproducto, String fechapedido, String fechaentrega, int cantidad, String estado,String numeroOrden, int estadoId, int idfabrica,String nombreFabrica) {
        this.idpedido = idpedido;
        this.idproducto = idproducto;
        this.fechapedido = fechapedido;
        this.fechaentrega = fechaentrega;
        this.cantidad = cantidad;
        this.estado = estado;
        this.numeroOrden=numeroOrden;
        this.estadoId=estadoId;
        this.idfabrica=idfabrica;
        this.nombreFabrica=nombreFabrica;

    }

    /**
     * Metodos getters y setters
     */
    public String getNombreFabrica() {
        return nombreFabrica;
    }

    public void setNombreFabrica(String nombreFabrica) {
        this.nombreFabrica = nombreFabrica;
    }

    public int getIdfabrica() {
        return idfabrica;
    }

    public void setIdfabrica(int idfabrica) {
        this.idfabrica = idfabrica;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(String fechapedido) {
        this.fechapedido = fechapedido;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idpedido=" + idpedido +
                ", idproducto=" + idproducto +
                ", fechapedido='" + fechapedido + '\'' +
                ", fechaentrega='" + fechaentrega + '\'' +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                ", numeroOrden='" + numeroOrden + '\'' +
                ", estadoId=" + estadoId +
                ", idfabrica=" + idfabrica +
                ", nombreFabrica='" + nombreFabrica + '\'' +
                '}';
    }
}
