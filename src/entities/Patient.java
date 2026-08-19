package entities;

public class Patient extends Person {

    private String bloodGroup;
    private String emergencyContact;
    private String registrationDate;

    private String[] allergies;
    private String[] recordIds;

    private int allergyCount;
    private int recordCount;

    private double outstandingBalance;
    private boolean insured;


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
            String bloodGroup,
            String emergencyContact,
            String registrationDate,
            double outstandingBalance,
            boolean insured) {

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

        setBloodGroup(bloodGroup);
        setEmergencyContact(emergencyContact);
        setRegistrationDate(registrationDate);
        setOutstandingBalance(outstandingBalance);
        setInsured(insured);

        allergies = new String[20];
        recordIds = new String[50];

        allergyCount = 0;
        recordCount = 0;
    }


    // Setters _________________________________________________

    public void setBloodGroup(String bloodGroup) {

        if (bloodGroup == null || bloodGroup.trim().isEmpty()) {
            System.out.println("Blood group cannot be empty.");
            return;
        }

        this.bloodGroup = bloodGroup;
    }


    public void setEmergencyContact(String emergencyContact) {

        if (emergencyContact == null || emergencyContact.trim().isEmpty()) {
            System.out.println("Emergency contact cannot be empty.");
            return;
        }

        this.emergencyContact = emergencyContact;
    }


    public void setRegistrationDate(String registrationDate) {

        if (registrationDate == null || registrationDate.trim().isEmpty()) {
            System.out.println("Registration date cannot be empty.");
            return;
        }

        this.registrationDate = registrationDate;
    }


    public void setOutstandingBalance(double outstandingBalance) {

        if (outstandingBalance < 0) {
            System.out.println("Outstanding balance cannot be negative.");
            return;
        }

        this.outstandingBalance = outstandingBalance;
    }


    public void setInsured(boolean insured) {
        this.insured = insured;
    }


    // Getters _________________________________________________

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public boolean isInsured() {
        return insured;
    }

    public int getAllergyCount() {
        return allergyCount;
    }

    public int getRecordCount() {
        return recordCount;
    }


    // Allergy Methods __________________________________________

    public void addAllergy(String allergy) {

        if (allergy == null || allergy.trim().isEmpty()) {
            System.out.println("Allergy cannot be empty.");
            return;
        }

        if (hasAllergy(allergy)) {
            System.out.println("Allergy already exists.");
            return;
        }

        if (allergyCount >= allergies.length) {
            System.out.println("Allergy list is full.");
            return;
        }

        allergies[allergyCount] = allergy;
        allergyCount++;
    }


    public boolean hasAllergy(String allergy) {

        for (int i = 0; i < allergyCount; i++) {

            if (allergies[i].equalsIgnoreCase(allergy)) {
                return true;
            }
        }

        return false;
    }


    public void listAllergies() {

        if (allergyCount == 0) {
            System.out.println("No allergies.");
            return;
        }

        for (int i = 0; i < allergyCount; i++) {
            System.out.println(allergies[i]);
        }
    }


    // Medical Record Methods ___________________________________

    public void addRecordId(String recordId) {

        if (recordId == null || recordId.trim().isEmpty()) {
            System.out.println("Record ID cannot be empty.");
            return;
        }

        if (recordCount >= recordIds.length) {
            System.out.println("Record list is full.");
            return;
        }

        recordIds[recordCount] = recordId;
        recordCount++;
    }


    // Balance Methods __________________________________________

    public void addToBalance(double amount) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        outstandingBalance += amount;
    }


    public void clearBalance() {
        outstandingBalance = 0;
    }


    // Overriding _______________________________________________

    @Override
    public void displayInfo() {

        System.out.println(
                "Patient: " + getFullName() +
                        ", ID: " + getId() +
                        ", Blood Group: " + getBloodGroup() +
                        ", Emergency Contact: " + getEmergencyContact() +
                        ", Registration Date: " + getRegistrationDate() +
                        ", Outstanding Balance: " + getOutstandingBalance() +
                        ", Insured: " + isInsured()
        );
    }
}//