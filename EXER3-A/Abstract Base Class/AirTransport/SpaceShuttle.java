public class SpaceShuttle extends AirTransport {
    private boolean reusable;

    public SpaceShuttle(String name, int maxSpeed, int capacity, int maxAltitude, boolean reusable) {
        super(name, maxSpeed, capacity, maxAltitude);
        this.reusable = reusable;
    }

    @Override
    public void move() {
        System.out.println(name + " is traveling to space using rocket propulsion");
    }

    @Override
    public void takeOff() {
        System.out.println(name + " is launching into space");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Reusable: " + (reusable ? "Yes" : "No"));
    }

    public void orbitEarth() {
        System.out.println(name + " is orbiting the Earth");
    }
}