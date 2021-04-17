
package proyectoperezcastronarvaez;
import controlador.*;
import modelo.*;
import vista.*;

public class ProyectoPerezCastroNarvaez {


    public static void main(String[] args) {
        
        Login login = new Login();
        Administrador admin = new Administrador();
        M_Login mlogin = new M_Login();
        CrearUsuario rUsuario = new CrearUsuario();
        hash hcifrado = new hash();
        SQL_Cliente modSql = new SQL_Cliente(); 
        Cliente mod = new Cliente();
        Usuario user = new Usuario();
        InfoConductor conductor = new InfoConductor();
        InfoBuses buses = new InfoBuses();
        InfoRutaBuses ruta_buses = new InfoRutaBuses();
        
        C_Login clogin = new C_Login(login, mlogin, admin, rUsuario, hcifrado, modSql, mod, user, conductor, buses, ruta_buses);
        clogin.iniciarC_Login();
        login.setVisible(true);
        
        
        
        
    }
    
}
