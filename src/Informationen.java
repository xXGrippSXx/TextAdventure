import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Informationen {

	public Informationen() {

		JDialog fenster = new JDialog();
		fenster.setTitle("INFOS");
		fenster.setSize(450, 340);

		JTabbedPane tabbedPane = new JTabbedPane();

		neuenTabErstellenUndHinzufuegen(tabbedPane, "Ziele der Übung",
				"	                      Ziele der Übung: \n \n Die Ziele der Übung sind, dass ich lerne,"
						+ " bzw. besser werde im\n Programmieren.\n Dazu haben mir alle aus p42 eine User Sory*²"
						+ " geschrieben, die ich bearbeiten\n kann.\n Das was ihr hier seht ist auch eine Userstory von Arne.\n"
						+ "Ich sollte Tabs erstellen in denen ich die 3 Texte abarbeite. \n \n \n \n \n \n   *² User Storys "
						+ "sind kleine Anforderungen der Kunden.\n In ihnen muss klar werden, wer etwas möchte, was er möchte, und \n warum er das möchte."
						+ "Diese User Story ist erst erfüllt, wenn alle \n Akzeptanzkriterien erfüllt sind.");
		neuenTabErstellenUndHinzufuegen(tabbedPane, "Praktikum",
				"	         Informationen zum Praktikum: \n \n Ich war vom 07.03.2016 bis zum 28.03.2016 zum "
						+ "Praktikum bei der Autovision in Wolfsburg.\n Dort war ich im Projekt: production42.\n In p42 gibt es 4 Dev´s "
						+ "und 2 Tester mit denen ich viel zusammen gemacht\n habe.\n Ich wurde dort von Arne Wohlert "
						+ "betreut, der mir viel geholfen und auch\n beigebracht hat.\n Ich habe viel mit dem Team von p42 gemacht, "
						+ "zum Beispiel Meetings und andere wichtige\n Termine.");
		neuenTabErstellenUndHinzufuegen(tabbedPane, "Scrum",
				"		Scrum: \n \nScum ist die Entwicklungsmethode, die p42 in ihrem Projekt benutzt.\n Scrum besteht aus einem \"Sprint\".\n"
						+ "Ein Sprint ist bei p42 ein Zeitabschnitt von 2 Wochen, in denen entwickelt und getestet \n wird.\n Am ersten Freitag im Sprint"
						+ "Refinement und am zweiten Freitag ist Review,\n Retro und wieder Planning.\n Beim Refinement werden die User Storys besprochen\n"
						+ "Es geht darum, dass jeder die Aufgabe versteht, und der Aufwand wird\n geschätzt.\n Bei der Review geht es darum "
						+ "zu gucken, was in dem Sprint gut und was\n schlecht gelaufen ist. Dann wird geguckt was man besser machen kann.\n"
						+ "Bei der Retro stellt jeder grob vor, was er in der Woche gemacht hat.\n Beim Planning wird der folgende Sprint "
						+ "geplant: Welche neuen User Storys\n gibt es, Was müssen wir dort machen, wie groß ist der Aufwand."
						+ "\nWeitere Informationen: http://www.scrum.org/");

		fenster.add(tabbedPane);
		fenster.setVisible(true);
	}

	private void neuenTabErstellenUndHinzufuegen(JTabbedPane tabbedPane, String titel, String text) {

		JTextArea fliesstext = new JTextArea(text);
		fliesstext.setBackground(Color.GREEN);

		tabbedPane.addTab(titel, fliesstext);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setVisible(true);
	}
}
