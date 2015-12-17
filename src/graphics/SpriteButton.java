package graphics;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

import logic.Sprite;

public class SpriteButton extends JButton{

	private static final long serialVersionUID = 1L;
	private Sprite sprite;
	
	public SpriteButton(Sprite sprite){
		this.sprite = sprite;
		setPreferredSize(new Dimension(64, 64));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		sprite.draw(g, 0, 0);
	}
	
}
