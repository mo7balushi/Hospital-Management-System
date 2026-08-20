import entities.Person;
import entities.Patient;
import entities.Doctor;
import entities.Nurse;
import entities.InPatient;
import entities.Surgeon;
import utils.InputHandler;

public class HospitalApp {

    public static void main(String[] args) {
        start();
    }


    // Main Menu ________________________________________________

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
                    System.out.println(
                            "Patients menu coming next."
                    );
                    break;

                case 2:
                    System.out.println(
                            "Doctors menu coming next."
                    );
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


    // Polymorphism Helpers ______________________________________

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

        System.out.println("\n--- COUNT BY TYPE ---");
        System.out.println("Person: " + personCount);
        System.out.println("Patient: " + patientCount);
        System.out.println("Doctor: " + doctorCount);
        System.out.println("Nurse: " + nurseCount);
        System.out.println("InPatient: " + inPatientCount);
        System.out.println("Surgeon: " + surgeonCount);
    }


    public static Person findOldest(Person[] people) {

        Person oldest = null;

        for (Person person : people) {

            if (person == null) {
                continue;
            }

            if (oldest == null
                    || person.getAge() > oldest.getAge()) {

                oldest = person;
            }
        }

        return oldest;
    }
}