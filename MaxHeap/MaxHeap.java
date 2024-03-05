import java.util.*;

//-----------------------------------------------------------------//
public class MaxHeap<T extends Comparable<T>> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
        return heap_.toString();  // don't change because of backend
    }

    //---------------------------------------------------------------//
    //--------------- !!Insert your solution below!! ----------------//
    private ArrayList<T> heap_;  // or Vector  // ArrayList to store the heap elements  // ArrayList zur Speicherung der Heap-Elemente


    //---------------------------------------------------------------//
    public MaxHeap() {
        // TODO: implementation
        heap_ = new ArrayList<T>(); // Initialize the heap as an empty ArrayList // Initialisiere den Heap als leere ArrayList
    }

    //---------------------------------------------------------------//
   public MaxHeap(T[] arr) {
        // TODO: construct a heap from array a (use downHeap)
       heap_ = new ArrayList<T>();  // Initialize the heap as an empty ArrayList

        for (int i = 0; i< arr.length; i++){
            heap_.add(arr[i]);    // Add each element of the array to the heap
        }
        int n = heap_.size();
        int k = (n-1) / 2;
        for (int i = k; i>= 0; i--){
            downHeap(i);    // Perform downHeap operation starting from the last parent node
                           // Führe die downHeap-Operation ab dem letzten Elternknoten aus
        }
    }



    //---------------------------------------------------------------//
    public ArrayList<T> getHeap(){
        // TODO: implementation
        return heap_;  // Return the heap ArrayList // Gibt die Heap-ArrayList zurück
    }

    //---------------------------------------------------------------//
    public int getSize() {
        // TODO: implementation
        return heap_.size();  // Return the size of the heap // Gibt die Größe des Heaps zurück
    }

    //---------------------------------------------------------------//
    public boolean isEmpty() {
        // TODO: implementation
        return heap_.isEmpty(); // Check if the heap is empty
                               // Überprüfe, ob der Heap leer ist
    }

    //---------------------------------------------------------------//
    public void downHeap(int n) {
        // TODO: implementation
        T x = heap_.get(n); // x is the element at index n

        while (n < heap_.size() / 2) {
            int j = 2 * n + 1; // Index of the left child

            if (j < (heap_.size() - 1) && heap_.get(j).compareTo(heap_.get(j + 1)) < 0) {
                j = j + 1; // If the right child is greater, update j to point to the right child
            }

            if (x.compareTo(heap_.get(j)) >= 0) {
                break; // If x is in the correct position, exit the loop
            }

            heap_.set(n, heap_.get(j)); // swap the values
            n = j;
        }

        heap_.set(n, x); // place x in its final position
    }
    //---------------------------------------------------------------//
    public void insert(T obj) {
        // TODO: implementation, use upHeap
        heap_.add(obj); // Add the object to the heap
        upHeap(heap_.size()-1); // Perform upHeap operation starting from the last element
                                  // Führe die upHeap-Operation ab dem letzten Element aus
    }

    //---------------------------------------------------------------//

    private void upHeap(int n) {
        T x = heap_.get(n); // Get the element at index n
        while (n > 0) {
            if (x.compareTo(heap_.get((n - 1) / 2)) > 0) {
                heap_.set(n, heap_.get((n - 1) / 2));  // Move the parent element down // Bewege das Elternelement nach unten
                n = (n - 1) / 2;
            } else {
                break;
            }
        }
        heap_.set(n,x); // Place x in its final position
    }





    //---------------------------------------------------------------//
    public static void main(String[] args) {
        // Create a MaxHeap object
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        // Insert elements into the heap
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(8);
        maxHeap.insert(12);
        maxHeap.insert(3);

        // Print the heap
        System.out.println("Heap: " + maxHeap.getHeap());

        // Get the size of the heap
        int size = maxHeap.getSize();
        System.out.println("Heap size: " + size);

        // Check if the heap is empty
        boolean isEmpty = maxHeap.isEmpty();
        System.out.println("Is heap empty? " + isEmpty);

        // Create a MaxHeap from an array
        Integer[] arr = {9, 4, 7, 2, 6};
        MaxHeap<Integer> arrHeap = new MaxHeap<>(arr);
        System.out.println("Heap from array: " + arrHeap.getHeap());
    }

}