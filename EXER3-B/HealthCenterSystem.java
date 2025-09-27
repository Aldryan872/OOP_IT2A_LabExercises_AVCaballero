import javax.swing.*;

public abstract class HealthCenterSystem {
    protected JFrame frame;
    protected String title;

    public HealthCenterSystem(String title) {
        this.title = title;
        this.frame = new JFrame(title);
    }

    public abstract void initialize();

    public void display() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    // Common utility methods
    protected void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    protected boolean validateInput(String input) {
        return input != null && !input.trim().isEmpty();
    }
}
