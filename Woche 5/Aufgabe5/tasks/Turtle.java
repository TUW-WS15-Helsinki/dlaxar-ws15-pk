public class Turtle extends CategoryWeightedAnimal {
	public Turtle(String name, ArchivIF owner, int rack, int gramms) {
		super(name, owner, rack, gramms);
	}

	@Override
	public void abwiegen(int gewicht) {
		super.abwiegen((gewicht*100)/110);
	}

	@Override
	public void archivieren(ArchivIF a) {

	}

	@Override
	public String toString() {
		return super.toString();
	}
}
