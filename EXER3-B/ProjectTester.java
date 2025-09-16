te /*
Class Hierarchy Diagram:

BarangayHealthDashboard
|
+-- Department
+-- Employee
+-- Patient
+-- Room

(BarangayHealthLogin and PatientInformationForm are separate GUI classes and not instantiated in the tester to avoid display issues)
*/

// Equivalent code for BarangayHealthDashboard and its inner classes

public class BarangayHealthDashboard {
   public BarangayHealthDashboard() {
        System.out.println("BarangayHealthDashboard instance created.");
    }

    public static class Department {
        public Department() {
            System.out.println("Department instance created.");
        }
    }

    public static class Employee {
        public Employee() {
            System.out.println("Employee instance created.");
        }
    }

    public static class Patient {
        public Patient() {
            System.out.println("Patient instance created.");
        }
    }

    public static class Room {
        public Room() {
            System.out.println("Room instance created.");
        }
    }
}
