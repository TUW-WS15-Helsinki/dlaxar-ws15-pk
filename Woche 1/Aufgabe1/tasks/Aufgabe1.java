import java.util.Stack;

/**********************************************************************************************************************

 AUFGABENBLATT F1 für fortgeschrittene Übungsgruppen - Allgemeine Informationen

 Das Projekt AufgabenblattF1 besteht aus fünf Aufgaben in den Klassen Aufgabe1 bis Aufgabe5, die Sie erweitern und in
 den Übungen vom 16.11. bis 20.11. präsentieren können müssen.

 Achten Sie bei der Implementierung von Aufgabe1-Aufgabe5 auf folgende Punkte:

 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Testen und kommentieren Sie Ihre Programme ausführlich.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
   Sie müssen diese Zusatzfragen in der Übung beantworten können.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 16.11.2015 um 06:00 Ihre Kreuzerl des aktuellen
 Aufgabenblattes eintragen. Nur durch Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie
 angekreuzte Aufgaben auch vorzeigen können.

***********************************************************************************************************************/
/*
    Aufgabe1) Mehrfache Rekursion versus einfache Iteration

    Implementieren Sie in Aufgabe1 je eine iterative (iter) und eine rekursive (rec) statische Methode, die für eine
    ganze nicht-negative Zahl n die Zahl L(n) berechnet. L(n) ist definiert durch:

        L(0) = 1
        L(1) = 1
        L(n) = L(n - 1) + L(n - 2) + 1  wenn  n > 1.

    Rufen Sie in main die Methoden iter und rec mit allen Zahlen von 0 bis 50 auf und geben Sie die Ergebnisse aus.
    Ein Programmaufruf soll in weniger als einer Sekunde terminieren.

    Hinweis: Eine simple, nahe an die Definition angelehnte rekursive Implementierung kann sehr ineffizient werden.
    Suchen Sie daher nach einer effizienteren Implementierungsmöglichkeit, die jedoch ohne Schleifen auskommen muss.
    Sie können z.B. Hilfsmethoden (ohne Schleifen) und/oder ein Array verwenden.

    Zusatzfragen:
    1. Welche Vor- und Nachteile hat iter im Vergleich zu rec?
    2. Welcher elementare Typ ist als Ergebnistyp dieser Methoden geeignet? Warum nur dieser?
    3. Welche elementaren Typen sind als Parametertypen geeignet? Warum?
    4. Welche alternativen Implementierungstechniken würde es geben?
       Aufgrund welcher Tatsachen haben Sie die von Ihnen verwendete(n) Implementierungstechnik(en) gewählt?
*/
public class Aufgabe1 {

    public static long[] cache;

    // invokes iter as well as rec with all integers from 0 to 50 and prints the results
    // (without empty lines or other output)
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        cache = new long[50];

        for(int i = 0; i <= 50; i++) {
            System.out.println(recursive(i));
            System.out.println(iterative(i));
        }
        System.out.println(System.currentTimeMillis()-start + "ms");
    }

    public static long iterativeStack(int n) {
        long sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(n);
        do {
            if(stack.peek() <= 1) {
                sum += 1;
                stack.pop();
            } else {
                sum += 1;
                n = stack.pop();
                stack.push(n - 1);
                stack.push(n - 2);
            }

        } while(stack.size() > 0);

        return sum;
    }

    public static long iterativeInsane(int n) {
        long a = 1;
        long b = 1;
        long sum;

        while(n-- > 0) {
            sum = a + b + 1;
            a = b;
            b = sum;
        }

        return a;
    }

    public static long iterative(int n) {
        if(n <= 1) {
            return 1;
        }
        long[] a = new long[n+1];
        a[0] = 1;
        a[1] = 1;
        int p = 2;
        while(p <= n) {
            a[p] = a[p-1] + a[p-2] + 1;
            p++;
        }
        return a[n];
    }

    public static long recursive(int n) {
        if(n <= 1) {
            return 1;
        }

        if(cache[n-1] <= 0) {
            cache[n-1] = recursive(n-1);
        }

        if(cache[n-2] <= 0) {
            cache[n-2] = recursive(n-2);
        }

        return cache[n-1] + cache[n-2] + 1;
    }
}
