
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body> 
        <div class="d-flex">
            <div class="col-lg-4 col-xs-12">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                    <div class="card-body">
                        <div class="form-group mb-2"> 
                            <label class="h3"> Datos del cliente </label>
                        </div>
                        <div class="form-group d-flex"> 
                            <div class="col-6">
                                <input type="text" name="codigocliente" value="${c.getId()}" class="form-control" placeholder="codigo">
                            </div>
                            <div class="col-3">
                                <input type="submit" name="accion" value="Buscar Cliente" class="btn btn-outline-info">
                            </div>
                            
                        </div>
                        <div class="form-group mt-3 "> 
                            <div class="col-7 mt-2"> 
                               <label class=""> Nombre</label>
                               <input type="text" name="nombrescliente" value="${c.getNombre()}" class="form-control col-4">
                            </div>
                            <div class="col-7 mt-2">
                                <label class=""> Correo</label>
                                <input type="text" name="" value="${c.getCorreo()}" class="form-control col-4">
                            </div>
                            <div class="col-7 mt-2">
                                <label class=""> Teléfono</label>
                                <input type="text" name="" value="${c.getCelular()}" class="form-control col-4">
                            </div>
                            <div class="col-7 mt-2">
                                <label class=""> Descuento</label>
                                <input type="text" name="" value="${c.getDescuento()}" class="form-control col-4">
                            </div>
                        </div>
                        <div class="form-group mt-4 mb-2"> 
                            <label class="h3">Datos Producto </label>
                        </div>
                        <div class="form-group d-flex"> 
                             <div class="col-6">
                                <input type="text" name="codigoproducto" class="form-control" placeholder="codigo">
                            </div>
                            <div class="col-3">
                                <input type="submit" name="accion" value="Buscar Producto" class="btn btn-outline-info">
                            </div>
                          
                        </div>

                        <div class="form-group mt-4"> 
                                <div class="col-7 mt-2">
                                  <input type="text" name="nombreproducto" value="${pro.getNombre()}" placeholder="Datos Producto" class="form-control col-4">
                                </div>
                                <div class="col-7 mt-2">
                                    <label>Precio </label>
                                    <input type="text" name="precio" value="${pro.getPrecioV()}" class="form-control" placeholder="Q 0.00">
                                </div>
                            
                                <div class="col-7 mt-2">
                                    <label>Cantidad </label>
                                    <input type="number" name="cantidad" value="1" class="form-control">
                                </div>
                                <div class="col-7 mt-2">
                                    <label>Inventario </label>
                                    <input type="text" name="stock" value="${pro.getCantidad()}" class="form-control">
                                </div>
                        </div>

                        <div>
                            <button type="submit" name="accion" value="Agregar" class="btn btn-lg btn-outline-info mt-3">Agregar</button>
                            
                        </div>
                    </div>
                </form>
                </div>
            </div>
            <div class="col-lg-7 col-xs-12">   
                <div class="card">
                 <!--    <div class="card-body">
                        comment   <div class="d-flex col-lg-4 col-sm-4">
                            <label>Numero de Factura</label>
                            <input type="text" name="NroSerie" class="form-control"> 
                        </div> -->
                        <c:if test="${avisoVenta > 10}">
                        <script >
                          alert("Venta realizada");
                        </script>
                        </c:if>
                        <c:if test="${avisoVenta < 10}">
                        <script >
                          alert("Sin stock :(");
                        </script>
                        </c:if>
                        
                        <br>
                        <table class="table table-hover">
                                <thead>
                                <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>subtotal</th>
                                        <th>acciones</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdProducto()}</td>
                                        <td>${list.getDescripcion()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()} </td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>  
                                            <a class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Delete&id=${list.getIdProducto()}">Eliminar</a>
                                        </td>
                                       
                                </tr>
                                 </c:forEach>   
                                </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div class="col-6">
                            <a class="btn btn-info" id="btnGenerarVenta" href="Controlador?menu=NuevaVenta&accion=GenerarVenta">Generar Venta</a>
                            <a class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Cancelar">Cancelar</a>                      
                        </div>
                         <div class="col-3 ms-auto">
                             <label>Descuentos, comisiones e IVA icluidos</label>
                            <input type="text" name="total" value="Q. ${total}" class="form-control">                         
                        </div>
                    </div>
                </div>
            </div>
        </div>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
