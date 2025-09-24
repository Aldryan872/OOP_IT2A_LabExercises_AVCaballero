// ProjectTester.java - Class to test polymorphism implementation
public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("=== POLYMORPHISM TESTING ===\n");
        
        // Test 1: Runtime Polymorphism (Method Overriding)
        System.out.println("1. RUNTIME POLYMORPHISM TEST (Method Overriding):");
        System.out.println("=================================================");
        
        // Creating Doctor objects but storing as HealthSystemUser (upcasting)
        HealthSystemUser user1 = new Doctor("doc001", "pass123", "Dr. Alice Brown", 
                                           "alice@hospital.com", "Neurology", "MD", "Female", "555-1001");
        HealthSystemUser user2 = new Doctor("doc002", "pass456", "Dr. Bob Wilson", 
                                           "bob@hospital.com", "Surgery", "PhD", "Male", "555-1002");
        
        // Polymorphic method call - actual implementation determined at runtime
        user1.displayUserInfo();
        System.out.println("---");
        user2.displayUserInfo();
        System.out.println();
        
        // Test 2: Compile-time Polymorphism (Method Overloading)
        System.out.println("2. COMPILE-TIME POLYMORPHISM TEST (Method Overloading):");
        System.out.println("======================================================");
        
        Doctor doctor = new Doctor("doc003", "pass789", "Dr. Carol Davis", 
                                  "carol@hospital.com", "Pediatrics", "MD", "Female", "555-1003");
        
        // Testing overloaded methods
        System.out.println("Authenticate with username only: " + doctor.authenticate("doc003"));
        System.out.println("Authenticate with username and password: " + 
                          doctor.authenticate("doc003", "pass789"));
        System.out.println();
        
        // Test 3: Interface Polymorphism
        System.out.println("3. INTERFACE POLYMORPHISM TEST:");
        System.out.println("===============================");
        
        // Creating login system that implements Authenticable interface
        BarangayHealthLogin loginSystem = new BarangayHealthLogin();
        
        // Test login functionality
        System.out.println("Testing login with valid credentials...");
        boolean loginResult = loginSystem.login("drjohn", "doctor123");
        System.out.println("Login result: " + loginResult);
        
        // Using default method from interface
        loginSystem.displayAuthStatus();
        System.out.println();
        
        // Test 4: Polymorphic Collections
        System.out.println("4. POLYMORPHIC COLLECTIONS TEST:");
        System.out.println("================================");
        
        java.util.List<HealthSystemUser> users = new java.util.ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(doctor);
        
        System.out.println("Processing " + users.size() + " users polymorphically:");
        for (HealthSystemUser user : users) {
            System.out.println(" - " + user.toString()); // Dynamic binding
            user.displayUserInfo(); // Polymorphic method call
            System.out.println();
        }
        
        // Test 5: Instanceof and Downcasting
        System.out.println("5. TYPE CHECKING AND DOWNCASTING TEST:");
        System.out.println("======================================");
        
        for (HealthSystemUser user : users) {
            if (user instanceof Doctor) {
                Doctor specificDoctor = (Doctor) user; // Downcasting
                System.out.println("Downcast successful: " + specificDoctor.getSpecialization());
            }
        }
        
        System.out.println("\n=== ALL POLYMORPHISM TESTS COMPLETED SUCCESSFULLY ===");
    }
}
