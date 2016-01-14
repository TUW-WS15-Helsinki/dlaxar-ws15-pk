public abstract class RackedAnimal extends NamedAnimal {

	protected int rack;

	public RackedAnimal(String name, ArchivIF owner, int rack) {
		super(name, owner);
		this.rack = rack;
	}

	@Override
	public void einordnen(int regal) {
		this.rack = regal;
	}

	@Override
	public void ausraeumen() {
		rack = 0;
	}

	@Override
	public String toString() {
		return super.toString() + ", Regal: " + rack;
	}

	@Override
	public void zurueckgeben() {
		super.zurueckgeben();
		ausraeumen();
	}
}
