
package Modelo;

import Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase FabricaDAO
 * Contiene los metodos para acceder a la base de datos y aterrizarlos en la clase Fabrica
 */
public class FabricaDAO {
    Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;

    /**
     * Metodo para buscar un Fabrica por id
     * @param id el id del Fabrica el cual se buscara en la base de datos
     * @return Devuelve un Objeto Fabrica si lo encontró, de no encontrarlo un objeto Fabrica vacio
     */
        public Fabrica buscar(int id){
            Fabrica f=new Fabrica();
           String sql ="select * from fabricas where idf="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   f.setIdf(rs.getInt("idf"));
                   f.setNombref(rs.getString("nombref"));
                   f.setDominio(rs.getString("dominio"));
                   f.setUsuario(rs.getString("usuario"));
                   f.setPass(rs.getString("pass"));
               }
           }catch(Exception e){
               
           }
           return f;
       }

    /**
     * Metodo para buscar un cliente por nombre
     * @param nombre el nombre del Fabrica el cual se buscara en la base de datos
     * @return Devuelve un Objeto Fabrica si lo encontró, de no encontrarlo un objeto Fabrica vacio
     */
        public Fabrica buscarM(String nombre){
            Fabrica f=new Fabrica();
           String sql ="select * from fabricas where nombref='"+nombre+"'";
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   f.setIdf(rs.getInt("idf"));
                   f.setNombref(rs.getString("nombref"));
                   f.setDominio(rs.getString("dominio"));
                   f.setUsuario(rs.getString("usuario"));
                   f.setPass(rs.getString("pass"));
               }
           }catch(Exception e){
               
           }
           return f;
       }

    /**
     * Metodo para listar todos los Fabrica
     * @return Objeto Lista <Fabrica> con todos las Fabrica que se encontraron en la base de datos
     */
       public List listar(){
           String sql= "select * from fabricas";
           List<Fabrica> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Fabrica f = new Fabrica();
                   f.setIdf(rs.getInt("idf"));
                   f.setNombref(rs.getString("nombref"));
                   f.setDominio(rs.getString("dominio"));
                   f.setUsuario(rs.getString("usuario"));
                   f.setPass(rs.getString("pass"));
                   lista.add(f);
               }
           }catch(Exception e){   
           }
           return lista;
       }

    /**
     * Metodo para agregar un Fabrica
     * @param mr el objeto Fabrica el cual se agregara a la base de datos
     * @return int respuesta, 1 al agregar exitosamente, 0 de lo contrario
     */
       public int agregar(Fabrica mr){
           String sql="INSERT INTO fabricas VALUES (null,?,?,?,?)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, mr.getNombref());
                ps.setString(2, mr.getDominio());
                ps.setString(3, mr.getUsuario());
                ps.setString(4, mr.getPass());
                ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para actualizar un Fabrica
     * @param mr el objeto Fabrica el cual tendra el id y los datos para actualizar el objeto en la base de datos
     * @return int respuesta, 1 al actualizar exitosamente, 0 de lo contrario
     */
       public int actualizar(Fabrica mr){
            String sql="UPDATE fabricas SET nombref=?, dominio=?, usuario=? where IDF=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, mr.getNombref());
               ps.setString(2, mr.getDominio());
               ps.setString(3, mr.getUsuario());
               ps.setInt(4, mr.getIdf());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para eliminar un Fabrica
     * @param id id del registro que se borrara en la tabla Fabricas de base de datos
     * @return int respuesta, 1 al eliminar exitosamente, 0 de lo contrario
     */
       public void delete(int id){
           String sql ="delete from fabricas where IDF="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.executeUpdate();
            }catch(Exception e){   
           }
           
           
    }
}
