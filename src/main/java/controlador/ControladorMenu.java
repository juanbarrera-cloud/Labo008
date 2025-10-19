/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.frmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu implements ActionListener {
    private frmMenu vistaMenu;

    public ControladorMenu(frmMenu vistaMenu) {
        this.vistaMenu = vistaMenu;

        // Escuchamos los botones
        this.vistaMenu.btnComprar.addActionListener(this);
        this.vistaMenu.btnConciertos.addActionListener(this);
        this.vistaMenu.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMenu.btnComprar) {
            System.out.println("🟢 Ir a la ventana de Compra de Entradas");
            // Aquí más adelante abriremos el frmCompra
        }

        if (e.getSource() == vistaMenu.btnConciertos) {
            System.out.println("🎵 Mostrar lista de conciertos");
            // Aquí luego abriremos el frmConciertos
        }

        if (e.getSource() == vistaMenu.btnSalir) {
            System.out.println("🔴 Cerrando sesión...");
            vistaMenu.dispose(); // Cerramos el menú
            // Y podríamos volver al frmLogin
        }
    }
}