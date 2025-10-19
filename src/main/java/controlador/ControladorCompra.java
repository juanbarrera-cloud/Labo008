/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import modelo.*;
import vista.frmCompra;
import vista.frmVenta;

public class ControladorCompra implements ActionListener {

    private frmCompra vista;
    private List<Concierto> conciertos;
    private Concierto conciertoSeleccionado;
    private Zona zonaSeleccionada;
    private int total = 0;

    public ControladorCompra(frmCompra vista) {
        this.vista = vista;
        this.vista.btnComprar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.cmbConcierto.addActionListener(this);
        this.vista.cmbZona.addActionListener(this);

        cargarConciertos();
        llenarComboConciertos();
    }

    private void cargarConciertos() {
        conciertos = new ArrayList<>();

        Concierto c1 = new Concierto("AGUA MARINA", new Date());
        Concierto c2 = new Concierto("GRUPO 5", new Date());

        Zona vip1 = new Zona("VIP", 5, 200, c1);
        Zona general1 = new Zona("General", 10, 100, c1);
        vip1.generarEntradas();
        general1.generarEntradas();
        c1.agregarZona(vip1);
        c1.agregarZona(general1);

        Zona vip2 = new Zona("VIP", 8, 180, c2);
        Zona general2 = new Zona("General", 12, 90, c2);
        vip2.generarEntradas();
        general2.generarEntradas();
        c2.agregarZona(vip2);
        c2.agregarZona(general2);

        conciertos.add(c1);
        conciertos.add(c2);
    }

    private void llenarComboConciertos() {
        vista.cmbConcierto.removeAllItems();
        for (Concierto c : conciertos) {
            vista.cmbConcierto.addItem(c.getNombre());
        }
    }

    private void llenarComboZonas(Concierto concierto) {
        vista.cmbZona.removeAllItems();
        for (Zona z : concierto.getZonas()) {
            vista.cmbZona.addItem(z.getNombre());
        }
    }

    private void mostrarEntradas(Zona zona) {
        vista.txtEntradas.setText("");
        for (Entrada e : zona.mostrarEntrada()) {
            vista.txtEntradas.append("Entrada " + e.getNumero() + " - " + e.getEstado() + "\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.cmbConcierto) {
            String nombreConcierto = (String) vista.cmbConcierto.getSelectedItem();
            for (Concierto c : conciertos) {
                if (c.getNombre().equals(nombreConcierto)) {
                    conciertoSeleccionado = c;
                    llenarComboZonas(c);
                }
            }
        }

        if (e.getSource() == vista.cmbZona && conciertoSeleccionado != null) {
            String nombreZona = (String) vista.cmbZona.getSelectedItem();
            for (Zona z : conciertoSeleccionado.getZonas()) {
                if (z.getNombre().equals(nombreZona)) {
                    zonaSeleccionada = z;
                    mostrarEntradas(z);
                }
            }
        }

        if (e.getSource() == vista.btnComprar && zonaSeleccionada != null) {
            try {
                int cantidad = Integer.parseInt(vista.txtCantidad.getText());
                if (cantidad <= 0 || cantidad > 4) {
                    JOptionPane.showMessageDialog(vista, "Máximo puedes comprar 4 entradas.");
                    return;
                }

                total = cantidad * (int) zonaSeleccionada.getPrecio();
                vista.lblTotal.setText("S/ " + total);
                abrirFrmVenta(cantidad, total);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Ingresa una cantidad válida.");
            }
        }

        if (e.getSource() == vista.btnCancelar) {
            vista.dispose();
        }
    }

    private void abrirFrmVenta(int cantidad, int total) {
        Venta venta = new Venta(new Date(), total, new Persona("Juan Carlos"));

        venta.setConcierto(conciertoSeleccionado);
        venta.setZona(zonaSeleccionada);
        venta.setCantidad(cantidad);

        frmVenta vistaVenta = new frmVenta();
        new ControladorVenta(vistaVenta, venta);
        vistaVenta.setVisible(true);
    }
}