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
                    <form action="Controlador?menu=Fabrica" method="POST">
                        <div class="form-group">
                            <input type="hidden" value="${datosF.getIdf()}" name="id" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${datosF.getNombref()}" name="nombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dominio</label>
                            <input type="text" value="${datosF.getDominio()}" name="dominio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${datosF.getUsuario()}" name="usuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="text" value="${datosF.getPass()}" name="pass" class="form-control">
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
                        <th>Nombre</th>
                        <th>Dominio</th>
                        <th>Usuario</th>
                        <th>Acciones</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="mr" items="${fabricas}">
                      <tr>
                        <td>${mr.getNombref()}</td>
                        <td>${mr.getDominio()}</td>
                        <td>${mr.getUsuario()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Fabrica&accion=Editar&id=${mr.getIdf()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Fabrica&accion=Delete&id=${mr.getIdf()}">Eliminar</a>
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
