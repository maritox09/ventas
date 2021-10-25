
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="container mt-4 col-lg-4">  
            <div class="card-body card mt-5">
                <div class="m-2">
                    <form action="Validar" method="POST">  
                        <div class="form-group text-center">
                            <h3>DEV</h3>
                        </div>
                        <div class="form-group mt-3">
                            <label>Usuario:</label>
                            <input type="text" name="usuario" class="form-control">
                        </div>
                         <div class="form-group mt-3">
                            <label>Contraseña:</label>
                            <input type="password" name="pass" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Ingresar" class=" mt-4 btn btn-primary btn-lg col-12">
                    </form>
                </div>
            </div>
        </div>
        
    </body>
</html>
