public interface ArchivIF {
	void registrieren(MeerestierIF m);

	void ausraeumen();

	void einordnen();

	void neuWiegen(int gewicht[]);

	void ausborgen(MeerestierIF m);
}
