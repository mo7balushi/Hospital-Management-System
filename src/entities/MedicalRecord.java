package entities;

import interfaces.Displayable;
import utils.HelperUtils;

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

        if (!HelperUtils.isValidText(recordId)) {
            System.out.println("Record ID cannot be empty.");
            return;
        }

        this.recordId = recordId;
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


    public void setVisitDate(String visitDate) {

        if (!HelperUtils.isValidText(visitDate)) {
            System.out.println("Visit date cannot be empty.");
            return;
        }

        this.visitDate = visitDate;
    }


    public void setDiagnosis(String diagnosis) {

        if (!HelperUtils.isValidText(diagnosis)) {
            System.out.println("Diagnosis cannot be empty.");
            return;
        }

        this.diagnosis = diagnosis;
    }


    public void setPrescription(String prescription) {

        if (!HelperUtils.isValidText(prescription)) {
            System.out.println("Prescription cannot be empty.");
            return;
        }

        this.prescription = prescription;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    public void setConfidential(boolean confidential) {
        this.confidential = confidential;
    }


    // Getters __________________________________===============

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

        if (!HelperUtils.isValidText(extraNote)) {
            System.out.println("Note cannot be empty.");
            return;
        }

        if (!HelperUtils.isValidText(notes)) {
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
}