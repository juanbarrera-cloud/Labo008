/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.*;

class Venta {
    private Date fecha;
    private int monto;
    private Persona persona;           
    private List<Entrada> entradas;    

    public Venta(Date fecha, int monto, Persona persona) {
        this.fecha = fecha;
        this.monto = monto;
        this.persona = persona;
        this.entradas = new ArrayList<>();
    }

    public boolean anular() {
        this.entradas.clear();
        return true;
    }

    public boolean agregarEntrada(Entrada e) {
        if (entradas.size() < 4) {
            entradas.add(e);
            return true;
        }
        return false;
    }
}