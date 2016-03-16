public enum GelaendeTyp {

	Start, Wand, Wald, Berg, Hoehle, Wueste, Stadt, Ziel, Weg, Ereignis;

	public static GelaendeTyp toGelaendeTyp(String koordinaten) {
		switch (koordinaten) {

		case "S":
			return Start;
		case "X":
			return Wand;
		case "T":
			return Stadt;
		case "F":
			return Wald;
		case "M":
			return Berg;
		case "D":
			return Wueste;
		case "C":
			return Hoehle;
		case "=":
			return Weg;
		case "E":
			return Ziel;
		case "W":
			return Ereignis;
		default:
			throw new IllegalArgumentException("Ungültige Koordinate: " + koordinaten);
		}
	}

}
