/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    private String nombre;
    private int capacidad;
    private int precio;
    private Concierto concierto;
    private List<Entrada> entradas;

    public Zona(String nombre, int capacidad, int precio, Concierto concierto) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.concierto = concierto;
        this.entradas = new ArrayList<>();
    }

    public boolean generarEntradas() {
        for (int i = 1; i <= capacidad; i++) {
            entradas.add(new Entrada(i, "disponible", this, null));
        }
        return true;
    }

    public List<Entrada> mostrarEntrada() {
        return entradas;
    }

    public List<Entrada> venderEntrada(int numero) {
        List<Entrada> vendidas = new ArrayList<>();
        for (Entrada e : entradas) {
            if (e.getNumero() == numero && e.vender()) {
                vendidas.add(e);
            }
        }
        return vendidas;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
