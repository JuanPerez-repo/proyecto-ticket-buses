package controlador;

import modelo.M_Login;
import vista.Login;
import vista.Administrador;
import vista.CrearUsuario;
import vista.Usuario;
import vista.InfoConductor;
import vista.InfoBuses;
import vista.InfoRutaBuses;
import vista.ComprarTicketBus;
import modelo.SQL_Cliente; //consulta cliente
import modelo.Cliente;//
import modelo.Conductor;
import modelo.SQL_Conductor;
import modelo.Buses;
import modelo.SQL_Buses;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private Usuario user;
    private InfoConductor conductor;
    private InfoBuses buses;
    private InfoRutaBuses ruta_buses;
    private Conductor cond;
    private SQL_Conductor conductorsql;
    private ComprarTicketBus cTB;
    private Buses bus;
    private SQL_Buses busql;

    public C_Login(Login login, M_Login m_login, Administrador admin, CrearUsuario registroUsuario, hash cifrado,
            SQL_Cliente clientesql, Cliente cli, Usuario user, InfoConductor conductor, InfoBuses buses,
            InfoRutaBuses ruta_buses, Conductor cond, SQL_Conductor conductorsql, ComprarTicketBus cTB,
            Buses bus, SQL_Buses busql) {

        this.login = login;
        this.m_login = m_login;
        this.admin = admin;
        this.registroUsuario = registroUsuario;
        this.cifrado = cifrado;//
        this.clientesql = clientesql;//
        this.cli = cli;//
        this.user = user;
        this.conductor = conductor;
        this.cond = cond;
        this.conductorsql = conductorsql;
        this.buses = buses;
        this.ruta_buses = ruta_buses;
        this.cTB = cTB; //Vista Comprar Ticket Bus
        this.bus = bus;
        this.busql = busql;
        
        this.login.jButtonAdmin.addActionListener(this);
        this.login.jButtonRegistroUsuario.addActionListener(this);
        this.login.jButtonExit.addActionListener(this);
        this.login.jButtonUsuario.addActionListener(this);
        this.registroUsuario.jButtonR_Usuario_Volver.addActionListener(this);
        this.registroUsuario.jButtonCrearUser.addActionListener(this);
        this.admin.jButtonAdminBus.addActionListener(this);
        this.admin.jButtonAdminConductor.addActionListener(this);
        this.admin.jButtonAdminInfoUsers.addActionListener(this);
        this.admin.jButtonAdminRuta.addActionListener(this);
        this.admin.jButtonAdminHelp.addActionListener(this);
        this.admin.jButtonAdminSalir.addActionListener(this);
        this.conductor.jButtonAnadirCond.addActionListener(this);
        this.conductor.jButtonVolverConductor.addActionListener(this);
        this.conductor.jButtonActualizarTablaConductores.addActionListener(this);
        this.conductor.jButtonBuscarIDsConductor.addActionListener(this);
        this.conductor.jButtonEliminarConductor.addActionListener(this);
        this.conductor.jButtonHelpConductor.addActionListener(this);
        this.conductor.jButtonVerIDsModificarConductor.addActionListener(this);
        this.conductor.jButtonModificarInfoConductor.addActionListener(this);
        this.conductor.jButtonVerIDsEliminarConductor.addActionListener(this);
        this.user.jButtonLogoutUser.addActionListener(this);
        this.user.jButtonReservarViaje.addActionListener(this);
        this.user.jButtonUserVerViajes.addActionListener(this);
        this.buses.jButtonAnadirBus.addActionListener(this);
        this.buses.jButtonEliminarBus.addActionListener(this);
        this.buses.jButtonHelpBus.addActionListener(this);
        this.buses.jButtonIDsModificarBus.addActionListener(this);
        this.buses.jButtonModificarBus.addActionListener(this);
        this.buses.jButtonTablaBus.addActionListener(this);
        this.buses.jButtonVerIDsEliminarBus.addActionListener(this);
        this.buses.jButtonVolverBus.addActionListener(this);
        this.ruta_buses.jButtonAgregarRutaBus.addActionListener(this);
        this.ruta_buses.jButtonVolverRutaBuses.addActionListener(this);
        this.cTB.jButtonCTB_Viajes.addActionListener(this);
        this.cTB.jButtonCTB_ReservarTicket.addActionListener(this);
        this.cTB.jButtonCTB_Volver.addActionListener(this);

    }

    private int ventanaLoginAdmin = 0;
    private int ventanaMainUsuario = 0;
    private int ventanaConductor = 0;
    private int ventanaCrearUser = 0;
    private int ventanaCrearBus = 0;
    private int ventanaCrearRuta = 0;
    private int ventanaCTB = 0;

    public void iniciarC_Login() {
        login.setTitle("Login principal");
        login.setLocationRelativeTo(null);
    }

    public void iniciarAdmin() {
        admin.setTitle("Aministrador | Principal");
        admin.setLocationRelativeTo(null);
    }

    public void iniciarC_RegistroUsuario() {
        registroUsuario.setTitle("Registro de usuario");
        registroUsuario.setLocationRelativeTo(null);
    }

    public void iniciarUsuario() {
        user.setTitle("Usuario | Principal");
        user.setLocationRelativeTo(null);
    }

    public void iniciarConductor() {
        conductor.setTitle("Admin | Agregar - modificar - eliminar información de conductor");
        conductor.setLocationRelativeTo(null);
    }

    public void iniciarBuses() {
        buses.setTitle("Admin | Agregar - modificar - eliminar información de los buses");
        buses.setLocationRelativeTo(null);
    }

    public void iniciarRuta() {
        ruta_buses.setTitle("Admin | Agregar rutas de buses");
        ruta_buses.setLocationRelativeTo(null);
    }

    public void iniciarCTB() {
        cTB.setTitle("Usuario | Reservar ticket");
        cTB.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) { //OPCIONES DE TODOS LOS BOTONES DEL PROGRAMA

        if (e.getSource() == login.jButtonAdmin) { //BOTON DE LOGIN --> ADMINISTRADOR

            String usuario = login.jTextUsername.getText();
            String pass = new String(login.jPassword.getPassword());

            if (m_login.IniciarSesion(usuario, pass) == true) {

                if (ventanaLoginAdmin == 0) {
                    iniciarAdmin();
                    ventanaLoginAdmin++;
                }

                login.setVisible(false);
                admin.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.", "Información", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource() == login.jButtonRegistroUsuario) {//BOTON DE LOGIN --> CREARUSUARIO

            if (ventanaCrearUser == 0) {
                iniciarC_RegistroUsuario();
                ventanaCrearUser++;
            }

            login.setVisible(false);
            registroUsuario.setVisible(true);

        } else if (e.getSource() == login.jButtonExit) { //BOTON DE LOGIN --> SALIR DEL PROGRAMA
            System.exit(0);
        } else if (e.getSource() == registroUsuario.jButtonR_Usuario_Volver) { // BOTON DE CREARUSUARIO --> LOGIN

            registroUsuario.setVisible(false);
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

            String pass = new String(login.jPassword.getPassword());

            if (!login.jTextUsername.getText().equals("") && !pass.equals("")) {

                String nuevoPass = hash.sha1(pass);

                cli.setId_cliente(Integer.parseInt(login.jTextUsername.getText()));

                cli.setContrasena(nuevoPass);

                if (clientesql.login(cli)) { //Cuando se ingresa exitosamente como usuario

                    if (ventanaMainUsuario == 0) {
                        iniciarUsuario();
                        ventanaMainUsuario++;
                    }

                    login.setVisible(false);
                    user.setVisible(true);
                    user.jLabelNombreUser.setText("¡Bienvenido, " + clientesql.obtenerNombreUsuario(cli) + "!");

                } else {

                    JOptionPane.showMessageDialog(null, " Error al ingresar.", "Información", JOptionPane.ERROR_MESSAGE);

                }

            } else {

                JOptionPane.showMessageDialog(null, " Por favor, rellenar todos los campos.", "Información", JOptionPane.WARNING_MESSAGE);

            }

        } else if (e.getSource() == user.jButtonLogoutUser) { //LOGOUT USUARIO (Usuario)

            user.setVisible(false);
            login.jTextUsername.setText("");
            login.jPassword.setText("");
            login.setVisible(true);

        } else if (e.getSource() == user.jButtonReservarViaje) {//BOTON COMPRAR TICKET BUS (Usuario)

            if (ventanaCTB == 0) {
                iniciarCTB();
                ventanaCTB++;
            }

            user.setVisible(false);
            cTB.setVisible(true);

        } else if (e.getSource() == user.jButtonUserVerViajes) {//VER PROXIMOS VIAJES (Usuario)

        } else if (e.getSource() == admin.jButtonAdminConductor) { //BOTON DE CREAR CONDUCTOR (ADMIN) --> INFOCONDUCTOR

            if (ventanaConductor == 0) {
                iniciarConductor();
                ventanaConductor++;
            }

            admin.setVisible(false);
            conductor.setVisible(true);

        } else if (e.getSource() == admin.jButtonAdminBus) { //BOTON DE BUS (Administrador)

            if (ventanaCrearBus == 0) {
                iniciarBuses();
                ventanaCrearBus++;
            }

            admin.setVisible(false);
            buses.setVisible(true);

        } else if (e.getSource() == admin.jButtonAdminHelp) { //joptionpane DE AYUDA PARA EL ADMIN (Administrador)

        } else if (e.getSource() == admin.jButtonAdminInfoUsers) { //BOTON PARA LLENAR LA TABLA CON TODOS LOS USUARIOS DENTRO DE LA BD (Administrador)

        } else if (e.getSource() == admin.jButtonAdminRuta) { //BOTON PARA AGREGAR RUTAS DE LOS BUSES (Administrador)

            if (ventanaCrearRuta == 0) {
                iniciarRuta();
                ventanaCrearRuta++;
            }

            admin.setVisible(false);
            ruta_buses.setVisible(true);

        } else if (e.getSource() == admin.jButtonAdminSalir) { //SALIR DE ADMIN PARA REGRESAR AL LOGIN

            admin.setVisible(false);
            login.setVisible(true);

        } else if (e.getSource() == conductor.jButtonAnadirCond) { //Botón de añadir a un conductor

            Date fechaConductor = conductor.jDateConductor.getDate();

            DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

            String DateDriver = formato.format(fechaConductor).toString();

            if (conductor.jTextConductor_id.getText().equals("") || conductor.jTextNombres_cond.getText().equals("")
                    || conductor.jTextApellidos_cond.getText().equals("") || conductor.jDateConductor.getCalendar().toString().equals("")) {

                JOptionPane.showMessageDialog(null, "Hay campos vacíos, por favor rellenar todos los campos.", "Información", JOptionPane.WARNING_MESSAGE);

            } else {

                cond.setId_cond(Integer.parseInt(conductor.jTextConductor_id.getText()));

                cond.setNombres_cond(conductor.jTextNombres_cond.getText());

                cond.setApellios_cond(conductor.jTextApellidos_cond.getText());

                cond.setF_naci_cond(DateDriver);

                if (conductorsql.anadirConductor(cond)) {

                    JOptionPane.showMessageDialog(null, "El conductor fue agregado a la base de datos de manera exitosa.");

                }

            }

        } else if (e.getSource() == conductor.jButtonVolverConductor) { //BOTON DE VOLVER DE CONDUCTOR A VENTANA PRINCIPAL DE ADMIN

            conductor.setVisible(false);
            admin.setVisible(true);

        } else if (e.getSource() == conductor.jButtonActualizarTablaConductores) { //ACTUALIZAR TABLA DE CONDUCTORES (InfoConductor)

        } else if (e.getSource() == conductor.jButtonBuscarIDsConductor) { //BUSCAR INFO POR LA ID DE UN CONDUCTOR (InfoConductor)

            conductor.jButtonModificarInfoConductor.setEnabled(true);

        } else if (e.getSource() == conductor.jButtonEliminarConductor) { //ELIMINA UN CONDUCTOR DE LA BD (InfoConductor)

        } else if (e.getSource() == conductor.jButtonHelpConductor) { //AYUDA PARA EL ADMIN EN LA INTERFAZ DE INFOCONDUCTOR

        } else if (e.getSource() == conductor.jButtonVerIDsModificarConductor) { //MUESTRA LAS IDS DE LOS CONDUCTORES EN EL COMBOBOX PARA MODIFICAR LUEGO (InfoConductor)

            conductor.jComboBuscarID.setEnabled(true);
            conductor.jButtonBuscarIDsConductor.setEnabled(true);

        } else if (e.getSource() == conductor.jButtonVerIDsEliminarConductor) { //MUESTRA LAS IDS DE LOS CONDUCTORES EN EL COMBOBOX PARA ELIMINAR LUEGO (InfoConductor)

        } else if (e.getSource() == buses.jButtonAnadirBus) {

            if(buses.jTextNumBus.getText().equals("") || buses.jTextPlaca.getText().equals("")){
                
                 JOptionPane.showMessageDialog(null, "Hay campos vacíos, por favor rellenar todos los campos.", "Error al añadir", JOptionPane.WARNING_MESSAGE);
                
            }else{
                
                bus.setId_bus(Integer.parseInt(buses.jTextNumBus.getText()));
                
                bus.setModelo_bus((String)buses.jComboBoxModeloBus.getSelectedItem());//sin probar aun (20-04-2021)
                
                bus.setPlaca_bus(buses.jTextPlaca.getText());
                
                if(busql.anadirBus(bus)){
                    
                     JOptionPane.showMessageDialog(null, "El autobus fue añadido exitosamente.");

                }
            }
            
        } else if (e.getSource() == buses.jButtonEliminarBus) {

        } else if (e.getSource() == buses.jButtonHelpBus) {

        } else if (e.getSource() == buses.jButtonIDsModificarBus) {

        } else if (e.getSource() == buses.jButtonModificarBus) {

        } else if (e.getSource() == buses.jButtonVolverBus) {

            buses.setVisible(false);
            admin.setVisible(true);

        } else if (e.getSource() == buses.jButtonVerIDsEliminarBus) {

        } else if (e.getSource() == ruta_buses.jButtonAgregarRutaBus) {

        } else if (e.getSource() == ruta_buses.jButtonVolverRutaBuses) {

            ruta_buses.setVisible(false);
            admin.setVisible(true);

        } else if (e.getSource() == cTB.jButtonCTB_Viajes) {

        } else if (e.getSource() == cTB.jButtonCTB_ReservarTicket) {

        } else if (e.getSource() == cTB.jButtonCTB_Volver) {
            
            cTB.setVisible(false);
            user.setVisible(true);
            
        }

    }
}
