package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.FrameMain;
import logic.Map;
import logic.Storage;

public class MenuBarMain extends JMenuBar implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JMenu menuFile, menuSettings;
    private JMenuItem itemFileCreate, itemFileOpen, itemFileSave, itemFileSaveAs;
    private JMenuItem itemSettingsLoadSprite, itemSettingsSetBackground, itemSettingsGrid;

    public MenuBarMain(){

        menuFile = new JMenu("File");
        add(menuFile);

        itemFileCreate = new JMenuItem("Create", new ImageIcon("image/create.png"));
        itemFileCreate.addActionListener(this);
        itemFileCreate.setMnemonic(KeyEvent.VK_N);
        menuFile.add(itemFileCreate);

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


        menuSettings = new JMenu("Settings");
        add(menuSettings);

        itemSettingsLoadSprite = new JMenuItem("Load sprites", new ImageIcon("image/load_sprite.png"));
        itemSettingsLoadSprite.addActionListener(this);
        itemSettingsLoadSprite.setMnemonic(KeyEvent.VK_L);
        menuSettings.add(itemSettingsLoadSprite);

        itemSettingsSetBackground = new JMenuItem("Set background", new ImageIcon("image/set_background.png"));
        itemSettingsSetBackground.addActionListener(this);
        itemSettingsSetBackground.setMnemonic(KeyEvent.VK_B);
        menuSettings.add(itemSettingsSetBackground);

        itemSettingsGrid = new JMenuItem("Grid", new ImageIcon("image/grid.png"));
        itemSettingsGrid.addActionListener(this);
        itemSettingsGrid.setMnemonic(KeyEvent.VK_G);
        menuSettings.add(itemSettingsGrid);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(itemFileCreate)) actionFileCreate();
        if (e.getSource().equals(itemFileOpen)) actionFileOpen();
        if (e.getSource().equals(itemFileSave)) actionFileSave();
        if (e.getSource().equals(itemFileSaveAs)) actionFileSaveAs();
        if (e.getSource().equals(itemSettingsLoadSprite)) actionSettingsLoadSprite();
        if (e.getSource().equals(itemSettingsSetBackground)) actionSettingsSetBackground();
        if (e.getSource().equals(itemSettingsGrid)) actionSettingsGrid();
    }


    public void actionFileCreate(){
        new DialogCreate(FrameMain.getInstance());
    }

    public void actionFileOpen(){
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setCurrentDirectory(new File("."));
        if (fileOpen.showOpenDialog(FrameMain.getInstance()) == JFileChooser.APPROVE_OPTION){
            File file = fileOpen.getSelectedFile();
            new Map(file);
        }
    }

    private void actionFileSave(){//�� ��������
        FrameMain.getInstance().getPanelMain().getPanelMap().getMap().save();
    }

    private void actionFileSaveAs(){
        JFileChooser fileSaveAs = new JFileChooser();
        fileSaveAs.setCurrentDirectory(new File("."));
        if (fileSaveAs.showSaveDialog(FrameMain.getInstance()) == JFileChooser.APPROVE_OPTION){
            FrameMain.getInstance().getPanelMain().getPanelMap().getMap().save(fileSaveAs.getSelectedFile());
        }
    }


    private void actionSettingsLoadSprite(){
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setCurrentDirectory(new File("."));
        fileOpen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileOpen.showOpenDialog(FrameMain.getInstance()) == JFileChooser.APPROVE_OPTION){
            File file = fileOpen.getSelectedFile();
            Storage.loadSprites(file);
            FrameMain.getInstance().getPanelMain().getPanelTree().addSprite(Storage.getSprite());
        }
    }

    private void actionSettingsSetBackground(){
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setCurrentDirectory(new File("."));
        if (fileOpen.showOpenDialog(FrameMain.getInstance()) == JFileChooser.APPROVE_OPTION){
            File file = fileOpen.getSelectedFile();
            if (FrameMain.getInstance().getPanelMain().getPanelMap().getMap() != null){
                FrameMain.getInstance().getPanelMain().getPanelMap().getMap().setBackground(file);
                FrameMain.getInstance().getPanelMain().getPanelMap().repaint();
            }
        }
    }

    private void actionSettingsGrid(){
        new DialogGrid(FrameMain.getInstance());
    }

}
