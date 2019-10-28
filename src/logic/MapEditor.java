package logic;

import gui.FrameMain;

import java.io.File;

public class MapEditor {

    public static void main(String[] args) {
        FrameMain.getInstance();
        MapEditor.loadDefaultSprites();
    }

    public static void loadDefaultSprites(){
        File f = new File("./res/image/");
        if (f.exists()){
            Storage.loadSprites(f);
            FrameMain.getInstance().getPanelMain().getPanelTree().addSprite(Storage.getSprite());
        }
    }

}
