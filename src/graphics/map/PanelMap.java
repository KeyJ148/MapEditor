package graphics.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import logic.Map;

public class PanelMap extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private Map map;
	private Camera camera;
	
	public PanelMap(){
		camera = new Camera(this);
		addMouseMotionListener(camera);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(new Color(238, 238, 238));
		g2D.fillRect(1, 1, getWidth()-2, getHeight()-2);
		
		
		if (map != null){
			setSizeToSizeMap();
			camera.paintMap(g2D, map);
		}
		
		g2D.setColor(Color.BLACK);
		g2D.drawRect(0, 0, getWidth()-1, getHeight()-1);
	}
	
	public void setSizeToSizeMap(){
		setSize(map.getWidth(), map.getHeight());
	}
	
	public void setMap(Map map){
		this.map = map;
		setSizeToSizeMap();
		repaint();
	}
	
	public Map getMap(){
		return map;
	}
}
