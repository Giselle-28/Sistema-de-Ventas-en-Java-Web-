
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    
    public Empleado validar(String user, String dni){
         System.out.println("Ahora estamos en emplado Dao con User: "+user);
         System.out.println("Ahora estamos en emplado Dao con Dni: "+dni);
           Empleado em=new Empleado();
           String sql= "select * from empleado where User=? and Dni=?";
           try {
               con=cn.Conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, user);
               ps.setString(2, dni);
               rs=ps.executeQuery();
               System.out.println("La variable RS tiene la mierda que devolvio la consulta: "+rs);
               while (rs.next()){
                   em.setId(rs.getInt("IdEmpleado"));
                   em.setUser(rs.getString("User"));
                   em.setDni(rs.getString("Dni"));
                   em.setNom(rs.getString("Nombres"));
                   
               }
           
           } catch (SQLException e){
           
           }
           return em;
    }

    
    public List listar(){
        String sql="select * from empleado";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                 em.setDni(rs.getString(2));
                 em.setNom(rs.getString(3));
                 em.setTel(rs.getString(4));
                 em.setEstado(rs.getString(5));
                 em.setUser(rs.getString(6));
                 lista.add(em);
            }
        } catch (SQLException e){
        }
        return lista;
    }
    
    public int agregar(Empleado em){
    String sql="insert into empleado (Dni, Nombres, Telefono, Estado, User) values (?,?,?,?,?)";
    try {
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        ps.setString(1, em.getDni());
        ps.setString(2, em.getNom());
        ps.setString(3, em.getTel());
        ps.setString(4, em.getEstado());
        ps.setString(4, em.getUser());
        ps.executeUpdate();
        
    } catch(SQLException e) {
    
    }
    return r;
    
    }
    
    public Empleado ListarId(int id){
        Empleado emp=new Empleado();
        String sql="select * from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                emp.setDni(rs.getNString(2));
                emp.setNom(rs.getNString(3));
                emp.setTel(rs.getNString(4));
                emp.setEstado(rs.getNString(5));
                emp.setUser(rs.getNString(6));
                
            }
            
        }  catch(SQLException e){
            
            
        }
        return emp;
    
    }
    public int actualizar(Empleado em){
         String sql="update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
    try {
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        ps.setString(1, em.getDni());
        ps.setString(2, em.getNom());
        ps.setString(3, em.getTel());
        ps.setString(4, em.getEstado());
        ps.setString(5, em.getUser());
        ps.setInt(6, em.getId());
        ps.executeUpdate();
        
    } catch(SQLException e) {
    
    }
    return r;
    }
    
    public void eliminar(int id){
        String sql="delete from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }  catch(SQLException e){
            
            
        }
    }

    public void editar(Empleado em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
