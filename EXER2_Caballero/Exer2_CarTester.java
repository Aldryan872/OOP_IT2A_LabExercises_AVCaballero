public class CarTester {

    public static void main(String[] args) {
        // Create an array of 10 Car objects with different brands
        Car[] cars = new Car[10];
        
        // Initialize car objects with brand information in the plateNo field
        // Using plateNo to store brand name as per your requirement
        cars[0] = new Car("Red", "Toyota (Founded 1937 by Kiichiro Toyoda)", "CH001");
        cars[1] = new Car("Blue", "Ford (Founded 1903 by Henry Ford)", "CH002");
        cars[2] = new Car("Black", "Mercedes-Benz (Founded 1926 by Karl Benz)", "CH003");
        cars[3] = new Car("White", "BMW (Founded 1916 by Karl Rapp)", "CH004");
        cars[4] = new Car("Silver", "Honda (Founded 1948 by Soichiro Honda)", "CH005");
        cars[5] = new Car("Green", "Volkswagen (Founded 1937 by German Labor Front)", "CH006");
        cars[6] = new Car("Yellow", "Ferrari (Founded 1939 by Enzo Ferrari)", "CH007");
        cars[7] = new Car("Gray", "Tesla (Founded 2003 by Martin Eberhard & Marc Tarpenning)", "CH008");
        cars[8] = new Car("Orange", "Porsche (Founded 1931 by Ferdinand Porsche)", "CH009");
        cars[9] = new Car("Purple", "Nissan (Founded 1933 by Yoshisuke Aikawa)", "CH010");
        
        // Display information for all cars
        System.out.println("=== CAR BRANDS COLLECTION ===");
        System.out.println("==============================");
        
        for (int i = 0; i < cars.length; i++) {
            System.out.println("\nCar #" + (i + 1) + ":");
            cars[i].displayInfo();
            System.out.println("------------------------------");
        }
        
        // Alternative: Display with more detailed brand information
        System.out.println("\n\n=== DETAILED CAR BRANDS INFORMATION ===");
        System.out.println("========================================");
        
        // Create a more detailed display using the existing Car class structure
        String[] brands = {
            "Toyota - Founded: 1937, Founder: Kiichiro Toyoda",
            "Ford - Founded: 1903, Founder: Henry Ford",
            "Mercedes-Benz - Founded: 1926, Founder: Karl Benz",
            "BMW - Founded: 1916, Founder: Karl Rapp",
            "Honda - Founded: 1948, Founder: Soichiro Honda",
            "Volkswagen - Founded: 1937, Founder: German Labor Front",
            "Ferrari - Founded: 1939, Founder: Enzo Ferrari",
            "Tesla - Founded: 2003, Founders: Martin Eberhard & Marc Tarpenning",
            "Porsche - Founded: 1931, Founder: Ferdinand Porsche",
            "Nissan - Founded: 1933, Founder: Yoshisuke Aikawa"
        };
        
        String[] colors = {"Red", "Blue", "Black", "White", "Silver", 
                          "Green", "Yellow", "Gray", "Orange", "Purple"};
        
        for (int i = 0; i < 10; i++) {
            Car car = new Car(colors[i], brands[i], "CH" + String.format("%03d", i+1));
            System.out.println("\nBrand " + (i + 1) + ":");
            car.displayInfo();
            System.out.println("----------------------------");
        }
    }
}