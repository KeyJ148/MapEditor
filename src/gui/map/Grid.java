package gui.map;

public class Grid {

	private PanelMap panelMap;
	
	private boolean active = false;
	private int indentWidth = 0;
	private int indentHeight = 0;
	
	private int width = 40;
	private int height = 40;
	
	public Grid(PanelMap panelMap){
		this.panelMap = panelMap;
	}
	
	public int getObjX(int x){
		return indentWidth+(x/getWidth())*getWidth() + getWidth()/2;
	}
	
	public int getObjY(int y){
		return indentHeight+(y/getHeight())*getHeight() + getHeight()/2;
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
		panelMap.repaint();
	}
	
	public void setIndent(int indentWidth, int indentHeight){
		this.indentWidth = indentWidth;
		this.indentHeight = indentHeight;
		panelMap.repaint();
	}
	
	public void turn(){
		active = !active;
		panelMap.repaint();
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getIndentWidth(){
		return indentWidth;
	}
	
	public int getIndentHeight(){
		return indentHeight;
	}
	
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
		panelMap.repaint();
	}

}
