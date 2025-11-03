/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.Tarjeta;
import vista.frmAgregarPersona;


public class ControladorAgregarPersona implements ActionListener {

    private frmAgregarPersona vista;
    private ControladorAdministrador controladorPrincipal;

    public ControladorAgregarPersona(frmAgregarPersona vista, ControladorAdministrador controladorPrincipal) {
        this.vista = vista;
        this.controladorPrincipal = controladorPrincipal;

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            try {
                String nombre = vista.txtNombre.getText();
                String apellido = vista.txtApellido.getText();
                String dni = vista.txtDni.getText();
                String usuario = vista.txtUsuario.getText();
                String contraseña = vista.txtContraseña.getText();
                String numTarjeta = vista.txtTarjeta.getText();
                String cvv = vista.txtCvv.getText();

                Tarjeta t = new Tarjeta(numTarjeta, cvv);
                Persona p = new Persona(nombre, apellido, dni, usuario, contraseña, t);

                controladorPrincipal.agregarPersona(p);
                JOptionPane.showMessageDialog(vista, "Persona agregada correctamente.");
                vista.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == vista.btnCancelar) {
            vista.dispose();
        }
    }
}