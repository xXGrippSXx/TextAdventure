import java.awt.Color;

import javax.swing.JLabel;

public class Gelaende extends JLabel {

	private boolean istEsBetreten;
	private boolean wurdeBetreten;

	private GelaendeTyp typ;

	public Gelaende(GelaendeTyp gelaendeTyp) {
		this.typ = gelaendeTyp;
		setToolTipText(typ.name());
		setOpaque(true); // Damit der farbige Hintergrund angezeigt wird
	}

	@Override
	public Color getBackground() {
		if (wurdeBetreten) {
			return Farben.getByGelaendeTyp(typ);
		} else {
			return Color.BLACK;
		}
	}

	public void betreten() {
		istEsBetreten = true;
		wurdeBetreten = true;
		repaint();
	}

	public void verlassen() {
		istEsBetreten = false;
	}
}
