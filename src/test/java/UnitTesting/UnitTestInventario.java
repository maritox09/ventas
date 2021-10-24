package UnitTesting;

import Modelo.*;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class UnitTestInventario {

    InventarioDAO mockInventarioDAO = Mockito.mock(InventarioDAO.class);

    @Test(groups="unitTest",description = "Prueba buscar inventario")
    public void buscarInventario(){
        mockInventarioDAO.buscar(5);
    }

    @Test(groups="unitTest",description = "Prueba métodos getter y setter de Inventario")
    public void gettersYsettersInventario(){
        Inventario inventario = new Inventario();
        inventario.setId(20);
        inventario.setCantidad(200);
        inventario.setIdProducto(30);
        inventario.setNombreProducto("Samsung galaxy 7");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(inventario.getId(),20);
        softAssert.assertEquals(inventario.getCantidad(),200);
        softAssert.assertEquals(inventario.getIdProducto(),30);
        softAssert.assertEquals(inventario.getNombreProducto(),"Samsung galaxy 7");
        softAssert.assertAll("Error getters y setter Inventario");
    }

    @Test(groups="unitTest",description = "Prueba listar inventarios")
    public void listarInventarios(){
        List<String> list1 =new ArrayList<>();
        Assert.assertEquals(mockInventarioDAO.listar(),list1,"Error Buscar inventarios");
    }

    @Test(groups="unitTest",description = "Prueba busqueda del producto de cada inventario")
    public void listarbyId(){
        mockInventarioDAO.buscarXpro(5);
    }
}
