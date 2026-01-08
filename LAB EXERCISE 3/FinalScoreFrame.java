import java.awt.*;
import javax.swing.*;

public class FinalScoreFrame extends JFrame {
    public FinalScoreFrame(int correct, int incorrect) {
        setTitle("Arithmetic Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        setLayout(null);
        setSize(972, 689);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(214, 234, 248));

        int total = correct + incorrect;
        double percentage = total > 0 ? ((double) correct / total) * 100 : 0;

        // Title
        JLabel lblTitle = new JLabel("Your Final Results", SwingConstants.CENTER);
        lblTitle.setBounds(300, 77, 371, 59);
        lblTitle.setFont(new Font("Swis721 BlkCn BT", Font.BOLD, 30));
        add(lblTitle);

        // Correct
        JLabel lblCorrect = new JLabel("Correct Answers: " + correct, SwingConstants.CENTER);
        lblCorrect.setBounds(388, 167, 198, 28);
        lblCorrect.setFont(new Font("Arial", Font.PLAIN, 22));
        add(lblCorrect);

        // Incorrect
        JLabel lblIncorrect = new JLabel("Incorrect Answers: " + incorrect, SwingConstants.CENTER);
        lblIncorrect.setBounds(379, 208, 214, 28);
        lblIncorrect.setFont(new Font("Arial", Font.PLAIN, 22));
        add(lblIncorrect);

        // Total
        JLabel lblTotal = new JLabel("Total Questions: " + total, SwingConstants.CENTER);
        lblTotal.setBounds(386, 249, 200, 28);
        lblTotal.setFont(new Font("Arial", Font.PLAIN, 22));
        add(lblTotal);

        // Percentage
        JLabel lblPercentage = new JLabel(String.format("Score: %.2f%%", percentage), SwingConstants.CENTER);
        lblPercentage.setBounds(411, 290, 170, 28);
        lblPercentage.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblPercentage);

        // Remarks
        String remark;
        if (percentage >= 90) remark = "Excellent!";
        else if (percentage >= 75) remark = "Good job!";
        else if (percentage >= 50) remark = "Fair, keep practicing!";
        else remark = "Needs improvement!";
        JLabel lblRemark = new JLabel("Remarks: " + remark, SwingConstants.CENTER);
        lblRemark.setBounds(303, 356, 350, 31);
        lblRemark.setFont(new Font("Arial", Font.ITALIC, 22));
        lblRemark.setForeground(new Color(80, 80, 200));
        add(lblRemark);

        // Close button
        JButton Close = new JButton("Close");
        Close.setBounds(554, 492, 157, 68);
        Close.setFont(new Font("Arial", Font.ITALIC, 25));
        Close.setBackground(new Color(40, 116, 166));
        Close.setForeground(Color.WHITE);
        Close.addActionListener(e -> System.exit(0));
        add(Close);

        JButton PlayAgain = new JButton("Play Again");
        PlayAgain.setBounds(262, 492, 157, 68);
        PlayAgain.setFont(new Font("Arial", Font.ITALIC, 22));
        PlayAgain.setBackground(new Color(40, 116, 166));    
        PlayAgain.setForeground(Color.WHITE);
        add(PlayAgain);
        PlayAgain.addActionListener(e -> {
            new ArithmeticGame(); 
            dispose();            
        });

        setVisible(true);
    }
}
