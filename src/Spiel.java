import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Spiel {

	int x;
	int y;
	int koordinateZielX;
	int koordinateZielY;

	public static boolean g = false;
	String map;

	public Spiel(int geld, boolean musik, String link, String map1) {
		Movement m = new Movement();
		map = map1;
		System.out.println(map);
		System.out.println("Start");
		try {
			lesen(m);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR!!!!!!!!!!!");
		}

		WeltKarte karte = new WeltKarte(m);

		Fenster f1 = new Fenster(m, geld, musik, link, karte);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(600, 600);
		f1.setAlwaysOnTop(false);
		f1.setResizable(true);
		f1.setVisible(true);
		f1.timer.scheduleAtFixedRate(f1.task, 1000, 1000);

		karte.setSize(200, 200);
		karte.setLocation(f1.getLocation().x + 600, karte.getLocation().y);
		karte.setVisible(true);
	}

	private void VorgeschichteAnzeigen() {
		new Vorgeschichte().anzeigen();

	}

	public void lesen(Movement m) throws IOException {

		String temp1;
		@SuppressWarnings("unused")
		String[] c;
		BufferedReader Datei = new BufferedReader(new FileReader(map));
		System.out.println("Nach Datei");
		for (int a = 0; a < 20; a++) {
			temp1 = Datei.readLine();
			System.out.println(temp1);
			for (int b = 0; b < 20; b++) {
				GelaendeTyp temp2 = GelaendeTyp.toGelaendeTyp(temp1.substring(b, b + 1));
				if (temp2 == GelaendeTyp.Start) {
					x = a;
					y = b;
				} else if (temp2 == GelaendeTyp.Ziel) {
					koordinateZielX = a;
					koordinateZielY = b;
				}
				m.setOrt(temp2, a, b);
			}
		}
		m.setX(x);
		m.setY(y);
		System.out.println("");
		Datei.close();

	}
}
