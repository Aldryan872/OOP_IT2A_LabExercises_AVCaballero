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
