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
                        <th>Codigo</th>
                        <th>Codigo del Cliente</th>
                        <th>Codigo del empleado</th>
                        <th>Fecha</th>
                        <th>Monto total</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="mr" items="${ventas}">
                      <tr>
                        <td>${mr.getId()}</td>
                        <td>${mr.getIdCliente()}</td>
                        <td>${mr.getIdEmpleado()}</td>
                        <td>${mr.getFecha()}</td>
                        <td>${mr.getMonto()}</td>
                        <td>${mr.getEstado()}</td>
                        <td>
                            <a class="btn btn-info" href="Controlador?menu=Detalle&accion=Listar&id=${mr.getId()}">Ver Detalle</a>
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
