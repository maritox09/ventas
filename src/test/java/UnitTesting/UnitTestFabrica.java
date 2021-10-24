package UnitTesting;

import Modelo.Cliente;
import Modelo.Fabrica;
import Modelo.FabricaDAO;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class UnitTestFabrica {

    FabricaDAO mockfabricaDAO = Mockito.mock(FabricaDAO.class);

    @Test(groups="unitTest",description = "Prueba agregar nueva Marca")
    public void agregarFabrica(){
        Fabrica fabrica = new Fabrica();

        fabrica.setPass("pass");
        fabrica.setUsuario("empresa");
        fabrica.setDominio("dominio");
        fabrica.setNombref("fabrica");
        fabrica.setIdf(2);

        Assert.assertEquals(mockfabricaDAO.agregar(fabrica),0,"Error al añadir registro");
    }

    @Test(groups="unitTest",description = "Prueba métodos getter y setter de Fabrica")
    public void gettersYsettersFabrica(){
        Fabrica fabrica = new Fabrica();

        fabrica.setPass("pass");
        fabrica.setUsuario("empresa");
        fabrica.setDominio("dominio");
        fabrica.setNombref("fabrica");
        fabrica.setIdf(2);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(fabrica.getPass(),"pass");
        softAssert.assertEquals(fabrica.getUsuario(),"empresa");
        softAssert.assertEquals(fabrica.getDominio(),"dominio");
        softAssert.assertEquals(fabrica.getNombref(),"fabrica");
        softAssert.assertEquals(fabrica.getIdf(),2);
        softAssert.assertAll("Error getters y setter Fabrica");
    }

    @Test(groups="unitTest",description = "Prueba buscar fabrica")
    public void buscarFabrica(){
        mockfabricaDAO.buscar(5);
    }

    @Test(groups="unitTest",description = "Prueba buscar marca")
    public void buscarMarca(){
        mockfabricaDAO.buscarM("fabrica1");
    }
    @Test(groups="unitTest",description = "Prueba actualizar Fabrica")
    public void actualizarFabrica(){
        Fabrica fabrica = new Fabrica();

        fabrica.setPass("pass");
        fabrica.setUsuario("empresa");
        fabrica.setDominio("dominio");
        fabrica.setNombref("fabrica");
        fabrica.setIdf(2);

        Assert.assertEquals(mockfabricaDAO.actualizar(fabrica),0,"Error al actualizar cliente");
    }

    @Test(groups="unitTest",description = "Prueba listar Fabricas")
    public void listarFabricas(){
        List<String> list1 =new ArrayList<>();
        Assert.assertEquals(mockfabricaDAO.listar(),list1,"Error Buscar fabricas");
    }

    @Test(groups="unitTest",description = "Prueba eliminar Fabrica")
    public void deleteById(){
        mockfabricaDAO.delete(5);
    }
}
