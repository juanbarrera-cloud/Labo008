/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Tarjeta {
    private String numero;
    private String cvv;

    public Tarjeta(String numero, String cvv) {
        this.numero = numero;
        this.cvv = cvv;
    }

    public Tarjeta() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return numero + " (CVV: " + cvv + ")";
    }
}
