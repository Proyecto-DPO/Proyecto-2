import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    private static final Font titleFont = new Font("Arial", Font.BOLD, 28);
    private static final Font labelFont = new Font("Arial", Font.BOLD, 14);
    private static final Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
    private static final Font buttonFont = new Font("Arial", Font.BOLD, 14);
    private static final Color bgColor = new Color(240, 240, 240);

    public static void showLoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(bgColor);
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(titleFont);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(bgColor);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        formPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setFont(textFieldFont);
        formPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        formPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(textFieldFont);
        formPanel.add(passwordField);

        frame.add(formPanel, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(buttonFont);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
        
                String accountType = authenticate(username, password);
        
                if (accountType.equals("manager")) {
                    ManagerView managerView = new ManagerView();
                    managerView.ShowManagerView();
                    frame.dispose();
                } else if (accountType.equals("employee")) {
                    EmployeeView employeeView = new EmployeeView();
                    employeeView.showEmployeeView(null);
                    frame.dispose();
                } else if (accountType.equals("receptionist")) {
                    ReceptionistView receptionistView = new ReceptionistView();
                    receptionistView.showReceptionistView(null);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(bgColor);
        buttonPanel.add(loginButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static String authenticate(String username, String password) {
        if (username.equals("manager") && password.equals("manager")) {
            return "manager";
        } else if (username.equals("employee") && password.equals("employee")) {
            return "employee";

        } else if (username.equals("receptionist") && password.equals("receptionist")) {
            return "receptionist";
        } else {
            return "invalid";
        }
    }
}
