import entities.Person;
import entities.Patient;
import entities.Doctor;
import entities.Nurse;
import entities.InPatient;
import entities.Surgeon;

import services.PatientService;
import services.DoctorService;

import utils.InputHandler;

public class HospitalApp {

    private static PatientService patientService =
            new PatientService();

    private static DoctorService doctorService =
            new DoctorService();


    public static void main(String[] args) {
        start();
    }


    // =========================================================
    // Main Menu
    // =========================================================

    public static void start() {

        boolean exit = false;

        while (!exit) {

            System.out.println("\n==============================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Patients");
            System.out.println("2. Doctors");
            System.out.println("3. Nurses");
            System.out.println("4. Appointments");
            System.out.println("5. Medical Records");
            System.out.println("6. Reports");
            System.out.println("7. Exit");

            int choice = InputHandler.readInt(
                    "Choose option: ",
                    1,
                    7
            );

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    doctorMenu();
                    break;

                case 3:
                    System.out.println(
                            "Nurses menu coming next."
                    );
                    break;

                case 4:
                    System.out.println(
                            "Appointments menu coming next."
                    );
                    break;

                case 5:
                    System.out.println(
                            "Medical Records menu coming next."
                    );
                    break;

                case 6:
                    System.out.println(
                            "Reports menu coming next."
                    );
                    break;

                case 7:
                    exit = true;

                    System.out.println(
                            "Exiting Hospital Management System."
                    );
                    break;
            }
        }
    }


    // =========================================================
    // Patient Menu
    // =========================================================

    public static void patientMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n--- PATIENT MENU ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient By ID");
            System.out.println("4. Remove Patient");
            System.out.println("5. Total Outstanding");
            System.out.println("6. Back");

            int choice = InputHandler.readInt(
                    "Choose option: ",
                    1,
                    6
            );

            switch (choice) {

                case 1:
                    addPatientHandler();
                    break;

                case 2:
                    viewPatientsHandler();
                    break;

                case 3:
                    searchPatientHandler();
                    break;

                case 4:
                    removePatientHandler();
                    break;

                case 5:
                    System.out.println(
                            "Total Outstanding: "
                                    + patientService
                                    .totalOutstanding()
                    );
                    break;

                case 6:
                    back = true;
                    break;
            }
        }
    }


    // Add Patient ______________________________________________

    public static void addPatientHandler() {

        String id =
                InputHandler.readText(
                        "Enter patient ID: "
                );

        String firstName =
                InputHandler.readText(
                        "Enter first name: "
                );

        String lastName =
                InputHandler.readText(
                        "Enter last name: "
                );

        String phone =
                InputHandler.readText(
                        "Enter phone number: "
                );

        String bloodGroup =
                InputHandler.readText(
                        "Enter blood group: "
                );

        patientService.addPatient(
                id,
                firstName,
                lastName,
                phone,
                bloodGroup
        );

        System.out.println(
                "Patient added successfully."
        );
    }


    // View Patients _____________________________________________

    public static void viewPatientsHandler() {

        Object[] patients =
                patientService.getAll();

        if (patients.length == 0) {

            System.out.println(
                    "No patients found."
            );

            return;
        }

        for (Object obj : patients) {

            Patient patient =
                    (Patient) obj;

            patient.displayInfo();
        }
    }


    // Search Patient ____________________________________________

    public static void searchPatientHandler() {

        String id =
                InputHandler.readText(
                        "Enter patient ID: "
                );

        Patient patient =
                (Patient) patientService
                        .searchById(id);

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        patient.displayInfo();
    }


    // Remove Patient ____________________________________________

    public static void removePatientHandler() {

        String id =
                InputHandler.readText(
                        "Enter patient ID to remove: "
                );

        boolean removed =
                patientService.removeById(id);

        if (removed) {

            System.out.println(
                    "Patient removed successfully."
            );

        } else {

            System.out.println(
                    "Patient not found."
            );
        }
    }


    // =========================================================
    // Doctor Menu
    // =========================================================

    public static void doctorMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n--- DOCTOR MENU ---");
            System.out.println("1. View All Doctors");
            System.out.println("2. Search Doctor By ID");
            System.out.println("3. Remove Doctor");
            System.out.println("4. List By Specialization");
            System.out.println("5. Available Doctors");
            System.out.println("6. Back");

            int choice = InputHandler.readInt(
                    "Choose option: ",
                    1,
                    6
            );

            switch (choice) {

                case 1:
                    viewDoctorsHandler();
                    break;

                case 2:
                    searchDoctorHandler();
                    break;

                case 3:
                    removeDoctorHandler();
                    break;

                case 4:
                    listDoctorsBySpecializationHandler();
                    break;

                case 5:
                    availableDoctorsHandler();
                    break;

                case 6:
                    back = true;
                    break;
            }
        }
    }


    // View Doctors ______________________________________________

    public static void viewDoctorsHandler() {

        Object[] doctors =
                doctorService.getAll();

        if (doctors.length == 0) {

            System.out.println(
                    "No doctors found."
            );

            return;
        }

        for (Object obj : doctors) {

            Doctor doctor =
                    (Doctor) obj;

            doctor.displayInfo();
        }
    }


    // Search Doctor _____________________________________________

    public static void searchDoctorHandler() {

        String id =
                InputHandler.readText(
                        "Enter doctor ID: "
                );

        Doctor doctor =
                (Doctor) doctorService
                        .searchById(id);

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        doctor.displayInfo();
    }


    // Remove Doctor _____________________________________________

    public static void removeDoctorHandler() {

        String id =
                InputHandler.readText(
                        "Enter doctor ID to remove: "
                );

        boolean removed =
                doctorService.removeById(id);

        if (removed) {

            System.out.println(
                    "Doctor removed successfully."
            );

        } else {

            System.out.println(
                    "Doctor not found."
            );
        }
    }


    // List Doctors By Specialization _____________________________

    public static void listDoctorsBySpecializationHandler() {

        String specialization =
                InputHandler.readText(
                        "Enter specialization: "
                );

        Doctor[] doctors =
                doctorService
                        .listBySpecialization(
                                specialization
                        );

        if (doctors.length == 0) {

            System.out.println(
                    "No doctors found."
            );

            return;
        }

        for (Doctor doctor : doctors) {
            doctor.displayInfo();
        }
    }


    // Available Doctors _________________________________________

    public static void availableDoctorsHandler() {

        Doctor[] doctors =
                doctorService.availableDoctors();

        if (doctors.length == 0) {

            System.out.println(
                    "No available doctors found."
            );

            return;
        }

        for (Doctor doctor : doctors) {
            doctor.displayInfo();
        }
    }


    // =========================================================
    // Polymorphism Helpers - Task 2.3
    // =========================================================

    public static void printAll(Person[] people) {

        for (Person person : people) {

            if (person != null) {
                person.displayInfo();
            }
        }
    }


    public static void countByType(Person[] people) {

        int personCount = 0;
        int patientCount = 0;
        int doctorCount = 0;
        int nurseCount = 0;
        int inPatientCount = 0;
        int surgeonCount = 0;

        for (Person person : people) {

            if (person == null) {
                continue;
            }

            if (person instanceof InPatient) {
                inPatientCount++;

            } else if (person instanceof Surgeon) {
                surgeonCount++;

            } else if (person instanceof Patient) {
                patientCount++;

            } else if (person instanceof Doctor) {
                doctorCount++;

            } else if (person instanceof Nurse) {
                nurseCount++;

            } else {
                personCount++;
            }
        }

        System.out.println(
                "\n--- COUNT BY TYPE ---"
        );

        System.out.println(
                "Person: " + personCount
        );

        System.out.println(
                "Patient: " + patientCount
        );

        System.out.println(
                "Doctor: " + doctorCount
        );

        System.out.println(
                "Nurse: " + nurseCount
        );

        System.out.println(
                "InPatient: " + inPatientCount
        );

        System.out.println(
                "Surgeon: " + surgeonCount
        );
    }


    public static Person findOldest(
            Person[] people) {

        Person oldest = null;

        for (Person person : people) {

            if (person == null) {
                continue;
            }

            if (oldest == null
                    || person.getAge()
                    > oldest.getAge()) {

                oldest = person;
            }
        }

        return oldest;
    }
}//