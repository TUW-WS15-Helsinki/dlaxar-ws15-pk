public abstract class NamedAnimal implements MeerestierIF {

	private String name;
	private ArchivIF owner;
	private ArchivIF possessor;

	public NamedAnimal(String name, ArchivIF owner) {
		this.name = name;
		this.owner = this.possessor = owner;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public void wirdAusgeborgtVon(ArchivIF a) {
		this.possessor = a;
		owner.ausraeumen();
	}

	@Override
	public void zurueckgeben() {
		this.possessor = this.owner;
	}
}
