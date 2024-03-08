

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
 
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
            <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="Controlador?menu=Producto" target="myframe">Producto</a>
        </li>
        <li class="nav-item">
          <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myframe">Empleado</a>
        </li>
         <li class="nav-item">
          <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="Controlador?menu=Clientes" target="myframe">Clientes</a>
        </li>
        <li class="nav-item">
           <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta" target="myframe">Nueva Venta</a>
        </li>
        
      </ul>
        
       <div class="dropdown">
  <button style="margin-left: 600px; border: none;" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
      ${usuario.getNom()}</button>

           <div style="margin-left: 600px; border: none;" class="dropdown-menu text-center" >
      <a class="dropdown-item" href="#">
          <img src="img/usuario-logo.png" alt="60" width="60"/>
      </a>
    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
    <a class="dropdown-item" href="#">usuario@gmail.com</a>
    <div class="dropdown-divider"></div>
    <form action="Validar" method="POST">
        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
    </form>
  </div>
</div>
        
    </div>
</nav>
    
    <div class="m-4" style="height: 550px;">
        <iframe name="myframe" width="100%" height="100%" style="border: none;">
</iframe>
    </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
