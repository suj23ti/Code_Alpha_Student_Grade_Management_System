package project1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class Student_grade_management_system {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== Student Grade Management System =====");

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input student data
        for (int i = 1; i <= numStudents; i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            double grade = 0;

            try {
                System.out.print("Enter grade: ");
                grade = scanner.nextDouble();
                scanner.nextLine(); // consume newline

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Grade must be a number.");
                scanner.nextLine(); // clear wrong input
                grade = 0;
            }

            // ✅ IMPORTANT: add student to list
            students.add(new Student(name, grade));

            System.out.println("Student: " + name);
            System.out.println("Grade: " + grade);
        }

        // Calculate statistics
        double total = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;

        for (Student student : students) {
            total += student.grade;

            if (student.grade > highest) {
                highest = student.grade;
            }

            if (student.grade < lowest) {
                lowest = student.grade;
            }
        }

        double average = total / students.size();

        // Display report
        System.out.println("\n========== SUMMARY REPORT ==========");
        System.out.printf("%-20s %-10s\n", "Student Name", "Grade");
        System.out.println("------------------------------------");

        for (Student student : students) {
            System.out.printf("%-20s %-10.2f\n",
                    student.name, student.grade);
        }

        System.out.println("------------------------------------");
        System.out.printf("Average Grade : %.2f\n", average);
        System.out.printf("Highest Grade : %.2f\n", highest);
        System.out.printf("Lowest Grade  : %.2f\n", lowest);

        scanner.close();
    }
}