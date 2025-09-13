public class Patient {
    private String name;
    private int age;
    private String patientId;

    // Default constructor
    public Patient() {
    }

    // Parameterized constructor
    public Patient(String name, int age, String patientId) {
        this.name = name;
        this.age = age;
        this.patientId = patientId;
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

    // Getter for patientId
    public String getPatientId() {
        return patientId;
    }

    // Setter for patientId
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
