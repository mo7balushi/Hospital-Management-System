package services;

import entities.InPatient;
import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;

public class PatientService implements Manageable, Searchable {

    private Patient[] patients = new Patient[100];
    private int patientCount = 0;


    // =========================================================
    // ADD PATIENT OVERLOADS - Task 2.2
    // =========================================================

    // 1. Existing Patient object
    public void addPatient(Patient patient) {

        if (patient == null) {
            System.out.println("Patient cannot be null.");
            return;
        }

        if (patientCount >= patients.length) {
            System.out.println("Patient storage is full.");
            return;
        }

        if (searchById(patient.getId()) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        patients[patientCount] = patient;
        patientCount++;
    }


    // 2. Basic details
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


    // 3. Details + blood group
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


    // =========================================================
    // MANAGEABLE
    // =========================================================

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Patient)) {
            System.out.println("Only Patient objects can be added.");
            return;
        }

        addPatient((Patient) entity);
    }


    @Override
    public boolean removeById(String id) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getId().equals(id)) {

                for (int j = i; j < patientCount - 1; j++) {
                    patients[j] = patients[j + 1];
                }

                patients[patientCount - 1] = null;
                patientCount--;

                return true;
            }
        }

        return false;
    }


    @Override
    public Object[] getAll() {

        Patient[] result = new Patient[patientCount];

        for (int i = 0; i < patientCount; i++) {
            result[i] = patients[i];
        }

        return result;
    }


    // =========================================================
    // SEARCHABLE
    // =========================================================

    @Override
    public Object[] search(String keyword) {

        Patient[] temp = new Patient[patientCount];
        int count = 0;

        for (int i = 0; i < patientCount; i++) {

            Patient patient = patients[i];

            if (
                    patient.getFirstName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || patient.getLastName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || patient.getId()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())
            ) {

                temp[count] = patient;
                count++;
            }
        }

        Patient[] result = new Patient[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    @Override
    public Object searchById(String id) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getId().equals(id)) {
                return patients[i];
            }
        }

        return null;
    }


    // =========================================================
    // UPDATE CONTACT - Task 2.7
    // =========================================================

    public boolean updateContact(
            String patientId,
            String phoneNumber) {

        Patient patient =
                (Patient) searchById(patientId);

        if (patient == null) {
            return false;
        }

        patient.updateContact(phoneNumber);

        return true;
    }


    public boolean updateContact(
            String patientId,
            String phoneNumber,
            String email) {

        Patient patient =
                (Patient) searchById(patientId);

        if (patient == null) {
            return false;
        }

        patient.updateContact(
                phoneNumber,
                email
        );

        return true;
    }


    // =========================================================
    // LIST INPATIENTS - Task 2.7
    // =========================================================

    public InPatient[] listInPatients() {

        InPatient[] temp =
                new InPatient[patientCount];

        int count = 0;

        for (int i = 0; i < patientCount; i++) {

            if (patients[i] instanceof InPatient) {

                temp[count] =
                        (InPatient) patients[i];

                count++;
            }
        }

        InPatient[] result =
                new InPatient[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    // =========================================================
    // TOTAL OUTSTANDING - Task 2.7
    // =========================================================

    public double totalOutstanding() {

        double total = 0;

        for (int i = 0; i < patientCount; i++) {
            total += patients[i]
                    .getOutstandingBalance();
        }

        return total;
    }


    // =========================================================
    // COUNT
    // =========================================================

    public int getPatientCount() {
        return patientCount;
    }
}