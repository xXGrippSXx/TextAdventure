import java.awt.Color;

import javax.swing.JLabel;

public class Gelaende extends JLabel {

	private GelaendeTyp typ;

	public Gelaende(GelaendeTyp gelaendeTyp) {
		this.typ = gelaendeTyp;
		setToolTipText(typ.name());
	}

	@Override
	public Color getBackground() {
		return Farben.getByGelaendeTyp(typ);
	}
}
