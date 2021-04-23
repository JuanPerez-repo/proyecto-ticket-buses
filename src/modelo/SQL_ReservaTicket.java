package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class SQL_ReservaTicket extends Conexion {

    public int seleccionarHorasRuta(JComboBox jcombohr, String origen, String destino, String fechaIngresada) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        int cont = 0;

        String sql = "SELECT hora FROM ruta WHERE origen =? AND destino =? AND fecha =?";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, fechaIngresada);

            rs = ps.executeQuery();

            jcombohr.addItem("Seleccione ID");

            while (rs.next()) {

                jcombohr.addItem(rs.getString("hora"));
                cont++;
            }

            return cont;

        } catch (SQLException ex) {
            Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);
            return cont;

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

    public boolean registroTicket(ReservaTicket reservaticket) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO ticket (nombres, apellidos, destino, asiento, id_cliente, id_ruta) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, reservaticket.getNombres());
            ps.setString(2, reservaticket.getApellidos());
            ps.setString(3, reservaticket.getDestino());
            ps.setInt(4, reservaticket.getAsiento());
            ps.setInt(5, reservaticket.getId_cliente());
            ps.setInt(6, reservaticket.getId_ruta());

            ps.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQL_ReservaTicket.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    public void mostrarTicketsComprados(int id_cliente) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM ticket JOIN ruta ON ruta.id_ruta = ticket.id_ruta WHERE ticket.id_cliente =?";
        String datos = "";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();

            while (rs.next()) {

                datos = "";
                datos += "Id del ticket: " + rs.getString("id_ticket") + "\n";
                datos += "Origen y destino: " + rs.getString("destino") + "\n";
                datos += "Asiento: " + rs.getString("asiento") + "\n";
                datos += "Fecha y hora: " + rs.getString("fecha") + " " + rs.getString("hora");

                JOptionPane.showMessageDialog(null, datos);

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

    public int cantidadTicketsCliente(int id_cliente) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT COUNT(*) AS totaltickets FROM ticket where id_cliente =?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("totaltickets");

            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SQL_Buses.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }

        }
        return 0;

    }

}
