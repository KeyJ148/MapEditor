package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import gui.FrameMain;

public class Map {
	
	private int width;
	private int height;
	
	private Sprite backgroundSprite;
	
	private ArrayList<Obj> array = new ArrayList<Obj>();
	
	private File dataFile;//Файл, из которого открыли карту
	
	public Map(File f){
		try {
			dataFile = f;
			
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String[] words = reader.readLine().split(" ");
			width = Integer.parseInt(words[0]);
			height = Integer.parseInt(words[1]);
			backgroundSprite = Storage.getSprite(words[2]+".png");
			
			while (true){ 
				String s = reader.readLine();
				if (s == null){
					break;
				}
				words = s.split(" ");
				add(Integer.parseInt(words[0]), Integer.parseInt(words[1]), Double.parseDouble(words[2]), Storage.getSprite(words[3]));
			}
			reader.close();
			setThisAsMap();
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] File not found");
		} catch (IOException e) {
			System.out.println("[ERROR] IO exception");
		} catch (NullPointerException e){
			System.out.println("[ERROR] Sprite not found");
		}
	}
	
	public Map(int width, int height){
		setSize(width, height);
		setThisAsMap();
	}
	
	private void setThisAsMap(){
		FrameMain.getInstance().getPanelMain().getPanelMap().setMap(this);
	}
	
	public void save(){
		save(dataFile);
	}
	
	public void save(File f){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write(width + " " + height + " " + backgroundSprite.getName());
			writer.newLine();
			for (int i=0; i<getCount(); i++){
				Obj obj = getObj(i);
				writer.write(obj.x + " " + obj.y + " " + obj.direction + " " + obj.sprite.getName());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("[ERROR] IO exception");
		}
	}
	
	public void add(int x, int y, double direction, Sprite sprite){
		array.add(new Obj(x, y, direction, sprite));
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void setBackground(File f){
		String name = f.getName();
		if (Storage.getSprite(name) == null){
			Storage.add(f);
		}
		setBackground(Storage.getSprite(name));
	}
	
	public void setBackground(Sprite background){
		this.backgroundSprite = background;
	}
	
	public Sprite getBackground(){
		return backgroundSprite;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getCount(){
		return array.size();
	}
	
	public Obj getObj(int index){
		return array.get(index);
	}
	
	public void remove(int index){
		array.remove(index);
	}
}
