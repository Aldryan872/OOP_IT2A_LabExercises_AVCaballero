package com.health.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;


public class SignupForm extends JFrame {

    private static final Color PRIMARY_BLUE = new Color(0, 123, 255);
    private static final Color SECONDARY_GREY = new Color(235, 235, 235);
    private static final Font LABEL_FONT = new Font("Segoe UI", Font.BOLD, 12);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 24);
    
    private JComboBox<String> titleCombo;
    private JTextField lastNameField;
    private JTextField middleNameField;
    private JTextField firstNameField;
    private JTextField birthdateField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox termsCheck;

    public SignupForm() {
        // --- Frame Setup ---
        setTitle("Sign Up");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

      
        JLabel headerLabel = new JLabel("SIGN UP");
        headerLabel.setFont(TITLE_FONT);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 25, 5); // Extra bottom margin
        mainPanel.add(headerLabel, gbc);

        
        gbc.gridwidth = 1;
        gbc.insets = new Insets(8, 8, 8, 8);

       
        // Using a helper method to keep the constructor clean
        int currentRow = 1;
        titleCombo = new JComboBox<>(new String[]{"Mr.", "Ms.", "Mrs.", "Dr."});
        addField(mainPanel, gbc, "Title", titleCombo, currentRow++);

        lastNameField = new JTextField(20);
        addField(mainPanel, gbc, "Last Name", lastNameField, currentRow++);

        middleNameField = new JTextField(20);
        addField(mainPanel, gbc, "Middle Name", middleNameField, currentRow++);

        firstNameField = new JTextField(20);
        addField(mainPanel, gbc, "First Name", firstNameField, currentRow++);

        birthdateField = new JTextField(20);
        addField(mainPanel, gbc, "Birthdate (YYYY-MM-DD)", birthdateField, currentRow++);

        emailField = new JTextField(20);
        addField(mainPanel, gbc, "Email", emailField, currentRow++);

        passwordField = new JPasswordField(20);
        addField(mainPanel, gbc, "Password", passwordField, currentRow++);

        termsCheck = new JCheckBox("I agree to the terms and conditions.");
        termsCheck.setFont(LABEL_FONT);
        termsCheck.setBackground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = currentRow++;
        gbc.gridwidth = 2;
        mainPanel.add(termsCheck, gbc);

        
        JButton signupButton = new JButton("SIGN UP");
        signupButton.setFont(LABEL_FONT);
        signupButton.setBackground(PRIMARY_BLUE);
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        gbc.gridy = currentRow;
        gbc.insets = new Insets(20, 8, 8, 8); // Extra top margin
        mainPanel.add(signupButton, gbc);

        
        signupButton.addActionListener(e -> {
            // Basic validation example
            if (firstNameField.getText().trim().isEmpty() || lastNameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "First Name and Last Name are required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else if (!termsCheck.isSelected()) {
                JOptionPane.showMessageDialog(this, "You must agree to the terms and conditions.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Sign up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(mainPanel, BorderLayout.CENTER);
    }

    private void addField(JPanel panel, GridBagConstraints gbc, String labelText, JComponent component, int yPos) {
        JLabel label = new JLabel(labelText);
        label.setFont(LABEL_FONT);
        gbc.gridx = 0;
        gbc.gridy = yPos;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(component, gbc);
    }

 
     
    public static void main(String[] args) {
        // Run the UI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new SignupForm().setVisible(true));
    }
}
