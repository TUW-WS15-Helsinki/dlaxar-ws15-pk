import java.util.*;

/*
    Aufgabenstellung zur Klasse StreetMap:

    Um die Suche nach einer Zieladresse zu erleichtern, haben die Fahrer in Karlis Fahrradbotendienst einen einfachen
    elektronischen Stadtplan bei sich: Nach Eingabe einer Adresse erscheinen der Name des entsprehenden Distrikts und
    die GPS-Koordinaten. Objekte der Klasse StreetMap stellen einen wesentlichen Teil des Stadtplans dar.
    Vervollständigen Sie die Implementierung, so wie in den Kommentaren beschrieben.

    Bitte verwenden Sie in der Implementierung von StreetMap KEIN Array, sondern nur Objekte von Typen wie Queue, Deque
    und Map (neben MapData - siehe unten).

    Zusatzfragen:
    1. Wieso ist die zusätzliche Klasse MapData sinnvoll?
    2. Wie werden die Daten in MapData zugreifbar? Geht das auch, wenn die Objektvariablen private sind?
    3. Wofür ist Queue besser geeignet, wofür Map?
    4. Warum ist Double mit großem Anfangsbuchstaben geschrieben (nicht double)?
    5. Sollte MapData auch die Adresse enthalten? Warum?
*/

public class StreetMap {

    // TODO: Object variables shall be declared here.
    Map<String, MapData> mapByAddr;

    // The parameters specify the initial contents of a street map:
    //     addr:  addresses that can be found in the street map
    //     distr: names of the districts of corresponding addresses
    //     lon:   longitudes in the GPS coordinates
    //     lat:   latitude in the GPS coordinates
    // All queues in the parameters are of the same size.
    // All entries at the same position (1st, 2nd, 3rd, ...) belong together.
    public StreetMap(Queue<String> addr, Queue<String> distr, Queue<Double> lon, Queue<Double> lat) {
        // TODO: Implementation is your task.
        Iterator<String> iAddr = addr.iterator();
        Iterator<String> iDistr = distr.iterator();
        Iterator<Double> iLon = lon.iterator();
        Iterator<Double> iLat = lat.iterator();
        mapByAddr = new HashMap<String, MapData>();

        while(iAddr.hasNext()) {
            String address = iAddr.next();
            mapByAddr.put(address, new MapData(address, iDistr.next(), iLon.next(), iLat.next()));
        }
    }

    // Returns all data (district and GPS coordinates) for address addr.
    // Returns null if no data can be found for this address.
    public MapData find(String addr) {
        // TODO: Implementation is your task.
        return mapByAddr.get(addr);
    }

    // Returns all data (district and GPS coordinates) for all known address that begin with addrPart.
    public Queue<MapData> findAll(String addrPart) {
        // TODO: Implementation is your task.
        Queue<MapData> memo = new ArrayDeque<MapData>();
        for(String key : mapByAddr.keySet()) {
            if(key.startsWith(addrPart)) {
                memo.offer(mapByAddr.get(key));
            }
        }

        return memo;
    }

    // Returns true if (and only if) address addr is in district distr.
    public boolean inDistrict(String addr, String distr) {
        // TODO: Implementation is your task.
        return (mapByAddr.get(addr) != null && mapByAddr.get(addr).getDistrict().equals(distr));
    }

    // Adds a new address addr to the street map, where newData are the data to be associated with this address.
    // However, if the address already exists, the old data are replaced with newData.
    // true is returned if the address was replaced, false if a new address was added.
    public boolean newData(String addr, MapData newData) {
        // TODO: Implementation is your task.
        return mapByAddr.put(addr, newData) != null;
    }

    // To test the implementation several objects of StreetMap (each with several addresses) are created,
    // all methods are called, and data associated with found addresses are printed.
    public static void main(String[] args) {
        // TODO: Implementation is your task.
        Queue<String> addr = new PriorityQueue<String>();
        Queue<String> distr = new PriorityQueue<String>();
        Queue<Double> lat = new PriorityQueue<Double>();
        Queue<Double> lng = new PriorityQueue<Double>();

        addr.offer("Getreidemarkt 9-11"); distr.offer("1040"); lat.offer(0d); lng.offer(0d);
        addr.offer("TU Hauptgebäude"); distr.offer("1040"); lat.offer(1d); lng.offer(1d);
        addr.offer("TU Freihaus"); distr.offer("1040"); lat.offer(2d); lng.offer(2d);
        addr.offer("Stephansplatz"); distr.offer("1010"); lat.offer(3d); lng.offer(3d);

        StreetMap sm = new StreetMap(addr, distr, lat, lng);

        System.out.println("Trying to add an existing address:");
        System.out.println(sm.newData("Stephansplatz", new MapData("Stephansplatz", "1010", 3, 3)));

        System.out.println("Trying to add a new address (should give false):");
        System.out.println(sm.newData("Institut für Informatik", new MapData("Institut für Informatik", "1100", 4, 4)));

        System.out.println("Retrieving data");
        System.out.println(sm.find("Institut für Informatik"));

        System.out.println("Find by beginning");
        System.out.println(sm.findAll("TU"));

        System.out.println("Institut für Inf in 1200");
        System.out.println(sm.inDistrict("Institut für Informatik", "1200"));
    }
}

// Objects of MapData hold all data (district and GPS coordinates) associated with an address in the street map.
// It is necessary to get access to the data in objects of this type.
class MapData {
    // TODO: Implementation is your task.
    private final String addr;
    private final String district;
    private final double lat;
    private final double lng;

    public MapData(String addr, String district, double lat, double lng) {
        this.addr = addr;
        this.district = district;
        this.lat = lat;
        this.lng = lng;
    }

    public String getAddr() {
        return addr;
    }

    public String getDistrict() {
        return district;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return addr + ", " + district + ", (" + lat + "/" + lng + ")";
    }
}
