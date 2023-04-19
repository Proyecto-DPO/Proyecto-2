package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JLabel lblTitle, lblUser, lblPassword;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnCancel;
    private Hotel hotel = new Hotel();

    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        lblTitle = new JLabel("Login Form");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);

        lblUser = new JLabel("Username:");
        lblPassword = new JLabel("Password:");

        txtUser = new JTextField(20);
        txtPassword = new JPasswordField(20);

        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);

        add(lblTitle, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);

        setVisible(true);
    }

    /**
     * Maneja los eventos de los botones login y cancel.
     * Si se presiona el botón login, verifica si el usuario y la contraseña son correctos.
     * Si se presiona el botón cancel, cierra la ventana de login.
     * @param e el evento que desencadena la acción
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String user = txtUser.getText();
            String password = new String(txtPassword.getPassword());
            Usuario usuario = this.hotel.getUsuario(user, password);
            if (usuario != null) {
                JOptionPane.showMessageDialog(this, "Welcome, " + user + "!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnCancel) {
            dispose();
        }
    }

    /**
     * Crea una instancia de la clase Login y la muestra en la pantalla.
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        try {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            Login login = new Login();
            login.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
