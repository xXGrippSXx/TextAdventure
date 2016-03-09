import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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


@SuppressWarnings("serial")
public class Hauptmenu extends JFrame implements ActionListener{

	private static final int CODE_JAN = 53481744;
	private static final int CODE_STI = 49435234;
	private static final int CODE_STC = 49435233;
	private static final int CODE_KUEHN = 9258369;
	private static final String code = "codeEingeben";
	private static final String code2 = "codeEingeben2";
	static Movement m;
	public JPanel p;
	public JButton start;
	public JButton credi;
	public JButton ende;
	public JButton laden;
	public JButton musik;
	static boolean music = true;
	public String[] Codes ={"21543","15946","44568","15357","54545"};
		
	public Hauptmenu(Movement m1) {
		super(" Menu ");
		m = m1;
		p = new JPanel();
		start = new JButton("Spiel Starten");
		laden = new JButton("Spiel Laden");
		credi = new JButton("Credits");
		musik = new JButton("Einstellungen");
		ende  = new JButton("Spiel Beenden");
		start.setBounds(120, 40,  160, 40);
		laden.setBounds(120, 120, 160, 40);
		credi.setBounds(120, 200, 160, 40);
		musik.setBounds(120, 280, 160, 40);
		ende .setBounds(120, 360, 160, 40);
		start.addActionListener(this);
		credi.addActionListener(this);
		ende .addActionListener(this);
		laden.addActionListener(this);
		musik.addActionListener(this);
		p.setLayout(null);
		p.add(start);
		p.add(laden);
		p.add(credi);
		p.add(musik);
		p.add(ende);
		setContentPane(p);
		createMenu(this);
	}
	
	public static void main(String[] args) throws Exception {
//		new Spiel(-5, music, ".\\musik",".\\MapSTCSTI.txt");
		Hauptmenu f = new Hauptmenu(m);
		f.setSize(400, 480);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	public JMenuBar createMenu(Hauptmenu f){
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
		menuItem.setActionCommand(code);
		menuItem.addActionListener(this);
		p.add(menuItem);
		menu.add(menuItem);
		
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("Schwer");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		rbMenuItem = new JRadioButtonMenuItem("Mittel");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		rbMenuItem = new JRadioButtonMenuItem("Leicht");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("Musik AN/AUS");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		cbMenuItem.setActionCommand(code2);
		cbMenuItem.addActionListener(this);
		p.add(cbMenuItem);
		menu.add(cbMenuItem);
		f.setJMenuBar(menuBar);
		return menuBar;
	}	
	//test
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start){
			try {
				new Vorgeschichte().anzeigen();
                @SuppressWarnings("unused")
				Spiel spiel = new Spiel(0, music, ".\\musik",".\\SAVE.txt");
				this.setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERROR while Loading... \nPlease Try again later, or send an email to\ninfo.javaprograms@gmail.com");}
		}

		if(e.getSource() == laden){
			String inputDialog = JOptionPane.showInputDialog("Geben Sie einen Level - Code ein", "1234567890");
			if(inputDialog == null){
				return;
			}
			int code = Integer.parseInt(inputDialog);
			if(code == 9258369){//CODE KUEHN
				try {
					new Spiel(100, music, ".\\musik",".\\SAVE.txt");
					this.setVisible(false);
				} catch (Exception e1) {}
			}
			if(code == 49435233){//CODE STC
				try {
					new Spiel(10, music, ".\\musik3",".\\MapSTCSTI.txt");
					this.setVisible(false);
				} catch (Exception e1) {}
			}
			if(code == 49435234){//CODE STI 
				try {
					new Spiel(10, music, ".\\musik4",".\\MapSTCSTI.txt");
					this.setVisible(false);
				} catch (Exception e1) {}
			}
			if(code == 53481744){//CODE JAN
				try {
					new Spiel(10, music, ".\\musik2",".\\SAVE.txt");
					this.setVisible(false);
				} catch (Exception e1) {}
			}else{
				if(laden(code)){
					try {
						new Spiel(0, music, ".\\musik",".\\SAVE.txt");
						this.setVisible(false);
					} catch (Exception e1){}
				}
			}
		}
		
		
		
		
		if(e.getSource() == credi){
			JOptionPane.showMessageDialog(null,"TextAdventure\nEin Spiel der ProgrammierAG des Alstergymnasiums H.-U.\nMegakrasse Musik ausgewählt von Jan Stegemann\nMultikontroverse Matrizen von David Kowalk\nMassive Maps von Tim Wolf und Jonas Matenia\nPerfekte Programmierung von Jonas Kühn\nLustiges Layout von Kevin Altenburg\nIdeale Idee von Hr. & Fr. Stichel", "CREDITS",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == musik){
			int goon = JOptionPane.showConfirmDialog(null, "Wollen Sie Musik?", "Einstellungen", JOptionPane.YES_NO_OPTION);
			if(goon == JOptionPane.YES_OPTION){
				music = true;
			}
			if(goon == JOptionPane.NO_OPTION){
				music = false;
			}
		}
		if(e.getSource() == ende){
			int a = JOptionPane.showConfirmDialog(null, "Wollen sie das Spiel wirklich beenden?", "BEENDEN", JOptionPane.YES_NO_OPTION);
			if(a == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Schade... \nBis zum naechsten mal!\nTSCHUESS!!");
				System.exit(0);
			}
			if(a == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "Super! Dann auf ins Abenteuer!");
			}
		}
		if(e.getActionCommand().equals(code)){
			String inputDialog = JOptionPane.showInputDialog("Geben Sie einen Level - Code ein", "1234567890");
			if(inputDialog == null){
				return;
			}
			int code = Integer.parseInt(inputDialog);
			if(code == CODE_KUEHN){
				try {
					new Spiel(100, music, ".\\musik",".\\SAVE.txt");
					this.setVisible(false);
				} catch (Exception e1) {}
			}
			if(code == CODE_STC){
				try {
					new Spiel(10, music, ".\\musik3",".\\MapSTCSTI.txt");
					this.setVisible(false);
				} catch (Exception e1) {}
			}
			if(code == CODE_STI){
				try {
					new Spiel(10, music, ".\\musik4",".\\MapSTCSTI.txt");
					this.setVisible(false);
				} catch (Exception e1) {}
			}
			if(code == CODE_JAN){
				try {
					new Spiel(10, music, ".\\musik2",".\\SAVE.txt");
					this.setVisible(false);
				} catch (Exception e1) {}
			}else{
				if(laden(code)){
					try {
						new Spiel(0, music, ".\\musik",".\\SAVE.txt");
						this.setVisible(false);
					} catch (Exception e1){}
				}
			}
			
		}
		if(e.getActionCommand().equals(code2)){
			
		
			JCheckBoxMenuItem checkBox = (JCheckBoxMenuItem)e.getSource(); 
			music = checkBox.isSelected();
		}
	}

	private boolean laden(int NR) {
		boolean b = false;
		for(int i = 0; i < Codes.length; i++)
		if(NR == Integer.parseInt(Codes[i])){
			b = true;
		}
		return b;
		
	}
	
}
