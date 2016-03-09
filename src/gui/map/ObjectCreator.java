package gui.map;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.FrameMain;
import logic.Map;
import logic.Sprite;

public class ObjectCreator implements MouseListener {
	
	private PanelMap panelMap;
	
	public ObjectCreator(PanelMap panelMap){
		this.panelMap = panelMap;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try{
			Sprite spriteSelect = FrameMain.getInstance().getPanelMain().getPanelTree().getSpriteSelect();
			Map map = panelMap.getMap();
			int absoluteX = e.getX()-panelMap.getCamera().getCameraX();
			int absoluteY = e.getY()-panelMap.getCamera().getCameraY();
			if (absoluteX < map.getWidth() && absoluteY < map.getHeight()){
				map.add(absoluteX, absoluteY, 90, spriteSelect);
				panelMap.repaint();
			}
		} catch (NullPointerException ne){
			System.err.println("Object not selected!");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
