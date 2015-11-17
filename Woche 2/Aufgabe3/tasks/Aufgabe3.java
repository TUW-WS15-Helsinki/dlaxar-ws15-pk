/*
    Aufgabe3) Eindimensionales Array

    Implementieren Sie folgende statische Methoden:

      - 'createArray' gibt ein neues Array zurück, dessen Länge gleich dem Argument der Methode ist. Das Array
        enthält Zufallszahlen größer oder gleich 0.0 und kleiner 100.0 (des diesen Literalen entsprechenden Typs).
        Zur Erzeugung von Zufallszahlen können Sie Math.random() verwenden:
        http://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random

      - 'printArray' hat zwei Parameter, gibt aber kein Ergebnis zurück. Der erste Parameter A ist ein Array, das z.B.
        durch 'createArray' erzeugt wurde. Der zweite Parameter N ist eine ganze Zahl mit N > 0. 'printArray' zerlegt
        den Wertebereich [0.0, 100.0) in N gleich große Teilbereiche (z.B. für N gleich 4 in [0.0, 25.0), [25.0, 50.0),
        [50.0, 75.0) und [75.0, 100.0) ) und zählt die Zahlen im Array A, die in jeden dieser Wertebereiche fallen.
        Schließlich gibt 'printArray' für jeden dieser Teilbereiche eine Zeile aus, welche die Anzahl der Zahlen im
        entsprechenden Teilbereich enthält. Beispielsweise gibt 'printArray' für ein A der Länge 5 mit den Zahlen
        10.0, 60.0, 20.0, 80.0 und 70.0 und N gleich 4 folgende Zeilen aus:

            2
            0
            2
            1

        Hinweise: Verwenden Sie zum Zählen der Zahlen in den Teilbereichen am besten ein weiteres Array. Am einfachsten
        ist es, die Zuordnung einer Zahl zu einem Teilbereich in die Berechnung des Indexes für dieses Array einzubauen.
        A und N dienen zur Beschreibung der Methode. In Ihrer Implementierung können die Parameter anders heißen.

      - 'diffArray' hat ein Array (wie von 'createArray' zurückgegeben) als Parameter und gibt nichts zurück. Jeder
        Wert im Array wird durch die positive Differenz zwischen diesem Wert und dem Durchschnittswert aller
        Elemente im Array ersetzt.

    Zusatzfragen:
    1. Warum kann man in 'printArray' for-each-Schleifen (also Schleifen der Form for(... : ...) ...) verwenden,
       in 'createArray' und 'diffArray' aber nicht?
    2. Warum ist es möglich, dass 'diffArray' kein Ergebnis zurückgibt, die Auswirkungen der Methode aber dennoch
       sichtbar werden?
    3. Woran könnte man feststellen, ob die Lösung richtig ist, obwohl jeder Testlauf andere Ergebnisse liefert?
    4. Wie wirken sich wiederholte Anwendungen von 'diffArray' auf die Verteilung der Werte im Array aus
       (entsprechend der Ausgabe von 'printArray')?
*/
public class Aufgabe3 {

    // Hier sollten die benötigten Methoden stehen.

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
    }
}
