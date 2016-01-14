public abstract class SpeciallyRackedAnimal extends NamedAnimal {

	private int rack;
	private int gramms;

	public SpeciallyRackedAnimal(String name, ArchivIF owner, int rack, int gramms) {
		super(name, owner);
		this.rack = rack;
		this.gramms = gramms;
	}

	@Override
	public void ausraeumen() {
		this.rack = 0;
	}

	@Override
	public void einordnen(int regal) {
		rack = regal;
	}

	@Override
	public void abwiegen(int gewicht) {
		this.gramms = gewicht * 1000;
	}

	@Override
	public String toString() {
		return super.toString() + ", SpezialRegal (Säugetier): " + rack + ", Gewicht: " +
				WeightedAnimal.formatGramms(gramms);
	}

	@Override
	public void zurueckgeben() {
		super.zurueckgeben();
		ausraeumen();
	}
}
