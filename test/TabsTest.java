import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabsTest {

	public static void main(String[] args) {
		JDialog fenster = new JDialog();
		fenster.setTitle("Tabs Test");
		fenster.setSize(450, 300);
		JPanel panelRot = new JPanel();
		JPanel panelBlau = new JPanel();
		JPanel panelGelb = new JPanel();
		JPanel panelGrün = new JPanel();
		JPanel panelPink = new JPanel();
		JPanel panelSchwarz = new JPanel();

		panelRot.setBackground(Color.RED);
		panelBlau.setBackground(Color.BLUE);
		panelGelb.setBackground(Color.YELLOW);
		panelGrün.setBackground(Color.GREEN);
		panelPink.setBackground(Color.PINK);
		panelSchwarz.setBackground(Color.BLACK);

		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("Ich bin Rot", panelRot);
		tabbedPane.addTab("Ich bin Blau", panelBlau);
		tabbedPane.addTab("Ich bin Gelb", panelGelb);
		tabbedPane.addTab("Ich bin Grün", panelGrün);
		tabbedPane.addTab("Ich bin Pink", panelPink);
		tabbedPane.addTab("Ich bin Schwarz", panelSchwarz);

		fenster.add(tabbedPane);
		fenster.setVisible(true);
	}
}
