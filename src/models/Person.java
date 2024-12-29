package models;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int yearsOld;
    private boolean isMale; // true = Male, false = Female

    public Person(String firstName, String lastName, int yearsOld, boolean isMale) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOld = yearsOld;
        this.isMale = isMale;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getYearsOld() { return yearsOld; }
    public boolean isMale() { return isMale; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setYearsOld(int yearsOld) { this.yearsOld = yearsOld; }
    public void setGender(boolean isMale) { this.isMale = isMale; }

    @Override
    public String toString() {
        String genderRepresentation = isMale ? "Male" : "Female";
        return "Hello, I am " + firstName + " " + lastName + ", a " + yearsOld + "-year-old " + genderRepresentation + ".";
    }
}
