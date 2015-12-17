package logic;

import java.io.File;
import java.util.ArrayList;

public class Storage {
	
	private static ArrayList<Sprite> spriteArray = new ArrayList<Sprite>();
	
	public static void add(File f){
		String name = f.getName().substring(0, f.getName().lastIndexOf('.'));
		String type = f.getName().substring(f.getName().lastIndexOf('.')+1);
		if ((type.equals("png")) || (type.equals("jpeg"))){
			boolean haveName = false;
			for (int i=0; i<spriteArray.size(); i++){
				if (name.equals(spriteArray.get(i).getName())){
					haveName = true;
					break;
				}
			}
			
			if (!haveName){
				spriteArray.add(new Sprite(f));
			}
		}
	}
	
	public static void loadSprites(File f){
		File[] files = f.listFiles();
		for (int i=0; i<files.length; i++){
			if (files[i].isDirectory()){
				loadSprites(files[i]);
			} else {
				add(files[i]);
			}
		}
	}
	
	//ѕолучение ссылки на спрайт из строки
	public static Sprite getSprite(String name){
		for (int i=0; i<spriteArray.size(); i++){
			if (name.equals(spriteArray.get(i).getName())) return spriteArray.get(i);
		}
		return null;
	}
	
	public static Sprite[] getSprite(){
		Sprite[] sprites = new Sprite[spriteArray.size()];
		for (int i=0; i<spriteArray.size(); i++) 
			sprites[i] = spriteArray.get(i);
		return sprites;
	}
}
