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
    private String name;
    
    public Sprite(File f) {
    	name = f.getName();
		//Загрузка изображения
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
    
    public String getName(){
    	return name;
    }
    
    public void draw(Graphics2D g, int x, int y, double direction) {
    	direction = Math.toRadians(direction);
    	direction-=Math.PI/2; //смещена начального угла с Востока на Север
		AffineTransform at = new AffineTransform(); 
		at.rotate(-direction,x+getWidth()/2,y+getHeight()/2); //Создание трансформа с поворотом
        g.setTransform(at); //для поворота спрайта на direction
        g.drawImage(image, x, y, null);//для отрисовки спрайта нужен верхний левый угол
    }
    
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);//для отрисовки спрайта нужен верхний левый угол
    }
}
