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
import vista.PagoTicket;
import modelo.SQL_Cliente; //consulta cliente
import modelo.Cliente;//
import modelo.Conductor;
import modelo.SQL_Conductor;
import modelo.Buses;
import modelo.SQL_Buses;
import modelo.SQL_Rutas;
import modelo.Rutas;
import modelo.SQL_ReservaTicket;
import modelo.ReservaTicket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import static java.util.Objects.hash; //cifrado de contraseña
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    private Rutas rutas;
    private SQL_Rutas rutassql;
    private Conductor cond;
    private SQL_Conductor conductorsql;
    private ComprarTicketBus cTB;
    private Buses bus;
    private SQL_Buses busql;
    private PagoTicket pagoticket;
    private ReservaTicket reservaticket;
    private SQL_ReservaTicket reservaticketsql;

    DefaultTableModel modeloBus = new DefaultTableModel();
    DefaultTableModel modeloCliente = new DefaultTableModel();
    DefaultTableModel modeloConductor = new DefaultTableModel();

    public C_Login(Login login, M_Login m_login, Administrador admin, CrearUsuario registroUsuario, hash cifrado,
            SQL_Cliente clientesql, Cliente cli, Usuario user, InfoConductor conductor, InfoBuses buses,
            InfoRutaBuses ruta_buses, Conductor cond, SQL_Conductor conductorsql, ComprarTicketBus cTB,
            Buses bus, SQL_Buses busql, SQL_Rutas rutassql, Rutas rutas, PagoTicket pagoticket,
            ReservaTicket reservaticket, SQL_ReservaTicket reservaticketsql) {

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
        this.ruta_buses = ruta_buses;//Vista InfoRutaBuses
        this.rutas = rutas;
        this.rutassql = rutassql;
        this.cTB = cTB; //Vista Comprar Ticket Bus
        this.bus = bus;
        this.busql = busql;
        this.pagoticket = pagoticket;
        this.reservaticket = reservaticket;
        this.reservaticketsql = reservaticketsql;

        this.login.jButtonAdmin.addActionListener(this);
        this.login.jButtonRegistroUsuario.addActionListener(this);
        this.login.jButtonExit.addActionListener(this);
        this.login.jButtonUsuario.addActionListener(this);
        this.login.jButtonAbout.addActionListener(this);
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
        this.buses.jButtonBuscarInfoBusParaModificar.addActionListener(this);
        this.buses.jButtonModificarBus.addActionListener(this);
        this.buses.jButtonTablaBus.addActionListener(this);
        this.buses.jButtonVerIDsEliminarBus.addActionListener(this);
        this.buses.jButtonVolverBus.addActionListener(this);
        this.buses.jButtonNumeroAleatorio.addActionListener(this);
        this.ruta_buses.jButtonAgregarRutaBus.addActionListener(this);
        this.ruta_buses.jButtonVolverRutaBuses.addActionListener(this);
        this.cTB.jButtonCTB_Viajes.addActionListener(this);
        this.cTB.jButtonCTB_ReservarTicket.addActionListener(this);
        this.cTB.jButtonCTB_Volver.addActionListener(this);
        this.pagoticket.jButtonPagar.addActionListener(this);
        this.pagoticket.jButtonVolverAtras.addActionListener(this);

    }

    private int ventanaLoginAdmin = 0;
    private int ventanaMainUsuario = 0;
    private int ventanaConductor = 0;
    private int ventanaCrearUser = 0;
    private int ventanaCrearBus = 0;
    private int ventanaCrearRuta = 0;
    private int ventanaCTB = 0;
    private int ventanaPagoTicket = 0;
    private String or = "";
    private String de = "";
    private String fI = "";

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

    public void iniciarPagoTicket() {
        pagoticket.setTitle("Usuario | Zona de pago");
        pagoticket.setLocationRelativeTo(null);
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

        } else if (e.getSource() == login.jButtonAbout) {

            JOptionPane.showMessageDialog(null, "Software para la gestión de tickets y rutas en el departamento del Atlántico \n"
                    + "\n"
                    + "Un software diseñado en un IDE de java (Netbeans), realizado para brindar soporte a \n"
                    + "cualquier empresa de transporte.\n"
                    + "\n"
                    + "Enfoque: Proyecto universitario.\n"
                    + "\n"
                    + "Fecha de realización: 1 de abril del año 2021\n"
                    + "\n"
                    + "Lugar de origen: Barranquilla - Colombia\n"
                    + "\n"
                    + "versión: 1.0\n"
                    + "\n"
                    + "Desarrolladores: Castro Orlando, Pérez Juan, Narváez Juan", "Acerca de...", JOptionPane.INFORMATION_MESSAGE);

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

                if (esNumerico(registroUsuario.jTextIdCliente.getText()) == true) {

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

                } else {

                    JOptionPane.showMessageDialog(null, "Debes ingresar solamente valores numéricos en el campo de CC/NIT/ID", "Información", JOptionPane.ERROR_MESSAGE);

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

                    if (reservaticketsql.cantidadTicketsCliente(Integer.parseInt(login.jTextUsername.getText())) >= 1) {
                        user.jLabelTieneAsientosComprados.setText("Actualmente usted tiene tickets comprados.");
                        user.jButtonUserVerViajes.setEnabled(true);
                    } else {
                        user.jLabelTieneAsientosComprados.setText("Actualmente no tiene ningún asiento comprado.");
                        user.jButtonUserVerViajes.setEnabled(false);
                    }

                    user.jLabelNombreUser.setText("¡Bienvenido, " + clientesql.obtenerNombreUsuario(cli) + "!");

                } else {

                    JOptionPane.showMessageDialog(null, " Error al ingresar.", "Información", JOptionPane.ERROR_MESSAGE);

                }

            } else {

                JOptionPane.showMessageDialog(null, "Por favor, rellenar todos los campos.", "Información", JOptionPane.WARNING_MESSAGE);

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

            reservaticketsql.mostrarTicketsComprados(Integer.parseInt(login.jTextUsername.getText()));

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

            JOptionPane.showMessageDialog(null, "Desde esta interfaz seleccione hacia donde se quiere dirigir a establecer o modificar datos.\n"
                    + "puede dirigirse a la interfaz de autobuses, conductor, ruta y ver la información de los clientes\n"
                    + "registrados.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == admin.jButtonAdminInfoUsers) { //BOTON PARA LLENAR LA TABLA CON TODOS LOS USUARIOS DENTRO DE LA BD (Administrador)

            listarCliente(admin.jTableInfoTodosLosUsuarios);

        } else if (e.getSource() == admin.jButtonAdminRuta) { //BOTON PARA AGREGAR RUTAS DE LOS BUSES (Administrador)

            if (ventanaCrearRuta == 0) {
                iniciarRuta();
                ventanaCrearRuta++;
            }

            admin.setVisible(false);
            ruta_buses.setVisible(true);

            ruta_buses.jComboID_Conductor.removeAllItems();
            conductorsql.seleccionar_IDs(ruta_buses.jComboID_Conductor);

            ruta_buses.jComboNumBUS.removeAllItems();
            busql.seleccionar_IDs_Bus(ruta_buses.jComboNumBUS);

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
                    
                    //LIMPIAR CAMPOS AQUI DE LA INTERFAZ INFOCONDUCTOR

                }

            }

        } else if (e.getSource() == conductor.jButtonVolverConductor) { //BOTON DE VOLVER DE CONDUCTOR A VENTANA PRINCIPAL DE ADMIN

            conductor.setVisible(false);
            admin.setVisible(true);

        } else if (e.getSource() == conductor.jButtonActualizarTablaConductores) { //ACTUALIZAR TABLA DE CONDUCTORES (InfoConductor)

            listarConductor(conductor.jTableInfoConductor);

        } else if (e.getSource() == conductor.jButtonBuscarIDsConductor) { //BUSCAR INFO POR LA ID DE UN CONDUCTOR (InfoConductor)

            if (conductor.jComboBuscarID.getSelectedIndex() != 0) {

                String fecha = "";
                int d = Integer.parseInt(String.valueOf(conductor.jComboBuscarID.getSelectedItem()));

                cond.setId_cond(d);

                if (conductorsql.buscarConductor(cond)) {

                    conductor.jTextModificarNombreConductor.setText(cond.getNombres_cond());
                    conductor.jTextModificarApellidoConductor.setText(cond.getApellios_cond());
                    fecha = cond.getF_naci_cond();

                }

                Date date;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                    conductor.jDateModificarConductor.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(C_Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                conductor.jTextModificarNombreConductor.setEnabled(true);
                conductor.jTextModificarApellidoConductor.setEnabled(true);
                conductor.jDateModificarConductor.setEnabled(true);
                conductor.jButtonModificarInfoConductor.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una ID.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == conductor.jButtonModificarInfoConductor) { //BOTON MODIFICAR CONDUCTOR (InfoConductor)

            int q = Integer.parseInt(String.valueOf(conductor.jComboBuscarID.getSelectedItem()));
            cond.setId_cond(q);
            cond.setNombres_cond(conductor.jTextModificarNombreConductor.getText());
            cond.setApellios_cond(conductor.jTextModificarApellidoConductor.getText());

            Date ModificarfechaConductor = conductor.jDateModificarConductor.getDate();

            DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

            String DateDriver = formato.format(ModificarfechaConductor).toString();
            cond.setF_naci_cond(DateDriver);

            if (conductorsql.modificarConductor(cond)) {

                JOptionPane.showMessageDialog(null, "Los datos del conductor fueron actualizados exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar datos del conductor.", "Información", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == conductor.jButtonEliminarConductor) { //ELIMINA UN CONDUCTOR DE LA BD (InfoConductor)

            if (conductor.jComboEliminarID.getSelectedIndex() != 0) {

                int elim = Integer.parseInt(String.valueOf(conductor.jComboEliminarID.getSelectedItem()));
                cond.setId_cond(elim);

                if (conductorsql.eliminarConductor(cond)) {
                    JOptionPane.showMessageDialog(null, "El conductor fue eliminado con exito de la base de datos.", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar de la base de datos.", "Información", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una ID.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == conductor.jButtonHelpConductor) { //AYUDA PARA EL ADMIN EN LA INTERFAZ DE INFOCONDUCTOR

            JOptionPane.showMessageDialog(null, "Ingrese los datos pertinentes para agregar un conductor en la base de datos.\n"
                    + "dependiendo de las acciones necesaria, podrá modificar y eliminar datos de \n"
                    + "estos en las cajas de texto.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == conductor.jButtonVerIDsModificarConductor) { //MUESTRA LAS IDS DE LOS CONDUCTORES EN EL COMBOBOX PARA MODIFICAR LUEGO (InfoConductor)

            conductor.jComboBuscarID.setEnabled(true);
            conductor.jComboBuscarID.removeAllItems();
            conductorsql.seleccionar_IDs(conductor.jComboBuscarID);
            conductor.jButtonBuscarIDsConductor.setEnabled(true);

        } else if (e.getSource() == conductor.jButtonVerIDsEliminarConductor) { //MUESTRA LAS IDS DE LOS CONDUCTORES EN EL COMBOBOX PARA ELIMINAR LUEGO (InfoConductor)

            conductor.jComboEliminarID.setEnabled(true);
            conductor.jComboEliminarID.removeAllItems();
            conductorsql.seleccionar_IDs(conductor.jComboEliminarID);
            conductor.jButtonEliminarConductor.setEnabled(true);

        } else if (e.getSource() == buses.jButtonAnadirBus) {

            if (buses.jTextNumBus.getText().equals("") || buses.jTextPlaca.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Hay campos vacíos, por favor rellenar todos los campos.", "Error al añadir", JOptionPane.WARNING_MESSAGE);

            } else {

                bus.setId_bus(Integer.parseInt(buses.jTextNumBus.getText()));

                bus.setModelo_bus((String) buses.jComboBoxModeloBus.getSelectedItem());

                bus.setPlaca_bus(buses.jTextPlaca.getText());

                if (busql.anadirBus(bus)) {

                    JOptionPane.showMessageDialog(null, "El autobus fue añadido exitosamente.");
                    
                    //LIMPIAR CAMPOS AQUI DE LA INTERFAZ INFOBUSES

                }
            }

        } else if (e.getSource() == buses.jButtonEliminarBus) {

            if (buses.jComboBoxEliminarBus.getSelectedIndex() != 0) {

                int elimBus = Integer.parseInt(String.valueOf(buses.jComboBoxEliminarBus.getSelectedItem()));
                bus.setId_bus(elimBus);

                if (busql.eliminarBus(bus)) {
                    JOptionPane.showMessageDialog(null, "El autobus fue eliminado con exito de la base de datos.", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar de la base de datos.", "Información", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una ID.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == buses.jButtonHelpBus) {

            JOptionPane.showMessageDialog(null, "Ingrese los datos pertinentes para agregar un autobus en la base de datos.\n"
                    + "dependiendo de las acciones necesarias, podrá modificar y eliminar datos\n"
                    + "de estos en las cajas de texto.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == buses.jButtonBuscarInfoBusParaModificar) {

            if (buses.jComboBoxBuscarBusID.getSelectedIndex() != 0) {

                int x = Integer.parseInt(String.valueOf(buses.jComboBoxBuscarBusID.getSelectedItem()));
                bus.setId_bus(x);

                if (busql.BuscarBus(bus)) {

                    buses.jComboBoxModeloBuscarBus.setSelectedItem(bus.getModelo_bus());
                    buses.jTextBuscarPlacaBus.setText(bus.getPlaca_bus());

                }

                buses.jComboBoxModeloBuscarBus.setEnabled(true);
                buses.jTextBuscarPlacaBus.setEnabled(true);
                buses.jButtonModificarBus.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una ID.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == buses.jButtonIDsModificarBus) {//Botón de ver los IDS --> InfoBuses

            buses.jButtonBuscarInfoBusParaModificar.setEnabled(true);
            buses.jComboBoxBuscarBusID.removeAllItems();
            busql.seleccionar_IDs_Bus(buses.jComboBoxBuscarBusID);
            buses.jComboBoxBuscarBusID.setEnabled(true);

        } else if (e.getSource() == buses.jButtonModificarBus) {// Botón de modificar --> InfoBuses 

            int p = Integer.parseInt(String.valueOf(buses.jComboBoxBuscarBusID.getSelectedItem()));

            bus.setId_bus(p);
            bus.setModelo_bus(String.valueOf(buses.jComboBoxModeloBuscarBus.getSelectedItem()));
            bus.setPlaca_bus(buses.jTextBuscarPlacaBus.getText());

            if (busql.modificarBus(bus)) {

                JOptionPane.showMessageDialog(null, "Los datos se han actualizado de manera exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(null, "No se han podido actualizar los datos", "Información", JOptionPane.ERROR_MESSAGE);

            }

        } else if (e.getSource() == buses.jButtonTablaBus) {

            listarBus(buses.jTableInfoBuses);

        } else if (e.getSource() == buses.jButtonVolverBus) {

            buses.setVisible(false);
            admin.setVisible(true);

        } else if (e.getSource() == buses.jButtonVerIDsEliminarBus) {

            buses.jComboBoxEliminarBus.setEnabled(true);
            buses.jComboBoxEliminarBus.removeAllItems();
            busql.seleccionar_IDs_Bus(buses.jComboBoxEliminarBus);
            buses.jButtonEliminarBus.setEnabled(true);

        } else if (e.getSource() == buses.jButtonNumeroAleatorio) {

            buses.jTextNumBus.setText(String.valueOf((int) Math.floor(Math.random() * (9000) + 1000)));

        } else if (e.getSource() == ruta_buses.jButtonAgregarRutaBus) { //AGRERAR RUTA DE BUS (InfoRutaBuses)

            Date fechaActual = new Date();

            SimpleDateFormat onlydate = new SimpleDateFormat("yyyy-MM-dd");

            Date fechaPartida = ruta_buses.jDateFechaPartida.getDate();
            String fP = onlydate.format(fechaPartida).toString();

            if (ruta_buses.jDateFechaPartida.getDate() == null) {

                JOptionPane.showMessageDialog(null, "Debes ingresar una fecha.", "Información", JOptionPane.ERROR_MESSAGE);

            } else if (fechaValida(fechaActual, fechaPartida) == true) {

                if (ruta_buses.jComboID_Conductor.getSelectedIndex() != 0 && ruta_buses.jComboNumBUS.getSelectedIndex() != 0) {

                    if (!ruta_buses.jComboOrigen.getSelectedItem().toString().equals(ruta_buses.jComboDestino.getSelectedItem().toString())) {

                        rutas.setOrigen(ruta_buses.jComboOrigen.getSelectedItem().toString());
                        rutas.setDestino(ruta_buses.jComboDestino.getSelectedItem().toString());
                        rutas.setHora(ruta_buses.jComboHora.getSelectedItem().toString() + ":" + ruta_buses.jComboMinutos.getSelectedItem().toString());
                        rutas.setFecha(fP);
                        rutas.setId_conductor(Integer.parseInt(ruta_buses.jComboID_Conductor.getSelectedItem().toString()));
                        rutas.setId_autobus(Integer.parseInt(ruta_buses.jComboNumBUS.getSelectedItem().toString()));

                        if (rutassql.anadirRuta(rutas)) {

                            JOptionPane.showMessageDialog(null, "La ruta fue programada a la base de datos de manera exitosa.");

                            cond.setId_cond(Integer.parseInt(ruta_buses.jComboID_Conductor.getSelectedItem().toString()));
                            bus.setId_bus(Integer.parseInt(ruta_buses.jComboNumBUS.getSelectedItem().toString()));

                            if (conductorsql.buscarConductor(cond) && busql.BuscarBus(bus)) {

                                ruta_buses.jTextAreaInfoRuta.setText("Identificador de la ruta de bus: " + rutassql.obtenerRutaID(Integer.parseInt(ruta_buses.jComboID_Conductor.getSelectedItem().toString()), fP) + "\n"
                                        + "Número del bus: " + bus.getId_bus() + "\n"
                                        + "Placa del bus: " + bus.getPlaca_bus() + "\n"
                                        + "Conductor del bus: " + cond.getNombres_cond() + " " + cond.getApellios_cond() + "\n"
                                        + "Lugar de partida: " + ruta_buses.jComboOrigen.getSelectedItem().toString() + "\n"
                                        + "Lugar de destino: " + ruta_buses.jComboDestino.getSelectedItem().toString() + "\n"
                                        + "Fecha y hora de partida de la ruta: " + fP + " " + ruta_buses.jComboHora.getSelectedItem().toString() + ":" + ruta_buses.jComboMinutos.getSelectedItem().toString());

                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La ruta de origen y destino no deben coincidir.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete los datos.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se puede agregar rutas para el mismo dia o anterior de la fecha actual, o no ingresó la fecha.", "Información", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == ruta_buses.jButtonVolverRutaBuses) {

            ruta_buses.setVisible(false);
            admin.setVisible(true);

        } else if (e.getSource() == cTB.jButtonCTB_Viajes) {

            if (!cTB.jComboLugarOrigen.getSelectedItem().toString().equals(cTB.jComboDestino.getSelectedItem().toString())) {

                Date fechaActual = new Date();
                SimpleDateFormat onlydate = new SimpleDateFormat("yyyy-MM-dd");

                or = (String) cTB.jComboLugarOrigen.getSelectedItem();
                de = (String) cTB.jComboDestino.getSelectedItem();

                try {

                    Date fechaIngresada = cTB.jDateFechaIngresada.getDate();
                    fI = onlydate.format(fechaIngresada).toString();

                    if (cTB.jDateFechaIngresada.getDate() == null) {

                        JOptionPane.showMessageDialog(null, "Debe ingresar una fecha.", "Información", JOptionPane.INFORMATION_MESSAGE);

                    } else if (fechaValida(fechaActual, fechaIngresada) == true) {

                        cTB.jComboHoras.removeAllItems();
                        if (reservaticketsql.seleccionarHorasRuta(cTB.jComboHoras, or, de, fI) != 0) {

                            cTB.jComboAsientos.setEnabled(true);
                            cTB.jComboHoras.setEnabled(true);
                            cTB.jButtonCTB_ReservarTicket.setEnabled(true);

                        } else {

                            JOptionPane.showMessageDialog(null, "No se encontraron horarios disponibles para la fecha seleccionada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            cTB.jButtonCTB_ReservarTicket.setEnabled(false);
                            cTB.jComboHoras.setEnabled(false);

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar una fecha valida, La fecha ingresada no puede ser anterior a la fecha actual.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (Exception ed) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una fecha.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "La ruta de origen y destino no deben coincidir.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == cTB.jButtonCTB_ReservarTicket) {

            if (cTB.jComboAsientos.getSelectedIndex() == 0) {

                JOptionPane.showMessageDialog(null, "Debe seleccionar un asiento.", "Información", JOptionPane.INFORMATION_MESSAGE);

            } else if (cTB.jComboHoras.getSelectedIndex() == 0) {

                JOptionPane.showMessageDialog(null, "Debe seleccionar una hora.", "Información", JOptionPane.INFORMATION_MESSAGE);

            } else {

                if (!cTB.jTextID.getText().equals("") && !cTB.jTextNombres.getText().equals("") && !cTB.jTextApellidos.getText().equals("")) {

                    if (esNumerico(cTB.jTextID.getText()) == true) {

                        if (ventanaPagoTicket == 0) {
                            iniciarPagoTicket();
                            ventanaPagoTicket++;
                        }

                        pagoticket.jTextID_C.setText(cTB.jTextID.getText());
                        pagoticket.jTextNombre_C.setText(cTB.jTextNombres.getText());
                        pagoticket.jTextApellido_C.setText(cTB.jTextApellidos.getText());
                        pagoticket.jTextLP_C.setText(or);
                        pagoticket.jTextLD_C.setText(de);
                        pagoticket.jTextHoraP_C.setText(cTB.jComboHoras.getSelectedItem().toString());
                        pagoticket.jTextNAsiento_C.setText(cTB.jComboAsientos.getSelectedItem().toString());

                        cTB.setVisible(false);
                        pagoticket.setVisible(true);

                    } else {

                        JOptionPane.showMessageDialog(null, "Debes ingresar solamente valores numéricos en el campo de Doc. Identidad.", "Información", JOptionPane.ERROR_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        } else if (e.getSource() == cTB.jButtonCTB_Volver) {

            cTB.setVisible(false);
            user.setVisible(true);

        } else if (e.getSource() == pagoticket.jButtonVolverAtras) {

            pagoticket.setVisible(false);
            cTB.setVisible(true);

        } else if (e.getSource() == pagoticket.jButtonPagar) {

            if (!pagoticket.jTextNumTarjeta.getText().equals("") && !pagoticket.jTextCVV.getText().equals("")
                    && !pagoticket.jTextNombreTarjeta.getText().equals("") && !pagoticket.jTextApellidoTarjeta.getText().equals("")
                    && !pagoticket.jTextCorreo.getText().equals("") && !pagoticket.jTextTelefono.getText().equals("")
                    && !pagoticket.jTextCiudad.getText().equals("") && !pagoticket.jTextPais.getText().equals("")
                    && !pagoticket.jTextConfirmarID.getText().equals("")) {

                if (esNumerico(pagoticket.jTextCVV.getText()) == true && pagoticket.jTextCVV.getText().length() == 3) {

                    reservaticket.setNombres(pagoticket.jTextNombre_C.getText());
                    reservaticket.setApellidos(pagoticket.jTextApellido_C.getText());
                    reservaticket.setDestino(pagoticket.jTextLP_C.getText() + "-" + pagoticket.jTextLD_C.getText());
                    reservaticket.setAsiento(Integer.parseInt(pagoticket.jTextNAsiento_C.getText()));
                    reservaticket.setId_cliente(Integer.parseInt(pagoticket.jTextID_C.getText()));
                    reservaticket.setId_ruta(rutassql.soloObtenerIDRuta(or, de, fI, cTB.jComboHoras.getSelectedItem().toString()));

                    if (reservaticketsql.registroTicket(reservaticket)) {

                        System.out.println("DOC. IDENTIDAD DEL PASAJERO: " + pagoticket.jTextID_C.getText());
                        System.out.println("NOMBRE DEL PASAJERO: " + pagoticket.jTextNombre_C.getText());
                        System.out.println("APELLIDOS DEL PASAJERO: " + pagoticket.jTextApellido_C.getText());
                        System.out.println("LUGAR DE ORIGEN-DESTINO: " + pagoticket.jTextLP_C.getText() + "-" + pagoticket.jTextLD_C.getText());
                        System.out.println("ASIENTO SELECCIONADO: " + pagoticket.jTextNAsiento_C.getText());
                        System.out.println("FECHA Y HORA DE PARTIDA: " + fI + " " + cTB.jComboHoras.getSelectedItem().toString());

                        JOptionPane.showMessageDialog(null, "Su ticket fue aprobado y registrado en nuestra base de datos.", "TICKET APROBADO", JOptionPane.INFORMATION_MESSAGE);

                        user.jLabelTieneAsientosComprados.setText("Actualmente usted tiene tickets comprados.");
                        user.jButtonUserVerViajes.setEnabled(true);

                        pagoticket.setVisible(false);
                        user.setVisible(true);
                        
                        //LIMPIAR CAMPOS AQUI DE LA INTERFAZ PAGOTICKET (SOLO CAMPOS DE TEXTO)
                        
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "El código de seguridad (CVV) solo deben contener digitos numericos y debe ser de 3 digitos.", "Información", JOptionPane.INFORMATION_MESSAGE);

                }

            } else {

                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.", "Información", JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }

    public boolean esNumerico(String cadena) {

        try {

            Integer.parseInt(cadena);
            return true;

        } catch (NumberFormatException nfe) {

            return false;

        }

    }

    public boolean fechaValida(Date fechaAct, Date fechaSelected) {

        if (fechaAct.compareTo(fechaSelected) > 0) {
            return false;
        } else if (fechaAct.compareTo(fechaSelected) < 0) {
            return true;
        } else if (fechaAct.compareTo(fechaSelected) == 0) {
            return true;
        }
        return false;
    }

    public void listarBus(JTable tablaBus) {

        modeloBus = (DefaultTableModel) tablaBus.getModel();
        List<Buses> lista = busql.listar();
        Object[] object = new Object[3];
        int numDatos = modeloBus.getRowCount();
        for (int k = 0; k < numDatos; k++) {

            modeloBus.removeRow(0);

        }

        for (int i = 0; i < lista.size(); i++) {

            object[0] = lista.get(i).getId_bus();
            object[1] = lista.get(i).getModelo_bus();
            object[2] = lista.get(i).getPlaca_bus();

            modeloBus.addRow(object);

        }

        buses.jTableInfoBuses.setModel(modeloBus);

    }

    public void listarCliente(JTable tablaCliente) {

        modeloCliente = (DefaultTableModel) tablaCliente.getModel();
        List<Cliente> lista = clientesql.listar();
        Object[] object = new Object[6];
        int numDatos = modeloCliente.getRowCount();

        for (int k = 0; k < numDatos; k++) {

            modeloCliente.removeRow(0);

        }

        for (int i = 0; i < lista.size(); i++) {

            object[0] = lista.get(i).getId_cliente();
            object[1] = lista.get(i).getNombres_cliente();
            object[2] = lista.get(i).getApellidos_cliente();
            object[3] = lista.get(i).getF_naci_cliente();
            object[4] = lista.get(i).getCorreo_cliente();
            object[5] = lista.get(i).getContrasena();

            modeloCliente.addRow(object);

        }

        admin.jTableInfoTodosLosUsuarios.setModel(modeloCliente);

    }

    public void listarConductor(JTable tablaConductor) {

        modeloConductor = (DefaultTableModel) tablaConductor.getModel();

        List<Conductor> lista = conductorsql.listar();
        Object[] object = new Object[4];
        int numDatos = modeloConductor.getRowCount();

        for (int k = 0; k < numDatos; k++) {

            modeloConductor.removeRow(0);

        }

        for (int i = 0; i < lista.size(); i++) {

            object[0] = lista.get(i).getId_cond();
            object[1] = lista.get(i).getNombres_cond();
            object[2] = lista.get(i).getApellios_cond();
            object[3] = lista.get(i).getF_naci_cond();
            modeloConductor.addRow(object);

        }

        conductor.jTableInfoConductor.setModel(modeloConductor);

    }

}
