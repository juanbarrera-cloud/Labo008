/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.ArrayList;
import modelo.Persona;
import modelo.Tarjeta;

public class Repositorio {

    public static ArrayList<Persona> listaPersonas = new ArrayList<>();

    static {
        listaPersonas.add(new Persona(
            "Juan", "Barrera", "24200009", "juancarlos", "1234",
            new Tarjeta("113345448", "1")
        ));
        listaPersonas.add(new Persona(
            "María", "López", "55667788", "maria", "abcd",
            new Tarjeta("555666788", "4")
        ));
    }

    public static ArrayList<Persona> obtenerPersonas() {
        return listaPersonas;
    }
}