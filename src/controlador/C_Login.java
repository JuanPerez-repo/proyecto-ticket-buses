package controlador;

import modelo.M_Login;
import vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class C_Login implements ActionListener{
    
private Login login;

private M_Login m_login;

    public C_Login(Login login, M_Login m_login) {
        this.login = login;
        this.m_login = m_login;
        this.login.jButtonAdmin.addActionListener(this);
    }
    
public void iniciarC_Login(){
        login.setTitle("Login principal");
        login.setLocationRelativeTo(null);
    }

public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == login.jButtonAdmin){
           
            m_login.IniciarSesion(login.jTextUsername.getText(), login.jPassword.getText());
            m_login.convertirDolares();
            login.jTextDolar.setText(String.valueOf(M_Login.getDolares()));
        
            if (m_login.IniciarSesion(usuario, contrasena))
        }
    }

}
