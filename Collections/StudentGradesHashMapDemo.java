// Q: HashMap Example - Student Grades
// Store and retrieve students' grades using roll numbers as keys.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradesHashMapDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> studentGrades = new HashMap<>();

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("\nEnter roll number: ");
            int roll = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter grade: ");
            String grade = scanner.nextLine();

            studentGrades.put(roll, grade);
        }

        System.out.print("\nEnter roll number to retrieve grade: ");
        int searchRoll = scanner.nextInt();

        if (studentGrades.containsKey(searchRoll)) {
            System.out.println("Grade for Roll No " + searchRoll + ": " + studentGrades.get(searchRoll));
        } else {
            System.out.println("Student not found.");
        }

        scanner.close();
    }
}
