package MongoDB.DesignPatterns;
//Respective Design Pattern: Observer Pattern
// Question: Implement a StockPriceTracker class (subject) that notifies multiple observers (e.g., PriceAlert and DisplayBoard) when stock prices change.

import java.util.*;

interface Observer {
    void update(float price);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class StockPriceTracker implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float stockPrice;

    public void setStockPrice(float price) {
        this.stockPrice = price;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }
}

class PriceAlert implements Observer {
    public void update(float price) {
        System.out.println("PriceAlert: Stock price changed to $" + price);
    }
}

class DisplayBoard implements Observer {
    public void update(float price) {
        System.out.println("DisplayBoard: Now showing stock price $" + price);
    }
}

public class StockPriceTrackerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPriceTracker tracker = new StockPriceTracker();

        // Create observers
        Observer alert = new PriceAlert();
        Observer board = new DisplayBoard();

        // Register observers
        tracker.registerObserver(alert);
        tracker.registerObserver(board);

        // Input price change
        System.out.print("Enter new stock price: ");
        float price = scanner.nextFloat();

        // Notify observers
        tracker.setStockPrice(price);

        scanner.close();
    }
}
