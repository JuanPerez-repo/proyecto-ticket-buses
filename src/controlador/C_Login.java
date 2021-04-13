package controlador;

import modelo.M_Login;
import vista.Login;
import vista.Administrador;
import vista.CrearUsuario; //En el video 18 el wey lo llama Registro a esta vista.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class C_Login implements ActionListener {

    private Login login;
    private Administrador admin;
    private M_Login m_login;
    private CrearUsuario registroUsuario;
    

    public C_Login(Login login, M_Login m_login, Administrador admin, CrearUsuario registroUsuario) {
        this.login = login;
        this.m_login = m_login;
        this.admin = admin;
        this.registroUsuario = registroUsuario;
        this.login.jButtonAdmin.addActionListener(this);
        this.login.jButtonRegistroUsuario.addActionListener(this);
        this.login.jButtonExit.addActionListener(this);
        this.registroUsuario.jButtonR_Usuario_Volver.addActionListener(this);
        this.registroUsuario.jButtonCrearUser.addActionListener(this);
        

    }

    public void iniciarC_Login() {
        login.setTitle("Login principal");
        login.setLocationRelativeTo(null);
    }
    
        public void iniciarC_RegistroUsuario() {
        registroUsuario.setTitle("Registro de usuario");
        registroUsuario.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) { //OPCIONES DE TODOS LOS BOTONES DEL PROGRAMA

        if (e.getSource() == login.jButtonAdmin) { //BOTON DE LOGIN --> ADMINISTRADOR

            String usuario = login.jTextUsername.getText();
            String pass = new String(login.jPassword.getPassword());

            if (m_login.IniciarSesion(usuario, pass) == true) {
                login.setVisible(false);
                admin.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.");
            }

        } else if (e.getSource() == login.jButtonRegistroUsuario) {//BOTON DE LOGIN --> CREARUSUARIO
            login.setVisible(false);
            
            iniciarC_RegistroUsuario();
            registroUsuario.setVisible(true);
            
        } else if (e.getSource() == login.jButtonExit) { //BOTON DE LOGIN --> SALIR DEL PROGRAMA
            System.exit(0);
        } else if (e.getSource() == registroUsuario.jButtonR_Usuario_Volver){ // BOTON DE CREARUSUARIO --> LOGIN
            registroUsuario.setVisible(false);
            
            iniciarC_Login();
            login.setVisible(true);
        } else if (e.getSource() == registroUsuario.jButtonCrearUser){ // BOTON DE CREARUSUARIO --> CREAR USUARIO
             
            
            
            
            
        }
    }

}
