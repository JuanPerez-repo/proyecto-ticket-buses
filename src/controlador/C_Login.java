package controlador;

import modelo.M_Login;
import vista.Login;
import vista.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class C_Login implements ActionListener {

    private Login login;
    private Administrador admin;
    private M_Login m_login;

    public C_Login(Login login, M_Login m_login, Administrador admin) {
        this.login = login;
        this.m_login = m_login;
        this.admin = admin;
        this.login.jButtonAdmin.addActionListener(this);
    }

    public void iniciarC_Login() {
        login.setTitle("Login principal");
        login.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login.jButtonAdmin) {

            if (m_login.IniciarSesion(login.jTextUsername.getText(), login.jPassword.getText()) == true){
                login.show(false);
                admin.show(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.");
            }

        }
    }

}
