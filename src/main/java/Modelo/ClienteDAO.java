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
 * Clase ClienteDAO
 * Contiene los metodos para acceder a la base de datos y aterrizarlos en la clase Cliente
 * @author josue
 */
public class ClienteDAO {

       Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;
        /**
         * Variables para la conexión
         */


        /**
         * Metodo para buscar un cliente por id
         * @param id el id del cliente el cual se buscara en la base de datos
         * @return Devuelve un Objeto Cliente si lo encontró, de no encontrarlo un objeto Cliente vacio
         */
        public Cliente buscar(int id){
           Cliente c=new Cliente();
           String sql ="select * from clientes inner join suscripciones on clientes.suscripcion=suscripciones.id where clientes.id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   c.setNombre(rs.getString("nombre"));
                   c.setNit(rs.getInt("nit"));
                   c.setCorreo(rs.getString("email"));
                   c.setCelular(rs.getInt("telefono"));
                   c.setPatente(rs.getString("patente"));
                   c.setSuscripcion(rs.getInt("suscripcion"));
                   c.setId(rs.getInt("id"));
                   c.setRango(rs.getString("nombretipo"));
                   c.setDescuento(rs.getFloat("descuento"));
               }
           }catch(Exception e){
               
           }
           return c;
       }

        /**
         * Metodo para listar todos los cliente
         * @return Objeto Lista <Cliente> con todos los clientes que se encontraron
         */
       public List listar(){
           String sql= "select * from clientes inner join suscripciones on clientes.suscripcion=suscripciones.id ORDER BY clientes.id asc";
           List<Cliente> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Cliente cl = new Cliente();
                   cl.setNombre(rs.getString("nombre"));
                   cl.setNit(rs.getInt("nit"));
                   cl.setCorreo(rs.getString("email"));
                   cl.setCelular(rs.getInt("telefono"));
                   cl.setPatente(rs.getString("patente"));
                   cl.setSuscripcion(rs.getInt("suscripcion"));
                   cl.setId(rs.getInt("id"));
                   cl.setRango(rs.getString("nombretipo"));
                   cl.setDescuento(rs.getFloat("descuento"));
                   lista.add(cl);
               }
           }catch(Exception e){   
           }
           return lista;
       }

        /**
         * Metodo para agregar un cliente
         * @param cl el objeto cliente el cual se agregara a la base de datos
         * @return int respuesta, 1 al agregar exitosamente el cliente, 0 de lo contrario
         */
       public int agregar(Cliente cl){
           String sql="INSERT INTO clientes VALUES (?,?,?,?,?,?,?,default)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, cl.getId());
               ps.setString(2, cl.getNombre());
               ps.setInt(3, cl.getNit());
               ps.setString(4, cl.getCorreo());
               ps.setInt(5, cl.getCelular());
               ps.setInt(6, cl.getSuscripcion());
               ps.setString(7, cl.getPatente());
               
               ps.executeUpdate();
            }catch(Exception i){   
           }
           
           return respuesta;
       }
       
       public Cliente listarId(int id){
           Cliente cl = new Cliente();
           String sql ="select * from clientes inner join suscripciones on clientes.suscripcion=suscripciones.id where clientes.id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   cl.setNombre(rs.getString("nombre"));
                   cl.setNit(rs.getInt("nit"));
                   cl.setCorreo(rs.getString("email"));
                   cl.setCelular(rs.getInt("telefono"));
                   cl.setPatente(rs.getString("patente"));
                   cl.setSuscripcion(rs.getInt("suscripcion"));
                   cl.setId(rs.getInt("id"));
                   cl.setRango(rs.getString("nombretipo"));
                   cl.setDescuento(rs.getFloat("descuento"));
               }
            }catch(Exception e){   
           }
           return cl;
       }

    /**
     * Metodo para actualizar un cliente
     * @param cl el objeto Cliente el cual tendra el id y los datos para actualizar el objeto en la base de datos
     * @return int respuesta, 1 al actualizar exitosamente el cliente, 0 de lo contrario
     */
       public int actualizar(Cliente cl){
            String sql="UPDATE clientes SET nombre=?, nit=?, email=?, telefono=?, patente=?, suscripcion=? where ID=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, cl.getNombre());
               ps.setInt(2, cl.getNit());
               ps.setString(3, cl.getCorreo());
               ps.setInt(4, cl.getCelular());
               ps.setString(5, cl.getPatente());
               ps.setInt(6, cl.getSuscripcion());
               ps.setInt(7, cl.getId());
               ps.executeUpdate();
                respuesta=1;
            }catch(Exception i){
                respuesta=0;
           }     
           
           return respuesta;
       }

    /**
     * Metodo para eliminar un cliente
     * @param id id del registro que se borrara en la tabla clientes de base de datos
     * @return int respuesta, 1 al eliminar exitosamente el cliente, 0 de lo contrario
     */
       public int delete(int id){
           String sql ="delete from clientes where ID="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.executeUpdate();
               respuesta=1;
            }catch(Exception e){
               respuesta=0;
           }

           return respuesta;
           
    }
       
}
