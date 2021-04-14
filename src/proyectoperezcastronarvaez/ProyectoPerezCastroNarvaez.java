
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
        
        C_Login clogin = new C_Login(login, mlogin, admin, rUsuario, hcifrado, modSql, mod);
        clogin.iniciarC_Login();
        login.setVisible(true);
        
        
        
        
    }
    
}
