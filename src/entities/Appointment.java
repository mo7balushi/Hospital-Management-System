package entities;

import interfaces.Displayable;
import utils.HelperUtils;

public class Appointment implements Displayable {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private boolean followUp;
    private String notes;


    // Constructor ______________________________________________

    public Appointment(
            String appointmentId,
            String patientId,
            String doctorId,
            String appointmentDate,
            String appointmentTime,
            String status,
            String reason,
            boolean followUp) {

        setAppointmentId(appointmentId);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setAppointmentDate(appointmentDate);
        setAppointmentTime(appointmentTime);
        setStatus(status);
        setReason(reason);
        setFollowUp(followUp);
    }


    // Setters _________________________________________________

    public void setAppointmentId(String appointmentId) {

        if (!HelperUtils.isValidText(appointmentId)) {
            System.out.println("Appointment ID cannot be empty.");
            return;
        }

        this.appointmentId = appointmentId;
    }


    public void setPatientId(String patientId) {

        if (!HelperUtils.isValidText(patientId)) {
            System.out.println("Patient ID cannot be empty.");
            return;
        }

        this.patientId = patientId;
    }


    public void setDoctorId(String doctorId) {

        if (!HelperUtils.isValidText(doctorId)) {
            System.out.println("Doctor ID cannot be empty.");
            return;
        }

        this.doctorId = doctorId;
    }


    public void setAppointmentDate(String appointmentDate) {

        if (!HelperUtils.isValidText(appointmentDate)) {
            System.out.println("Appointment date cannot be empty.");
            return;
        }

        this.appointmentDate = appointmentDate;
    }


    public void setAppointmentTime(String appointmentTime) {

        if (!HelperUtils.isValidText(appointmentTime)) {
            System.out.println("Appointment time cannot be empty.");
            return;
        }

        this.appointmentTime = appointmentTime;
    }


    public void setStatus(String status) {

        String[] allowedStatuses = {
                "Scheduled",
                "Cancelled",
                "Completed",
                "Rescheduled"
        };

        if (!HelperUtils.isOneOf(status, allowedStatuses)) {
            System.out.println("Invalid appointment status.");
            return;
        }

        this.status = status;
    }


    public void setReason(String reason) {

        if (!HelperUtils.isValidText(reason)) {
            System.out.println("Reason cannot be empty.");
            return;
        }

        this.reason = reason;
    }


    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    // Getters __________________________________===============

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public boolean isFollowUp() {
        return followUp;
    }

    public String getNotes() {
        return notes;
    }


    // Status Methods ___________________________________________

    public void cancel() {
        setStatus("Cancelled");
    }


    public void complete() {
        setStatus("Completed");
    }


    // Reschedule _______________________________________________

    public void reschedule(
            String newDate,
            String newTime) {

        setAppointmentDate(newDate);
        setAppointmentTime(newTime);
        setStatus("Rescheduled");
    }


    // Compare Date _____________________________________________

    public boolean isPast(String currentDate) {

        if (!HelperUtils.isValidText(currentDate)) {
            return false;
        }

        return appointmentDate.compareTo(currentDate) < 0;
    }


    // Notes Overloading - Task 2.2 _____________________________

    public void addNotes(String notes) {

        if (!HelperUtils.isValidText(notes)) {
            System.out.println("Notes cannot be empty.");
            return;
        }

        setNotes(notes);
    }


    public void addNotes(
            String notes,
            String author) {

        if (!HelperUtils.isValidText(notes)
                || !HelperUtils.isValidText(author)) {

            System.out.println(
                    "Notes and author cannot be empty."
            );
            return;
        }

        setNotes(author + ": " + notes);
    }


    // Display __________________________________===============

    @Override
    public void displayInfo() {

        System.out.println(
                "Appointment ID: " + getAppointmentId() +
                        ", Patient ID: " + getPatientId() +
                        ", Doctor ID: " + getDoctorId() +
                        ", Date: " + getAppointmentDate() +
                        ", Time: " + getAppointmentTime() +
                        ", Status: " + getStatus() +
                        ", Reason: " + getReason() +
                        ", Follow Up: " + isFollowUp() +
                        ", Notes: " + getNotes()
        );
    }


    @Override
    public String displaySummary() {

        return getAppointmentId()
                + " - "
                + getPatientId()
                + " with "
                + getDoctorId()
                + " - "
                + getStatus();
    }
}