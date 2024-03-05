import aud.Stack;

public class RecursionToStack {
    //-----------------------------------------------------------------//
    public static int whatStack(int n) {
        // Erstellen Sie einen Stack und legen Sie den Eingabeparameter n darauf
        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        // Summe initialisieren
        int sum = 0;

        // Solange der Stack nicht leer ist, führen Sie Folgendes aus:
        while (!stack.is_empty()){
            int x = stack.pop(); // Holen Sie das oberste Element vom Stack

            // Wenn das Element kleiner als 10 ist, addieren Sie es zur Summe hinzu
            if (x < 10){
                sum += x;
            }
            // Andernfalls:
            else {
                stack.push((x/10)); // Teilen Sie das Element durch 10 und legen Sie den Quotienten auf den Stack
                x = x % 10; // Berechnen Sie den Rest des Elements durch 10
                sum += x; // Addieren Sie den Rest zur Summe hinzu
            }
        }
        return sum;
    }

    //-----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: Testen Sie Ihren Code mit geeigneten Beispielen
        System.out.println(whatStack(123));
        System.out.println(whatStack(235));
        System.out.println(whatStack(346));
    }

}