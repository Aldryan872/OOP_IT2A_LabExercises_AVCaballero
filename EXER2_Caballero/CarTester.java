public class CarTester {
    public static void main(String[] args) {
        System.out.println("Here are the different types of cars: Ford Mustang GTD, Toyota Fortuner, McLaren 12C, Mitsubishi Outlander, Audi Q2 and Pagani Huayra \n");
        
        // Create car objects
        Car c1 = new Car("Ford", "Mustang GTD", 2025, "DG12WE", "Yellow", "Henry Ford", 803);
        Car c2 = new Car("Toyota", "Fortuner", 2005, "GF13SE", "White", "Kiichiro Toyoda", 148);
        Car c3 = new Car("McLaren", "12C", 2011, "GHT18C", "Pink", "Bruce McLaren", 616);
        Car c4 = new Car("Mitsubishi", "Outlander", 2001, "45F64Z", "White", "Yataro Iwasaki", 181);
        Car c5 = new Car("Audi", "Q2", 2025, "SFT12Y", "Yellow", "August Horch", 116);
        Car c6 = new Car("Pagani", "Huayra", 2012, "GYTKRT", "Brown", "Horacio Pagani", 730);
        
        // Add a new car
        Car c7 = new Car("Tesla", "Model S", 2023, "TES123", "Red", "Elon Musk", 1020);
        
        // Get and display car information
        String info1 = c1.getCarInfo(1);
        String info2 = c2.getCarInfo(2);
        String info3 = c3.getCarInfo(3);
        String info4 = c4.getCarInfo(4);
        String info5 = c5.getCarInfo(5);
        String info6 = c6.getCarInfo(6);
        String info7 = c7.getCarInfo(7);
        
        System.out.println(info1);
        System.out.println(info2);
        System.out.println(info3);
        System.out.println(info4);
        System.out.println(info5);
        System.out.println(info6);
        System.out.println(info7);
    }
}