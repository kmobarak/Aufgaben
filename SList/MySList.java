import java.util.NoSuchElementException;

/**MySList repräsentiert eine einfach verkettete Liste, die Elemente des
 * Typs Integer enthält.*/

public class MySList implements Iterable<Integer> {
  //-----------------------------------------------------------------//
  //------------- !!Die folgenden Zeilen nicht ändern!! -------------//
  public String toString() {
    if (empty())
      return "[]";
    String rv = "[";
    Node node = head_;
    do {
      rv += node.data_;
      if (node.next_ != null)
        rv += ",";
      node = node.next_;
    } while (node != null);
    rv += "]";
    return rv;
  }

  public boolean empty() {
    return head_ == null;
  }


  //-----------------------------------------------------------------//
  //---------------- !!Fügen Sie Ihre Lösung unten ein!! -----------------//

  /**
   * Node repräsentiert ein einzelnes Element in der Liste.
   */
  class Node {
    int data_;                         //!! Diese Zeile nicht ändern !!
    // TODO: weitere Implementierung von `Node`
    Node next_;

    public Node(int data) {
      data_ = data;
      next_ = null;

    }

  }
  //----------------------------------------------------------------//
  Node head_ = null;

  //----------------------------------------------------------------//
  public MySList() {
    // TODO: Konstruktor
    head_ = null;

  }

  //----------------------------------------------------------------//
  /*
  Die push_back-Methode wird verwendet, um ein Element am Ende der Liste einzufügen.
  Es erstellt ein neues Node-Objekt mit dem angegebenen Ganzzahlwert und weist es dem next-Feld des letzten Knotens in der Liste zu.
  Wenn die Liste leer ist, wird der neue Knoten zum Kopf der Liste.
   */
  public void push_back(int obj) {
    Node newNode = new Node(obj);
    if (head_ == null) {
      head_ = newNode;
    } else {
      Node current = head_;
      while (current.next_ != null) {
        current = current.next_;
      }
      current.next_ = newNode;
    }
  }

  //----------------------------------------------------------------//

  /**
   * Iterator wird verwendet, um ungerade Elemente in einer Liste zu durchlaufen.
   */
  public class Iterator implements java.util.Iterator<Integer> {
    Node currentNode = head_;


    @Override
    /*
    Die hasNext-Methode prüft, ob es ein nächstes ungerades Element in der Liste gibt, und die next-Methode gibt das nächste ungerade Element zurück.
     */
    public boolean hasNext() {
      Node tempNode = currentNode;
      while (tempNode != null && tempNode.data_ % 2 == 0) { //Prüft, ob der Knoten ungerade ist
        tempNode = tempNode.next_; //Falls der Knoten gerade ist, bewegt es sich auf den nächsten Knoten
      }
      return tempNode != null; //Gibt true zurück, wenn es einen ungeraden Knoten gibt, sonst false
    }

    @Override
    public Integer next() {
      if (currentNode == null) { //Wenn der aktuelle Knoten null ist, wird eine Ausnahme geworfen
        throw new NoSuchElementException();
      }
      Integer nextOdd = null;
      while (currentNode != null) {
        if (currentNode.data_ % 2 != 0) { //Wenn der Knoten ungerade ist, wird der Wert gespeichert und currentNode auf den nächsten Knoten gesetzt
          nextOdd = currentNode.data_;
          currentNode = currentNode.next_;
          break;
        }
        currentNode = currentNode.next_; //Falls der Knoten gerade ist, bewegt es sich auf den nächsten Knoten
      }
      return nextOdd; //Gibt den ungeraden Wert zurück
    }

    @Override
    public void remove() {

    }

  }


  // TODO: Implementieren Sie den Iterator, der über ungerade Elemente läuft


  //----------------------------------------------------------------//
  public Iterator iterator() {
    // TODO: Implementieren Sie diese Methode, die eine neue Iterator-Instanz zurückgibt
    return new Iterator();
  }

  //----------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test your code with appropriate examples
    MySList myList = new MySList();
    myList.push_back(1);
    myList.push_back(2);
    myList.push_back(3);
    myList.push_back(4);
    myList.push_back(5);
    myList.push_back(6);

    for (Integer odd : myList) {
      System.out.print(odd + " ");
    }
  }
}