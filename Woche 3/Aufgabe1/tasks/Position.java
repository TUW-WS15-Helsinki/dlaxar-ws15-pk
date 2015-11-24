/**********************************************************************************************************************

 AUFGABENBLATT F3 - Allgemeine Informationen

 Das Projekt AufgabenblattF3 besteht aus fünf Aufgaben in je einer Klasse, die Sie erweitern und in den Übungen vom
 30.11. bis 4.12. präsentieren können müssen.

 Achten Sie bei der Implementierung der Klassen auf folgende Punkte:

 - Einige Aufgabenstellungen sind in eine Geschichte eingebettet und auf einer höheren Abstraktionsebene beschrieben
   als in bisherigen Übungen. Rechnen Sie daher mit einem höheren Aufwand zum Verstehen der Aufgaben.
 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Testen und kommentieren Sie Ihre Programme ausführlich.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
   Sie müssen diese Zusatzfragen in der Übung beantworten können.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 30.11.2015 um 06:00 Ihre Kreuzerl des aktuellen
 Aufgabenblattes eintragen. Nur durch Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie
 angekreuzte Aufgaben auch vorzeigen können.

 ***********************************************************************************************************************/
/*
    Aufgabenstellung zur Klasse Position:
        Die letzten Wochen vor Weihnachten sind für Karlis Fahrradbotendienst die schwierigsten. Einerseits gibt es
        mehr Botenfahrten als im restlichen Jahr, andererseits sind die Straßenverhältnisse oft schlecht, und angeblich
        bleibt immer wieder einmal ein Fahrradbote an einem Punschstand hängen. Dadurch erreicht so manche Sendung den
        Empfänger nicht wie zugesichert innerhalb einer Stunde, wobei Fahrten nur zwischen 8:00 und 18:00 Uhr erfolgen.
        Um die Ursachen von Zustellproblemen leichter ermitteln zu können, werden die Radfahrer mit GPS-Trackern
        ausgestattet, die nach jeder Fahrt ausgewertet werden. Das Auslesen eines GPS-Trackers gibt ein Array von
        Objekten der hier implementierten Klasse 'Position' zurück. Für ca. jede Minute der Fahrt gibt es einen Eintrag
        im Array, chronologisch sortiert. Jeder Array-Eintrag enthält Informationen zur Uhrzeit (als Anzahl der seit
        Mitternacht vergangenen Sekunden) und der genauestmöglichen Position in Wien und Umgebung, dargestellt durch
        Longitude (also der geographischen Länge im Wertebereich von etwa 15.0 bis 17.0) und Latitude (geographischer
        Breite etwa zwischen 47.0 und 49.0). Methoden von 'Position' sollen bei der Auswertung der Daten helfen und
        sich den Kommentaren entsprechend verhalten.

    Zusatzfragen:
    1. Welche Teile der Aufgabenstellung beeinflussen welche Teile der Lösung auf welche Weise?
       Welche Teile der Aufgabenstellung haben dagegen keinen Einfluss auf die Lösung?
    2. Warum sollen Objektvariablen als private deklariert sein?
    3. Woran kann man einen Konstruktor erkennen?
    4. Warum ist isStopped als static definiert, isClose und isCloseToPath aber nicht?
    5. Warum erlauben die Vergleiche einen Abstand eps zwischen Standorten (statt einfacher Vergleiche mittels ==)?
*/
public class Position {

    // TODO: Object variables shall be declared here.
    private int timestamp;
    private double lat;
    private double lng;

    // TODO: A public constructor for Position shall be declared here, providing values for all object variables.
    public Position(int timestamp, double lat, double lng) {
        this.timestamp = timestamp;
        this.lat = lat;
        this.lng = lng;
    }

    // Returns true if (and only if) longitude and latitude of this position (the current object) differ from
    // longitude and latitude of x by at most eps.
    public boolean isClose(Position x, double eps) {
        // TODO: Implementation is your task.
        eps = Math.abs(eps);
        double v = this.getLat() - x.getLat();
        double v1 = this.getLng() - x.getLng();
        System.out.println(v + ", " + v1);
        return Math.abs(v) <= eps && Math.abs(v1) <= eps;
    }

    // Returns true if (and only if) longitude and latitude of this position (the current object) differ from
    // longitude and latitude of any element in xs by at most eps.
    public boolean isCloseToPath(Position[] xs, double eps) {
        // TODO: Implementation is your task.
        for(Position x : xs) {
            if(this.isClose(x, eps)) {
                return true;
            }
        }
        return false;
    }

    // Parameter xs contains the positions of a tour. A tour is regarded as being stopped at a position in the array
    // if this position is close (difference at most eps) to each of the following 4 positions in the array.
    // The method returns the time (in seconds since midnight) of the first stop (lowest index in the array),
    // or -1 if there is no stop.
    public static int isStopped(Position[] xs, double eps) {
        // TODO: Implementation is your task.
        int stopCount = 0;
        for(int i = 0; i < xs.length; i++) {
            stopCount = 0;
            for(int n = i+1; n < i+5 && n < xs.length; n++) {
                if(xs[i].isClose(xs[n], eps)) {
                    stopCount++;
                }
            }

            if(stopCount == 4) {
                return xs[i].getTimestamp();
            }
        }

        return -1;
    }

    // Returns true if (and only if) the time of the position at each index i (0 < i < xs.length) is at least min and
    // at most max higher than that at index i - 1.
    public static boolean chronologic(Position[] xs, int min, int max) {
        // TODO: Implementation is your task.
        for(int i = 1; i < xs.length; i++) {
            int diff = Math.abs(xs[i].getTimestamp() - xs[i-1].getTimestamp());
            if(diff < min || diff > max) {
                return false;
            }
        }

        return true;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
        Position a = new Position(-1, 15, 0);
        Position b = new Position(1, 15.1, 4);
        Position c = new Position(2, 1, 1);
        Position d = new Position(3, 1, 0);
        Position e = new Position(4, 1, -.1);
        Position f = new Position(5, 1, -.2);
        Position g = new Position(6, 1, -.3);
        Position h = new Position(7, 1, -4);
        System.out.println(Position.isStopped(new Position[]{a, b, c, d, e, f, g, h}, 3));
    }
}
