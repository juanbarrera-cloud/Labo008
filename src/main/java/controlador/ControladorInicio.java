/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmInicio;
import vista.frmLogin;

public class ControladorInicio implements ActionListener {

    private frmInicio vista;

    public ControladorInicio(frmInicio vista) {
        this.vista = vista;
        this.vista.btnAdministrador.addActionListener(this);
        this.vista.btnComprador.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAdministrador) {
            frmLogin loginAdmin = new frmLogin("admin");
            new ControladorLogin(loginAdmin); 
            loginAdmin.setVisible(true);
            vista.dispose(); 
        }

        if (e.getSource() == vista.btnComprador) {
            frmLogin loginComprador = new frmLogin("comprador");
            new ControladorLogin(loginComprador); 
            loginComprador.setVisible(true);
            vista.dispose();
        }
    }
}