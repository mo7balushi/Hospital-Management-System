package entities;

import interfaces.Displayable;
import utils.HelperUtils;

public class Person implements Displayable {

    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String nationalId;
    private int age;
    private boolean active;


    // Constructors ______________________________________________

    public Person(
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
            boolean active) {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAddress(address);
        setNationalId(nationalId);
        setAge(age);
        setActive(active);
    }


    // Overloaded Constructor

    public Person(
            String id,
            String firstName,
            String lastName) {

        this(
                id,
                firstName,
                lastName,
                "N/A",
                "Unknown",
                "00000000",
                "unknown@hospital.com",
                "N/A",
                "N/A",
                0,
                true
        );
    }


    // Setters _________________________________________________

    public void setId(String id) {

        if (!HelperUtils.isValidText(id)) {
            System.out.println("ID cannot be empty.");
            return;
        }

        this.id = id;
    }


    public void setFirstName(String firstName) {

        if (!HelperUtils.isValidText(firstName)) {
            System.out.println("First name cannot be empty.");
            return;
        }

        this.firstName = firstName;
    }


    public void setLastName(String lastName) {

        if (!HelperUtils.isValidText(lastName)) {
            System.out.println("Last name cannot be empty.");
            return;
        }

        this.lastName = lastName;
    }


    public void setDateOfBirth(String dateOfBirth) {

        if (!HelperUtils.isValidText(dateOfBirth)) {
            System.out.println("Date of birth cannot be empty.");
            return;
        }

        this.dateOfBirth = dateOfBirth;
    }


    public void setGender(String gender) {

        if (!HelperUtils.isValidText(gender)) {
            System.out.println("Gender cannot be empty.");
            return;
        }

        this.gender = gender;
    }


    public void setPhoneNumber(String phoneNumber) {

        if (!HelperUtils.isValidPhone(phoneNumber)) {
            System.out.println("Invalid phone number.");
            return;
        }

        this.phoneNumber = phoneNumber;
    }


    public void setEmail(String email) {

        if (!HelperUtils.isValidText(email)) {
            System.out.println("Email cannot be empty.");
            return;
        }

        if (!email.contains("@")) {
            System.out.println("Invalid email.");
            return;
        }

        this.email = email;
    }


    public void setAddress(String address) {

        if (!HelperUtils.isValidText(address)) {
            System.out.println("Address cannot be empty.");
            return;
        }

        this.address = address;
    }


    public void setNationalId(String nationalId) {

        if (!HelperUtils.isValidText(nationalId)) {
            System.out.println("National ID cannot be empty.");
            return;
        }

        this.nationalId = nationalId;
    }


    public void setAge(int age) {

        if (!HelperUtils.isValidAge(age)) {
            System.out.println("Age must be between 0 and 120.");
            return;
        }

        this.age = age;
    }


    public void setActive(boolean active) {
        this.active = active;
    }


    // Getters _________________________________________________

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNationalId() {
        return nationalId;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }


    // Functions _______________________________________________

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }


    public boolean isAdult() {
        return getAge() >= 18;
    }


    @Override
    public void displayInfo() {

        System.out.println(
                "ID: " + getId() +
                        ", Name: " + getFullName() +
                        ", Age: " + getAge() +
                        ", Phone: " + getPhoneNumber() +
                        ", Email: " + getEmail()
        );
    }


    @Override
    public String displaySummary() {
        return getId() + " - " + getFullName();
    }


    @Override
    public String toString() {

        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + getFullName() + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;

        return id != null && id.equals(other.id);
    }
}