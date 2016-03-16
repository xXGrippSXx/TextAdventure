import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class WeltKarte extends JFrame {

	private List<List<Gelaende>> ort;
	private Movement m;

	public WeltKarte(Movement m) {
		this.m = m;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(m.Ort.length, m.Ort[0].length));
		ort = new ArrayList<>();
		for (int x = 0; x < m.Ort[0].length; x++) {
			List<Gelaende> xWerte = new ArrayList<>();
			for (int y = 0; y < m.Ort.length; y++) {
				Gelaende icon = createIcon(m.Ort[x][y]);
				add(icon);
				xWerte.add(icon);
			}
			ort.add(xWerte);
		}
		grenzenDarstellen();
	}

	private void grenzenDarstellen() {

		for (int y = 0; y < ort.size(); y++) {
			List<Gelaende> xWerte = ort.get(y);
			for (int x = 0; x < ort.size(); x++) {
				Gelaende label = xWerte.get(x);
				createBorder(label, x, y);
			}
		}

	}

	private void createBorder(Gelaende label, int x, int y) {
	}

	private Gelaende createIcon(GelaendeTyp gelaendeTyp) {

		Gelaende label = new Gelaende(gelaendeTyp);

		label.setBackground(Farben.getByGelaendeTyp(gelaendeTyp));
		label.setOpaque(true);

		// TODO

		return label;

	}

	public void neuePosition(int positionX, int positionY) {

		Gelaende neuePosition = ort.get(positionY).get(positionX);
		neuePosition.setText("X");

	}

}
