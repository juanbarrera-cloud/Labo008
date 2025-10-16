/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

class Persona {
    private String nombres;
    private String apellidos;
    private String dni;
    private String contraseña;
    private Tarjeta tarjeta;  
    private Venta venta;       

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
