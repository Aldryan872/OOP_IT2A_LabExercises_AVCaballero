import javax.swing.SwingUtilities;

public class GameTester {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new WelcomeFrame();
        });
    }
}

