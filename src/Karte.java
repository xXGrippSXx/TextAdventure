import java.util.HashSet;
import java.util.Set;

public class Karte {

	private Set<Feld> felder = new HashSet<Feld>();

	public Karte(int x, int y) {

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				felder.add(new Feld(i, j));
			}
		}

	}

}
