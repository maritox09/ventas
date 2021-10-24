
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class VentaDAO {    
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar(){
        String sql= "select * from ventas order by fecha desc";
        List<Venta> lista=new ArrayList<>();
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Venta mr = new Venta();
                mr.setId(rs.getInt("idventa"));
                mr.setIdCliente(rs.getInt("idcliente"));
                mr.setIdEmpleado(rs.getInt("idempleado"));
                mr.setFecha(rs.getString("fecha"));
                mr.setMonto(rs.getDouble("monto"));
                mr.setEstado(rs.getInt("estado"));
                lista.add(mr);
            }
        }catch(Exception e){
        }
        return lista;

        }

    public int Idventas(){
        int idVentas=0;
        String sql ="select max(idventa) as idventa from ventas";
        try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   idVentas=rs.getInt("idventa");
               }
           }catch(Exception e){
               
           }
        return idVentas;
    }
    public int guardarVenta(Venta ve){
        String sql ="INSERT INTO ventas VALUES (null,?,?,default,?,?)";
        try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, ve.getIdCliente());
               ps.setInt(2, ve.getIdEmpleado());
               ps.setDouble(3, ve.getMonto());
               ps.setInt(4, ve.getEstado());
               ps.executeUpdate();

           }catch(Exception e){
               
           }
        return r;
    }
    public int detalleVenta(Venta ve){
        String sql ="INSERT INTO detalleventa VALUES (null,?,?,?,?,?,?)";
        try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, ve.getId());
               ps.setInt(2, ve.getIdProducto());
               ps.setInt(3, ve.getCantidad());
               ps.setDouble(4, ve.getPrecio());
               ps.setInt(5,ve.getEstado());
               ps.setInt(6,ve.getEncargo());
               ps.executeUpdate();

           }catch(Exception e){
               
           }
        return r;
    }
}
