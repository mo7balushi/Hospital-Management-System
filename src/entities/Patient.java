package entities;

public class Patient extends Person {

    private String bloodType;
    private String insuranceNumber;
    private String emergencyContact;
    private boolean admitted;


    // Constructor ______________________________________________

    public Patient(
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
            String bloodType,
            String insuranceNumber,
            String emergencyContact,
            boolean admitted) {

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

        setBloodType(bloodType);
        setInsuranceNumber(insuranceNumber);
        setEmergencyContact(emergencyContact);
        setAdmitted(admitted);
    }


    // Setters _________________________________________________

    public void setBloodType(String bloodType) {
        if (bloodType == null || bloodType.trim().isEmpty()) {
            System.out.println("Blood type cannot be empty.");
            return;
        }

        this.bloodType = bloodType;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        if (insuranceNumber == null || insuranceNumber.trim().isEmpty()) {
            System.out.println("Insurance number cannot be empty.");
            return;
        }

        this.insuranceNumber = insuranceNumber;
    }

    public void setEmergencyContact(String emergencyContact) {
        if (emergencyContact == null || emergencyContact.trim().isEmpty()) {
            System.out.println("Emergency contact cannot be empty.");
            return;
        }

        this.emergencyContact = emergencyContact;
    }

    public void setAdmitted(boolean admitted) {
        this.admitted = admitted;
    }


    // Getters _________________________________________________

    public String getBloodType() {
        return bloodType;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public boolean isAdmitted() {
        return admitted;
    }


    // Overriding ______________________________________________

    @Override
    public void displayInfo() {
        System.out.println(
                "Patient: " + getFullName() +
                        ", ID: " + getId() +
                        ", Blood Type: " + getBloodType() +
                        ", Insurance: " + getInsuranceNumber() +
                        ", Emergency Contact: " + getEmergencyContact() +
                        ", Admitted: " + isAdmitted()
        );
    }
}