package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {
	
	private int width;
	private int height;
	
	private Sprite backgroundSprite;
	
	private ArrayList<Integer> xArray = new ArrayList<Integer>();
	private ArrayList<Integer> yArray = new ArrayList<Integer>();
	private ArrayList<Double> directionArray = new ArrayList<Double>();
	private ArrayList<Sprite> spriteArray = new ArrayList<Sprite>();
	
	public Map(File f){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			String[] words = reader.readLine().split(" ");
			width = Integer.parseInt(words[1]);
			height = Integer.parseInt(words[2]);
			backgroundSprite = Storage.getSprite(words[3]);
			
			while (true){ 
				String s = reader.readLine();
				if (s == null){
					break;
				}
				words = s.split(" ");
				add(Integer.parseInt(words[0]), Integer.parseInt(words[1]), Double.parseDouble(words[2]), Storage.getSprite(words[0]));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] File not found");
		} catch (IOException e) {
			System.out.println("[ERROR] IO exception");
		} 
	}
	
	public void add(int x, int y, double direction, Sprite sprite){
		xArray.add(x);
		yArray.add(y);
		directionArray.add(direction);
		spriteArray.add(sprite);
	}
	
	public int getX(int index){
		return xArray.get(index);
	}
	
	public int getY(int index){
		return yArray.get(index);
	}
	
	public double getDirection(int index){
		return directionArray.get(index);
	}
	
	public Sprite getSprite(int index){
		return spriteArray.get(index);
	}
	
	public void delete(int index){
		xArray.remove(index);
		yArray.remove(index);
		directionArray.remove(index);
		spriteArray.remove(index);
	}
}
