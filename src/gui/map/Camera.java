package gui.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import gui.FrameMain;
import logic.Map;
import logic.Obj;
import logic.Sprite;

public class Camera implements MouseMotionListener{

    private PanelMap panelMap;

    private int mouseXPre, mouseYPre;
    private int cameraX, cameraY;

    public Camera(PanelMap panelMap){
        this.panelMap = panelMap;
        cameraX = 0;
        cameraY = 0;
    }

    public void paintMap(Graphics2D g2D, Map map){
        Sprite background = map.getBackground();
        if (background != null){
            int size = background.getWidth();
            for (int dy = 0; dy<=map.getHeight(); dy+=size){
                for (int dx = 0; dx<=map.getWidth(); dx+=size){
                    background.draw(g2D, cameraX+dx, cameraY+dy, 90);
                }
            }
        }


        for (int i=0; i<map.getCount(); i++){
            Obj obj = map.getObj(i);
            obj.sprite.draw(g2D, cameraX+obj.x, cameraY+obj.y, obj.direction);
        }

        if (panelMap.getGrid().getActive()){
            g2D.setColor(Color.BLACK);
            for (int i=0; i<map.getWidth(); i+=panelMap.getGrid().getWidth()){
                g2D.drawLine(cameraX+i, cameraY, cameraX+i, cameraY+map.getHeight());
            }
            for (int i=0; i<map.getHeight(); i+=panelMap.getGrid().getHeight()){
                g2D.drawLine(cameraX, cameraY+i, cameraX+map.getWidth(), cameraY+i);

            }
        }

        if (FrameMain.getInstance().getPanelMain().getPanelTree().isSelect()){
            Sprite spriteSelect = FrameMain.getInstance().getPanelMain().getPanelTree().getSpriteSelect();
            spriteSelect.draw(g2D, getMouseX(), getMouseY(), panelMap.getObjHandler().getDirection());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (e.getModifiers() == InputEvent.BUTTON2_MASK){
            cameraX = cameraX+(mouseX-mouseXPre);
            cameraY = cameraY+(mouseY-mouseYPre);
            if (cameraX > 0) cameraX = 0;
            if (cameraY > 0) cameraY = 0;

            mouseXPre = mouseX;
            mouseYPre = mouseY;
        }

        panelMap.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseXPre = e.getX();
        mouseYPre = e.getY();

        panelMap.repaint();
    }

    public int getCameraX(){
        return cameraX;
    }

    public int getCameraY(){
        return cameraY;
    }

    public int getMouseX(){
        return mouseXPre;
    }

    public int getMouseY(){
        return mouseYPre;
    }
}
