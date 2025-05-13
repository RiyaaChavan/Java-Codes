// Q: Apply Interface Segregation Principle
// Create separate interfaces for print, scan, and fax operations and implement only required ones.
package MongoDB.SOLID;

import java.util.Scanner;

interface Printable {
    void printDocument();
}

interface Scannable {
    void scanDocument();
}

interface Faxable {
    void faxDocument();
}

// Implements only print functionality
class SimplePrinter implements Printable {
    public void printDocument() {
        System.out.println("Printing document using SimplePrinter...");
    }
}

// Implements print and scan functionality
class OfficePrinter implements Printable, Scannable {
    public void printDocument() {
        System.out.println("Printing document using OfficePrinter...");
    }

    public void scanDocument() {
        System.out.println("Scanning document using OfficePrinter...");
    }
}

// Implements all three
class MultiFunctionPrinter implements Printable, Scannable, Faxable {
    public void printDocument() {
        System.out.println("Printing document using MultiFunctionPrinter...");
    }

    public void scanDocument() {
        System.out.println("Scanning document using MultiFunctionPrinter...");
    }

    public void faxDocument() {
        System.out.println("Faxing document using MultiFunctionPrinter...");
    }
}

// Main class to test behavior
public class InterfaceSegregationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Printer Selection Menu =====");
        System.out.println("1. Simple Printer (Print only)");
        System.out.println("2. Office Printer (Print, Scan)");
        System.out.println("3. Multi-Function Printer (Print, Scan, Fax)");
        System.out.print("Choose a printer (1-3): ");
        
        int printerChoice;
        try {
            printerChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Defaulting to Simple Printer.");
            printerChoice = 1;
        }
        
        switch (printerChoice) {
            case 1:
                SimplePrinter simplePrinter = new SimplePrinter();
                useSimplePrinter(simplePrinter, scanner);
                break;
            case 2:
                OfficePrinter officePrinter = new OfficePrinter();
                useOfficePrinter(officePrinter, scanner);
                break;
            case 3:
                MultiFunctionPrinter mfp = new MultiFunctionPrinter();
                useMultiFunctionPrinter(mfp, scanner);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Simple Printer.");
                SimplePrinter defaultPrinter = new SimplePrinter();
                useSimplePrinter(defaultPrinter, scanner);
        }
        
        scanner.close();
    }
    
    private static void useSimplePrinter(SimplePrinter printer, Scanner scanner) {
        System.out.println("\n===== Simple Printer Menu =====");
        System.out.println("1. Print Document");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Exiting.");
            return;
        }
        
        if (choice == 1) {
            printer.printDocument();
        } else {
            System.out.println("Exiting.");
        }
    }
    
    private static void useOfficePrinter(OfficePrinter printer, Scanner scanner) {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n===== Office Printer Menu =====");
            System.out.println("1. Print Document");
            System.out.println("2. Scan Document");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    printer.printDocument();
                    break;
                case 2:
                    printer.scanDocument();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void useMultiFunctionPrinter(MultiFunctionPrinter printer, Scanner scanner) {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n===== Multi-Function Printer Menu =====");
            System.out.println("1. Print Document");
            System.out.println("2. Scan Document");
            System.out.println("3. Fax Document");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    printer.printDocument();
                    break;
                case 2:
                    printer.scanDocument();
                    break;
                case 3:
                    printer.faxDocument();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}