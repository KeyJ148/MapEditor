package logic;

import gui.FrameMain;

import java.io.File;

public class MapEditor {

    public static void main(String[] args) {
        FrameMain.getInstance();

        Storage.loadSprites(new File("./res/image/"));
        FrameMain.getInstance().getPanelMain().getPanelTree().addSprite(Storage.getSprite());
    }

}
