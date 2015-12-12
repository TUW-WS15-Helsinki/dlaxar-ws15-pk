/*
    Aufgabe5) Bäume

    In der Klasse StringTree haben Sie eine Baumimplementierung gegeben, die
    analog zu Aufgabe4 einen sortierten Binärbaum abbildet. Nun wird anstatt
    eines int-Elements ein String in jedem Knoten abgelegt.

    Jede Veränderung des Baumes durch eine Methode muss gewährleisten, dass
    dieser sortiert bleibt. Dazu sollen Sie folgende zusätzliche Methoden
    implementieren:

    - add:              Fügt einen Knoten in den Baum ein. Die Strings werden
                        sortiert nach ihrer lexikografischen Ordnung in den Baum
                        eingefügt. Hinweis: Sie können dazu
                        String.compareTo(...) verwenden. Werden folgende
                        Elemente {"Mama", "Hugo", "Kasten", "Nordpol", "Haus",
                        "Nase", "Insel", "Natrium"} nacheinander in den Baum
                        eingefügt, wird folgender Baum aufgebaut:
                                                Mama
                                          /             \
                                       Hugo            Nordpol
                                    /       \          /
                                 Haus     Kasten     Nase
                                          /             \
                                       Insel          Natrium
    - height:           Liefert die Höhe des Baumes zurück. Der leere Baum hat
                        die Höhe 0. Hat der Baum nur einen Knoten (Wurzel), dann
                        hat er die Höhe 1. Mit jeder zusätzlichen Stufe von
                        Nachfolgern erhöht sich die Höhe um 1. Der oben gezeigte
                        Baum hat die Höhe 4.
    - printLeaves:      Diese Methode gibt die Elemente der Blattknoten aus,
                        wobei das linke Blatt immer vor dem rechten Blatt
                        ausgegeben wird. Verwenden Sie an entsprechender Stelle
                        für die Ausgabe -> System.out.println(this.elem);
    - printInOrderUpSub:Diese Methode gibt alle Elemente eines Teilbaums in
                        aufsteigender Reihenfolge aus. Dazu wird der Methode ein
                        Element übergeben, welches dem Wurzelknoten des
                        Teilbaums entspricht. Nun wird der komplette Teilbaum
                        inklusive Wurzel ausgegben. Verwenden Sie an
                        entsprechender Stelle für die
                        Ausgabe -> System.out.println(this.elem);
    - printPostOrder:   Diese Methode gibt alle Elemente in der sogenannten
                        Post-Order aus. Die Post-Order für den oben abgebildeten
                        Baum ergibt folgende Reihenfolge (Haus,Insel,Kasten,
                        Hugo,Natrium,Nase,Nordpol,Mama). Verwenden Sie an
                        entsprechender Stelle für die
                        Ausgabe -> System.out.println(this.elem);
    - printPreOrder:    Diese Methode gibt alle Elemente in der sogenannten
                        Pre-Order aus. Die Pre-Order für den oben abgebildeten
                        Baum ergibt folgende Reihenfolge (Mama,Hugo,Haus,Kasten,
                        Insel,Nordpol,Nase,Natrium). Verwenden Sie an
                        entsprechender Stelle für die
                        Ausgabe -> System.out.println(this.elem);
    - printLevelOrder:  Diese Methode gibt alle Elemente in der sogenannten
                        Level-Order aus. Die Level-Order bildet den Baum Level
                        für Level ab. Der oben stehende Baum produziert folgende
                        Ausgabe:       Mama
                                       Hugo Nordpol
                                       Haus Kasten Nase
                                       Insel Natrium

    Zusatzfragen:
    1. Falls die Elemente beim Einfügen in den Baum in ungünstiger Reihenfolge
       auftreten, könnte im schlimmsten Fall ein entarteter Baum entstehen. Wie
       würde dieser für unser Beispiel in der Angabe aussehen?

*/
public class Aufgabe5 {

    public static void main(String[] args) {

        String [] mytestarray = new String[]{"Mama", "Hugo", "Kasten",
                                             "Nordpol", "Haus", "Nase",
                                             "Insel", "Natrium"};
        StringTree myTree = new StringTree();
        for(int i = 0; i < mytestarray.length; i++){
            myTree.add(mytestarray[i]);
        }

        System.out.println("Height***********");
        System.out.println(myTree.height());
        System.out.println("Leaves***********");
        myTree.printLeaves();
        System.out.println("InOrderUpSub*****");
        myTree.printInOrderUpSub("Hugo");
        System.out.println("PostOrder********");
        myTree.printPostOrder();
        System.out.println("PreOrder*********");
        myTree.printPreOrder();
        System.out.println("LevelOrder*******");
        myTree.printLevelOrder();


    }
}
