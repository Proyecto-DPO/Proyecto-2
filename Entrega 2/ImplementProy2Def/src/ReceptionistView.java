import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReceptionistView {

    public static void showReceptionistView(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        // Configuración de la ventana
        JFrame frame = new JFrame("Gestión de Reservas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Panel de entrada de datos de huéspedes
        JPanel panelDatosHuespedes = new JPanel();
        panelDatosHuespedes.setLayout(new GridLayout(3, 2));
        panelDatosHuespedes.add(new JLabel("Nombre:"));
        JTextField txtNombre = new JTextField();
        panelDatosHuespedes.add(txtNombre);
        panelDatosHuespedes.add(new JLabel("Apellidos:"));
        JTextField txtApellidos = new JTextField();
        panelDatosHuespedes.add(txtApellidos);
        panelDatosHuespedes.add(new JLabel("Número de personas:"));
        JTextField txtNumPersonas = new JTextField();
        panelDatosHuespedes.add(txtNumPersonas);

        // Panel de entrada de datos de la reserva
        JPanel panelDatosReserva = new JPanel();
        panelDatosReserva.setLayout(new GridLayout(2, 2));
        panelDatosReserva.add(new JLabel("Número de habitaciones:"));
        JTextField txtNumHabitaciones = new JTextField();
        panelDatosReserva.add(txtNumHabitaciones);
        panelDatosReserva.add(new JLabel("Número de días:"));
        JTextField txtNumDias = new JTextField();
        panelDatosReserva.add(txtNumDias);

        // Panel de botones de acción
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        JButton btnCrearReserva = new JButton("Crear Reserva");
        btnCrearReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para crear la reserva
            }
        });
        panelBotones.add(btnCrearReserva);
        JButton btnGenerarFactura = new JButton("Generar Factura");
        btnGenerarFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para generar la factura
            }
        });
        panelBotones.add(btnGenerarFactura);
        JButton btnConsultarInventario = new JButton("Consultar Inventario");
        btnConsultarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para consultar el inventario de habitaciones
            }
        });
        panelBotones.add(btnConsultarInventario);
        JButton btnCancelarReserva = new JButton("Cancelar Reserva");
        btnCancelarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para cancelar la reserva
            }
        });
        panelBotones.add(btnCancelarReserva);

        // Añadir paneles a la ventana
        frame.getContentPane().setLayout(new GridLayout(3, 1));
        frame.getContentPane().add(panelDatosHuespedes);
        frame.getContentPane().add(panelDatosReserva);
        frame.getContentPane().add(panelBotones);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

}
