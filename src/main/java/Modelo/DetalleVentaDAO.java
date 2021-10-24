
package Modelo;

import Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DetalleVentaDAO
 * Contiene los metodos para acceder a la base de datos y aterrizarlos en la clase DetalleVenta
 */
public class DetalleVentaDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    /**
     * Metodo para listar todos los DetalleVenta
     * @return Objeto Lista <DetalleVenta> con todos los DetalleVenta que se encontraron en la base de datos
     */
    public List listar(int id){
        String sql= "select * from detalleventa inner join estadodetalle on   detalleventa.estadodetalle= estadodetalle.ided where idventa="+id;
        List<DetalleVenta> lista=new ArrayList<>();
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                DetalleVenta mr = new DetalleVenta();
                mr.setId(rs.getInt("iddetalle"));
                mr.setIdventa(rs.getInt("idventa"));
                mr.setIdproducto(rs.getInt("idproducto"));
                mr.setCantidad(rs.getInt("cantidad"));
                mr.setMonto(rs.getDouble("precioventa"));
                mr.setEstado(rs.getInt("estadodetalle"));
                mr.setEstadoNombre(rs.getString("nombreestado"));
                mr.setEncargo(rs.getInt("cantidadencargo"));
                lista.add(mr);
            }
        }catch(Exception e){
        }
        return lista;

        }

    /**
     * Metodo para actualizar un el campo estado de DetalleVenta
     * @param id,estado se envian el id del DetalleVenta a actualizar y el id del estado nuevo para actualizar el objeto en la base de datos
     * @return int respuesta, 1 al actualizar exitosamente, 0 de lo contrario
     */
    public int actualizarEstado(int id, int estado){
        String sql="UPDATE detalleventa SET estadodetalle=? where iddetalle=?";

        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(Exception i){
        }
        return r;
    }


}
