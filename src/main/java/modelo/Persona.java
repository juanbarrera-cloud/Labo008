/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

public class Persona {
    private String nombres;
    private String apellidos;
    private String dni;
    private String contraseña;
    private Tarjeta tarjeta;
    private Venta venta;

    public Persona() {}

    public Persona(String nombreCompleto) {
        this.nombres = nombreCompleto;
    }

    public Persona(String nombres, String apellidos, String dni, String contraseña) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contraseña = contraseña;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getNombre() {
        return nombres;
    }

    public boolean registrarTarjeta(Tarjeta t) {
        if (this.tarjeta == null) {
            this.tarjeta = t;
            return true;
        }
        return false;
    }

    public boolean eliminarTarjeta() {
        if (this.tarjeta != null) {
            this.tarjeta = null;
            return true;
        }
        return false;
    }

    public boolean anularVenta() {
        if (this.venta != null) {
            return this.venta.anular();
        }
        return false;
    }

    public boolean comprar(Venta v) {
        if (this.venta == null) {
            this.venta = v;
            return true;
        }
        return false;
    }
}