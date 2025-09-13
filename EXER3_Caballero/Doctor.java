public class Doctor {
    private String name;
    private int age;
    private String doctorId;

    // Default constructor
    public Doctor() {
    }

    // Parameterized constructor
    public Doctor(String name, int age, String doctorId) {
        this.name = name;
        this.age = age;
        this.doctorId = doctorId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for doctorId
    public String getDoctorId() {
        return doctorId;
    }

    // Setter for doctorId
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        doctor.setName("Dr. Smith");
        doctor.setAge(45);
        doctor.setDoctorId("D67890");

        System.out.println("Name: " + doctor.getName());
        System.out.println("Age: " + doctor.getAge());
        System.out.println("Doctor ID: " + doctor.getDoctorId());
    }
}
