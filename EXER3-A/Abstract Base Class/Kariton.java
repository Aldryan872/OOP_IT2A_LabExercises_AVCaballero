public class Kariton extends LandTransport {
    private String material;

    public Kariton(String name, int maxSpeed, int capacity, int wheelCount, String material) {
        super(name, maxSpeed, capacity, wheelCount);
        this.material = material;
    }

    @Override
    public void move() {
        System.out.println(name + " is being pushed or pulled manually");
    }

    @Override
    public void drive() {
        System.out.println(name + " is being moved by human power");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Material: " + material);
    }

    public void carryGoods() {
        System.out.println(name + " is carrying various goods");
    }
}
