public class Car {
    private String color;
    private String plateNo;
    private String chassisNo;

    // no argument constructor
    public Car() {
        this.color = "No color";
        this.plateNo = "No PlateNumber";
        this.chassisNo = "No Chassis No Yet!";
    }
    
    public Car(String color, String plateNo, String chassisNo) {
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
    }

    //-------------------methods------------------
    public void displayInfo() {
        String info = "";
        info += "Color: " + this.color;
        info += "\nPlateNo: " + this.plateNo;
        info += "\nChassisNo: " + this.chassisNo;
        System.out.println(info);
    }
    
    // Getters and setters (optional but recommended)
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getPlateNo() { return plateNo; }
    public void setPlateNo(String plateNo) { this.plateNo = plateNo; }
    public String getChassisNo() { return chassisNo; }
    public void setChassisNo(String chassisNo) { this.chassisNo = chassisNo; }
}