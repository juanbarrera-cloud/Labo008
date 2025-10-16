
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.frmLogin;
import vista.frmMenu; 

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

            if (usuario.equals("admin") && contraseña.equals("1234")) {
                JOptionPane.showMessageDialog(vista, "Bienvenido " + usuario + "!");
                
                frmMenu menu = new frmMenu();
                menu.setVisible(true);                
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos");
            }
        }

        if (e.getSource() == vista.btnSalir) {
            System.exit(0);
        }
    }
}