
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.frmLogin;
import vista.frmMenu;
import vista.frmAdministrador; 
import controlador.ControladorMenu;
import controlador.ControladorAdministrador; 
import modelo.Persona;

public class ControladorLogin implements ActionListener {

    private frmLogin vista;

    public ControladorLogin(frmLogin vista) {
        this.vista = vista;
        this.vista.btnIngresar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar) {

            String usuario = vista.txtUsuario.getText().trim();
            String contraseña = String.valueOf(vista.txtContraseña.getPassword());
            String tipoUsuario = vista.getTipoUsuario();

            if (tipoUsuario == null || tipoUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Error: tipo de usuario no definido.");
                return;
            }
            if (tipoUsuario.equalsIgnoreCase("admin")) {
                if (usuario.equals("admin") && contraseña.equals("1234")) {
                    JOptionPane.showMessageDialog(vista, "👑 Bienvenido Administrador");
                    frmAdministrador admin = new frmAdministrador();
                    ControladorAdministrador ctrlAdmin = new ControladorAdministrador(admin); 
                    admin.setVisible(true);
                    vista.dispose();
                } else {
                    JOptionPane.showMessageDialog(vista, "Credenciales de administrador incorrectas");
                }
            }
            else if (tipoUsuario.equalsIgnoreCase("comprador")) {
                boolean accesoPermitido = false;

                for (Persona p : datos.Repositorio.listaPersonas) { 
                    if (p.getUsuario().equals(usuario) && p.getContraseña().equals(contraseña)) {
                        accesoPermitido = true;
                        break;
                    }
                }

                if (accesoPermitido) {
                    JOptionPane.showMessageDialog(vista, "Bienvenido " + usuario + "!");
                    frmMenu menu = new frmMenu();
                    ControladorMenu ctrlMenu = new ControladorMenu(menu);
                    menu.setVisible(true);
                    vista.dispose();
                } else {
                    JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos");
                }
            }
        }
            else if (e.getSource() == vista.btnSalir) {
                vista.dispose(); 
                vista.frmInicio inicio = new vista.frmInicio();
                controlador.ControladorInicio ctrlInicio = new controlador.ControladorInicio(inicio);
                inicio.setVisible(true);
            }
    }
}