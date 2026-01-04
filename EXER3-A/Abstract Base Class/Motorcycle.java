// Motorcycle.java
public class Motorcycle extends LandTransport {
    public Motorcycle(int capacity) {
        super("Motorcycle", capacity);
    }
}

    public void wheelie() {
        System.out.println(name + " is doing a wheelie!");
    }
}
