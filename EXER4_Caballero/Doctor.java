// Doctor.java - Derived class demonstrating inheritance and method overriding
public class Doctor extends HealthSystemUser {
    private String specialization;
    private String qualifications;
    private String gender;
    private String contactNumber;
    
    public Doctor(String username, String password, String fullName, String email, 
                 String specialization, String qualifications, String gender, String contactNumber) {
        super(username, password, fullName, email);
        this.specialization = specialization;
        this.qualifications = qualifications;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }
    
    // Method overriding - runtime polymorphism
    @Override
    public void displayUserInfo() {
        System.out.println("Doctor Information:");
        System.out.println("Name: " + fullName);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualifications: " + qualifications);
        System.out.println("Contact: " + contactNumber);
    }
    
    // Method overloading
    public void setContactInfo(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public void setContactInfo(String contactNumber, String email) {
        this.contactNumber = contactNumber;
        this.email = email;
    }
    
    // Getters
    public String getSpecialization() { return specialization; }
    public String getQualifications() { return qualifications; }
    public String getGender() { return gender; }
    public String getContactNumber() { return contactNumber; }
    
    @Override
    public String toString() {
        return "Dr. " + fullName + " - " + specialization + " (" + qualifications + ")";
    }
}
