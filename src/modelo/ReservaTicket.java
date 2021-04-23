
package modelo;


public class ReservaTicket {
    
    
    private String origen;
    private String destino;
    private String fechaIngresada;
    private String nombres;
    private String apellidos;
    private String origen_destino;
    private int asiento;
    private int id_cliente;
    private int id_ruta;

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaIngresada() {
        return fechaIngresada;
    }

    public void setFechaIngresada(String fechaIngresada) {
        this.fechaIngresada = fechaIngresada;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOrigen_destino() {
        return origen_destino;
    }

    public void setOrigen_destino(String origen_destino) {
        this.origen_destino = origen_destino;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }
    
    
}
