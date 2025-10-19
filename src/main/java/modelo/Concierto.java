/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Concierto {

    private String nombre;
    private Date fecha;
    private List<Zona> zonas;

    public Concierto(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.zonas = new ArrayList<>();
    }
    public boolean agregarZona(Zona z) {
        return zonas.add(z);
    }
    public boolean eliminarZona(String nombre) {
        return zonas.removeIf(z -> z.getNombre().equals(nombre));
    }
    public List<Zona> getZonas() {
        return zonas;
    }
    public String getNombre() {
        return nombre;
    }
    public Date getFecha() {
        return fecha;
    }
}