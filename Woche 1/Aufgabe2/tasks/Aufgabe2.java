/*
    Aufgabe2) Verschachtelte Schleifen und Rekursion

    - Erweitern Sie die Klasse 'Aufgabe2' um eine statische Methode namens "drawNumDiamondIter(int h)", die einen Diamanten
    (Raute) mit Zahlen iterativ berechnet und ausgibt. Der übergebene Parameter "h" entspricht der Höhe des Diamanten (Raute).
    Ein h=9 führt zu folgender Ausgabe:

        1
       222
      33333
     4444444
    555555555
     4444444
      33333
       222
        1

    Testen Sie Ihre Methode mit weiteren Höhen für "h"! Der Rückgabetyp der Methode ist "void".

    - Implementieren Sie zusätzlich eine Methode "drawNumDiamondRec(int h)", die den Diamanten (Raute) rekursiv generieren
    soll. Sie können für die rekursive Implementierung zusätzliche Methoden anlegen.


    Zusatzfragen:
    1. Wie ist die Vorgangsweise abzuändern, wenn statt jedem Wert 1 der Buchstabe A, statt jedem Wert 2 der
    Buchstabe B, ... und statt jedem Wert 5 der Buchstabe E ausgegeben werden soll ?
    (Die Methode soll dann nur für h <= 17 funktionieren.)

    2. An welchen Stellen ist das Programm zu ändern, wenn Rauten der Form
        1
        2
       333
       444
      55555
       444
       333
        2
        1
    generiert werden sollen ?
    3. Welche Unterschiede konnten Sie zwischen der rekursiven und iterativen Implementierung feststellen?
*/
public class Aufgabe2 {

    // just for testing ...
    public static void main(String[] args) {
        System.out.println("Iterative solution:");
        drawNumDiamondIter(15);

        System.out.println("Recursive solution:");
        drawNumDiamondRec(15);
    }

    public static void drawNumDiamondRec(int h) {
        drawNumDiamondRec(h, 1);
    }

    public static void drawNumDiamondRec(int h, int start) {
        int currentWidth = 2*(start-1)+1;
        for(int n = 0; n < (h-currentWidth)/2; n++) {
            System.out.print(" ");
        }

        for(int n = 0; n < currentWidth; n++) {
            System.out.print(start);
        }

        System.out.println();
        if(start < h/2+1) {
            drawNumDiamondRec(h, start + 1);
        } else {
            return;
        }

        for(int n = 0; n < (h-currentWidth)/2; n++) {
            System.out.print(" ");
        }

        for(int n = 0; n < 2*(start-1)+1; n++) {
            System.out.print(start);
        }
        System.out.println();

    }

    public static void drawNumDiamondIter(int h) {
        int width = h;
        int n;
        int currentWidth;
        int text;
        for(int i = 0; i < h; i++) {
            text = ((i > h/2) ? h-i : i+1);
            currentWidth = ((i >= h/2) ? (h-i-1) : i) * 2 + 1;

            for(n = 0; n < (width-currentWidth)/2; n++) {
                System.out.print(" ");
            }

            for(n = 0; n < currentWidth; n++) {
                System.out.print(text);
            }

            for(n = 0; n < (width-currentWidth)/2; n++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

