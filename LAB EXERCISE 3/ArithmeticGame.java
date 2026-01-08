import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class ArithmeticGame extends JFrame {
    private JLabel lblNum1, lblNum2, lblOperation, lblCorrect, lblIncorrect, lblFeedback;
    private JTextField txtAnswer;
    private JButton btnGo, btnSubmit, btnNext, btnExit;
    private JRadioButton rbAdd, rbSub, rbMul, rbDiv, rbMod;
    private JRadioButton rbLvl1, rbLvl2, rbLvl3;
    private ButtonGroup operationGroup, levelGroup;

    private int num1, num2, levelMin, levelMax, correctCount = 0, incorrectCount = 0;
    private String operation;
    private Random rand = new Random();

    public ArithmeticGame() {
        setTitle("Arithmetic Game");
        setSize(972, 689);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 25);
        Color brown = new Color(40, 116, 166);

        // ✅ Main JPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 972, 689);
        mainPanel.setBackground(new Color(214, 234, 248));
        add(mainPanel);

        // Labels for numbers and operation
        lblNum1 = new JLabel(" ", SwingConstants.CENTER);
        lblNum1.setBounds(74, 98, 172, 116);
        lblNum1.setOpaque(true);
        lblNum1.setBackground(brown);
        lblNum1.setForeground(Color.WHITE);
        lblNum1.setFont(font);

        lblOperation = new JLabel(" ", SwingConstants.CENTER);
        lblOperation.setBounds(291, 126, 64, 61);
        lblOperation.setOpaque(true);
        lblOperation.setBackground(brown);
        lblOperation.setForeground(Color.WHITE);

        lblNum2 = new JLabel(" ", SwingConstants.CENTER);
        lblNum2.setBounds(400, 98, 172, 116);
        lblNum2.setOpaque(true);
        lblNum2.setBackground(brown);
        lblNum2.setForeground(Color.WHITE);
        lblNum2.setFont(font);

        JLabel lblEqual = new JLabel("=", SwingConstants.CENTER);
        lblEqual.setBounds(617, 126, 64, 61);
        lblEqual.setOpaque(true);
        lblEqual.setBackground(brown);
        lblEqual.setForeground(Color.WHITE);

        txtAnswer = new JTextField();
        txtAnswer.setBounds(726, 99, 172, 116);
        txtAnswer.setFont(font);
        txtAnswer.setHorizontalAlignment(JTextField.CENTER);

        // Feedback label
        lblFeedback = new JLabel("", SwingConstants.CENTER);
        lblFeedback.setBounds(74, 301, 597, 114);
        lblFeedback.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        lblFeedback.setFont(new Font("Arial", Font.ITALIC, 22));

        // Buttons
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(726, 291, 172, 70);
        btnSubmit.setBackground(brown);
        btnSubmit.setForeground(Color.WHITE);

        btnNext = new JButton("Next");
        btnNext.setBounds(819, 384, 79, 48);
        btnNext.setBackground(brown);
        btnNext.setForeground(Color.WHITE);

        btnExit = new JButton("Exit");
        btnExit.setBounds(726, 384, 79, 48);
        btnExit.setBackground(brown);
        btnExit.setForeground(Color.WHITE);

        // Operation Radio Buttons
        JLabel lblOp = new JLabel("Operation:");
        lblOp.setBounds(62, 459, 89, 19);

        rbAdd = new JRadioButton("Addition");
        rbSub = new JRadioButton("Subtraction");
        rbMul = new JRadioButton("Multiplication");
        rbDiv = new JRadioButton("Division");
        rbMod = new JRadioButton("Modulo");

        rbAdd.setBounds(95, 492, 120, 19);
        rbSub.setBounds(95, 516, 120, 19);
        rbMul.setBounds(95, 540, 120, 19);
        rbDiv.setBounds(95, 564, 120, 19);
        rbMod.setBounds(95, 588, 120, 19);

        operationGroup = new ButtonGroup();
        operationGroup.add(rbAdd);
        operationGroup.add(rbSub);
        operationGroup.add(rbMul);
        operationGroup.add(rbDiv);
        operationGroup.add(rbMod);

        // Level Radio Buttons
        JLabel lblLvl = new JLabel("Level:");
        lblLvl.setBounds(341, 459, 50, 19);

        rbLvl1 = new JRadioButton("Level 1 (1-100)");
        rbLvl2 = new JRadioButton("Level 2 (101-200)");
        rbLvl3 = new JRadioButton("Level 3 (201-300)");

        rbLvl1.setBounds(375, 490, 140, 19);
        rbLvl2.setBounds(375, 514, 140, 19);
        rbLvl3.setBounds(375, 538, 140, 19);

        levelGroup = new ButtonGroup();
        levelGroup.add(rbLvl1);
        levelGroup.add(rbLvl2);
        levelGroup.add(rbLvl3);

        btnGo = new JButton("GO");
        btnGo.setBounds(399, 570, 92, 37);
        btnGo.setBackground(brown);
        btnGo.setForeground(Color.WHITE);

        // Score boxes
        JLabel lblScore = new JLabel("Score:");
        lblScore.setBounds(710, 475, 52, 19);

        lblCorrect = new JLabel("0", SwingConstants.CENTER);
        lblCorrect.setBounds(726, 507, 79, 84);
        lblCorrect.setOpaque(true);
        lblCorrect.setBackground(brown);
        lblCorrect.setForeground(Color.WHITE);
        lblCorrect.setFont(font);

        lblIncorrect = new JLabel("0", SwingConstants.CENTER);
        lblIncorrect.setBounds(819, 507, 79, 84);
        lblIncorrect.setOpaque(true);
        lblIncorrect.setBackground(brown);
        lblIncorrect.setForeground(Color.WHITE);
        lblIncorrect.setFont(font);

        JLabel lblC = new JLabel("Correct", SwingConstants.CENTER);
        lblC.setBounds(734, 601, 62, 19);
        JLabel lblI = new JLabel("Incorrect", SwingConstants.CENTER);
        lblI.setBounds(822, 602, 76, 19);

        // Add components to panel
        mainPanel.add(lblNum1);
        mainPanel.add(lblOperation);
        mainPanel.add(lblNum2);
        mainPanel.add(lblEqual);
        mainPanel.add(txtAnswer);
        mainPanel.add(lblFeedback);
        mainPanel.add(btnSubmit);
        mainPanel.add(btnExit);
        mainPanel.add(btnNext);
        mainPanel.add(lblOp);
        mainPanel.add(rbAdd);
        mainPanel.add(rbSub);
        mainPanel.add(rbMul);
        mainPanel.add(rbDiv);
        mainPanel.add(rbMod);
        mainPanel.add(lblLvl);
        mainPanel.add(rbLvl1);
        mainPanel.add(rbLvl2);
        mainPanel.add(rbLvl3);
        mainPanel.add(btnGo);
        mainPanel.add(lblScore);
        mainPanel.add(lblCorrect);
        mainPanel.add(lblIncorrect);
        mainPanel.add(lblC);
        mainPanel.add(lblI);

        // Disable until Go is pressed
        txtAnswer.setEnabled(false);
        btnSubmit.setEnabled(false);
        btnNext.setEnabled(false);

        // Action listeners
        btnGo.addActionListener(e -> startGame());
        btnSubmit.addActionListener(e -> checkAnswer());
        btnNext.addActionListener(e -> startGame());

        btnExit.addActionListener(e -> {
            new FinalScoreFrame(correctCount, incorrectCount);
            dispose();
        });

        setVisible(true);
    }

    private void startGame() {
        if (!rbAdd.isSelected() && !rbSub.isSelected() && !rbMul.isSelected() && !rbDiv.isSelected() && !rbMod.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select an operation first!");
            return;
        }

        if (!rbLvl1.isSelected() && !rbLvl2.isSelected() && !rbLvl3.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a level first!");
            return;
        }

        txtAnswer.setEnabled(true);
        btnSubmit.setEnabled(true);
        btnNext.setEnabled(true);

        if (rbAdd.isSelected()) operation = "+";
        else if (rbSub.isSelected()) operation = "-";
        else if (rbMul.isSelected()) operation = "x";
        else if (rbDiv.isSelected()) operation = "/";
        else operation = "%";

        if (rbLvl1.isSelected()) { levelMin = 1; levelMax = 100; }
        else if (rbLvl2.isSelected()) { levelMin = 101; levelMax = 200; }
        else { levelMin = 201; levelMax = 300; }

        num1 = new Random().nextInt(levelMax - levelMin + 1) + levelMin;
        num2 = new Random().nextInt(levelMax - levelMin + 1) + levelMin;
        if (operation.equals("/") || operation.equals("%")) num2 = new Random().nextInt(levelMax - levelMin) + 1;

        lblNum1.setText(String.valueOf(num1));
        lblNum2.setText(String.valueOf(num2));
        lblOperation.setText(operation);
        txtAnswer.setText("");
        lblFeedback.setText("");
    }

    private void checkAnswer() {
        try {
            double userAnswer = Double.parseDouble(txtAnswer.getText());
            double correctAnswer = switch (operation) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "x" -> num1 * num2;
                case "/" -> Math.round(((double) num1 / num2) * 100.0) / 100.0;
                case "%" -> num1 % num2;
                default -> 0;
            };

            if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                //Correct answer feedback
                correctCount++;
                lblCorrect.setText(String.valueOf(correctCount));
                String[] positiveFeedbacks = {
                    "Great job! Keep it up!",
                    "Awesome! You're on fire!",
                    "Excellent thinking!",
                    "Correct! You’re getting better every time!",
                    "Superb! You’ve got this!",
                    "Brilliant work!",
                    "Nice! You’re mastering this!",
                    "Impressive! Stay focused!",
                    "Amazing effort! Keep pushing!",
                    "Perfect! You’re unstoppable!"
                };
                lblFeedback.setText(positiveFeedbacks[rand.nextInt(positiveFeedbacks.length)]);
                lblFeedback.setForeground(Color.GREEN.darker());
            } else {
                // ❌ Incorrect answer feedback
                incorrectCount++;
                lblIncorrect.setText(String.valueOf(incorrectCount));
                String[] motivationalFeedbacks = {
                    "Not quite! Don’t give up!",
                    "Almost there! Try again!",
                    "You’re learning—keep going!",
                    "Don’t worry, you’ll get the next one!",
                    "Mistakes help us grow!",
                    "Keep practicing—you’re improving!",
                    "Stay positive, you can do it!",
                    "Good effort! Never stop learning!",
                    "Believe in yourself—you’ve got this!",
                    "Keep trying! Success is built one step at a time!"
                };
                lblFeedback.setText(motivationalFeedbacks[rand.nextInt(motivationalFeedbacks.length)]
                        + " (Correct: " + correctAnswer + ")");
                lblFeedback.setForeground(Color.RED);
            }

            // ⏳ Delay 2 seconds before next question
            Timer timer = new Timer(2000, e -> startGame());
            timer.setRepeats(false);
            timer.start();

        } catch (NumberFormatException ex) {
            lblFeedback.setText("Please enter a valid number.");
            lblFeedback.setForeground(Color.RED);
        }
    }
}
