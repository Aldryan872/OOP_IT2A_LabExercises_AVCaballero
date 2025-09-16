public class SUV extends LandTransport {
    private boolean fourWheelDrive;

    public SUV(String name, int maxSpeed, int capacity, int wheelCount, boolean fourWheelDrive) {
        super(name, maxSpeed, capacity, wheelCount);
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public void move() {
        System.out.println(name + " is driving on various terrains");
    }

    @Override
    public void drive() {
        System.out.println(name + " is being driven as a family vehicle");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("4WD: " + (fourWheelDrive ? "Yes" : "No"));
    }
}