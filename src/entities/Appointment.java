package entities;

public class Appointment {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private boolean followUp;


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
        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            System.out.println("Appointment ID cannot be empty.");
            return;
        }

        this.appointmentId = appointmentId;
    }

    public void setPatientId(String patientId) {
        if (patientId == null || patientId.trim().isEmpty()) {
            System.out.println("Patient ID cannot be empty.");
            return;
        }

        this.patientId = patientId;
    }

    public void setDoctorId(String doctorId) {
        if (doctorId == null || doctorId.trim().isEmpty()) {
            System.out.println("Doctor ID cannot be empty.");
            return;
        }

        this.doctorId = doctorId;
    }

    public void setAppointmentDate(String appointmentDate) {
        if (appointmentDate == null || appointmentDate.trim().isEmpty()) {
            System.out.println("Appointment date cannot be empty.");
            return;
        }

        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(String appointmentTime) {
        if (appointmentTime == null || appointmentTime.trim().isEmpty()) {
            System.out.println("Appointment time cannot be empty.");
            return;
        }

        this.appointmentTime = appointmentTime;
    }

    public void setStatus(String status) {

        if (status == null ||
                (!status.equalsIgnoreCase("Scheduled")
                        && !status.equalsIgnoreCase("Cancelled")
                        && !status.equalsIgnoreCase("Completed")
                        && !status.equalsIgnoreCase("Rescheduled"))) {

            System.out.println("Invalid appointment status.");
            return;
        }

        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }


    // Getters _________________________________________________

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
        return appointmentDate.compareTo(currentDate) < 0;
    }


    // Display _________________________________________________

    public void displayInfo() {
//
        System.out.println(
                "Appointment ID: " + getAppointmentId() +
                        ", Patient ID: " + getPatientId() +
                        ", Doctor ID: " + getDoctorId() +
                        ", Date: " + getAppointmentDate() +
                        ", Time: " + getAppointmentTime() +
                        ", Status: " + getStatus() +
                        ", Reason: " + getReason() +
                        ", Follow Up: " + isFollowUp()
        );
    }
}