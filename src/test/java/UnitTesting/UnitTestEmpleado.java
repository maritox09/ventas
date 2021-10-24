package UnitTesting;

import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class UnitTestEmpleado {

    EmpleadoDAO mockEmpleadoDAO = Mockito.mock(EmpleadoDAO.class);

    @Test(groups="unitTest",description = "Prueba agregar nuevo Empleado")
    public void agregarEmpleado(){
        Empleado empleado = new Empleado();

        empleado.setId(1);
        empleado.setCorreo("empleado@gmail.com");
        empleado.setNombre("test");
        empleado.setRango("Vendedor");
        empleado.setPass("contra123");
        empleado.setTipo(1);

        Assert.assertEquals(mockEmpleadoDAO.agregar(empleado),0,"Error al añadir registro");
    }

    @Test(groups="unitTest",description = "Prueba métodos getter y setter de Empleado")
    public void gettersYsettersEmpleado(){
        Empleado empleado = new Empleado();
        empleado.setTipo(2);
        empleado.setRango("Vendedor");
        empleado.setNombre("Juan");
        empleado.setCorreo("juan@gmail.com");
        empleado.setPass("pass123");
        empleado.setId(5);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(empleado.getPass(),"pass123");
        softAssert.assertEquals(empleado.getCorreo(),"juan@gmail.com");
        softAssert.assertEquals(empleado.getId(),5);
        softAssert.assertEquals(empleado.getRango(),"Vendedor");
        softAssert.assertEquals(empleado.getTipo(),2);
        softAssert.assertAll("Error getters y setter Cliente");
    }

    @Test(groups="unitTest",description = "Prueba listar empleados")
    public void listarClientes(){
        List<String> list1 =new ArrayList<>();
        Assert.assertEquals(mockEmpleadoDAO.listar(),list1,"Error listar empleados");
    }

    @Test(groups="unitTest",description = "Prueba listar Empleado por ID")
    public void listarbyId(){
        mockEmpleadoDAO.listarId(5);
    }

    @Test(groups="unitTest",description = "Prueba actualizar Empleado")
    public void actualizarEmpleado(){
        Empleado empleado = new Empleado();

        empleado.setId(1);
        empleado.setCorreo("empleado@gmail.com");
        empleado.setNombre("test");
        empleado.setRango("Vendedor");
        empleado.setPass("contra123");
        empleado.setTipo(1);

        Assert.assertEquals(mockEmpleadoDAO.actualizar(empleado),0,"Error al actualizar empleado");
    }

    @Test(groups="unitTest",description = "Prueba eliminar Empleado")
    public void deleteById(){
        mockEmpleadoDAO.delete(5);
    }
}
