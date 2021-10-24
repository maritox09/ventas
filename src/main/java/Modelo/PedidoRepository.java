package Modelo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Clase PedidoRepository
 * Contiene los metodos para realizar pedidos a Fabrica
 */
public class PedidoRepository {

    /**
     * Metodo para obtener el inventario de una fabrica
     * @param dominio,usuario,pass se pasan los datos de la fabrica a la que se consultará
     * @return Deveulve una List<Producto> con todos los datos de los productos del inventario de la fabrica
     */
    public List<Producto> inventarioFabrica(String dominio, String usuario, String pass) throws Exception {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://"+dominio+".falcorp.net/solicitar_inventario")
                .header("Content-Type", "application/json")
                .body("{\r\n    \"usuario\": \""+usuario+"\",\r\n    \"pass\":\""+pass+"\"\r\n}")
                .asString();

        System.out.println(response);
        List<Producto> inventario=new ArrayList<>();
        JSONArray json = new JSONArray(response.getBody());
        for (int i=0;i<json.length(); i++){
            Producto producto = new Producto();
            JSONObject jsonObject = json.getJSONObject(i);
            producto.setMemoria(jsonObject.getInt("memoria"));
            producto.setAlmacenamiento(jsonObject.getInt("almacenamiento"));
            producto.setProcesador(jsonObject.getString("procesador"));
            producto.setCores(jsonObject.getInt("cores"));
            producto.setMarca(jsonObject.getString("marca"));
            producto.setNombre(jsonObject.getString("modelo"));
            producto.setPrecioL(jsonObject.getInt("precio"));
            producto.setDescripcion("Telefono nuevo ingreso");
            producto.setColor("Negro");
            producto.setImagen1("https://cdn2.smart-gsm.com//2020/06/Samsung-Galaxy-S10-Lite-1.jpg");
            producto.setImagen2("https://cdn2.smart-gsm.com//2020/06/Samsung-Galaxy-S10-Lite-1.jpg");
            producto.setImagen3("https://cdn2.smart-gsm.com//2020/06/Samsung-Galaxy-S10-Lite-1.jpg");
            inventario.add(producto);
        }
        return inventario;

    }

    public Producto buscarModelo(String modelo, String fabrica) throws Exception {
        Producto producto = new Producto();
        FabricaDAO fdao=new FabricaDAO();
        Fabrica fabrica1= new Fabrica();
        fabrica1=fdao.buscarM(fabrica);
        List<Producto> inventario=new ArrayList<>();
        inventario= inventarioFabrica(fabrica1.getDominio(),fabrica1.getUsuario(),fabrica1.getPass());
        for(int i=0;i<inventario.size(); i++){
            if (inventario.get(i).getNombre().equals(modelo)){
                producto= inventario.get(i);
            }
        }
        return producto;
    }

    /**
     * Metodo para realizar un Pedido a fabrica
     * @param modelo,cantidad se envia el nombre del modelo y la cantidad que se pedira
     * @return Devuelve el número de orden del pedido, proporcionado por la fabrica
     */
    public String hacerPedido(String dominio, String usuario, String pass, String modelo, int cantidad) throws Exception {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://"+dominio+".falcorp.net/nueva_orden")
                .header("Content-Type", "application/json")
                .body("{\r\n    \"usuario\": \""+usuario+"\",\r\n    \"pass\":\""+pass+"\",\r\n    \"orden\":[\r\n        {\"modelo\":\"" + modelo + "\", \"cantidad\":\"" + cantidad + "\"}\r\n    ]\r\n}")
                .asString();

        String orden;
        JSONObject json= new JSONObject(response.getBody());
        orden = json.getString("orden");
        return orden;

    }

    /**
     * Metodo para cancelar un Pedido ya realizado a fabrica
     * @param orden se envia el numero de orden que se quiere cancelar
     */
    public void cancelarPedido(String orden) throws Exception {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://fabrica.falcorp.net/cancelar_orden")
                .header("Content-Type", "application/json")
                .body("{\r\n    \"usuario\": \"6073872cefe04403f9283fd7\",\r\n    \"pass\":\"12345\",\r\n    \"orden\":\""+orden+"\"\r\n}")
                .asString();

    }

}
