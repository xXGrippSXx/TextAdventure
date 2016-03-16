import java.awt.Color;

public class Farben {

	public static Color getByGelaendeTyp(GelaendeTyp gelaendeTyp) {

		switch (gelaendeTyp) {
		case Start:
			return Color.CYAN;
		case Stadt:
			return Color.ORANGE;
		case Wald:
			return Color.GREEN;
		case Weg:
			return Color.LIGHT_GRAY;
		case Hoehle:
			return Color.GRAY;
		case Wueste:
			return Color.YELLOW;
		case Berg:
			return Color.BLUE;
		case Wand:
			return Color.BLACK;
		case Ziel:
			return Color.WHITE;
		case Ereignis:
			return Color.RED;
		default:
			return null;
		}

	}

}
