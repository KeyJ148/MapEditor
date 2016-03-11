package gui.map;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.FrameMain;
import logic.Map;
import logic.Sprite;

public class ObjectHandler implements MouseListener {
	
	private PanelMap panelMap;
	
	public ObjectHandler(PanelMap panelMap){
		this.panelMap = panelMap;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Map map = panelMap.getMap();
		int absoluteX = e.getX()-panelMap.getCamera().getCameraX();
		int absoluteY = e.getY()-panelMap.getCamera().getCameraY();
		
		if (e.getModifiers() == InputEvent.BUTTON1_MASK){
			Sprite spriteSelect = FrameMain.getInstance().getPanelMain().getPanelTree().getSpriteSelect();
			if (spriteSelect == null){
				System.out.println("Object not selected");
				return;
			}
			
			if (absoluteX < map.getWidth() && absoluteY < map.getHeight()){
				map.add(absoluteX, absoluteY, 90, spriteSelect);
				panelMap.repaint();
			}
		}
		
		if (e.getModifiers() == InputEvent.BUTTON3_MASK){
			for (int i=0; i<map.getCount(); i++){
				if ((absoluteX >= map.getX(i)) &&
					(absoluteY >= map.getY(i)) &&
					(absoluteX <= map.getX(i)+map.getSprite(i).getWidth()) &&
					(absoluteY <= map.getY(i)+map.getSprite(i).getHeight())){
					
					map.remove(i);
					panelMap.repaint();
					break;
				}
			}
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
