import models.School;
import models.Student;
import models.Teacher;
import models.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        // Reading and adding students to the school
        readAndAddStudents(school, "src/models/Students.txt");

        // Reading and adding teachers to the school
        readAndAddTeachers(school, "src/models/Teachers.txt");

        // Displaying the details of all members in the school
        System.out.println(school);

        System.out.println();

        // Display GPA for students and salary for teachers after the raise
        displayMemberDetails(school);
    }

    // Method to read students from a file and add to the school
    private static void readAndAddStudents(School school, String filePath) throws FileNotFoundException {
        File studentFile = new File(filePath);
        Scanner studentScanner = new Scanner(studentFile);

        while (studentScanner.hasNextLine()) {
            String[] data = studentScanner.nextLine().split(" ");
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("male");

            Student student = new Student(firstName, lastName, age, gender);
            for (int i = 4; i < data.length; i++) {
                student.addMark(Integer.parseInt(data[i]));
            }
            school.addParticipant(student);
        }

        studentScanner.close();
    }

    // Method to read teachers from a file and add to the school
    private static void readAndAddTeachers(School school, String filePath) throws FileNotFoundException {
        File teacherFile = new File(filePath);
        Scanner teacherScanner = new Scanner(teacherFile);

        while (teacherScanner.hasNextLine()) {
            String[] data = teacherScanner.nextLine().split(" ");
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("male");
            String subject = data[4];
            int experience = Integer.parseInt(data[5]);
            int salary = Integer.parseInt(data[6]);

            Teacher teacher = new Teacher(firstName, lastName, age, gender, subject, experience, salary);
            if (experience > 10) {
                teacher.applyRaise(10);  // Apply raise if teacher has more than 10 years of experience
            }
            school.addParticipant(teacher);
        }

        teacherScanner.close();
    }

    // Method to display details of students and teachers
    private static void displayMemberDetails(School school) {
        for (Person member : school.getParticipants()) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(student.getFirstName() + " GPA: " + student.computeGPA());
            } else if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                System.out.println(teacher.getFirstName() + " Salary after raise: " + teacher.getCompensation());
            }
        }
    }
}
