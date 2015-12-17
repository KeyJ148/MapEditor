package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logic.Map;
import logic.Storage;

public class MenuBarMain extends JMenuBar implements ActionListener{

	private static final long serialVersionUID = 1L;
	private FrameMain frameMain;
	private JMenu menuFile, menuSettings;
	private JMenuItem itemFileOpen, itemFileSave, itemFileSaveAs;
	private JMenuItem itemSettingsLoadSprite;
	
	public MenuBarMain(FrameMain frameMain){
		this.frameMain = frameMain;
		
		//Файлы
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
		
		itemFileSaveAs = new JMenuItem("Save as", new ImageIcon("image/save_as.png"));
		itemFileSaveAs.addActionListener(this);
		menuFile.add(itemFileSaveAs);
		
		//Настройки
		menuSettings = new JMenu("Settings");
		add(menuSettings);
		
		itemSettingsLoadSprite = new JMenuItem("Load sprites", new ImageIcon("image/load_sprite.png"));
		itemSettingsLoadSprite.addActionListener(this);
		itemSettingsLoadSprite.setMnemonic(KeyEvent.VK_S);
		menuSettings.add(itemSettingsLoadSprite);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(itemFileOpen)) actionFileOpen();
		if (e.getSource().equals(itemFileSave)) actionFileSave();
		if (e.getSource().equals(itemFileSaveAs)) actionFileSaveAs();
		if (e.getSource().equals(itemSettingsLoadSprite)) actionSettingsLoadSprite();
	}
	
	public void actionFileOpen(){
		JFileChooser fileOpen = new JFileChooser();
		fileOpen.setCurrentDirectory(new File("."));
		if (fileOpen.showOpenDialog(frameMain) == JFileChooser.APPROVE_OPTION){
			File file = fileOpen.getSelectedFile();
			new Map(file);
		}
	}
	
	private void actionFileSave(){
		
	}
	
	private void actionFileSaveAs(){
		JFileChooser fileSaveAs = new JFileChooser();
		fileSaveAs.setCurrentDirectory(new File("."));
		if (fileSaveAs.showSaveDialog(frameMain) == JFileChooser.APPROVE_OPTION){
			File file = fileSaveAs.getSelectedFile();
		}
	}
	
	private void actionSettingsLoadSprite(){
		JFileChooser fileOpen = new JFileChooser();
		fileOpen.setCurrentDirectory(new File("."));
		fileOpen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileOpen.showOpenDialog(frameMain) == JFileChooser.APPROVE_OPTION){
			File file = fileOpen.getSelectedFile();
			Storage.loadSprites(file);
			frameMain.getPanelMain().getPanelTree().addSprite(Storage.getSprite());
			frameMain.getPanelMain().getPanelTree().repaint();
		}
	}

}
