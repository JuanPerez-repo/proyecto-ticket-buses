package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQL_Cliente extends Conexion {

    public boolean RegistrarCliente(Cliente cliente) {

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

    public boolean login(Cliente cliente) {

        PreparedStatement ps = null;

        ResultSet rs = null;

        Connection con = getConexion();

        String sql = "SELECT id, nombres, apellidos, contrasena FROM cliente WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, cliente.getId_cliente());

            rs = ps.executeQuery();

            if (rs.next()) {

                if (cliente.getContrasena().equals(rs.getString(4))) {

                    cliente.setId_cliente(rs.getInt(1));

                    cliente.setNombres_cliente(rs.getString(2));

                    cliente.setApellidos_cliente(rs.getString(3));

                    return true;

                } else {

                    return false;

                }

            }

            return false;

        } catch (SQLException ex) {
            System.err.println("Error la busqueda de una id repetida.");
            Logger.getLogger(SQL_Cliente.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    public String obtenerNombreUsuario(Cliente cliente) {

        PreparedStatement ps = null;

        ResultSet rs = null;

        Connection con = getConexion();

        String sql = "SELECT nombres, apellidos FROM cliente WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, cliente.getId_cliente());

            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString(1) + " " + rs.getString(2);

            }

            return null;

        } catch (SQLException ex) {
            System.err.println("Error, no se pudo obtener el nombre del usuario.");
            Logger.getLogger(SQL_Cliente.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }

    }

    public int existeUsuario(String id) {

        PreparedStatement ps = null;

        ResultSet rs = null;

        Connection con = getConexion();

        String sql = "SELECT count(id) FROM cliente WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1);

            }

            return 1;

        } catch (SQLException ex) {
            System.err.println("Error la busqueda de una id repetida.");
            Logger.getLogger(SQL_Cliente.class.getName()).log(Level.SEVERE, null, ex);

            return 1;
        }

    }

    public boolean esEmail(String correo) {

        //Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();

    }
    
        public List listar(){
        
        Connection con = getConexion();
        
        PreparedStatement ps = null;
        
        ResultSet rs;
        
        List<Cliente>datos=new ArrayList<>();
      
        String sql = "select * from cliente";
        
        try{
            
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Cliente cli=new Cliente();
                
                cli.setId_cliente(rs.getInt(1));    
                cli.setNombres_cliente(rs.getString(2));
                cli.setApellidos_cliente(rs.getString(3));
                cli.setF_naci_cliente(rs.getString(4));
                cli.setCorreo_cliente(rs.getString(5));
                cli.setContrasena(rs.getString(6));
                
                datos.add(cli);
            }
            
        }catch (Exception e){
            System.err.println("Hubo un error al listar los datos del Usuario: "+e);
        }
        return datos;
        
    }
}
