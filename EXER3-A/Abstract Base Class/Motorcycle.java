public class Motorcycle extends LandTransport {
    private String engineType;

    public Motorcycle(String name, int maxSpeed, int capacity, int wheelCount, String engineType) {
        super(name, maxSpeed, capacity, wheelCount);
        this.engineType = engineType;
    }

    @Override
    public void move() {
        System.out.println(name + " is riding on two wheels");
    }

    @Override
    public void drive() {
        System.out.println(name + " is being ridden with handlebars");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Type: " + engineType);
    }

    public void wheelie() {
        System.out.println(name + " is doing a wheelie!");
    }
}