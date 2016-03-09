import java.awt.Component;
import java.awt.GridLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WeltKarte extends JFrame {
	
	private Movement m;
	public WeltKarte(Movement m) {	
		this.m = m;	
		
		setLayout(new GridLayout(m.Ort.length,m.Ort[0].length));
		for(int i = 0;i < m.Ort[0].length;i++){
			for(int j = 0;j < m.Ort.length;j++){
				add(createIcon(m.Ort[i][j]));
			}
		}
		
	}
	private Component createIcon(GelaendeTyp gelaendeTyp) {
		
//		try {
//			BufferedImage myPicture = ImageIO.read(new File("Desert.png"));
//			int w = myPicture.getWidth();
//			int h = myPicture.getHeight();
//			BufferedImage after = new BufferedImage (w, h, BufferedImage.TYPE_INT_ARGB);
//			AffineTransform at = new AffineTransform();
//			at.scale(0.2, 0.2);
//			AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//			after = scaleOp.filter(myPicture, after);
//			JLabel label = new JLabel(new ImageIcon(after));
//			return label;
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
		JLabel label = new JLabel(gelaendeTyp.name());
		label.setBackground(Farben.getByGelaendeTyp(gelaendeTyp));
		label.setOpaque(true);
		return label;
		
		
	}
	
	
	
	
	
	
}
