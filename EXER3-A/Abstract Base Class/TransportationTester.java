public class TransportationTester {
    public static void main(String[] args) {
        System.out.println("=== TRANSPORTATION TESTER ===\n");

        // Create instances of all subclasses
        System.out.println("=== AIR TRANSPORT ===");
        Helicopter helicopter = new Helicopter("Black Hawk", 350, 12, 6000, 2);
        Airplane airplane = new Airplane("Boeing 747", 988, 416, 13700, 68);
        SpaceShuttle spaceShuttle = new SpaceShuttle("Discovery", 28000, 7, 400000, true);

        testTransport(helicopter);
        testTransport(airplane);
        testTransport(spaceShuttle);

        System.out.println("\n=== LAND TRANSPORT ===");
        Truck truck = new Truck("Volvo FH16", 120, 3, 18, 25.5);
        SUV suv = new SUV("Toyota Fortuner", 180, 7, 4, true);
        Tricycle tricycle = new Tricycle("Pedal Power", 15, 2, 3, true);
        Motorcycle motorcycle = new Motorcycle("Yamaha R1", 299, 2, 2, "Inline-4");
        Kariton kariton = new Kariton("Wooden Cart", 5, 1, 2, "Wood");

        testTransport(truck);
        testTransport(suv);
        testTransport(tricycle);
        testTransport(motorcycle);
        testTransport(kariton);

        System.out.println("\n=== WATER TRANSPORT ===");
        Boat boat = new Boat("Sailboat", 25, 8, 5.2, "Monohull");
        Submarine submarine = new Submarine("Nuclear Sub", 46, 134, 18700, 300);

        testTransport(boat);
        testTransport(submarine);

        // Demonstrate specific methods
        System.out.println("\n=== SPECIALIZED METHODS ===");
        helicopter.hover();
        spaceShuttle.orbitEarth();
        truck.loadCargo();
        tricycle.ringBell();
        motorcycle.wheelie();
        kariton.carryGoods();
        boat.anchor();
        submarine.dive();
        submarine.surface();
    }

    private static void testTransport(Transportation transport) {
        System.out.println("\n--- Testing " + transport.getName() + " ---");
        transport.displayInfo();
        transport.move();

        // Call specific methods based on type
        if (transport instanceof AirTransport) {
            ((AirTransport) transport).takeOff();
        }
        if (transport instanceof LandTransport) {
            ((LandTransport) transport).drive();
        }
        if (transport instanceof WaterTransport) {
            ((WaterTransport) transport).sail();
        }
    }
}