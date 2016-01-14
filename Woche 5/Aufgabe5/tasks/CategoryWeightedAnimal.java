public abstract class CategoryWeightedAnimal extends RackedAnimal {

	private int gramms;

	public CategoryWeightedAnimal(String name, ArchivIF owner, int rack, int gramms) {
		super(name, owner, rack);
		this.gramms = gramms;
	}

	@Override
	public void abwiegen(int gewicht) {
		gramms = gewicht*1000;
	}

	@Override
	public int gewicht() {
		return gramms;
	}

	@Override
	public String toString() {
		return super.toString() + ", Gewichtsklasse: " + formatGramms(gramms);
	}

	public static String formatGramms(int gramms) {
		return (gramms > 1000 ? (gramms / 1000) + "kg" : gramms + "g");
	}
}
