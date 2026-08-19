package entities;

public class Doctor extends Person {

    private String specialization;
    private int experienceYears;
    private double consultationFee;

    private String[] availableSlots;
    private String[] assignedPatientIds;

    private int slotCount;
    private int patientCount;

    private boolean onCall;


    // Constructor ______________________________________________

    public Doctor(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String nationalId,
            int age,
            boolean active,
            String specialization,
            int experienceYears,
            double consultationFee,
            boolean onCall) {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                nationalId,
                age,
                active
        );
    }






}
