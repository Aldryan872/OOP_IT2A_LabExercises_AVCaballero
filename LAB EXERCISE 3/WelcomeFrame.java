import java.awt.*;
import javax.swing.*;

public class WelcomeFrame extends JFrame {
    public WelcomeFrame() {
        setTitle("Arithmetic Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(214, 234, 248));
        setResizable(false);
        setSize(972, 689);
        setLocationRelativeTo(null);
        setLayout(null);

        //Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome to Arithmetic Game!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        welcomeLabel.setBounds(138, 286, 696, 59);
        welcomeLabel.setForeground(new Color(44, 62, 80));
        add(welcomeLabel);

        //Start Button
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 30));
        startButton.setBounds(408, 477, 157, 68);
        startButton.setBackground(new Color(40, 116, 166));
        startButton.setForeground(Color.WHITE);
        add(startButton);

        //Action when Start is clicked
        startButton.addActionListener(e -> {
            new ArithmeticGame(); 
            dispose();         
        });

        setVisible(true);
    }
}
