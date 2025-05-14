// Q: Perform CRUD using ArrayList
// Add, retrieve, update, and remove student records using ArrayList.


import java.util.ArrayList;
import java.util.Scanner;

// Student class to hold student information
class Student {
    private int rollNumber;
    private String name;

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name;
    }
}

public class StudentCRUDDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== Student CRUD Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // Create
                    System.out.print("Enter roll number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    students.add(new Student(roll, name));
                    System.out.println("Student added successfully.");
                    break;

                case 2: // Read
                    System.out.println("\n--- Student List ---");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3: // Update
                    System.out.print("Enter roll number to update: ");
                    int updateRoll = scanner.nextInt();
                    scanner.nextLine();
                    boolean updated = false;
                    for (Student s : students) {
                        if (s.getRollNumber() == updateRoll) {
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            s.setName(newName);
                            updated = true;
                            System.out.println("Student updated successfully.");
                            break;
                        }
                    }
                    if (!updated) System.out.println("Student not found.");
                    break;

                case 4: // Delete
                    System.out.print("Enter roll number to remove: ");
                    int removeRoll = scanner.nextInt();
                    boolean removed = students.removeIf(s -> s.getRollNumber() == removeRoll);
                    if (removed) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
