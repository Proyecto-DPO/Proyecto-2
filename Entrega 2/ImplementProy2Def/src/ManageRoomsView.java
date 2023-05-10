import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

class ManageRoomsView {

    public void showWindow() {
        JFrame frame = new JFrame("Manage Rooms");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);

        JPanel panel = new JPanel(new GridLayout(8,2));

        JLabel roomNumberLabel = new JLabel("Room Number:");
        JTextField roomNumberField = new JTextField();

        JLabel locationLabel = new JLabel("Location:");
        JTextField locationField = new JTextField();

        JLabel capacityLabel = new JLabel("Capacity:");
        JTextField capacityField = new JTextField();

        JLabel typeLabel = new JLabel("Type:");
        String[] types = {"Standard", "Suite", "Double Suite"};
        JComboBox<String> typeField = new JComboBox<>(types);

        JLabel featuresLabel = new JLabel("Additional Features:");
        JCheckBox balconyCheck = new JCheckBox("Balcony");
        JCheckBox viewCheck = new JCheckBox("View");
        JCheckBox kitchenCheck = new JCheckBox("Integrated Kitchen");

        JButton createRoomButton = new JButton("Create Room");
        createRoomButton.addActionListener(e -> {
            // Handle room creation
        });

        JButton loadRoomsButton = new JButton("Load Rooms From File");
        loadRoomsButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                // Handle file loading
            }
        });

        panel.add(roomNumberLabel);
        panel.add(roomNumberField);
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(capacityLabel);
        panel.add(capacityField);
        panel.add(typeLabel);
        panel.add(typeField);
        panel.add(featuresLabel);
        panel.add(balconyCheck);
        panel.add(new JLabel(""));
        panel.add(viewCheck);
        panel.add(new JLabel(""));
        panel.add(kitchenCheck);
        panel.add(createRoomButton);
        panel.add(loadRoomsButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
