package entities;

public class InPatient extends Patient {

    private String admissionDate;
    private String roomNumber;
    private double dailyCharges;
    private int daysAdmitted;


    // Constructor ______________________________________________

    public InPatient(
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
            boolean insured,
            String admissionDate,
            String roomNumber,
            double dailyCharges,
            int daysAdmitted) {

        // Person -> Patient -> InPatient
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
                active,
                bloodGroup,
                emergencyContact,
                registrationDate,
                outstandingBalance,
                insured
        );

        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);
    }


    // Setters _________________________________________________

    public void setAdmissionDate(String admissionDate) {
        if (admissionDate == null || admissionDate.trim().isEmpty()) {
            System.out.println("Admission date cannot be empty.");
            return;
        }

        this.admissionDate = admissionDate;
    }

    public void setRoomNumber(String roomNumber) {
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            System.out.println("Room number cannot be empty.");
            return;
        }

        this.roomNumber = roomNumber;
    }

    public void setDailyCharges(double dailyCharges) {
        if (dailyCharges < 0) {
            System.out.println("Daily charges cannot be negative.");
            return;
        }

        this.dailyCharges = dailyCharges;
    }

    public void setDaysAdmitted(int daysAdmitted) {
        if (daysAdmitted < 0) {
            System.out.println("Days admitted cannot be negative.");
            return;
        }

        this.daysAdmitted = daysAdmitted;
    }


    // Getters _________________________________________________

    public String getAdmissionDate() {
        return admissionDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }


    // Admit _________________________________________________

    public void admit(
            String admissionDate,
            String roomNumber,
            int daysAdmitted) {

        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setDaysAdmitted(daysAdmitted);
    }


    // Discharge _______________________________________________

    public void discharge() {
        admissionDate = null;
        roomNumber = null;
        daysAdmitted = 0;
    }


    // Total Room Cost _________________________________________

    public double totalRoomCost() {
        return dailyCharges * daysAdmitted;
    }


    // Overriding ______________________________________________

    @Override
    public void displayInfo() {
        System.out.println(
                "InPatient: " + getFullName() +
                        ", ID: " + getId() +
                        ", Blood Group: " + getBloodGroup() +
                        ", Admission Date: " + getAdmissionDate() +
                        ", Room Number: " + getRoomNumber() +
                        ", Daily Charges: " + getDailyCharges() +
                        ", Days Admitted: " + getDaysAdmitted() +
                        ", Total Room Cost: " + totalRoomCost()
        );
    }
}//