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
            <div class="card m-4">
                <table class="table ">
                    <thead>
                        
                      <tr>
                        <th>Codigo de venta</th>
                        <th>Codigo de producto</th>
                        <th>cantidad</th>
                        <th>Monto</th>
                        <th>Entregado/Por encargo</th>
                        <th>Cantidad por encargo</th>
                        <th>Acciones</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="mr" items="${detalleventas}">
                      <tr>
                        <td>${mr.getIdventa()}</td>
                        <td>${mr.getIdproducto()}</td>
                        <td>${mr.getCantidad()}</td>
                        <td>${mr.getMonto()}</td>
                        <td>${mr.getEstadoNombre()}</td>
                        <td>${mr.getEncargo()}</td>
                        <td>
                            <c:if test="${mr.getEstado() ==2}">
                                <a class="btn btn-warning" href="Controlador?menu=Detalle&accion=ActualizarEstado&id=${mr.getId()}">Entregado</a>
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
