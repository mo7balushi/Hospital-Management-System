import entities.Person;
import entities.Patient;
import entities.Doctor;
import entities.Nurse;
import entities.InPatient;
import entities.Surgeon;
import entities.Appointment;
import entities.MedicalRecord;

import services.PatientService;
import services.DoctorService;
import services.NurseService;
import services.AppointmentService;
import services.RecordService;

import utils.InputHandler;
import utils.HelperUtils;

public class HospitalApp {

    private static PatientService patientService =
            new PatientService();

    private static DoctorService doctorService =
            new DoctorService();

    private static NurseService nurseService =
            new NurseService();

    private static AppointmentService appointmentService =
            new AppointmentService();

    private static RecordService recordService =
            new RecordService();


    public static void main(String[] args) {

        seedSampleData();

        runTask29Tests();

        start();
    }


    // =========================================================
    // MAIN MENU
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
                    nurseMenu();
                    break;

                case 4:
                    appointmentMenu();
                    break;

                case 5:
                    recordMenu();
                    break;

                case 6:
                    reportsHandler();
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
    // PATIENT MENU
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
    // DOCTOR MENU
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


    public static void listDoctorsBySpecializationHandler() {

        String specialization =
                InputHandler.readText(
                        "Enter specialization: "
                );

        Doctor[] doctors =
                doctorService.listBySpecialization(
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
    // NURSE MENU
    // =========================================================

    public static void nurseMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n--- NURSE MENU ---");
            System.out.println("1. View All Nurses");
            System.out.println("2. Search Nurse By ID");
            System.out.println("3. Remove Nurse");
            System.out.println("4. List By Shift");
            System.out.println("5. Reassign Patient");
            System.out.println("6. Back");

            int choice = InputHandler.readInt(
                    "Choose option: ",
                    1,
                    6
            );

            switch (choice) {

                case 1:
                    viewNursesHandler();
                    break;

                case 2:
                    searchNurseHandler();
                    break;

                case 3:
                    removeNurseHandler();
                    break;

                case 4:
                    listNursesByShiftHandler();
                    break;

                case 5:
                    reassignPatientHandler();
                    break;

                case 6:
                    back = true;
                    break;
            }
        }
    }


    public static void viewNursesHandler() {

        Object[] nurses =
                nurseService.getAll();

        if (nurses.length == 0) {
            System.out.println(
                    "No nurses found."
            );
            return;
        }

        for (Object obj : nurses) {

            Nurse nurse =
                    (Nurse) obj;

            nurse.displayInfo();
        }
    }


    public static void searchNurseHandler() {

        String id =
                InputHandler.readText(
                        "Enter nurse ID: "
                );

        Nurse nurse =
                (Nurse) nurseService
                        .searchById(id);

        if (nurse == null) {

            System.out.println(
                    "Nurse not found."
            );

            return;
        }

        nurse.displayInfo();
    }


    public static void removeNurseHandler() {

        String id =
                InputHandler.readText(
                        "Enter nurse ID to remove: "
                );

        boolean removed =
                nurseService.removeById(id);

        if (removed) {

            System.out.println(
                    "Nurse removed successfully."
            );

        } else {

            System.out.println(
                    "Nurse not found."
            );
        }
    }


    public static void listNursesByShiftHandler() {

        String shift =
                InputHandler.readText(
                        "Enter shift: "
                );

        Nurse[] nurses =
                nurseService.listByShift(shift);

        if (nurses.length == 0) {

            System.out.println(
                    "No nurses found for this shift."
            );

            return;
        }

        for (Nurse nurse : nurses) {
            nurse.displayInfo();
        }
    }


    public static void reassignPatientHandler() {

        String fromNurseId =
                InputHandler.readText(
                        "Enter current nurse ID: "
                );

        String toNurseId =
                InputHandler.readText(
                        "Enter new nurse ID: "
                );

        String patientId =
                InputHandler.readText(
                        "Enter patient ID: "
                );

        boolean reassigned =
                nurseService.reassign(
                        fromNurseId,
                        toNurseId,
                        patientId
                );

        if (reassigned) {

            System.out.println(
                    "Patient reassigned successfully."
            );

        } else {

            System.out.println(
                    "Unable to reassign patient."
            );
        }
    }


    // =========================================================
    // APPOINTMENT MENU
    // =========================================================

    public static void appointmentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n--- APPOINTMENT MENU ---"
            );

            System.out.println(
                    "1. Schedule Appointment"
            );

            System.out.println(
                    "2. View All Appointments"
            );

            System.out.println(
                    "3. Cancel Appointment"
            );

            System.out.println(
                    "4. Complete Appointment"
            );

            System.out.println(
                    "5. Reschedule Appointment"
            );

            System.out.println(
                    "6. List By Status"
            );

            System.out.println(
                    "7. List By Patient"
            );

            System.out.println(
                    "8. Back"
            );

            int choice = InputHandler.readInt(
                    "Choose option: ",
                    1,
                    8
            );

            switch (choice) {

                case 1:
                    scheduleAppointmentHandler();
                    break;

                case 2:
                    viewAppointmentsHandler();
                    break;

                case 3:
                    cancelAppointmentHandler();
                    break;

                case 4:
                    completeAppointmentHandler();
                    break;

                case 5:
                    rescheduleAppointmentHandler();
                    break;

                case 6:
                    listAppointmentsByStatusHandler();
                    break;

                case 7:
                    listAppointmentsByPatientHandler();
                    break;

                case 8:
                    back = true;
                    break;
            }
        }
    }


    public static void scheduleAppointmentHandler() {

        String patientId =
                InputHandler.readText(
                        "Enter patient ID: "
                );

        String doctorId =
                InputHandler.readText(
                        "Enter doctor ID: "
                );

        String date =
                InputHandler.readText(
                        "Enter appointment date: "
                );

        String time =
                InputHandler.readText(
                        "Enter appointment time: "
                );

        appointmentService.schedule(
                patientId,
                doctorId,
                date,
                time
        );

        System.out.println(
                "Appointment scheduled successfully."
        );
    }


    public static void viewAppointmentsHandler() {

        Object[] appointments =
                appointmentService.getAll();

        if (appointments.length == 0) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (Object obj : appointments) {

            Appointment appointment =
                    (Appointment) obj;

            appointment.displayInfo();
        }
    }


    public static void cancelAppointmentHandler() {

        String id =
                InputHandler.readText(
                        "Enter appointment ID: "
                );

        boolean cancelled =
                appointmentService.cancel(id);

        if (cancelled) {

            System.out.println(
                    "Appointment cancelled."
            );

        } else {

            System.out.println(
                    "Appointment not found."
            );
        }
    }


    public static void completeAppointmentHandler() {

        String id =
                InputHandler.readText(
                        "Enter appointment ID: "
                );

        boolean completed =
                appointmentService.complete(id);

        if (completed) {

            System.out.println(
                    "Appointment completed."
            );

        } else {

            System.out.println(
                    "Appointment not found."
            );
        }
    }


    public static void rescheduleAppointmentHandler() {

        String id =
                InputHandler.readText(
                        "Enter appointment ID: "
                );

        String newDate =
                InputHandler.readText(
                        "Enter new date: "
                );

        String newTime =
                InputHandler.readText(
                        "Enter new time: "
                );

        boolean rescheduled =
                appointmentService.reschedule(
                        id,
                        newDate,
                        newTime
                );

        if (rescheduled) {

            System.out.println(
                    "Appointment rescheduled."
            );

        } else {

            System.out.println(
                    "Appointment not found."
            );
        }
    }


    public static void listAppointmentsByStatusHandler() {

        String status =
                InputHandler.readText(
                        "Enter status: "
                );

        Appointment[] appointments =
                appointmentService
                        .listByStatus(status);

        if (appointments.length == 0) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (Appointment appointment : appointments) {
            appointment.displayInfo();
        }
    }


    public static void listAppointmentsByPatientHandler() {

        String patientId =
                InputHandler.readText(
                        "Enter patient ID: "
                );

        Appointment[] appointments =
                appointmentService
                        .listByPatient(patientId);

        if (appointments.length == 0) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (Appointment appointment : appointments) {
            appointment.displayInfo();
        }
    }


    // =========================================================
    // MEDICAL RECORD MENU
    // =========================================================

    public static void recordMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n--- MEDICAL RECORD MENU ---"
            );

            System.out.println(
                    "1. View All Records"
            );

            System.out.println(
                    "2. Search Record By ID"
            );

            System.out.println(
                    "3. Remove Record"
            );

            System.out.println(
                    "4. List By Patient"
            );

            System.out.println(
                    "5. Count Confidential"
            );

            System.out.println(
                    "6. Back"
            );

            int choice = InputHandler.readInt(
                    "Choose option: ",
                    1,
                    6
            );

            switch (choice) {

                case 1:
                    viewRecordsHandler();
                    break;

                case 2:
                    searchRecordHandler();
                    break;

                case 3:
                    removeRecordHandler();
                    break;

                case 4:
                    listRecordsByPatientHandler();
                    break;

                case 5:
                    System.out.println(
                            "Confidential Records: "
                                    + recordService
                                    .countConfidential()
                    );
                    break;

                case 6:
                    back = true;
                    break;
            }
        }
    }


    public static void viewRecordsHandler() {

        Object[] records =
                recordService.getAll();

        if (records.length == 0) {

            System.out.println(
                    "No medical records found."
            );

            return;
        }

        for (Object obj : records) {

            MedicalRecord record =
                    (MedicalRecord) obj;

            record.displayInfo();
        }
    }


    public static void searchRecordHandler() {

        String id =
                InputHandler.readText(
                        "Enter record ID: "
                );

        MedicalRecord record =
                (MedicalRecord) recordService
                        .searchById(id);

        if (record == null) {

            System.out.println(
                    "Medical record not found."
            );

            return;
        }

        record.displayInfo();
    }


    public static void removeRecordHandler() {

        String id =
                InputHandler.readText(
                        "Enter record ID to remove: "
                );

        boolean removed =
                recordService.removeById(id);

        if (removed) {

            System.out.println(
                    "Medical record removed."
            );

        } else {

            System.out.println(
                    "Medical record not found."
            );
        }
    }


    public static void listRecordsByPatientHandler() {

        String patientId =
                InputHandler.readText(
                        "Enter patient ID: "
                );

        MedicalRecord[] records =
                recordService
                        .listByPatient(patientId);

        if (records.length == 0) {

            System.out.println(
                    "No records found for this patient."
            );

            return;
        }

        for (MedicalRecord record : records) {
            record.displayInfo();
        }
    }


    // =========================================================
    // REPORTS
    // =========================================================

    public static void reportsHandler() {

        Object[] patients =
                patientService.getAll();

        Object[] doctors =
                doctorService.getAll();

        Object[] nurses =
                nurseService.getAll();

        Object[] appointments =
                appointmentService.getAll();

        Object[] records =
                recordService.getAll();

        InPatient[] inPatients =
                patientService.listInPatients();


        System.out.println(
                "\n=============================="
        );

        System.out.println(
                "       HOSPITAL REPORTS"
        );

        System.out.println(
                "=============================="
        );

        System.out.println(
                "Total Patients: "
                        + patients.length
        );

        System.out.println(
                "Total InPatients: "
                        + inPatients.length
        );

        System.out.println(
                "Total Doctors: "
                        + doctors.length
        );

        System.out.println(
                "Total Nurses: "
                        + nurses.length
        );

        System.out.println(
                "Total Appointments: "
                        + appointments.length
        );

        System.out.println(
                "Total Medical Records: "
                        + records.length
        );

        System.out.println(
                "Confidential Records: "
                        + recordService
                        .countConfidential()
        );

        System.out.println(
                "Total Outstanding Balance: "
                        + patientService
                        .totalOutstanding()
        );

        System.out.println(
                "=============================="
        );
    }


    // =========================================================
    // TASK 2.9 - SAMPLE DATA
    // =========================================================

    public static void seedSampleData() {

        System.out.println(
                "\n--- SEEDING SAMPLE DATA ---"
        );


        // =====================================================
        // 6 PATIENTS
        // =====================================================

        patientService.addPatient(
                "P001",
                "Ahmed",
                "Ali",
                "91234567"
        );


        patientService.addPatient(
                "P002",
                "Sara",
                "Hassan",
                "92345678",
                "A+"
        );


        Patient patient3 =
                new Patient(
                        "P003",
                        "Mariam",
                        "Salim",
                        "10-03-1998",
                        "Female",
                        "93456789",
                        "mariam@email.com",
                        "Muscat",
                        "N003",
                        28,
                        true,
                        "O+",
                        "99881122",
                        "20-08-2026",
                        150.0,
                        true
                );

        patientService.addPatient(
                patient3
        );


        Patient patient4 =
                new Patient(
                        "P004",
                        "Khalid",
                        "Nasser",
                        "04-06-1988",
                        "Male",
                        "94567890",
                        "khalid@email.com",
                        "Sohar",
                        "N004",
                        38,
                        true,
                        "B+",
                        "99770011",
                        "20-08-2026",
                        220.0,
                        false
                );

        patientService.addPatient(
                patient4
        );


        InPatient inPatient1 =
                new InPatient(
                        "P005",
                        "Fatma",
                        "Ahmed",
                        "11-09-1990",
                        "Female",
                        "95678901",
                        "fatma@email.com",
                        "Nizwa",
                        "N005",
                        35,
                        true,
                        "AB+",
                        "99665544",
                        "20-08-2026",
                        400.0,
                        true,
                        "19-08-2026",
                        "R101",
                        50.0,
                        3
                );

        patientService.addPatient(
                inPatient1
        );


        InPatient inPatient2 =
                new InPatient(
                        "P006",
                        "Salim",
                        "Mohammed",
                        "01-01-1975",
                        "Male",
                        "96789012",
                        "salim@email.com",
                        "Salalah",
                        "N006",
                        51,
                        true,
                        "A-",
                        "99554433",
                        "20-08-2026",
                        300.0,
                        false,
                        "18-08-2026",
                        "R102",
                        65.0,
                        4
                );

        patientService.addPatient(
                inPatient2
        );


        // =====================================================
        // 4 DOCTORS
        // =====================================================

        Doctor doctor1 =
                new Doctor(
                        "D001",
                        "Omar",
                        "Salim",
                        "12-02-1980",
                        "Male",
                        "97890123",
                        "omar@email.com",
                        "Muscat",
                        "DN001",
                        46,
                        true,
                        "Cardiology",
                        15,
                        30.0,
                        true
                );


        Doctor doctor2 =
                new Doctor(
                        "D002",
                        "Ali",
                        "Hamed",
                        "08-05-1985",
                        "Male",
                        "98901234",
                        "ali@email.com",
                        "Muscat",
                        "DN002",
                        41,
                        true,
                        "Neurology",
                        11,
                        25.0,
                        true
                );


        Doctor doctor3 =
                new Doctor(
                        "D003",
                        "Aisha",
                        "Said",
                        "15-07-1990",
                        "Female",
                        "99012345",
                        "aisha@email.com",
                        "Sohar",
                        "DN003",
                        36,
                        true,
                        "Pediatrics",
                        8,
                        20.0,
                        false
                );


        Surgeon surgeon =
                new Surgeon(
                        "D004",
                        "Hassan",
                        "Ahmed",
                        "22-04-1978",
                        "Male",
                        "90123456",
                        "hassan@email.com",
                        "Muscat",
                        "DN004",
                        48,
                        true,
                        "Surgery",
                        20,
                        45.0,
                        true,
                        150,
                        true
                );


        doctorService.add(
                doctor1
        );

        doctorService.add(
                doctor2
        );

        doctorService.add(
                doctor3
        );

        doctorService.addSurgeon(
                surgeon
        );


        // =====================================================
        // 3 NURSES
        // =====================================================

        Nurse nurse1 =
                new Nurse(
                        "N001",
                        "Maryam",
                        "Said",
                        "12-12-1992",
                        "Female",
                        "91231234",
                        "maryam@email.com",
                        "Muscat",
                        "DEP01",
                        33,
                        true,
                        "WARD01",
                        "Morning",
                        8
                );


        Nurse nurse2 =
                new Nurse(
                        "N002",
                        "Noor",
                        "Ali",
                        "21-08-1994",
                        "Female",
                        "92342345",
                        "noor@email.com",
                        "Sohar",
                        "DEP02",
                        31,
                        true,
                        "WARD02",
                        "Evening",
                        6
                );


        Nurse nurse3 =
                new Nurse(
                        "N003",
                        "Ahmed",
                        "Hassan",
                        "09-11-1989",
                        "Male",
                        "93453456",
                        "ahmed.nurse@email.com",
                        "Nizwa",
                        "DEP03",
                        36,
                        true,
                        "WARD03",
                        "Night",
                        10
                );


        nurseService.add(
                nurse1
        );

        nurseService.add(
                nurse2
        );

        nurseService.add(
                nurse3
        );


        // =====================================================
        // 6 APPOINTMENTS
        // =====================================================

        appointmentService.schedule(
                "P001",
                "D001",
                "21-08-2026"
        );


        appointmentService.schedule(
                "P002",
                "D002",
                "21-08-2026",
                "10:30"
        );


        appointmentService.schedule(
                patient3,
                doctor3,
                "22-08-2026",
                "11:00",
                "Regular checkup"
        );


        appointmentService.schedule(
                "P004",
                "D001",
                "23-08-2026",
                "12:00"
        );


        appointmentService.schedule(
                "P005",
                "D004",
                "24-08-2026",
                "09:30"
        );


        appointmentService.schedule(
                "P006",
                "D003",
                "25-08-2026",
                "14:00"
        );


        // =====================================================
        // 5 MEDICAL RECORDS
        // =====================================================

        MedicalRecord record1 =
                new MedicalRecord(
                        "R001",
                        "P001",
                        "D001",
                        "20-08-2026",
                        "High blood pressure",
                        "Medication A",
                        "Monitor blood pressure",
                        false
                );


        MedicalRecord record2 =
                new MedicalRecord(
                        "R002",
                        "P002",
                        "D002",
                        "20-08-2026",
                        "Migraine",
                        "Medication B",
                        "Follow up after two weeks",
                        true
                );


        MedicalRecord record3 =
                new MedicalRecord(
                        "R003",
                        "P003",
                        "D003",
                        "20-08-2026",
                        "Flu",
                        "Medication C",
                        "Rest and drink water",
                        false
                );


        MedicalRecord record4 =
                new MedicalRecord(
                        "R004",
                        "P005",
                        "D004",
                        "20-08-2026",
                        "Surgery review",
                        "Medication D",
                        "Prepare for surgery",
                        true
                );


        MedicalRecord record5 =
                new MedicalRecord(
                        "R005",
                        "P006",
                        "D001",
                        "20-08-2026",
                        "Chest pain",
                        "Medication E",
                        "Further tests required",
                        true
                );


        recordService.add(
                record1
        );

        recordService.add(
                record2
        );

        recordService.add(
                record3
        );

        recordService.add(
                record4
        );

        recordService.add(
                record5
        );


        // Extra Sample Operations

        doctorService.assignPatient(
                "D001",
                "P001"
        );

        doctor1.addSlot(
                "09:00"
        );

        doctor1.addSlot(
                "10:00"
        );

        nurse1.assignPatient(
                "P001"
        );

        nurse2.assignPatient(
                "P002"
        );

        surgeon.scheduleSurgery(
                "28-08-2026"
        );


        System.out.println(
                "Sample data seeded successfully."
        );
    }


    // =========================================================
    // TASK 2.9 - TESTS
    // =========================================================

    public static void runTask29Tests() {

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "       TASK 2.9 TESTS"
        );

        System.out.println(
                "================================"
        );


        // Data Counts

        System.out.println(
                "Patients: "
                        + patientService
                        .getAll().length
        );

        System.out.println(
                "InPatients: "
                        + patientService
                        .listInPatients().length
        );

        System.out.println(
                "Doctors: "
                        + doctorService
                        .getAll().length
        );

        System.out.println(
                "Nurses: "
                        + nurseService
                        .getAll().length
        );

        System.out.println(
                "Appointments: "
                        + appointmentService
                        .getAll().length
        );

        System.out.println(
                "Medical Records: "
                        + recordService
                        .getAll().length
        );


        // =====================================================
        // Patient updateContact overloads
        // =====================================================

        Patient testPatient =
                (Patient) patientService
                        .searchById("P003");

        if (testPatient != null) {

            testPatient.updateContact(
                    "91112222"
            );

            testPatient.updateContact(
                    "92223333",
                    "updated@email.com"
            );
        }


        // =====================================================
        // Doctor updateFee overloads
        // =====================================================

        Doctor testDoctor =
                (Doctor) doctorService
                        .searchById("D001");

        if (testDoctor != null) {

            testDoctor.updateFee(
                    35.0
            );

            testDoctor.updateFee(
                    40.0,
                    "Annual fee review"
            );
        }


        // =====================================================
        // Appointment addNotes overloads
        // =====================================================

        Appointment testAppointment =
                (Appointment) appointmentService
                        .searchById("A1");

        if (testAppointment != null) {

            testAppointment.addNotes(
                    "Bring previous reports"
            );

            testAppointment.addNotes(
                    "Patient arrived early",
                    "Reception"
            );
        }


        // =====================================================
        // HelperUtils overloads
        // =====================================================

        System.out.println(
                "generateId(): "
                        + HelperUtils
                        .generateId()
        );


        System.out.println(
                "generateId(prefix): "
                        + HelperUtils
                        .generateId("TEST-")
        );


        System.out.println(
                "isEmpty text: "
                        + HelperUtils
                        .isEmpty("")
        );


        Object[] emptyArray =
                new Object[2];


        System.out.println(
                "isEmpty array: "
                        + HelperUtils
                        .isEmpty(emptyArray)
        );


        System.out.println(
                "validText: "
                        + HelperUtils
                        .isValidText("Hospital")
        );


        System.out.println(
                "validText min: "
                        + HelperUtils
                        .isValidText(
                                "Hospital",
                                3
                        )
        );


        System.out.println(
                "validText min/max: "
                        + HelperUtils
                        .isValidText(
                                "Hospital",
                                3,
                                20
                        )
        );


        System.out.println(
                "positive int: "
                        + HelperUtils
                        .isPositive(5)
        );


        System.out.println(
                "positive double: "
                        + HelperUtils
                        .isPositive(5.5)
        );


        System.out.println(
                "range int: "
                        + HelperUtils
                        .isInRange(
                                5,
                                1,
                                10
                        )
        );


        System.out.println(
                "range double: "
                        + HelperUtils
                        .isInRange(
                                5.5,
                                1.0,
                                10.0
                        )
        );


        // =====================================================
        // Polymorphism
        // =====================================================

        Person basePerson =
                new Person(
                        "BASE01",
                        "Test",
                        "Person",
                        "01-01-1990",
                        "Male",
                        "90000000",
                        "base@email.com",
                        "Muscat",
                        "BASE-NID",
                        36,
                        true
                );


        Patient regularPatient =
                (Patient) patientService
                        .searchById("P001");


        InPatient inpatient =
                patientService
                        .listInPatients()[0];


        Doctor doctor =
                (Doctor) doctorService
                        .searchById("D001");


        Surgeon surgeon = null;


        Object[] allDoctors =
                doctorService.getAll();


        for (Object obj : allDoctors) {

            if (obj instanceof Surgeon) {

                surgeon =
                        (Surgeon) obj;

                break;
            }
        }


        Nurse nurse =
                (Nurse) nurseService
                        .searchById("N001");


        Person[] people =
                new Person[6];


        people[0] = basePerson;
        people[1] = regularPatient;
        people[2] = doctor;
        people[3] = nurse;
        people[4] = inpatient;
        people[5] = surgeon;


        System.out.println(
                "\n--- POLYMORPHISM TEST ---"
        );


        printAll(
                people
        );


        countByType(
                people
        );


        Person oldest =
                findOldest(
                        people
                );


        if (oldest != null) {

            System.out.println(
                    "\nOldest Person:"
            );

            oldest.displayInfo();
        }


        // =====================================================
        // Validation Tests
        // =====================================================

        System.out.println(
                "\n--- VALIDATION TEST ---"
        );


        Person validationPerson =
                new Person(
                        "TEST001",
                        "Valid",
                        "Person",
                        "01-01-2000",
                        "Male",
                        "91111111",
                        "valid@email.com",
                        "Muscat",
                        "VALID001",
                        26,
                        true
                );


        // Empty ID
        validationPerson.setId(
                ""
        );


        // Invalid age
        validationPerson.setAge(
                150
        );


        // Negative money
        Patient validationPatient =
                new Patient(
                        "TEST002",
                        "Test",
                        "Patient",
                        "01-01-2000",
                        "Female",
                        "92222222",
                        "patient@email.com",
                        "Muscat",
                        "VALID002",
                        26,
                        true,
                        "A+",
                        "99999999",
                        "20-08-2026",
                        100,
                        true
                );


        validationPatient
                .setOutstandingBalance(
                        -100
                );


        // Bad shift
        Nurse validationNurse =
                new Nurse(
                        "TESTN",
                        "Test",
                        "Nurse",
                        "01-01-1990",
                        "Female",
                        "93333333",
                        "nurse@email.com",
                        "Muscat",
                        "VALID003",
                        36,
                        true,
                        "DEP",
                        "Morning",
                        5
                );


        validationNurse.setShift(
                "InvalidShift"
        );


        // Bad appointment status
        Appointment validationAppointment =
                new Appointment(
                        "TESTA",
                        "P001",
                        "D001",
                        "20-08-2026",
                        "10:00",
                        "Scheduled",
                        "Test",
                        false
                );


        validationAppointment
                .setStatus(
                        "WrongStatus"
                );


        System.out.println(
                "\nTask 2.9 automated checks finished."
        );


        System.out.println(
                "================================"
        );
    }


    // =========================================================
    // POLYMORPHISM HELPERS
    // =========================================================

    public static void printAll(
            Person[] people) {

        for (Person person : people) {

            if (person != null) {
                person.displayInfo();
            }
        }
    }


    public static void countByType(
            Person[] people) {

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
                "Person: "
                        + personCount
        );


        System.out.println(
                "Patient: "
                        + patientCount
        );


        System.out.println(
                "Doctor: "
                        + doctorCount
        );


        System.out.println(
                "Nurse: "
                        + nurseCount
        );


        System.out.println(
                "InPatient: "
                        + inPatientCount
        );


        System.out.println(
                "Surgeon: "
                        + surgeonCount
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
}