public class Truck extends LandTransport {
    private double cargoCapacity;

    public Truck(String name, int maxSpeed, int capacity, int wheelCount, double cargoCapacity) {
        super(name, maxSpeed, capacity, wheelCount);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void move() {
        System.out.println(name + " is transporting goods on the road");
    }

    @Override
    public void drive() {
        System.out.println(name + " is being driven on highways");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }

    public void loadCargo() {
        System.out.println(name + " is loading cargo");
    }
}