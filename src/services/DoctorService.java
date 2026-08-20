package services;

import entities.Doctor;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;

public class DoctorService implements Manageable, Searchable {

    private Doctor[] doctors = new Doctor[100];
    private int doctorCount = 0;


    // Add ______________________________________________

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Doctor)) {
            System.out.println("Only Doctor objects can be added.");
            return;
        }

        Doctor doctor = (Doctor) entity;

        if (searchById(doctor.getId()) != null) {
            System.out.println("Doctor ID already exists.");
            return;
        }

        if (doctorCount >= doctors.length) {
            System.out.println("Doctor storage is full.");
            return;
        }

        doctors[doctorCount] = doctor;
        doctorCount++;
    }


    // Remove ___________________________________________

    @Override
    public boolean removeById(String id) {

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i].getId().equals(id)) {

                for (int j = i; j < doctorCount - 1; j++) {
                    doctors[j] = doctors[j + 1];
                }

                doctors[doctorCount - 1] = null;
                doctorCount--;

                return true;
            }
        }

        return false;
    }


    // Get All __________________________________________

    @Override
    public Object[] getAll() {

        Doctor[] result = new Doctor[doctorCount];

        for (int i = 0; i < doctorCount; i++) {
            result[i] = doctors[i];
        }

        return result;
    }


    // Search ___________________________________________

    @Override
    public Object[] search(String keyword) {

        Doctor[] temp = new Doctor[doctorCount];
        int count = 0;

        for (int i = 0; i < doctorCount; i++) {

            Doctor doctor = doctors[i];

            if (
                    doctor.getFirstName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || doctor.getLastName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || doctor.getSpecialization()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || doctor.getId()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())
            ) {

                temp[count] = doctor;
                count++;
            }
        }

        Doctor[] result = new Doctor[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    // Search by ID _____________________________________

    @Override
    public Object searchById(String id) {

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }

        return null;
    }


    // Add Surgeon ______________________________________

    public void addSurgeon(Surgeon surgeon) {

        if (surgeon == null) {
            System.out.println("Surgeon cannot be null.");
            return;
        }

        add(surgeon);
    }


    // Assign Patient ___________________________________

    public boolean assignPatient(
            String doctorId,
            String patientId) {

        Doctor doctor =
                (Doctor) searchById(doctorId);

        if (doctor == null) {
            return false;
        }

        doctor.assignPatient(patientId);

        return true;
    }


    // List by Specialization ____________________________

    public Doctor[] listBySpecialization(
            String specialization) {

        Doctor[] temp = new Doctor[doctorCount];
        int count = 0;

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i]
                    .getSpecialization()
                    .equalsIgnoreCase(specialization)) {

                temp[count] = doctors[i];
                count++;
            }
        }

        Doctor[] result = new Doctor[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    // Available Doctors ________________________________

    public Doctor[] availableDoctors() {

        Doctor[] temp = new Doctor[doctorCount];
        int count = 0;

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i].isOnCall()) {

                temp[count] = doctors[i];
                count++;
            }
        }

        Doctor[] result = new Doctor[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    // Count ____________________________________________

    public int getDoctorCount() {
        return doctorCount;
    }
}