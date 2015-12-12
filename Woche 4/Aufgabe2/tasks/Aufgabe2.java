/*
    Aufgabe2) Einfach verkettete Liste

    In der Klasse IntList haben Sie eine Listenimplementierung gegeben. Dazu
    sollen Sie folgende zusätzliche Methoden implementieren:

    - add:      (rekursiv) Fügt neue Knoten zur Liste hinzu. Es wird angenommen,
                dass die Elemente in der richtigen Reihenfolge (sortiert)
                hinzugefügt werden.
    - search:   (iterativ) Sucht in der Liste nach einem übergebenen Wert. Wird
                der Wert gefunden, dann wird true zurückgeliefert. Ansonsten
                wird false zurückgeliefert. Diese Methode muss iterativ in der
                Klasse IntList implementiert werden.
    - reverseI: (iterativ) Dreht die Liste um. Die Methode muss iterativ
                implementiert werden. Die eigentliche Iteration sollte in der
                Klasse ListNode durchgeführt werden. Bei dieser Methode werden
                keine (!) neuen Knoten erzeugt und die Werte der Knoten dürfen
                nicht überschrieben werden. Die Umkehrung der Liste wird nur
                durch die Neuverkettung der vorhandenen Knoten erreicht!
    - reverseR: (rekursiv) Dreht die Liste um. Die Methode muss rekursiv
                implementiert werden. Die eigentliche Rekursion sollte in der
                Klasse ListNode durchgeführt werden. Bei dieser Methode werden
                keine (!) neuen Knoten erzeugt und die Werte der Knoten dürfen
                nicht überschrieben werden. Die Umkehrung der Liste wird nur
                durch die Neuverkettung der vorhandenen Knoten erreicht!

    Erweitern Sie ListNode um eine Membervariable "int prevSum" (previous sum),
    die die Summe aller vorherigen Elemente der Liste abspeichert, und diese bei
    Veränderung der Liste durch die oben angeführten Methoden wieder
    aktualisiert und anpasst. Der head-Knoten der Liste hat für prevSum den
    Wert 0 gespeichert.

    Zusatzfragen:
    1. Wie entsteht die Ausgabe beim Aufruf der Methode
       System.out.println(list);
    2. Warum ist es sinnvoll beim Iterieren durch Listen sich eine Kopie des
       Zeigers auf den "head"-Knoten zu erstellen?

*/
public class Aufgabe2 {

    public static void main(String[] args) {
        IntList myList = new IntList();
        for(int i = 1; i < 10; i++){
            myList.add(i);
        }

        System.out.println(myList);
        myList.reverseI();
        System.out.println(myList);
        myList.reverseR();
        System.out.println(myList);
        System.out.println(myList.search(5));
        System.out.println(myList.search(14));
    }
}

