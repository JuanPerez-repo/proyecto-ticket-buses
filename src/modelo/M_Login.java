
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.Administrador;

public class M_Login extends Conexion {
    
    private String usuario;
    
    private String contrasena;

    public M_Login(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

     public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
    public boolean IniciarSesion(String usuario, String contrasena){
        
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "SELECT * FROM administrador";
        
        try{
            
            ps = con.prepareStatement(sql);
            
            ResultSet result = ps.executeQuery();
            
            String [] array = new String [1];
            
            int i = 0;
            

            
            while(result.next()){
                
                array[i] = result.getString(i);
                
                i++;
                
            }
            
            if (usuario.equals(array[0]) && contrasena.equals(array[1])){
                
                return true;
                
            }else{
                
                return false;
            }
         
            
            
        }catch(SQLException e){
            
            System.err.println(e);
            
             return false;
            
        } finally{
            
            try{
                
                con.close();
                
            }catch(SQLException e){
                
                System.err.println(e);
                
            }
            
        }
        
}

   

    
    
}