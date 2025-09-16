public abstract class WaterTransport extends Transportation {
    protected double displacement;

    public WaterTransport(String name, int maxSpeed, int capacity, double displacement) {
        super(name, maxSpeed, capacity);
        this.displacement = displacement;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Displacement: " + displacement + " tons");
    }

    public abstract void sail();
}
