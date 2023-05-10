import javax.swing.*;
import java.awt.*;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

public class EmployeeView {

    public static void showEmployeeView(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Check in, register user");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.setLayout(new BorderLayout());

        frame.add(createTitleMenuPanel(), BorderLayout.NORTH);
        frame.add(createBodyPanel(), BorderLayout.CENTER);
        frame.add(createButtonPanel(), BorderLayout.SOUTH);

        applyGlobalStyles(frame);

        frame.setVisible(true);
    }

    private static JPanel createTitleMenuPanel() {
        JPanel titleMenuPanel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Check In");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Register user");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(subtitleLabel);

        JMenuBar menuBar = new JMenuBar();
        Color menuBarColor = new Color(35,68,211);
        menuBar.setBackground(menuBarColor);

        JMenuItem searchItem = new JMenuItem("Search");
        searchItem.addActionListener(e -> {
        });
        menuBar.add(searchItem);

        JMenuItem viewItem = new JMenuItem("View");
        viewItem.addActionListener(e -> {
        });
        menuBar.add(viewItem);

        JMenuItem actionsItem = new JMenuItem("Actions");
        actionsItem.addActionListener(e -> {
        });
        menuBar.add(actionsItem);

        JMenuItem helpItem = new JMenuItem("Help");
        helpItem.addActionListener(e -> {
        });
        menuBar.add(helpItem);

        titleMenuPanel.add(titlePanel, BorderLayout.CENTER);
        titleMenuPanel.add(menuBar, BorderLayout.NORTH);

        return titleMenuPanel;
    }

    private static JPanel createBodyPanel() {
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        bodyPanel.add(createAddressPanel());
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bodyPanel.add(createPrivateInfoPanel());
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bodyPanel.add(createReservationPanel());

        return bodyPanel;
    }

    private static JPanel createAddressPanel() {
        JPanel addressPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        addressPanel.setBorder(BorderFactory.createTitledBorder("Address"));
        addressPanel.add(new JLabel("Address:"));
        addressPanel.add(new JTextField());
        addressPanel.add(new JLabel("City:"));
        addressPanel.add(new JTextField());
        addressPanel.add(new JLabel("Zip code:"));
        addressPanel.add(new JTextField());
        addressPanel.add(new JLabel("State:"));
        addressPanel.add(new JTextField());

        return addressPanel;
    }
    
    private static JPanel createPrivateInfoPanel() {
        JPanel privateInfoPanel = new JPanel(new GridBagLayout());
        privateInfoPanel.setBorder(BorderFactory.createTitledBorder("Private Information"));
    
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.insets = new Insets(2, 2, 2, 2);
        privateInfoPanel.add(new JLabel("First/middle:"), c);
    
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        privateInfoPanel.add(new JTextField(15), c);
    
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        privateInfoPanel.add(new JLabel("Last name:"), c);
    
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.5;
        privateInfoPanel.add(new JTextField(15), c);
    
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        c.insets = new Insets(2, 2, 2, 2);
        privateInfoPanel.add(new JLabel("SSN:"), c);
    
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 0.5;
        privateInfoPanel.add(new JTextField(15), c);
    
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0.5;
        privateInfoPanel.add(new JLabel("Date of Birth:"), c);
    
        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 0.5;
        UtilDateModel dobModel = new UtilDateModel();
        JDatePicker dobDatePicker = new JDatePicker(dobModel);
        privateInfoPanel.add((JComponent) dobDatePicker, c);
    
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 0.5;
        privateInfoPanel.add(new JLabel("Passport:"), c);
    
        c.gridx = 1;
        c.gridy = 4;
        c.weightx = 0.5;
        privateInfoPanel.add(new JTextField(15), c);
    
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 0.5;
        privateInfoPanel.add(new JLabel("Client ID:"), c);
    
        c.gridx = 1;
        c.gridy = 5;
        c.weightx = 0.5;
        privateInfoPanel.add(new JTextField(15), c);
    
        c.gridx = 0;
        c.gridy = 6;
        c.weightx = 0.5;
        privateInfoPanel.add(new JLabel("Email:"), c);
    
        c.gridx = 1;
        c.gridy = 6;
        c.weightx = 0.5;
        privateInfoPanel.add(new JTextField(15), c);
    
        c.gridx = 0;
        c.gridy = 7;
        c.weightx = 0.5;
        privateInfoPanel.add(new JLabel("Phone number:"), c);
    
        c.gridx = 1;
        c.gridy = 7;
        c.weightx = 0.5;
        privateInfoPanel.add(new JTextField(15), c);
    
        return privateInfoPanel;
    }
    
    private static JPanel createReservationPanel() {
        JPanel reservationPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        reservationPanel.setBorder(BorderFactory    .createTitledBorder("Reservation"));

        reservationPanel.add(new JLabel("Arrival:"));
        UtilDateModel arrivalModel = new UtilDateModel();
        JDatePicker arrivalDatePicker = new JDatePicker(arrivalModel);
        reservationPanel.add((JComponent) arrivalDatePicker);
    
        reservationPanel.add(new JLabel("Departure:"));
        UtilDateModel departureModel = new UtilDateModel();
        JDatePicker departureDatePicker = new JDatePicker(departureModel);
        reservationPanel.add((JComponent) departureDatePicker);
    
        reservationPanel.add(new JLabel("Room Type:"));
        String[] roomTypes = {"Single", "Double", "Suite"};
        JComboBox<String> roomTypeComboBox = new JComboBox<>(roomTypes);
        reservationPanel.add(roomTypeComboBox);
    
        return reservationPanel;
    }
    
    private static JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
        });
        buttonPanel.add(clearButton);
    
        buttonPanel.add(Box.createHorizontalGlue());
    
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
        });
        buttonPanel.add(saveButton);
    
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        return buttonPanel;
    }
    
    private static void applyGlobalStyles(JFrame frame) {
        UIManager.put("OptionPane.background", Color.white);
        UIManager.put("Panel.background", Color.white);
        UIManager.put("Button.background", new Color(0, 102, 204));
        UIManager.put("Button.foreground", Color.white);
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("ComboBox.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("MenuBar.background", new Color(0, 102, 204));
        UIManager.put("Menu.foreground", Color.white);
        UIManager.put("Menu.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("MenuItem.foreground", Color.white);
        UIManager.put("MenuItem.font", new Font("Arial", Font.PLAIN, 14));
        SwingUtilities.updateComponentTreeUI(frame);
    }
}    
    
