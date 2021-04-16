package controlador;

import modelo.M_Login;
import vista.Login;
import vista.Administrador;
import vista.CrearUsuario; //En el video 18 el wey lo llama Registro a esta vista.
import modelo.SQL_Cliente; //consulta cliente
import modelo.Cliente;//
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.util.Objects.hash; //cifrado de contraseña
import javax.swing.JOptionPane;
import modelo.hash;//cifrado de contraseña

public class C_Login implements ActionListener {

    private Login login;
    private Administrador admin;
    private M_Login m_login;
    private CrearUsuario registroUsuario;
    private hash cifrado; //
    private SQL_Cliente clientesql; //
    private Cliente cli; //

    public C_Login(Login login, M_Login m_login, Administrador admin, CrearUsuario registroUsuario, hash cifrado, SQL_Cliente clientesql, Cliente cli) {

        this.login = login;
        this.m_login = m_login;
        this.admin = admin;
        this.registroUsuario = registroUsuario;
        this.cifrado = cifrado;//
        this.clientesql = clientesql;//
        this.cli = cli;//
        this.login.jButtonAdmin.addActionListener(this);
        this.login.jButtonRegistroUsuario.addActionListener(this);
        this.login.jButtonExit.addActionListener(this);
        this.login.jButtonUsuario.addActionListener(this);
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
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.","Información", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource() == login.jButtonRegistroUsuario) {//BOTON DE LOGIN --> CREARUSUARIO
            login.setVisible(false);

            iniciarC_RegistroUsuario();
            registroUsuario.setVisible(true);

        } else if (e.getSource() == login.jButtonExit) { //BOTON DE LOGIN --> SALIR DEL PROGRAMA
            System.exit(0);
        } else if (e.getSource() == registroUsuario.jButtonR_Usuario_Volver) { // BOTON DE CREARUSUARIO --> LOGIN
            registroUsuario.setVisible(false);

            iniciarC_Login();
            login.setVisible(true);
        } else if (e.getSource() == registroUsuario.jButtonCrearUser) { // BOTON DE CREARUSUARIO --> CREAR USUARIO

            String date = (String) registroUsuario.jComboBoxYearNacimientoCliente.getSelectedItem() + "/" + (String) registroUsuario.jComboBoxMesNacimientoCliente.getSelectedItem() + "/" + (String) registroUsuario.jComboBoxDiaNacimientoCliente.getSelectedItem();

            String pass_cliente = new String(registroUsuario.jPasswordClienteCrear.getPassword());

            String passCon_cliente = new String(registroUsuario.jPasswordConfirmarCliente.getPassword());

            if (registroUsuario.jTextNombresCliente.getText().equals("") || registroUsuario.jTextIdCliente.getText().equals("")
                    || passCon_cliente.equals("") || registroUsuario.jTextApellidosCliente.getText().equals("")
                    || registroUsuario.jTextCorreoCliente.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Hay campos vacíos, por favor rellenar todos los campos.", "Información", JOptionPane.WARNING_MESSAGE);

            } else {

                if (pass_cliente.equals(passCon_cliente)) {

                    if (clientesql.existeUsuario(registroUsuario.jTextIdCliente.getText()) == 0) {

                        if (clientesql.esEmail(registroUsuario.jTextCorreoCliente.getText())) {

                            String nuevoPass = hash.sha1(pass_cliente);

                            cli.setId_cliente(Integer.parseInt(registroUsuario.jTextIdCliente.getText())); //valor por default, pero entonces como agarro los valores de la caja ?

                            cli.setNombres_cliente(registroUsuario.jTextNombresCliente.getText());

                            cli.setContrasena(nuevoPass);

                            cli.setApellidos_cliente(registroUsuario.jTextApellidosCliente.getText());

                            cli.setF_naci_cliente(date);

                            cli.setCorreo_cliente(registroUsuario.jTextCorreoCliente.getText());

                            if (clientesql.RegistrarCliente(cli)) {

                                JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);

                                registroUsuario.jPasswordClienteCrear.setText("");
                                registroUsuario.jPasswordConfirmarCliente.setText("");
                                registroUsuario.jTextNombresCliente.setText("");
                                registroUsuario.jTextIdCliente.setText("");
                                registroUsuario.jTextCorreoCliente.setText("");
                                registroUsuario.jTextApellidosCliente.setText("");

                            } else {

                                JOptionPane.showMessageDialog(null, "Error al registar al cliente.", "Información", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {

                            JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Información", JOptionPane.WARNING_MESSAGE);

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "La ID ingresada ya está registrada. Por favor, ingrese con otra identificación.", "Información", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Por favor, ingrese nuevamente las contraseñas.", "Información", JOptionPane.WARNING_MESSAGE);
                }

            }

        } else if (e.getSource() == login.jButtonUsuario) { // BOTON DE LOGEARSE COMO USUARIO --> LOGIN

        }
    }
}
