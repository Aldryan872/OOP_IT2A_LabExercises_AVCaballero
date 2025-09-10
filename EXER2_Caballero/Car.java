public class Car {
    private String make;
    private String model;
    private int yearModel;
    private String licensePlate;
    private String color;
    private String founder;
    private int horsePower;
    
    public Car(String make, String model, int yearModel, String licensePlate, 
               String color, String founder, int horsePower) {
        this.make = make;
        this.model = model;
        this.yearModel = yearModel;
        this.licensePlate = licensePlate;
        this.color = color;
        this.founder = founder;
        this.horsePower = horsePower;
    }
    
    // Getter methods
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYearModel() {
        return yearModel;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getFounder() {
        return founder;
    }
    
    public int getHorsePower() {
        return horsePower;
    }
    
    // Method to get car information as a formatted string
    public String getCarInfo(int carNumber) {
        StringBuilder info = new StringBuilder();
        info.append("Car").append(carNumber).append(": ").append(make).append(" ").append(model).append("\n")
            .append("Year Model: ").append(yearModel).append("\n")
            .append("License Plate: ").append(licensePlate).append("\n")
            .append("Color: ").append(color).append("\n")
            .append("Founder of the Car: ").append(founder).append("\n")
            .append("Horse power: ").append(horsePower).append("\n\n");
        return info.toString();
    }
}