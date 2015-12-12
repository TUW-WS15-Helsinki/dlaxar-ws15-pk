/*
    Aufgabe3) Doppelt verkettete Liste

    In der Klasse CharList haben Sie eine Listenimplementierung gegeben. Ähnlich
    zu Aufgabe2 wird anstatt eines int ein char in jedem Knoten gespeihert.
    Zusätzlich ist die Liste nun doppelt verkettet. Das heißt jeder Knoten zeigt
    nun auf seinen Nachfolger und auf seinen Vorgänger.

    Dazu sollen Sie folgende zusätzliche Methoden implementieren:

    - add:      (rekursiv) Fügt neue Knoten zur Liste hinzu. Es wird angenommen,
                dass die Elemente in der richtigen Reihenfolge (sortiert)
                hinzugefügt werden. Hier wird der numerische Wert des char
                Zeichens verwendet.
    - search:   (iterativ) Sucht in der Liste nach einem übergebenen Wert. Wird
                der Wert gefunden, dann wird true zurückgeliefert. Ansonsten
                wird false zurückgeliefert. Diese Methode muss iterativ in der
                Klasse IntList implementiert werden.
    - insert:   (iterativ) Fügt einen Knoten entsprechend dem Element
                (char - numerischer Wert) an der richtigen Stelle ein. Hängen
                Sie an entsprechender Stelle die Liste so um, damit diese nach
                Einfügen wieder die korrekte Verkettung aufweist.
    - remove:   (iterativ) Entfernt aus der Liste einen übergebenen Wert, falls
                dieser vorhanden ist. Bei erfolgreichem Entfernen wird true
                zurückgegeben, ansonsten false.

    Zusatzfragen:
    1. Erläutern Sie die Vor- und Nachteile von Listen gegenüber Arrays.
    2. Was müsste man hinzufügen um am Ende der Liste einen Knoten hinzuzufügen
       (Ohne Iteration durch die Liste) ?

*/
public class Aufgabe3 {

    public static void main(String[] args) {

        CharList myList = new CharList();
        for(char i = 'A'; i < 'J'; i++){
            myList.add(i);
        }
        System.out.println(myList);
        myList.remove('G');
        System.out.println(myList);
        myList.remove('G');
        System.out.println(myList);
        myList.remove('E');
        System.out.println(myList);
        myList.remove('A');
        System.out.println(myList);
        myList.remove('I');
        System.out.println(myList);

        myList.insert('E');
        System.out.println(myList);
        myList.insert('I');
        System.out.println(myList);
        myList.insert('G');
        System.out.println(myList);
        myList.insert('A');
        System.out.println(myList);
        System.out.println(myList.search('B'));
        System.out.println(myList.search('I'));
    }
}
