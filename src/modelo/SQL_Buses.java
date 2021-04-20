package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQL_Buses extends Conexion {
    
    public boolean anadirBus(Buses bus) {

        PreparedStatement ps = null;

        Connection con = getConexion();

        String sql = "INSERT INTO autobus (id_autobus, modelo, placa) VALUES(?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, bus.getId_bus());

            ps.setString(2, bus.getModelo_bus());

            ps.setString(3, bus.getPlaca_bus());

            ps.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }
    
}
