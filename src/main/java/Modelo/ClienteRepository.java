package Modelo;

import java.util.ArrayList;
import java.util.List;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;


public class ClienteRepository {

    public List<Cliente> clientes() throws Exception {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("http://ventas.falcorp.net:8080/PrimerSistema/api/clientes").asString();

        List<Cliente> clientes=new ArrayList<>();
        JSONArray json = new JSONArray(response.getBody());
        for (int i=0;i<json.length(); i++){
            Cliente cliente = new Cliente();
            JSONObject jsonObject = json.getJSONObject(i);
            cliente.setId(jsonObject.getInt("id"));
            cliente.setNombre(jsonObject.getString("nombre"));
            cliente.setNit(jsonObject.getInt("nit"));
            cliente.setCorreo(jsonObject.getString("email"));
            cliente.setCelular(jsonObject.getInt("telefono"));
            cliente.setSuscripcion(jsonObject.getInt("suscripcion"));
            cliente.setPatente(jsonObject.getString("patente"));

            clientes.add(cliente);
        }

        return clientes;

    }
}
