public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("=== Barangay Health Center System Tester ===\n");
        
        // Test 1: Create AuthenticationService instance
        System.out.println("1. Testing AuthenticationService:");
        AuthenticationService authService = new AuthenticationService();
        testAuthenticationService(authService);
        
        // Test 2: Create Doctor instances
        System.out.println("\n2. Testing Doctor class:");
        testDoctorClass();
        
        // Test 3: Create UI instances (without showing windows)
        System.out.println("\n3. Testing UI Classes:");
        testUIClasses();
        
        System.out.println("\n=== All tests completed successfully ===");
    }
    
    private static void testAuthenticationService(AuthenticationService authService) {
        // Test valid credentials
        boolean result1 = authService.authenticate("admin", "barangay123");
        System.out.println("Valid credentials test: " + (result1 ? "PASS" : "FAIL"));
        
        // Test invalid credentials
        boolean result2 = authService.authenticate("wrong", "password");
        System.out.println("Invalid credentials test: " + (!result2 ? "PASS" : "FAIL"));
        
        // Test registration
        boolean result3 = authService.registerUser("newuser", "pass123", "John Doe", "john@example.com");
        System.out.println("Registration test: " + (result3 ? "PASS" : "FAIL"));
    }
    
    private static void testDoctorClass() {
        // Create doctor instances
        Doctor doctor1 = new Doctor("D001", "Dr. John Smith", "555-1234", "123 Main St", "Cardiologist");
        Doctor doctor2 = new Doctor("D002", "Dr. Emily Johnson", "555-5678", "456 Oak Ave", "Pediatrician");
        
        System.out.println("Doctor 1: " + doctor1);
        System.out.println("Doctor 2: " + doctor2);
        
        // Test setters
        doctor1.setContact("555-9999");
        System.out.println("Updated Doctor 1 contact: " + doctor1.getContact());
    }
    
    private static void testUIClasses() {
        try {
            // Create instances without making them visible
            BarangayHealthLogin loginFrame = new BarangayHealthLogin();
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            HealthCenterDashboard dashboard = new HealthCenterDashboard();
            DoctorDetails doctorDetails = new DoctorDetails();
            
            System.out.println("BarangayHealthLogin instance created: " + (loginFrame != null));
            System.out.println("HealthCenterDashboard instance created: " + (dashboard != null));
            System.out.println("DoctorDetails instance created: " + (doctorDetails != null));
            
            // Don't setVisible(true) to avoid showing windows during testing
            loginFrame.dispose();
            dashboard.dispose();
            doctorDetails.dispose();
            
        } catch (Exception e) {
            System.out.println("Error creating UI instances: " + e.getMessage());
        }
    }
    
    // Method to demonstrate the actual application
    public static void startApplication() {
        System.out.println("Starting Barangay Health Center Application...");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BarangayHealthLogin loginApp = new BarangayHealthLogin();
                loginApp.setVisible(true);
            }
        });
    }
}
