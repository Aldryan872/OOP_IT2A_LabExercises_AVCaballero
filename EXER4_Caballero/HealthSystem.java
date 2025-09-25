import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class HealthSystem extends JFrame {
    protected String systemName;
    protected String systemTitle;
    protected Color themeColor;

    public HealthSystem(String title, String name, Color color) {
        super(title);
        this.systemTitle = title;
        this.systemName = name;
        this.themeColor = color;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        displayWelcomeMessage();
    }

    // Template method
    public final void initializeSystem() {
        initializeComponents();
        layoutComponents();
        showSystemInfo();
    }

    // Abstract methods to be implemented by subclasses
    public abstract void initializeComponents();

    public abstract void layoutComponents();

    public abstract void showSystemInfo();

    // Concrete methods
    public JPanel createHeaderPanel(String headerText) {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(themeColor);
        JLabel headerLabel = new JLabel(headerText, JLabel.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(headerLabel);
        return headerPanel;
    }

    public void styleAuthButton(JButton button) {
        button.setBackground(new Color(0, 120, 215));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }

    public void styleUtilityButton(JButton button) {
        button.setBackground(new Color(200, 200, 200));
        button.setFocusPainted(false);
    }

    public void displayWelcomeMessage() {
        System.out.println("=== " + systemName + " ===");
    }
}
