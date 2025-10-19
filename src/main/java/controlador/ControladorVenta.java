/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.*;
import modelo.Venta;
import vista.frmVenta;

public class ControladorVenta implements ActionListener {

    private frmVenta vista;
    private Venta venta;

    public ControladorVenta(frmVenta vista, Venta venta) {
    this.vista = vista;
    this.venta = venta;

    this.vista.btnCerrar.addActionListener(this);

    try {
        mostrarDatosVenta();
    } catch (Exception ex) {
        ex.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(null, "Error al mostrar los datos: " + ex.getMessage());
    }
    }
    private void mostrarDatosVenta() {
        vista.txtCliente.setText(venta.getPersona().getNombre());
        vista.txtConcierto.setText(venta.getConcierto().getNombre());
        vista.txtZona.setText(venta.getZona().getNombre());
        vista.txtCantidad.setText(String.valueOf(venta.getCantidad()));
        vista.txtTotal.setText("S/ " + venta.getMonto());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCerrar) {
            vista.dispose();
        }
    }
}
