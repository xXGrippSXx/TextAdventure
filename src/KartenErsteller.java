import javax.swing.JButton;
import javax.swing.JFrame;

public class KartenErsteller
		extends JFrame { /* Zum Erstellen neuer Karten für Entwickler */

	public JButton wald;
	public JButton start;
	public JButton wand;
	public JButton berg;
	public JButton hoehle;
	public JButton wueste;
	public JButton ziel;
	public JButton weg;
	public JButton stadt;

	public KartenErsteller() {

		setTitle("Kartenersteller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocation(50, 50);
		setVisible(true);

	}
}
