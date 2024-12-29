package models;

public class Teacher extends Person {
    private String taughtSubject;
    private int experienceYears;
    private int compensation;

    public Teacher(String firstName, String lastName, int age, boolean gender, String taughtSubject, int experienceYears, int compensation) {
        super(firstName, lastName, age, gender);
        this.taughtSubject = taughtSubject;
        this.experienceYears = experienceYears;
        this.compensation = compensation;
    }

    public String getTaughtSubject() { return taughtSubject; }
    public int getExperienceYears() { return experienceYears; }
    public int getCompensation() { return compensation; }

    public void applyRaise(double percentage) {
        compensation += compensation * (percentage / 100);
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + taughtSubject + ".";
    }
}
