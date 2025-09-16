public class Airplane extends AirTransport {
    private int wingSpan;

    public Airplane(String name, int maxSpeed, int capacity, int maxAltitude, int wingSpan) {
        super(name, maxSpeed, capacity, maxAltitude);
        this.wingSpan = wingSpan;
    }

    @Override
    public void move() {
        System.out.println(name + " is flying using jet engines");
    }

    @Override
    public void takeOff() {
        System.out.println(name + " is taking off from runway");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Wing Span: " + wingSpan + " meters");
    }
}