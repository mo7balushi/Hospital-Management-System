package services;

import entities.Patient;

public class PatientService {

    private Patient[] patients = new Patient[100];
    private int patientCount = 0;


    // Add existing Patient object
    public void addPatient(Patient patient) {

        if (patient == null) {
            System.out.println("Patient cannot be null.");
            return;
        }

        if (patientCount >= patients.length) {
            System.out.println("Patient storage is full.");
            return;
        }

        patients[patientCount] = patient;
        patientCount++;
    }


    // Basic details
    public void addPatient(
            String id,
            String firstName,
            String lastName,
            String phoneNumber) {

        Patient patient = new Patient(
                id,
                firstName,
                lastName,
                "N/A",
                "Unknown",
                phoneNumber,
                "unknown@hospital.com",
                "N/A",
                "N/A",
                0,
                true,
                "Unknown",
                "N/A",
                "N/A",
                0,
                false
        );

        addPatient(patient);
    }


    // Details + blood group
    public void addPatient(
            String id,
            String firstName,
            String lastName,
            String phoneNumber,
            String bloodGroup) {

        Patient patient = new Patient(
                id,
                firstName,
                lastName,
                "N/A",
                "Unknown",
                phoneNumber,
                "unknown@hospital.com",
                "N/A",
                "N/A",
                0,
                true,
                bloodGroup,
                "N/A",
                "N/A",
                0,
                false
        );

        addPatient(patient);
    }


    public int getPatientCount() {
        return patientCount;
    }
}