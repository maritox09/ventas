
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase PedidoDAO
 * Contiene los metodos para acceder a la base de datos y aterrizarlos en la clase Pedido
 */
public class PedidoDAO {
    Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;

    /**
     * Metodo para buscar un Pedido por id
     * @param id el id del Pedido el cual se buscara en la base de datos
     * @return Devuelve un Objeto Pedido si lo encontró, de no encontrarlo un objeto Pedido vacio
     */
        public Pedido buscar(int id){
           Pedido p=new Pedido();
           String sql ="select * from pedidosview where idpedido="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   p.setIdpedido(rs.getInt("idpedido"));
                   p.setIdproducto(rs.getInt("idproducto"));
                   p.setFechapedido(rs.getString("fechapedido"));
                   p.setFechaentrega(rs.getString("fechaentrega"));
                   p.setCantidad(rs.getInt("cantidad"));
                   p.setEstado(rs.getString("nombre"));
                   p.setNumeroOrden(rs.getString("orden"));
                   p.setIdfabrica(rs.getInt("fabrica"));
                   p.setNombreFabrica(rs.getString("nombref"));

               }
           }catch(Exception e){
               
           }
           return p;
       }

    /**
     * Metodo para listar todos los Pedidos
     * @return Objeto Lista <Pedido> con todos los Pedidos que se encontraron en la base de datos
     */
       public List listar(){
           String sql= "select * from pedidosview order by idpedido desc";
           List<Pedido> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Pedido p = new Pedido();
                   p.setIdpedido(rs.getInt("idpedido"));
                   p.setIdproducto(rs.getInt("idproducto"));
                   p.setFechapedido(rs.getString("fechapedido"));
                   p.setFechaentrega(rs.getString("fechaentrega"));
                   p.setCantidad(rs.getInt("cantidad"));
                   p.setEstadoId(rs.getInt("estado"));
                   p.setEstado(rs.getString("nombre"));
                   p.setNumeroOrden(rs.getString("orden"));
                   p.setIdfabrica(rs.getInt("fabrica"));
                   p.setNombreFabrica(rs.getString("nombref"));
                   lista.add(p);
               }
           }catch(Exception e){   
           }
           return lista;
       }

    /**
     * Metodo para agregar un Pedido
     * @param pe el objeto Pedido el cual se agregara a la base de datos
     * @return int respuesta, 1 al agregar exitosamente, 0 de lo contrario
     */
       public int agregar(Pedido pe){
           String sql="INSERT INTO pedidos VALUES (null,?,default,default,?,1,?,?)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, pe.getIdproducto());
               ps.setInt(2, pe.getCantidad());
               ps.setString(3,pe.getNumeroOrden());
               ps.setInt(4,pe.getIdfabrica());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para actualizar un Pedido
     * @param id,estado el id del Pedido que se quiere actualizar y el nuevo estado que se seteara
     * @return int respuesta, 1 al actualizar exitosamente, 0 de lo contrario
     */
    public int actualizarEstado(int id, int estado){
        String sql="UPDATE pedidos SET estado=? where IDPEDIDO=?";

        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(Exception i){
        }
            return respuesta;
        }


    }
