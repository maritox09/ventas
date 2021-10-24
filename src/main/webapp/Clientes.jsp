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
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>Codigo</label>
                            <input type="text" value="${datosC.getId()}" name="id" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${datosC.getNombre()}" name="nombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NIT</label>
                            <input type="number" value="${datosC.getNit()}" name="nit" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" value="${datosC.getCorreo()}" name="correo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Número de teléfono</label>
                            <input type="text" value="${datosC.getCelular()}" name="celular" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>URL patente de comercio</label>
                            <input type="text" value="${datosC.getPatente()}" name="patente" class="form-control">
                        </div>  
                        <div class="form-group">
                            <label>Tipo de Subscripción</label>
                            <input list="items" value="${datosC.getRango()}" name="suscripcion" class="form-control"/>
                            <datalist id="items">
                              <option value="Mayorista">
                              <option value="Distribuidor">
                            </datalist>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info mt-3">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-info mt-3">
                    </form>
                </div>
            </div>
            <div class="col-sm-7 col-lg-8 m-2">
                <table class="table ">
                    <thead>
                        
                      <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>NIT</th>
                        <th>Correo Electrónico</th>
                        <th>Celular</th>
                        <th>Patente</th>
                        <th>Suscripcion</th>
                        <th>Acciones</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="cl" items="${clientes}">
                      <tr>
                        <td>${cl.getId()}</td>
                        <td>${cl.getNombre()}</td>
                        <td>${cl.getNit()}</td>
                        <td>${cl.getCorreo()}</td>
                        <td>${cl.getCelular()}</td>
                        <td>
                            <img src="${cl.getPatente()}" height="100px">
                        </td>
                        <td>${cl.getRango()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cl.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${cl.getId()}">Eliminar</a>
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
