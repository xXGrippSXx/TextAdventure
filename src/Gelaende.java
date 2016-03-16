import javax.swing.JLabel;

public class Gelaende extends JLabel {

	private GelaendeTyp typ;

	public Gelaende(GelaendeTyp gelaendeTyp) {
		this.typ = gelaendeTyp;
	}

	@Override
	public String getToolTipText() {
		return typ.name();
	}

}
