package entities;

public class Surgeon extends Doctor {

    private int surgeriesPerformed;
    private boolean operationTheatreAccess;

    private String[] upcomingSurgeryDates;
    private int upcomingCount;


    // Constructor ______________________________________________

    public Surgeon(
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
            boolean onCall,
            int surgeriesPerformed,
            boolean operationTheatreAccess) {

        // Person -> Doctor -> Surgeon
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
                specialization,
                experienceYears,
                consultationFee,
                onCall
        );

        setSurgeriesPerformed(surgeriesPerformed);
        setOperationTheatreAccess(operationTheatreAccess);

        upcomingSurgeryDates = new String[30];
        upcomingCount = 0;
    }


    // Setters _________________________________________________

    public void setSurgeriesPerformed(int surgeriesPerformed) {

        if (surgeriesPerformed < 0) {
            System.out.println("Surgeries performed cannot be negative.");
            return;
        }

        this.surgeriesPerformed = surgeriesPerformed;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }


    // Getters _________________________________________________

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public boolean hasOperationTheatreAccess() {
        return operationTheatreAccess;
    }


    // Surgery Methods __________________________________________

    public void performSurgery() {

        if (!operationTheatreAccess) {
            System.out.println("Surgeon does not have operation theatre access.");
            return;
        }

        surgeriesPerformed++;
    }


    public void scheduleSurgery(String surgeryDate) {

        if (surgeryDate == null || surgeryDate.trim().isEmpty()) {
            System.out.println("Surgery date cannot be empty.");
            return;
        }

        if (upcomingCount >= upcomingSurgeryDates.length) {
            System.out.println("Upcoming surgery list is full.");
            return;
        }

        upcomingSurgeryDates[upcomingCount] = surgeryDate;
        upcomingCount++;
    }


    public int getUpcomingCount() {
        return upcomingCount;
    }


    // Overriding _______________________________________________

    @Override
    public void displayInfo() {

        System.out.println(
                "Surgeon: " + getFullName() +
                        ", ID: " + getId() +
                        ", Specialization: " + getSpecialization() +
                        ", Surgeries Performed: " + getSurgeriesPerformed() +
                        ", Theatre Access: " + hasOperationTheatreAccess() +
                        ", Upcoming Surgeries: " + getUpcomingCount()
        );
    }
}//