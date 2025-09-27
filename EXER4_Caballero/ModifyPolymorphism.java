// Interface for common management system operations
interface ManagementSystem {
    void loadData();
    void refreshData();
    boolean validateForm();
    void saveData();
    void clearForm();
}

// Abstract base class for management panels using template method pattern
abstract class BaseManagementPanel implements ManagementSystem {
    // Template method
    public void initializeUI() {
        setupUI();
        setupEventHandlers();
        System.out.println("UI initialized successfully.");
    }

    // Abstract method to be implemented by subclasses
    protected abstract void setupUI();

    // Common event handler setup
    protected void setupEventHandlers() {
        System.out.println("Event handlers set up.");
    }
}

// Concrete implementation for Doctor Details management
class DoctorDetails extends BaseManagementPanel {
    @Override
    public void loadData() {
        System.out.println("Loading doctor details from database...");
    }

    @Override
    public void refreshData() {
        System.out.println("Refreshing doctor availability and schedules...");
    }

    @Override
    public boolean validateForm() {
        System.out.println("Validating doctor form: Checking required fields...");
        return true; // Assume validation passes
    }

    @Override
    public void saveData() {
        System.out.println("Saving doctor details to database...");
    }

    @Override
    public void clearForm() {
        System.out.println("Clearing doctor form fields...");
    }

    @Override
    protected void setupUI() {
        System.out.println("Setting up Doctor Details UI components...");
    }

    // Specific method for DoctorDetails
    public void exportToCSV() {
        System.out.println("Exporting doctor details to CSV file...");
    }
}

// Concrete implementation for Room Management
class RoomManagementSystem extends BaseManagementPanel {
    @Override
    public void loadData() {
        System.out.println("Loading room information and status...");
    }

    @Override
    public void refreshData() {
        System.out.println("Refreshing room occupancy and availability...");
    }

    @Override
    public boolean validateForm() {
        System.out.println("Validating room form: Checking room number and capacity...");
        return true; // Assume validation passes
    }

    @Override
    public void saveData() {
        System.out.println("Saving room management data...");
    }

    @Override
    public void clearForm() {
        System.out.println("Clearing room form fields...");
    }

    @Override
    protected void setupUI() {
        System.out.println("Setting up Room Management UI components...");
    }

    // Specific method for RoomManagementSystem
    public void checkRoomAvailability() {
        System.out.println("Checking room availability for the selected date...");
    }
}

// Concrete implementation for Services Management
class ServicesManagementSystem extends BaseManagementPanel {
    @Override
    public void loadData() {
        System.out.println("Loading services and pricing information...");
    }

    @Override
    public void refreshData() {
        System.out.println("Refreshing service usage statistics...");
    }

    @Override
    public boolean validateForm() {
        System.out.println("Validating services form: Checking service details and costs...");
        return true; // Assume validation passes
    }

    @Override
    public void saveData() {
        System.out.println("Saving services management data...");
    }

    @Override
    public void clearForm() {
        System.out.println("Clearing services form fields...");
    }

    @Override
    protected void setupUI() {
        System.out.println("Setting up Services Management UI components...");
    }

    // Specific method for ServicesManagementSystem
    public void calculateTotalRevenue() {
        System.out.println("Calculating total revenue from services...");
    }
}
