package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarMain extends JMenuBar implements ActionListener{

	private static final long serialVersionUID = 1L;
	private FrameMain frameMain;
	private JMenu menuFile;
	private JMenuItem itemFileOpen, itemFileSave, itemFileSaveAs;
	
	public MenuBarMain(FrameMain frameMain){
		this.frameMain = frameMain;
		
		menuFile = new JMenu("File");
		add(menuFile);
		
		itemFileOpen = new JMenuItem("Open", new ImageIcon("image/open.png"));
		itemFileOpen.addActionListener(this);
		itemFileOpen.setMnemonic(KeyEvent.VK_O);
		menuFile.add(itemFileOpen);
		
		itemFileSave = new JMenuItem("Save", new ImageIcon("image/save.png"));
		itemFileSave.addActionListener(this);
		itemFileSave.setMnemonic(KeyEvent.VK_S);
		menuFile.add(itemFileSave);
		
		itemFileSaveAs = new JMenuItem("Save as", new ImageIcon("image/saveas.png"));
		itemFileSaveAs.addActionListener(this);
		menuFile.add(itemFileSaveAs);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(itemFileOpen)) actionFileOpen();
		if (e.getSource().equals(itemFileSave)) actionFileSave();
		if (e.getSource().equals(itemFileSaveAs)) actionFileSaveAs();
	}
	
	public void actionFileOpen(){
		JFileChooser fileOpen = new JFileChooser();
		fileOpen.setCurrentDirectory(new File("."));
		if (fileOpen.showOpenDialog(frameMain) == JFileChooser.APPROVE_OPTION){
			File file = fileOpen.getSelectedFile();
		}
	}
	
	public void actionFileSave(){
		
	}
	
	public void actionFileSaveAs(){
		JFileChooser fileSaveAs = new JFileChooser();
		fileSaveAs.setCurrentDirectory(new File("."));
		if (fileSaveAs.showSaveDialog(frameMain) == JFileChooser.APPROVE_OPTION){
			File file = fileSaveAs.getSelectedFile();
		}
	}

}
