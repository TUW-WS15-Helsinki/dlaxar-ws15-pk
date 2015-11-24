import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
    Aufgabenstellung zur Klasse District:

    Karlis Fahrradbotendienst hat die Stadt in verschiedene Distrikte (engl. District) eingeteilt. Pro Distrikt
    gibt es eine Sammelstelle, in der sich Fahrer treffen und auf Aufträge warten. Führt ein Auftrag von einem
    Distrikt in einen anderen, kommt der Fahrer nach Erledigung des Auftrags zur Sammelstelle des Distrikts, in dem
    die Fahrt endet. Dort wartet der Fahrer auf einen Auftrag. Fahrer erhalten Aufträge in der Reihenfolge, in der
    Sie in der Sammelstelle eingetroffen sind. Manchmal kommt es zu ungleichen Auslastungen. Dann muss ein Fahrer, der
    als nächster eine Fahrt zu absolvieren hätte, in einen anderen Distrikt wechseln. Damit es zu keinen
    Ungerechtigkeiten kommt, wird ein solcher Fahrer gleich nach Eintreffen ganz nach vorne gereiht.

    Simulieren Sie diese Vorgehensweise in der Klasse District:
    Ein Objekt der Klasse erhält den Namen des Distrikts über einen Konstruktor. Es wird eine Uhr mitgeführt.
    Folgende Methoden werden benötigt:

    - tick:   Diese parameterlose Methode schaltet die Uhr um zehn Minuten weiter. Die Uhr startet mit 08:00 Uhr
              (Betriebsbeginn) und stoppt mit 18:00 Uhr (kann danach nicht mehr erhöht werden). Ausgaben der
              Uhrzeit erfolgen im Format hh:mm (je zwei Ziffern für Stunden und Minuten, getrennt durch :).

    - arrive: Ein Fahrer (Name als String-Parameter übergeben) trifft in der Sammelstelle des Distrikts ein.
              Eine Ausgabe wird gemacht: "Um <Uhrzeit> ist <Name des Fahrers> in <Name des Distrikts> eingetroffen."

    - help:   Ein Fahrer (Name als String-Parameter übergeben) trifft in der Sammelstelle des Distrikts ein, weil er
              von einem anderen Distrikt hierher gewechselt hat um auszuhelfen. Es wird dieselbe Ausgabe gemacht wie
              bei arrive.

    - job:    Ein Auftrag ist eingetroffen. Der Distrikt des Ziels der Fahrt wird als Parameter übergeben. Wenn kein
              Fahrer verfügbar ist, wird als Ergebnis false zurückgegeben, andernfalls true. Eine Ausgabe wird
              gemacht, entweder: "Um <Uhrzeit> Auftrag ohne Fahrer in <Name des Distrikts>."
              oder: "Um <Uhrzeit> fährt <Name des Fahrers> von <Name des Distrikts> nach <Name des Distrikts>."
              Dieselbe Methode wird verwendet, wenn ein Fahrer in einen anderen Distrikt wechseln soll.

    Verwenden Sie in District KEIN Array, sondern ein Objekt vom Typ Queue bzw. Deque.

    Schreiben Sie in District eine Methode main, die ein Gesamtszenario simuliert. Es sollen mehrere Distrikte erzeugt
    und mehrere Fahrer zwischen ihnen hin und her geschickt werden. Auch tick ist regelmäßig aufzurufen. In den
    entstehenden Bildschirmausgaben sollen alle wesentlichen unterschiedlichen Fälle sichtbar werden.

    Zusatzfragen:
    1. Was unterscheidet Queue von Deque?
    2. Was versteht man unter dem FIFO- bzw. LIFO-Prinzip?
    3. Welche dieser Methoden sind static, welche nicht? Warum ist das so?
*/
public class District {

    private Clock clock;
    private Deque<String> drivers;

    private final String name;

    // TODO: All necessary object variables, constructors and methods shall be declared or defined here.


    public District(String name) {
        this.name = name;
        this.drivers = new ArrayDeque<String>();
    }

    public String getName() {
        return name;
    }

    public void arrive(String name) {
        drivers.offer(name);
        System.out.println("Um " + this.clock + " ist " + name + " in " + this + " eingetroffen.");
    }

    public void help(String name) {
        drivers.offerFirst(name);
        System.out.println("Um " + this.clock + " ist " + name + " in " + this + " eingetroffen.");
    }

    public boolean job(District destination) {
        if(drivers.size() <= 0) {
            System.out.println("Um " + this.clock + " Auftrag ohne Fahrer in " + destination);
            return false;
        }

        System.out.println("Um " + this.clock + " fährt " + drivers.poll() + " von " + this + " nach " + destination + ".");
        return true;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    @Override
    public String toString() {
        return "District: '" + this.name + "'";
    }

    public static void main(String[] args) {
        Clock c = new District.Clock();
        int NUM_DISTRICTS = 5;
        District districts[] = new District[NUM_DISTRICTS];
        for(int i = 0; i < NUM_DISTRICTS; i++) {
            districts[i] = new District("#" + i);
            districts[i].setClock(c);
        }

        c.tick();
        c.tick();

        districts[0].arrive("Mike");
        districts[0].arrive("Mark");
        districts[0].job(districts[1]);
        districts[0].job(districts[2]);
        districts[0].job(districts[3]);
        c.tick();
        c.tick();
        districts[1].arrive("Mike");
        districts[2].help("Mark");
        c.tick();
        c.tick();


    }

    private static class Clock {
        int minutesSinceMidnight;

        public Clock() {
            // default to 8am
            this(8 * 60);
        }

        public Clock(int minutesSinceMidnight) {
            this.minutesSinceMidnight = minutesSinceMidnight;
        }

        public void tick() {
            // default to tick 10 mintues
            this.tick(10);
        }

        public void tick(int minutes) {
            if(this.minutesSinceMidnight + minutes < 18*60) {
                this.minutesSinceMidnight += minutes;
            }
        }

        @Override
        public String toString() {
            int hours = minutesSinceMidnight/60;
            int minutes = minutesSinceMidnight%60;

            return (hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes;
        }
    }
}
