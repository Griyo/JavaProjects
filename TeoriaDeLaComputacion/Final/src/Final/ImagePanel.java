package Final;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private BufferedImage imagen;
	
	
	public ImagePanel(){		
	
		try {
			imagen =  ImageIO.read(Panel.class.getResource("/img/fondo.jpg"));				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, e);
		}		
	}
	public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		 g.drawImage(imagen,0,0,900,600,null);		 
		
    }
}
