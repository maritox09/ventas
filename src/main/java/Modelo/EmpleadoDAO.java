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
 * Clase EmpleadoDAO
 * Contiene los metodos para acceder a la base de datos y aterrizarlos en la clase Empleado
 */
public class EmpleadoDAO {
       Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;

        /**
         * Metodo para validar las acciones que tendra un empleado en la página
         * @param user,pass el usuario y la contraseña se validaran en la base de datos para obtener los datos del empleado
         * @return devuelde el objeto Empleado con todos sus datos
         *
         */
       public Empleado validar(String user, String pass){
           Empleado em= new Empleado();
           String sql = "Select * from empleados where usuario=? and pass=?";
           try{
               con=cn.conexion();
               ps = con.prepareStatement(sql);
               ps.setString(1, user);
               ps.setString(2, pass);
               rs=ps.executeQuery();
               while(rs.next()){
                   em.setNombre(rs.getString("usuario"));
                   em.setPass(rs.getString("pass"));
                   em.setTipo(rs.getInt("tipo"));
                   em.setId(rs.getInt("id"));
                   em.setCorreo(rs.getString("correo"));
                   
               }
           }catch(Exception e){
               
           }
           return em;
       }

    /**
     * Metodo para listar todos los Empleado
     * @return Objeto Lista <Empleado> con todos los Empleado que se encontraron en la base de datos
     */
       public List listar(){
           String sql= "select * from empleados inner join tipoemp on empleados.tipo=tipoemp.id ORDER BY empleados.id asc";
           List<Empleado> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Empleado em = new Empleado();
                   em.setNombre(rs.getString("usuario"));
                   em.setPass(rs.getString("pass"));
                   em.setTipo(rs.getInt("tipo"));
                   em.setId(rs.getInt("id"));
                   em.setCorreo(rs.getString("correo"));
                   em.setRango(rs.getString("rango"));
                   lista.add(em);
               }
           }catch(Exception e){   
           }
           return lista;
       }

    /**
     * Metodo para agregar un Empleado
     * @param em el objeto Empleado el cual se agregara a la base de datos
     * @return int respuesta, 1 al agregar exitosamente el cliente, 0 de lo contrario
     */
       public int agregar(Empleado em){
           String sql="INSERT INTO empleados VALUES (null,?,?,?,?)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, em.getNombre());
               ps.setString(2, em.getPass());
               ps.setString(3, em.getCorreo());
               ps.setInt(4, em.getTipo());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para buscar un Empleado por id
     * @param id el id del Empleado el cual se buscara en la base de datos
     * @return Devuelve un Objeto Empleado si lo encontró, de no encontrarlo un objeto Empleado vacio
     */
       public Empleado listarId(int id){
           Empleado em = new Empleado();
           String sql ="select * from empleados inner join tipoemp on empleados.tipo=tipoemp.id where empleados.id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   em.setNombre(rs.getString("usuario"));
                   em.setPass(rs.getString("pass"));
                   em.setTipo(rs.getInt("tipo"));
                   em.setId(rs.getInt("id"));
                   em.setCorreo(rs.getString("correo"));
                   em.setRango(rs.getString("rango"));
               }
            }catch(Exception e){   
           }
           return em;
       }

    /**
     * Metodo para actualizar un Empleado
     * @param em el objeto Empleado el cual tendra el id y los datos para actualizar el objeto en la base de datos
     * @return int respuesta, 1 al actualizar exitosamente, 0 de lo contrario
     */
       public int actualizar(Empleado em){
            String sql="UPDATE empleados SET usuario=?, pass=?, correo=?, tipo=? where ID=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, em.getNombre());
               ps.setString(2, em.getPass());
               ps.setString(3, em.getCorreo());
               ps.setInt(4, em.getTipo());
               ps.setInt(5, em.getId());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para eliminar un registro
     * @param id id del registro que se borrara en la tabla Empleados de base de datos
     * @return int respuesta, 1 al eliminar exitosamente, 0 de lo contrario
     */
       public void delete(int id){
           String sql ="delete from empleados where ID="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.executeUpdate();
            }catch(Exception e){   
           }
       }
}
