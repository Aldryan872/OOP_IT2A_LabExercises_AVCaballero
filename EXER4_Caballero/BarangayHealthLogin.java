import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BarangayHealthLogin extends HealthSystem implements Authenticable {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, registerButton;
    private EnhancedAuthenticationService authService;

    public BarangayHealthLogin() {
        super("Barangay Health Center - Login", "Barangay Health Login System", new Color(0, 100, 180));
        this.authService = new EnhancedAuthenticationService();
        setSize(400, 300);
        initializeSystem(); // Using template method
        setupEventListeners();
    }

    @Override
    public void initializeComponents() {
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        clearButton = new JButton("Clear");
        registerButton = new JButton("Register");

        // Polymorphism: Using different button styles based on type
        styleAuthButton(loginButton);
        styleUtilityButton(clearButton);
        styleAuthButton(registerButton);
    }

    @Override
    public void layoutComponents() {
        setLayout(new BorderLayout(10, 10));

        // Header using polymorphic method from base class
        add(createHeaderPanel("BARANGAY HEALTH CENTER LOGIN"), BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("Username:"));
        mainPanel.add(usernameField);
        mainPanel.add(new JLabel("Password:"));
        mainPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(registerButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void showSystemInfo() {
        System.out.println("Login System Info:");
        System.out.println("- Manages user authentication");
        System.out.println("- Provides registration functionality");
        System.out.println("- Secure password handling");
    }

    // Interface method implementation
    @Override
    public boolean authenticate(String username, String password) {
        logAuthenticationAttempt(username); // Using default interface method
        return authService.authenticate(username, password);
    }

    @Override
    public void handleAuthenticationSuccess() {
        JOptionPane.showMessageDialog(this, "Login Successful! Opening Dashboard...");
        openMainApplication();
    }

    @Override
    public void handleAuthenticationFailure() {
        JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Overriding base class method for polymorphic behavior
    @Override
    public void displayWelcomeMessage() {
        System.out.println("=== Barangay Health Center Authentication System ===");
        System.out.println("Please login to access the health management system");
    }

    // Polymorphic method overloading
    public void attemptLogin() {
        attemptLogin(usernameField.getText(), new String(passwordField.getPassword()));
    }

    private void attemptLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password");
            return;
        }

        if (authenticate(username, password)) {
            handleAuthenticationSuccess();
        } else {
            handleAuthenticationFailure();
        }
    }

    private void openMainApplication() {
        dispose();
        // Polymorphism: Using base class reference for subclass object
        HealthSystem dashboard = new DoctorDetails();
        dashboard.setVisible(true);
    }

    // Event handling setup
    private void setupEventListeners() {
        loginButton.addActionListener(e -> attemptLogin());

        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        registerButton.addActionListener(e -> openRegistrationForm());

        passwordField.addActionListener(e -> attemptLogin());
    }

    private void openRegistrationForm() {
        JDialog registerDialog = new JDialog(this, "Registration", true);
        registerDialog.setSize(300, 200);
        registerDialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        JTextField userField = new JTextField();
        panel.add(userField);

        panel.add(new JLabel("Password:"));
        JPasswordField passField = new JPasswordField();
        panel.add(passField);

        JButton registerBtn = new JButton("Register");
        panel.add(registerBtn);

        registerBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(registerDialog, "Registration complete!");
            registerDialog.dispose();
        });

        registerDialog.add(panel);
        registerDialog.setVisible(true);
    }
}
