/*
    Aufgabe4) toString, equals, hashCode implementieren

    Implementieren Sie die Klasse Person mit folgenden Eigenschaften:

    - Vorname
    - Nachname
    - Geschlecht
    - Alter (als Zahl)
    - Sozialversicherungsnummer (als vierstellige Zahl)
    - Liste aller Kinder dieser Person (Es kann beliebig viele Kinder,
      aber auch gar kein Kind geben.)

    Person soll keine Klasse sondern ein Interface sein. Nennen Sie das
    Interface PersonIF und verwenden dieses in der Klasse Person.
    Abgesehen von der Liste der Kinder sollen alle Eigenschaften im Konstruktor
    festgelegt werden. Vermeiden Sie unnötige "setter"-Methoden!

    Um ein Kind hinzufügen zu können, implementieren Sie die Methode:

      void neuesKind(PersonIF p);

    Stellen Sie sicher, dass die Ausgabe eines Objekts vom Typ Person
    mittels System.out.println(person) folgende Beschreibung dieser Person
    liefert (Implementierung von toString()):

    # <Vorname> <Nachname>, <Geschlecht>, <Alter> Jahre, Svnr: <SV-Nummer>

    Hat eine Person Kinder, so werden auch rekursiv alle Kinder dieser
    Person (sowie auch alle darunterliegenden Hierarchieebenen) bei der
    Ausgabe berücksichtigt. Jede Ebene wird mit einem Leerzeichen
    eingerückt, z.B:

    # <Vorname> <Nachname>, <Geschlecht>, <Alter> Jahre, Svnr: <SV-Nummer>
     # <Vorname Kind1> <Nachname Kind1>, <Geschlecht Kind1>, <Alter Kind1> Jahre, Svnr: <SV-Nummer Kind1>
     # <Vorname Kind2> <Nachname Kind2>, <Geschlecht Kind2>, <Alter Kind2> Jahre, Svnr: <SV-Nummer Kind2>
      # <Vorname Kind1 von Kind2> <Nachname Kind1 von Kind2>, <Geschlecht Kind1 von Kind2>, <Alter Kind1 von Kind2> Jahre, Svnr: <SV-Nummer Kind1 von Kind2>

    Implementieren Sie createHubert() so, dass die zurückgelieferte Person
    folgende Ausgabe hat:

    # Hubert Maier, maennlich, 88 Jahre, Svnr: 1234
     # Julia Maier, weiblich, 54 Jahre, Svnr: 1111
      # Thomas Maier, maennlich, 22 Jahre, Svnr: 2222
      # Gernot Maier, maennlich, 24 Jahre, Svnr: 3333
     # Gernot Mueller, maennlich, 40 Jahre, Svnr: 1115
      # Roman Mueller, maennlich, 12 Jahre, Svnr: 1116
      # Sophie Mueller, weiblich, 14 Jahre, Svnr: 1117

    createJulia() soll innerhalb von createHubert() verwendet werden
    und createThomas() innerhalb von createJulia(). Es dürfen weitere
    Hilfsmethoden verwendet werden.

    Stellen Sie außerdem sicher, dass Kinder jünger als Eltern sind und das auch
    andere ungültige Werte abgewiesen werden (Alter<0, Svnr<0 oder > 9999).

    Innerhalb der Liste der Kinder einer Person, darf es keine zwei
    gleichen Objekte vom Typ Person geben. Zwei Personen sind gleich, wenn
    ihr Vor- und Nachname, sowie ihre Sozialversicherungsnummer gleich ist.

    Achten Sie auch darauf, dass hashCode() und equals() korrekt funktionieren
    und alle Modifier korrekt sind.

    Kommentieren Sie Ihr Programm ausreichend!

    Zusatzfragen:
    1. Wie verhält sich das Programm wenn es keine eigene Implementierung
       von equals gibt?
    2. Warum sollte man zur textuellen Beschreibung einer Klasse toString
       verwenden und keine Methode mit einem anderen Namen implementieren?
    3. Warum wird hashCode benötigt und wie kann der Rückgabewert dieser
       Methode interpretiert werden?
    4. Warum eignet sich hashCode() nicht für Vergleiche von Objekten?
    5. Inwiefern können Namen und Kommentare altern?
*/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

class Person implements PersonIF {
	private String firstName;
	private String lastName;
	private char sex;
	private int age;
	private int svnr;
	List<PersonIF> kids;

	public Person(String firstName, String lastName, char sex, int age, int svnr) {
		if(age < 0 || svnr < 0 || svnr > 9999) {
			throw new IllegalArgumentException("Some params do not work that way");
		}

		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
		this.svnr = svnr;
		this.kids = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("# ")
				.append(firstName)
				.append(' ')
				.append(lastName)
				.append(", ")
				.append(sex == 'm' ? "maennlich" : "weiblich")
				.append(", ")
				.append(age)
				.append(" Jahre, Svnr: ")
				.append(svnr);

		for(PersonIF kid : kids) {
			String kidStr = kid.toString();
			for(String line : kidStr.split(System.lineSeparator())) {
				sb.append(System.lineSeparator()).append(' ').append(line);
			}
		}

		return sb.toString();
	}

	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (svnr != person.svnr) return false;
		if (!firstName.equals(person.firstName)) return false;
		return lastName.equals(person.lastName);

	}

	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + svnr;
		return result;
	}

	@Override
	public void neuesKind(PersonIF p) {
		if(p.getAge() > age) {
			throw new IllegalArgumentException("Kids must be younger than parent");
		}

		if(kids.contains(p)) {
			throw new DuplicateKidException();
		}

		kids.add(p);
	}
}

public class Aufgabe4 {

	public static PersonIF createHubert() {
		PersonIF hubert = new Person("Hubert", "Maier", 'm', 88, 1234);
		hubert.neuesKind(createJulia());
		hubert.neuesKind(createGernotMueller());
		return hubert;
	}

	public static PersonIF createJulia() {
        PersonIF julia = new Person("Julia", "Maier", 'w', 54, 1111);
		julia.neuesKind(createThomas());
		julia.neuesKind(createGernot());
		return julia;
	}

	public static PersonIF createGernot() {
		return new Person("Gernot", "Maier", 'm', 24, 3333);
	}

	public static PersonIF createGernotMueller() {
		PersonIF gernot = new Person("Gernot", "Mueller", 'm', 40, 1115);
		PersonIF roman = new Person("Roman", "Mueller", 'm', 12, 1116);
		PersonIF sophie = new Person("Sophie", "Mueller", 'w', 14, 1117);

		gernot.neuesKind(roman);
		gernot.neuesKind(sophie);

		return gernot;
	}

	public static PersonIF createThomas() {
		return new Person("Thomas", "Maier", 'w', 22, 2222);
	}

	// just for testing ...
	public static void main(String[] args) {
		System.out.println(createHubert());
	}
}