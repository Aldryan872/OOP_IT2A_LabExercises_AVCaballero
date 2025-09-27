// ProjectTester class to demonstrate polymorphism
import java.util.*;

public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("=== Barangay Health Center Management System - Polymorphism Demo ===\n");
        
        // Create a list of ManagementSystem objects (polymorphism)
        List<ManagementSystem> systems = new ArrayList<>();
        
        // Add different types of management systems to the same list
        systems.add(new DoctorDetails());
        systems.add(new RoomManagementSystem());
        systems.add(new ServicesManagementSystem());
        
        // Demonstrate polymorphism by calling common methods
        System.out.println("1. Testing common interface methods:");
        System.out.println("--------------------------------------");
        
        for (int i = 0; i < systems.size(); i++) {
            ManagementSystem system = systems.get(i);
            System.out.println("\nSystem " + (i + 1) + ": " + system.getClass().getSimpleName());
            
            // These methods work polymorphically
            system.loadData();
            system.refreshData();
            
            // Validate form (each system has its own implementation)
            System.out.println("Form validation: " + system.validateForm());
        }
        
        // Demonstrate specific behaviors through type checking and casting
        System.out.println("\n\n2. Testing specific behaviors:");
        System.out.println("--------------------------------");
        
        for (ManagementSystem system : systems) {
            System.out.println("\nTesting " + system.getClass().getSimpleName() + ":");
            
            if (system instanceof DoctorDetails) {
                DoctorDetails doctorSystem = (DoctorDetails) system;
                doctorSystem.exportToCSV(); // Specific to DoctorDetails
            } else if (system instanceof RoomManagementSystem) {
                RoomManagementSystem roomSystem = (RoomManagementSystem) system;
                roomSystem.checkRoomAvailability(); // Specific to RoomManagementSystem
            } else if (system instanceof ServicesManagementSystem) {
                ServicesManagementSystem serviceSystem = (ServicesManagementSystem) system;
                serviceSystem.calculateTotalRevenue(); // Specific to ServicesManagementSystem
            }
        }
        
        // Demonstrate template method pattern
        System.out.println("\n\n3. Testing template method pattern:");
        System.out.println("-------------------------------------");
        
        List<BaseManagementPanel> panels = new ArrayList<>();
        panels.add(new DoctorDetails());
        panels.add(new RoomManagementSystem());
        panels.add(new ServicesManagementSystem());
        
        for (BaseManagementPanel panel : panels) {
            System.out.println("\nInitializing " + panel.getClass().getSimpleName() + ":");
            // The template method pattern ensures consistent initialization
            panel.initializeUI();
        }
        
        // Test batch operations using polymorphism
        System.out.println("\n\n4. Testing batch operations:");
        System.out.println("-----------------------------");
        
        performBatchOperations(systems);
        
        System.out.println("\n=== Polymorphism demonstration completed successfully! ===");

        // Demonstrate interface polymorphism with reports
        System.out.println("\n\n5. Testing interface polymorphism with reports:");
        System.out.println("--------------------------------------------------");
        
        // Create report generators
        List<ReportGenerator> reports = new ArrayList<>();
        reports.add(new DoctorReport(new DoctorDetails()));
        reports.add(new RoomReport(new RoomManagementSystem()));
        reports.add(new ServiceReport(new ServicesManagementSystem()));
        
        // Demonstrate interface polymorphism
        for (ReportGenerator report : reports) {
            System.out.println("\n" + report.getClass().getSimpleName() + ":");
            report.generateReport();
            report.exportReport("PDF");
        }
    }
    
    // Method demonstrating polymorphism in action
    private static void performBatchOperations(List<ManagementSystem> systems) {
        System.out.println("Performing batch save operation...");
        for (ManagementSystem system : systems) {
            system.saveData(); // Each system saves data in its own way
        }
        
        System.out.println("Performing batch clear operation...");
        for (ManagementSystem system : systems) {
            system.clearForm(); // Each system clears forms in its own way
        }
        
        System.out.println("Batch operations completed!");
    }
    
    // Additional method to demonstrate dynamic method dispatch
    public static void demonstrateDynamicDispatch(ManagementSystem system) {
        System.out.println("Dynamic dispatch for: " + system.getClass().getSimpleName());
        
        // The actual method called depends on the runtime type
        system.loadData();
        system.refreshData();
        
        if (system.validateForm()) {
            System.out.println("Form validation passed!");
        } else {
            System.out.println("Form validation failed!");
        }
    }
}

// Additional interface for report generation (demonstrating interface polymorphism)
interface ReportGenerator {
    void generateReport();
    void exportReport(String format);
}

// Doctor report implementation
class DoctorReport implements ReportGenerator {
    private DoctorDetails doctorSystem;
    
    public DoctorReport(DoctorDetails system) {
        this.doctorSystem = system;
    }
    
    @Override
    public void generateReport() {
        System.out.println("Generating Doctor Report...");
        System.out.println("Report includes doctor details and availability status");
    }
    
    @Override
    public void exportReport(String format) {
        System.out.println("Exporting Doctor Report in " + format + " format");
    }
}

// Room report implementation
class RoomReport implements ReportGenerator {
    private RoomManagementSystem roomSystem;
    
    public RoomReport(RoomManagementSystem system) {
        this.roomSystem = system;
    }
    
    @Override
    public void generateReport() {
        System.out.println("Generating Room Utilization Report...");
        System.out.println("Report includes room status and occupancy rates");
    }
    
    @Override
    public void exportReport(String format) {
        System.out.println("Exporting Room Report in " + format + " format");
    }
}

// Service report implementation
class ServiceReport implements ReportGenerator {
    private ServicesManagementSystem serviceSystem;
    
    public ServiceReport(ServicesManagementSystem system) {
        this.serviceSystem = system;
    }
    
    @Override
    public void generateReport() {
        System.out.println("Generating Service Revenue Report...");
        System.out.println("Report includes service usage and financial data");
    }
    
    @Override
    public void exportReport(String format) {
        System.out.println("Exporting Service Report in " + format + " format");
    }
}

