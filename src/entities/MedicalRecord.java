package entities;
import interfaces.Displayable;

public class MedicalRecord implements Displayable {

    private String recordId;
    private String patientId;
    private String doctorId;
    private String visitDate;
    private String diagnosis;
    private String prescription;
    private String notes;
    private boolean confidential;


    // Constructor ______________________________________________

    public MedicalRecord(
            String recordId,
            String patientId,
            String doctorId,
            String visitDate,
            String diagnosis,
            String prescription,
            String notes,
            boolean confidential) {

        setRecordId(recordId);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setVisitDate(visitDate);
        setDiagnosis(diagnosis);
        setPrescription(prescription);
        setNotes(notes);
        setConfidential(confidential);
    }


    // Setters _________________________________________________

    public void setRecordId(String recordId) {

        if (recordId == null || recordId.trim().isEmpty()) {
            System.out.println("Record ID cannot be empty.");
            return;
        }

        this.recordId = recordId;
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


    public void setVisitDate(String visitDate) {

        if (visitDate == null || visitDate.trim().isEmpty()) {
            System.out.println("Visit date cannot be empty.");
            return;
        }

        this.visitDate = visitDate;
    }


    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }


    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    public void setConfidential(boolean confidential) {
        this.confidential = confidential;
    }


    // Getters _________________________________________________

    public String getRecordId() {
        return recordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isConfidential() {
        return confidential;
    }


    // Append Note ______________________________________________

    public void appendNote(String extraNote) {

        if (extraNote == null || extraNote.trim().isEmpty()) {
            System.out.println("Note cannot be empty.");
            return;
        }

        if (notes == null || notes.trim().isEmpty()) {
            notes = extraNote;
        } else {
            notes = notes + " | " + extraNote;
        }
    }


    // Confidential _____________________________________________

    public void markConfidential() {
        confidential = true;
    }


    // Display _________________________________________________
    @Override
    public void displayInfo() {

        System.out.println(
                "Record ID: " + getRecordId() +
                        ", Patient ID: " + getPatientId() +
                        ", Doctor ID: " + getDoctorId() +
                        ", Visit Date: " + getVisitDate() +
                        ", Diagnosis: " + getDiagnosis() +
                        ", Prescription: " + getPrescription() +
                        ", Notes: " + getNotes() +
                        ", Confidential: " + isConfidential()
        );
    }

    @Override
    public String displaySummary() {
        return getRecordId()
                + " - Patient: "
                + getPatientId();
    }
}//?