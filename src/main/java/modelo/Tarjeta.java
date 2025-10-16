/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

class Tarjeta {
    private int numero;
    private String nombre;
    private String fecha;
    private int CVV;
    private Persona titular;  

    public Tarjeta(int numero, String nombre, String fecha, int CVV, Persona titular) {
        this.numero = numero;
        this.nombre = nombre;
        this.fecha = fecha;
        this.CVV = CVV;
        this.titular = titular;
    }
}
