/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import datos.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import vista.frmAdministrador;
import vista.frmAgregarPersona;
import java.util.ArrayList;


public class ControladorAdministrador implements ActionListener {

    private frmAdministrador vista;
    private ArrayList<Persona> listaPersonas;
    private DefaultTableModel modeloTabla;

    public ControladorAdministrador(frmAdministrador vista) {
        this.vista = vista;
        this.listaPersonas = Repositorio.obtenerPersonas(); 

        this.modeloTabla = (DefaultTableModel) vista.tblUsuarios.getModel();
        this.vista.tblUsuarios.setModel(modeloTabla);

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);

        refrescarTabla(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            frmAgregarPersona frm = new frmAgregarPersona();
            ControladorAgregarPersona ctrl = new ControladorAgregarPersona(frm, this);
            frm.setVisible(true);
        } else if (e.getSource() == vista.btnEliminar) {
            eliminarPersona();
        } else if (e.getSource() == vista.btnSalir) {
            vista.dispose(); 
            vista.frmLogin login = new vista.frmLogin("admin");
            controlador.ControladorLogin ctrlLogin = new controlador.ControladorLogin(login);
            login.setVisible(true);
        }
    }

    public void agregarPersona(Persona p) {
        listaPersonas.add(p);
        refrescarTabla();
    }

    private void eliminarPersona() {
        int fila = vista.tblUsuarios.getSelectedRow();
        if (fila >= 0) {
            listaPersonas.remove(fila);
            refrescarTabla();
            JOptionPane.showMessageDialog(vista, "Persona eliminada.");
        } else {
            JOptionPane.showMessageDialog(vista, "Selecciona una fila para eliminar.");
        }
    }

    private void refrescarTabla() {
        modeloTabla.setRowCount(0);
        for (Persona p : listaPersonas) {
            modeloTabla.addRow(new Object[]{
                p.getNombre(),
                p.getApellido(),
                p.getDni(),
                p.getUsuario(),
                p.getContraseña(),
                p.getTarjeta().getNumero(),
                p.getTarjeta().getCvv()
            });
        }
    }
}