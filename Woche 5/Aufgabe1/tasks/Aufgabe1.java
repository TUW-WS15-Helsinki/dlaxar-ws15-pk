import java.util.Arrays;

/*******************************************************************************
 * AUFGABENBLATT F5 - Allgemeine Informationen
 * <p>
 * Das Projekt AufgabenblattF5 besteht aus fünf Aufgaben in je einer Klasse, die
 * Sie erweitern und in den Übungen vom präsentieren können müssen.
 * <p>
 * ********************************* HINWEIS ************************************
 * Übungswoche F5 findet aufgrund Laborverfügbarkeiten über zwei Wochen statt.
 * D.h. alle Dienstag-, Mittwoch- und Freitag-Gruppen absolvieren die Übung
 * in der Woche von 11.01-15.01 in ihrem jeweiligen Slot.
 * Alle Montag- und Donnerstag-Gruppen absolvieren die Übung in der Woche von
 * 18.01-22.01 in ihrem jeweiligen Slot.
 * ******************************************************************************
 * <p>
 * Achten Sie bei der Implementierung der Klassen auf folgende Punkte:
 * <p>
 * - Einige Aufgabenstellungen sind in eine Geschichte eingebettet und auf einer
 * höheren Abstraktionsebene beschrieben als in bisherigen Übungen. Rechnen Sie
 * daher mit einem höheren Aufwand zum Verstehen der Aufgaben.
 * - Ihr Programm sollte kompilierbar und ausführbar sein.
 * - Testen und kommentieren Sie Ihre Programme ausführlich.
 * - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich
 * thematisch auf das erstellte Programm. Sie müssen diese Zusatzfragen in der
 * Übung beantworten können.
 * <p>
 * Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 11.01.2016 um
 * 06:00 Ihre Kreuzerl des aktuellen Aufgabenblattes eintragen. Nur durch
 * Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie angekreuzte
 * Aufgaben auch vorzeigen können.
 ******************************************************************************/
/*
    Aufgabe1) Sortieren & Suchen

    Implementieren Sie in der gegebenen Klasse Aufgabe1 folgende statische
    Methoden:

    - sort:      Diese Methode soll den Sortieralgorithmus "QuickSort"
                 implementieren. Sie müssen den Sortieralgorithmus selbst
                 ausimplementieren und dürfen keinen entsprechenden Aufruf aus
                 der Java-API verwenden.
    - binSearch: Dieser Methode wird ein sortiertes Array übergeben. Zusätzlich
                 erhält die Methode einen Wert nach dem gesucht werden soll. Es
                 soll eine binäre Suche implementiert werden, die true
                 zurückliefert falls das Element enthalten ist, ansonsten false.
    - sortAlternative:
        + Methode beginnt mit dem Sortiervorgang an der Position i=1 und
          vergleicht in jedem Schritt den Wert an dieser Position mit seinem
          Vorgänger (i und i-1)
        + Sind die zwei Werte in der richtigen Reihenfolge aufsteigend sortiert,
          dann wird die Position um eins erhöht.
        + Sind die zwei Werte nicht in der richtigen Reihenfolge, dann werden
          sie vertauscht. Die Position wird um eins erniedrigt, falls i>1,
          ansonsten wird die Position um eins erhöht.
        + Der Algorithmus terminiert, wenn man an der letzten Position im Array
          ankommt und die letzten beiden Werte im Array richtig sortiert sind.

    Zusatzfragen:
    1. Welche API-Aufrufe bietet Java für das Sortieren von Arrays an?
    2. Welcher Sortieralgorithmus wird in Java (1.8) für das Sortieren von
       Arrays verwendet?
    3. Warum ist die Wahl des Pivot-Elements entscheidend für die Performance
       des Quicksort Algorithmus?
    4. Warum muss das Array für die binäre Suche sortiert sein?
    5. Wie geht man vor wenn man in einem absteigend sortierten Array die
       Binärsuche anwenden will?

*/
public class Aufgabe1 {

	public static void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] a, int low, int high) {
		if (low >= high) {
			return;
		}

		int pivotIndex = (high + low) / 2;
		int pivot = a[pivotIndex];
		for (int i = low, j = high; i <= j; ) {
			while (a[i] < pivot) {
				i++;
			}

			while (a[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}

			if (low < j) {
				sort(a, low, j);
			}
			if (high > i) {
				sort(a, i, high);
			}
		}
	}

	public static boolean binSearch(int[] array, int elem) {
		return binSearch(array, elem, 0, array.length - 1);
	}

	private static boolean binSearch(int[] array, int elem, int low, int high) {
		int pivotIndex = (low + high) / 2;

		if (low > high) {
			return false;
		}

//        System.out.println(pivotIndex + ": " + array[pivotIndex] + " (" + low + ", " + high + ")");

		if (array[pivotIndex] == elem) {
			return true;
		} else if (elem < array[pivotIndex]) {
			return binSearch(array, elem, low, pivotIndex);
		} else if (elem > array[pivotIndex]) {
			return binSearch(array, elem, pivotIndex + 1, high);
		}

		return false;
	}

	// just for testing ...
	public static void main(String[] args) {
		int[] a = new int[]{0, 1, 2, 6, 5, 7, 8, 0, 3, 4, 4, 6, 7, 4, 9, 4, 6, 1};
		sort(a);
		System.out.println(Arrays.toString(a));
		for (int i = 0; i <= 10; i++) {
			System.out.println(i + ": " + binSearch(a, i));
		}
	}
}