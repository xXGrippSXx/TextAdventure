import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KartenErsteller extends JFrame implements
		ActionListener { /* Zum Erstellen neuer Karten für Entwickler */

	private static final String AC_WALD = "codeEingabeKarte1";
	private static final String AC_START = "codeEinagbeKarte2";
	private static final String AC_WAND = "codeEingabeKarte3";
	private static final String AC_BERG = "codeEingabeKarte4";
	private static final String AC_HOEHLE = "codeEinabeKarte5";
	private static final String AC_WUESTE = "codeEingabeKarte6";
	private static final String AC_ZIEL = "codeEingabeKarte7";
	private static final String AC_WEG = "codeEingabeKarte8";
	private static final String AC_STADT = "codeEingabeKarte9";
	public JButton wald;
	public JButton start;
	public JButton wand;
	public JButton berg;
	public JButton hoehle;
	public JButton wueste;
	public JButton ziel;
	public JButton weg;
	public JButton stadt;
	public JPanel p;

	public KartenErsteller() {

		setTitle("Kartenersteller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocation(50, 50);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(AC_WALD)) {
			System.out.println("wald");
		}
		if (e.getActionCommand().equals(AC_START)) {
			System.out.println("start");
		}
		if (e.getActionCommand().equals(AC_WAND)) {
			System.out.println("wand");
		}
		if (e.getActionCommand().equals(AC_BERG)) {
			System.out.println("berg");
		}
		if (e.getActionCommand().equals(AC_HOEHLE)) {
			System.out.println("höhle");
		}
		if (e.getActionCommand().equals(AC_WUESTE)) {
			System.out.println("wüste");
		}
		if (e.getActionCommand().equals(AC_ZIEL)) {
			System.out.println("ziel");
		}
		if (e.getActionCommand().equals(AC_WEG)) {
			System.out.println("weg");
		}
		if (e.getActionCommand().equals(AC_STADT)) {
			System.out.println(stadt);
		}

	}

	public JButton getWald() {
		if (wald == null) {
			wald = new JButton("Wald");
			wald.setActionCommand(AC_WALD);
			wald.addActionListener(this);
		}
		return wald;
	}

	public JButton getStart() {
		if (start == null) {
			start = new JButton("Start");
			start.setActionCommand(AC_START);
			start.addActionListener(this);
			start.setBounds(120, 40, 160, 40);
		}
		return start;
	}

	public JButton getWand() {
		if (wand == null) {
			wand = new JButton("Wand");
			wand.setActionCommand(AC_WAND);
			wand.addActionListener(this);
			wand.setBounds(120, 40, 160, 40);
		}
		return start;
	}

	public JButton getBerg() {
		if (berg == null) {
			berg = new JButton("Berg");
			berg.setActionCommand(AC_BERG);
			berg.addActionListener(this);
			berg.setBounds(120, 40, 160, 40);
		}
		return start;
	}

	public JButton getHoehle() {
		if (hoehle == null) {
			hoehle = new JButton("Höhle");
			hoehle.setActionCommand(AC_HOEHLE);
			hoehle.addActionListener(this);
			hoehle.setBounds(120, 40, 160, 40);
		}
		return start;
	}

	public JButton getWueste() {
		if (wueste == null) {
			wueste = new JButton("Wüste");
			wueste.setActionCommand(AC_WUESTE);
			wueste.addActionListener(this);
			wueste.setBounds(120, 40, 160, 40);
		}
		return start;
	}

	public JButton getZiel() {
		if (ziel == null) {
			ziel = new JButton("Ziel");
			ziel.setActionCommand(AC_ZIEL);
			ziel.addActionListener(this);
			ziel.setBounds(120, 40, 160, 40);
		}
		return start;
	}

	public JButton getWeg() {
		if (weg == null) {
			weg = new JButton("Weg");
			weg.setActionCommand(AC_WEG);
			weg.addActionListener(this);
			weg.setBounds(120, 40, 160, 40);
		}
		return start;
	}

	public JButton getStadt() {
		if (stadt == null) {
			stadt = new JButton("Stadt");
			stadt.setActionCommand(AC_STADT);
			stadt.addActionListener(this);
			stadt.setBounds(120, 40, 160, 40);
		}
		return start;
	}

}
