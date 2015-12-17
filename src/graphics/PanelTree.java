package graphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import logic.Sprite;

public class PanelTree extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PanelTree(){
		setPreferredSize(new Dimension(130, getHeight()));
		setLayout(new FlowLayout(FlowLayout.LEADING, 1, 1));
	}
	
	public void addSprite(Sprite sprite){
		add(new SpriteButton(sprite));
	}
	
	public void addSprite(Sprite[] sprite){
		for (int i=0; i<sprite.length; i++)
			addSprite(sprite[i]);
	}
	
	@Override
	public void paint(Graphics g){
		Component[] components = getComponents();
		for (int i=0; i<components.length; i++)
			components[i].repaint();
	}
}
