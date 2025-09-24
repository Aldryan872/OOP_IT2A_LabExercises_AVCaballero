import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class DoctorDetailsSystem extends JFrame {
    private List<Doctor> doctors = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable doctorTable;
    
    public DoctorDetailsSystem() {
        setTitle("Doctor Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initializeSampleDoctors();
        initUI();
        setVisible(true);
    }
    
    private void initializeSampleDoctors() {
        // Polymorphism in action - Doctor objects treated as HealthSystemUser
        doctors.add(new Doctor("D001", "pass123", "Dr. John Smith", "john@hospital.com", 
                             "Cardiology", "MD", "Male", "555-0101"));
        doctors.add(new Doctor("D002", "pass456", "Dr. Sarah Johnson", "sarah@hospital.com", 
                             "Pediatrics", "MD", "Female", "555-0102"));
    }
    
    private void initUI() {
        setLayout(new BorderLayout());
        
        // Table setup
        String[] columns = {"ID", "Name", "Specialization", "Qualifications", "Contact"};
        tableModel = new DefaultTableModel(columns, 0);
        doctorTable = new JTable(tableModel);
        refreshTable();
        
        add(new JScrollPane(doctorTable), BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton displayInfoBtn = new JButton("Display Doctor Info");
        JButton polymorphicTestBtn = new JButton("Test Polymorphism");
        
        displayInfoBtn.addActionListener(this::displayDoctorInfo);
        polymorphicTestBtn.addActionListener(this::testPolymorphism);
        
        buttonPanel.add(displayInfoBtn);
        buttonPanel.add(polymorphicTestBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Doctor doctor : doctors) {
            tableModel.addRow(new Object[]{
                doctor.getUsername(),
                doctor.getFullName(),
                doctor.getSpecialization(),
                doctor.getQualifications(),
                doctor.getContactNumber()
            });
        }
    }
    
    private void displayDoctorInfo(ActionEvent e) {
        int selectedRow = doctorTable.getSelectedRow();
        if (selectedRow >= 0) {
            Doctor doctor = doctors.get(selectedRow);
            doctor.displayUserInfo(); // Polymorphic method call
        } else {
            JOptionPane.showMessageDialog(this, "Please select a doctor first.");
        }
    }
    
    private void testPolymorphism(ActionEvent e) {
        StringBuilder result = new StringBuilder("Polymorphism Test Results:\n\n");
        
        // 1. Runtime polymorphism through method overriding
        result.append("1. Method Overriding (Runtime Polymorphism):\n");
        for (HealthSystemUser user : doctors) { // Treating Doctor as HealthSystemUser
            result.append(" - ");
            user.displayUserInfo(); // This will call Doctor's overridden method
            result.append("\n");
        }
        
        // 2. Compile-time polymorphism through method overloading
        result.append("\n2. Method Overloading (Compile-time Polymorphism):\n");
        if (!doctors.isEmpty()) {
            Doctor doc = doctors.get(0);
            result.append(" - Single parameter authenticate: ").append(doc.authenticate("D001")).append("\n");
            result.append(" - Two parameter authenticate: ").append(doc.authenticate("D001", "pass123")).append("\n");
        }
        
        // 3. Interface polymorphism
        result.append("\n3. Interface Polymorphism:\n");
        BarangayHealthLogin loginSystem = new BarangayHealthLogin();
        result.append(" - Default interface method called\n");
        
        JOptionPane.showMessageDialog(this, result.toString());
    }
}
