
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



public class Controlador extends HttpServlet {

            Empleado em=new Empleado();
            EmpleadoDAO edao=new EmpleadoDAO();
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu=request.getParameter("menu");
            System.out.println("ACA SALE MENU :"+menu);
            String accion=request.getParameter("accion");
             System.out.println("ACA SALE LA ACCION :"+accion);
            if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if(menu.equals("Empleado")){
                switch(accion){
                    case "Listar":
                        List lista=edao.listar();
                        request.setAttribute("empleados", lista);
                        break;
                    case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nom=request.getParameter("txtNombres");
                        String tel=request.getParameter("txtTel");
                        String est=request.getParameter("txtEst");
                        String user=request.getParameter("txtUsuario");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":

                    String idEditar = request.getParameter("idEmpleado"); // Asumiendo que tienes un campo oculto en tu formulario que almacena el ID del empleado a editar
                    String dniEditar = request.getParameter("txtDni");
                    String nomEditar = request.getParameter("txtNombres");
                    String telEditar = request.getParameter("txtTel");
                    String estEditar = request.getParameter("txtEst");
                    String userEditar = request.getParameter("txtUsuario");

                    em.setId(Integer.parseInt(idEditar));
                    em.setDni(dniEditar);
                    em.setNom(nomEditar);
                    em.setTel(telEditar);
                    em.setEstado(estEditar);
                    em.setUser(userEditar);

                    edao.editar(em); // Debes implementar este método en tu EmpleadoDAO para actualizar los datos del empleado en la base de datos
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                        
                
                    case "Eliminar":
                        
                        
                        break;
                        
                    default:
                        System.out.println("La accion es: "+accion);
                        
                         break;
                       // throw new AssertionError();
                }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
            if(menu.equals("Clientes")){
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            }
            if(menu.equals("Producto")){
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            if(menu.equals("NuevaVenta")){
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            
            
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void swich() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
