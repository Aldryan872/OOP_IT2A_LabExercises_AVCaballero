// TransportationTester.java
import java.util.ArrayList;
import java.util.List;

public class TransportationTester {
    public static void main(String[] args) {
        // Air Transport
        Helicopter helicopter = new Helicopter(5);
        Airplane airplane = new Airplane(150);
        SpaceShuttle shuttle = new SpaceShuttle(7);

        // Land Transport
        Truck truck = new Truck(3);
        SUV suv = new SUV(7);
        Tricycle tricycle = new Tricycle(2);
        Motorcycle motorcycle = new Motorcycle(2);
        Kariton kariton = new Kariton(1);

        // Water Transport
        Boat boat = new Boat(20);
        Submarine submarine = new Submarine(30);

        // Create a list to hold all transportation objects
        List<Transportation> transports = new ArrayList<>();
        transports.add(helicopter);
        transports.add(airplane);
        transports.add(shuttle);
        transports.add(truck);
        transports.add(suv);
        transports.add(tricycle);
        transports.add(motorcycle);
        transports.add(kariton);
        transports.add(boat);
        transports.add(submarine);

        // Testing move() method using a loop
        for (Transportation t : transports) {
            t.move();
        }
    }
}
