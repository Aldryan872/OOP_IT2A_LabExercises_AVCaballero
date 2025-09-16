public abstract class AirTransport extends Transportation {
    protected int maxAltitude;

    public AirTransport(String name, int maxSpeed, int capacity, int maxAltitude) {
        super(name, maxSpeed, capacity);
        this.maxAltitude = maxAltitude;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Max Altitude: " + maxAltitude + " meters");
    }

    public abstract void takeOff();
}