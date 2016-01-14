public class Fish extends WeightedAnimal {
	public Fish(String name, ArchivIF owner, int rack, int gramms) {
		super(name, owner, rack, gramms);
	}

	@Override
	public void einordnen(int regal) {
		super.einordnen(regal+200);
	}

	@Override
	public void archivieren(ArchivIF a) {

	}
}
