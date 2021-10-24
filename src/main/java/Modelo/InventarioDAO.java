
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase InventarioDAO
 * Contiene los metodos para acceder a la base de datos y aterrizarlos en la clase Inventario
 */
public class InventarioDAO {
    Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;

    /**
     * Metodo para buscar un Inventario por id
     * @param id el id del Inventario el cual se buscara en la base de datos
     * @return Devuelve un Objeto Inventario si lo encontró, de no encontrarlo un objeto Inventario vacio
     */
        public Inventario buscar(int id){
           Inventario i=new Inventario();
           String sql ="select * from inventarios where id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   i.setId(rs.getInt("id"));
                   i.setIdProducto(rs.getInt("idproducto"));
                   i.setCantidad(rs.getInt("cantidad"));
               }
           }catch(Exception e){
               
           }
           return i;
       }

    /**
     * Metodo para buscar un inventario por id del producto
     * @param id el id del producto el cual se buscara al inventario que le corresponde
     * @return Devuelve un Objeto Inventario si lo encontró correspondiende al id del producto
     */
    public Inventario buscarXpro(int id){
        Inventario i=new Inventario();
        String sql ="select * from inventarios where idproducto="+id;
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                i.setId(rs.getInt("id"));
                i.setIdProducto(rs.getInt("idproducto"));
                i.setCantidad(rs.getInt("cantidad"));
            }
        }catch(Exception e){

        }
        return i;
    }

    /**
     * Metodo para listar todos los Inventarios
     * @return Objeto Lista <Inventario> con todos los Inventario que se encontraron en la base de datos
     */
       public List listar(){
           String sql= "select nombre, inventarios.id, cantidad, idproducto from inventarios inner join producto on inventarios.idproducto=producto.id";
           List<Inventario> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Inventario i = new Inventario();
                   i.setId(rs.getInt("id"));
                   i.setIdProducto(rs.getInt("idproducto"));
                   i.setCantidad(rs.getInt("cantidad"));
                   i.setNombreProducto(rs.getString("nombre"));
                   lista.add(i);
               }
           }catch(Exception e){   
           }
           return lista;
       }

    /**
     * Metodo para actualizar un Inventario
     * @param in el objeto Inventario el cual tendra el id y los datos para actualizar el objeto en la base de datos
     * @return int respuesta, 1 al actualizar exitosamente, 0 de lo contrario
     */
       public int actualizar(Inventario in){
            String sql="UPDATE inventarios SET cantidad=? where ID=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, in.getCantidad());
               ps.setInt(2, in.getId());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
          
}
