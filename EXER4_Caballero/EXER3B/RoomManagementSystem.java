import javax.swing.*;
import java.awt.*;

public class RoomManagementSystem extends ManagementPanels {
    public RoomManagementSystem() {
        add(new JLabel("Room Management Panel", JLabel.CENTER));
    }

    @Override
    public void loadData() {
        // Load room data
        System.out.println("Loading room data...");
    }

    @Override
    public void saveData() {
        // Save room data
        System.out.println("Saving room data...");
    }

    @Override
    public void refresh() {
        // Refresh the table
        System.out.println("Refreshing room data...");
    }
}
