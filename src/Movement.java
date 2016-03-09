import javax.swing.JOptionPane;

public class Movement {
	
	int y;
	int x;
	int TopPassierbar;
	int LeftPassierbar;
	int RightPassierbar;
	int BotPassierbar;
	String Top, Left, Right, Bot, Richtung;
	GelaendeTyp AktuellesGebiet = GelaendeTyp.Start; 
	GelaendeTyp[][] Ort = new GelaendeTyp [20][20];
	
	public void setGebiet(int a, int b)
	{
		AktuellesGebiet = getOrt(a, b);
	}
	
	public GelaendeTyp getGebiet()
	{
		return AktuellesGebiet;
	}
	
	public void setOrt(GelaendeTyp temp2, int a, int b)
	{
		Ort[a][b] = temp2;
		if(temp2==GelaendeTyp.Start){
			x = b;
			y = a;
			System.out.println("START AT "+x+","+y);
		}
			
	}
	
	public void setX(int a){
		x = a;
	}
	public void setY(int a){
		y = a;
	}
	
	public GelaendeTyp getOrt(int a, int b)
	{
		return Ort[a][b];
	}
	public int getPositionX()
	{
		return x;
	}
	public GelaendeTyp getLeft()
	{
		return Ort[getPositionX()][getPositionY()-1];
	}
	public GelaendeTyp getRight()
	{
		return Ort[getPositionX()][getPositionY()+1];
	}
	public GelaendeTyp getZiel(int a, int b)
	{
		return Ort[a][b];
	}
	public GelaendeTyp getBottom()
	{
		return Ort[getPositionX()][getPositionY()+1];
	}
	public int getPositionY()
	{
		return y;
	}
	GelaendeTyp temp = getOrt(getPositionX(),getPositionY());
	
	void gebietBetreten() {
		switch(Richtung) {
		case "Top": geheTop(); break;
		case "Left" : geheLeft(); break;
		case "Right" : geheRight(); break;
		case "Bot" : geheBot(); break;
		}
	}
	
	void geheTop() {
		if (getGebiet()==GelaendeTyp.Weg || getGebiet()== GelaendeTyp.Start || getGebiet() == GelaendeTyp.Ziel) {
			
			switch (getZiel(getPositionY()-1, getPositionX())) {

			case Start: System.out.println("Du befindest dich wieder am Start!"); TopPassierbar = 1; break;
			case Wand: JOptionPane.showMessageDialog(null, "Der Weg wird dir von einer Wand versperrt!"); TopPassierbar = 0; break;
			case Stadt: System.out.println("Du befindest dich in der Stadt!"); TopPassierbar = 1; break;
			case Ziel: JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); System.exit(0); TopPassierbar = 1; break;
			case Wald: System.out.println("Du befindest dich im Wald!"); TopPassierbar = 1; break;
			case Berg: System.out.println("Du befindest dich in den Bergen!"); TopPassierbar = 1; break;
			case Wueste: System.out.println("Du befindest dich in der Wüste!"); TopPassierbar = 1; break;
			case Hoehle: System.out.println("Du befindest dich in einem Verließ!"); TopPassierbar = 1; break;
			case Weg: System.out.println("Du befindest dich auf einem weiterem Weg!"); TopPassierbar = 1; break;
			}
		} else if (getGebiet() != GelaendeTyp.Weg) {
			if (getZiel(getPositionY()-1, getPositionX()).equals(getGebiet()) || getZiel(getPositionY()-1, getPositionX())== GelaendeTyp.Start || getZiel(getPositionY()-1, getPositionX())==GelaendeTyp.Ziel) {
				switch(getZiel(getPositionY()-1, getPositionX())) {
				
				case Start: System.out.println("Du befindest dich immer noch am Start!"); TopPassierbar = 1; break;
				case Stadt: System.out.println("Du befindest dich immer noch in der Stadt!"); TopPassierbar = 1; break;
				case Wald: System.out.println("Du befindest dich immer noch im Wald!"); TopPassierbar = 1; break;
				case Berg: System.out.println("Du befindest dich immer noch in den Bergen!"); TopPassierbar = 1; break;
				case Wueste: System.out.println("Du befindest dich immer noch in der Wüste!"); TopPassierbar = 1; break;
				case Hoehle: System.out.println("Du befindest dich immer noch in einem Verließ!"); TopPassierbar = 1; break;
				case Ziel: JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!");  System.exit(0); TopPassierbar = 1; System.exit(1000);break;
				}
			} else if (getZiel(getPositionY()-1, getPositionX())==GelaendeTyp.Weg || getZiel(getPositionY()-1, getPositionX())==GelaendeTyp.Start || getZiel(getPositionY()-1, getPositionX())==GelaendeTyp.Ziel) {
				System.out.println("Du befindest dich nun wieder auf dem Weg!");
				TopPassierbar = 1;
			} else {
				JOptionPane.showMessageDialog(null,"Du kannst diesen Ort nicht betreten!");
				TopPassierbar = 0;
			}
		}
		
		if(TopPassierbar == 1) {
			y = y - 1;
			AktuellesGebiet = getOrt(getPositionY(), getPositionX());
		}
		System.out.println("TopPassierbar: " + TopPassierbar);
	}
	
	void geheLeft() {
		if (getGebiet()== GelaendeTyp.Weg || getGebiet()==GelaendeTyp.Start || getGebiet()== GelaendeTyp.Ziel) {
			
			switch (getZiel(getPositionY(), getPositionX()-1)) {

			case Start: System.out.println("Du befindest dich wieder am Start!"); LeftPassierbar = 1; break;
			case Wand: JOptionPane.showMessageDialog(null, "Der Weg wird dir von einer Wand versperrt!"); LeftPassierbar = 0; break;
			case Stadt: System.out.println("Du befindest dich in der Stadt!"); LeftPassierbar = 1; break;
			case Ziel: JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); System.exit(0); LeftPassierbar = 1; break;
			case Wald: System.out.println("Du befindest dich im Wald!"); LeftPassierbar = 1; break;
			case Berg: System.out.println("Du befindest dich in den Bergen!"); LeftPassierbar = 1; break;
			case Wueste: System.out.println("Du befindest dich in der Wüste!"); LeftPassierbar = 1; break;
			case Hoehle: System.out.println("Du befindest dich in einem Verließ!"); LeftPassierbar = 1; break;
			case Weg: System.out.println("Du befindest dich auf einem weiterem Weg!"); LeftPassierbar = 1; break;
			}
		} else if (getGebiet() != GelaendeTyp.Weg) {
			if (getZiel(getPositionY(), getPositionX()-1).equals(getGebiet()) || getZiel(getPositionY(), getPositionX()-1)==GelaendeTyp.Start || getZiel(getPositionY(), getPositionX()-1)==GelaendeTyp.Ziel) {
				switch(getZiel(getPositionY(), getPositionX()-1)) {
				
				case Start: System.out.println("Du befindest dich immer noch am Start!"); LeftPassierbar = 1; break;
				case Stadt: System.out.println("Du befindest dich immer noch in der Stadt!"); LeftPassierbar = 1; break;
				case Wald: System.out.println("Du befindest dich immer noch im Wald!"); LeftPassierbar = 1; break;
				case Berg: System.out.println("Du befindest dich immer noch in den Bergen!"); LeftPassierbar = 1; break;
				case Wueste: System.out.println("Du befindest dich immer noch in der Wüste!"); LeftPassierbar = 1; break;
				case Hoehle: System.out.println("Du befindest dich immer noch in einem Verließ!"); LeftPassierbar = 1; break;
				case Ziel: JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); System.exit(0); TopPassierbar = 1; System.exit(1000);break;
				}
			} else if (getZiel(getPositionY(), getPositionX()-1)==GelaendeTyp.Weg || getZiel(getPositionY(), getPositionX()-1)==GelaendeTyp.Start || getZiel(getPositionY(), getPositionX()-1)==GelaendeTyp.Ziel) {
				System.out.println("Du befindest dich nun wieder auf dem Weg!");
				LeftPassierbar = 1;
			} else {
				JOptionPane.showMessageDialog(null,"Du kannst diesen Ort nicht betreten!");
				LeftPassierbar = 0;
			}
		}
		
		if(LeftPassierbar == 1) {
			x = x - 1;
			AktuellesGebiet = getOrt(getPositionY(), getPositionX());
		}
		System.out.println("LeftPassierbar: " + LeftPassierbar);
	}
	
	void geheRight() {
		if (getGebiet()==GelaendeTyp.Weg || getGebiet()==GelaendeTyp.Start || getGebiet()==GelaendeTyp.Ziel) {
			
			switch (getZiel(getPositionY(), getPositionX()+1)) {

			case Start: System.out.println("Du befindest dich wieder am Start!"); RightPassierbar = 1; break;
			case Wand: JOptionPane.showMessageDialog(null, "Der Weg wird dir von einer Wand versperrt!"); RightPassierbar = 0; break;
			case Stadt: System.out.println("Du befindest dich in der Stadt!"); RightPassierbar = 1; break;
			case Ziel: JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); System.exit(0); RightPassierbar = 1; break;
			case Wald: System.out.println("Du befindest dich im Wald!"); RightPassierbar = 1; break;
			case Berg: System.out.println("Du befindest dich in den Bergen!"); RightPassierbar = 1; break;
			case Wueste: System.out.println("Du befindest dich in der Wüste!"); RightPassierbar = 1; break;
			case Hoehle: System.out.println("Du befindest dich in einem Verließ!"); RightPassierbar = 1; break;
			case Weg: System.out.println("Du befindest dich auf einem weiterem Weg!"); RightPassierbar = 1; break;
			}
		} else if (getGebiet() != GelaendeTyp.Weg) {
			if (getZiel(getPositionY(), getPositionX()+1).equals(getGebiet()) || getZiel(getPositionY(), getPositionX()+1)==GelaendeTyp.Start || getZiel(getPositionY(), getPositionX()+1)==GelaendeTyp.Ziel) {
				switch(getZiel(getPositionY(), getPositionX()+1)) {
				
				case Start: System.out.println("Du befindest dich immer noch am Start!"); RightPassierbar = 1; break;
				case Stadt: System.out.println("Du befindest dich immer noch in der Stadt!"); RightPassierbar = 1; break;
				case Wald: System.out.println("Du befindest dich immer noch im Wald!"); RightPassierbar = 1; break;
				case Berg: System.out.println("Du befindest dich immer noch in den Bergen!"); RightPassierbar = 1; break;
				case Wueste: System.out.println("Du befindest dich immer noch in der Wüste!"); RightPassierbar = 1; break;
				case Hoehle: System.out.println("Du befindest dich immer noch in einem Verließ!"); RightPassierbar = 1; break;
				case Ziel: JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); System.exit(0); TopPassierbar = 1; System.exit(1000);break;
				}
			} else if (getZiel(getPositionY(), getPositionX()+1)== GelaendeTyp.Weg || getZiel(getPositionY()-1, getPositionX())== GelaendeTyp.Start || getZiel(getPositionY()-1, getPositionX())==GelaendeTyp.Ziel) {
				System.out.println("Du befindest dich nun wieder auf dem Weg!");
				RightPassierbar = 1;
			} else {
				JOptionPane.showMessageDialog(null,"Du kannst diesen Ort nicht betreten!");
				RightPassierbar = 0;
			}
		}
		
		if(RightPassierbar == 1) {
			x = x + 1;
			AktuellesGebiet = getOrt(getPositionY(), getPositionX());
		}
		System.out.println("RightPassierbar: " + RightPassierbar);
	}
	
	void geheBot() {
		if (getGebiet()==GelaendeTyp.Weg || getGebiet()==GelaendeTyp.Start || getGebiet()==GelaendeTyp.Ziel) {
			
			switch (getZiel(getPositionY()+1, getPositionX())) {

			case Start: System.out.println("Du befindest dich wieder am Start!"); BotPassierbar = 1; break;
			case Wand: JOptionPane.showMessageDialog(null, "Der Weg wird dir von einer Wand versperrt!"); BotPassierbar = 0; break;
			case Stadt: System.out.println("Du befindest dich in der Stadt!"); BotPassierbar = 1; break;
			case Ziel: JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); System.exit(0); BotPassierbar = 1; break;
			case Wald: System.out.println("Du befindest dich im Wald!"); BotPassierbar = 1; break;
			case Berg: System.out.println("Du befindest dich in den Bergen!"); BotPassierbar = 1; break;
			case Wueste: System.out.println("Du befindest dich in der Wüste!"); BotPassierbar = 1; break;
			case Hoehle: System.out.println("Du befindest dich in einem Verließ!"); BotPassierbar = 1; break;
			case Weg: System.out.println("Du befindest dich auf einem weiterem Weg!"); BotPassierbar = 1; break;
			}
		} else if (getGebiet() != GelaendeTyp.Weg) {
			if (getZiel(getPositionY()+1, getPositionX()).equals(getGebiet()) || getZiel(getPositionY()+1, getPositionX())==GelaendeTyp.Start || getZiel(getPositionY()+1, getPositionX())==GelaendeTyp.Ziel) {
				switch(getZiel(getPositionY()+1, getPositionX())) {
				
				case Start: System.out.println("Du befindest dich immer noch am Start!"); BotPassierbar = 1; break;
				case Stadt: System.out.println("Du befindest dich immer noch in der Stadt!"); BotPassierbar = 1; break;
				case Wald: System.out.println("Du befindest dich immer noch im Wald!"); BotPassierbar = 1; break;
				case Berg: System.out.println("Du befindest dich immer noch in den Bergen!"); BotPassierbar = 1; break;
				case Wueste: System.out.println("Du befindest dich immer noch in der Wüste!"); BotPassierbar = 1; break;
				case Hoehle: System.out.println("Du befindest dich immer noch in einem Verließ!"); BotPassierbar = 1; break;
				case Ziel: JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); System.exit(0); TopPassierbar = 1; System.exit(1000);break;
				}
			} else if (getZiel(getPositionY()+1, getPositionX())==GelaendeTyp.Weg || getZiel(getPositionY()-1, getPositionX())==GelaendeTyp.Start || getZiel(getPositionY()-1, getPositionX())==GelaendeTyp.Ziel) {
				System.out.println("Du befindest dich nun wieder auf dem Weg!");
				BotPassierbar = 1;
			} else {
				JOptionPane.showMessageDialog(null,"Du kannst diesen Ort nicht betreten!");
				BotPassierbar = 0;
			}
		}
		
		if(BotPassierbar == 1) {
			y = y + 1;
			AktuellesGebiet = getOrt(getPositionY(), getPositionX());
		}
		System.out.println("BotPassierbar: " + BotPassierbar);
	}
}



