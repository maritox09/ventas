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
             <div class="card col-sm-5 col-lg-4">
                <div class="card-body">
                    <form action="Controlador?menu=Pedido" method="POST">

                        <div class="form-group d-flex mb-4">
                            <div class="col-12">
                                <label>Fabrica </label>
                                <input list="fabricas" name="nombreF" value="${fabricaSeleecionada}" class="form-control mb-2"/>
                                <datalist id="fabricas">
                                    <c:forEach var="pro" items="${fabricas}">
                                    <option value="${pro.getNombref()}">
                                        </c:forEach>
                                </datalist>
                                <input type="submit" name="accion" value="Listar Inventario" class="btn btn-outline-info">
                            </div>

                        </div>
                        <div class="form-group">
                            <label>Modelo del producto </label>
                            <input list="items" name="modelo" class="form-control"/>
                            <datalist id="items">
                                <c:forEach var="pro" items="${modelos}">
                                <option value="${pro.getNombre()}">
                                    </c:forEach>
                            </datalist>
                        </div>
                        <div class="form-group">
                            <label>Cantidad</label>
                            <input type="text" name="cantidad" class="form-control">
                        </div>

              
                        <input type="submit" name="accion" value="Relizar Pedido" class="btn btn-info mt-3">
                    </form>
                </div>
            </div>
            <div class="col-sm-7 col-lg-8 m-2">
                <c:if test="${envio ==true}">
                    <script >
                        alert("pedido enviado a fábrica");
                    </script>
                </c:if>
                <c:if test="${envio==false}">
                    <script >
                        alert("Error :(");
                    </script>
                </c:if>
                <table class="table ">
                    <thead>
                        
                      <tr>
                        <th>Codigo producto</th>
                        <th>Fecha de emisión</th>
                        <th>Fecha de entrega</th>
                        <th>Cantidad</th>
                        <th>Estado del pedido</th>
                        <th>Fabrica</th>
                        <th>Acciones</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="mr" items="${pedidos}">
                      <tr>
                        <td>${mr.getIdproducto()}</td>
                        <td>${mr.getFechapedido()}</td>
                        <td>${mr.getFechaentrega()}</td>
                        <td>${mr.getCantidad()}</td>
                        <td>${mr.getEstado()}</td>
                        <td>${mr.getNombreFabrica()}</td>
                          <td>
                            <c:if test="${mr.getEstadoId() ==1}">
                                <a class="btn btn-warning" href="Controlador?menu=Pedido&accion=Cancelar&id=${mr.getIdpedido()}&ordenId=${mr.getNumeroOrden()}">Cancelar</a>
                        </c:if>
                            <c:if test="${mr.getEstadoId() ==2}">
                               <a class="btn btn-success" href="Controlador?menu=Pedido&accion=Recibido&id=${mr.getIdpedido()}&ordenId=${mr.getNumeroOrden()}">Recibido</a>
                            </c:if>

                        </td>
                      </tr>
                      </c:forEach>                        
                    </tbody>
                </table>    
            </div>
                   
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
