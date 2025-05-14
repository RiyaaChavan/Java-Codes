package MongoDB.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the class to inspect (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            // Get the Class object for the given class name
            Class<?> inspectedClass = Class.forName(className);

            // Print the class name
            System.out.println("\nClass Name: " + inspectedClass.getName());

            // Get and print the fields of the class
            System.out.println("\nFields:");
            Field[] fields = inspectedClass.getDeclaredFields(); //Gets all declared fields, including private ones
            if (fields.length == 0)
            {
                System.out.println(" No fields found");
            }
            else {
                for (Field field : fields) {
                    System.out.println(" - " + field.getType().getSimpleName() + " " + field.getName());
                }
            }


            // Get and print the methods of the class
            System.out.println("\nMethods:");
            Method[] methods = inspectedClass.getDeclaredMethods();  //Gets all declared methods, including private ones.
            if (methods.length == 0)
            {
                System.out.println(" No methods found");
            }
            else{
                for (Method method : methods) {
                    System.out.println(" - " + method.getName() + " (" + getParameterTypes(method) + ")");
                }
            }


        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
        scanner.close();
    }

    // Helper method to get parameter types as a string
    private static String getParameterTypes(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameterTypes.length; i++) {
            sb.append(parameterTypes[i].getSimpleName());
            if (i < parameterTypes.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

