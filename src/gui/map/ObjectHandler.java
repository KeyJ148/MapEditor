package gui.map;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import gui.FrameMain;
import logic.Map;
import logic.Obj;
import logic.Sprite;

public class ObjectHandler implements MouseListener, MouseWheelListener {

    private PanelMap panelMap;
    private double direction = 90;//Угол, с которым будет установлен объект
    private static final double DIRECTION_UP = (double) 360/16;//На сколько градусов поворачивать за один скролл

    public ObjectHandler(PanelMap panelMap){
        this.panelMap = panelMap;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Map map = panelMap.getMap();
        int absoluteX = e.getX()-panelMap.getCamera().getCameraX();
        int absoluteY = e.getY()-panelMap.getCamera().getCameraY();

        if (e.getModifiers() == InputEvent.BUTTON1_MASK){
            addObject(map, absoluteX, absoluteY);
        }

        if (e.getModifiers() == InputEvent.BUTTON3_MASK){
            removeObject(map, absoluteX, absoluteY);
        }
    }

    private void addObject(Map map, int absoluteX, int absoluteY){
        Sprite spriteSelect;
        if (FrameMain.getInstance().getPanelMain().getPanelTree().isSelect()){
            spriteSelect = FrameMain.getInstance().getPanelMain().getPanelTree().getSpriteSelect();
        } else{
            System.out.println("Object not selected");
            return;
        }

        if (absoluteX < map.getWidth() && absoluteY < map.getHeight()){
            Grid grid = panelMap.getGrid();
            if (grid.getActive()){
                map.add(grid.getObjX(absoluteX), grid.getObjY(absoluteY), direction, spriteSelect);
            } else {
                map.add(absoluteX, absoluteY, direction, spriteSelect);
            }
            panelMap.repaint();
        }
    }

    private void removeObject(Map map, int absoluteX, int absoluteY){
        if (map == null){
            System.out.println("Map not selected");
            return;
        }

        for (int i=map.getCount()-1; i>=0; i--){//Обратный цикл для того чтобы вначале удалялись объекты расположенные сверху
            Obj obj = map.getObj(i);
            if ((absoluteX >= obj.x-obj.sprite.getWidth()/2) &&
                    (absoluteY >= obj.y-obj.sprite.getHeight()/2) &&
                    (absoluteX <= obj.x+obj.sprite.getWidth()/2) &&
                    (absoluteY <= obj.y+obj.sprite.getHeight()/2)){

                map.remove(i);
                panelMap.repaint();
                break;
            }
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        direction += DIRECTION_UP*(-notches);//notches<0  => Скролл вверх, иначе вниз
        panelMap.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public double getDirection(){
        return direction;
    }

}
