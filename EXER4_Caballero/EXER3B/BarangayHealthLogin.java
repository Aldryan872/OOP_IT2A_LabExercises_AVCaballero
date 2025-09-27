import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BarangayHealthLogin extends HealthCenterSystem {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public BarangayHealthLogin() {
        super("Barangay Health Center Login");
    }

    @Override
    public void initialize() {
        loginFrame = new JFrame("Barangay Health Center - Login");
        // Initialize login components
        setupLoginComponents();
    }

    @Override
    public void display() {
        loginFrame.setVisible(true);
    }

    private void setupLoginComponents() {
        // Login UI setup code
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header
        JLabel titleLabel = new JLabel("Barangay Health Center Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        formPanel.add(usernameField);

        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        formPanel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> attemptLogin());
        formPanel.add(loginBtn);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        loginFrame.add(mainPanel);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void attemptLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (validateInput(username) && validateInput(password)) {
            if (authenticate(username, password)) {
                showMessage("Login successful!");
                openDashboard();
            } else {
                showMessage("Invalid credentials!");
            }
        }
    }

    private boolean validateInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(loginFrame, msg);
    }

    private boolean authenticate(String username, String password) {
        // Simplified authentication
        return "admin".equals(username) && "admin123".equals(password);
    }

    private void openDashboard() {
        loginFrame.dispose();
        HealthCenterDashboard dashboard = new HealthCenterDashboard();
        dashboard.initialize();
        dashboard.display();
    }
}
