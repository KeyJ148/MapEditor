package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import gui.menu.MenuBarMain;

public class FrameMain extends JFrame{

	private static final long serialVersionUID = 1L;
	private static FrameMain instance = null;
	private static final String FRAME_NAME = "MapEditor";
	private PanelMain panelMain;
	
	private FrameMain(){
		super(FRAME_NAME);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
		int displayWidth = displaySize.width;
		int displayHeight = displaySize.height;
		int frameWidth = displayWidth/2;
		int frameHeight = displayHeight/2;
		setBounds(displayWidth/2-frameWidth/2, displayHeight/2-frameHeight/2, frameWidth, frameHeight);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		panelMain = new PanelMain();
		add(panelMain, BorderLayout.CENTER);
		
		setJMenuBar(new MenuBarMain());
		
		setVisible(true);
	}
	
	public PanelMain getPanelMain(){
		return panelMain;
	}
	
	public static FrameMain getInstance(){
		if (instance == null) instance = new FrameMain();
		return instance;
	}
	
}
