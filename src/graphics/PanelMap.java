package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelMap extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int maxWidth = -1;
	private int maxHeight = -1;
	private int mapPosX = 0;//Позиция правого верхнего угла карты
	private int mapPosY = 0;//относительно угла панели

	@Override
	public void paintComponent(Graphics g){
		if ((maxWidth == -1) || (maxHeight == -1)){
			this.maxWidth = getWidth();
			this.maxHeight = getHeight();
		}
		
		setBounds(-20, -20, maxWidth-20, maxHeight-20);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//заливка фона
		/*
		Image back = Global.background.getImage();
		int dxf,dyf;
		int size = Global.backgroundSize;//Размер плитки с фоном
		for (int dy = 0; dy<=Global.heightMap; dy+=size){
			for (int dx = 0; dx<=Global.widthMap; dx+=size){
				dxf = (int) Math.round(Global.cameraXView - (Global.cameraX - dx));
				dyf = (int) Math.round(Global.cameraYView - (Global.cameraY - dy));
				g.drawImage(back,dxf,dyf,null);
			}
		}
		
		//Сортировка массивов по глубине объектов в них
		
		for (int i=0; i<Global.depth.size(); i++){
			for (int j=0; j<Global.depth.size()-1; j++){
				DepthVector dv1 = (DepthVector) Global.depth.get(j);
				DepthVector dv2 = (DepthVector) Global.depth.get(j+1);
				if (dv1.depth < dv2.depth){
					Global.depth.set(j, dv2);
					Global.depth.set(j+1, dv1);
				}
			}
		}
		
		//Отрисовка объектов	
		for (int i=0; i<Global.depth.size(); i++){
			DepthVector dv = (DepthVector) Global.depth.get(i);
			for (int j=0; j<dv.number.size(); j++){
				ObjLight obj = (ObjLight) Global.getObj((long) dv.number.get(j));
				obj.draw(g);
				
			}
		}
		*/
	}
}
