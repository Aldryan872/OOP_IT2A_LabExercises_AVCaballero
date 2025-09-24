// HealthSystemUser.java - Base class demonstrating polymorphism
public abstract class HealthSystemUser {
    protected String username;
    protected String password;
    protected String fullName;
    protected String email;
    
    public HealthSystemUser(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }
    
    // Abstract method - runtime polymorphism
    public abstract void displayUserInfo();
    
    // Method overloading - compile-time polymorphism
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public boolean authenticate(String username) {
        return this.username.equals(username);
    }
    
    // Getters and setters
    public String getUsername() { return username; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    
    @Override
    public String toString() {
        return "User: " + fullName + " (" + username + ")";
    }
}
