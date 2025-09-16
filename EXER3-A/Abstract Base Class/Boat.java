public class Boat extends WaterTransport {
    private String hullType;

    public Boat(String name, int maxSpeed, int capacity, double displacement, String hullType) {
        super(name, maxSpeed, capacity, displacement);
        this.hullType = hullType;
    }

    @Override
    public void move() {
        System.out.println(name + " is sailing on water");
    }

    @Override
    public void sail() {
        System.out.println(name + " is sailing using wind or engine power");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hull Type: " + hullType);
    }

    public void anchor() {
        System.out.println(name + " is dropping anchor");
    }
}
