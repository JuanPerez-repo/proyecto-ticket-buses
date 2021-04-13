package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.Administrador;

public class M_Login extends Conexion {

    private String usuario;

    private String contrasena;


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

    public boolean IniciarSesion(String usuario, String contrasena) {

        PreparedStatement ps = null;

        Connection con = getConexion();

        String sql = "SELECT usuario_ad, contrasena from administrador";


        try {

            ps = con.prepareStatement(sql);

            ResultSet result = ps.executeQuery();
            


            int i = 1;
            
            if (result.next()){
                if (usuario.equals(result.getString(1)) && contrasena.equals(result.getString(2))){
                    return true;
                } else {
                    return false;
                }
            }
            
            return false;
            

        } catch (SQLException e) {

            System.err.println("Hubo un error en la conexion: "+e);

            return false;

        } finally {

            try {

                con.close();

            } catch (SQLException e) {

                System.err.println("" +e);

            }

        }

    }

}
