import javax.swing.*;
import java.awt.*;

public class HealthCenterDashboard extends HealthCenterSystem {
    private JFrame dashboardFrame;
    private JTabbedPane tabbedPane;

    public HealthCenterDashboard() {
        super("Barangay Health Center Dashboard");
    }

    @Override
    public void initialize() {
        dashboardFrame = new JFrame("Barangay Health Center - Dashboard");
        dashboardFrame.setSize(1200, 800);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupDashboard();
    }

    @Override
    public void display() {
        dashboardFrame.setVisible(true);
    }

    private void setupDashboard() {
        tabbedPane = new JTabbedPane();

        // Create management panel instances
        doctordetails doctorPanel = new doctordetails();
        RoomManagementSystem roomPanel = new RoomManagementSystem();
        ServicesManagementSystem servicesPanel = new ServicesManagementSystem();

        // Add tabs
        tabbedPane.addTab("Dashboard", createDashboardTab());
        tabbedPane.addTab("Doctor Management", doctorPanel);
        tabbedPane.addTab("Room Management", roomPanel);
        tabbedPane.addTab("Services Management", servicesPanel);

        dashboardFrame.add(tabbedPane);
    }

    private JPanel createDashboardTab() {
        JPanel dashboardPanel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Barangay Health Center", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(welcomeLabel, BorderLayout.CENTER);

        return dashboardPanel;
    }
}
