public interface PersonIF {

	int hashCode();

	boolean equals(Object obj);

	String toString();

	void neuesKind(PersonIF p);

	int getAge();
}