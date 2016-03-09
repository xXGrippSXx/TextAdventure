import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Vorgeschichte {

	public void anzeigen(){
		File myFile = new File("Vorgeschichte.txt");
		if(myFile.exists())
		{
			try
			{
				FileReader fR = new FileReader(myFile);
				BufferedReader bR = new BufferedReader(fR);
				String zeile = null;
				while ((zeile = bR.readLine()) !=  null)
					{
					JOptionPane.showMessageDialog(null, zeile, "Vorgeschichte", JOptionPane.INFORMATION_MESSAGE);
					}
				bR.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else
		{
			System.out.println("Vorgeschichte nicht gefunden!");
		}
	}
	
}

//GEILO//
