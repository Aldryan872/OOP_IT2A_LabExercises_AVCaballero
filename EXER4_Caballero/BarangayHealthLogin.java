import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BarangayHealthLogin extends JFrame implements Authenticable {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton, registerButton;
    private JCheckBox showPasswordCheckBox;
    private Image backgroundImage;
    private Image logoImage;
    private boolean loggedIn = false;
    
    // Polymorphic collection - can hold any HealthSystemUser
    private List<HealthSystemUser> users = new ArrayList<>();
    
    public BarangayHealthLogin() {
        setTitle("Barangay Health Center - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        // Load images
        try {
            backgroundImage = ImageIO.read(new File("lib/background picture.jpg"));
            logoImage = ImageIO.read(new File("lib/logo.jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading images: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Initialize some sample users demonstrating polymorphism
        initializeUsers();
        initComponents();
        layoutComponents();
        addEventListeners();
    }
    
    private void initializeUsers() {
        // Adding different types of users to the same collection - polymorphism
        users.add(new Doctor("drjohn", "doctor123", "Dr. John Smith", "drjohn@health.com", 
                           "Cardiology", "MD", "Male", "555-1234"));
        users.add(new Doctor("drsarah", "doctor456", "Dr. Sarah Johnson", "drsarah@health.com", 
                           "Pediatrics", "MD", "Female", "555-5678"));
        // Can add more user types here in the future
    }
    
    // Interface method implementation
    @Override
    public boolean login(String username, String password) {
        for (HealthSystemUser user : users) {
            if (user.authenticate(username, password)) {
                loggedIn = true;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void logout() {
        loggedIn = false;
    }
    
    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }

    private void initComponents() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 120, 215));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(200, 200, 200));
        clearButton.setFocusPainted(false);

        registerButton = new JButton("Register Account");
        registerButton.setBackground(new Color(70, 130, 180));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);

        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setOpaque(false);
        showPasswordCheckBox.setForeground(Color.WHITE);
    }

    private void layoutComponents() {
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        mainPanel.setLayout(new BorderLayout(10, 10));

        // ... (rest of the layout code remains similar to original)
        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 100, 180, 200));
            }
        };
        headerPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("BARANGAY HEALTH CENTER", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(userLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        formPanel.add(usernameField, gbc);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(passLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(passwordField, gbc);

        // Show Password
        gbc.gridx = 1; gbc.gridy = 2;
        formPanel.add(showPasswordCheckBox, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private void addEventListeners() {
        loginButton.addActionListener(e -> attemptLogin());
        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });
        showPasswordCheckBox.addActionListener(e -> {
            passwordField.setEchoChar(showPasswordCheckBox.isSelected() ? (char) 0 : '•');
        });
    }

    private void attemptLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password");
            return;
        }

        if (login(username, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            displayAuthStatus(); // Using interface default method
            openMainApplication();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    private void openMainApplication() {
        dispose();
        // Open the doctor details application
        javax.swing.SwingUtilities.invokeLater(() -> {
            new DoctorDetailsSystem();
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            new BarangayHealthLogin().setVisible(true);
        });
    }
}
