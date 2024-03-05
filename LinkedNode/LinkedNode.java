

public class LinkedNode<T> {
    T data_ = null; // represents the data stored in the node.
    LinkedNode<T> next_ = null;  // represent the reference to the next node in the list.

    // TODO: constructors
    public LinkedNode(T data){ // constructor for the 'LinkedNode' class.
        this.data_ = data;
        this.next_ = null;
    }


    // TODO: getters and setters  // these are the getters and setters methods
    /* Diese Getter- und Setter-Methoden ermöglichen uns,
       die data_- und next_-Instanzvariablen eines LinkedNode-Objekts von außerhalb der Klasse zu manipulieren,
       während wir gleichzeitig die Kapselung beibehalten. */
    /*
    Dies bedeutet, dass die internen Details der Klasse vor der Außenwelt verborgen bleiben
    und wir nur über ihre öffentlichen Methoden mit der Klasse interagieren können.
     */
    public void setData_(T data){
        this.data_ = data;
    }

    public T getData(){
        return this.data_;
    }

    public void setNext_(LinkedNode<T> next){
        this.next_ = next;
    }

    public LinkedNode<T> getNext_() {
        return next_;
    }

    // Provide String-representation for list beginning at `this` node.
    @Override
    public String toString() { //This is an overridden toString method for the LinkedNode class.
        // It returns a string representation of the list starting from the current node.
        // It does this by iterating through the list starting at the current node and appending each node's data_ variable to a StringBuilder object.
        // TODO: show data_ from this to the end

        /*  diese Methode gibt eine String representation der Liste zurück,
           die beim aktuellen Knoten beginnt.
           Dies geschieht durch Iterieren durch die Liste,
           beginnend beim aktuellen Knoten, und Anfügen der data_-Variable jedes Knotens an ein StringBuilder-Objekt. */
        StringBuilder sb = new StringBuilder();
        LinkedNode<T> current = this;
        while (current != null){
            sb.append(current.data_);
            sb.append(" ");
            current = current.next_;
        }
        return sb.toString();



    }

    // You must provide a main() method!
    public static void main(String[] args) {
        // TODO: Test

        LinkedNode<String> Montag = new LinkedNode<>("Montag");
        LinkedNode<String> Donnerstag = new LinkedNode<>("Donnerstag");
        LinkedNode<String> Freitag = new LinkedNode<>("Freitag");
        Montag.setNext_(Donnerstag);
        Donnerstag.setNext_(Freitag);
        System.out.println(Montag);


        LinkedNode<String> Dienstag = new LinkedNode<>("Dienstag");
        LinkedNode<String> Mittwoch = new LinkedNode<>("Mittwoch");
        Montag.setNext_(Dienstag);
        Dienstag.setNext_(Mittwoch);
        Mittwoch.setNext_(Donnerstag);
        Donnerstag.setNext_(Freitag);
        System.out.println(Montag);









    }
}