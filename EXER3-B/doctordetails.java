import javax.swing.*;
import java.awt.*;

public class doctordetails extends ManagementPanels {
    public doctordetails() {
        add(new JLabel("Doctor Management Panel", JLabel.CENTER));
    }

    @Override
    public void loadData() {
        // Load doctor data
        System.out.println("Loading doctor data...");
    }

    @Override
    public void saveData() {
        // Save doctor data
        System.out.println("Saving doctor data...");
    }

    @Override
    public void refresh() {
        // Refresh the table
        System.out.println("Refreshing doctor data...");
    }
}
