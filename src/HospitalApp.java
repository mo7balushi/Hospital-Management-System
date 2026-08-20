import entities.Person;
import entities.Patient;
import entities.Doctor;
import entities.Nurse;
import entities.InPatient;
import entities.Surgeon;

public class HospitalApp {

    public static void main(String[] args) {

        Person[] people = new Person[6];
        Person person = new Person(
                "P001",
                "Ahmed",
                "Ali",
                "01-01-1990",
                "Male",
                "91234567",
                "ahmed@email.com",
                "Muscat",
                "N001",
                36,
                true
        );

        Patient patient = new Patient(
                "P002",
                "Sara",
                "Hassan",
                "05-05-1995",
                "Female",
                "92345678",
                "sara@email.com",
                "Sohar",
                "N002",
                31,
                true,
                "A+",
                "99887766",
                "19-08-2026",
                100.0,
                true
        );

        Doctor doctor = new Doctor(
                "D001",
                "Omar",
                "Salim",
                "10-10-1985",
                "Male",
                "93456789",
                "omar@email.com",
                "Muscat",
                "N003",
                40,
                true,
                "Cardiology",
                12,
                25.0,
                true
        );

        Nurse nurse = new Nurse(
                "N001",
                "Maryam",
                "Said",
                "12-12-1992",
                "Female",
                "94567890",
                "maryam@email.com",
                "Nizwa",
                "N004",
                33,
                true,
                "DEP01",
                "Night",
                8
        );

        InPatient inPatient = new InPatient(
                "P003",
                "Khalid",
                "Nasser",
                "03-03-1988",
                "Male",
                "95678901",
                "khalid@email.com",
                "Salalah",
                "N005",
                38,
                true,
                "O+",
                "98765432",
                "18-08-2026",
                200.0,
                false,
                "18-08-2026",
                "R101",
                50.0,
                3
        );

        Surgeon surgeon = new Surgeon(
                "D002",
                "Fatma",
                "Ahmed",
                "07-07-1980",
                "Female",
                "96789012",
                "fatma@email.com",
                "Muscat",
                "N006",
                46,
                true,
                "Surgery",
                18,
                40.0,
                true,
                120,
                true
        );
        people[0] = person;
        people[1] = patient;
        people[2] = doctor;
        people[3] = nurse;
        people[4] = inPatient;
        people[5] = surgeon;
        System.out.println("\n--- POLYMORPHISM TEST ---");
        printAll(people);
        countByType(people);

    }





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
}