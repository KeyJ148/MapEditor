package graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import logic.Sprite;

public class SpriteButton extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Sprite sprite;
	
	public SpriteButton(Sprite sprite, int size){
		this.sprite = sprite;
		setPreferredSize(new Dimension(size, size));
		setIcon(new ImageIcon(sprite.getImage()));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Click on " + sprite.getName());
	}
	
}
