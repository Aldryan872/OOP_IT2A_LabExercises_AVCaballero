import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * ArithmeticApp is a simple math practice application built using Java Swing,
 * based on the provided sketch.
 * It generates random arithmetic problems and checks the user's answers.
 */
public class ArithmeticApp extends JFrame {

    // --- Core Model Variables ---
    private int num1, num2;
    private String operator;
    private double correctAnswer;
    private int difficultyLevel = 1; // 1: Easy (0-10), 2: Medium (10-50), 3: Hard (50-200)

    // --- GUI Components ---
    private JLabel num1Label, operatorLabel, num2Label, equalsLabel;
    private JTextField answerField;
    private JButton submitButton;
    private JLabel feedbackLabel;
    private ButtonGroup operationGroup; // For radio buttons

    private final Random random = new Random();

    /**
     * Constructor sets up the main application frame and UI.
     */
    public ArithmeticApp() {
        // Set up the main window (JFrame)
        setTitle("Arithmetic Course");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Prevents resizing and disables the maximize button
        // Use a clean layout for the main structure
        setLayout(new BorderLayout(10, 10));

        // Initialize UI components
        initComponents();

        // Generate the first problem
        generateNewProblem();

        // Final window settings
        pack(); // Adjusts size to fit components
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    /**
     * Initializes all GUI components and sets up the layout.
     */
    private void initComponents() {
        // --- 1. Problem Panel (Top/Center) ---
        JPanel problemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        
        // Components for the math problem display (like 53 + 12 = ?)
        num1Label = new JLabel("?");
        operatorLabel = new JLabel("+");
        num2Label = new JLabel("?");
        equalsLabel = new JLabel("=");
        answerField = new JTextField(5); // Text field for user input (like 32 in the sketch)
        submitButton = new JButton("Submit");
        
        // Style the labels and text field (using basic colors and fonts for aesthetic)
        Font problemFont = new Font("SansSerif", Font.BOLD, 24);
        num1Label.setFont(problemFont);
        operatorLabel.setFont(problemFont);
        num2Label.setFont(problemFont);
        equalsLabel.setFont(problemFont);
        answerField.setFont(problemFont);
        answerField.setHorizontalAlignment(JTextField.CENTER);
        
        // Add components to the problem panel
        problemPanel.add(num1Label);
        problemPanel.add(operatorLabel);
        problemPanel.add(num2Label);
        problemPanel.add(equalsLabel);
        problemPanel.add(answerField);
        problemPanel.add(submitButton);

        // --- 2. Feedback Panel (Below Problem) ---
        feedbackLabel = new JLabel("Ready to start!", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("SansSerif", Font.ITALIC, 16));
        feedbackLabel.setPreferredSize(new Dimension(getWidth(), 30));

        // --- 3. Settings Panel (Left/Bottom) ---
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        settingsPanel.setBorder(BorderFactory.createTitledBorder("Settings"));
        
        // Operation Selection (Radio Buttons)
        settingsPanel.add(new JLabel("Operation:"));
        operationGroup = new ButtonGroup();
        
        JRadioButton addRadio = new JRadioButton("a. Addition (+)", true); // Default
        addRadio.setActionCommand("+");
        JRadioButton subRadio = new JRadioButton("b. Subtraction (-)");
        subRadio.setActionCommand("-");
        JRadioButton mulRadio = new JRadioButton("c. Multiplication (x)");
        mulRadio.setActionCommand("*");
        JRadioButton divRadio = new JRadioButton("d. Division (/)");
        divRadio.setActionCommand("/");

        // Add action listener to update problem immediately on change
        ActionListener operationListener = e -> {
            operator = e.getActionCommand();
            generateNewProblem();
        };

        addRadio.addActionListener(operationListener);
        subRadio.addActionListener(operationListener);
        mulRadio.addActionListener(operationListener);
        divRadio.addActionListener(operationListener);

        operationGroup.add(addRadio);
        operationGroup.add(subRadio);
        operationGroup.add(mulRadio);
        operationGroup.add(divRadio);
        
        settingsPanel.add(addRadio);
        settingsPanel.add(subRadio);
        settingsPanel.add(mulRadio);
        settingsPanel.add(divRadio);
        
        settingsPanel.add(Box.createVerticalStrut(10)); // Spacer

        // Level Selection (Dropdown/Combo Box)
        settingsPanel.add(new JLabel("Level:"));
        String[] levels = {"a. Level 1 (0-10)", "b. Level 2 (10-50)", "c. Level 3 (50-200)"};
        JComboBox<String> levelSelector = new JComboBox<>(levels);
        levelSelector.addActionListener(e -> {
            // Determine difficulty level based on selection index
            difficultyLevel = levelSelector.getSelectedIndex() + 1;
            generateNewProblem();
        });
        settingsPanel.add(levelSelector);


        // --- 4. Wire up the Submit Button ---
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        // --- 5. Assemble the Main Frame ---
        
        // Top container for problem and feedback
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.add(problemPanel, BorderLayout.CENTER);
        mainContent.add(feedbackLabel, BorderLayout.SOUTH);
        
        // Container for the settings panel to align it to the left at the bottom
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        bottomPanel.add(settingsPanel);

        // Add components to the JFrame
        add(mainContent, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH); // Place settings panel at the bottom-left

        // Initialize the default operator
        operator = "+";
    }

    /**
     * Generates two random numbers and calculates the correct answer based on
     * the current operator and difficulty level.
     */
    private void generateNewProblem() {
        int range;
        int minNum;
        
        switch (difficultyLevel) {
            case 1: // Easy: 0-10
                minNum = 0;
                range = 10;
                break;
            case 2: // Medium: 10-50
                minNum = 10;
                range = 40; // Range between 10 and 50
                break;
            case 3: // Hard: 50-200
                minNum = 50;
                range = 150; // Range between 50 and 200
                break;
            default:
                minNum = 0;
                range = 10;
        }

        num1 = random.nextInt(range) + minNum;
        num2 = random.nextInt(range) + minNum;

        // Ensure division doesn't result in non-integer or division by zero for basic levels
        if ("/".equals(operator)) {
            // Prevent division by zero
            if (num2 == 0) {
                num2 = random.nextInt(range) + 1; // Ensure num2 > 0
            }
            // Ensure whole number result
            num1 = (num1 / num2) * num2;
            correctAnswer = (double)num1 / num2;
        } else if ("-".equals(operator)) {
             // For subtraction, ensure num1 >= num2 for non-negative result practice
             if (num1 < num2) {
                 int temp = num1;
                 num1 = num2;
                 num2 = temp;
             }
             correctAnswer = num1 - num2;
        } else if ("*".equals(operator)) {
            correctAnswer = (double)num1 * num2;
        } else { // Default to "+"
            correctAnswer = (double)num1 + num2;
            operator = "+"; // Reset operator if it was something unexpected
        }

        // Update the display
        num1Label.setText(String.valueOf(num1));
        operatorLabel.setText(operator);
        num2Label.setText(String.valueOf(num2));
        feedbackLabel.setText(" "); // Clear previous feedback
        feedbackLabel.setForeground(UIManager.getColor("Label.foreground")); // Reset color
        answerField.setText(""); // Clear previous answer
        answerField.requestFocusInWindow(); // Focus the input field
    }

    /**
     * Checks the user's input against the correct answer.
     */
    private void checkAnswer() {
        try {
            double userAnswer = Double.parseDouble(answerField.getText().trim());

            // Simple comparison, rounded to handle potential float inaccuracies from division
            if (Math.abs(userAnswer - correctAnswer) < 0.0001) {
                feedbackLabel.setText("Correct! Well done. Generating new problem...");
                feedbackLabel.setForeground(new Color(34, 139, 34)); // Forest Green
                // Pause briefly before generating a new problem for better user experience
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateNewProblem();
                        ((Timer)e.getSource()).stop();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                feedbackLabel.setText("Incorrect. Try again, or click Submit for a new problem.");
                feedbackLabel.setForeground(new Color(220, 20, 60)); // Crimson Red
                // Optionally, show the correct answer after a few incorrect attempts
            }

        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Please enter a valid number.");
            feedbackLabel.setForeground(Color.ORANGE);
        }
    }

    /**
     * Main method to run the application.
     */
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        SwingUtilities.invokeLater(() -> {
            new ArithmeticApp();
        });
    }
}