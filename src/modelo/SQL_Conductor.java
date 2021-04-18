package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQL_Conductor extends Conexion {
  
    public boolean anadirConductor(Conductor conductor) {

        PreparedStatement ps = null;

        Connection con = getConexion();

        String sql = "INSERT INTO conductor (id_conductor, nombres, apellidos, fecha_nacimiento) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, conductor.getId_cond());

            ps.setString(2, conductor.getNombres_cond());

            ps.setString(3, conductor.getApellios_cond());

            ps.setString(4, conductor.getF_naci_cond());

            ps.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQL_Conductor.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }
   
}
