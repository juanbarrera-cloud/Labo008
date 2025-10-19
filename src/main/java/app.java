/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import controlador.ControladorLogin;
import vista.frmLogin;

public class App {
    public static void main(String[] args) {
        frmLogin vista = new frmLogin();              // Creamos la vista (pantalla de login)
        ControladorLogin controlador = new ControladorLogin(vista); // Vinculamos con el controlador
        vista.setVisible(true);                       // Mostramos la ventana
    }
}