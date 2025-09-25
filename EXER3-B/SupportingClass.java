public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        // Simple authentication - in real application, this would connect to database
        return "admin".equals(username) && "barangay123".equals(password);
    }

    public boolean registerUser(String username, String password, String fullName, String email) {
        // Registration logic would go here
        System.out.println("Registering user: " + username);
        return true;
    }
}
