package services;

import entities.Appointment;
import entities.Doctor;
import entities.Patient;

public class AppointmentService {

    private Appointment[] appointments = new Appointment[100];
    private int appointmentCount = 0;


    // Schedule 1: IDs + date
    public void schedule(
            String patientId,
            String doctorId,
            String date) {

        Appointment appointment = new Appointment(
                "A" + (appointmentCount + 1),
                patientId,
                doctorId,
                date,
                "09:00",
                "Scheduled",
                "General",
                false
        );

        addAppointment(appointment);
    }


    // Schedule 2: IDs + date + time
    public void schedule(
            String patientId,
            String doctorId,
            String date,
            String time) {

        Appointment appointment = new Appointment(
                "A" + (appointmentCount + 1),
                patientId,
                doctorId,
                date,
                time,
                "Scheduled",
                "General",
                false
        );

        addAppointment(appointment);
    }


    // Schedule 3: full objects + reason
    public void schedule(
            Patient patient,
            Doctor doctor,
            String date,
            String time,
            String reason) {

        if (patient == null || doctor == null) {
            System.out.println("Patient and Doctor cannot be null.");
            return;
        }

        Appointment appointment = new Appointment(
                "A" + (appointmentCount + 1),
                patient.getId(),
                doctor.getId(),
                date,
                time,
                "Scheduled",
                reason,
                false
        );

        addAppointment(appointment);
    }


    // Add Appointment
    private void addAppointment(Appointment appointment) {

        if (appointmentCount >= appointments.length) {
            System.out.println("Appointment storage is full.");
            return;
        }

        appointments[appointmentCount] = appointment;
        appointmentCount++;
    }


    public int getAppointmentCount() {
        return appointmentCount;
    }
}