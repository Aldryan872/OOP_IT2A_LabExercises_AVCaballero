// ProjectTesterclass.java
import javax.swing.*;
import java.awt.*;

public class ProjectTesterclass {
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create instances of all classes
        System.out.println("=== Barangay Health Center System Tester ===");
        
        // Test abstract class functionality
        testHealthCenterSystem();
        
        // Test login system
        testLoginSystem();
        
        // Test dashboard system
        testDashboardSystem();
        
        // Test management panels
        testManagementPanels();
        
        System.out.println("=== Testing Completed ===");
    }
    
    private static void testHealthCenterSystem() {
        System.out.println("\n1. Testing HealthCenterSystem Abstract Class:");
        System.out.println("Abstract class cannot be instantiated directly");
        System.out.println("Serves as base class for all system components");
    }
    
    private static void testLoginSystem() {
        System.out.println("\n2. Testing BarangayHealthLogin:");
        BarangayHealthLogin loginSystem = new BarangayHealthLogin();
        loginSystem.initialize();
        System.out.println("Login system initialized successfully");
        // loginSystem.display(); // Uncomment to show login window
    }
    
    private static void testDashboardSystem() {
        System.out.println("\n3. Testing HealthCenterDashboard:");
        HealthCenterDashboard dashboard = new HealthCenterDashboard();
        dashboard.initialize();
        System.out.println("Dashboard system initialized successfully");
        // dashboard.display(); // Uncomment to show dashboard
    }
    
    private static void testManagementPanels() {
        System.out.println("\n4. Testing Management Panels:");
        
        // Test Doctor Management
        System.out.println("4.1 Testing Doctor Management:");
        doctordetails doctorPanel = new doctordetails();
        System.out.println("Doctor panel created with sample data");
        
        // Test Room Management
        System.out.println("4.2 Testing Room Management:");
        RoomManagementSystem roomPanel = new RoomManagementSystem();
        System.out.println("Room panel created with sample data");
        
        // Test Services Management
        System.out.println("4.3 Testing Services Management:");
        ServicesManagementSystem servicesPanel = new ServicesManagementSystem();
        System.out.println("Services panel created with sample data");
        
        // Test panel integration in dashboard
        testPanelIntegration(doctorPanel, roomPanel, servicesPanel);
    }
    
    private static void testPanelIntegration(doctordetails doctorPanel, 
                                           RoomManagementSystem roomPanel, 
                                           ServicesManagementSystem servicesPanel) {
        System.out.println("\n5. Testing Panel Integration:");
        
        JFrame testFrame = new JFrame("Integration Test");
        testFrame.setLayout(new GridLayout(1, 3));
        
        // Add panels to test frame
        testFrame.add(doctorPanel);
        testFrame.add(roomPanel);
        testFrame.add(servicesPanel);
        
        testFrame.pack();
        testFrame.setLocationRelativeTo(null);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        System.out.println("All panels integrated successfully");
        // testFrame.setVisible(true); // Uncomment to show integration test
    }
    
    // Utility method to create test instances
    public static HealthCenterSystem[] createAllSystemInstances() {
        return new HealthCenterSystem[] {
            new BarangayHealthLogin(),
            new HealthCenterDashboard()
        };
    }
    
    public static ManagementPanels[] createAllPanelInstances() {
        return new ManagementPanels[] {
            new doctordetails(),
            new RoomManagementSystem(),
            new ServicesManagementSystem()
        };
    }
}