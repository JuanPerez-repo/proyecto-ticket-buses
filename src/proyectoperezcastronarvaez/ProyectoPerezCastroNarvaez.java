
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
        InfoRutaBuses rutaBuses = new InfoRutaBuses();
        SQL_Conductor modSqlCond = new SQL_Conductor();
        Conductor modCond = new Conductor();
        ComprarTicketBus cTB = new ComprarTicketBus();
        Buses modbus = new Buses();
        SQL_Buses modSqlbus = new SQL_Buses();
        Rutas rutas = new Rutas();
        SQL_Rutas rutassql = new SQL_Rutas();
        PagoTicket pagoticket = new PagoTicket();
        ReservaTicket reservaticket = new ReservaTicket();
        SQL_ReservaTicket reservaticketsql = new SQL_ReservaTicket();
        
        C_Login clogin = new C_Login(login, mlogin, admin, rUsuario, hcifrado, modSql, mod, user, conductor, buses, rutaBuses, modCond, modSqlCond, cTB, modbus, modSqlbus, rutassql, rutas, pagoticket, reservaticket, reservaticketsql);
        clogin.iniciarC_Login();
        login.setVisible(true);
        
        
        
        
    }
    
}
