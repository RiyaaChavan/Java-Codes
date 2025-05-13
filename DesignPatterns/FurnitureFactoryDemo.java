package MongoDB.DesignPatterns;
//Respective Design Pattern: Factory Pattern
// Question: Create a system where a FurnitureFactory creates different types of furniture objects (e.g., Chair, Table, Sofa) based on user input.

import java.util.Scanner;

interface Furniture {
    void create();
}

class Chair implements Furniture {
    public void create() {
        System.out.println("Chair has been created.");
    }
}

class Table implements Furniture {
    public void create() {
        System.out.println("Table has been created.");
    }
}

class Sofa implements Furniture {
    public void create() {
        System.out.println("Sofa has been created.");
    }
}

class FurnitureFactory {
    public static Furniture getFurniture(String type) {
        switch (type.toLowerCase()) {
            case "chair":
                return new Chair();
            case "table":
                return new Table();
            case "sofa":
                return new Sofa();
            default:
                return null;
        }
    }
}

public class FurnitureFactoryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the type of furniture (Chair/Table/Sofa): ");
        String input = scanner.nextLine();

        Furniture furniture = FurnitureFactory.getFurniture(input);

        if (furniture != null) {
            furniture.create();
        } else {
            System.out.println("Invalid furniture type.");
        }

        scanner.close();
    }
}
