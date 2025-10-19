/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.frmMenu;
import vista.frmCompra;
import vista.frmConcierto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu implements ActionListener {

    private frmMenu vistaMenu;

    public ControladorMenu(frmMenu vistaMenu) {
        this.vistaMenu = vistaMenu;

        this.vistaMenu.btnComprar.addActionListener(this);
        this.vistaMenu.btnConciertos.addActionListener(this);
        this.vistaMenu.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaMenu.btnComprar) {
            frmCompra compra = new frmCompra();
            ControladorCompra controlador = new ControladorCompra(compra);
            compra.setVisible(true);
        }

        if (e.getSource() == vistaMenu.btnConciertos) {
            frmConcierto vistaConcierto = new frmConcierto();
            new ControladorConcierto(vistaConcierto, vistaMenu); 
            vistaConcierto.setVisible(true);
            vistaMenu.setVisible(false); 
        }

        if (e.getSource() == vistaMenu.btnSalir) {
            System.out.println("🔴 Cerrando sesión...");
            vistaMenu.dispose();
        }
    }
}