package models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int counter = 1;
    private int studentIdentifier;
    private List<Integer> marks;

    public Student(String firstName, String lastName, int age, boolean gender) {
        super(firstName, lastName, age, gender);
        this.studentIdentifier = counter++;
        this.marks = new ArrayList<>();
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public double computeGPA() {
        ArrayList<Double> marksGpa = new ArrayList<>();
        for (int i = 0; i < marks.size(); i++) {
            marksGpa.add((marks.get(i) >= 60) ? Math.max(0, Math.min(4.0, 4.0 - 3.0 * (100 - marks.get(i)) / 40.0)) : 0.0);
        }

        if (marksGpa.isEmpty()) return 0.0;
        int total = 0;
        for (double mark : marksGpa) {
            total += mark;
        }
        return total / (double) marks.size();
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentIdentifier + ".";
    }
}
