// Authenticable.java - Interface demonstrating polymorphism through interface
public interface Authenticable {
    boolean login(String username, String password);
    void logout();
    boolean isLoggedIn();
    
    // Default method - interface polymorphism
    default void displayAuthStatus() {
        System.out.println("Authentication status: " + (isLoggedIn() ? "Logged In" : "Logged Out"));
    }
}
