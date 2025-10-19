/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.*;

public class Venta {
    private Date fecha;
    private int monto;
    private Persona persona;           
    private List<Entrada> entradas;    

    private Concierto concierto;
    private Zona zona;
    private int cantidad;
    
    
    
    public Venta(Date fecha, Persona persona, Concierto concierto, Zona zona, int cantidad) {
        this.fecha = fecha;
        this.persona = persona;
        this.concierto = concierto;
        this.zona = zona;
        this.cantidad = cantidad;
        this.entradas = new ArrayList<>();
        this.monto = (int) (cantidad * zona.getPrecio()); 
    }
    public Venta(Date fecha, int total, Persona persona) {
        this.fecha = fecha;
        this.monto = total;
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
    public void setConcierto(Concierto concierto) { this.concierto = concierto; }
    public void setZona(Zona zona) { this.zona = zona; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    
    public Date getFecha() { return fecha; }
    public int getMonto() { return monto; }
    public Persona getPersona() { return persona; }
    public List<Entrada> getEntradas() { return entradas; }
    public Concierto getConcierto() { return concierto; }
    public Zona getZona() { return zona; }
    public int getCantidad() { return cantidad; }
}