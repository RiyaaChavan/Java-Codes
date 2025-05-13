package MongoDB.DesignPatterns;
//q: Create a subject-observer structure where multiple observers get notified when the subject's state changes
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for Observers
interface Observer {
    void update(String message);
}

// Interface for the Subject
interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Observer class
class ConcreteObserver implements Observer {
    private String observerName;

    public ConcreteObserver(String name) {
        this.observerName = name;
    }

    @Override
    public void update(String message) {
        System.out.println(observerName + " received update: " + message);
    }
}

// Concrete Subject class
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("State changed to: " + state);
        }
    }
}

// Main class to demonstrate Observer Pattern
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the Subject
        ConcreteSubject subject = new ConcreteSubject();

        // Create Observers
        System.out.print("Enter name for Observer 1: ");
        String observer1Name = scanner.nextLine();
        ConcreteObserver observer1 = new ConcreteObserver(observer1Name);

        System.out.print("Enter name for Observer 2: ");
        String observer2Name = scanner.nextLine();
        ConcreteObserver observer2 = new ConcreteObserver(observer2Name);

        // Register Observers with the Subject
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        // Change the Subject's state and notify Observers
        System.out.print("Enter new state for the Subject: ");
        String newState = scanner.nextLine();
        subject.setState(newState);

        // Unregister an Observer
        subject.unregisterObserver(observer1);

        // Change the Subject's state again
        System.out.print("Enter another new state for the Subject: ");
        String anotherNewState = scanner.nextLine();
        subject.setState(anotherNewState);

        scanner.close();
    }
}
