import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//---------------------------------------------------------------//
public class MyHash {
    //-------------------------------------------------------------//
    //-------------- !!Insert your solution below!! ---------------//
    public BucketArray e_;  //<-- !! USE ONLY THIS ARRAY !!
    int size_;              //the capacity of the array

    //-------------------------------------------------------------//
    public MyHash(int size) {
        this.size_ = size;
        e_ = new BucketArray(size);
    }

    // Hash-Funktion, die den Hash-Wert für einen gegebenen String berechnet
    private int hashFunction(String s){
        int hashValue = 0;

        // Iteriere durch jeden Buchstaben im String
        for (int i = 0; i< s.length(); i++){
            char character = s.charAt(i);
            hashValue += character; // Füge den ASCII-Wert des Buchstabens zum Hash-Wert hinzu
        }
        return hashValue;
    }

    //-------------------------------------------------------------//
    public void insert(String s) {
        // Berechne den Hash-Index mit Hilfe der Hash-Funktion
        int hashIndex = hashFunction(s);
        int index = hashIndex % e_.arr.length;

        // Lineares Sondieren, um eine leere Position im Array zu finden
        while (e_.arr[index] != null){
            index = (index +1) % e_.arr.length;
        }

        // Füge den String an der leeren Position ein
        e_.arr[index] = s;
    }

    //-------------------------------------------------------------//
    public static void main(String[] args) {
        // Idea for test
        int size = 1249;  // only an example (backend test)
        MyHash hash = new MyHash(size);
        try {
            DataInput s = new DataInputStream(new FileInputStream("ww1.txt"));
            // use correct Path
            String line;
            while ((line = s.readLine()) != null) {
                hash.insert(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        System.out.println(hash.e_.toString());
        System.out.println("Collisions: " + hash.e_.getCollisions() + "\n");
    }

    //---------------------------------------------------------------//
    //---------------------------------------------------------------//
    //--------------- !!Do not change the code below!! --------------//
    class BucketArray {
        protected String[] arr;
        protected int col;

        //-------------------------------------------------------------//
        public BucketArray(int size) {
            col = 0;
            arr = new String[size];
        }

        //-------------------------------------------------------------//
        /**Insert the String s at index pos into the the BucketArray.
         If this index is already filled/blocked by another String,
         s is *NOT* added and false is returned.
         \return - true, if s was added correctly
         - false, if there is already an entry for this position.*/
        public boolean insert(int pos, String s) {
            if (arr[pos] == null) {
                arr[pos] = s;
                return true;
            }
            col++;
            return false;
        }

        //-------------------------------------------------------------//
        public int getCollisions() {
            return col;
        }

        //-------------------------------------------------------------//
        public String toString() {
            String res = new String();
            for (String s : arr)
                res += s + "\n";
            return res;
        }
    }
}