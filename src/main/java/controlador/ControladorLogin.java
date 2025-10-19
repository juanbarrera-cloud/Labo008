
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.frmLogin;
import vista.frmMenu;
import controlador.ControladorMenu;

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
            String usuario = vista.txtUsuario.getText();
            String contraseña = String.valueOf(vista.txtContraseña.getPassword());

            if (usuario.equals("juancarlos") && contraseña.equals("24200009")) {
                JOptionPane.showMessageDialog(vista, "✅ Bienvenido " + usuario + "!");
                frmMenu menu = new frmMenu();
                controlador.ControladorMenu ctrlMenu = new controlador.ControladorMenu(menu);
                menu.setVisible(true);

                vista.dispose();

            } else {
                JOptionPane.showMessageDialog(vista, "❌ Usuario o contraseña incorrectos");
            }
        }
        if (e.getSource() == vista.btnSalir) {
            int confirm = JOptionPane.showConfirmDialog(
                vista,
                "¿Seguro que deseas salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}