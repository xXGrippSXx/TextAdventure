import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Fenster extends JFrame implements ActionListener, KeyListener {
	public JPanel PanelShop, KnöpfeAngebote, KnöpfeSteuer;
	public JButton kaufen;
	public JButton zurück;
	public JButton[] angebote;
	public static final int Angebote = 3;
	public static final String[] preise = { "5", "15", "20" };
	public static final String[] text = { ".\\wood_sword.png", ".\\iron_sword.png", ".\\diamond_" + "sword.png" };
	public static final boolean[] schwerter = { false, false, false };
	static int CASH = 0;
	boolean shop = false;
	boolean musik = true;
	JPanel P;
	JButton kMusik;
	static JButton[] B = new JButton[9];
	static JTextArea A;
	static Movement m;
	JButton ShopKnopf;
	static Color color = Color.DARK_GRAY;
	Clip clip;
	String titel;
	JButton ChooseMusik;
	static JPanel subPanel;
	Shop S = new Shop();
	private WeltKarte karte;
	static int sec = 0;
	public Timer timer = new Timer();

	private SoundSpieler soundPlayer = new SoundSpieler();

	public TimerTask task = new TimerTask() {

		@Override
		public void run() {
			sec++;
			Text();
		}
	};

	public Fenster(Movement m1, int geld, boolean music, String link, WeltKarte karte) {
		super("World Adventure");
		addKeyListener(this);
		titel = link;
		musik = music;
		this.karte = karte;
		subPanel = new JPanel();
		P = new JPanel();
		A = new JTextArea();
		ShopKnopf = new JButton();
		ShopKnopf.addActionListener(this);
		setFocusable(true);
		CASH = geld;
		m = m1;
		ChooseMusik = new JButton("Musik wählen");
		ChooseMusik.addActionListener(this);
		P.add(ChooseMusik, BorderLayout.PAGE_END);
		for (int i = 0; i < B.length; i++) {
			B[i] = new JButton();
			subPanel.add(B[i]);
			B[i].setFont(new Font("ARIAL", Font.BOLD, 64));
			B[i].setForeground(Color.ORANGE);
			B[i].addActionListener(this);
		}

		kMusik = new JButton();
		if (music) {
			play(null, titel);
			kMusik.setText(" MUSIK ON ");
			kMusik.setForeground(Color.GREEN);
		} else {
			kMusik.setText(" MUSIK OFF ");
			kMusik.setForeground(Color.RED);
		}
		kMusik.setBackground(Color.BLUE);
		kMusik.addActionListener(this);
		kMusik.setFont(new Font("ARIAL", Font.BOLD, 32));
		kMusik.setSize(600, 100);

		P.setLayout(new BorderLayout());
		P.add(kMusik, BorderLayout.PAGE_END);
		subPanel.setLayout(new GridLayout(3, 3));
		P.add(subPanel, BorderLayout.CENTER);

		P.add(ShopKnopf, BorderLayout.PAGE_START);
		ShopKnopf.setSize(600, 50);
		P.add(A, BorderLayout.LINE_END);

		A.setFont(new Font("ARIAL", Font.BOLD, 32));
		A.setBackground(Color.BLUE);
		A.setForeground(Color.ORANGE);
		A.setEditable(false);
		A.setFocusable(false);

		B[1].setBackground(Color.BLUE);
		B[3].setBackground(Color.BLUE);
		B[5].setBackground(Color.BLUE);
		B[7].setBackground(Color.BLUE);

		B[1].setText("N");
		B[5].setText("O");
		B[3].setText("W");
		B[7].setText("S");

		B[0].setVisible(false);
		B[2].setVisible(false);
		B[4].setVisible(false);
		B[6].setVisible(false);
		B[8].setVisible(false);

		ShopKnopf.setIcon(new ImageIcon(".\\Coin.png"));
		Text();

		setContentPane(P);
		setResizable(true);

	}

	public void Text() {
		String Temp = "";
		switch (m.getZiel(m.getPositionY(), m.getPositionX())) {
		case Start:
			Temp = "Start";
			color = Color.DARK_GRAY;
			break;
		case Ziel:
			Temp = "Ausgang";
			break;
		case Stadt:
			Temp = "Stadt";
			color = Color.ORANGE;
			break;
		case Wand:
			Temp = "Mauer";
			break;
		case Wald:
			Temp = "Wald";
			color = Color.GREEN;
			break;
		case Weg:
			Temp = "Weg";
			color = Color.LIGHT_GRAY;
			break;
		case Hoehle:
			Temp = "Höhle";
			color = Color.BLACK;
			break;
		case Wueste:
			Temp = "Wüste";
			color = Color.YELLOW;
			break;
		case Berg:
			Temp = "Berg";
			color = Color.WHITE;
			break;
		case Ereignis:
			Temp = "Ereignisfeld";
			color = Color.RED;
		}

		if (Temp.equals("Höhle")) {
			if (!soundPlayer.isPlaying()) {
				soundPlayer.play(".\\CaveSound.wav");
			}
			if (!cave()) {
				if (CASH < 50) {
					CASH += 50;
				}
			} else {
				CASH = CASH;
				System.out.println("Du kannst kein Geld mehr bekommen da du mehr als 50 Gold hast.");
			}
		} else {
			if (soundPlayer.isPlaying()) {
				soundPlayer.stop();
			}
		}

		if (Temp.equals("Ereignisfeld")) {
			if (!ef()) {
				m.x = m.xStart;
				m.y = m.yStart;
				m.AktuellesGebiet = GelaendeTyp.Start;
			} else {
				m.x = m.xZiel;
				m.y = m.yZiel;
				m.AktuellesGebiet = GelaendeTyp.Ziel;
			}
		}

		subPanel.setBackground(color);

		A.setText(Temp + "\n" + m.getGebiet() + "\nX: " + m.getPositionX() + "\nY: " + m.getPositionY() + "\nZeit: "
				+ sec + "\n" + CASH + " G");
		karte.neuePosition(m.getPositionX(), m.getPositionY());
	}

	public JPanel Shop() {
		PanelShop = new JPanel();
		KnöpfeAngebote = new JPanel();
		KnöpfeSteuer = new JPanel();
		kaufen = new JButton("Kaufen");
		zurück = new JButton("Zurück zum Spiel");
		angebote = new JButton[Angebote];
		for (int i = 0; i < angebote.length; i++) {
			angebote[i] = new JButton();
			angebote[i].setIcon(new ImageIcon(text[i]));
			angebote[i].setBackground(Color.WHITE);
			KnöpfeAngebote.add(angebote[i]);
			angebote[i].addActionListener(this);
		}
		kaufen.addActionListener(this);
		zurück.addActionListener(this);
		KnöpfeSteuer.add(kaufen);
		KnöpfeSteuer.add(zurück);
		PanelShop.add(KnöpfeAngebote);
		PanelShop.add(KnöpfeSteuer);
		return (PanelShop);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!shop) {
			if (e.getSource() == kMusik) {
				musik = !musik;
				if (musik) {
					play(null, titel);
					kMusik.setText(" MUSIK ON ");
					kMusik.setForeground(Color.GREEN);
				} else {
					stop(null, titel);
					kMusik.setText(" MUSIK OFF ");
					kMusik.setForeground(Color.RED);
				}
				requestFocus();
			}
			if (e.getSource() == B[1]) {
				m.geheTop();
				geld();
				Text();
				requestFocus();
			}
			if (e.getSource() == ShopKnopf) {
				setPanel(Shop());
				shop = true;
				validate();
				requestFocus();
			}
			if (e.getSource() == B[3]) {
				m.geheLeft();
				geld();
				Text();
				requestFocus();
			}
			if (e.getSource() == B[7]) {
				m.geheBot();
				geld();
				Text();
				requestFocus();
			}
			if (e.getSource() == B[5]) {
				m.geheRight();
				geld();
				Text();
				requestFocus();
			}
		} else {
			if (e.getSource() == zurück) {
				setPanel(P);
				shop = false;
				validate();
				requestFocus();
			}
			for (int i = 0; i < angebote.length; i++) {
				if (e.getSource() == angebote[i]) {
					schwerter[i] = !schwerter[i];
					if (schwerter[i]) {
						angebote[i].setBackground(Color.YELLOW);
					} else {
						angebote[i].setBackground(Color.WHITE);
					}
					requestFocus();
				}
			}
			if (e.getSource() == kaufen) {
				int kaufPreis = 0;
				kaufPreis = S.getPreis("S", 1);
				if (CASH >= kaufPreis) {
					int confirm = JOptionPane.showConfirmDialog(null, "WILLST DU DIESE ARTIKEL WIRKLICH KAUFEN?",
							"KAUFBESTÄTIGUNG", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Ihr Kauf war erfolgreich!");
						CASH -= kaufPreis;
					} else {
						JOptionPane.showMessageDialog(null, "Ihr Kauf wurde abgebrochen!");
					}
				} else {
					int zuwenig = kaufPreis - CASH;
					JOptionPane.showMessageDialog(null,
							"Du brauchst ersteinmal Geld, bevor du dir diese Artikel kaufen kannst!\nDu hast " + zuwenig
									+ " zuwenig!");
				}
				requestFocus();
			}
		}

	}

	public void geld() {
		if (m.getPositionX() == 4 && m.getPositionY() == 17) {
			System.out.println("Kein Geld wegen Ausgang...");
		} else {
			int rnd = (int) (Math.random() * 5) + 1;
			if (rnd == 5) {
				CASH++;
				System.out.println("DU HAST GELD GEFUNDEN");
			}
		}
	}

	public void setPanel(JPanel p) {
		this.setContentPane(p);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			m.geheTop();
			geld();
			Text();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			m.geheLeft();
			geld();
			Text();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			m.geheRight();
			geld();
			Text();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			m.geheBot();
			geld();
			Text();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private void play(Object codeBase, String fileName) {
		try {
			clip = AudioSystem.getClip();
			File file = new File(fileName + ".wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			clip.open(ais);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void stop(Object codeBase, String fileName) {
		try {
			if (clip != null) {
				clip.stop();
				clip.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean cave() {
		boolean temp = false;
		int rnd = (int) (Math.random() * 100);
		if (rnd >= 25) {
			temp = true;
		}
		return temp;
	}

	public static boolean ef() {
		boolean temp = false;
		int random = (int) (Math.random() * 100);
		if (random >= 50) {
			temp = true;
		}
		return temp;
	}
}
