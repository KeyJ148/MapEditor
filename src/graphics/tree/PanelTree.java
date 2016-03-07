package graphics.tree;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import logic.Sprite;

public class PanelTree extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int SPRITE_SIZE = 64;
	private static final int SPRITE_SPACE = 1;
	private static final int SPRITE_IN_LINE = 2;
	
	public PanelTree(){
		setPreferredSize(new Dimension(SPRITE_SIZE*SPRITE_IN_LINE+SPRITE_SPACE*2, getHeight()));
		setLayout(new FlowLayout(FlowLayout.LEADING, SPRITE_SPACE, SPRITE_SPACE));
	}
	
	public void addSprite(Sprite sprite){
		add(new SpriteButton(sprite, SPRITE_SIZE));
		setPreferredSize(new Dimension(getWidth(), getComponentCount()*(SPRITE_SIZE+SPRITE_SPACE)/SPRITE_IN_LINE));
		revalidate();//Что бы кнопка сразу же отрисовывалась
	}
	
	public void addSprite(Sprite[] sprite){
		for (int i=0; i<sprite.length; i++)
			addSprite(sprite[i]);
	}
}
