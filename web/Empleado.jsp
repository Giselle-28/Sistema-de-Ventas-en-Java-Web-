<%-- 
    Document   : Empleado
    Created on : 2 ago. 2023, 22:21:48
    Author     : PC-Comedor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="o" %>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
        <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Empleado" method="POST">
                    <div class="form-group">
                        <label>Dni</label>
                        <input type="text" name="txtDni" class="form-control">
                    </div> 
                    
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" name="txtNombres" class="form-control">
                    </div>
                    
                    <div class="form-group">
                        <label>Teléfono</label>
                        <input type="text" name="txtTel" class="form-control">
                    </div>
                    
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="text" name="txtEst" class="form-control">
                    </div>
                    
                    <div class="form-group">
                        <label>Usuario</label>
                        <input type="text" name="txtUsuario" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info mt-4">
                </form>
            </div>
        </div>
        
        
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>           
               
                    <tr>               
    <th>DNI</th>
    <th>NOMBRES</th>
    <th>TELEFONO</th>
    <th>ESTADO</th>
    <th>USER</th>
    <th>ACCIONES</th>
    
  </tr>
                </thead>
  <tbody>
  
  <o:forEach var="em" items="${empleados}">
     
      <tr>
    <td>${em.getId()}</td>
    <td>${em.getDni()}</td>
    <td>${em.getNom()}</td>
    <td>${em.getTel()}</td>
    <td>${em.getEstado()}</td>
    <td>${em.getUser()}</td>
    <td>
        <a>Editar</a>
         <a>Eliminar</a>
    </td>
    
    </tr> 
  </o:forEach>
  </tbody>
  
 
</table>
        </div>
            
        </div>
        
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>  
    </body>
</html>
