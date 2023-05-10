import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;
import org.jdatepicker.ComponentFormatDefaults;
import org.jdatepicker.DateComponentFormatter;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilCalendarModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class ManagerView {

    private static RoomManager roomManager;

    public ManagerView() {
        this.roomManager = new RoomManager();
    }

    public void ShowManagerView() {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }


    private static JDatePicker createDatePicker() {
        UtilCalendarModel model = new UtilCalendarModel();
        JDatePicker datePicker = new JDatePicker(model);
        datePicker.setTextEditable(true);
        datePicker.setShowYearButtons(true);
        datePicker.getModel().setSelected(true);
        return datePicker;
    }    

    private static void createAndShowGUI() {
        Font titleFont = new Font("Arial", Font.BOLD, 28);
        Font subtitleFont = new Font("Arial", Font.PLAIN, 18);
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        Color bgColor = new Color(240, 240, 240);
        Color panelBorderColor = new Color(200, 200, 200);
        Color menuBarColor = new Color(0, 102, 204);
        Color green = new Color(0, 255, 0);
        Color red = new Color(255, 0, 0);

        JFrame frame = new JFrame("Hotel Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1148, 870);
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(bgColor);
        frame.add(contentPanel, BorderLayout.CENTER);

        createTitleMenuPanel(titleFont, menuBarColor, contentPanel);
        createMainContentPanel(bgColor, panelBorderColor, green, red, contentPanel);
        createCloseButtonPanel(bgColor, contentPanel, frame);        
        createCheckRatesButton(bgColor, contentPanel, frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createTitleMenuPanel(Font titleFont, Color menuBarColor, JPanel contentPanel) {
        JPanel titleMenuPanel = new JPanel(new BorderLayout());
    
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        JLabel titleLabel = new JLabel("Manager View");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);
    
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(menuBarColor);
    
        JMenuItem searchItem = new JMenuItem("Search");
        searchItem.addActionListener(e -> {
        });
        menuBar.add(searchItem);
    
        JMenuItem viewItem = new JMenuItem("View");
        viewItem.addActionListener(e -> {
            int roomCount = roomManager.getRoomCount();
            JOptionPane.showMessageDialog(null, "Number of rooms: " + roomCount);
        });
        menuBar.add(viewItem);
    
        JMenu actionsItem = new JMenu("Actions");
        JMenuItem manageRoomsItem = new JMenuItem("Manage Rooms");
        manageRoomsItem.addActionListener(e -> {
            // Open the manage rooms window
        });
        actionsItem.add(manageRoomsItem);
    
        JMenuItem setPricesItem = new JMenuItem("Set Prices");
        setPricesItem.addActionListener(e -> {
            // Open the set prices window
        });
        actionsItem.add(setPricesItem);
    
        menuBar.add(actionsItem);

        manageRoomsItem.addActionListener(e -> {
            // Open the manage rooms window
            new ManageRoomsView().showWindow();
        });
        actionsItem.add(manageRoomsItem);

        setPricesItem.addActionListener(e -> {
            // Open the set prices window
            new SetPricesView().showWindow();
        });
actionsItem.add(setPricesItem);
    
        JMenuItem helpItem = new JMenuItem("Help");
        helpItem.addActionListener(e -> {
        });
        menuBar.add(helpItem);
    
        titleMenuPanel.add(titlePanel, BorderLayout.CENTER);
        titleMenuPanel.add(menuBar, BorderLayout.NORTH);
        contentPanel.add(titleMenuPanel, BorderLayout.NORTH);
    }        
    
    private static void createMainContentPanel(Color bgColor, Color panelBorderColor, Color green, Color red, JPanel contentPanel) {
        JPanel mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.setBackground(bgColor);
        contentPanel.add(mainContentPanel, BorderLayout.CENTER);
    
        createOccupancyVocContainer(bgColor, panelBorderColor, green, red, mainContentPanel);
        createStaffManagementPanel(bgColor, panelBorderColor, mainContentPanel);
    }
    
    private static void createOccupancyVocContainer(Color bgColor, Color panelBorderColor, Color green, Color red, JPanel mainContentPanel) {
        JPanel occupancyVocContainer = new JPanel(new GridLayout(1, 2));
        mainContentPanel.add(occupancyVocContainer, BorderLayout.CENTER);
    
        createOccupancyPanel(bgColor, panelBorderColor, green, red, occupancyVocContainer);
        createVocPanel(bgColor, panelBorderColor, occupancyVocContainer);
    }
    
    private static void createOccupancyPanel(Color bgColor, Color panelBorderColor, Color green, Color red, JPanel occupancyVocContainer) {
        JPanel occupancyPanel = new JPanel(new BorderLayout());
        occupancyPanel.setBackground(bgColor);
        occupancyPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(panelBorderColor), "Occupancy"));
        occupancyVocContainer.add(occupancyPanel);
    
        JPanel occupancyGrid = new JPanel(new GridLayout(6, 7));
        occupancyPanel.add(occupancyGrid, BorderLayout.CENTER);
    
        Random random = new Random();
        for (int i = 0; i < 42; i++) {
            JButton dayButton = new JButton(String.valueOf(i % 31 + 1));
            dayButton.setFont(new Font("Arial", Font.PLAIN, 14));
            if (random.nextBoolean()) {
                dayButton.setBackground(green);
            } else {
                dayButton.setBackground(red);
            }
            occupancyGrid.add(dayButton);
        }
    }
    
    private static void createVocPanel(Color bgColor, Color panelBorderColor, JPanel occupancyVocContainer) {
        JPanel vocPanel = new JPanel(new BorderLayout());
        vocPanel.setBackground(bgColor);
        vocPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(panelBorderColor), "VOC"));
        occupancyVocContainer.add(vocPanel);
    
        DefaultPieDataset dataset = createPieChartDataset();
        JFreeChart pieChart = createPieChart(bgColor, dataset);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(400, 400));
        vocPanel.add(chartPanel, BorderLayout.CENTER);
    
        createDateRangeFilterPanel(vocPanel);
    }
    
    private static DefaultPieDataset createPieChartDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Score 1", 10);
        dataset.setValue("Score 2", 20);
        dataset.setValue("Score 3", 30);
        dataset.setValue("Score 4", 25);
        dataset.setValue("Score 5", 15);
        return dataset;
    }
    
    private static JFreeChart createPieChart(Color bgColor, DefaultPieDataset dataset) {
        JFreeChart pieChart = ChartFactory.createPieChart("Customer Scores", dataset, false, true, false);
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setNoDataMessage("No data available");
        plot.setBackgroundPaint(bgColor);
        plot.setInteriorGap(0.02);
        return pieChart;
    }
    
    private static void createDateRangeFilterPanel(JPanel vocPanel) {
        JPanel dateRangeFilterPanel =     new JPanel();
        dateRangeFilterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        vocPanel.add(dateRangeFilterPanel, BorderLayout.SOUTH);
    
        createStartEndDateRangeLabelsAndPickers(dateRangeFilterPanel);
    }
    
    private static void createStartEndDateRangeLabelsAndPickers(JPanel dateRangeFilterPanel) {
        Font labelFont = new Font("Arial", Font.BOLD, 14);
    
        JLabel dateRangeStartLabel = new JLabel("Start Date:");
        dateRangeStartLabel.setFont(labelFont);
        dateRangeFilterPanel.add(dateRangeStartLabel);
    
        JDatePicker dateRangeStartPicker = createDatePicker();
        dateRangeFilterPanel.add(dateRangeStartPicker);
    
        JLabel dateRangeEndLabel = new JLabel("End Date:");
        dateRangeEndLabel.setFont(labelFont);
        dateRangeFilterPanel.add(dateRangeEndLabel);
    
        JDatePicker dateRangeEndPicker = createDatePicker();
        dateRangeFilterPanel.add(dateRangeEndPicker);
    }
    
    private static void createStaffManagementPanel(Color bgColor, Color panelBorderColor, JPanel mainContentPanel) {
        JPanel staffManagementPanel = new JPanel(new BorderLayout());
        staffManagementPanel.setBackground(bgColor);
        staffManagementPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(panelBorderColor), "Staff management"));
        mainContentPanel.add(staffManagementPanel, BorderLayout.SOUTH);
    
        createFilterPanel(staffManagementPanel);
        createFilterButtonPanel(staffManagementPanel);
    }
    
    private static void createFilterPanel(JPanel staffManagementPanel) {
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(2, 5, 10, 10));
        filterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        createFilterControls(filterPanel);
    
        staffManagementPanel.add(filterPanel, BorderLayout.NORTH);
    }
    
    private static void createFilterControls(JPanel filterPanel) {
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
    
        createFilterLabelAndTextField("ID:", labelFont, textFieldFont, filterPanel);
        createFilterLabelAndTextField("Indicator:", labelFont, textFieldFont, filterPanel);
        createFilterLabelAndTextField("Area:", labelFont, textFieldFont, filterPanel);
        createFilterLabelAndDatePicker("Date Start:", labelFont, filterPanel);
        createFilterLabelAndDatePicker("Date End:", labelFont, filterPanel);
    }
    
    private static void createFilterLabelAndTextField(String labelText, Font labelFont, Font textFieldFont, JPanel filterPanel) {
        JLabel label = new JLabel(labelText);
        label.setFont(labelFont);
        filterPanel.add(label);
    
        JTextField textField = new JTextField();
        textField.setFont(textFieldFont);
        filterPanel.add(textField);
    }
    
    private static void createFilterLabelAndDatePicker(String labelText, Font labelFont, JPanel filterPanel) {
        JLabel label = new JLabel(labelText);
        label.setFont(labelFont);
        filterPanel.add(label);
    
        JDatePicker datePicker = createDatePicker();
        filterPanel.add(datePicker);
    }
    
    private static void createFilterButtonPanel(JPanel staffManagementPanel) {
        JPanel filterButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
    
        createFilterButtons(filterButtonPanel);
    
        staffManagementPanel.add(filterButtonPanel, BorderLayout.CENTER);
    }
    
    private static void createFilterButtons(JPanel filterButtonPanel) {
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
    
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(buttonFont);
        filterButtonPanel.add(clearButton);
    
        JButton searchButton = new JButton("Search");
        searchButton.setFont(    buttonFont);
        filterButtonPanel.add(searchButton);
    }
    
    private static void createCloseButtonPanel(Color bgColor, JPanel contentPanel, JFrame frame) {
        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        contentPanel.add(closeButtonPanel, BorderLayout.SOUTH);
    
        createCloseButton(closeButtonPanel, frame);
    }
    
    private static void createCloseButton(JPanel closeButtonPanel, JFrame frame) {
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
    
        JButton closeButton = new JButton("Close");
        closeButton.setFont(buttonFont);
        closeButton.addActionListener(e -> {
            frame.dispose();
        });
        closeButtonPanel.add(closeButton);
    }

    private static void createCheckRatesButton(Color bgColor, JPanel contentPanel, JFrame frame) {
        JPanel checkRatesButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        contentPanel.add(checkRatesButtonPanel, BorderLayout.SOUTH);

        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        JButton checkRatesButton = new JButton("Check Rates");
        checkRatesButton.setFont(buttonFont);
        checkRatesButton.addActionListener(e -> {
            checkForMissingRates();    // Add your actual function call here
        });
        checkRatesButtonPanel.add(checkRatesButton);
    }

    private static void checkForMissingRates() {
        // Placeholder function. Replace with actual function to check for missing rates in backend.
        System.out.println("Checking for missing rates...");
    }
    
}
    
    
