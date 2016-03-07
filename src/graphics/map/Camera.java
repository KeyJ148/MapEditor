package graphics.map;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import logic.Map;
import logic.Sprite;

public class Camera implements MouseMotionListener {

	private PanelMap panelMap;
	
	private int mouseXPre, mouseYPre;//Позиция мыши в предыдущей итерации (Для Drag)
	private int cameraX, cameraY;//Позиция левого верхнего угла видимой области на оси PanelMap
	
	public Camera(PanelMap panelMap){
		this.panelMap = panelMap;
		cameraX = 0;
		cameraY = 0;
	}
	
	public void paintMap(Graphics2D g2D, Map map){
		//заливка фона
		Sprite background = map.getBackground();
		if (background != null){
			int size = background.getWidth();//Размер плитки с фоном
			for (int dy = 0; dy<=map.getHeight(); dy+=size){
				for (int dx = 0; dx<=map.getWidth(); dx+=size){
					background.draw(g2D, cameraX+dx, cameraY+dy, 90);
				}
			}
		}
			
		//Отрисовка объектов	
		for (int i=0; i<map.getCount(); i++){
			map.getSprite(i).draw(g2D, cameraX+map.getX(i), cameraY+map.getY(i), map.getDirection(i));
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		cameraX = cameraX+(mouseX-mouseXPre);
		cameraY = cameraY+(mouseY-mouseYPre);
		if (cameraX > 0) cameraX = 0;
		if (cameraY > 0) cameraY = 0;
			
		mouseXPre = mouseX;
		mouseYPre = mouseY;
		
		panelMap.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseXPre = e.getX();
		mouseYPre = e.getY();
	}
}
