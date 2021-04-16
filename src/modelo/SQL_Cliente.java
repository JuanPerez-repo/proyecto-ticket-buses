package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SQL_Cliente extends Conexion {
    
    public boolean RegistrarCliente(Cliente cliente){
        
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "INSERT INTO cliente (id, nombres, apellidos, fecha_nacimiento, correo, contrasena) VALUES(?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, cliente.getId_cliente());
            
            ps.setString(2, cliente.getNombres_cliente());
            
            ps.setString(3, cliente.getApellidos_cliente());
            
            ps.setString(4, cliente.getF_naci_cliente());
            
            ps.setString(5, cliente.getCorreo_cliente());
            
            ps.setString(6, cliente.getContrasena());
            
            ps.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
    }
    
     public int existeUsuario (String cliente){
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        Connection con = getConexion();
        
        String sql = "SELECT count(id) FROM clientes WHERE cliente = ?";
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(3, cliente);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
            
            return rs.getInt(1);
            
            }
            
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            
            return 1;
        }
        
    }
    
     public boolean esEmail(String correo){
         
         //Patrón para validar el email
         
         Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
         
         Matcher mather = pattern.matcher(correo);
         
         return mather.find();
         
     }
}
