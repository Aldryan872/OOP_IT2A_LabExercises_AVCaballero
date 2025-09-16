public class Tricycle extends LandTransport {
    private boolean hasBasket;

    public Tricycle(String name, int maxSpeed, int capacity, int wheelCount, boolean hasBasket) {
        super(name, maxSpeed, capacity, wheelCount);
        this.hasBasket = hasBasket;
    }

    @Override
    public void move() {
        System.out.println(name + " is pedaling on streets");
    }

    @Override
    public void drive() {
        System.out.println(name + " is being pedaled manually");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Basket: " + (hasBasket ? "Yes" : "No"));
    }

    public void ringBell() {
        System.out.println(name + " is ringing its bell");
    }
}