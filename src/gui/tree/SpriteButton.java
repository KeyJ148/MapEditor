package gui.tree;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import logic.Sprite;

public class SpriteButton extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Sprite sprite;
	private PanelTree panelTree;
	
	public SpriteButton(Sprite sprite, int size, PanelTree panelTree){
		this.sprite = sprite;
		this.panelTree = panelTree;
		setPreferredSize(new Dimension(size, size));
		setIcon(new ImageIcon(sprite.getImage()));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panelTree.setSpriteSelect(this);
	}
	
	public Sprite getSprite(){
		return sprite;
	}
}
