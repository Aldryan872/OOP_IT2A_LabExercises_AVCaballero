public interface Authenticable {
    boolean authenticate(String username, String password);

    void handleAuthenticationSuccess();

    void handleAuthenticationFailure();

    default void logAuthenticationAttempt(String username) {
        System.out.println("Authentication attempt for user: " + username);
    }
}
