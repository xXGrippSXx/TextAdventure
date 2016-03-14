import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WeltKarte extends JFrame {

	private JLabel[][] ort;
	private Movement m;

	public WeltKarte(Movement m) {
		this.m = m;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(m.Ort.length, m.Ort[0].length));
		ort = new JLabel[m.Ort[0].length][m.Ort.length];
		for (int x = 0; x < m.Ort[0].length; x++) {
			for (int y = 0; y < m.Ort.length; y++) {
				JLabel icon = createIcon(m.Ort[x][y]);
				add(icon);
				ort[x][y] = icon;
			}
		}

		grenzenDarstellen();
	}

	private void grenzenDarstellen() {

	}

	private JLabel createIcon(GelaendeTyp gelaendeTyp) {

		// try {
		// BufferedImage myPicture = ImageIO.read(new File("Desert.png"));
		// int w = myPicture.getWidth();
		// int h = myPicture.getHeight();
		// BufferedImage after = new BufferedImage (w, h,
		// BufferedImage.TYPE_INT_ARGB);
		// AffineTransform at = new AffineTransform();
		// at.scale(0.2, 0.2);
		// AffineTransformOp scaleOp = new AffineTransformOp(at,
		// AffineTransformOp.TYPE_BILINEAR);
		// after = scaleOp.filter(myPicture, after);
		// JLabel label = new JLabel(new ImageIcon(after));
		// return label;
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }

		JLabel label = new JLabel(gelaendeTyp.name());
		label.setBackground(Farben.getByGelaendeTyp(gelaendeTyp));
		label.setOpaque(true);
		return label;

	}

	public void neuePosition(int positionX, int positionY) {

		JLabel neuePosition = ort[positionX][positionY];
		neuePosition.setText("X");

	}

}
