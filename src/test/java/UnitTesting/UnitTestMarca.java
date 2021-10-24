package UnitTesting;

import Modelo.*;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class UnitTestMarca {
    MarcaDAO mockMarcaDAO = Mockito.mock(MarcaDAO.class);

    @Test(groups="unitTest",description = "Prueba agregar nueva Marca")
    public void agregarCliente(){
        Marca marca = new Marca();

        marca.setNombrem("Samsung");
        marca.setId(2);
        marca.setDescripcion("Marca de prueba");
        marca.setLogo("logo.png");

        Assert.assertEquals(mockMarcaDAO.agregar(marca),0,"Error al añadir registro");
    }

    @Test(groups="unitTest",description = "Prueba métodos getter y setter de Marca")
    public void gettersYsettersMarca(){
        Marca marca = new Marca();
        marca.setNombrem("Samsung");
        marca.setId(2);
        marca.setDescripcion("Marca de prueba");
        marca.setLogo("logo.png");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(marca.getId(),2);
        softAssert.assertEquals(marca.getNombrem(),"Samsung");
        softAssert.assertEquals(marca.getDescripcion(),"Marca de prueba");
        softAssert.assertEquals(marca.getLogo(),"logo.png");
        softAssert.assertAll("Error getters y setter Marcas");
    }

    @Test(groups="unitTest",description = "Prueba listar marcas")
    public void listarmarcas(){
        List<String> list1 =new ArrayList<>();
        Assert.assertEquals(mockMarcaDAO.listar(),list1,"Error Buscar marcas");
    }

    @Test(groups="unitTest",description = "Prueba eliminar marca por ID")
    public void deletebyId(){
        mockMarcaDAO.delete(5);
    }
/*
    @Test(groups="unitTest",description = "Prueba conexion a base de datos")
    public void conexion(){
        Conexion conexion = new Conexion();
        Connection con;
        con = conexion.conexion();
        Assert.assertNotEquals(con,null,"Error de conexión a BD");
    }

    @Test(dependsOnMethods = {"conexion"},description = "Prueba búsqueda de cliente por ID")
    @Parameters({"cliente1"})
    public void buscarCliente(int cliente1){
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente = clienteDAO.buscar(cliente1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(cliente.getNombre(),null);
        softAssert.assertNotEquals(cliente.getCelular(),null);
        softAssert.assertNotEquals(cliente.getCorreo(),null);
        softAssert.assertNotEquals(cliente.getNit(),null);
        softAssert.assertNotEquals(cliente.getRango(),null);
        softAssert.assertNotEquals(cliente.getDescuento(),null);
        softAssert.assertNotEquals(cliente.getPatente(),null);
        softAssert.assertNotEquals(cliente.getSuscripcion(),null);
        softAssert.assertAll("Error búsqueda de cliente por Id");
    }

    @Test(dependsOnMethods = {"conexion"},description = "Prueba metodo para obetener el id de la última venta")
    public void maxIdVenta(){
        VentaDAO ventaDAO = new VentaDAO();
        Assert.assertNotEquals(ventaDAO.Idventas(),0,"Error máximo id Ventas");
    }

    @Test(dependsOnMethods = {"conexion"}, description = "Prueba Metodo para obtener las marcas de terminales registradas")
    public void listarMarcas(){
        MarcaDAO marcaDAO = new MarcaDAO();
        List<Marca> lista=new ArrayList<>();
        lista = marcaDAO.listar();
        Assert.assertNotEquals(lista.size(),0,"Error lista de marcas");

    }

    @Test(dependsOnMethods = {"buscarCliente"}, description = "Prueba actualización de un cliente")
    @Parameters({"cliente1"})
    public void actualizarCliente(int cliente1){
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente = clienteDAO.buscar(cliente1);
        cliente.setId(1);
        Assert.assertEquals(clienteDAO.actualizar(cliente),1,"Error actualizar cliente");
    }

    @Test(dependsOnMethods = {"conexion"},description = "Prueba buscar Inventario por ID")
    @Parameters({"inventario1"})
    public void buscarInventario(int inventario1){
        InventarioDAO inventarioDAO = new InventarioDAO();
        Inventario inventario = new Inventario();
        inventario = inventarioDAO.buscar(inventario1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(inventario.getId(),null);
        softAssert.assertNotEquals(inventario.getIdProducto(),null);
        softAssert.assertNotEquals(inventario.getCantidad(),null);
        softAssert.assertAll("Error búsqueda de inventario por Id"); aa
    }

    @Test(dependsOnMethods = {"conexion"},description = "Prueba método para validar empleados")
    @Parameters({"usser","pass","expected"})
    public void validarEmpleado(String usser, String pass, int expected){
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        Empleado empleado = new Empleado();
        empleado= empleadoDAO.validar(usser,pass);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(empleado.getId(),expected);
        softAssert.assertEquals(empleado.getTipo(),expected);
        softAssert.assertAll("Error en validación de empleado");

    }
*/
}
