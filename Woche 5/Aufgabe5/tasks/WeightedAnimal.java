public abstract class WeightedAnimal extends RackedAnimal {

	private int gramms;

	public WeightedAnimal(String name, ArchivIF owner, int rack, int gramms) {
		super(name, owner, rack);
		this.gramms = gramms;
	}

	@Override
	public int gewicht() {
		return gramms;
	}

	@Override
	public void abwiegen(int gewicht) {
		this.gramms = gewicht*1000;
	}

	@Override
	public String toString() {
		return super.toString() + ", Gewicht: " + formatGramms(gramms);
	}

	public static String formatGramms(int gramms) {
		return (gramms > 1000 ? (gramms/1000) + "kg" : gramms + "g");
	}
}
