public class Cartester {
    public static void main(String[] args) {
        System.out.println("=== CAR PERFORMANCE TESTING ===\n");
        
        // Test 1: Hypercar - Pagani Huayra
        Car pagani = new Car("Pagani", "Huayra", 2024, 3500000.0, 
                           "Hypercar", 4600, 2036, 1169, 1350, 11.5,
                           370, 3.2, 100, 6.0, "V12", 12, 15.7,
                           "Carbon Fiber", true, true, true, 350, 
                           new String[]{"ABS", "Traction Control", "Carbon Ceramic Brakes", "Stability Control"});
        
        System.out.println("PAGANI HUAYRA:");
        pagani.displayAllSpecs();
        pagani.testPerformance();
        System.out.println("Environmental Impact: " + pagani.calculateEnvironmentalImpact() + " g/km CO2\n");
        
        // Test 2: Supercar - McLaren 720S
        Car mclaren = new Car("McLaren", "720S", 2024, 300000.0, 
                            "Supercar", 4543, 1930, 1196, 1419, 11.1,
                            341, 2.9, 97, 7.9, "V8 Twin-Turbo", 8, 12.3,
                            "Carbon Fiber", true, true, false, 280,
                            new String[]{"ABS", "Traction Control", "Carbon Ceramic Brakes", "Airbags", "Stability Control"});
        
        System.out.println("MCLAREN 720S:");
        mclaren.displayAllSpecs();
        mclaren.testPerformance();
        System.out.println("Environmental Impact: " + mclaren.calculateEnvironmentalImpact() + " g/km CO2\n");
        
        // Test 3: Sports Sedan - Mitsubishi Lancer Evolution
        Car mitsubishi = new Car("Mitsubishi", "Lancer Evolution X", 2024, 45000.0, 
                               "Sports Sedan", 4500, 1810, 1480, 1600, 10.8,
                               250, 4.5, 85, 10.5, "Inline-4 Turbo", 4, 9.8,
                               "Steel/Aluminum", true, false, false, 210,
                               new String[]{"ABS", "Airbags", "Traction Control", "Stability Control"});
        
        System.out.println("MITSUBISHI LANCER EVOLUTION:");
        mitsubishi.displayAllSpecs();
        mitsubishi.testPerformance();
        System.out.println("Environmental Impact: " + mitsubishi.calculateEnvironmentalImpact() + " g/km CO2\n");
        
        // Test 4: Pickup Truck - Ford F-150 Raptor
        Car ford = new Car("Ford", "F-150 Raptor", 2024, 75000.0, 
                         "Pickup Truck", 5910, 2190, 1992, 2500, 14.2,
                         180, 5.5, 70, 14.2, "V6 Twin-Turbo", 6, 16.8,
                         "Aluminum", true, true, true, 380,
                         new String[]{"ABS", "Airbags", "Traction Control", "Stability Control", "Tow Package"});
        
        System.out.println("FORD F-150 RAPTOR:");
        ford.displayAllSpecs();
        ford.testPerformance();
        System.out.println("Environmental Impact: " + ford.calculateEnvironmentalImpact() + " g/km CO2\n");
        
        // Performance comparison
        System.out.println("=== PERFORMANCE COMPARISON ===");
        compareCars(pagani, mclaren, mitsubishi, ford);
    }
    
    public static void compareCars(Car... cars) {
        System.out.printf("%-20s %-8s %-12s %-10s %-12s %-10s%n", 
                         "Model", "0-100", "Top Speed", "Weight", "Power", "CO2");
        System.out.println("=".repeat(75));
        
        for (Car car : cars) {
            System.out.printf("%-20s %-8.1fs %-12dkm/h %-10dkg %-12dHP %-10dg/km%n",
                            car.getMake() + " " + car.getModel(),
                            car.getAcceleration0to100(),
                            car.getTopSpeed(),
                            car.getWeight(),
                            car.calculatePower(),  // Assuming power calculation based on engine
                            car.calculateEnvironmentalImpact());
        }
    }
}

class Car {
    // Basic identification
    private String make;
    private String model;
    private int year;
    private double price;
    private String bodyType;
    
    // Static dimensions (mm and kg)
    private int length;
    private int width;
    private int height;
    private int weight;
    private double turningRadius;
    
    // Dynamic performance
    private int topSpeed;
    private double acceleration0to100;
    private int brakingDistance; // 100-0 km/h in meters
    private double fuelConsumption; // L/100km
    
    // Powertrain
    private String engineType;
    private int cylinders;
    private double engineDisplacement; // Liters
    
    // Body and features
    private String chassisMaterial;
    private boolean hasPowerSteering;
    private boolean hasClimateControl;
    private boolean hasPremiumAudio;
    
    // Environmental and safety
    private int co2Emissions;
    private String[] safetySystems;
    
    public Car(String make, String model, int year, double price, String bodyType,
              int length, int width, int height, int weight, double turningRadius,
              int topSpeed, double acceleration0to100, int brakingDistance, double fuelConsumption,
              String engineType, int cylinders, double engineDisplacement,
              String chassisMaterial, boolean hasPowerSteering, boolean hasClimateControl, 
              boolean hasPremiumAudio, int co2Emissions, String[] safetySystems) {
        
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.bodyType = bodyType;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.turningRadius = turningRadius;
        this.topSpeed = topSpeed;
        this.acceleration0to100 = acceleration0to100;
        this.brakingDistance = brakingDistance;
        this.fuelConsumption = fuelConsumption;
        this.engineType = engineType;
        this.cylinders = cylinders;
        this.engineDisplacement = engineDisplacement;
        this.chassisMaterial = chassisMaterial;
        this.hasPowerSteering = hasPowerSteering;
        this.hasClimateControl = hasClimateControl;
        this.hasPremiumAudio = hasPremiumAudio;
        this.co2Emissions = co2Emissions;
        this.safetySystems = safetySystems;
    }
    
    // Getters
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public int getTopSpeed() { return topSpeed; }
    public double getAcceleration0to100() { return acceleration0to100; }
    public int getWeight() { return weight; }
    
    // Performance methods
    public void testPerformance() {
        System.out.printf("Performance: 0-100: %.1fs, Top Speed: %dkm/h, Braking: %dm%n",
                         acceleration0to100, topSpeed, brakingDistance);
    }
    
    public int calculatePower() {
        // Simplified power calculation based on engine type and displacement
        return (int)(engineDisplacement * cylinders * 15);
    }
    
    public int calculateEnvironmentalImpact() {
        return co2Emissions;
    }
    
    public void displayAllSpecs() {
        System.out.printf("%d %s %s %s - $%.2f%n", year, make, model, bodyType, price);
        System.out.printf("Dimensions: %dx%dx%dmm, Weight: %dkg, Turning: %.1fm%n",
                         length, width, height, weight, turningRadius);
        System.out.printf("Engine: %s %d-cylinder %.1fL%n", engineType, cylinders, engineDisplacement);
        System.out.printf("Fuel: %.1fL/100km, Features: Power Steering(%b), Climate(%b), Premium Audio(%b)%n",
                         fuelConsumption, hasPowerSteering, hasClimateControl, hasPremiumAudio);
        System.out.print("Safety: " + String.join(", ", safetySystems) + "\n");
    }
    
    // Car operation methods
    public void startEngine() {
        System.out.println("Starting " + engineType + " engine... Vroom!");
    }
    
    public void accelerate(int targetSpeed) {
        System.out.printf("Accelerating to %d km/h...%n", targetSpeed);
    }
    
    public void brake() {
        System.out.printf("Braking from %d km/h... Stopping in %d meters%n", topSpeed/2, brakingDistance);
    }
    
    public void turn(double angle) {
        System.out.printf("Turning with %.1fm radius...%n", turningRadius);
    }
    
    @Override
    public String toString() {
        return String.format("%d %s %s (%s) - %dHP, %.1fL/100km",
                           year, make, model, bodyType, calculatePower(), fuelConsumption);
    }
}
