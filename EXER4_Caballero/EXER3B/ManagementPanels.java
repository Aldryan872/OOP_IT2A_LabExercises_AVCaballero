import javax.swing.*;
import java.awt.*;

public abstract class ManagementPanels extends JPanel {
    public ManagementPanels() {
        setLayout(new BorderLayout());
    }

    public abstract void loadData();
    public abstract void saveData();
    public abstract void refresh();
}
