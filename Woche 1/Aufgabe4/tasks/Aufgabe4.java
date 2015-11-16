/*
    Aufgabe4) Rekursion und Termination

    Die Methoden f, g, h, p und q sind vorgegeben. Rufen Sie in main jede dieser Methoden mit allen Argumenten im
    Bereich von -100 bis 100 (in aufsteigender Reihenfolge) auf und geben sie die Ergebnisse aus, wenn die Aufrufe mit
    Argumenten terminieren. Aufrufe, die nicht terminieren oder einen Überlauf produzieren, sind auszulassen.
    Vermeiden Sie Exceptions.

    Hinweis: Für diese Aufgabe ist es besonders wichtig, die Zusatzfragen beantworten zu können.

    Zusatzfragen:
    1. Nennen Sie für jeden nicht terminierenden Aufruf von f, g, h, p und q einen Grund für die Endlosrekursion
       (im Hinblick auf Fundiertheit und Fortschritt).
    2. Beschreiben Sie überblicksartig, was die Methoden f, g, h, p und q berechnen.
    3. Bedeutet ein StackOverflowError immer, dass eine Endlosrekursion vorhanden ist?
    4. Bedeutet kein StackOverflowError immer, dass ein richtiges Ergebnis geliefert wird?
    5. [optional] Ist die Aufgabe überhaupt lösbar (wegen der Unentscheidbarkeit des Halteproblems der Turing-Maschine)?
*/
public class Aufgabe4 {

    private static int f(int x) {
        return x * x == 100 ? 0 : f(x - 3) + 1;
    }

    private static int g(int x) {
        return x <= -100 ? 0 : g(x / 2 - 2) + 1;
    }

    private static int h(int x) {
        return x == 100 ? 0 : h(x * x + 19) + 1;
    }

    private static int p(int x) {
        return x == 0 ? 0 : x % 2 == 1 ? p(x / 2) + 2 : p(- x - 1) + 1;
    }

    private static int q(int x) {
        return x % 11 == 0 ? 0 : q(x * 2) + 1;
    }

    // to be implemented by you
    public static void main(String[] args) {
        for(int i = -100; i <= 100; i++) {
            // terminiert nur wenn (x-3)^2 einmal 100 ergibt. das ist nur der fall wenn x-3 = 10 wird.
            if(i > 10 && (i-10)%3 == 0) {
                System.out.println(f(i));
            }

            // terminiert nur wenn i = -100. Ansonten nähert sich x 0 an und nicht -100
            if(i == -100) {
                System.out.println(g(i));
            }

            // terminiert nur wenn x = 100 wobei x = x*x+19. da 19^2 schon >100 ist, muss die funktion schon
            // nach dem ersten aufruf terminieren folgt: 100-19 = x^2 => x = +- 9
            if(Math.abs(i) == 9 || i == 100) {
                System.out.println(h(i));
            }

            // terminiert nur wenn x negativ und eine zweiterpotenz oder
            // x=0
            // oder positiv und x+1 eine zweiterpotenz ist.
            double log2 = Math.log(Math.abs(i))/Math.log(2);
            double log2p1 = Math.log1p(Math.abs(i))/Math.log(2);
            if((i < 0 && (log2 - (int)log2) == 0)
                    || (i == 0)
                    || (i > 0 && (log2p1 - (int)log2p1) == 0)) {
                System.out.println(p(i));
            }

            System.out.println(q(i));
        }
    }
}
