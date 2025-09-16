public abstract class Transportation {
    protected String name;
    protected int maxSpeed;
    protected int capacity;

    public Transportation(String name, int maxSpeed, int capacity) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
    }

    public abstract void move();

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Capacity: " + capacity + " people");
    }

    public String getName() {
        return name;
    }
}