public class MyCircle<T> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    //A Node is a single element int the ring
    class Node {
        T data_ = null;
        Node next_ = null;
        Node prev_ = null;

        Node(T obj, Node prv, Node nxt) {
            data_ = obj;
            prev_ = prv;
            next_ = nxt;
        }
    }

    //--- class members
    protected Node head_ = null;

    //--- class methods
    public   MyCircle() { head_ = null; }

    public T front()    { return head_.data_; }


    public String toString() {
        if (empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while(node != head_);
        rv += "]";
        return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//

    public int size() {
        // TODO: return the size of the ring buffer
        if (!empty()) {
            int head = 1;
            Node tail = head_;
            while (tail.next_ != head_) {
                tail = tail.next_;
                ++head;
            }
            return head;
        }
        else return 0;
    }

    //-----------------------------------------------------------------//
    public boolean empty() {
        // TODO: return if the ring buffer is empty
        return head_==null;
    }

    //-----------------------------------------------------------------//
    public void push_back(T obj) {
        // TODO: append an element at the 'end' of the end buffer
        if (empty()) {// Falls die Liste leer ist, erstelle einen neuen Knoten und setze ihn als head
            head_ = new Node(obj, null, null);
            head_.next_ = head_;
            head_.prev_ = head_;
        } else {// Falls die Liste nicht leer ist, füge einen neuen Knoten am Ende ein
            Node last_  = head_.prev_;

            Node newNode = new Node(obj, last_ , head_);  // Erstelle einen neuen Knoten und setze ihn hinter dem letzten Knoten ein
            last_.next_ = newNode; // Aktualisiere die next-Referenz des letzten Knotens auf den neuen Knoten
            head_.prev_ = newNode; // Aktualisiere die prev-Referenz der head-Referenz auf den neuen Knoten
        }

    }

    //-----------------------------------------------------------------//
    public void pop_front() {
        // TODO: remove an element at the 'front' if the ring buffer
        if(size()==1){// Falls die Liste nur einen Knoten enthält, entferne ihn und setze head auf null
            head_ =null ;
        }
        else if(empty()){// Falls die Liste leer ist, gibt es nichts zu entfernen
            System.out.println("is empty");
        }
        // Falls die Liste mehr als einen Knoten enthält, entferne den ersten Knoten und aktualisiere head
        else {
            // Der neue erste Knoten ist der nächste Knoten nach dem aktuellen head
            Node newHead = head_.next_;
            // Der vorherige Knoten des neuen ersten Knotens ist der letzte Knoten der Liste
            Node lastNode = head_.prev_;
            // Setze die next-Referenz des letzten Knotens auf den neuen ersten Knoten
            lastNode.next_ = newHead;
            // Setze die prev-Referenz des neuen ersten Knotens auf den letzten Knoten
            newHead.prev_ = lastNode;
            // Setze head auf den neuen ersten Knoten
            head_ = newHead;
        }
    }


    //-----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
        MyCircle<String> test = new MyCircle<>();

        System.out.println("Initial size of the test : " + test.size());
        System.out.println("Is the test empty? " + test.empty());

        String text = "Khled Ahmed Hus ";
        String[] split = text.split(" ");
        for (String s : split)
            test.push_back(s);

        System.out.println("Elements in the test: " + test.toString());
        System.out.println("Size of the test after adding elements: " + test.size());
        System.out.println("Is the test empty after adding elements? " + test.empty());

        test.pop_front();

        System.out.println("Elements in the test after removing one element: " + test.toString());
        System.out.println("Size of the test after removing one element: " + test.size());
        System.out.println("Is the test empty after removing one element? " + test.empty());
    }

}