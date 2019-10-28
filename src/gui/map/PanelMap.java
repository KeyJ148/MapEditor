package gui.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import logic.Map;

public class PanelMap extends JPanel{

    private static final long serialVersionUID = 1L;

    private Map map;
    private Camera camera;
    private ObjectHandler objHandler;
    private Grid grid;

    public PanelMap(){
        camera = new Camera(this);
        addMouseMotionListener(camera);

        objHandler = new ObjectHandler(this);
        addMouseListener(objHandler);
        addMouseWheelListener(objHandler);

        grid = new Grid(this);
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

        g2D.setColor(new Color(122, 138, 153));
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

    public ObjectHandler getObjHandler(){
        return objHandler;
    }

    public Camera getCamera(){
        return camera;
    }

    public Grid getGrid(){
        return grid;
    }
}
