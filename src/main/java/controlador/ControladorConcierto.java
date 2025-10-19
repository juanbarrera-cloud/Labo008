/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmConcierto;
import vista.frmMenu;

public class ControladorConcierto implements ActionListener {

    private frmConcierto vista;
    private frmMenu menu;

    public ControladorConcierto(frmConcierto vista, frmMenu menu) {
        this.vista = vista;
        this.menu = menu;

        this.vista.btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnVolver) {
            vista.dispose();      
            menu.setVisible(true); 
        }
    }
}