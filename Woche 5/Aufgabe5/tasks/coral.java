public class Coral extends RackedAnimal {

	public Coral(String name, ArchivIF owner, int rack) {
		super(name, owner, rack);
	}

	@Override
	public int gewicht() {
		return 1000;
	}

	@Override
	public void abwiegen(int gewicht) {
		// ignore
	}

	@Override
	public void archivieren(ArchivIF a) {

	}

	@Override
	public String toString() {
		return super.toString() + ", Gewicht: 1000g";
	}
}
