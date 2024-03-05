public class RNode {

    private int data; // Integer-Wert des Knotens
    private RNode next; // Verweis auf den nächsten Knoten im Ring

    // Konstruktor für den Knoten
    public RNode(int data) {
        this.data = data; // Initialisierung des Integer-Werts
        this.next = this; // Der Knoten verweist auf sich selbst, da der Ring zunächst nur einen Knoten enthält
    }

    // Methode zum Einfügen eines neuen Knotens vor dem bestehenden Knoten position
    public void insert_before(RNode n, RNode position) {
        RNode current = this; // Starte bei diesem Knoten
        while (current.next != position) { // Durchlaufe den Ring bis zum Knoten vor "position"
            current = current.next;
        }
        current.next = n; // Füge den neuen Knoten n vor "position" ein
        n.next = position;
    }

    // Methode zum Suchen des ersten Knotens mit Wert x im Ring
    public RNode find(int x) {
        RNode current = this; // Starte bei diesem Knoten
        do {
            if (current.data == x) { // Wenn der Wert des aktuellen Knotens x entspricht, gib den Knoten zurück
                return current;
            }
            current = current.next; // Gehe zum nächsten Knoten im Ring
        } while (current != this); // Durchlaufe den Ring, bis wir wieder beim Anfang sind
        return null; // Wenn kein Knoten mit dem Wert x gefunden wurde, gib null zurück
    }
}



