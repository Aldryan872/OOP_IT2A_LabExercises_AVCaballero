public abstract class LandTransport extends Transportation {
    protected int wheelCount;

    public LandTransport(String name, int maxSpeed, int capacity, int wheelCount) {
        super(name, maxSpeed, capacity);
        this.wheelCount = wheelCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Wheel Count: " + wheelCount);
    }

    public abstract void drive();
}
