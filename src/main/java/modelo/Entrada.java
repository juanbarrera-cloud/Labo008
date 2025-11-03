/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Entrada {
    private int numero;
    private String estado;
    private Zona zona;
    private Object venta; 

    public Entrada(int numero, String estado, Zona zona, Object venta) {
        this.numero = numero;
        this.estado = estado;
        this.zona = zona;
        this.venta = venta;
    }

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public boolean vender() {
        if (estado.equals("disponible")) {
        estado = "vendida";
        return true;
        }   
        return false;
    }

    public boolean liberar() {
        if (estado.equals("vendida")) {
            estado = "disponible";
            return true;
        }
        return false;
    }
}