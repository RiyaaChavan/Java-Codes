// Inspect Class using Reflection
// Write a program to get class name, fields, and method names using reflection.

import java.lang.reflect.*;

public class ClassInspector {

    public static void main(String[] args) {
        // Example class to inspect
        SampleClass sample = new SampleClass();
        Class<?> clazz = sample.getClass();

        // Print class name
        System.out.println("Class Name: " + clazz.getName());

        // Print declared fields
        System.out.println("\nDeclared Fields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName());
        }

        // Print declared methods
        System.out.println("\nDeclared Methods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "()");
        }
    }
}

// A sample class to demonstrate reflection
class SampleClass {
    private int id;
    private String name;

    public SampleClass() {
        this.id = 1;
        this.name = "Demo";
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    private void secretMethod() {
        System.out.println("This is a secret method.");
    }
}
