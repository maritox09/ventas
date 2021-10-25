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
             <div class="card col-sm-5 col-lg-3">
                <div class="card-body">
                    <form action="Controlador?menu=Inventario" method="POST">
                        <div class="form-group">
                            <label>Stock de inventario</label>
                            <input type="text" value="${datosI.getCantidad()}" name="cantidad" class="form-control">
                            <input name="id" type="hidden" value="${datosI.getId()}">
                        </div>
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-info mt-3">
                    </form>
                </div>
            </div>
            <div class="col-sm-7 col-lg-8 m-2">
                 <table class="table ">
                    <thead>
                        
                      <tr>
                        <th>Codigo del inventario</th>
                        <th>Nombre del producto</th>
                        <th>Cantidad en Stock</th>
                        <th>Acciones</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="in" items="${inventarios}">
                      <tr>
                        <td>${in.getId()}</td>
                        <td>${in.getNombreProducto()}</td>
                        <td>${in.getCantidad()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Inventario&accion=Editar&id=${in.getId()}">Actualizar Stock</a>
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
