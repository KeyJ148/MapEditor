package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import logic.Map;
import logic.Sprite;

public class PanelMap extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Map map;
	
	private int maxWidth = -1;
	private int maxHeight = -1;
	private int mapPosX = 0;//Позиция правого верхнего угла карты
	private int mapPosY = 0;//относительно угла панели

	
	@Override
	public void paintComponent(Graphics g){
		if ((maxWidth == -1) || (maxHeight == -1)){
			maxWidth = getWidth();
			maxHeight = getHeight();
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		
		
		//Если выбрана определённая карта
		if (map != null){
			
			//заливка фона
			Sprite background = map.getBackground();
			if (background != null){
				Image back = background.getImage();
				int size = background.getWidth();//Размер плитки с фоном
				for (int dy = 0; dy<=map.getHeight(); dy+=size){
					for (int dx = 0; dx<=map.getWidth(); dx+=size){
						g.drawImage(back,dx,dy,null);
					}
				}
			}
			
			//Отрисовка объектов	
			for (int i=0; i<map.getCount(); i++){
				map.getSprite(i).draw((Graphics2D) g, map.getX(i), map.getY(i), map.getDirection(i));
			}
		}
	}
	
	public void setMap(Map map){
		this.map = map;
	}
	
	public Map getMap(){
		return map;
	}
}
