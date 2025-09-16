public class Helicopter extends AirTransport {
    private int rotorCount;

    public Helicopter(String name, int maxSpeed, int capacity, int maxAltitude, int rotorCount) {
        super(name, maxSpeed, capacity, maxAltitude);
        this.rotorCount = rotorCount;
    }

    @Override
    public void move() {
        System.out.println(name + " is flying using rotors");
    }

    @Override
    public void takeOff() {
        System.out.println(name + " is taking off vertically");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rotor Count: " + rotorCount);
    }

    public void hover() {
        System.out.println(name + " is hovering in place");
    }
}
