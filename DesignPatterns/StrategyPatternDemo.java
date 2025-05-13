package MongoDB.DesignPatterns;

//q:Create a context class that uses different sorting strategies (bubble sort, quick sort) at runtime.
import java.util.Scanner;

// Strategy Interface
interface SortingStrategy {
    void sort(int[] array);
    String getName(); // Added to get the name of the sorting strategy
}

// Concrete Strategy: Bubble Sort
class BubbleSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap temp and array[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}

// Concrete Strategy: Quick Sort
class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot) {
                i++;

                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}

// Concrete Strategy: Merge Sort
class MergeSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort the first and second halves
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            // Merge the sorted halves
            merge(array, l, m, r);
        }
    }

    private void merge(int[] array, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }
}

// Concrete Strategy: Insertion Sort
class InsertionSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}

// Context Class
class Sorter {
    private SortingStrategy sortingStrategy;

    public Sorter(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array) {
        System.out.println("Using " + sortingStrategy.getName() + " to sort the array."); //added line
        sortingStrategy.sort(array);
    }

    public void displayArray(int[] array) {
        System.out.print("Sorted Array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Main Class
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array to sort: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        Sorter sorter = null; // Declare sorter here.

        System.out.print("Choose a sorting strategy (1 for Bubble Sort, 2 for Quick Sort, 3 for Merge Sort, 4 for Insertion Sort): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            sorter = new Sorter(new BubbleSortStrategy());
        } else if (choice == 2) {
            sorter = new Sorter(new QuickSortStrategy());
        } else if (choice == 3) {
            sorter = new Sorter(new MergeSortStrategy());
        } else if (choice == 4) {
            sorter = new Sorter(new InsertionSortStrategy());
        } else {
            System.out.println("Invalid choice. Exiting.");
            scanner.close();
            return;
        }

        sorter.performSort(array);
        sorter.displayArray(array);

        scanner.close();
    }
}
