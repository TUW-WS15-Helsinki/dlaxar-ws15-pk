/*
    Aufgabe5) dynamisches versus statisches Binden

    Implementieren Sie folgende Hierarchie:

         interface MeerestierIF
         /   |     \         \
    Koralle Fisch Saeugetier Schildkroete

    D.h. Koralle, Fisch, .. usw. implementieren alle das Interface MeerestierIF.

    Sie sollen eine Archivverwaltung eines Museums implementieren.

    Schreiben Sie dazu eine Implementierung des Interfaces ArchivIF (Name selbst
    wählen), in dem eine Liste von Meerestieren gespeichert wird. Sie dürfen die
    Methodensignaturen der Interfaces nicht verändern.

    Die Methoden sollen sich folgendermaßen verhalten:
	- void registrieren(MeerestierIF m);
	  Fuegt ein Meerestier im Archiv auf Regal 0 hinzu.

	- void ausraeumen();
	  Raeumt alle Tiere bis auf Saeugetiere aus
	  (= ins Regal 0 geben)

	- void einordnen();
	  Ordnet alle Tiere der Reihe nach in Regalnummern,
	  allerdings sind Saeugetiere in den Regalen ab 100
	  und Fische ab den Regalen 200
	  (einfach 100 respektive 200 zu dem Index hinzugeben)

    - void neuWiegen(int gewicht[]);
	  Wiegt alle Tiere neu.
	  Allerdings gibt es einen systematischen Fehler
	  bei Schildkröten. Diese wiegen tatsächlich um 10%
	  weniger als die Waage angzeigt hat (der Wert im Array).
	  Sauegetiere werden immer in Tonnen gewogen.
	  Korallen haben immer ein Kilogramm, unabhängig vom
	  Wert im Array.

    Achtung! Es darf kein if, instanceof, getClass() o.ä. verwendet werden um
    die beschriebenen Unterschiede auszuprogrammieren. Stattdessen soll
    ausschließlich dynamisches Binden verwendet werden!

    Eigenschaften der Tiere sollen in den Klassen Koralle, Fisch, Saeugetier und
    Schildkroete gespeichert werden. Bei Korallen soll es keine Eigenschaft
    Gewicht geben.

    Es soll möglich sein, das ganze Archiv mit System.out.println(archiv)
    auszugeben. Dabei soll jedes Tier in einer Zeile geschrieben werden. Wenn
    das Archiv leer ist, soll toString() "Leeres Archiv" ausgeben.

    Initial (in createArchiv()) sollen die Tiere so angelegt werden, dass
    folgende Ausgabe entsteht (einfach Tiere explizit so erzeugen, dass diese
    Zahlen gespeichert sind und ausgegeben werden):
    Hering, Regal 250, Gewicht 20kg
    Walhai, Regal 280, Gewicht 2050kg
    Kaiserfisch, Regal 1220, Gewicht 20kg
    Meeresschildkroete, Regal 33, Gewichtsklasse 20kg
    Wal, SpezialRegal (Saeugetier) 20004, Gewicht 20000kg
    Lederkoralle, Regal 40, Gewicht 1000g
    Feuerkoralle, Regal 41, Gewicht 1000g

    Wird nach der Initialisierung ausraeumen() durchgeführt, soll danach
    folgendes ausgegeben werden:
    Hering, Regal 0, Gewicht 20kg
    Walhai, Regal 0, Gewicht 2050kg
    Kaiserfisch, Regal 0, Gewicht 20kg
    Meeresschildkroete, Regal 0, Gewichtsklasse 20kg
    Wal, SpezialRegal (Saeugetier) 20004, Gewicht 20000kg
    Lederkoralle, Regal 0, Gewicht 1000g
    Feuerkoralle, Regal 0, Gewicht 1000g

    Nach einer weiteren Durchführung von einordnen():
    Hering, Regal 201, Gewicht 20kg
    Walhai, Regal 202, Gewicht 2050kg
    Kaiserfisch, Regal 203, Gewicht 20kg
    Meeresschildkroete, Regal 4, Gewichtsklasse 20kg
    Wal, SpezialRegal (Saeugetier) 105, Gewicht 20000kg
    Lederkoralle, Regal 6, Gewicht 1000g
    Feuerkoralle, Regal 7, Gewicht 1000g

    Und wenn danach alle Tiere neu gewogen werden {23,2100, 40, 23, 30, 3, 0}:
    Hering, Regal 201, Gewicht 23kg
    Walhai, Regal 202, Gewicht 2100kg
    Kaiserfisch, Regal 203, Gewicht 40kg
    Meeresschildkroete, Regal 4, Gewichtsklasse 20kg
    Wal, SpezialRegal (Saeugetier) 105, Gewicht 30000kg
    Lederkoralle, Regal 6, Gewicht 1000g
    Feuerkoralle, Regal 7, Gewicht 1000g

    Erweitern Sie das Interface ArchivIF (und entsprechende Klassen) um die
    Methode ausborgen(MeerestierIF). Damit soll es möglich sein, dass Tiere
    zwischen Archiven verborgt werden können. Für die Rückgabe erweitern Sie das
    Interface MeerestierIF (und entsprechende Klassen) um die Methode
    zurueckgeben(), die das Tier wieder in das Ausgangsarchiv verschiebt.
    Dabei soll es möglich sein, dass Tiere weitergeborgt werden können, aber
    beim zurückgeben kommen sie immer zu ihrem Ausgangsarchiv. Wechselt ein Tier
    das Archiv, kommt es ins Regal 0, behält aber sein Gewicht.

    Zusatzfragen:
    1. Wie könnte man die Programmieraufgabe mit statischem Binden lösen?
    2. Verwendet ein Interface dynamisches Binden?

*/

import java.util.ArrayList;
import java.util.List;

class Archive implements ArchivIF {
	List<MeerestierIF> archive;

	public Archive() {
		this.archive = new ArrayList<>();
	}

	@Override
	public void registrieren(MeerestierIF m) {
		archive.add(m);
	}

	@Override
	public void ausraeumen() {
		for(MeerestierIF m : archive) {
			m.ausraeumen();
		}
	}

	@Override
	public void einordnen() {
		int i = 1;
		for(MeerestierIF m : archive) {
			m.einordnen(i++);
		}
	}

	@Override
	public void neuWiegen(int[] gewicht) {
		int i = 0;
		for(MeerestierIF m : archive) {
			if(i >= gewicht.length) {
				throw new RuntimeException("We need a weight for every single animal");
			}
			m.abwiegen(gewicht[i++]);
		}
	}

	@Override
	public void ausborgen(MeerestierIF m) {
		m.wirdAusgeborgtVon(this);
		registrieren(m);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(MeerestierIF m : archive) {
			sb.append(m.toString()).append(System.lineSeparator());
		}
		return sb.toString();
	}
}

public class Aufgabe5 {

	static MeerestierIF whale;

	static ArchivIF createArchiv() {
		ArchivIF a = new Archive();

		a.registrieren(new Fish("Hering", a, 250, 20000));
		a.registrieren(new Fish("Walhai", a, 280, 2050000));
		a.registrieren(new Fish("Kaiserfisch", a, 1220, 20000));
		a.registrieren(new Turtle("Meeresschildkröte", a, 33, 20000));
		a.registrieren(whale = new Mammal("Wal", a, 20004, 20000000));
		a.registrieren(new Coral("Lederkoralle", a, 40));
		a.registrieren(new Coral("Feuerkoralle", a, 41));

		return a;
	}

	// just for testing ...
	public static void main(String[] args) {
		ArchivIF a = createArchiv();
		System.out.println(a);
		a.ausraeumen();
		System.out.println(a);
		a.einordnen();
		System.out.println(a);
		a.neuWiegen(new int[]{23,2100, 40, 23, 30, 3, 0});
		System.out.println(a);

		ArchivIF x = new Archive();
		// todo because of the parameters/methods/interfaces
		// its not able to un-register at the archive.
		x.ausborgen(whale);

		System.out.println(x);

		whale.zurueckgeben();

		System.out.println(x);
	}
}
