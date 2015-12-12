/*******************************************************************************

 AUFGABENBLATT F4 - Allgemeine Informationen

 Das Projekt AufgabenblattF4 besteht aus fünf Aufgaben in je einer Klasse, die
 Sie erweitern und in den Übungen vom 14.12. bis 18.12. präsentieren können
 müssen.

 Achten Sie bei der Implementierung der Klassen auf folgende Punkte:

 - Einige Aufgabenstellungen sind in eine Geschichte eingebettet und auf einer
 höheren Abstraktionsebene beschrieben als in bisherigen Übungen. Rechnen Sie
 daher mit einem höheren Aufwand zum Verstehen der Aufgaben.
 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Testen und kommentieren Sie Ihre Programme ausführlich.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich
 thematisch auf das erstellte Programm. Sie müssen diese Zusatzfragen in der
 Übung beantworten können.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 14.12.2015 um
 06:00 Ihre Kreuzerl des aktuellen Aufgabenblattes eintragen. Nur durch
 Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie angekreuzte
 Aufgaben auch vorzeigen können.

 ******************************************************************************/
/*
    Aufgabe1) Char-Stack als einfach verketteter Liste

    In Aufgabe1 soll ein Character-Stack mittels einfach-verkettete Liste
    realisiert werden. Der char-Stack wird verwendet um Klammerausdrücke zu
    überprüfen. Für die Realisierung des Stacks werden zwei Klassen benötigt,
    die als separate Files realisiert sind.

    CharStackNode: Diese Klasse bildet einen Knoten (ein Element) des Stacks ab.
                   Dieser Knoten (Klasse) besitzt zwei Membervariablen. Die
                   erste Variable speichert den Character und die zweite
                   Variable zeigt auf das nachfolgende Element im Stack (Liste).
                   Methoden der Klasse:
                   - CharStackNode(...,...): Konstruktor der Klasse
                   - getElem(): Gibt das Element (char) des Knotens zurück.
                   - getNext(): Gibt den nächsten Knoten des Stacks (Liste)
                                zurück.

    CharStack: Diese Klasse realisiert den Stack und besitzt eine
               Membervariable. Diese Variable zeigt auf den ersten bzw. obersten
               Knoten (Element) des Stacks. Methoden der Klasse:
               - isEmpty(): Prüft ob der Stack leer ist und gibt einen boolean
                            zurück.
               - push(): Die Methode bekommt einen char übergeben und legt
                         diesen auf dem Stack ab.
               - pop(): Die Methode nimmt das Element (Knoten) vom Stack
                        herunter und gibt den gelesenen Wert (char) zurück.

    Aufgabe1: Implementieren Sie in der Klasse "Aufgabe1" eine statische Methode
              "check", die eine Klammersequenz mit runden Klammern () überprüft.
              Das heißt jeder öffnenden Klammer muss eine schließende Klammer
              gegenüber stehen und nach Abarbeitung aller Klammern muss der
              Stack leer sein. Der Methode wird die Klammersequenz als String
              übergeben. Die Methode gibt true zurück falls die Klammerung
              stimmt, ansonsten false.

    Zusatzfragen:
    1. Welche Vorteile bieten die Java-Datenstrukturen gegenüber der eigenen
       Implementierung?

*/
public class Aufgabe1 {

    private static boolean check(String sequenz){
        CharStack stack = new CharStack();
        for(char c : sequenz.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String seq_true = "(())()((()))";
        String seq_false = "((())())(";
        System.out.println(check(seq_true));
        System.out.println(check(seq_false));
    }
}