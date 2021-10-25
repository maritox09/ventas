
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">PRIMER SISTEMA DE VENTAS</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                  <li class="nav-item">
                    <a class="nav-link active" href="Controlador?menu=Home" target="myframe">Home</a>
                  </li>
                   <li class="nav-item">
                       <a class="nav-link" href="Controlador?menu=Producto&accion=Listar" target="myframe">Producto</a>
                  </li>
                  <li class="nav-item">
                       <a class="nav-link" href="Controlador?menu=Inventario&accion=Listar" target="myframe">Inventarios</a>
                  </li>
                   <li class="nav-item">
                       <a class="nav-link" href="Controlador?menu=Marca&accion=Listar" target="myframe">Marcas</a>
                  </li>
                   <li class="nav-item">
                    <a class="nav-link" href="Controlador?menu=Cliente&accion=Listar" target="myframe">Clientes</a>
                  </li>
                   <li class="nav-item">
                    <a class="nav-link" href="Controlador?menu=Pedido&accion=Listar" target="myframe">Pedidos</a>
                  </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Venta&accion=Listar" target="myframe">Ventas</a>
                    </li>

                  <c:if test="${tipo==2}">
                         <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Empleado&accion=Listar" target="myframe">Empleados</a>
                         </li>
                      <li class="nav-item">
                          <a class="nav-link" href="Controlador?menu=Fabrica&accion=Listar" target="myframe">Fabricas</a>
                      </li>
                  </c:if>
                    <li class="nav-item">
                    <a class="btn btn-outline-dark " href="Controlador?menu=NuevaVenta&accion=Listar" target="myframe">Nueva Venta</a>
                  </li>
                 
                  
                   
                </ul>
                 <div class="dropdown col-2 ">
                    <button class="btn btn-outline-light dropdown-toggle mr-5" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                      Usuario
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="#">${empleado.getNombre()} </a></li>
                      <li><a class="dropdown-item" href="#"> ${empleado.getCorreo()}</a></li>
                      <li><a class="dropdown-item" href="#"> ${empleado.getRango()}</a></li>
                      <div class="dropdown-divider"></div>
                      <li>
                          <form action="Validar" method="POST">
                              <button value="Salir" name="accion" class="dropdown-item" href="#" >Salir</button>
                          </form>
                      </li>
                    </ul>
                 </div>
              </div>
            </div>
        </nav>
              
        <div class="m-4" style="height: 740px">
            <iframe name="myframe" style="height: 100%; width: 100%"> </iframe>
             
        </div>
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
