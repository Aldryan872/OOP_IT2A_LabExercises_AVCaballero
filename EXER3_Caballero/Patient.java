import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Address class
class Address {
    private String houseNumber;
    private String street;
    private String purokSitio;
    private String barangay;
    private String cityMunicipality;
    private String province;
    
    public Address(String houseNumber, String street, String purokSitio, String barangay, 
                  String cityMunicipality, String province) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.purokSitio = purokSitio;
        this.barangay = barangay;
        this.cityMunicipality = cityMunicipality;
        this.province = province;
    }
    
    public String getFullAddress() {
        return houseNumber + " " + street + ", " + purokSitio + ", " + 
               barangay + ", " + cityMunicipality + ", " + province;
    }
    
    // Getters and setters
    public String getHouseNumber() { return houseNumber; }
    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }
    
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    
    public String getPurokSitio() { return purokSitio; }
    public void setPurokSitio(String purokSitio) { this.purokSitio = purokSitio; }
    
    public String getBarangay() { return barangay; }
    public void setBarangay(String barangay) { this.barangay = barangay; }
    
    public String getCityMunicipality() { return cityMunicipality; }
    public void setCityMunicipality(String cityMunicipality) { this.cityMunicipality = cityMunicipality; }
    
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
}

// ContactInfo class
class ContactInfo {
    private String mobileNumber;
    private String landlineNumber;
    private String emailAddress;
    private String emergencyContactName;
    private String emergencyContactNumber;
    
    public ContactInfo(String mobileNumber, String landlineNumber, String emailAddress, 
                      String emergencyContactName, String emergencyContactNumber) {
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
        this.emailAddress = emailAddress;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
    }
    
    // Getters and setters
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    
    public String getLandlineNumber() { return landlineNumber; }
    public void setLandlineNumber(String landlineNumber) { this.landlineNumber = landlineNumber; }
    
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    
    public String getEmergencyContactName() { return emergencyContactName; }
    public void setEmergencyContactName(String emergencyContactName) { this.emergencyContactName = emergencyContactName; }
    
    public String getEmergencyContactNumber() { return emergencyContactNumber; }
    public void setEmergencyContactNumber(String emergencyContactNumber) { this.emergencyContactNumber = emergencyContactNumber; }
}

// MedicalRecord class
class MedicalRecord {
    private List<String> knownAllergies;
    private List<String> currentMedications;
    private List<String> preExistingConditions;
    private String familyHistory;
    private String immunizationRecord;
    
    public MedicalRecord() {
        this.knownAllergies = new ArrayList<>();
        this.currentMedications = new ArrayList<>();
        this.preExistingConditions = new ArrayList<>();
        this.familyHistory = "";
        this.immunizationRecord = "";
    }
    
    // Methods to manage lists
    public void addAllergy(String allergy) {
        knownAllergies.add(allergy);
    }
    
    public void addMedication(String medication) {
        currentMedications.add(medication);
    }
    
    public void addCondition(String condition) {
        preExistingConditions.add(condition);
    }
    
    // Getters and setters
    public List<String> getKnownAllergies() { return new ArrayList<>(knownAllergies); }
    public void setKnownAllergies(List<String> knownAllergies) { this.knownAllergies = new ArrayList<>(knownAllergies); }
    
    public List<String> getCurrentMedications() { return new ArrayList<>(currentMedications); }
    public void setCurrentMedications(List<String> currentMedications) { this.currentMedications = new ArrayList<>(currentMedications); }
    
    public List<String> getPreExistingConditions() { return new ArrayList<>(preExistingConditions); }
    public void setPreExistingConditions(List<String> preExistingConditions) { this.preExistingConditions = new ArrayList<>(preExistingConditions); }
    
    public String getFamilyHistory() { return familyHistory; }
    public void setFamilyHistory(String familyHistory) { this.familyHistory = familyHistory; }
    
    public String getImmunizationRecord() { return immunizationRecord; }
    public void setImmunizationRecord(String immunizationRecord) { this.immunizationRecord = immunizationRecord; }
}

// Consultation class
class Consultation {
    private String consultationId;
    private LocalDate date;
    private String physicianName;
    private String subjectiveComplaints;
    private String objectiveFindings;
    private String assessment;
    private String plan;
    private List<String> prescriptions;
    
    public Consultation(String consultationId, LocalDate date, String physicianName) {
        this.consultationId = consultationId;
        this.date = date;
        this.physicianName = physicianName;
        this.prescriptions = new ArrayList<>();
        this.subjectiveComplaints = "";
        this.objectiveFindings = "";
        this.assessment = "";
        this.plan = "";
    }
    
    public void addPrescription(String prescription) {
        prescriptions.add(prescription);
    }
    
    // Getters and setters
    public String getConsultationId() { return consultationId; }
    public void setConsultationId(String consultationId) { this.consultationId = consultationId; }
    
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    public String getPhysicianName() { return physicianName; }
    public void setPhysicianName(String physicianName) { this.physicianName = physicianName; }
    
    public String getSubjectiveComplaints() { return subjectiveComplaints; }
    public void setSubjectiveComplaints(String subjectiveComplaints) { this.subjectiveComplaints = subjectiveComplaints; }
    
    public String getObjectiveFindings() { return objectiveFindings; }
    public void setObjectiveFindings(String objectiveFindings) { this.objectiveFindings = objectiveFindings; }
    
    public String getAssessment() { return assessment; }
    public void setAssessment(String assessment) { this.assessment = assessment; }
    
    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }
    
    public List<String> getPrescriptions() { return new ArrayList<>(prescriptions); }
    public void setPrescriptions(List<String> prescriptions) { this.prescriptions = new ArrayList<>(prescriptions); }
}

// Patient class
class Patient {
    private String patientId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String suffix;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String sex;
    private String civilStatus;
    private String nationality;
    private String religion;
    private String bloodType;
    
    // Composition relationships
    private Address address;
    private ContactInfo contactInfo;
    private MedicalRecord medicalRecord;
    
    // Aggregation relationship
    private List<Consultation> consultationHistory;
    
    public Patient(String patientId, String lastName, String firstName, LocalDate dateOfBirth, String sex) {
        this.patientId = patientId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.consultationHistory = new ArrayList<>();
        this.medicalRecord = new MedicalRecord();
    }
    
    public int calculateAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
    
    public String getFullName() {
        return firstName + " " + (middleName != null ? middleName + " " : "") + lastName + (suffix != null ? " " + suffix : "");
    }
    
    public void addConsultation(Consultation consultation) {
        consultationHistory.add(consultation);
    }
    
    // Getters and setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    
    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) { this.suffix = suffix; }
    
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    
    public String getPlaceOfBirth() { return placeOfBirth; }
    public void setPlaceOfBirth(String placeOfBirth) { this.placeOfBirth = placeOfBirth; }
    
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    
    public String getCivilStatus() { return civilStatus; }
    public void setCivilStatus(String civilStatus) { this.civilStatus = civilStatus; }
    
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    
    public String getReligion() { return religion; }
    public void setReligion(String religion) { this.religion = religion; }
    
    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }
    
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    
    public ContactInfo getContactInfo() { return contactInfo; }
    public void setContactInfo(ContactInfo contactInfo) { this.contactInfo = contactInfo; }
    
    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord) { this.medicalRecord = medicalRecord; }
    
    public List<Consultation> getConsultationHistory() { return new ArrayList<>(consultationHistory); }
}

// Main class to demonstrate the system
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== BARANGAY HEALTH INFORMATION SYSTEM ===");
        
        // Create a patient
        Patient patient = new Patient("BRGY-PAT-2024-0105", "Dela Cruz", "Juan", 
                                    LocalDate.of(1985, 5, 15), "Male");
        patient.setMiddleName("Santos");
        patient.setBloodType("O+");
        patient.setCivilStatus("Married");
        patient.setNationality("Filipino");
        patient.setReligion("Catholic");
        
        // Set address
        Address address = new Address("123", "Rizal Street", "Purok 5", "Barangay San Jose", 
                                    "City of San Fernando", "Pampanga");
        patient.setAddress(address);
        
        // Set contact information
        ContactInfo contactInfo = new ContactInfo("09123456789", "045-123-4567", 
                                                "juan.delacruz@email.com", "Maria Dela Cruz", "09187654321");
        patient.setContactInfo(contactInfo);
        
        // Add medical information
        MedicalRecord medicalRecord = patient.getMedicalRecord();
        medicalRecord.addAllergy("Penicillin");
        medicalRecord.addAllergy("Shellfish");
        medicalRecord.addCondition("Hypertension");
        medicalRecord.addCondition("Asthma");
        medicalRecord.addMedication("Lisinopril 10mg daily");
        medicalRecord.addMedication("Salbutamol inhaler as needed");
        medicalRecord.setImmunizationRecord("Complete basic immunization; COVID-19 vaccinated (3 doses)");
        medicalRecord.setFamilyHistory("Father: Hypertension, Mother: Diabetes");
        
        // Add consultations
        Consultation consultation1 = new Consultation("CONS-2024-001", LocalDate.of(2024, 1, 15), "Dr. Garcia");
        consultation1.setSubjectiveComplaints("Headache and dizziness for 3 days");
        consultation1.setObjectiveFindings("BP: 150/95 mmHg, HR: 88 bpm, Temp: 36.8°C");
        consultation1.setAssessment("Hypertension, uncontrolled");
        consultation1.setPlan("Increase Lisinopril to 20mg daily; Low salt diet; Follow-up in 2 weeks");
        consultation1.addPrescription("Lisinopril 20mg tablet #30 - Take 1 tablet once daily");
        
        Consultation consultation2 = new Consultation("CONS-2024-002", LocalDate.now(), "Dr. Reyes");
        consultation2.setSubjectiveComplaints("Shortness of breath, chest tightness");
        consultation2.setObjectiveFindings("BP: 130/85 mmHg, HR: 92 bpm, O2 Sat: 96%");
        consultation2.setAssessment("Asthma exacerbation");
        consultation2.setPlan("Continue medications; Avoid triggers; Use inhaler as needed");
        consultation2.addPrescription("Salbutamol inhaler 1-2 puffs every 4-6 hours as needed");
        
        patient.addConsultation(consultation1);
        patient.addConsultation(consultation2);
        
        // Display patient information
        System.out.println("\n--- PATIENT INFORMATION ---");
        System.out.println("Patient ID: " + patient.getPatientId());
        System.out.println("Name: " + patient.getFullName());
        System.out.println("Age: " + patient.calculateAge() + " years old");
        System.out.println("Date of Birth: " + patient.getDateOfBirth());
        System.out.println("Sex: " + patient.getSex());
        System.out.println("Civil Status: " + patient.getCivilStatus());
        System.out.println("Nationality: " + patient.getNationality());
        System.out.println("Religion: " + patient.getReligion());
        System.out.println("Blood Type: " + patient.getBloodType());
        
        System.out.println("\n--- ADDRESS ---");
        System.out.println("Address: " + patient.getAddress().getFullAddress());
        
        System.out.println("\n--- CONTACT INFORMATION ---");
        System.out.println("Mobile: " + patient.getContactInfo().getMobileNumber());
        System.out.println("Landline: " + patient.getContactInfo().getLandlineNumber());
        System.out.println("Email: " + patient.getContactInfo().getEmailAddress());
        System.out.println("Emergency Contact: " + patient.getContactInfo().getEmergencyContactName() + 
                          " - " + patient.getContactInfo().getEmergencyContactNumber());
        
        System.out.println("\n--- MEDICAL HISTORY ---");
        System.out.println("Known Allergies: " + String.join(", ", medicalRecord.getKnownAllergies()));
        System.out.println("Pre-existing Conditions: " + String.join(", ", medicalRecord.getPreExistingConditions()));
        System.out.println("Current Medications: " + String.join(", ", medicalRecord.getCurrentMedications()));
        System.out.println("Family History: " + medicalRecord.getFamilyHistory());
        System.out.println("Immunization Record: " + medicalRecord.getImmunizationRecord());
        
        System.out.println("\n--- CONSULTATION HISTORY ---");
        List<Consultation> consultations = patient.getConsultationHistory();
        for (int i = 0; i < consultations.size(); i++) {
            Consultation cons = consultations.get(i);
            System.out.println("\nConsultation #" + (i+1) + ":");
            System.out.println("  Date: " + cons.getDate());
            System.out.println("  Physician: " + cons.getPhysicianName());
            System.out.println("  Complaints: " + cons.getSubjectiveComplaints());
            System.out.println("  Findings: " + cons.getObjectiveFindings());
            System.out.println("  Assessment: " + cons.getAssessment());
            System.out.println("  Plan: " + cons.getPlan());
            System.out.println("  Prescriptions: " + String.join(", ", cons.getPrescriptions()));
        }
        
        scanner.close();
    }
}