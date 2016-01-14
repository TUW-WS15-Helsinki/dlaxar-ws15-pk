public interface MeerestierIF {
	void einordnen(int regal);

	void ausraeumen();

	int gewicht();

	void abwiegen(int gewicht);

	void wirdAusgeborgtVon(ArchivIF a);

	void archivieren(ArchivIF a);

	void zurueckgeben();
}
