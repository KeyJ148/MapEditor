package logic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite{
	
    private Image image;
    private String path;
    
    public Sprite(File f) {
    	path = f.getName();

		BufferedImage sourceImage = null;
        try {
			sourceImage = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
       
		this.image = Toolkit.getDefaultToolkit().createImage(sourceImage.getSource());
    }
    
    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }
    
    public Image getImage(){
    	return image;
	}
    
    public String getPath(){
    	return path;
    }
    
    public String getName(){
    	return getPath().substring(0, getPath().lastIndexOf('.'));
    }
    
    public void draw(Graphics2D g, int x, int y, double direction) {
    	direction = Math.toRadians(direction);
    	direction -= Math.PI/2;
    	
		AffineTransform at = new AffineTransform(); 
		at.rotate(-direction,x,y);
		g.setTransform(at);
		
        g.drawImage(image, x-getWidth()/2, y-getHeight()/2, null);
        g.setTransform(new AffineTransform());
    }
    
    public void draw(Graphics g, int x, int y) {
    	g.drawImage(image, x-getWidth()/2, y-getHeight()/2, null);
    }
}
