package core;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelMain extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelMain(){
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
	}
}
