package UnitTesting;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class UnitTestCliente {

    ClienteDAO mockClienteDAO = Mockito.mock(ClienteDAO.class);

    @Test(groups="unitTest",description = "Prueba agregar nuevo Cliente")
    public void agregarCliente(){
        Cliente cliente = new Cliente();

        cliente.setId(200);
        cliente.setNombre("Josue");
        cliente.setNit(546554);
        cliente.setCelular(52653254);
        cliente.setCorreo("josue@gmail.com");
        cliente.setSuscripcion(1);
        cliente.setPatente("patente.com");

        Assert.assertEquals(mockClienteDAO.agregar(cliente),0,"Error al añadir registro");
    }

    @Test(groups="unitTest",description = "Prueba métodos getter y setter de Cliente")
    public void gettersYsettersInventario(){
        Cliente cliente = new Cliente();
        cliente.setCelular(12345678);
        cliente.setDescuento(2.0f);
        cliente.setCorreo("test@gmail.com");
        cliente.setId(5);
        cliente.setNit(562626112);
        cliente.setPatente("patente.png");
        cliente.setRango("Mayorista");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(cliente.getCelular(),12345678);
        softAssert.assertEquals(cliente.getDescuento(),2.0f);
        softAssert.assertEquals(cliente.getCorreo(),"test@gmail.com");
        softAssert.assertEquals(cliente.getId(),5);
        softAssert.assertEquals(cliente.getNit(),562626112);
        softAssert.assertEquals(cliente.getPatente(),"patente.png");
        softAssert.assertEquals(cliente.getRango(),"Mayorista");
        softAssert.assertAll("Error getters y setter Cliente");
    }

    @Test(groups="unitTest",description = "Prueba buscar nuevo Cliente")
    public void buscarCliente(){
        mockClienteDAO.buscar(5);
    }

    @Test(groups="unitTest",description = "Prueba listar Cliente")
    public void listarClientes(){
        List<String> list1 =new ArrayList<>();
        Assert.assertEquals(mockClienteDAO.listar(),list1,"Error Buscar cliente");
    }

    @Test(groups="unitTest",description = "Prueba listar Cliente por ID")
    public void listarbyId(){
        mockClienteDAO.listarId(5);
    }

    @Test(groups="unitTest",description = "Prueba actualizar Cliente")
    public void actualizarCliente(){
        Cliente cliente = new Cliente();

        cliente.setId(200);
        cliente.setNombre("Josue");
        cliente.setNit(546554);
        cliente.setCelular(52653254);
        cliente.setCorreo("josue@gmail.com");
        cliente.setSuscripcion(1);
        cliente.setPatente("patente.com");

        Assert.assertEquals(mockClienteDAO.actualizar(cliente),0,"Error al actualizar cliente");
    }

    @Test(groups="unitTest",description = "Prueba eliminar Cliente")
    public void deleteById(){
        Assert.assertEquals( mockClienteDAO.delete(5),0,"Error al eliminar cliente");
    }

}
