public class Submarine extends WaterTransport {
    private int maxDiveDepth;

    public Submarine(String name, int maxSpeed, int capacity, double displacement, int maxDiveDepth) {
        super(name, maxSpeed, capacity, displacement);
        this.maxDiveDepth = maxDiveDepth;
    }

    @Override
    public void move() {
        System.out.println(name + " is navigating underwater");
    }

    @Override
    public void sail() {
        System.out.println(name + " is sailing on surface or submerged");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Max Dive Depth: " + maxDiveDepth + " meters");
    }

    public void dive() {
        System.out.println(name + " is diving underwater");
    }

    public void surface() {
        System.out.println(name + " is surfacing");
    }
}