// Question:
// Implement a Generic Stack Class:
// Design a class Stack<T> that uses an ArrayList<T> to implement stack behavior (push, pop, and peek methods).
// Include error handling for popping from an empty stack.

import java.util.ArrayList;
import java.util.Scanner;
import java.util.EmptyStackException;

class Stack<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
        System.out.println("Pushed: " + item);
    }

    public T pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.println("Current Stack: " + list);
    }
}

public class GenericStackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        int choice;
        do {
            System.out.println("\nStack Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter item to push: ");
                        String item = scanner.nextLine();
                        stack.push(item);
                        break;

                    case 2:
                        System.out.println("Popped: " + stack.pop());
                        break;

                    case 3:
                        System.out.println("Top element: " + stack.peek());
                        break;

                    case 4:
                        stack.display();
                        break;

                    case 0:
                        System.out.println("Exiting program.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (EmptyStackException e) {
                System.out.println("Stack is empty! Operation not possible.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
