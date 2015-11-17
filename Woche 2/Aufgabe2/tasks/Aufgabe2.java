/*
    Aufgabe2) Rekursion nachvollziehen

    Die Methoden 'simple' und 'rec' sind nach folgendem Muster aufgebaut:

    private static int simple(int line) {
        System.out.println(...);
        return ...;
    }

    private static int rec(int i, int line) {
         System.out.println(...);
         if (i > 0) {
            ... = rec(i - 1, ...);
            ... = simple(0);
            ... = rec(i - 1, ...);
            return ...;
        }
        return ...;
    }

    Ersetzen Sie alle '...' in diesem Muster durch Ausdrücke, sodass ein Aufruf von rec(4, 0) ein Protokoll aller
    Methodenaufrufe erstellt. Jeder Eintrag im Protokoll gibt eine fortlaufende Nummer des Aufrufs, den Namen der
    aufgerufenen Methode und die Werte aller Parameter an. Die Parameter 'line' in 'simple' und 'rec' sowie die
    zurückgegebenen Ergebnisse stehen dabei jeweils für die fortlaufende Nummer der zuletzt ausgegebenen Zeile im
    Protokoll. Die ersten zehn Zeilen des Protokolls sollen folgendermaßen aussehen:

    1 rec(4, 0)
    2 rec(3, 1)
    3 rec(2, 2)
    4 rec(1, 3)
    5 rec(0, 4)
    6 simple(5)
    7 rec(0, 6)
    8 simple(7)
    9 rec(1, 8)
    10 rec(0, 9)


    Zusatzfragen:
    1. Wodurch kommt die große Anzahl der Zeilen im Protokoll zustande?
    2. Wie stark wirkt sich eine Änderung des ersten Arguments von 'rec' auf die Anzahl der Zeilen im Protokoll aus?
       Wie viele Zeilen würde man z.B. mit 2, 6, 10 oder 15 statt 4 bekommen?
    3. Wie viele Aufrufe von 'rec' sind maximal zur selben Zeit aktiv?
    4. Durch welche einzelne Anweisung könnte man die vier Anweisungen in der bedingten Anweisung in 'rec' ersetzen,
       ohne die Semantik des Programms zu ändern?
*/
public class Aufgabe2 {

    // Hier sollten die benötigten Methoden stehen.

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
    }
}
