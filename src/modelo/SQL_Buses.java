package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

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
    
    public void seleccionar_IDs_Bus(JComboBox cbox_id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT id_autobus FROM autobus";

        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            cbox_id.addItem("Seleccione ID");

            while (rs.next()) {
                cbox_id.addItem(rs.getString("id_autobus"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
    
    public boolean BuscarBus(Buses bus) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT modelo, placa FROM autobus WHERE id_autobus = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, bus.getId_bus());
            rs = ps.executeQuery();

            if (rs.next()) {

                bus.setModelo_bus(rs.getString("modelo"));
                bus.setPlaca_bus(rs.getString("placa"));
               
                return true;

            }

            return false;

        } catch (SQLException ex) {
            System.err.println("Hubo un error: " + ex);
            return false;
        } finally {

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
    
    public boolean eliminarBus(Buses bus) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM autobus WHERE id_autobus = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, bus.getId_bus());
            ps.execute();

            return true;

        } catch (SQLException ex) {
            System.err.println("Hubo un error: " + ex);
            return false;
        } finally {

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
    
     public boolean modificarBus(Buses bus){

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE autobus SET modelo=?, placa=? WHERE id_autobus=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, bus.getModelo_bus());
            ps.setString(2, bus.getPlaca_bus());
            ps.setInt(3, bus.getId_bus());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al modificar: " + e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
