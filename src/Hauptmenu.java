import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

//245
@SuppressWarnings("serial")
public class Hauptmenu extends JFrame implements ActionListener {

	private static final int CODE_JAN = 53481744;
	private static final int CODE_42 = 424242;
	private static final int CODE_STI = 49435234;
	private static final int CODE_STC = 49435233;
	private static final int CODE_KUEHN = 9258369;
	private static final String AC_Code = "codeEingeben";
	private static final String AC_Music_ON_OFF = "codeEingeben2";
	private static final String AC_Schwer = "codeEingeben3";
	private static final String AC_Mittel = "codeEingeben4";
	private static final String AC_Leicht = "codeEingeben5";
	private static final String AC_KARTE = "codeEingeben6";
	static Movement m;
	public JPanel p;
	public JButton start;
	public JButton credi;
	public JButton ende;
	public JButton laden;
	public JButton optionen;
	private JMenu entwicklerOptionen;
	static boolean music = true;
	public String[] Codes = { "21543", "15946", "44568", "15357", "54545" };
	private Schwierigkeit aktuelleSchwierigkeit = Schwierigkeit.Mittel;

	public Hauptmenu(Movement m1) {
		super(" Menu ");
		m = m1;
		p = new JPanel();
		start = new JButton("Spiel Starten");
		optionen = new JButton("Spiel ohne VG");
		laden = new JButton("Ziel des Spiels");
		credi = new JButton("Credits");
		ende = new JButton("Spiel Beenden");
		start.setBounds(120, 40, 160, 40);
		optionen.setBounds(120, 120, 160, 40);
		laden.setBounds(120, 200, 160, 40);
		credi.setBounds(120, 280, 160, 40);
		ende.setBounds(120, 360, 160, 40);
		start.addActionListener(this);
		laden.addActionListener(this);
		ende.addActionListener(this);
		optionen.addActionListener(this);
		credi.addActionListener(this);
		p.setLayout(null);
		p.add(start);
		p.add(optionen);
		p.add(laden);
		p.add(credi);
		p.add(ende);
		setContentPane(p);
		createMenu(this);
	}

	public static void main(String[] args) throws Exception {
		// new Spiel(-5, music, ".\\musik",".\\MapSTCSTI.txt");
		Hauptmenu f = new Hauptmenu(m);
		f.setSize(400, 480);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	public JMenuBar createMenu(Hauptmenu f) {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		menuBar = new JMenuBar();
		menu = new JMenu("Optionen");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has items");
		menuBar.add(menu);

		menuItem = new JMenuItem("Code Eingabe");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("This doesnt really do anything");
		menuItem.setActionCommand(AC_Code);
		menuItem.addActionListener(this);
		p.add(menuItem);
		menu.add(menuItem);

		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("Schwer");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		rbMenuItem.setActionCommand(AC_Schwer);
		rbMenuItem.addActionListener(this);
		rbMenuItem.setToolTipText("Schwerer Karten und Monster");
		p.add(rbMenuItem);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		rbMenuItem = new JRadioButtonMenuItem("Mittel");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		rbMenuItem.setActionCommand(AC_Mittel);
		rbMenuItem.addActionListener(this);
		rbMenuItem.setToolTipText("Normale Karten, keine Monster");
		p.add(rbMenuItem);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		rbMenuItem = new JRadioButtonMenuItem("Leicht");
		rbMenuItem.setMnemonic(KeyEvent.VK_G);
		rbMenuItem.setActionCommand(AC_Leicht);
		rbMenuItem.addActionListener(this);
		rbMenuItem.setToolTipText("Einfache Karten, keine Monster");
		p.add(rbMenuItem);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("Musik AN/AUS");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		cbMenuItem.setActionCommand(AC_Music_ON_OFF);
		cbMenuItem.addActionListener(this);
		p.add(cbMenuItem);
		menu.add(cbMenuItem);

		menu.add(getEntwicklerOptionen());
		menuItem = new JMenuItem("Kartenersteller");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		entwicklerOptionen.add(menuItem);
		menuItem.setActionCommand(AC_KARTE);
		menuItem.addActionListener(this);
		menuItem.setToolTipText("Kartenersteller für Entwickler");
		menu.add(entwicklerOptionen);
		menuBar.add(menu);
		f.setJMenuBar(menuBar);
		return menuBar;

	}

	public JMenu getEntwicklerOptionen() {
		if (entwicklerOptionen == null) {
			entwicklerOptionen = new JMenu("Entwickler Einstellungen");
			entwicklerOptionen.setMnemonic(KeyEvent.VK_A);
			entwicklerOptionen.getAccessibleContext()
					.setAccessibleDescription("Entwickler Einstellungen, nur für Entwickler!");
			entwicklerOptionen.setVisible(false);
		}
		return entwicklerOptionen;
	}

	// test
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			try {
				JOptionPane.showMessageDialog(null,
						"Du bist Joel, ein Junge der ein ziemlicher Raufbold in der Schule ist.\nDoch als du dich umguckst merkst du, dass du weder zu Hause noch in der Schule oder an einem sonstigen dir bekanntem Ort bist.\nDir wird klar, dass du dich igenwo in einem kleinen Labyrinth befindest...\nund den Ausgang finden musst, damit du deine Familie wiedersehen kannst!\nAuf einmal wird es sehr hell und du erkennst einen riesigen Fernseher in der anderen Ecke des Raumes.\nDer Fernseher zeigt nichts an, er hat nur die Störung, die auftritt, wenn kein Signal besteht.\nDoch dann geht er an und du siehst einen Mann, der dir sagt, dass du für deine Taten in der Schule einige Aufgaben erfüllen musst, damit du dich besserst.\nDu weißt, dass du dein größtest Abenteurer vor dir hast, was du je erlebt hast und erleben wirst.\nDer Fernseher geht aus und du stürmst sofort nach draußen...\nDoch dann bemerkst du, dass es keine normalen Räume sondern Gebiete sind...",
						"Ziel des Spiels", JOptionPane.INFORMATION_MESSAGE);
				/* new Vorgeschichte().anzeigen(); */ // WICHTIG FÜR STORY,
				// SONST WIRD SIE NICHT
				// ANGEZEIGT
				@SuppressWarnings("unused")
				Spiel spiel = new Spiel(0, music, ".\\musik", ".\\SAVE.txt");
				this.setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"ERROR while Loading... \nPlease Try again later, or send an email to\ninfo.javaprograms@gmail.com");
			}
		}

		if (e.getSource() == laden) {
			JOptionPane.showMessageDialog(null,
					"Das Ziel des Spieles ist es, das Ziel auf einer 20 x 20 großen Karte zu finden.\nHierbei musst du darauf achten, dass du nur von Wegen in Gebiete, oder dich in den Gebieten bewegen kannst.\nDu musst auf der Schwierigkeitsstufe Schwer gegen Monster kämpfen. \n Wenn du das Ziel gefunden hast, kommt es darauf an, ob du bereits genug Gold gesammelt hast, wenn nicht, dann musst du weiter suchen!",
					"Ziel des Spiels", JOptionPane.INFORMATION_MESSAGE);
		}

		if (e.getSource() == credi) {
			JOptionPane.showMessageDialog(null,
					"TextAdventure\nEin Spiel der ProgrammierAG des Alstergymnasiums H.-U.\nMegakrasse Musik ausgewählt von Jan Stegemann\nMultikontroverse Matrizen von David Kowalk\nMassive Maps von Tim Wolf und Jonas Matenia\nPerfekte Programmierung von Jonas Kühn\nLustiges Layout von Kevin Altenburg\nIdeale Idee von Hr. & Fr. Stichel",
					"CREDITS", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == optionen) {
			try {
				@SuppressWarnings("unused")
				Spiel spiel = new Spiel(0, music, ".\\musik", ".\\SAVE.txt");
				this.setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"ERROR while Loading... \nPlease Try again later, or send an email to\ninfo.javaprograms@gmail.com");

			}
		}
		if (e.getSource() == ende) {
			int a = JOptionPane.showConfirmDialog(null, "Wollen sie das Spiel wirklich beenden?", "BEENDEN",
					JOptionPane.YES_NO_OPTION);
			if (a == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Schade... \nBis zum naechsten mal!\nTSCHUESS!!");
				System.exit(0);
			}
			if (a == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Super! Dann auf ins Abenteuer!");
			}
		}
		if (e.getActionCommand().equals(AC_Code)) {
			String inputDialog = JOptionPane.showInputDialog("Geben Sie einen Level - Code ein", "1234567890");
			if (inputDialog == null) {
				return;
			}
			int code = Integer.parseInt(inputDialog);
			if (code == CODE_KUEHN) {
				try {
					new Spiel(100, music, ".\\musik", ".\\SAVE.txt");
					this.setVisible(false);
				} catch (Exception e1) {
				}
			} else if (code == CODE_STC) {
				try {
					new Spiel(10, music, ".\\musik3", ".\\MapSTCSTI.txt");
					this.setVisible(false);
				} catch (Exception e1) {
				}
			} else if (code == CODE_STI) {
				try {
					new Spiel(10, music, ".\\musik4", ".\\MapSTCSTI.txt");
					this.setVisible(false);
				} catch (Exception e1) {
				}
			} else if (code == CODE_JAN) {
				try {
					new Spiel(10, music, ".\\musik2", ".\\SAVE.txt");
					this.setVisible(false);
				} catch (Exception e1) {
				}

			} else if (code == CODE_42) {// CODE 42
				try {
					getEntwicklerOptionen().setVisible(true);
				} catch (Exception e1) {
				}
			} else {
				if (laden(code)) {
					try {
						new Spiel(0, music, ".\\musik", ".\\SAVE.txt");
						this.setVisible(false);
					} catch (Exception e1) {
					}
				}
			}

		}
		if (e.getActionCommand().equals(AC_Music_ON_OFF)) {

			JCheckBoxMenuItem checkBox = (JCheckBoxMenuItem) e.getSource();
			music = checkBox.isSelected();
		}
		if (e.getActionCommand().equals(AC_Schwer)) {

			aktuelleSchwierigkeit = Schwierigkeit.Schwer;
			meldeAktuelleSchwierigkeit();

		}
		if (e.getActionCommand().equals(AC_Mittel)) {

			aktuelleSchwierigkeit = Schwierigkeit.Mittel;
			meldeAktuelleSchwierigkeit();

		}
		if (e.getActionCommand().equals(AC_Leicht)) {

			aktuelleSchwierigkeit = Schwierigkeit.Leicht;
			meldeAktuelleSchwierigkeit();

		}
		if (e.getActionCommand().equals(AC_KARTE)) {

			new KartenErsteller();

		}
	}

	private void meldeAktuelleSchwierigkeit() {
		JOptionPane.showMessageDialog(this, "Die Schwierigkeit wurde auf " + aktuelleSchwierigkeit + " gestellt!");
	}

	private boolean laden(int NR) {
		boolean b = false;
		for (int i = 0; i < Codes.length; i++)
			if (NR == Integer.parseInt(Codes[i])) {
				b = true;
			}
		return b;

	}

}
