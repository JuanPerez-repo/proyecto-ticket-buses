
package proyectoperezcastronarvaez;
import controlador.*;
import modelo.*;
import vista.*;

public class ProyectoPerezCastroNarvaez {


    public static void main(String[] args) {
        
        Login login = new Login();
        Administrador admin = new Administrador();
        M_Login mlogin = new M_Login();
        
        C_Login clogin = new C_Login(login, mlogin, admin);
        clogin.iniciarC_Login();
        login.setVisible(true);
        
        
        
        
    }
    
}
