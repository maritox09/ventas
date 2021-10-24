/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase Venta
 * Contiene la entidad Venta correspondiente al registro de datos de cada venta realizada por el sistema de ventas
 */
public class Venta {
    int id;
    int item;
    int idCliente;
    int idEmpleado;
    int idProducto;
    String descripcion;
    String fecha;
    double precio;
    int cantidad;
    double subtotal;
    double monto;
    int estado;
    int encargo;

    public Venta() {
    };

    /**
     * Constructor de la clase
     */
    public Venta(int id, int item, int idCliente, int idEmpleado, int idProducto, String descripción, String fecha, double precio, int cantidad, double subtotal, double monto, int estado, int encargo) {
        this.id = id;
        this.item = item;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
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

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripción) {
        this.descripcion = descripción;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
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

    public int getEncargo() {
        return encargo;
    }

    public void setEncargo(int encargo) {
        this.encargo = encargo;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", item=" + item +
                ", idCliente=" + idCliente +
                ", idEmpleado=" + idEmpleado +
                ", idProducto=" + idProducto +
                ", descripción='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", monto=" + monto +
                ", estado=" + estado +
                ", encargo=" + encargo +
                '}';
    }
}
