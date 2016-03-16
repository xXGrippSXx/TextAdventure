import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WeltKarte extends JFrame {

	private List<List<JLabel>> ort;
	private Movement m;

	public WeltKarte(Movement m) {
		this.m = m;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(m.Ort.length, m.Ort[0].length));
		ort = new ArrayList<>();
		for (int x = 0; x < m.Ort[0].length; x++) {
			List<JLabel> xWerte = new ArrayList<>();
			for (int y = 0; y < m.Ort.length; y++) {
				JLabel icon = createIcon(m.Ort[x][y]);
				add(icon);
				xWerte.add(icon);
			}
			ort.add(xWerte);
		}
		grenzenDarstellen();
	}

	private void grenzenDarstellen() {

		for (int y = 0; y < ort.size(); y++) {
			List<JLabel> xWerte = ort.get(y);
			for (int x = 0; x < ort.size(); x++) {
				JLabel label = xWerte.get(x);
				createBorder(label, x, y);
			}
		}

	}

	private void createBorder(JLabel label, int x, int y) {
	}

	private JLabel createIcon(GelaendeTyp gelaendeTyp) {

		JLabel label = new JLabel();

		label.setBackground(Farben.getByGelaendeTyp(gelaendeTyp));
		label.setOpaque(true);

		// TODO

		return label;

	}

	public void neuePosition(int positionX, int positionY) {

		JLabel neuePosition = ort.get(positionY).get(positionX);
		neuePosition.setText("X");

	}

}
