/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ProductoDAO
 * Contiene los metodos para acceder a la base de datos y aterrizarlos en la clase Producto
 */
public class ProductoDAO {
     Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       String res;
       int respuesta;

    public int Idproductos(){
        int idVentas=0;
        String sql ="select max(id) as idproducto from producto";
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                idVentas=rs.getInt("idproducto");
            }
        }catch(Exception e){

        }
        return idVentas;
    }

    /**
     * Metodo para listar todos los Producto
     * @return Objeto Lista <Producto> con todos los Producto que se encontraron en la base de datos
     */
       public List listar(){
           String sql= "select * from producto inner join marcas on producto.idmarca=marcas.id inner join fabricas on fabricas.idf=producto.idfabrica";
           List<Producto> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Producto pro = new Producto();
                   pro.setId(rs.getInt("id"));
                   pro.setNombre(rs.getString("nombre"));
                   pro.setPrecioL(rs.getInt("precio_lista"));
                   pro.setMemoria(rs.getInt("memoria"));
                   pro.setAlmacenamiento(rs.getInt("almacenamiento"));
                   pro.setProcesador(rs.getString("procesador"));
                   pro.setCores(rs.getInt("cores"));
                   pro.setDescripcion(rs.getString("descripcion"));
                   pro.setColor(rs.getString("color"));
                   pro.setPrecioV(rs.getDouble("precio_venta"));
                   pro.setImagen1(rs.getString("imagen1"));
                   pro.setImagen2(rs.getString("imagen2"));
                   pro.setImagen3(rs.getString("imagen3"));
                   pro.setIdMarca(rs.getInt("idmarca"));
                   pro.setMarca(rs.getString("nombrem"));
                   pro.setIdFabrica(rs.getInt("idfabrica"));
                   pro.setNombreFabrica(rs.getString("nombref"));
                   lista.add(pro);
               }
           }catch(Exception e){   
           }
           return lista;
       }

       public int agregarI(int id){
           String sql ="INSERT INTO inventarios VALUES (null,?,default)";
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1,id );
               ps.executeUpdate();
               
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para agregar un Producto
     * @param pro el objeto Producto el cual se agregara a la base de datos
     * @return int respuesta, 1 al agregar exitosamente, 0 de lo contrario
     */
       public int agregar(Producto pro){
           int x = pro.getPrecioL();
           String sql="INSERT INTO producto VALUES (?,?,?,?,?,?,?,?,?,precioT("+x+"),?,?,?,?,?)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, pro.getId());
               ps.setString(2, pro.getNombre());
               ps.setInt(3, pro.getPrecioL());
               ps.setInt(4, pro.getMemoria());
               ps.setInt(5, pro.getAlmacenamiento());
               ps.setString(6, pro.getProcesador());
               ps.setInt(7, pro.getCores());
               ps.setString(8, pro.getDescripcion());
               ps.setString(9, pro.getColor());
               ps.setString(10, pro.getImagen1());
               ps.setString(11, pro.getImagen2());
               ps.setString(12, pro.getImagen3());
               ps.setInt(13, pro.getIdMarca());
               ps.setInt(14,pro.getIdFabrica());
               ps.executeUpdate();
               
               
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para buscar un Producto por id
     * @param id el id del Producto el cual se buscara en la base de datos
     * @return Devuelve un Objeto Producto si lo encontró, de no encontrarlo un objeto Producto vacio
     */
       public Producto listarId(int id){
           Producto pro = new Producto();
           String sql ="select producto.id, producto.nombre, producto.precio_lista, producto.memoria, producto.almacenamiento, producto.procesador, producto.cores, producto.descripcion, producto.color, producto.precio_venta,producto.imagen1, producto.imagen2, producto.imagen3, idmarca, idfabrica, nombrem, nombref, cantidad from producto inner join marcas on producto.idmarca=marcas.id inner join fabricas on fabricas.idf=producto.idfabrica inner join inventarios on producto.id=inventarios.idproducto where producto.id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   pro.setId(rs.getInt(1));
                   pro.setNombre(rs.getString(2));
                   pro.setPrecioL(rs.getInt(3));
                   pro.setMemoria(rs.getInt(4));
                   pro.setAlmacenamiento(rs.getInt(5));
                   pro.setProcesador(rs.getString(6));
                   pro.setCores(rs.getInt(7));
                   pro.setDescripcion(rs.getString(8));
                   pro.setColor(rs.getString(9));
                   pro.setPrecioV(rs.getDouble(10));
                   pro.setImagen1(rs.getString(11));
                   pro.setImagen2(rs.getString(12));
                   pro.setImagen3(rs.getString(13));
                   pro.setIdMarca(rs.getInt(14));
                   pro.setIdFabrica(rs.getInt(15));
                   pro.setMarca(rs.getString(16));
                   pro.setNombreFabrica(rs.getString(17));
                   pro.setCantidad(rs.getInt(18));

               }
            }catch(Exception e){   
           }
           return pro;
       }

    /**
     * Metodo para actualizar una Producto
     * @param pro el objeto Producto el cual tendra el id y los datos para actualizar el objeto en la base de datos
     * @return int respuesta, 1 al actualizar exitosamente, 0 de lo contrario
     */
       public int actualizar(Producto pro){
           int x = pro.getPrecioL();
            String sql="UPDATE producto SET nombre=?, precio_lista=?, memoria=?, almacenamiento=?, procesador=?, cores=?, descripcion=?, color=?, precio_venta=precioT("+x+"), imagen1=?, imagen2=?, imagen3=?, idmarca=?, idfabrica=? where ID=?";
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, pro.getNombre());
               ps.setInt(2, pro.getPrecioL());
               ps.setInt(3, pro.getMemoria());
               ps.setInt(4, pro.getAlmacenamiento());
               ps.setString(5, pro.getProcesador());
               ps.setInt(6, pro.getCores());
               ps.setString(7, pro.getDescripcion());
               ps.setString(8, pro.getColor());
               ps.setString(9, pro.getImagen1());
               ps.setString(10, pro.getImagen2());
               ps.setString(11, pro.getImagen3());
               ps.setInt(12, pro.getIdMarca());
               ps.setInt(13,pro.getIdFabrica());
               ps.setInt(14, pro.getId());
               
               ps.executeUpdate();
               
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para eliminar una Producto
     * @param id id del registro que se borrara en la tabla Producto de base de datos
     * @return int respuesta, 1 al eliminar exitosamente, 0 de lo contrario
     */
       public void delete(int id){
           String sql ="delete from producto where ID="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.executeUpdate();
            }catch(Exception e){   
           }
       }

    public Producto buscarM(String nombre){
        Producto m=new Producto();
        String sql ="select * from producto where nombre='"+nombre+"'";
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setIdFabrica(rs.getInt("idfabrica"));
            }
        }catch(Exception e){
            m.setId(0);
        }
        return m;
    }
       
}
