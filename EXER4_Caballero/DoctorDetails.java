import java.awt.BorderLayout;
import java.awt.Color;

public class DoctorDetails extends HealthSystem {
    public DoctorDetails() {
        super("Doctor Details", "Doctor Management System", new Color(0, 150, 0));
        setSize(600, 400);
        initializeSystem();
    }

    @Override
    public void initializeComponents() {
        // Initialize components for doctor details
    }

    @Override
    public void layoutComponents() {
        setLayout(new BorderLayout());
        add(createHeaderPanel("DOCTOR DETAILS"), BorderLayout.NORTH);
        // Add more layout here
    }

    @Override
    public void showSystemInfo() {
        System.out.println("Doctor Details System Info:");
        System.out.println("- Manages doctor information");
    }
}
