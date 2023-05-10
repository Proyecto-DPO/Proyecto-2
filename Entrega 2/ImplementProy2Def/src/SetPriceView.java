import java.awt.*;
import javax.swing.*;

class SetPricesView {

    public void showWindow() {
        JFrame frame = new JFrame("Set Prices");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        JLabel roomTypeLabel = new JLabel("Room Type:");
        String[] types = {"Standard", "Suite", "Double Suite"};
        JComboBox<String> roomTypeField = new JComboBox<>(types);

        JLabel dateRangeLabel = new JLabel("Date Range:");
        JPanel dateRangePanel = new JPanel(new GridLayout(1,2));
        JSpinner startDateField = new JSpinner(new SpinnerDateModel());
        JSpinner endDateField = new JSpinner(new SpinnerDateModel());
        dateRangePanel.add(startDateField);
        dateRangePanel.add(endDateField);

        JLabel daysOfWeekLabel = new JLabel("Days of Week:");
        JPanel daysOfWeekPanel = new JPanel(new GridLayout(1, 7));
        JCheckBox[] dayChecks = new JCheckBox[7];
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < 7; i++) {
            dayChecks[i] = new JCheckBox(daysOfWeek[i]);
            daysOfWeekPanel.add(dayChecks[i]);
        }

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();

        JButton setPriceButton = new JButton("Set Price");
        setPriceButton.addActionListener(e -> {
            // Handle price setting
        });

        panel.add(roomTypeLabel);
        panel.add(roomTypeField);
        panel.add(dateRangeLabel);
        panel.add(dateRangePanel);
        panel.add(daysOfWeekLabel);
        panel.add(daysOfWeekPanel);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(setPriceButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
