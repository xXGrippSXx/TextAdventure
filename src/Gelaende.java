import java.awt.Color;

import javax.swing.JLabel;

public class Gelaende extends JLabel {

	private boolean istEsBetreten;

	private GelaendeTyp typ;

	public Gelaende(GelaendeTyp gelaendeTyp) {
		this.typ = gelaendeTyp;
		setToolTipText(typ.name());
		setOpaque(true); // Damit der farbige Hintergrund angezeigt wird
	}

	@Override
	public Color getBackground() {
		return Farben.getByGelaendeTyp(typ);
	}

	public void betreten() {
		istEsBetreten = true;
	}

	public void verlassen() {
		istEsBetreten = false;
	}
}
