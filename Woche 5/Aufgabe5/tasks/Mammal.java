public class Mammal extends SpeciallyRackedAnimal {
	public Mammal(String name, ArchivIF owner, int rack, int gramms) {
		super(name, owner, rack, gramms);
	}

	@Override
	public int gewicht() {
		return 0;
	}

	@Override
	public void einordnen(int regal) {
		super.einordnen(regal+100);
	}

	@Override
	public void abwiegen(int gewicht) {
		super.abwiegen(gewicht * 1000);
	}

	@Override
	public void archivieren(ArchivIF a) {

	}
}
