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
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Codigo</label>
                            <input type="number" value="${datosP.getId()}" name="id" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${datosP.getNombre()}" name="nombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio de Lista</label>
                            <input type="number" value="${datosP.getPrecioL()}" name="precioL" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Memoria</label>
                            <input type="number" value="${datosP.getMemoria()}" name="memoria" class="form-control">
                        </div>        
                        <div class="form-group">
                            <label>Almacenamiento</label>
                            <input type="number" value="${datosP.getAlmacenamiento()}" name="almacenamiento" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Procesador</label>
                            <input type="text" value="${datosP.getProcesador()}" name="procesador" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Cores</label>
                            <input type="number" value="${datosP.getCores()}" name="cores" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Descripción</label>
                            <input type="text" value="${datosP.getDescripcion()}" name="descripcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Color</label>
                            <input type="text" value="${datosP.getColor()}" name="color" class="form-control">
                        </div>
                         <input type="hidden" value="${datosP.getIdFabrica()}" name="idfabrica" class="form-control">
                        <div class="form-group">
                            <label>Marca</label>
                            <input list="items" value="${datosP.getMarca()}" name="marca" class="form-control"/>
                            <datalist id="items">
                              <c:forEach var="pro" items="${marcas}">
                              <option value="${pro.getNombrem()}">
                              </c:forEach>    
                            </datalist>
                        </div>
                        <div class="form-group">
                            <label>Fabrica</label>
                            <input list="items2" value="${datosP.getNombreFabrica()}" name="fabrica" class="form-control"/>
                            <datalist id="items2">
                                <c:forEach var="pro" items="${fabricas}">
                                <option value="${pro.getNombref()}"></c:forEach>
                            </datalist>
                        </div>
                        <div class="form-group">
                            <label>URL de primera imagen</label>
                            <input type="text" value="${datosP.getImagen1()}" name="img1" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>URL de segunda imagen</label>
                            <input type="text" value="${datosP.getImagen2()}" name="img2" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>URL de tercera imagen</label>
                            <input type="text" value="${datosP.getImagen3()}" name="img3" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info mt-3">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-info mt-3">
                    </form>
                </div>
            </div>
            <div class="col-sm-7 col-lg-8 m-2">
                <table class="table">
                    <thead>
                        
                      <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Marca</th>
                        <th>Precio Lista</th>
                        <th>Memoria</th>
                        <th>Almacenamiento</th>
                        <th>Procesador</th>
                        <th>Cores</th>
                        <th>Descripción</th>
                        <th>Color</th>
                        <th>Precio Venta</th>
                          <th>Fabrica</th>
                        <th colspan="3">Imágenes</th>
                        <th colspan="2">Acciones</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="pro" items="${productos}">
                      <tr>
                        <td>${pro.getId()}</td>
                        <td>${pro.getNombre()}</td>
                        <td>${pro.getMarca()}</td>
                        <td>${pro.getPrecioL()}</td>
                        <td>${pro.getMemoria()}</td>
                        <td>${pro.getAlmacenamiento()}</td>
                        <td>${pro.getProcesador()}</td>
                        <td>${pro.getCores()}</td>
                        <td>${pro.getDescripcion()}</td>
                        <td>${pro.getColor()}</td>
                        <td>${pro.getPrecioV()}</td>
                        <td>${pro.getNombreFabrica()}</td>
                        <td>    
                            <img src="${pro.getImagen1()}" height="100px">
                        </td>
                        <td>    
                            <img src="${pro.getImagen2()}" height="100px">
                        </td>
                        <td>    
                            <img src="${pro.getImagen3()}" height="100px">
                        </td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pro.getId()}">Editar</a>
                        </td>
                        <td>
                             <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pro.getId()}">Eliminar</a>
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

