package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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

    public void seleccionar_IDs(JComboBox cbox_id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT id_conductor FROM conductor";

        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            cbox_id.addItem("Seleccione ID");

            while (rs.next()) {
                cbox_id.addItem(rs.getString("id_conductor"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL_Conductor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SQL_Conductor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public boolean buscarConductor(Conductor conductor) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT nombres, apellidos, fecha_nacimiento FROM conductor WHERE id_conductor = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, conductor.getId_cond());
            rs = ps.executeQuery();

            if (rs.next()) {

                conductor.setNombres_cond(rs.getString("nombres"));
                conductor.setApellios_cond(rs.getString("apellidos"));
                conductor.setF_naci_cond(rs.getString("fecha_nacimiento"));

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
                    Logger.getLogger(SQL_Conductor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public boolean eliminarConductor(Conductor conductor) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM conductor WHERE id_conductor = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, conductor.getId_cond());
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
                    Logger.getLogger(SQL_Conductor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public boolean modificarConductor(Conductor conductor) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE conductor SET nombres=?, apellidos=?, fecha_nacimiento=? WHERE id_conductor=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, conductor.getNombres_cond());
            ps.setString(2, conductor.getApellios_cond());
            ps.setString(3, conductor.getF_naci_cond());
            ps.setInt(4, conductor.getId_cond());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al modificar: " + e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQL_Conductor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
        public List listar(){
        
        Connection con = getConexion();
        
        PreparedStatement ps = null;
        
        ResultSet rs;
        
        List<Conductor>datos=new ArrayList<>();
      
        String sql = "select * from conductor";
        
        try{
            
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Conductor driver=new Conductor();
                
                driver.setId_cond(rs.getInt(1));
                
                driver.setNombres_cond(rs.getString(2));
                
                driver.setApellios_cond(rs.getString(3));
                
                driver.setF_naci_cond(rs.getString(4));
                
                datos.add(driver);
            }
            
        }catch (Exception e){
            
        }
        return datos;
        
    }

}
