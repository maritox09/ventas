package UnitTesting;

import Modelo.MarcaDAO;
import Modelo.Pedido;
import Modelo.PedidoDAO;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class UnitTestPedidos {

    PedidoDAO mockPedidosDAO = Mockito.mock(PedidoDAO.class);

    @Test(groups="unitTest",description = "Prueba métodos getter y setter de Pedidos")
    public void gettersYsettersPedidos(){
        Pedido pedido = new Pedido();
        pedido.setIdpedido(1);
        pedido.setIdproducto(20);
        pedido.setFechaentrega("01/02/21");
        pedido.setFechapedido("01/01/21");
        pedido.setCantidad(20);
        pedido.setEstado("Recibido");


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(pedido.getIdpedido(),1);
        softAssert.assertEquals(pedido.getIdproducto(),20);
        softAssert.assertEquals(pedido.getFechaentrega(),"01/02/21");
        softAssert.assertEquals(pedido.getFechapedido(),"01/01/21");
        softAssert.assertEquals(pedido.getCantidad(),20);
        softAssert.assertEquals(pedido.getEstado(),"Recibido");
        softAssert.assertAll("Error getters y setter Pedidos");
    }

    @Test(groups="unitTest",description = "Prueba listar pedidos")
    public void listarPedidos(){
        List<String> list1 =new ArrayList<>();
        Assert.assertEquals(mockPedidosDAO.listar(),list1,"Error Buscar pedidos");
    }
    @Test(groups="unitTest",description = "Prueba buscar marca por ID")
    public void buscarbyId(){
        mockPedidosDAO.buscar(5);
    }

    @Test(groups="unitTest",description = "Actualizar el estado de un inventario")
    public void actualizaEstadoInventario(){
        mockPedidosDAO.actualizarEstado(1,2);
    }

}
