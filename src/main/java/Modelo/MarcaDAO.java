
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase MarcaDAO
 * Contiene los metodos para acceder a la base de datos y aterrizarlos en la clase Marca
 */
public class MarcaDAO {
    Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;


    public int Idmax(){
        int idVentas=0;
        String sql ="select max(id) as idmarca from marcas";
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                idVentas=rs.getInt("idmarca");
            }
        }catch(Exception e){

        }
        return idVentas;
    }

    /**
     * Metodo para buscar una Marca por id
     * @param id el id del Marca el cual se buscara en la base de datos
     * @return Devuelve un Objeto Marca si lo encontró, de no encontrarlo un objeto Marca vacio
     */
        public Marca buscar(int id){
           Marca m=new Marca();
           String sql ="select * from marcas where id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   m.setId(rs.getInt("id"));
                   m.setNombrem(rs.getString("nombrem"));
                   m.setLogo(rs.getString("logo"));
                   m.setDescripcion(rs.getString("descripcion"));
               }
           }catch(Exception e){
               
           }
           return m;
       }


        public Marca buscarM(String nombre){
           Marca m=new Marca();
           String sql ="select * from marcas where nombrem='"+nombre+"'";
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   m.setId(rs.getInt("id"));
                   m.setNombrem(rs.getString("nombrem"));
                   m.setLogo(rs.getString("logo"));
                   m.setDescripcion(rs.getString("descripcion"));
               }
           }catch(Exception e){
               
           }
           return m;
       }

    /**
     * Metodo para listar todos los Marca
     * @return Objeto Lista <Marca> con todos los Marca que se encontraron en la base de datos
     */
       public List listar(){
           String sql= "select * from marcas";
           List<Marca> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Marca mr = new Marca();
                   mr.setId(rs.getInt("id"));
                   mr.setNombrem(rs.getString("nombrem"));
                   mr.setLogo(rs.getString("logo"));
                   mr.setDescripcion(rs.getString("descripcion"));
                   lista.add(mr);
               }
           }catch(Exception e){   
           }
           return lista;
       }

    /**
     * Metodo para agregar un Marcas
     * @param mr el objeto Marca el cual se agregara a la base de datos
     * @return int respuesta, 1 al agregar exitosamente, 0 de lo contrario
     */
       public int agregar(Marca mr){
           String sql="INSERT INTO marcas VALUES (?,?,?,?)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, mr.getId());
               ps.setString(2, mr.getNombrem());
               ps.setString(3, mr.getLogo());
               ps.setString(4, mr.getDescripcion());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para actualizar una Marca
     * @param mr el objeto Marca el cual tendra el id y los datos para actualizar el objeto en la base de datos
     * @return int respuesta, 1 al actualizar exitosamente, 0 de lo contrario
     */
       public int actualizar(Marca mr){
            String sql="UPDATE Marcas SET nombrem=?, logo=?, descripcion=? where ID=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, mr.getNombrem());
               ps.setString(2, mr.getLogo());
               ps.setString(3, mr.getDescripcion());
               ps.setInt(4, mr.getId());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }

    /**
     * Metodo para eliminar una Marca
     * @param id id del registro que se borrara en la tabla Marcas de base de datos
     * @return int respuesta, 1 al eliminar exitosamente, 0 de lo contrario
     */
       public void delete(int id){
           String sql ="delete from marcas where ID="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.executeUpdate();
            }catch(Exception e){   
           }
           
           
    }
}
