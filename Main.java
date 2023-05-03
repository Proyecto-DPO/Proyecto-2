import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Check in, register user");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JMenuItem("Search"));
        menuBar.add(new JMenuItem("View"));
        menuBar.add(new JMenuItem("Actions"));
        menuBar.add(new JMenuItem("Help"));
        frame.add(menuBar, BorderLayout.NORTH);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout(3, 1));

        JPanel addressPanel = new JPanel(new GridLayout(6, 2));
        addressPanel.add(new JLabel("Address:"));
        addressPanel.add(new JTextField());
        addressPanel.add(new JLabel("City:"));
        addressPanel.add(new JTextField());
        addressPanel.add(new JLabel("Zip code:"));
        addressPanel.add(new JTextField());
        addressPanel.add(new JLabel("State:"));
        addressPanel.add(new JTextField());

        JPanel privateInfoPanel = new JPanel(new GridLayout(6, 2));
        privateInfoPanel.add(new JLabel("First/middle:"));
        privateInfoPanel.add(new JTextField());
        privateInfoPanel.add(new JLabel("Last name:"));
        privateInfoPanel.add(new JTextField());
        privateInfoPanel.add(new JLabel("SSN:"));
        privateInfoPanel.add(new JTextField());
        privateInfoPanel.add(new JLabel("Date of birth:"));
        privateInfoPanel.add(new JTextField());
        privateInfoPanel.add(new JLabel("Passport:"));
        privateInfoPanel.add(new JTextField());
        privateInfoPanel.add(new JLabel("Client id:"));
        privateInfoPanel.add(new JTextField());
        privateInfoPanel.add(new JLabel("Email:"));
        privateInfoPanel.add(new JTextField());
        privateInfoPanel.add(new JLabel("Phone number:"));
        privateInfoPanel.add(new JTextField());

        JPanel reservationPanel = new JPanel(new GridLayout(3, 2));
        reservationPanel.add(new JLabel("Room:"));
        reservationPanel.add(new JTextField());
        reservationPanel.add(new JLabel("Start Date:"));
        reservationPanel.add(new JTextField());
        reservationPanel.add(new JLabel("End Date:"));
        reservationPanel.add(new JTextField());

        bodyPanel.add(addressPanel);
        bodyPanel.add(privateInfoPanel);
        bodyPanel.add(reservationPanel);

        frame.add(bodyPanel, BorderLayout.CENTER);
        frame.setVisible(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);

        JButton backButton = new JButton("<Back");
        buttonPanel.add(backButton);

        JButton nextButton = new JButton("Next>");
        buttonPanel.add(nextButton);

        // Add buttons panel to the frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
