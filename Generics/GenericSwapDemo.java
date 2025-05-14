// Q: Write a Generic Swap Method
// Create a method that swaps two elements of any type (e.g., integers, strings).

import java.util.Scanner;

// Wrapper class to hold values (because Java is pass-by-value for primitives & references)
class Wrapper<T> {
    public T value;

    public Wrapper(T value) {
        this.value = value;
    }
}

public class GenericSwapDemo {

    // Generic swap method
    public static <T> void swap(Wrapper<T> a, Wrapper<T> b) {
        T temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Swap integers
        System.out.print("Enter first integer: ");
        Wrapper<Integer> int1 = new Wrapper<>(scanner.nextInt());

        System.out.print("Enter second integer: ");
        Wrapper<Integer> int2 = new Wrapper<>(scanner.nextInt());

        System.out.println("\nBefore Swap: int1 = " + int1.value + ", int2 = " + int2.value);
        swap(int1, int2);
        System.out.println("After Swap:  int1 = " + int1.value + ", int2 = " + int2.value);

        scanner.nextLine(); // consume newline

        // Swap strings
        System.out.print("\nEnter first string: ");
        Wrapper<String> str1 = new Wrapper<>(scanner.nextLine());

        System.out.print("Enter second string: ");
        Wrapper<String> str2 = new Wrapper<>(scanner.nextLine());

        System.out.println("\nBefore Swap: str1 = " + str1.value + ", str2 = " + str2.value);
        swap(str1, str2);
        System.out.println("After Swap:  str1 = " + str1.value + ", str2 = " + str2.value);

        scanner.close();
    }
}
